/*
 * Copyright 2010 Nabeel Mukhtar 
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); 
 * you may not use this file except in compliance with the License. 
 * You may obtain a copy of the License at 
 * 
 *  http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. 
 * See the License for the specific language governing permissions and
 * limitations under the License. 
 * 
 */
package com.googleapis.ajax.services.example;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

import org.apache.commons.cli.BasicParser;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.OptionBuilder;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import com.googleapis.ajax.schema.Language;
import com.googleapis.ajax.schema.TranslateLanguageResult;
import com.googleapis.ajax.services.GoogleSearchQueryFactory;
import com.googleapis.ajax.services.TranslateLanguageQuery;

/**
 * The Class TranslationSample.
 */
public class ResourceBundleGenerator {

    /** The Constant APPLICATION_KEY_OPTION. */
    private static final String APPLICATION_KEY_OPTION = "appid";
	
    /** The Constant QUERY_OPTION. */
    private static final String RESOURCE_OPTION = "resource";
	
    /** The Constant QUERY_OPTION. */
    private static final String LANGUAGES_OPTION = "languages";
    
    /** The Constant HELP_OPTION. */
    private static final String HELP_OPTION = "help";
    
    /**
     * The main method.
     * 
     * @param args the arguments
     */
	public static void main(String[] args) {
		Options options = buildOptions();
        try {
            CommandLine line = new BasicParser().parse(options, args);
            processCommandLine(line, options);
        } catch(ParseException exp ) {
            System.err.println(exp.getMessage());
            printHelp(options);
        }
	}
    
	/**
	 * Process command line.
	 * 
	 * @param line the line
	 * @param options the options
	 */
    @SuppressWarnings("unchecked")
	private static void processCommandLine(CommandLine line, Options options) {
        if(line.hasOption(HELP_OPTION)) {
            printHelp(options);            
        } else if(line.hasOption(APPLICATION_KEY_OPTION) && line.hasOption(RESOURCE_OPTION)) {
    		GoogleSearchQueryFactory factory = GoogleSearchQueryFactory.newInstance(line.getOptionValue(APPLICATION_KEY_OPTION));
    		Properties resourceMessages = loadResourceMessages(line.getOptionValue(RESOURCE_OPTION));
    		List<String> propertyNames = (List<String>) Collections.list(resourceMessages.propertyNames());
        	List<Language> targetLanguages = getTargetLanguages(line.getOptionValue(LANGUAGES_OPTION));
        	
        	for (Language language : targetLanguages) {
        		Properties translatedResources = new Properties();
        		TranslateLanguageQuery translateQuery = factory.newTranslateLanguageQuery();
        		translateQuery.withLanguagePair(Language.ENGLISH, language);
        		
        		for (String name : propertyNames) {        		
        			translateQuery.withQuery(resourceMessages.getProperty(name));
        		}
        		List<TranslateLanguageResult> result = translateQuery.list();
        		if (result.size() == propertyNames.size()) {
        			int index = 0;
            		for (String name : propertyNames) {        		
            			translatedResources.setProperty(name, result.get(index++).getTranslatedText());
            		}
        		}
        		saveResourceMessages(translatedResources, line.getOptionValue(RESOURCE_OPTION), language);
			}
        } else {
        	printHelp(options);
        }
	}

	private static void saveResourceMessages(Properties translatedResources,
			String fileName, Language language) {
		FileOutputStream os = null;
		try {
			os = new FileOutputStream(fileName + "_" + language.value() + ".properties");
			translatedResources.store(os, "Resources for " + language);
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (os != null) {
				try {
					os.close();
				} catch (Exception e) {}				
			}
		}
	}

	private static Properties loadResourceMessages(String fileName) {
		FileInputStream is = null;
		Properties resourceMessages = new Properties();
		try {
			is = new FileInputStream(fileName + ".properties");
			resourceMessages.load(is);
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (Exception e) {}				
			}
		}
		return resourceMessages;
	}

	private static List<Language> getTargetLanguages(String optionValue) {
		List<Language> targetLanguages = new ArrayList<Language>();
		if (optionValue != null) {
			String[] langs = optionValue.split(",");
			for (String value : langs) {
				Language language = Language.fromValue(value);
				if (language != null) {
					targetLanguages.add(language);
				}
			}
		} else {
			for (Language language : Language.values()) {
				if (language.supportsTranslation()) {
					targetLanguages.add(language);
				}
			}
		}
		return targetLanguages;
	}

	/**
	 * Builds the options.
	 * 
	 * @return the options
	 */
    private static Options buildOptions() {
       
        Options opts = new Options();
        
        String helpMsg = "Print this message.";
        Option help = new Option(HELP_OPTION, helpMsg);
        opts.addOption(help);

        String applicationKeyMsg = "You Application ID.";
        OptionBuilder.withArgName("appid");
        OptionBuilder.hasArg();
        OptionBuilder.withDescription(applicationKeyMsg);
        Option applicationKey = OptionBuilder.create(APPLICATION_KEY_OPTION);
        opts.addOption(applicationKey);
        
        String resourceMsg = "Path to the default resource bundle (without .properties).";
        OptionBuilder.withArgName("resource");
        OptionBuilder.hasArg();
        OptionBuilder.withDescription(resourceMsg);
        Option resource = OptionBuilder.create(RESOURCE_OPTION);
        opts.addOption(resource);
        
        String languagesMsg = "Comma separated list of languages. e.g. de,fr,es";
        OptionBuilder.withArgName("languages");
        OptionBuilder.hasArg();
        OptionBuilder.withDescription(languagesMsg);
        Option languages = OptionBuilder.create(LANGUAGES_OPTION);
        opts.addOption(languages);
        
        return opts;
    }
    
    /**
     * Prints the help.
     * 
     * @param options the options
     */
    private static void printHelp(Options options) {
        int width = 80;
        String syntax = ResourceBundleGenerator.class.getName() + " <options>";
        String header = MessageFormat.format("\nThe -{0} and -{1} options are required. All others are optional.", APPLICATION_KEY_OPTION, RESOURCE_OPTION);
        new HelpFormatter().printHelp(width, syntax, header, options, null, false);
    }
}
