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
package com.googleapis.ajax.services.impl;

import java.util.Locale;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.googleapis.ajax.schema.WebResult;
import com.googleapis.ajax.services.WebSearchQuery;
import com.googleapis.ajax.services.constant.GoogleSearchApiUrls;
import com.googleapis.ajax.services.constant.ParameterNames;
import com.googleapis.ajax.services.enumeration.DuplicateContentFilter;
import com.googleapis.ajax.services.enumeration.LanguageFilter;
import com.googleapis.ajax.services.enumeration.SafetyLevel;

/**
 * The Class WebSearchQueryImpl.
 */
public class WebSearchQueryImpl extends BaseGoogleSearchApiQuery<WebResult> implements
		WebSearchQuery {
	
	/**
	 * Instantiates a new web search query impl.
	 * 
	 * @param applicationId the application id
	 */
	public WebSearchQueryImpl(String applicationId) {
		super(applicationId);
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.googlesearch.client.GoogleSearchQuery#reset()
	 */
	@Override
	public void reset() {
		apiUrlBuilder = createGoogleSearchApiUrlBuilder(GoogleSearchApiUrls.SEARCH_WEB_URL);
	}


	/* (non-Javadoc)
	 * @see com.google.code.googlesearch.client.WebSearchQuery#withCountry(java.util.Locale)
	 */
	@Override
	public WebSearchQuery withCountry(Locale country) {
		apiUrlBuilder.withParameter(ParameterNames.COUNTRY_RESTRICTION, country.getCountry());
		return this;
	}


	/* (non-Javadoc)
	 * @see com.google.code.googlesearch.client.WebSearchQuery#withCustomeSearchEngineId(java.lang.String)
	 */
	@Override
	public WebSearchQuery withCustomeSearchEngineId(String cx) {
		apiUrlBuilder.withParameter(ParameterNames.CUSTOM_SEARCH_ID, cx);
		return this;
	}


	/* (non-Javadoc)
	 * @see com.google.code.googlesearch.client.WebSearchQuery#withCustomeSearchEngineUrl(java.lang.String)
	 */
	@Override
	public WebSearchQuery withCustomeSearchEngineUrl(String cx) {
		apiUrlBuilder.withParameter(ParameterNames.CUSTOM_SEARCH_URL, cx);
		return this;
	}


	/* (non-Javadoc)
	 * @see com.google.code.googlesearch.client.WebSearchQuery#withDuplicateFilter(com.google.code.googlesearch.client.enumeration.DuplicateContentFilter)
	 */
	@Override
	public WebSearchQuery withDuplicateFilter(DuplicateContentFilter filter) {
		apiUrlBuilder.withParameterEnum(ParameterNames.DUPLICATE_FILTER, filter);
		return this;
	}


	/* (non-Javadoc)
	 * @see com.google.code.googlesearch.client.WebSearchQuery#withLanguage(java.util.Locale)
	 */
	@Override
	public WebSearchQuery withLanguage(LanguageFilter language) {
		apiUrlBuilder.withParameterEnum(ParameterNames.LANGUAGE_RESTRICTION, language);
		return this;
	}


	/* (non-Javadoc)
	 * @see com.google.code.googlesearch.client.WebSearchQuery#withSafetyLevel(com.google.code.googlesearch.client.enumeration.SafetyLevel)
	 */
	@Override
	public WebSearchQuery withSafetyLevel(SafetyLevel safe) {
		apiUrlBuilder.withParameterEnum(ParameterNames.SAFETY_LEVEL, safe);
		return this;
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.googlesearch.client.impl.BaseGoogleSearchApiQuery#unmarshall(com.google.gson.JsonElement)
	 */
	@Override
	protected WebResult unmarshall(JsonElement object) {
		Gson gson = getGsonBuilder().create();
		return gson.fromJson(object, WebResult.class);
	}
}
