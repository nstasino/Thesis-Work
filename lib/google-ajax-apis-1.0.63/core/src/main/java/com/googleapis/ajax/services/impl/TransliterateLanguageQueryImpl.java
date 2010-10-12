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

import java.io.InputStream;
import java.io.InputStreamReader;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.googleapis.ajax.common.PagedArrayList;
import com.googleapis.ajax.common.PagedList;
import com.googleapis.ajax.schema.Language;
import com.googleapis.ajax.schema.TransliterateLanguageResult;
import com.googleapis.ajax.services.GoogleSearchException;
import com.googleapis.ajax.services.TransliterateLanguageQuery;
import com.googleapis.ajax.services.constant.GoogleSearchApiUrls;
import com.googleapis.ajax.services.constant.ParameterNames;
import com.googleapis.ajax.services.enumeration.TranslationFormat;

/**
 * The Class TranslateLanguageQueryImpl.
 */
public class TransliterateLanguageQueryImpl extends BaseGoogleSearchApiQuery<TransliterateLanguageResult> implements
	TransliterateLanguageQuery {
//	private Map<String, List<String>> parameters = new HashMap<String, List<String>>(); 
	
	/**
	 * Instantiates a new translate language query impl.
	 * 
	 * @param applicationId the application id
	 */
	public TransliterateLanguageQueryImpl(String applicationId) {
		super(applicationId);
	}
	
	
	/* (non-Javadoc)
	 * @see com.google.code.googlesearch.client.GoogleSearchQuery#reset()
	 */
	@Override
	public void reset() {
		apiUrlBuilder = createGoogleSearchApiUrlBuilder(GoogleSearchApiUrls.LANGUAGE_TRANSLITERATE_URL);
	}

	/* (non-Javadoc)
	 * @see com.google.code.googlesearch.client.TranslateLanguageQuery#withFormat(com.google.code.googlesearch.client.enumeration.TranslationFormat)
	 */
	@Override
	public TransliterateLanguageQuery withFormat(TranslationFormat format) {
		apiUrlBuilder.withParameterEnum(ParameterNames.FORMAT, format);
		return this;
	}


	/* (non-Javadoc)
	 * @see com.google.code.googlesearch.client.TranslateLanguageQuery#withLanguagePair(java.lang.String, java.lang.String)
	 */
	@Override
	public TransliterateLanguageQuery withLanguagePair(Language sourceLanguage,
			Language targetLanguage) {
		String languagePair = "|" + targetLanguage.value();
		if (sourceLanguage != null) {
			languagePair = sourceLanguage.value() + languagePair;
		}
		apiUrlBuilder.withParameter(ParameterNames.LANGUAGE_PAIR, languagePair);
//		putParameters(ParameterNames.LANGUAGE_PAIR, languagePair);
		return this;
	}
	
	@Override
	public TransliterateLanguageQuery withQuery(String query) {
		apiUrlBuilder.withParameter(ParameterNames.QUERY, query);
//		putParameters(ParameterNames.QUERY, query);
		return this;
	}
	
	
	@Override
	public PagedList<TransliterateLanguageResult> list() {
		InputStream jsonContent = null;
        try {
        	jsonContent = callApiGet(apiUrlBuilder.buildUrl());
        	JsonElement response = parser.parse(new InputStreamReader(jsonContent, UTF_8_CHAR_SET));
        	if (response.isJsonObject()) {
        		PagedList<TransliterateLanguageResult> responseList = unmarshallList(response.getAsJsonObject());
        		notifyObservers(responseList);
    			return responseList;
        	}
        	throw new GoogleSearchException("Unknown content found in response:" + response.toString());
        } catch (Exception e) {
            throw new GoogleSearchException(e);
        } finally {
	        closeStream(jsonContent);
	    }
	}
	
	@Override
	public TransliterateLanguageResult singleResult() {
		InputStream jsonContent = null;
        try {
        	jsonContent = callApiGet(apiUrlBuilder.buildUrl());
        	JsonElement response = parser.parse(new InputStreamReader(jsonContent, UTF_8_CHAR_SET));
        	if (response.isJsonObject()) {
        		PagedList<TransliterateLanguageResult> responseList = unmarshallList(response.getAsJsonObject());
        		notifyObservers(responseList);
    			return responseList.isEmpty() ? null : responseList.get(0);
        	}
        	throw new GoogleSearchException("Unknown content found in response:" + response.toString());
        } catch (Exception e) {
            throw new GoogleSearchException(e);
        } finally {
	        closeStream(jsonContent);
	    }
	}

	/**
	 * Unmarshall list.
	 * 
	 * @param response the response
	 * 
	 * @return the paged list< t>
	 */
	protected PagedList<TransliterateLanguageResult> unmarshallList(JsonObject response) {
		int status = response.get("responseStatus").getAsInt();
		if (status != 200) {
			throw new GoogleSearchException(String.valueOf(response.get("responseDetails").getAsString()));
		}
		JsonObject data = response.get("responseData").getAsJsonObject();
		PagedArrayList<TransliterateLanguageResult> list = new PagedArrayList<TransliterateLanguageResult>();
		if (data != null) {
			JsonArray dataArray = data.get("transliterations").getAsJsonArray();
			for (JsonElement element : dataArray) {
	        	if (element.isJsonObject()) {
	        		JsonObject json = element.getAsJsonObject();
        			list.add(unmarshall(json));
	        	}
			}
		} 
		return list;
	}
	
	/* (non-Javadoc)
	 * @see com.google.code.googlesearch.client.impl.BaseGoogleSearchApiQuery#unmarshall(com.google.gson.JsonElement)
	 */
	@Override
	protected TransliterateLanguageResult unmarshall(JsonElement object) {
		Gson gson = getGsonBuilder().create();
		return gson.fromJson(object, TransliterateLanguageResult.class);
	}
	
//	protected void putParameters(String name, String value) {
//		List<String> values = parameters.get(name);
//		if (values == null) {
//			values = new ArrayList<String>();
//			parameters.put(name, values);
//		}
//		values.add(value);
//	}
}
