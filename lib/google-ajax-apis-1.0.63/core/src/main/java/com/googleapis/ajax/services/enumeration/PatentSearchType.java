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
 * The Enum PatentSearchType.
 */
public enum PatentSearchType implements ValueEnum {
	
	/** The ALL. */
	ALL(null), 
 
 /** The FILED. */
 FILED("as_psra"), 
 
 /** The ISSUED. */
 ISSUED("as_psrg");
	
    /** The Constant stringToEnum. */
	private static final Map<String, PatentSearchType> stringToEnum = new HashMap<String, PatentSearchType>();

	static { // Initialize map from constant name to enum constant
		for (PatentSearchType op : values()) {
			stringToEnum.put(op.value(), op);
		}
	}
	
    /** The value. */
    private final String value;
    
    /**
     * Instantiates a new patent search type.
     * 
     * @param value the value
     */
    PatentSearchType(String value) {
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
	 * @return the patent search type
	 */
	public static PatentSearchType fromValue(String value) {
		return stringToEnum.get(value);
	}

}
