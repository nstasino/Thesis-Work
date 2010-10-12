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
 * The Class ImageResult.
 */
public class ImageResult extends SchemaEntity {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 6998066536030585746L;
	
	/** The title. */
	private String title;
	
	/** The title no formatting. */
	private String titleNoFormatting;
	
	/** The unescaped url. */
	private String unescapedUrl;
	
	/** The url. */
	private String url;
	
	/** The visible url. */
	private String visibleUrl;
	
	/** The original context url. */
	private String originalContextUrl;
	
	/** The width. */
	private int width;
	
	/** The height. */
	private int height;
	
	/** The tb width. */
	private int tbWidth;
	
	/** The tb height. */
	private int tbHeight;
	
	/** The tb url. */
	private String tbUrl;
	
	/** The content. */
	private String content;
	
	/** The content no formatting. */
	private String contentNoFormatting;
	
	/** The image id. */
	private String imageId;
	
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
	 * Gets the width.
	 * 
	 * @return the width
	 */
	public int getWidth() {
		return width;
	}
	
	/**
	 * Sets the width.
	 * 
	 * @param width the new width
	 */
	public void setWidth(int width) {
		this.width = width;
	}
	
	/**
	 * Gets the height.
	 * 
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}
	
	/**
	 * Sets the height.
	 * 
	 * @param height the new height
	 */
	public void setHeight(int height) {
		this.height = height;
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
	 * Gets the content no formatting.
	 * 
	 * @return the content no formatting
	 */
	public String getContentNoFormatting() {
		return contentNoFormatting;
	}
	
	/**
	 * Sets the content no formatting.
	 * 
	 * @param contentNoFormatting the new content no formatting
	 */
	public void setContentNoFormatting(String contentNoFormatting) {
		this.contentNoFormatting = contentNoFormatting;
	}
	
	/**
	 * Gets the image id.
	 * 
	 * @return the image id
	 */
	public String getImageId() {
		return imageId;
	}
	
	/**
	 * Sets the image id.
	 * 
	 * @param imageId the new image id
	 */
	public void setImageId(String imageId) {
		this.imageId = imageId;
	}
}
