package com.bookme.bookme;

import com.bookme.bookme.contants.KidFriendlyStatus;
import com.bookme.bookme.contants.UserType;
import com.bookme.bookme.controllers.BookmarkController;
import com.bookme.bookme.entities.Bookmark;
import com.bookme.bookme.entities.User;
import com.bookme.bookme.partner.Shareable;

public class View {

	public static void broswe(User user, Bookmark[][] bookmarks) {
		System.out.println("\n" + user.getEmail() + " is broswing");
		int bookmarkCount = 0;

		for (Bookmark[] list : bookmarks) {
			for (Bookmark b : list) {
				if (bookmarkCount < DataStore.USER_BOOKMARK_LIMIT) {
					if (getBookmarkDecision(b)) {
						bookmarkCount++;
						BookmarkController.getInstance().saveUserBookmark(user, b);

						System.out.println("booked: " + b);
					}

					
					if (user.getUserType().equals(UserType.EDITOR)
							|| user.getUserType().equals(UserType.CHIEF_EDITOR)) {
						
						// mark as kid-friendly
						if (b.isKidFriendlyEligible() && b.getKidFriendlyStatus().equals(KidFriendlyStatus.UNKNOWN)) {
							String kidFriendlyStatus= getKidFriendlyStatusDecision(b);
							if(!kidFriendlyStatus.equals(KidFriendlyStatus.UNKNOWN)){				
								BookmarkController.getInstance().setKidFriendlyStatus(user,kidFriendlyStatus,b);
							}
						}
						
						//sharing
						if(b.getKidFriendlyStatus().equals(KidFriendlyStatus.APPROVED)&& b instanceof Shareable){
							if(getShareDecision()){
								BookmarkController.getInstance().share(user,b);
							}
						}
					}
				}
			}
		}

	}
	
	//TODO: below methods will decided by user input console.
	private static boolean getShareDecision() {
		return Math.random() < 0.5 ? true : false;
	
	}

	private static String getKidFriendlyStatusDecision(Bookmark b) {
		return Math.random() < 0.4 ? KidFriendlyStatus.APPROVED
				: (Math.random() >= 0.4 && Math.random() < 0.8) ? KidFriendlyStatus.REJECTED
						: KidFriendlyStatus.UNKNOWN;
	}

	private static boolean getBookmarkDecision(Bookmark b) {
		return Math.random() < 0.5 ? true : false;

	}

	// public static void bookmark(User user, Bookmark[][] bookmarks){
	// System.out.println("\n"+user.getEmail()+" is bookmarking");
	// for(int i=0;i<DataStore.USER_BOOKMARK_LIMIT;i++){
	// int typeOffset = (int)(Math.random()*DataStore.BOOKMARK_TYPES_COUNT);
	// int bookmarkOffset =
	// (int)(Math.random()*DataStore.BOOKMARK_COUNT_PER_TYPE);
	//
	// Bookmark bookmark=bookmarks[typeOffset][bookmarkOffset];
	//
	// BookmarkController.getInstance().saveUserBookmark(user,bookmark);
	//
	// System.out.println(bookmark);
	// }
	// }
}
