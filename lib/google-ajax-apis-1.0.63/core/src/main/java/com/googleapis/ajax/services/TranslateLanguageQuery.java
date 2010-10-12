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

import com.googleapis.ajax.schema.Language;
import com.googleapis.ajax.schema.TranslateLanguageResult;
import com.googleapis.ajax.services.enumeration.TranslationFormat;

/**
 * The Interface TranslateLanguageQuery.
 */
public interface TranslateLanguageQuery extends GoogleSearchQuery<TranslateLanguageResult> {
	
	/**
	 * With language pair.
	 * 
	 * @param sourceLanguage the source language
	 * @param targetLanguage the target language
	 * 
	 * @return the translate language query
	 */
	public TranslateLanguageQuery withLanguagePair(Language sourceLanguage, Language targetLanguage);
	
	/**
	 * With format.
	 * 
	 * @param format the format
	 * 
	 * @return the translate language query
	 */
	public TranslateLanguageQuery withFormat(TranslationFormat format);
}
