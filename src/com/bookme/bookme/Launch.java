package com.bookme.bookme;

import com.bookme.bookme.entities.Bookmark;
import com.bookme.bookme.entities.User;
import com.bookme.bookme.managers.BookmarkManager;
import com.bookme.bookme.managers.UserManager;

public class Launch {
	private static User[] users;
	private static Bookmark[][] bookmarks;
	
	private static void loadData() {

		System.out.println("1. Loading Data....");
		DataStore.loadData();
		
		users=UserManager.getInstance().getUsers();
		bookmarks=BookmarkManager.getInstance().getBookmarks();
		
//		System.out.println("Printing data...");
//		printUserData();
//		printBookmarkData();
	
	}
//	private static void printBookmarkData() {
//		for(Bookmark[] b:bookmarks)
//			for(Bookmark bk:b)
//				System.out.println(bk);
//		
//	}
//	private static void printUserData() {
//		for(User u:users)
//			System.out.println(u);
//		
//	}
	
//	private static void startBookmarking() {
//		System.out.println("\n2. Bookmarking....");
//		for(User user:users){
//			View.bookmark(user, bookmarks);
//		}
//		
//	}
	
	private static void startBroswe() {
		//System.out.println("\n2. Bookmarking....");
		for(User user:users){
			View.broswe(user, bookmarks);
		}
		
	}
	
	
	
	public static void main(String[] args) {
		loadData();
		//startBookmarking();
		startBroswe();

	}
	



}
