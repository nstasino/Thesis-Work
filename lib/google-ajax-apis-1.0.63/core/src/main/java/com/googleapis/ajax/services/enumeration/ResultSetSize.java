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
package com.googleapis.ajax.services.enumeration;

import java.util.HashMap;
import java.util.Map;

import com.googleapis.ajax.common.ValueEnum;

/**
 * The Enum ResultSetSize.
 */
public enum ResultSetSize implements ValueEnum {
	
	/** The LARGE. */
	LARGE("large"), 
 
 /** The SMALL. */
 SMALL("small");
	
    /** The Constant stringToEnum. */
	private static final Map<String, ResultSetSize> stringToEnum = new HashMap<String, ResultSetSize>();

	static { // Initialize map from constant name to enum constant
		for (ResultSetSize op : values()) {
			stringToEnum.put(op.value(), op);
		}
	}
	
    /** The value. */
    private final String value;
    
    /**
     * Instantiates a new result set size.
     * 
     * @param value the value
     */
    ResultSetSize(String value) {
        this.value = value;
    }

	@Override
	public String value() {
		return value;
	}
	
	/**
	 * From value.
	 * 
	 * @param value the value
	 * 
	 * @return the result set size
	 */
	public static ResultSetSize fromValue(String value) {
		return stringToEnum.get(value);
	}
}
