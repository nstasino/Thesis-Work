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
package com.googleapis.ajax.services.constant;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.googleapis.ajax.common.ValueEnum;

/**
 * The Class GoogleSearchApiUrls.
 */
public final class GoogleSearchApiUrls {

    /** The Constant API_URLS_FILE. */
    public static final String API_URLS_FILE = "GoogleSearchApiUrls.properties";

    /** The Constant LOG. */
    private static final Logger LOG = Logger.getLogger(GoogleSearchApiUrls.class.getCanonicalName());
    
    /** The Constant googleApiUrls. */
    private static final Properties googleApiUrls = new Properties();

    static {
        try {
            googleApiUrls.load(GoogleSearchApiUrls.class.getResourceAsStream(API_URLS_FILE));
        } catch (IOException e) {
        	LOG.log(Level.SEVERE, "An error occurred while loading urls.", e);
        }
    }

    /** The Constant SEARCH_WEB_URL. */
    public static final String SEARCH_WEB_URL =
        googleApiUrls.getProperty("com.googleapis.ajax.services.search.web");
    
    /** The Constant SEARCH_LOCAL_URL. */
    public static final String SEARCH_LOCAL_URL =
        googleApiUrls.getProperty("com.googleapis.ajax.services.search.local");
    
    /** The Constant SEARCH_VIDEO_URL. */
    public static final String SEARCH_VIDEO_URL =
        googleApiUrls.getProperty("com.googleapis.ajax.services.search.video");
    
    /** The Constant SEARCH_BLOG_URL. */
    public static final String SEARCH_BLOG_URL =
        googleApiUrls.getProperty("com.googleapis.ajax.services.search.blog");
    
    /** The Constant SEARCH_NEWS_URL. */
    public static final String SEARCH_NEWS_URL =
        googleApiUrls.getProperty("com.googleapis.ajax.services.search.new");
    
    /** The Constant SEARCH_BOOK_URL. */
    public static final String SEARCH_BOOK_URL =
        googleApiUrls.getProperty("com.googleapis.ajax.services.search.book");
    
    /** The Constant SEARCH_IMAGE_URL. */
    public static final String SEARCH_IMAGE_URL =
        googleApiUrls.getProperty("com.googleapis.ajax.services.search.image");
    
    /** The Constant SEARCH_PATENT_URL. */
    public static final String SEARCH_PATENT_URL =
        googleApiUrls.getProperty("com.googleapis.ajax.services.search.patent");
    
    /** The Constant LANGUAGE_TRANSLATE_URL. */
    public static final String LANGUAGE_TRANSLATE_URL =
        googleApiUrls.getProperty("com.googleapis.ajax.services.language.translate");
    
    /** The Constant LANGUAGE_TRANSLITERATE_URL. */
    public static final String LANGUAGE_TRANSLITERATE_URL =
        googleApiUrls.getProperty("com.googleapis.ajax.services.language.transliterate");
    
    /** The Constant LANGUAGE_DETECT_URL. */
    public static final String LANGUAGE_DETECT_URL =
        googleApiUrls.getProperty("com.googleapis.ajax.services.language.detect");
    
    /** The Constant FEED_LOAD_URL. */
    public static final String FEED_LOAD_URL =
        googleApiUrls.getProperty("com.googleapis.ajax.services.feed.load");

    /** The Constant FEED_FIND_URL. */
    public static final String FEED_FIND_URL =
        googleApiUrls.getProperty("com.googleapis.ajax.services.feed.find");

    /** The Constant FEED_LOOKUP_URL. */
    public static final String FEED_LOOKUP_URL =
        googleApiUrls.getProperty("com.googleapis.ajax.services.feed.lookup");
    
    /**
     * Instantiates a new google search api urls.
     */
    private GoogleSearchApiUrls() {}

    /**
     * The Class GoogleSearchApiUrlBuilder.
     */
    public static class GoogleSearchApiUrlBuilder {
        
        /** The Constant API_URLS_PLACEHOLDER_START. */
        private static final char API_URLS_PLACEHOLDER_START = '{';

        /** The Constant API_URLS_PLACEHOLDER_END. */
        private static final char API_URLS_PLACEHOLDER_END = '}';
        
        /** The Constant QUERY_PARAMETERS_PLACEHOLDER. */
        private static final String QUERY_PARAMETERS_PLACEHOLDER = "queryParameters";
    	
    	/** The url format. */
	    private String urlFormat;
	    
    	/** The parameters map. */
	    private Map<String, Collection<String>> parametersMap = new HashMap<String, Collection<String>>();
    	
    	/**
	     * Instantiates a new google search api url builder.
	     * 
	     * @param urlFormat the url format
	     */
	    public GoogleSearchApiUrlBuilder(String urlFormat) {
	    	this(urlFormat, ApplicationConstants.DEFAULT_API_VERSION);
    	}
    	
    	/**
	     * Instantiates a new google search api url builder.
	     * 
	     * @param urlFormat the url format
	     * @param apiVersion the api version
	     */
	    public GoogleSearchApiUrlBuilder(String urlFormat, String apiVersion) {
    		this.urlFormat = urlFormat;
    		parametersMap.put(ParameterNames.VERSION, Collections.singleton(encodeUrl(apiVersion)));
    	}
	    
    	/**
	     * With parameter.
	     * 
	     * @param name the name
	     * @param value the value
	     * 
	     * @return the google search api url builder
	     */
	    public GoogleSearchApiUrlBuilder withParameter(String name, String value) {
	    	if (value != null && value.length() > 0) {
	    		Collection<String> values = parametersMap.get(name);
	    		if (values == null) {
	    			values = new ArrayList<String>();
		    		parametersMap.put(name, values);
	    		}
	    		values.add(encodeUrl(value));
	    	}
    		
    		return this;
    	}
    	
    	/**
	     * With parameter.
	     * 
	     * @param name the name
	     * @param value the value
	     * 
	     * @return the google search api url builder
	     */
	    public GoogleSearchApiUrlBuilder withParameterSuffix(String name, String suffix) {
	    	if (suffix != null && suffix.length() > 0) {
	    		Collection<String> values = parametersMap.get(name);
	    		if (values != null) {
	    			List<String> updatedValues = new ArrayList<String>(values.size());
	    			for (String value : values) {
	    				updatedValues.add(encodeUrl(suffix) + value);	    				
	    			}
		    		parametersMap.put(name, updatedValues);
	    		}
	    	}
    		
    		return this;
    	}
	    
    	/**
	     * With parameters.
	     * 
	     * @param name the name
	     * @param values the values
	     * 
	     * @return the google search api url builder
	     */
	    public GoogleSearchApiUrlBuilder withParameters(String name, Collection<String> values) {
	    	List<String> encodedValues = new ArrayList<String>(values.size());
	    	for (String value : values) {
	    		encodedValues.add(encodeUrl(value));
	    	}
    		parametersMap.put(name, encodedValues);
    		
    		return this;
    	}
    	
    	/**
	     * With parameter enum set.
	     * 
	     * @param name the name
	     * @param enumSet the enum set
	     * 
	     * @return the google search api url builder
	     */
	    public GoogleSearchApiUrlBuilder withParameterEnumSet(String name, Set<? extends ValueEnum> enumSet) {
	    	Set<String> values = new HashSet<String>(enumSet.size());
	    	
	    	for (ValueEnum fieldEnum : enumSet) {
	    		values.add(encodeUrl(fieldEnum.value()));
	    	}
	    	
    		parametersMap.put(name, values);
    		
    		return this;
    	}
	    
    	/**
	     * With parameter enum.
	     * 
	     * @param name the name
	     * @param value the value
	     * 
	     * @return the google search api url builder
	     */
	    public GoogleSearchApiUrlBuilder withParameterEnum(String name, ValueEnum value) {
	    	withParameter(name, value.value());
    		
    		return this;
    	}
    	
    	/**
	     * With parameter enum map.
	     * 
	     * @param enumMap the enum map
	     * 
	     * @return the google search api url builder
	     */
	    public GoogleSearchApiUrlBuilder withParameterEnumMap(Map<? extends ValueEnum, String> enumMap) {
	    	for (ValueEnum parameter : enumMap.keySet()) {
	    		withParameter(parameter.value(), enumMap.get(parameter));
	    	}
    		
    		return this;
    	}
	    
    	/**
	     * Builds the url.
	     * 
	     * @return the string
	     */
		public String buildUrl() {
        	StringBuilder urlBuilder = new StringBuilder();
        	StringBuilder placeHolderBuilder = new StringBuilder();
        	boolean placeHolderFlag = false;
        	for (int i = 0; i < urlFormat.length(); i++) {
        		if (urlFormat.charAt(i) == API_URLS_PLACEHOLDER_START) {
        			placeHolderBuilder = new StringBuilder();
        			placeHolderFlag = true;
        		} else if (placeHolderFlag && urlFormat.charAt(i) == API_URLS_PLACEHOLDER_END) {
        			String placeHolder = placeHolderBuilder.toString();
        			if (QUERY_PARAMETERS_PLACEHOLDER.equals(placeHolder)) {
    			    	StringBuilder builder = new StringBuilder();
    			    	if (!parametersMap.isEmpty()) {
    			    		Iterator<String> iter = parametersMap.keySet().iterator();
    			    		while (iter.hasNext()) {
    			    			String name = iter.next();
			    				Collection<String> parameterValues = parametersMap.get(name);
			    				Iterator<String> iterParam = parameterValues.iterator();
			    				while (iterParam.hasNext()) {
    			    				builder.append(name);
    			    				builder.append("=");
    			    				builder.append(iterParam.next());
    			    				if (iterParam.hasNext()) {
        			    				builder.append("&");
    			    				}
			    				}
    			    			if (iter.hasNext()) {
    			    				builder.append("&");
    			    			}
    			    		}
    			    	}
    			    	urlBuilder.append(builder.toString());
        			} else {
        				// we did not find a binding for the placeholder.
        				// append it as it is.
        				urlBuilder.append(API_URLS_PLACEHOLDER_START);
        				urlBuilder.append(placeHolder);
        				urlBuilder.append(API_URLS_PLACEHOLDER_END);
        			}
        			placeHolderFlag = false;
        		} else if (placeHolderFlag) {
        			placeHolderBuilder.append(urlFormat.charAt(i));
        		} else {
        			urlBuilder.append(urlFormat.charAt(i));
        		}
        	}

        	return urlBuilder.toString();
    	}
    	
        /**
         * Encode url.
         * 
         * @param original the original
         * 
         * @return the string
         */
        private static String encodeUrl(String original) {
        	try {
    			return URLEncoder.encode(original, ApplicationConstants.CONTENT_ENCODING);
    		} catch (UnsupportedEncodingException e) {
    			// should never be here..
    			return original;
    		}
        }
    }
}
