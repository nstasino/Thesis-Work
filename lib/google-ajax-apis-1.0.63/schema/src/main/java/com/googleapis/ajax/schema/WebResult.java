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
 * The Class WebResult.
 */
public class WebResult extends SchemaEntity {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -8535742587293626160L;
	
	/** The unescaped url. */
	private String unescapedUrl;
	
	/** The url. */
	private String url;
	
	/** The visible url. */
	private String visibleUrl;
	
	/** The title. */
	private String title;
	
	/** The title no formatting. */
	private String titleNoFormatting;
	
	/** The content. */
	private String content;
	
	/** The cache url. */
	private String cacheUrl;
	
	/**
	 * Gets the unescaped url.
	 * 
	 * @return the unescaped url
	 */
	public String getUnescapedUrl() {
		return unescapedUrl;
	}
	
	/**
	 * Sets the unescaped url.
	 * 
	 * @param unescapedUrl the new unescaped url
	 */
	public void setUnescapedUrl(String unescapedUrl) {
		this.unescapedUrl = unescapedUrl;
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
	 * Gets the visible url.
	 * 
	 * @return the visible url
	 */
	public String getVisibleUrl() {
		return visibleUrl;
	}
	
	/**
	 * Sets the visible url.
	 * 
	 * @param visibleUrl the new visible url
	 */
	public void setVisibleUrl(String visibleUrl) {
		this.visibleUrl = visibleUrl;
	}
	
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
	 * Gets the content.
	 * 
	 * @return the content
	 */
	public String getContent() {
		return content;
	}
	
	/**
	 * Sets the content.
	 * 
	 * @param content the new content
	 */
	public void setContent(String content) {
		this.content = content;
	}
	
	/**
	 * Gets the cache url.
	 * 
	 * @return the cache url
	 */
	public String getCacheUrl() {
		return cacheUrl;
	}
	
	/**
	 * Sets the cache url.
	 * 
	 * @param cacheUrl the new cache url
	 */
	public void setCacheUrl(String cacheUrl) {
		this.cacheUrl = cacheUrl;
	}
}
