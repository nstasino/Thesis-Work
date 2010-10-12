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

import java.util.Date;

/**
 * The Class BlogResult.
 */
public class BlogResult extends SchemaEntity {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1556677921929249355L;
	
	/** The title. */
	private String title;
	
	/** The title no formatting. */
	private String titleNoFormatting;
	
	/** The post url. */
	private String postUrl;
	
	/** The content. */
	private String content;
	
	/** The author. */
	private String author;
	
	/** The blog url. */
	private String blogUrl;
	
	/** The published date. */
	private Date publishedDate;
	
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
	 * Gets the post url.
	 * 
	 * @return the post url
	 */
	public String getPostUrl() {
		return postUrl;
	}
	
	/**
	 * Sets the post url.
	 * 
	 * @param postUrl the new post url
	 */
	public void setPostUrl(String postUrl) {
		this.postUrl = postUrl;
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
	 * Gets the author.
	 * 
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}
	
	/**
	 * Sets the author.
	 * 
	 * @param author the new author
	 */
	public void setAuthor(String author) {
		this.author = author;
	}
	
	/**
	 * Gets the blog url.
	 * 
	 * @return the blog url
	 */
	public String getBlogUrl() {
		return blogUrl;
	}
	
	/**
	 * Sets the blog url.
	 * 
	 * @param blogUrl the new blog url
	 */
	public void setBlogUrl(String blogUrl) {
		this.blogUrl = blogUrl;
	}
	
	/**
	 * Gets the published date.
	 * 
	 * @return the published date
	 */
	public Date getPublishedDate() {
		return publishedDate;
	}
	
	/**
	 * Sets the published date.
	 * 
	 * @param publishedDate the new published date
	 */
	public void setPublishedDate(Date publishedDate) {
		this.publishedDate = publishedDate;
	}
}
