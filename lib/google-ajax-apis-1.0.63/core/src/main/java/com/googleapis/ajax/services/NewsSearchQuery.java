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
package com.googleapis.ajax.services;

import com.googleapis.ajax.schema.NewsResult;
import com.googleapis.ajax.services.enumeration.NewsEdition;
import com.googleapis.ajax.services.enumeration.NewsSortOrder;
import com.googleapis.ajax.services.enumeration.NewsTopic;

/**
 * The Interface NewsSearchQuery.
 */
public interface NewsSearchQuery extends GoogleSearchQuery<NewsResult> {
	
	/**
	 * With order.
	 * 
	 * @param order the order
	 * 
	 * @return the news search query
	 */
	public NewsSearchQuery withOrder(NewsSortOrder order);
	
	/**
	 * With location.
	 * 
	 * @param location the location
	 * 
	 * @return the news search query
	 */
	public NewsSearchQuery withLocation(String location);
	
	/**
	 * With quote type id.
	 * 
	 * @param qsid the qsid
	 * 
	 * @return the news search query
	 */
	public NewsSearchQuery withQuoteTypeId(String qsid);
	
	/**
	 * With topic.
	 * 
	 * @param topic the topic
	 * 
	 * @return the news search query
	 */
	public NewsSearchQuery withTopic(NewsTopic topic);
	
	/**
	 * With edition.
	 * 
	 * @param edition the edition
	 * 
	 * @return the news search query
	 */
	public NewsSearchQuery withEdition(NewsEdition edition);
}
