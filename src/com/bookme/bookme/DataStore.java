package com.bookme.bookme;

import com.bookme.bookme.contants.BookGenre;
import com.bookme.bookme.contants.Gender;
import com.bookme.bookme.contants.MovieGenre;
import com.bookme.bookme.contants.UserType;
import com.bookme.bookme.entities.*;
import com.bookme.bookme.managers.BookmarkManager;
import com.bookme.bookme.managers.UserManager;

public class DataStore {
	public static final int USER_BOOKMARK_LIMIT = 5;
	public static final int BOOKMARK_COUNT_PER_TYPE = 5;
	public static final int BOOKMARK_TYPES_COUNT = 3;
	public static final int TOTAL_USER_COUNT = 5;
	
	private static User[] users = new User[TOTAL_USER_COUNT];
	public static User[] getUsers() {
		return users;
	}

	private static Bookmark[][] bookmarks = new Bookmark[BOOKMARK_TYPES_COUNT][BOOKMARK_COUNT_PER_TYPE];
	public static Bookmark[][] getBookmarks() {
		return bookmarks;
	}

	private static UserBookmark[] userbookmarks= new UserBookmark[TOTAL_USER_COUNT* USER_BOOKMARK_LIMIT];
	public static UserBookmark[] getUsebookmarks() {
		return userbookmarks;
	}
	
	private static int bookmarkIndex;

	public static void loadData(){
		loadUsers();
		loadWebLinks();
		loadMovies();
		loadBooks();
	}
	
	private static void loadUsers(){
		
		users[0]=UserManager.getInstance().createUser(1000, "qingqinz@usc.edu", "12345678", "Qing", "Zheng", Gender.FEMALE, UserType.USER);
		users[1]=UserManager.getInstance().createUser(1001, "sapphire040703@gmail.com", "12345678", "sapphire", "Zheng", Gender.MALE, UserType.USER);
		users[2]=UserManager.getInstance().createUser(1001, "sapphire040703@gmail.com", "12345678", "sapphire", "Zheng", Gender.FEMALE, UserType.USER);
		users[3]=UserManager.getInstance().createUser(1001, "sapphire040703@gmail.com", "12345678", "sapphire", "Zheng", Gender.FEMALE, UserType.EDITOR);
		users[4]=UserManager.getInstance().createUser(1002, "qingq.zheng@gmail.com", "12345678", "summer", "Zheng", Gender.FEMALE, UserType.CHIEF_EDITOR);
	}
	
	private static void loadWebLinks(){

		bookmarks[0][0]=BookmarkManager.getInstance().createWebLink(2000,"Taming Tiger, Part 2","http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html","http://www.javaworld.com", null);
		bookmarks[0][1]=BookmarkManager.getInstance().createWebLink(2001,"How do I import a pre-existing Java project into Eclipse and get up and running?","http://stackoverflow.com/questions/142863/how-do-i-import-a-pre-existing-java-project-into-eclipse-and-get-up-and-running","http://www.stackoverflow.com", null);
		bookmarks[0][2]=BookmarkManager.getInstance().createWebLink(2002,"Interface vs Abstract Class","http://mindprod.com/jgloss/interfacevsabstract.html","http://mindprod.com", null);
		bookmarks[0][3]=BookmarkManager.getInstance().createWebLink(2003,"NIO tutorial by Greg Travis","http://cs.brown.edu/courses/cs161/papers/j-nio-ltr.pdf",	"http://cs.brown.edu", null);
		bookmarks[0][4]=BookmarkManager.getInstance().createWebLink(2004,"Virtual Hosting and Tomcat","http://tomcat.apache.org/tomcat-6.0-doc/virtual-hosting-howto.html","http://tomcat.apache.org", null);
		
	}
	
	private static void loadMovies(){

		bookmarks[1][0]=BookmarkManager.getInstance().createMovie(3000, "Citizen Kane", null , 1941, new String[]{"Orson Welles","Joseph"}, new String[]{"Cotten Orson Welles"}, MovieGenre.CLASSICS,8.5);
		bookmarks[1][1]=BookmarkManager.getInstance().createMovie(3001, "The Grapes of Wrath", null, 1940, new String[]{"Henry Fonda","Jane Darwell"}, new String[]{"John Ford"},MovieGenre.CLASSICS , 7.3);
		bookmarks[1][2]=BookmarkManager.getInstance().createMovie(3002, "A Touch of Greatness" , null, 2004, new String[]{"Henry Fonda","Jane Darwell"}, new String[]{"John Ford"}, MovieGenre.CLASSICS, 7.2);
		bookmarks[1][3]=BookmarkManager.getInstance().createMovie(3003, "The Big Bang Theory", null, 2007, new String[]{"Henry Fonda","Jane Darwell"}, new String[]{"John Ford"}, MovieGenre.TV_SHOWS, 8.8);
		bookmarks[1][4]=BookmarkManager.getInstance().createMovie(3004, "Ikiru", null, 1952, new String[]{"Henry Fonda","Jane Darwell"}, new String[]{"John Ford"}, MovieGenre.CLASSICS, 8.1);
	}
	
	public static void loadBooks(){
		
		bookmarks[2][0]=BookmarkManager.getInstance().createBook(4001, "Walden", null, 1854, "Wilder Publications", new String[]{"Henry David"}, BookGenre.PHILOSOPHy, 4.3);
		bookmarks[2][1]=BookmarkManager.getInstance().createBook(4002, "Walden", null, 1854, "Wilder Publications", new String[]{"Henry David"}, BookGenre.PHILOSOPHy, 4.3);
		bookmarks[2][2]=BookmarkManager.getInstance().createBook(4003, "Walden", null, 1854, "Wilder Publications", new String[]{"Henry David"}, BookGenre.PHILOSOPHy, 4.3);
		bookmarks[2][3]=BookmarkManager.getInstance().createBook(4004, "Walden", null, 1854, "Wilder Publications", new String[]{"Henry David"}, BookGenre.PHILOSOPHy, 4.3);
		bookmarks[2][4]=BookmarkManager.getInstance().createBook(4005, "Walden", null, 1854, "Wilder Publications", new String[]{"Henry David"}, BookGenre.PHILOSOPHy, 4.3);
		
		
	}

	public static void add(UserBookmark userbookmark) {
		userbookmarks[bookmarkIndex++] = userbookmark;
		
	}
	
}
