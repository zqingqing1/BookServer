package com.bookme.bookme.dao;

import com.bookme.bookme.DataStore;
import com.bookme.bookme.entities.Bookmark;
import com.bookme.bookme.entities.UserBookmark;

public class BookMarkDao {
	public Bookmark[][] getBookmarks(){
		return DataStore.getBookmarks();
	}

	public void saveUserBookmark(UserBookmark userbookmark) {
		DataStore.add(userbookmark);
	}
}
