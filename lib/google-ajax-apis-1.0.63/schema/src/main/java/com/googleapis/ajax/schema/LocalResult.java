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

import java.util.List;


/**
 * The Class LocalResult.
 */
public class LocalResult extends SchemaEntity {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 6016892309811530169L;
	
	/** The title. */
	private String title;
	
	/** The title no formatting. */
	private String titleNoFormatting;
	
	/** The url. */
	private String url;
	
	/** The lat. */
	private double lat;
	
	/** The lng. */
	private double lng;
	
	/** The street address. */
	private String streetAddress;
	
	/** The city. */
	private String city;
	
	/** The region. */
	private String region;
	
	/** The country. */
	private String country;
	
	/** The phone numbers. */
	private List<PhoneNumber> phoneNumbers;
	
	/** The address lines. */
	private List<String> addressLines;
	
	/** The dd url. */
	private String ddUrl;
	
	/** The dd url to here. */
	private String ddUrlToHere;
	
	/** The dd url from here. */
	private String ddUrlFromHere;
	
	/** The static map url. */
	private String staticMapUrl;
	
	/** The listing type. */
	private ListingType listingType;
	
	/** The content. */
	private String content;
	
	/** The max age. */
	private long maxAge;
	
	/** The accuracy. */
	private int accuracy;
	
	/** The viewportmode. */
	private ViewPortMode viewportmode;
	
	/**
	 * Gets the title.
	 * 
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	
	/**
	 * Sets the title.
	 * 
	 * @param title the new title
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	
	/**
	 * Gets the title no formatting.
	 * 
	 * @return the title no formatting
	 */
	public String getTitleNoFormatting() {
		return titleNoFormatting;
	}
	
	/**
	 * Sets the title no formatting.
	 * 
	 * @param titleNoFormatting the new title no formatting
	 */
	public void setTitleNoFormatting(String titleNoFormatting) {
		this.titleNoFormatting = titleNoFormatting;
	}
	
	/**
	 * Gets the url.
	 * 
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}
	
	/**
	 * Sets the url.
	 * 
	 * @param url the new url
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	
	/**
	 * Gets the lat.
	 * 
	 * @return the lat
	 */
	public double getLat() {
		return lat;
	}
	
	/**
	 * Sets the lat.
	 * 
	 * @param lat the new lat
	 */
	public void setLat(double lat) {
		this.lat = lat;
	}
	
	/**
	 * Gets the lng.
	 * 
	 * @return the lng
	 */
	public double getLng() {
		return lng;
	}
	
	/**
	 * Sets the lng.
	 * 
	 * @param lng the new lng
	 */
	public void setLng(double lng) {
		this.lng = lng;
	}
	
	/**
	 * Gets the street address.
	 * 
	 * @return the street address
	 */
	public String getStreetAddress() {
		return streetAddress;
	}
	
	/**
	 * Sets the street address.
	 * 
	 * @param streetAddress the new street address
	 */
	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}
	
	/**
	 * Gets the city.
	 * 
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	
	/**
	 * Sets the city.
	 * 
	 * @param city the new city
	 */
	public void setCity(String city) {
		this.city = city;
	}
	
	/**
	 * Gets the region.
	 * 
	 * @return the region
	 */
	public String getRegion() {
		return region;
	}
	
	/**
	 * Sets the region.
	 * 
	 * @param region the new region
	 */
	public void setRegion(String region) {
		this.region = region;
	}
	
	/**
	 * Gets the country.
	 * 
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}
	
	/**
	 * Sets the country.
	 * 
	 * @param country the new country
	 */
	public void setCountry(String country) {
		this.country = country;
	}
	
	/**
	 * Gets the phone numbers.
	 * 
	 * @return the phone numbers
	 */
	public List<PhoneNumber> getPhoneNumbers() {
		return phoneNumbers;
	}
	
	/**
	 * Sets the phone numbers.
	 * 
	 * @param phoneNumbers the new phone numbers
	 */
	public void setPhoneNumbers(List<PhoneNumber> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}
	
	/**
	 * Gets the address lines.
	 * 
	 * @return the address lines
	 */
	public List<String> getAddressLines() {
		return addressLines;
	}
	
	/**
	 * Sets the address lines.
	 * 
	 * @param addressLines the new address lines
	 */
	public void setAddressLines(List<String> addressLines) {
		this.addressLines = addressLines;
	}
	
	/**
	 * Gets the dd url.
	 * 
	 * @return the dd url
	 */
	public String getDdUrl() {
		return ddUrl;
	}
	
	/**
	 * Sets the dd url.
	 * 
	 * @param ddUrl the new dd url
	 */
	public void setDdUrl(String ddUrl) {
		this.ddUrl = ddUrl;
	}
	
	/**
	 * Gets the dd url to here.
	 * 
	 * @return the dd url to here
	 */
	public String getDdUrlToHere() {
		return ddUrlToHere;
	}
	
	/**
	 * Sets the dd url to here.
	 * 
	 * @param ddUrlToHere the new dd url to here
	 */
	public void setDdUrlToHere(String ddUrlToHere) {
		this.ddUrlToHere = ddUrlToHere;
	}
	
	/**
	 * Gets the dd url from here.
	 * 
	 * @return the dd url from here
	 */
	public String getDdUrlFromHere() {
		return ddUrlFromHere;
	}
	
	/**
	 * Sets the dd url from here.
	 * 
	 * @param ddUrlFromHere the new dd url from here
	 */
	public void setDdUrlFromHere(String ddUrlFromHere) {
		this.ddUrlFromHere = ddUrlFromHere;
	}
	
	/**
	 * Gets the static map url.
	 * 
	 * @return the static map url
	 */
	public String getStaticMapUrl() {
		return staticMapUrl;
	}
	
	/**
	 * Sets the static map url.
	 * 
	 * @param staticMapUrl the new static map url
	 */
	public void setStaticMapUrl(String staticMapUrl) {
		this.staticMapUrl = staticMapUrl;
	}
	
	/**
	 * Gets the listing type.
	 * 
	 * @return the listing type
	 */
	public ListingType getListingType() {
		return listingType;
	}
	
	/**
	 * Sets the listing type.
	 * 
	 * @param listingType the new listing type
	 */
	public void setListingType(ListingType listingType) {
		this.listingType = listingType;
	}
	
	/**
	 * Gets the content.
	 * 
	 * @return the content
	 */
	public String getContent() {
		return content;
	}
	
	/**
	 * Sets the content.
	 * 
	 * @param content the new content
	 */
	public void setContent(String content) {
		this.content = content;
	}
	
	/**
	 * Gets the max age.
	 * 
	 * @return the max age
	 */
	public long getMaxAge() {
		return maxAge;
	}
	
	/**
	 * Sets the max age.
	 * 
	 * @param maxAge the new max age
	 */
	public void setMaxAge(long maxAge) {
		this.maxAge = maxAge;
	}
	
	/**
	 * Gets the accuracy.
	 * 
	 * @return the accuracy
	 */
	public int getAccuracy() {
		return accuracy;
	}
	
	/**
	 * Sets the accuracy.
	 * 
	 * @param accuracy the new accuracy
	 */
	public void setAccuracy(int accuracy) {
		this.accuracy = accuracy;
	}
	
	/**
	 * Gets the viewportmode.
	 * 
	 * @return the viewportmode
	 */
	public ViewPortMode getViewportmode() {
		return viewportmode;
	}
	
	/**
	 * Sets the viewportmode.
	 * 
	 * @param viewportmode the new viewportmode
	 */
	public void setViewportmode(ViewPortMode viewportmode) {
		this.viewportmode = viewportmode;
	}
}
