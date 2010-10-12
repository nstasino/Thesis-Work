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

import com.googleapis.ajax.schema.PatentResult;
import com.googleapis.ajax.services.enumeration.PatentSearchType;
import com.googleapis.ajax.services.enumeration.PatentSortOrder;

/**
 * The Interface PatentSearchQuery.
 */
public interface PatentSearchQuery extends GoogleSearchQuery<PatentResult> {
	
	/**
	 * With search type.
	 * 
	 * @param type the type
	 * 
	 * @return the patent search query
	 */
	public PatentSearchQuery withSearchType(PatentSearchType type);
	
	/**
	 * With order.
	 * 
	 * @param order the order
	 * 
	 * @return the patent search query
	 */
	public PatentSearchQuery withOrder(PatentSortOrder order);
	
}
