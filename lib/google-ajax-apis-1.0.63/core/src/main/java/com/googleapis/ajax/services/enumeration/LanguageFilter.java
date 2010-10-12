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
public enum LanguageFilter implements ValueEnum  {
	
	Arabic ("lang_ar"),
	Bulgarian ("lang_bg"),
	Catalan ("lang_ca"),
	Chinese_Simplified ("lang_zh-CN"),
	Chinese_Traditional ("lang_zh-TW"),
	Croation ("lang_hr"),
	Czech ("lang_cs"),
	Danish ("lang_da"),
	Dutch ("lang_nl"),
	English ("lang_en"),
	Estonian ("lang_et"),
	Finnish ("lang_fi"),
	French ("lang_fr"),
	German ("lang_de"),
	Greek ("lang_el"),
	Hebrew ("lang_iw"),
	Hungarian ("lang_hu"),
	Icelandic ("lang_is"),
	Indonesian ("lang_id"),
	Italian ("lang_it"),
	Japanese ("lang_ja"),
	Korean ("lang_ko"),
	Latvian ("lang_lv"),
	Lithuanian ("lang_lt"),
	Norwegian ("lang_no"),
	Polish ("lang_pl"),
	Portuguese ("lang_pt"),
	Romanian ("lang_ro"),
	Russian ("lang_ru"),
	Serbian ("lang_sr"),
	Slovak ("lang_sk"),
	Slovenian ("lang_sl"),
	Spanish ("lang_es"),
	Swedish ("lang_sv"),
	Turkish ("lang_tr");
	
    /** The Constant stringToEnum. */
	private static final Map<String, LanguageFilter> stringToEnum = new HashMap<String, LanguageFilter>();

	static { // Initialize map from constant name to enum constant
		for (LanguageFilter op : values()) {
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
    LanguageFilter(String value) {
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
	public static LanguageFilter fromValue(String value) {
		return stringToEnum.get(value);
	}

}
