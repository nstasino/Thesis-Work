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
 * The Class Image.
 */
public class Image extends SchemaEntity {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -2155486647070807034L;


	/** The title. */
	private String title;
	
	/** The title no formatting. */
	private String titleNoFormatting;
	
	/** The url. */
	private String url;
	
	/** The original context url. */
	private String originalContextUrl;
	
	private String publisher;
	
	/** The tb width. */
	private int tbWidth;
	
	/** The tb height. */
	private int tbHeight;
	
	/** The tb url. */
	private String tbUrl;
	
	/**
	 * Gets the title.
	 * 
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	
	/**
	 * Sets the title.
	 * 
	 * @param title the new title
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	
	/**
	 * Gets the title no formatting.
	 * 
	 * @return the title no formatting
	 */
	public String getTitleNoFormatting() {
		return titleNoFormatting;
	}
	
	/**
	 * Sets the title no formatting.
	 * 
	 * @param titleNoFormatting the new title no formatting
	 */
	public void setTitleNoFormatting(String titleNoFormatting) {
		this.titleNoFormatting = titleNoFormatting;
	}
	
	/**
	 * Gets the url.
	 * 
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}
	
	/**
	 * Sets the url.
	 * 
	 * @param url the new url
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	
	/**
	 * Gets the original context url.
	 * 
	 * @return the original context url
	 */
	public String getOriginalContextUrl() {
		return originalContextUrl;
	}
	
	/**
	 * Sets the original context url.
	 * 
	 * @param originalContextUrl the new original context url
	 */
	public void setOriginalContextUrl(String originalContextUrl) {
		this.originalContextUrl = originalContextUrl;
	}
	
	/**
	 * Gets the tb width.
	 * 
	 * @return the tb width
	 */
	public int getTbWidth() {
		return tbWidth;
	}
	
	/**
	 * Sets the tb width.
	 * 
	 * @param tbWidth the new tb width
	 */
	public void setTbWidth(int tbWidth) {
		this.tbWidth = tbWidth;
	}
	
	/**
	 * Gets the tb height.
	 * 
	 * @return the tb height
	 */
	public int getTbHeight() {
		return tbHeight;
	}
	
	/**
	 * Sets the tb height.
	 * 
	 * @param tbHeight the new tb height
	 */
	public void setTbHeight(int tbHeight) {
		this.tbHeight = tbHeight;
	}
	
	/**
	 * Gets the tb url.
	 * 
	 * @return the tb url
	 */
	public String getTbUrl() {
		return tbUrl;
	}
	
	/**
	 * Sets the tb url.
	 * 
	 * @param tbUrl the new tb url
	 */
	public void setTbUrl(String tbUrl) {
		this.tbUrl = tbUrl;
	}

	/**
	 * @return the publisher
	 */
	public String getPublisher() {
		return publisher;
	}

	/**
	 * @param publisher the publisher to set
	 */
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
}
