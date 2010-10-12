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
package com.googleapis.ajax.common;

import java.util.ArrayList;
import java.util.List;


/**
 * The Class PagedArrayList.
 */
public class PagedArrayList<E> extends ArrayList<E> implements PagedList<E> {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 5011544152511118680L;
	
	private Cursor cursor = new Cursor();
	
	/**
	 * @return the cursor
	 */
	public Cursor getCursor() {
		return cursor;
	}
	/**
	 * @param cursor the cursor to set
	 */
	public void setCursor(Cursor cursor) {
		this.cursor = cursor;
	}
	/**
	 * @return the pages
	 */
	public List<Page> getPages() {
		return cursor.getPages();
	}
	/**
	 * @return the estimatedResultCount
	 */
	public long getEstimatedResultCount() {
		return cursor.getEstimatedResultCount();
	}
	/**
	 * @return the currentPageIndex
	 */
	public int getCurrentPageIndex() {
		return cursor.getCurrentPageIndex();
	}
	/**
	 * @return the moreResultsUrl
	 */
	public String getMoreResultsUrl() {
		return cursor.getMoreResultsUrl();
	}
	
	public static class Cursor {
		private List<Page> pages = new ArrayList<Page>();
		
		private long estimatedResultCount;
		private int currentPageIndex;
		private String moreResultsUrl;
		
		/**
		 * @return the pages
		 */
		public List<Page> getPages() {
			return pages;
		}
		/**
		 * @param pages the pages to set
		 */
		public void setPages(List<Page> pages) {
			this.pages = pages;
		}
		/**
		 * @return the estimatedResultCount
		 */
		public long getEstimatedResultCount() {
			return estimatedResultCount;
		}
		/**
		 * @param estimatedResultCount the estimatedResultCount to set
		 */
		public void setEstimatedResultCount(long estimatedResultCount) {
			this.estimatedResultCount = estimatedResultCount;
		}
		/**
		 * @return the currentPageIndex
		 */
		public int getCurrentPageIndex() {
			return currentPageIndex;
		}
		/**
		 * @param currentPageIndex the currentPageIndex to set
		 */
		public void setCurrentPageIndex(int currentPageIndex) {
			this.currentPageIndex = currentPageIndex;
		}
		/**
		 * @return the moreResultsUrl
		 */
		public String getMoreResultsUrl() {
			return moreResultsUrl;
		}
		/**
		 * @param moreResultsUrl the moreResultsUrl to set
		 */
		public void setMoreResultsUrl(String moreResultsUrl) {
			this.moreResultsUrl = moreResultsUrl;
		}
	}
}
