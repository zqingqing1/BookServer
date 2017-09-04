package com.bookme.bookme.managers;

import com.bookme.bookme.dao.BookMarkDao;
import com.bookme.bookme.entities.Book;
import com.bookme.bookme.entities.Bookmark;
import com.bookme.bookme.entities.Movie;
import com.bookme.bookme.entities.User;
import com.bookme.bookme.entities.UserBookmark;
import com.bookme.bookme.entities.WebLink;

public class BookmarkManager {
	private static BookmarkManager instance = new BookmarkManager();
	private static BookMarkDao dao = new BookMarkDao();
	
	private BookmarkManager() {
	}

	public static BookmarkManager getInstance() {
		return instance;
	}

	public Movie createMovie(long id, String title, String profileUrl, int releaseYear, String[] cast,
			String[] directors, String genre, double imdbRating) {
		Movie movie = new Movie();
		movie.setId(id);
		movie.setTitle(title);
		movie.setProfileUrl(profileUrl);
		movie.setReleaseYear(releaseYear);
		movie.setCast(cast);
		movie.setDirectors(directors);
		movie.setGenre(genre);
		movie.setImdbRating(imdbRating);

		return movie;
	}

	public Book createBook(long id, String title, String profileUrl, int publicationYear, String publisher,
			String[] authors, String genre, double amazonRating) {
		Book book = new Book();

		book.setId(id);
		book.setAuthors(authors);
		book.setProfileUrl(profileUrl);
		book.setPublicationYear(publicationYear);
		book.setPublisher(publisher);
		book.setTitle(title);
		book.setGenre(genre);
		book.setAmazonRating(amazonRating);

		return book;
	}

	public WebLink createWebLink(long id, String title, String profileUrl, String url, String host) {
		WebLink weblink=new WebLink();
		weblink.setId(id);
		weblink.setTitle(title);
		weblink.setProfileUrl(profileUrl);
		weblink.setHost(host);
		weblink.setUrl(url);
		
		return weblink;
	}
	
	public Bookmark[][] getBookmarks(){
		return dao.getBookmarks();
	}

	public void saveUserBookmark(User user, Bookmark bookmark) {
		UserBookmark userbookmark=new UserBookmark();
		userbookmark.setUser(user);
		userbookmark.setBookmark(bookmark);
		
		dao.saveUserBookmark(userbookmark);
	}

	public void setKidFriendlyStatus(User user,String kidFriendlyStatus, Bookmark b) {
		b.setKidFriendlyStatus(kidFriendlyStatus);
		b.setKidFriendlyMarkedBy(user);
		System.out.println("bookmark: "+ b + " status: "+ kidFriendlyStatus + "Marked by"+ user);
		
	}

	public void share(User user, Bookmark b) {
		b.setShareBy(user);
		System.out.println("Date sharing" );
		if(b instanceof Book){
			System.out.println(((Book)b).getItemData());
		}
		else if(b instanceof WebLink){
			System.out.println(((WebLink)b).getItemData());
		}
		
	}

}
