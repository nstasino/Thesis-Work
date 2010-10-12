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

import com.googleapis.ajax.schema.BlogResult;
import com.googleapis.ajax.services.enumeration.BlogSortOrder;

/**
 * The Interface BlogSearchQuery.
 */
public interface BlogSearchQuery extends GoogleSearchQuery<BlogResult> {
	
	/**
	 * With order.
	 * 
	 * @param order the order
	 * 
	 * @return the blog search query
	 */
	public BlogSearchQuery withOrder(BlogSortOrder order);

}
