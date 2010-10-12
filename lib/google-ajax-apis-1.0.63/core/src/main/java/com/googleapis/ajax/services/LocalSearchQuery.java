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

import com.googleapis.ajax.schema.LocalResult;
import com.googleapis.ajax.services.enumeration.LocalSearchType;

/**
 * The Interface LocalSearchQuery.
 */
public interface LocalSearchQuery extends GoogleSearchQuery<LocalResult> {
	
	/**
	 * With location.
	 * 
	 * @param latitude the latitude
	 * @param longitude the longitude
	 * 
	 * @return the local search query
	 */
	public LocalSearchQuery withLocation(double latitude, double longitude);
	
	/**
	 * With bounding box.
	 * 
	 * @param x the x
	 * @param y the y
	 * 
	 * @return the local search query
	 */
	public LocalSearchQuery withBoundingBox(double x, double y);
	
	/**
	 * With local search type.
	 * 
	 * @param type the type
	 * 
	 * @return the local search query
	 */
	public LocalSearchQuery withLocalSearchType(LocalSearchType type);


}
