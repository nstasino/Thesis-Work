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
 * The Class BookResult.
 */
public class BookResult extends SchemaEntity {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1165875438932653598L;
	
	/** The title. */
	private String title;
	
	/** The title no formatting. */
	private String titleNoFormatting;
	
	/** The unescaped url. */
	private String unescapedUrl;
	
	/** The url. */
	private String url;
	
	/** The authors. */
	private String authors;
	
	/** The book id. */
	private String bookId;
	
	/** The published year. */
	private String publishedYear;
	
	/** The page count. */
	private int pageCount;
	
	/** The thumbnail html. */
	private String thumbnailHtml;
	
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
	 * Gets the authors.
	 * 
	 * @return the authors
	 */
	public String getAuthors() {
		return authors;
	}
	
	/**
	 * Sets the authors.
	 * 
	 * @param authors the new authors
	 */
	public void setAuthors(String authors) {
		this.authors = authors;
	}
	
	/**
	 * Gets the book id.
	 * 
	 * @return the book id
	 */
	public String getBookId() {
		return bookId;
	}
	
	/**
	 * Sets the book id.
	 * 
	 * @param bookId the new book id
	 */
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	
	/**
	 * Gets the published year.
	 * 
	 * @return the published year
	 */
	public String getPublishedYear() {
		return publishedYear;
	}
	
	/**
	 * Sets the published year.
	 * 
	 * @param publishedYear the new published year
	 */
	public void setPublishedYear(String publishedYear) {
		this.publishedYear = publishedYear;
	}
	
	/**
	 * Gets the page count.
	 * 
	 * @return the page count
	 */
	public int getPageCount() {
		return pageCount;
	}
	
	/**
	 * Sets the page count.
	 * 
	 * @param pageCount the new page count
	 */
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	
	/**
	 * Gets the thumbnail html.
	 * 
	 * @return the thumbnail html
	 */
	public String getThumbnailHtml() {
		return thumbnailHtml;
	}
	
	/**
	 * Sets the thumbnail html.
	 * 
	 * @param thumbnailHtml the new thumbnail html
	 */
	public void setThumbnailHtml(String thumbnailHtml) {
		this.thumbnailHtml = thumbnailHtml;
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
}
