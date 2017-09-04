package com.bookme.bookme.controllers;

import com.bookme.bookme.entities.Bookmark;
import com.bookme.bookme.entities.User;
import com.bookme.bookme.managers.BookmarkManager;

public class BookmarkController {
	private static BookmarkController instance = new BookmarkController();
	private BookmarkController () {}
	
	public static BookmarkController getInstance(){
		return instance;
	}

	public void saveUserBookmark(User user, Bookmark bookmark) {
		BookmarkManager.getInstance().saveUserBookmark(user,bookmark);
		
	}

	public void setKidFriendlyStatus(User user,String kidFriendlyStatus, Bookmark b) {
		BookmarkManager.getInstance().setKidFriendlyStatus(user,kidFriendlyStatus,b);
		
	}

	public void share(User user, Bookmark b) {
		BookmarkManager.getInstance().share(user,b);
		
	}
	
}
