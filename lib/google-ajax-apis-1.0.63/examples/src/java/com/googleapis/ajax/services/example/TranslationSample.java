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

import java.text.MessageFormat;

import org.apache.commons.cli.BasicParser;
import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.OptionBuilder;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import com.googleapis.ajax.common.PagedList;
import com.googleapis.ajax.schema.DetectLanguageResult;
import com.googleapis.ajax.schema.Language;
import com.googleapis.ajax.schema.TranslateLanguageResult;
import com.googleapis.ajax.schema.TransliterateLanguageResult;
import com.googleapis.ajax.services.DetectLanguageQuery;
import com.googleapis.ajax.services.GoogleSearchQueryFactory;
import com.googleapis.ajax.services.TranslateLanguageQuery;
import com.googleapis.ajax.services.TransliterateLanguageQuery;

/**
 * The Class TranslationSample.
 */
public class TranslationSample {

    /** The Constant APPLICATION_KEY_OPTION. */
    private static final String APPLICATION_KEY_OPTION = "appid";
	
    /** The Constant QUERY_OPTION. */
    private static final String QUERY_OPTION = "query";
	
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
    private static void processCommandLine(CommandLine line, Options options) {
        if(line.hasOption(HELP_OPTION)) {
            printHelp(options);            
        } else if(line.hasOption(APPLICATION_KEY_OPTION) && line.hasOption(QUERY_OPTION)) {
    		GoogleSearchQueryFactory factory = GoogleSearchQueryFactory.newInstance(line.getOptionValue(APPLICATION_KEY_OPTION));
    		DetectLanguageQuery detectQuery = factory.newDetectLanguageQuery();
    		DetectLanguageResult detectResponse = detectQuery.withQuery(line.getOptionValue(QUERY_OPTION)).singleResult();
    		printResponse(detectResponse);
    		TranslateLanguageQuery translateQuery = factory.newTranslateLanguageQuery();
    		PagedList<TranslateLanguageResult> translateResponse = translateQuery.withLanguagePair(null, Language.GERMAN).withLanguagePair(null, Language.FRENCH).withQuery(line.getOptionValue(QUERY_OPTION)).list();
    		printResponse(translateResponse);
    		TransliterateLanguageQuery transliterateQuery = factory.newTransliterateLanguageQuery();
    		PagedList<TransliterateLanguageResult> transliterateResponse = transliterateQuery.withLanguagePair(Language.ENGLISH, Language.URDU).withQuery(line.getOptionValue(QUERY_OPTION)).list();
    		for (TransliterateLanguageResult result : transliterateResponse) {
    			printResponse(result);
    		}
        } else {
        	printHelp(options);
        }
	}

	/**
	 * Prints the response.
	 * 
	 * @param transliterateResponse the transliterate response
	 */
	private static void printResponse(TransliterateLanguageResult transliterateResponse) {
		System.out.println(transliterateResponse.getSourceWord() + ":" + transliterateResponse.getTransliteratedWords());
	}

	/**
	 * Prints the response.
	 * 
	 * @param response the response
	 */
	private static void printResponse(PagedList<TranslateLanguageResult> response) {
		for (TranslateLanguageResult result : response) {
			printResponse(result);
		}
	}

	/**
	 * Prints the response.
	 * 
	 * @param detectResponse the detect response
	 */
	private static void printResponse(DetectLanguageResult detectResponse) {
		System.out.println(detectResponse.getLanguage());
		System.out.println(detectResponse.getConfidence());
		System.out.println(detectResponse.isReliable());
	}

	/**
	 * Prints the response.
	 * 
	 * @param response the response
	 */
	private static void printResponse(TranslateLanguageResult response) {
		System.out.println(response.getDetectedSourceLanguage());			
		System.out.println(response.getTranslatedText());			
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
        
        String queryMsg = "Search Query.";
        OptionBuilder.withArgName("query");
        OptionBuilder.hasArg();
        OptionBuilder.withDescription(queryMsg);
        Option query = OptionBuilder.create(QUERY_OPTION);
        opts.addOption(query);
        
        return opts;
    }
    
    /**
     * Prints the help.
     * 
     * @param options the options
     */
    private static void printHelp(Options options) {
        int width = 80;
        String syntax = TranslationSample.class.getName() + " <options>";
        String header = MessageFormat.format("\nThe -{0} and -{1} options are required. All others are optional.", APPLICATION_KEY_OPTION, QUERY_OPTION);
        new HelpFormatter().printHelp(width, syntax, header, options, null, false);
    }
}
