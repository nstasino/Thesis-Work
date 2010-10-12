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
 * The Class PatentResult.
 */
public class PatentResult extends SchemaEntity {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -1220138742878830624L;
	
	/** The title. */
	private String title;
	
	/** The title no formatting. */
	private String titleNoFormatting;
	
	/** The content. */
	private String content;
	
	/** The unescaped url. */
	private String unescapedUrl;
	
	/** The url. */
	private String url;
	
	/** The application date. */
	private Date applicationDate;
	
	/** The patent number. */
	private String patentNumber;
	
	/** The patent status. */
	private PatentStatus patentStatus;
	
	/** The assignee. */
	private String assignee;
	
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
	 * Gets the application date.
	 * 
	 * @return the application date
	 */
	public Date getApplicationDate() {
		return applicationDate;
	}
	
	/**
	 * Sets the application date.
	 * 
	 * @param applicationDate the new application date
	 */
	public void setApplicationDate(Date applicationDate) {
		this.applicationDate = applicationDate;
	}
	
	/**
	 * Gets the patent number.
	 * 
	 * @return the patent number
	 */
	public String getPatentNumber() {
		return patentNumber;
	}
	
	/**
	 * Sets the patent number.
	 * 
	 * @param patentNumber the new patent number
	 */
	public void setPatentNumber(String patentNumber) {
		this.patentNumber = patentNumber;
	}
	
	/**
	 * Gets the patent status.
	 * 
	 * @return the patent status
	 */
	public PatentStatus getPatentStatus() {
		return patentStatus;
	}
	
	/**
	 * Sets the patent status.
	 * 
	 * @param patentStatus the new patent status
	 */
	public void setPatentStatus(PatentStatus patentStatus) {
		this.patentStatus = patentStatus;
	}
	
	/**
	 * Gets the assignee.
	 * 
	 * @return the assignee
	 */
	public String getAssignee() {
		return assignee;
	}
	
	/**
	 * Sets the assignee.
	 * 
	 * @param assignee the new assignee
	 */
	public void setAssignee(String assignee) {
		this.assignee = assignee;
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
