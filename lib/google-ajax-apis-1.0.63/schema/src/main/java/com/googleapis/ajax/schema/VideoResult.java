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
 * The Class VideoResult.
 */
public class VideoResult extends SchemaEntity {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -544563069546960689L;
	
	/** The title. */
	private String title;
	
	/** The title no formatting. */
	private String titleNoFormatting;
	
	/** The content. */
	private String content;
	
	/** The url. */
	private String url;
	
	/** The published. */
	private Date published;
	
	/** The publisher. */
	private String publisher;
	
	/** The duration. */
	private int duration;
	
	/** The tb width. */
	private int tbWidth;
	
	/** The tb height. */
	private int tbHeight;
	
	/** The tb url. */
	private String tbUrl;
	
	/** The play url. */
	private String playUrl;
	
	/** The author. */
	private String author;
	
	/** The view count. */
	private int viewCount;
	
	/** The rating. */
	private double rating;
	
	/** The video type. */
	private VideoType videoType;
	
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
	 * Gets the published.
	 * 
	 * @return the published
	 */
	public Date getPublished() {
		return published;
	}
	
	/**
	 * Sets the published.
	 * 
	 * @param published the new published
	 */
	public void setPublished(Date published) {
		this.published = published;
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
	 * Gets the duration.
	 * 
	 * @return the duration
	 */
	public int getDuration() {
		return duration;
	}
	
	/**
	 * Sets the duration.
	 * 
	 * @param duration the new duration
	 */
	public void setDuration(int duration) {
		this.duration = duration;
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
	 * Gets the play url.
	 * 
	 * @return the play url
	 */
	public String getPlayUrl() {
		return playUrl;
	}
	
	/**
	 * Sets the play url.
	 * 
	 * @param playUrl the new play url
	 */
	public void setPlayUrl(String playUrl) {
		this.playUrl = playUrl;
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
	 * Gets the view count.
	 * 
	 * @return the view count
	 */
	public int getViewCount() {
		return viewCount;
	}
	
	/**
	 * Sets the view count.
	 * 
	 * @param viewCount the new view count
	 */
	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}
	
	/**
	 * Gets the rating.
	 * 
	 * @return the rating
	 */
	public double getRating() {
		return rating;
	}
	
	/**
	 * Sets the rating.
	 * 
	 * @param rating the new rating
	 */
	public void setRating(double rating) {
		this.rating = rating;
	}
	
	/**
	 * Gets the video type.
	 * 
	 * @return the video type
	 */
	public VideoType getVideoType() {
		return videoType;
	}
	
	/**
	 * Sets the video type.
	 * 
	 * @param videoType the new video type
	 */
	public void setVideoType(VideoType videoType) {
		this.videoType = videoType;
	}
}
