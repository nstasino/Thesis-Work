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

import com.googleapis.ajax.schema.ImageResult;
import com.googleapis.ajax.services.enumeration.ImageColor;
import com.googleapis.ajax.services.enumeration.ImageColorization;
import com.googleapis.ajax.services.enumeration.ImageFileType;
import com.googleapis.ajax.services.enumeration.ImageRights;
import com.googleapis.ajax.services.enumeration.ImageSize;
import com.googleapis.ajax.services.enumeration.ImageType;
import com.googleapis.ajax.services.enumeration.SafetyLevel;

/**
 * The Interface ImageSearchQuery.
 */
public interface ImageSearchQuery extends GoogleSearchQuery<ImageResult> {
	
	/**
	 * With safety level.
	 * 
	 * @param safe the safe
	 * 
	 * @return the image search query
	 */
	public ImageSearchQuery withSafetyLevel(SafetyLevel safe);
	
	/**
	 * With image size.
	 * 
	 * @param imgsz the imgsz
	 * 
	 * @return the image search query
	 */
	public ImageSearchQuery withImageSize(ImageSize imgsz);
	
	/**
	 * With image colorization.
	 * 
	 * @param colorization the colorization
	 * 
	 * @return the image search query
	 */
	public ImageSearchQuery withImageColorization(ImageColorization colorization);
	
	/**
	 * With image color.
	 * 
	 * @param color the color
	 * 
	 * @return the image search query
	 */
	public ImageSearchQuery withImageColor(ImageColor color);
	
	/**
	 * With image type.
	 * 
	 * @param type the type
	 * 
	 * @return the image search query
	 */
	public ImageSearchQuery withImageType(ImageType type);
	
	/**
	 * With file type.
	 * 
	 * @param fileType the file type
	 * 
	 * @return the image search query
	 */
	public ImageSearchQuery withFileType(ImageFileType fileType);
	
	/**
	 * With image rights.
	 * 
	 * @param rights the rights
	 * 
	 * @return the image search query
	 */
	public ImageSearchQuery withImageRights(ImageRights rights);
}
