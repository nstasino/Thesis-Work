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
import com.googleapis.ajax.schema.LocalResult;
import com.googleapis.ajax.services.LocalSearchQuery;
import com.googleapis.ajax.services.constant.GoogleSearchApiUrls;
import com.googleapis.ajax.services.constant.ParameterNames;
import com.googleapis.ajax.services.enumeration.LocalSearchType;

/**
 * The Class LocalSearchQueryImpl.
 */
public class LocalSearchQueryImpl extends BaseGoogleSearchApiQuery<LocalResult> implements
		LocalSearchQuery {
	
	/**
	 * Instantiates a new local search query impl.
	 * 
	 * @param applicationId the application id
	 */
	public LocalSearchQueryImpl(String applicationId) {
		super(applicationId);
	}
	
	
	/* (non-Javadoc)
	 * @see com.google.code.googlesearch.client.GoogleSearchQuery#reset()
	 */
	@Override
	public void reset() {
		apiUrlBuilder = createGoogleSearchApiUrlBuilder(GoogleSearchApiUrls.SEARCH_LOCAL_URL);
	}


	/* (non-Javadoc)
	 * @see com.google.code.googlesearch.client.LocalSearchQuery#withBoundingBox(double, double)
	 */
	@Override
	public LocalSearchQuery withBoundingBox(double x, double y) {
		apiUrlBuilder.withParameter(ParameterNames.BOUNDING_BOX, x + "," + y);
		return this;
	}


	/* (non-Javadoc)
	 * @see com.google.code.googlesearch.client.LocalSearchQuery#withLocalSearchType(com.google.code.googlesearch.client.enumeration.LocalSearchType)
	 */
	@Override
	public LocalSearchQuery withLocalSearchType(LocalSearchType type) {
		apiUrlBuilder.withParameterEnum(ParameterNames.TYPE_OF_LISTING, type);
		return this;
	}


	/* (non-Javadoc)
	 * @see com.google.code.googlesearch.client.LocalSearchQuery#withLocation(double, double)
	 */
	@Override
	public LocalSearchQuery withLocation(double latitude, double longitude) {
		apiUrlBuilder.withParameter(ParameterNames.SEARCH_CENTER_POINT, latitude + "," + longitude);
		return this;
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.googlesearch.client.impl.BaseGoogleSearchApiQuery#unmarshall(com.google.gson.JsonElement)
	 */
	@Override
	protected LocalResult unmarshall(JsonElement object) {
		Gson gson = getGsonBuilder().create();
		return gson.fromJson(object, LocalResult.class);
	}
}
