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
 * The Enum ImageSize.
 */
public enum ImageSize implements ValueEnum  {
	
	/** The ICON. */
	ICON("icon"), 
 
 /** The SMALL. */
 SMALL("small"), 
 
 /** The MEDIUM. */
 MEDIUM("medium"), 
 
 /** The LARGE. */
 LARGE("large"), 
 
 /** The XLARGE. */
 XLARGE("xlarge"), 
 
 /** The XXLARGE. */
 XXLARGE("xxlarge"), 
 
 /** The HUGE. */
 HUGE("huge");
	
    /** The Constant stringToEnum. */
	private static final Map<String, ImageSize> stringToEnum = new HashMap<String, ImageSize>();

	static { // Initialize map from constant name to enum constant
		for (ImageSize op : values()) {
			stringToEnum.put(op.value(), op);
		}
	}
	
    /** The value. */
    private final String value;
    
    /**
     * Instantiates a new image size.
     * 
     * @param value the value
     */
    ImageSize(String value) {
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
	 * @return the image size
	 */
	public static ImageSize fromValue(String value) {
		return stringToEnum.get(value);
	}

}
