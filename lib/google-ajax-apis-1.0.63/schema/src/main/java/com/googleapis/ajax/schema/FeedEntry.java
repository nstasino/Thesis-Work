/**
 * 
 */
package com.googleapis.ajax.schema;

import java.util.Date;
import java.util.List;

/**
 * @author nmukhtar
 *
 */
public class FeedEntry extends SchemaEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = -771563978505504712L;
	
//	private String mediaGroup;
	private String title;
	private String link;
	private String content;
	private String contentSnippet;
	private Date publishedDate;
	private List<String> categories;
	/**
	 * @return the mediaGroup
	 */
//	public String getMediaGroup() {
//		return mediaGroup;
//	}
//	/**
//	 * @param mediaGroup the mediaGroup to set
//	 */
//	public void setMediaGroup(String mediaGroup) {
//		this.mediaGroup = mediaGroup;
//	}
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the link
	 */
	public String getLink() {
		return link;
	}
	/**
	 * @param link the link to set
	 */
	public void setLink(String link) {
		this.link = link;
	}
	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}
	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * @return the contentSnippet
	 */
	public String getContentSnippet() {
		return contentSnippet;
	}
	/**
	 * @param contentSnippet the contentSnippet to set
	 */
	public void setContentSnippet(String contentSnippet) {
		this.contentSnippet = contentSnippet;
	}
	/**
	 * @return the publishedDate
	 */
	public Date getPublishedDate() {
		return publishedDate;
	}
	/**
	 * @param publishedDate the publishedDate to set
	 */
	public void setPublishedDate(Date publishedDate) {
		this.publishedDate = publishedDate;
	}
	/**
	 * @return the categories
	 */
	public List<String> getCategories() {
		return categories;
	}
	/**
	 * @param categories the categories to set
	 */
	public void setCategories(List<String> categories) {
		this.categories = categories;
	}
}
