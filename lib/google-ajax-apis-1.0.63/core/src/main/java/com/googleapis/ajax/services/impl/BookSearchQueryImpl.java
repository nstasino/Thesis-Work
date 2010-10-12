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

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.googleapis.ajax.schema.BookResult;
import com.googleapis.ajax.services.BookSearchQuery;
import com.googleapis.ajax.services.constant.GoogleSearchApiUrls;
import com.googleapis.ajax.services.constant.ParameterNames;
import com.googleapis.ajax.services.enumeration.BookSearchType;

/**
 * The Class BookSearchQueryImpl.
 */
public class BookSearchQueryImpl extends BaseGoogleSearchApiQuery<BookResult> implements
		BookSearchQuery {
	
	/**
	 * Instantiates a new book search query impl.
	 * 
	 * @param applicationId the application id
	 */
	public BookSearchQueryImpl(String applicationId) {
		super(applicationId);
	}
	
	
	/* (non-Javadoc)
	 * @see com.google.code.googlesearch.client.GoogleSearchQuery#reset()
	 */
	@Override
	public void reset() {
		apiUrlBuilder = createGoogleSearchApiUrlBuilder(GoogleSearchApiUrls.SEARCH_BOOK_URL);
	}


	/* (non-Javadoc)
	 * @see com.google.code.googlesearch.client.BookSearchQuery#withLibrary(java.lang.String)
	 */
	@Override
	public BookSearchQuery withLibrary(String library) {
		apiUrlBuilder.withParameter(ParameterNames.BOOK_LIBRARY, library);
		return this;
	}


	/* (non-Javadoc)
	 * @see com.google.code.googlesearch.client.BookSearchQuery#withSearchType(com.google.code.googlesearch.client.enumeration.BookSearchType)
	 */
	@Override
	public BookSearchQuery withSearchType(BookSearchType type) {
		if (type.value() != null) {
			apiUrlBuilder.withParameter(type.value(), "1");
		}
		return this;
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.googlesearch.client.impl.BaseGoogleSearchApiQuery#unmarshall(com.google.gson.JsonElement)
	 */
	@Override
	protected BookResult unmarshall(JsonElement object) {
		Gson gson = getGsonBuilder().create();
		return gson.fromJson(object, BookResult.class);
	}
}
