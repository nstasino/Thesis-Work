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
import java.util.List;

/**
 * The Class NewsResult.
 */
public class NewsResult extends SchemaEntity {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 8463967785278054587L;
	
	/** The title. */
	private String title;
	
	/** The title no formatting. */
	private String titleNoFormatting;
	
	/** The unescaped url. */
	private String unescapedUrl;
	
	/** The url. */
	private String url;
	
	/** The cluster url. */
	private String clusterUrl;
	
	/** The content. */
	private String content;
	
	/** The publisher. */
	private String publisher;
	
	/** The location. */
	private String location;
	
	/** The published date. */
	private Date publishedDate;
	
	/** The related stories. */
	private List<NewsStory> relatedStories;
	
	/** The image. */
	private Image image;
	
	/** The language. */
	private String language;
	
	/** The author. */
	private String author;
	
	/** The signed redirect url. */
	private String signedRedirectUrl;
	
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
	 * Gets the cluster url.
	 * 
	 * @return the cluster url
	 */
	public String getClusterUrl() {
		return clusterUrl;
	}
	
	/**
	 * Sets the cluster url.
	 * 
	 * @param clusterUrl the new cluster url
	 */
	public void setClusterUrl(String clusterUrl) {
		this.clusterUrl = clusterUrl;
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
	 * Gets the publisher.
	 * 
	 * @return the publisher
	 */
	public String getPublisher() {
		return publisher;
	}
	
	/**
	 * Sets the publisher.
	 * 
	 * @param publisher the new publisher
	 */
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	
	/**
	 * Gets the location.
	 * 
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}
	
	/**
	 * Sets the location.
	 * 
	 * @param location the new location
	 */
	public void setLocation(String location) {
		this.location = location;
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
	
	/**
	 * Gets the related stories.
	 * 
	 * @return the related stories
	 */
	public List<NewsStory> getRelatedStories() {
		return relatedStories;
	}
	
	/**
	 * Sets the related stories.
	 * 
	 * @param relatedStories the new related stories
	 */
	public void setRelatedStories(List<NewsStory> relatedStories) {
		this.relatedStories = relatedStories;
	}
	
	/**
	 * Gets the image.
	 * 
	 * @return the image
	 */
	public Image getImage() {
		return image;
	}
	
	/**
	 * Sets the image.
	 * 
	 * @param image the new image
	 */
	public void setImage(Image image) {
		this.image = image;
	}
	
	/**
	 * Gets the language.
	 * 
	 * @return the language
	 */
	public String getLanguage() {
		return language;
	}
	
	/**
	 * Sets the language.
	 * 
	 * @param language the new language
	 */
	public void setLanguage(String language) {
		this.language = language;
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
	 * Gets the signed redirect url.
	 * 
	 * @return the signed redirect url
	 */
	public String getSignedRedirectUrl() {
		return signedRedirectUrl;
	}
	
	/**
	 * Sets the signed redirect url.
	 * 
	 * @param signedRedirectUrl the new signed redirect url
	 */
	public void setSignedRedirectUrl(String signedRedirectUrl) {
		this.signedRedirectUrl = signedRedirectUrl;
	}
}
