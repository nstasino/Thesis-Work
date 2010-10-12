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

import java.util.HashMap;
import java.util.Map;

import com.googleapis.ajax.common.ValueEnum;

/**
 * The Enum ImageSize.
 */
public enum Language implements ValueEnum  {
	
	AFRIKAANS("af", true, false, false),
	ALBANIAN("sq", true, false, false),
	AMHARIC("am", false, true, false),
	ARABIC("ar", true, true, true),
	ARMENIAN("hy", false, false, false),
	AZERBAIJANI("az", false, false, false),
	BASQUE("eu", false, false, false),
	BELARUSIAN("be", true, false, false),
	BENGALI("bn", false, true, false),
	BIHARI("bh", false, false, false),
	BRETON("br", false, false, false),
	BULGARIAN("bg", true, false, false),
	BURMESE("my", false, false, false),
	CATALAN("ca", true, false, false),
	CHEROKEE("chr", false, false, false),
	CHINESE("zh", true, false, false),
	CHINESE_SIMPLIFIED("zh-CN", true, false, false),
	CHINESE_TRADITIONAL("zh-TW", true, false, false),
	CORSICAN("co", false, false, false),
	CROATIAN("hr", true, false, false),
	CZECH("cs", true, false, false),
	DANISH("da", true, false, false),
	DHIVEHI("dv", false, false, false),
	DUTCH("nl", true, false, false),  
	ENGLISH("en", true, false, false),
	ESPERANTO("eo", false, false, false),
	ESTONIAN("et", true, false, false),
	FAROESE("fo", false, false, false),
	FILIPINO("tl", true, false, false),
	FINNISH("fi", true, false, false),
	FRENCH("fr", true, false, false),
	FRISIAN("fy", false, false, false),
	GALICIAN("gl", true, false, false),
	GEORGIAN("ka", false, false, false),
	GERMAN("de", true, false, false),
	GREEK("el", true, true, false),
	GUJARATI("gu", false, true, false),
	HAITIAN_CREOLE("ht", true, false, false),
	HEBREW("iw", true, false, false),
	HINDI("hi", true, true, false),
	HUNGARIAN("hu", true, false, false),
	ICELANDIC("is", true, false, false),
	INDONESIAN("id", true, false, false),
	INUKTITUT("iu", false, false, false),
	IRISH("ga", true, false, false),
	ITALIAN("it", true, false, false),
	JAPANESE("ja", true, false, false),
	JAVANESE("jw", false, false, false),
	KANNADA("kn", false, true, false),
	KAZAKH("kk", false, false, false),
	KHMER("km", false, false, false),
	KOREAN("ko", true, false, false),
	KURDISH("ku", false, false, false),
	KYRGYZ("ky", false, false, false),
	LAO("lo", false, false, false),
	LATIN("la", false, false, false),
	LATVIAN("lv", true, false, false),
	LITHUANIAN("lt", true, false, false),
	LUXEMBOURGISH("lb", false, false, false),
	MACEDONIAN("mk", true, false, false),
	MALAY("ms", true, false, false),
	MALAYALAM("ml", false, true, false),
	MALTESE("mt", true, false, false),
	MAORI("mi", false, false, false),
	MARATHI("mr", false, true, false),
	MONGOLIAN("mn", false, false, false),
	NEPALI("ne", false, true, false),
	NORWEGIAN("no", true, false, false),
	OCCITAN("oc", false, false, false),
	ORIYA("or", false, false, false),
	PASHTO("ps", false, false, false),
	PERSIAN("fa", true, true, false),
	POLISH("pl", true, false, false),
	PORTUGUESE("pt", true, false, false),
	PORTUGUESE_PORTUGAL("pt-PT", true, false, false),
	PUNJABI("pa", false, true, false),
	QUECHUA("qu", false, false, false),
	ROMANIAN("ro", true, false, false),
	RUSSIAN("ru", true, true, false),
	SANSKRIT("sa", false, true, false),
	SCOTS_GAELIC("gd", false, false, false),
	SERBIAN("sr", true, true, false),
	SINDHI("sd", false, false, false),
	SINHALESE("si", false, false, false),
	SLOVAK("sk", true, false, false),
	SLOVENIAN("sl", true, false, false),
	SPANISH("es", true, false, false),
	SUNDANESE("su", false, false, false),
	SWAHILI("sw", true, false, false),
	SWEDISH("sv", true, false, false),
	SYRIAC("syr", false, false, false),
	TAJIK("tg", false, false, false),
	TAMIL("ta", false, true, false),
	TATAR("tt", false, false, false),
	TELUGU("te", false, true, false),
	THAI("th", true, false, false),
	TIBETAN("bo", false, false, false),
	TONGA("to", false, false, false),
	TURKISH("tr", true, false, false),
	UKRAINIAN("uk", true, false, false),
	URDU("ur", false, true, false),
	UZBEK("uz", false, false, false),
	UIGHUR("ug", false, false, false),
	VIETNAMESE("vi", true, false, false),
	WELSH("cy", true, false, false),
	YIDDISH("yi", true, false, false),
	YORUBA("yo", false, false, false),
	UNKNOWN("", false, false, false);
	
    /** The Constant stringToEnum. */
	private static final Map<String, Language> stringToEnum = new HashMap<String, Language>();

	static { // Initialize map from constant name to enum constant
		for (Language op : values()) {
			stringToEnum.put(op.value(), op);
		}
	}
	
    /** The value. */
    private final String value;
    
    /** The value. */
    private final boolean supportsTranslation;
    
    private final boolean supportsTransliteration;
    private final boolean supportsDiacritization;
    
    /**
     * Instantiates a new image size.
     * 
     * @param value the value
     */
    Language(String value, boolean supportsTranslation, boolean supportsTransliteration, boolean supportsDiacritization) {
        this.value = value;
        this.supportsTranslation = supportsTranslation;
        this.supportsTransliteration = supportsTransliteration;
        this.supportsDiacritization = supportsDiacritization;
    }

	@Override
	public String value() {
		return value;
	}
	
	public boolean supportsTranslation() {
		return supportsTranslation;
	}
	
	public boolean supportsTransliteration() {
		return supportsTransliteration;
	}
	
	public boolean supportsDiacritization() {
		return supportsDiacritization;
	}
	
	/**
	 * From value.
	 * 
	 * @param value the value
	 * 
	 * @return the image size
	 */
	public static Language fromValue(String value) {
		return stringToEnum.get(value);
	}
}
