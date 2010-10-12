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
import com.googleapis.ajax.schema.ImageResult;
import com.googleapis.ajax.services.ImageSearchQuery;
import com.googleapis.ajax.services.constant.GoogleSearchApiUrls;
import com.googleapis.ajax.services.constant.ParameterNames;
import com.googleapis.ajax.services.enumeration.ImageColor;
import com.googleapis.ajax.services.enumeration.ImageColorization;
import com.googleapis.ajax.services.enumeration.ImageFileType;
import com.googleapis.ajax.services.enumeration.ImageRights;
import com.googleapis.ajax.services.enumeration.ImageSize;
import com.googleapis.ajax.services.enumeration.ImageType;
import com.googleapis.ajax.services.enumeration.SafetyLevel;

/**
 * The Class ImageSearchQueryImpl.
 */
public class ImageSearchQueryImpl extends BaseGoogleSearchApiQuery<ImageResult> implements
		ImageSearchQuery {
	
	/**
	 * Instantiates a new image search query impl.
	 * 
	 * @param applicationId the application id
	 */
	public ImageSearchQueryImpl(String applicationId) {
		super(applicationId);
	}
	
	
	/* (non-Javadoc)
	 * @see com.google.code.googlesearch.client.GoogleSearchQuery#reset()
	 */
	@Override
	public void reset() {
		apiUrlBuilder = createGoogleSearchApiUrlBuilder(GoogleSearchApiUrls.SEARCH_IMAGE_URL);
	}


	/* (non-Javadoc)
	 * @see com.google.code.googlesearch.client.ImageSearchQuery#withFileType(com.google.code.googlesearch.client.enumeration.ImageFileType)
	 */
	@Override
	public ImageSearchQuery withFileType(ImageFileType fileType) {
		apiUrlBuilder.withParameterEnum(ParameterNames.IMAGE_FILE_TYPE, fileType);
		return this;
	}


	/* (non-Javadoc)
	 * @see com.google.code.googlesearch.client.ImageSearchQuery#withImageColor(com.google.code.googlesearch.client.enumeration.ImageColor)
	 */
	@Override
	public ImageSearchQuery withImageColor(ImageColor color) {
		apiUrlBuilder.withParameterEnum(ParameterNames.IMAGE_COLOR, color);
		return this;
	}


	/* (non-Javadoc)
	 * @see com.google.code.googlesearch.client.ImageSearchQuery#withImageColorization(com.google.code.googlesearch.client.enumeration.ImageColorization)
	 */
	@Override
	public ImageSearchQuery withImageColorization(ImageColorization colorization) {
		apiUrlBuilder.withParameterEnum(ParameterNames.IMAGE_COLORIZATION, colorization);
		return this;
	}


	/* (non-Javadoc)
	 * @see com.google.code.googlesearch.client.ImageSearchQuery#withImageRights(com.google.code.googlesearch.client.enumeration.ImageRights)
	 */
	@Override
	public ImageSearchQuery withImageRights(ImageRights rights) {
		apiUrlBuilder.withParameterEnum(ParameterNames.IMAGE_RIGHTS, rights);
		return this;
	}


	/* (non-Javadoc)
	 * @see com.google.code.googlesearch.client.ImageSearchQuery#withImageSize(com.google.code.googlesearch.client.enumeration.ImageSize)
	 */
	@Override
	public ImageSearchQuery withImageSize(ImageSize imgsz) {
		apiUrlBuilder.withParameterEnum(ParameterNames.IMAGE_SIZE, imgsz);
		return this;
	}


	/* (non-Javadoc)
	 * @see com.google.code.googlesearch.client.ImageSearchQuery#withImageType(com.google.code.googlesearch.client.enumeration.ImageType)
	 */
	@Override
	public ImageSearchQuery withImageType(ImageType type) {
		apiUrlBuilder.withParameterEnum(ParameterNames.IMAGE_TYPE, type);
		return this;
	}


	/* (non-Javadoc)
	 * @see com.google.code.googlesearch.client.ImageSearchQuery#withSafetyLevel(com.google.code.googlesearch.client.enumeration.SafetyLevel)
	 */
	@Override
	public ImageSearchQuery withSafetyLevel(SafetyLevel safe) {
		apiUrlBuilder.withParameterEnum(ParameterNames.SAFETY_LEVEL, safe);
		return this;
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.googlesearch.client.impl.BaseGoogleSearchApiQuery#unmarshall(com.google.gson.JsonElement)
	 */
	@Override
	protected ImageResult unmarshall(JsonElement object) {
		Gson gson = getGsonBuilder().create();
		return gson.fromJson(object, ImageResult.class);
	}
}
