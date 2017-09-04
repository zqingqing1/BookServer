package com.bookme.bookme.entities;

import static org.junit.Assert.*;

import org.junit.Test;

import com.bookme.bookme.managers.BookmarkManager;

public class WebLinkTest {

	@Test
	public void testIsKidFriendlyEligible() {
		//Test 1: porn in url --false
		WebLink weblink = BookmarkManager.getInstance().createWebLink(2000,"Taming Tiger, Part 2",null,"http://www.javaworld.com/article/2072759/core-java/taming-porn--part-2.html","http://www.javaworld.com");
		
		boolean isKidFriendlyEligible= weblink.isKidFriendlyEligible();
		
		assertFalse("should return false", isKidFriendlyEligible);
		
		// Test 2 : porn in title --false
		
		// Test 3: audit in host -- false
		
		// Test 4: audlt in url but not in host -- true
		
		// Test 5: audit in title only -- true
		
	}

}
