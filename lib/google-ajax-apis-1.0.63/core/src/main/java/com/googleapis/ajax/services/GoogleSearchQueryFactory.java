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
package com.googleapis.ajax.services;

import com.googleapis.ajax.services.impl.BlogSearchQueryImpl;
import com.googleapis.ajax.services.impl.BookSearchQueryImpl;
import com.googleapis.ajax.services.impl.DetectLanguageQueryImpl;
import com.googleapis.ajax.services.impl.FindFeedQueryImpl;
import com.googleapis.ajax.services.impl.ImageSearchQueryImpl;
import com.googleapis.ajax.services.impl.LoadFeedQueryImpl;
import com.googleapis.ajax.services.impl.LocalSearchQueryImpl;
import com.googleapis.ajax.services.impl.LookupFeedQueryImpl;
import com.googleapis.ajax.services.impl.NewsSearchQueryImpl;
import com.googleapis.ajax.services.impl.PatentSearchQueryImpl;
import com.googleapis.ajax.services.impl.TranslateLanguageQueryImpl;
import com.googleapis.ajax.services.impl.TransliterateLanguageQueryImpl;
import com.googleapis.ajax.services.impl.VideoSearchQueryImpl;
import com.googleapis.ajax.services.impl.WebSearchQueryImpl;



/**
 * A factory for creating GoogleSearchQuery objects.
 */
public class GoogleSearchQueryFactory {

    /** The application key. */
    private String applicationKey;

    /**
     * Instantiates a new google search query factory.
     * 
     * @param applicationKey the application key
     */
	private GoogleSearchQueryFactory(String applicationKey) {
        this.applicationKey = applicationKey;
    }
	
    /**
     * New instance.
     * 
     * @param applicationKey the application key
     * 
     * @return the google search query factory
     */
    public static GoogleSearchQueryFactory newInstance(String applicationKey) {
        return new GoogleSearchQueryFactory(applicationKey);
    }
    
    /**
     * New blog search query.
     * 
     * @return the blog search query
     */
    public BlogSearchQuery newBlogSearchQuery() {
    	return new BlogSearchQueryImpl(applicationKey);
    }
    
    /**
     * New book search query.
     * 
     * @return the book search query
     */
    public BookSearchQuery newBookSearchQuery() {
    	return new BookSearchQueryImpl(applicationKey);
    }
    
    /**
     * New image search query.
     * 
     * @return the image search query
     */
    public ImageSearchQuery newImageSearchQuery() {
    	return new ImageSearchQueryImpl(applicationKey);
    }
    
    /**
     * New local search query.
     * 
     * @return the local search query
     */
    public LocalSearchQuery newLocalSearchQuery() {
    	return new LocalSearchQueryImpl(applicationKey);
    }

    /**
     * New news search query.
     * 
     * @return the news search query
     */
    public NewsSearchQuery newNewsSearchQuery() {
    	return new NewsSearchQueryImpl(applicationKey);
    }
    
    /**
     * New patent search query.
     * 
     * @return the patent search query
     */
    public PatentSearchQuery newPatentSearchQuery() {
    	return new PatentSearchQueryImpl(applicationKey);
    }
    
    /**
     * New video search query.
     * 
     * @return the video search query
     */
    public VideoSearchQuery newVideoSearchQuery() {
    	return new VideoSearchQueryImpl(applicationKey);
    }
    
    /**
     * New web search query.
     * 
     * @return the web search query
     */
    public WebSearchQuery newWebSearchQuery() {
    	return new WebSearchQueryImpl(applicationKey);
    }
    
    /**
     * New translate language query.
     * 
     * @return the translate language query
     */
    public TranslateLanguageQuery newTranslateLanguageQuery() {
    	return new TranslateLanguageQueryImpl(applicationKey);
    }

    /**
     * New translate language query.
     * 
     * @return the transliterate language query
     */
    public TransliterateLanguageQuery newTransliterateLanguageQuery() {
    	return new TransliterateLanguageQueryImpl(applicationKey);
    }
    
    /**
     * New detect language query.
     * 
     * @return the detect language query
     */
    public DetectLanguageQuery newDetectLanguageQuery() {
    	return new DetectLanguageQueryImpl(applicationKey);
    }
    
    public LoadFeedQuery newLoadFeedQuery() {
    	return new LoadFeedQueryImpl(applicationKey);
    }
    public FindFeedQuery newFindFeedQuery() {
    	return new FindFeedQueryImpl(applicationKey);
    }
    public LookupFeedQuery newLookupFeedQuery() {
    	return new LookupFeedQueryImpl(applicationKey);
    }
}
