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
import com.googleapis.ajax.schema.BlogResult;
import com.googleapis.ajax.services.BlogSearchQuery;
import com.googleapis.ajax.services.constant.GoogleSearchApiUrls;
import com.googleapis.ajax.services.constant.ParameterNames;
import com.googleapis.ajax.services.enumeration.BlogSortOrder;

/**
 * The Class BlogSearchQueryImpl.
 */
public class BlogSearchQueryImpl extends BaseGoogleSearchApiQuery<BlogResult> implements
		BlogSearchQuery {
	
	/**
	 * Instantiates a new blog search query impl.
	 * 
	 * @param applicationId the application id
	 */
	public BlogSearchQueryImpl(String applicationId) {
		super(applicationId);
	}
	
	
	/* (non-Javadoc)
	 * @see com.google.code.googlesearch.client.GoogleSearchQuery#reset()
	 */
	@Override
	public void reset() {
		apiUrlBuilder = createGoogleSearchApiUrlBuilder(GoogleSearchApiUrls.SEARCH_BLOG_URL);
	}


	/* (non-Javadoc)
	 * @see com.google.code.googlesearch.client.BlogSearchQuery#withOrder(com.google.code.googlesearch.client.enumeration.BlogSortOrder)
	 */
	@Override
	public BlogSearchQuery withOrder(BlogSortOrder order) {
		apiUrlBuilder.withParameterEnum(ParameterNames.SCORING, order);
		return this;
	}

	/* (non-Javadoc)
	 * @see com.google.code.googlesearch.client.impl.BaseGoogleSearchApiQuery#unmarshall(com.google.gson.JsonElement)
	 */
	@Override
	protected BlogResult unmarshall(JsonElement object) {
		Gson gson = getGsonBuilder().create();
		return gson.fromJson(object, BlogResult.class);
	}
}
