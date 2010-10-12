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



/**
 * The Class TranslateLanguageResult.
 */
public class TranslateLanguageResult extends SchemaEntity {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -7036808295558563537L;
	
	/** The translated text. */
	private String translatedText;
	
	/** The detected source language. */
	private Language detectedSourceLanguage;
	
	/**
	 * Gets the translated text.
	 * 
	 * @return the translated text
	 */
	public String getTranslatedText() {
		return translatedText;
	}
	
	/**
	 * Sets the translated text.
	 * 
	 * @param translatedText the new translated text
	 */
	public void setTranslatedText(String translatedText) {
		this.translatedText = translatedText;
	}
	
	/**
	 * Gets the detected source language.
	 * 
	 * @return the detected source language
	 */
	public Language getDetectedSourceLanguage() {
		return detectedSourceLanguage;
	}
	
	/**
	 * Sets the detected source language.
	 * 
	 * @param detectedSourceLanguage the new detected source language
	 */
	public void setDetectedSourceLanguage(Language detectedSourceLanguage) {
		this.detectedSourceLanguage = detectedSourceLanguage;
	}
}
