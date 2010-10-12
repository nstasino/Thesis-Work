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
package com.googleapis.ajax.schema;

import java.util.List;



/**
 * The Class TranslateLanguageResult.
 */
public class TransliterateLanguageResult extends SchemaEntity {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -7036808295558563537L;
	
	/** The translated text. */
	private String sourceWord;
	private List<String> transliteratedWords;
	/**
	 * @return the sourceWord
	 */
	public String getSourceWord() {
		return sourceWord;
	}
	/**
	 * @param sourceWord the sourceWord to set
	 */
	public void setSourceWord(String sourceWord) {
		this.sourceWord = sourceWord;
	}
	/**
	 * @return the transliteratedWords
	 */
	public List<String> getTransliteratedWords() {
		return transliteratedWords;
	}
	/**
	 * @param transliteratedWords the transliteratedWords to set
	 */
	public void setTransliteratedWords(List<String> transliteratedWords) {
		this.transliteratedWords = transliteratedWords;
	}
}
