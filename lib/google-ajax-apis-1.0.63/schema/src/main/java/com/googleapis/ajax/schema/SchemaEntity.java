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

import java.io.Serializable;
import java.util.logging.Logger;


/**
 * The Class SchemaEntity.
 */
public abstract class SchemaEntity implements Serializable {

	/** The logger. */
    protected final Logger logger = Logger.getLogger(getClass().getCanonicalName());
	
	/** The gsearch result class. */
	private GsearchResultClass GsearchResultClass;

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 250056223059654638L;
	
	/**
	 * Gets the gsearch result class.
	 * 
	 * @return the gsearch result class
	 */
	public GsearchResultClass getGsearchResultClass() {
		return GsearchResultClass;
	}

	/**
	 * Sets the gsearch result class.
	 * 
	 * @param gsearchResultClass the new gsearch result class
	 */
	public void setGsearchResultClass(GsearchResultClass gsearchResultClass) {
		this.GsearchResultClass = gsearchResultClass;
	}
}
