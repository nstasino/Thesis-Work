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
 * The Class DetectLanguageResult.
 */
public class DetectLanguageResult extends SchemaEntity {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -7595223844163364948L;
	
	/** The language. */
	private Language language;
	
	/** The reliable. */
	private boolean reliable;
	
	/** The confidence. */
	private double confidence;
	
	/**
	 * Gets the language.
	 * 
	 * @return the language
	 */
	public Language getLanguage() {
		return language;
	}
	
	/**
	 * Sets the language.
	 * 
	 * @param language the new language
	 */
	public void setLanguage(Language language) {
		this.language = language;
	}
	
	/**
	 * Checks if is reliable.
	 * 
	 * @return true, if is reliable
	 */
	public boolean isReliable() {
		return reliable;
	}
	
	/**
	 * Sets the reliable.
	 * 
	 * @param reliable the new reliable
	 */
	public void setReliable(boolean reliable) {
		this.reliable = reliable;
	}
	
	/**
	 * Gets the confidence.
	 * 
	 * @return the confidence
	 */
	public double getConfidence() {
		return confidence;
	}
	
	/**
	 * Sets the confidence.
	 * 
	 * @param confidence the new confidence
	 */
	public void setConfidence(double confidence) {
		this.confidence = confidence;
	}
}
