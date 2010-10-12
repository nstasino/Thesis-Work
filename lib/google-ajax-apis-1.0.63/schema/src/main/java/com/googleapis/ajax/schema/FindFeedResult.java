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

import java.util.List;


/**
 * The Class WebResult.
 */
public class FindFeedResult extends SchemaEntity {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -8535742587293626160L;
	
	private String query;
	
	private List<FeedEntry> entries;
	
	/**
	 * @return the query
	 */
	public String getQuery() {
		return query;
	}
	/**
	 * @param query the query to set
	 */
	public void setQuery(String query) {
		this.query = query;
	}
	/**
	 * @return the entries
	 */
	public List<FeedEntry> getEntries() {
		return entries;
	}
	/**
	 * @param entries the entries to set
	 */
	public void setEntries(List<FeedEntry> entries) {
		this.entries = entries;
	}
}
