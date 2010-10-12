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

import java.util.Locale;

import com.googleapis.ajax.schema.WebResult;
import com.googleapis.ajax.services.enumeration.DuplicateContentFilter;
import com.googleapis.ajax.services.enumeration.LanguageFilter;
import com.googleapis.ajax.services.enumeration.SafetyLevel;

/**
 * The Interface WebSearchQuery.
 */
public interface WebSearchQuery extends GoogleSearchQuery<WebResult> {
	
	/**
	 * With custome search engine id.
	 * 
	 * @param cx the cx
	 * 
	 * @return the web search query
	 */
	public WebSearchQuery withCustomeSearchEngineId(String cx);
	
	/**
	 * With custome search engine url.
	 * 
	 * @param cx the cx
	 * 
	 * @return the web search query
	 */
	public WebSearchQuery withCustomeSearchEngineUrl(String cx);

	/**
	 * With safety level.
	 * 
	 * @param safe the safe
	 * 
	 * @return the web search query
	 */
	public WebSearchQuery withSafetyLevel(SafetyLevel safe);
	
	/**
	 * With language.
	 * 
	 * @param language the language
	 * 
	 * @return the web search query
	 */
	public WebSearchQuery withLanguage(LanguageFilter language);
	
	/**
	 * With country.
	 * 
	 * @param country the country
	 * 
	 * @return the web search query
	 */
	public WebSearchQuery withCountry(Locale country);
	
	/**
	 * With duplicate filter.
	 * 
	 * @param filter the filter
	 * 
	 * @return the web search query
	 */
	public WebSearchQuery withDuplicateFilter(DuplicateContentFilter filter);
}
