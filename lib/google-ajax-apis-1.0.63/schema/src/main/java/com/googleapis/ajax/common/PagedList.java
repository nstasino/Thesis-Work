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

import java.util.List;

/**
 * The Interface PagedList.
 */
public interface PagedList<E> extends List<E> {
	public class Page {
		private int start;
		private int label;
		
		/**
		 * @return the start
		 */
		public int getStart() {
			return start;
		}
		/**
		 * @param start the start to set
		 */
		public void setStart(int start) {
			this.start = start;
		}
		/**
		 * @return the label
		 */
		public int getLabel() {
			return label;
		}
		/**
		 * @param label the label to set
		 */
		public void setLabel(int label) {
			this.label = label;
		}

		@Override
		public String toString() {
			return "Page [label=" + label + ", start=" + start + "]";
		}
	}
	
	
	/**
	 * @return the pages
	 */
	public List<Page> getPages();
	
	/**
	 * @return the estimatedResultCount
	 */
	public long getEstimatedResultCount();
	
	/**
	 * @return the currentPageIndex
	 */
	public int getCurrentPageIndex();
	
	/**
	 * @return the moreResultsUrl
	 */
	public String getMoreResultsUrl();
}
