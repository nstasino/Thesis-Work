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
package com.googleapis.ajax.services.search;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.googleapis.ajax.common.PagedList;
import com.googleapis.ajax.schema.BlogResult;
import com.googleapis.ajax.schema.BookResult;
import com.googleapis.ajax.schema.DetectLanguageResult;
import com.googleapis.ajax.schema.FindFeedResult;
import com.googleapis.ajax.schema.ImageResult;
import com.googleapis.ajax.schema.Language;
import com.googleapis.ajax.schema.LoadFeedResult;
import com.googleapis.ajax.schema.LocalResult;
import com.googleapis.ajax.schema.LookupFeedResult;
import com.googleapis.ajax.schema.NewsResult;
import com.googleapis.ajax.schema.PatentResult;
import com.googleapis.ajax.schema.TranslateLanguageResult;
import com.googleapis.ajax.schema.VideoResult;
import com.googleapis.ajax.schema.WebResult;
import com.googleapis.ajax.services.BlogSearchQuery;
import com.googleapis.ajax.services.BookSearchQuery;
import com.googleapis.ajax.services.DetectLanguageQuery;
import com.googleapis.ajax.services.FindFeedQuery;
import com.googleapis.ajax.services.GoogleSearchQueryFactory;
import com.googleapis.ajax.services.ImageSearchQuery;
import com.googleapis.ajax.services.LoadFeedQuery;
import com.googleapis.ajax.services.LocalSearchQuery;
import com.googleapis.ajax.services.LookupFeedQuery;
import com.googleapis.ajax.services.NewsSearchQuery;
import com.googleapis.ajax.services.PatentSearchQuery;
import com.googleapis.ajax.services.TranslateLanguageQuery;
import com.googleapis.ajax.services.VideoSearchQuery;
import com.googleapis.ajax.services.WebSearchQuery;
import com.googleapis.ajax.services.constant.TestConstants;

/**
 * The Class GoogleSearchJsonQueryTest.
 */
public class GoogleSearchJsonQueryTest extends BaseGoogleSearchClientTest {
	
	/** The factory. */
	private GoogleSearchQueryFactory factory;
	

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	@Before
	public void setUp() throws Exception {
		factory = GoogleSearchQueryFactory.newInstance(TestConstants.TEST_API_KEY);
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#tearDown()
	 */
	@After
	public void tearDown() throws Exception {
		factory = null;
	}

	/**
	 * Test search blogs.
	 */
	@Test
	public void testSearchBlogs() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Query."), TestConstants.TEST_QUERY);
		BlogSearchQuery query = factory.newBlogSearchQuery();
		PagedList<BlogResult> result = query.withQuery(TestConstants.TEST_QUERY).list();
		assertNotNullOrEmpty("Search result should not be null or empty.", result);
	}
	
	/**
	 * Test search books.
	 */
	@Test
	public void testSearchBooks() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Query."), TestConstants.TEST_QUERY);
		BookSearchQuery query = factory.newBookSearchQuery();
		PagedList<BookResult> result = query.withQuery(TestConstants.TEST_QUERY).list();
		assertNotNullOrEmpty("Search result should not be null or empty.", result);
	}
	
	/**
	 * Test search images.
	 */
	@Test
	public void testSearchImages() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Query."), TestConstants.TEST_QUERY);
		ImageSearchQuery query = factory.newImageSearchQuery();
		PagedList<ImageResult> result = query.withQuery(TestConstants.TEST_QUERY).list();
		assertNotNullOrEmpty("Search result should not be null or empty.", result);
	}
	
	/**
	 * Test search local.
	 */
	@Test
	public void testSearchLocal() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Query."), TestConstants.TEST_QUERY);
		LocalSearchQuery query = factory.newLocalSearchQuery();
		PagedList<LocalResult> result = query.withQuery(TestConstants.TEST_QUERY).list();
		assertNotNullOrEmpty("Search result should not be null or empty.", result);
	}
	
	/**
	 * Test search news.
	 */
	@Test
	public void testSearchNews() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Query."), TestConstants.TEST_QUERY);
		NewsSearchQuery query = factory.newNewsSearchQuery();
		PagedList<NewsResult> result = query.withQuery(TestConstants.TEST_QUERY).list();
		assertNotNullOrEmpty("Search result should not be null or empty.", result);
	}
	
	/**
	 * Test search patents.
	 */
	@Test
	public void testSearchPatents() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Query."), TestConstants.TEST_QUERY);
		PatentSearchQuery query = factory.newPatentSearchQuery();
		PagedList<PatentResult> result = query.withQuery(TestConstants.TEST_QUERY).list();
		assertNotNullOrEmpty("Search result should not be null or empty.", result);
	}
	
	/**
	 * Test search videos.
	 */
	@Test
	public void testSearchVideos() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Query."), TestConstants.TEST_QUERY);
		VideoSearchQuery query = factory.newVideoSearchQuery();
		PagedList<VideoResult> result = query.withQuery(TestConstants.TEST_QUERY).list();
		assertNotNullOrEmpty("Search result should not be null or empty.", result);
	}
	
	/**
	 * Test search web.
	 */
	@Test
	public void testSearchWeb() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Query."), TestConstants.TEST_QUERY);
		WebSearchQuery query = factory.newWebSearchQuery();
		PagedList<WebResult> result = query.withQuery(TestConstants.TEST_QUERY).list();
		assertNotNullOrEmpty("Search result should not be null or empty.", result);
	}
	
	/**
	 * Test detect language.
	 */
	@Test
	public void testDetectLanguage() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Query."), TestConstants.TEST_QUERY);
		DetectLanguageQuery query = factory.newDetectLanguageQuery();
		DetectLanguageResult result = query.withQuery(TestConstants.TEST_QUERY).singleResult();
		assertNotNull("Search result should not be null or empty.", result);
	}

	/**
	 * Test translate language.
	 */
	@Test
	public void testTranslateLanguage() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Query."), TestConstants.TEST_QUERY);
		TranslateLanguageQuery query = factory.newTranslateLanguageQuery();
		TranslateLanguageResult result = query.withLanguagePair(null, Language.GERMAN).withQuery(TestConstants.TEST_QUERY).singleResult();
		assertNotNull("Search result should not be null or empty.", result);
	}
	
	@Test
	public void testFindLookupAndLoadFeed() {
    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Query."), TestConstants.TEST_QUERY);
		FindFeedQuery findQuery = factory.newFindFeedQuery();
		FindFeedResult findResult = findQuery.withQuery(TestConstants.TEST_QUERY).singleResult();
		assertNotNull("Find result should not be null or empty.", findResult);
		assertNotNull("Find result should not be null or empty.", findResult.getEntries());
    	LookupFeedQuery lookupQuery = factory.newLookupFeedQuery();
		LookupFeedResult lookupResult = lookupQuery.withQuery(findResult.getEntries().get(0).getLink()).singleResult();
		assertNotNull("Lookup result should not be null or empty.", lookupResult);
		LoadFeedQuery loadQuery = factory.newLoadFeedQuery();
		LoadFeedResult loadResult = loadQuery.withQuery(lookupResult.getUrl()).singleResult();
		assertNotNull("Load result should not be null or empty.", loadResult);
		assertNotNull("Load result should not be null or empty.", loadResult.getEntries());
	}
	
//	@Test
//	public void testLoadFeed() {
//    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Query."), TestConstants.TEST_QUERY);
//		LoadFeedQuery query = factory.newLoadFeedQuery();
//		LoadFeedResult result = query.withQuery(TestConstants.TEST_QUERY).singleResult();
//		assertNotNull("Search result should not be null or empty.", result);
//		assertNotNull("Search result should not be null or empty.", result.getEntries());
//	}
//	@Test
//	public void testFindFeed() {
//    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Query."), TestConstants.TEST_QUERY);
//		FindFeedQuery query = factory.newFindFeedQuery();
//		FindFeedResult result = query.withQuery(TestConstants.TEST_QUERY).singleResult();
//		assertNotNull("Search result should not be null or empty.", result);
//		assertNotNull("Search result should not be null or empty.", result.getEntries());
//	}
//	@Test
//	public void testLookupFeed() {
//    	assertNotNullOrEmpty(String.format(RESOURCE_MISSING_MESSAGE, "Test Query."), TestConstants.TEST_QUERY);
//    	LookupFeedQuery query = factory.newLookupFeedQuery();
//		LookupFeedResult result = query.withQuery(TestConstants.TEST_QUERY).singleResult();
//		assertNotNull("Search result should not be null or empty.", result);
//	}
}
