package com.bookme.bookme.concurrency.indexer;

import java.util.ArrayDeque;
import java.util.Deque;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
//import com.bookme.bookme.entities.WebLink;
public class navieIndexer {
	
	private Deque<Weblink> queue=new ArrayDeque<>();
	
	private static class Weblink{
		private long id;
		private String title;
		private String url;
		private String host;
		
		private volatile String htmlPage; // shared value;

		public long getId() {
			return id;
		}

		public String getTitle() {
			return title;
		}

		public String getUrl() {
			return url;
		}

		public String getHost() {
			return host;
		}

		public String getHtmlPage() {
			return htmlPage;
		}

		public void setId(long id) {
			this.id = id;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public void setUrl(String url) {
			this.url = url;
		}

		public void setHost(String host) {
			this.host = host;
		}

		public void setHtmlPage(String htmlPage) {
			this.htmlPage = htmlPage;
		}
		
	}
	
	private static class Downloader implements Runnable{
		private Weblink weblink;
		public Downloader(Weblink weblink){
			this.weblink=weblink;
		}
		public void run(){
			try{
				System.out.println("url: "+ weblink.getUrl());
				String htmlPage= HttpConnect.download(weblink.getUrl());
				weblink.setHtmlPage(htmlPage);
			}catch(MalformedURLException e){
				e.printStackTrace();
			}catch(URISyntaxException e){
				e.printStackTrace();
			}
		}
		
	}
	
	private static class Indexer implements Runnable{
		private Weblink weblink;
		public Indexer(Weblink weblink){
			this.weblink=weblink;
		}
		public void run(){
			while(true){
				String htmlPage=weblink.getHtmlPage();
				if(htmlPage!=null){
					index(htmlPage);
					break;
				}else{
					System.out.println(weblink.getId()+" not yet downloaded!");
				}
			}
		}
		
		private void index(String text){
			if(text!=null){
				System.out.println("\nIndexed: "+ weblink.getId()+ "\n");
			}
		}
	}
	
	public void go(){
		while(queue.size()>0){
			Weblink weblink = queue.remove();
			Thread downloaderThread = new Thread(new Downloader(weblink));
			Thread indexerThread = new Thread(new Indexer(weblink));
			
			downloaderThread.start();
			indexerThread.start();
		}
	}
	
	public void add(Weblink link){
		queue.add(link);
	}
	
	public Weblink createWeblink(long id, String title, String url, String host){
		Weblink link= new Weblink();
		link.setHost(host);
		link.setUrl(url);
		link.setId(id);
		link.setTitle(title);
		return link;
	}
	
	
	
	
	public static void main(String[] args) {
		navieIndexer index = new navieIndexer();
		index.add(index.createWeblink(2000, "Taming Tiger, Part 2", "http://www.javaworld.com/article/2072759/core-java/taming-tiger--part-2.html", "http://www.javaworld.com"));
		//index.add(index.createWeblink(2001, "How do I import a pre-existing Java project into Eclipse and get up and running?", "http://stackoverflow.com/questions/142863/how-do-i-import-a-pre-existing-java-project-into-eclipse-and-get-up-and-running", "http://www.stackoverflow.com"));
		index.add(index.createWeblink(2002, "Interface vs Abstract Class", "http://mindprod.com/jgloss/interfacevsabstract.html", "http://mindprod.com"));
		//index.add(index.createWeblink(2004, "Virtual Hosting and Tomcat", "http://tomcat.apache.org/tomcat-6.0-doc/virtual-hosting-howto.html", "http://tomcat.apache.org"));
		index.go();
	}

}
