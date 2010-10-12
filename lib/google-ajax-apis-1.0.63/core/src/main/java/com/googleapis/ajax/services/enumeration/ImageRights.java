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
 * The Enum ImageRights.
 */
public enum ImageRights implements ValueEnum {
	
	/** The C c_ publicdomain. */
	CC_PUBLICDOMAIN("cc_publicdomain"), 
 
 /** The C c_ attribute. */
 CC_ATTRIBUTE("cc_attribute"), 
 
 /** The C c_ sharealike. */
 CC_SHAREALIKE("cc_sharealike"), 
 
 /** The C c_ noncommercial. */
 CC_NONCOMMERCIAL("cc_noncommercial"), 
 
 /** The C c_ nonderived. */
 CC_NONDERIVED("cc_nonderived");
	
    /** The Constant stringToEnum. */
	private static final Map<String, ImageRights> stringToEnum = new HashMap<String, ImageRights>();

	static { // Initialize map from constant name to enum constant
		for (ImageRights op : values()) {
			stringToEnum.put(op.value(), op);
		}
	}
	
    /** The value. */
    private final String value;
    
    /**
     * Instantiates a new image rights.
     * 
     * @param value the value
     */
    ImageRights(String value) {
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
	 * @return the image rights
	 */
	public static ImageRights fromValue(String value) {
		return stringToEnum.get(value);
	}

}
