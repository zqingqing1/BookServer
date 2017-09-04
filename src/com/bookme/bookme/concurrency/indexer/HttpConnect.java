package com.bookme.bookme.concurrency.indexer;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class HttpConnect {
	public static String download(String sourceUrl) throws MalformedURLException, URISyntaxException{
		System.out.println("Downloading.."+sourceUrl);
		URL url = new URI(sourceUrl).toURL();
		
		try{
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			int responseCode = con.getResponseCode();
			
			if(responseCode >=200 && responseCode<300){
				return IOUtil.read(con.getInputStream());
			}
		}catch(IOException e){
			e.printStackTrace();
		}
		
		return null;
	}

	public static InputStream getInputStream(String url) throws MalformedURLException, URISyntaxException {
		// TODO Auto-generated method stub
		URL newurl = new URI(url).toURL();
		try{
			HttpURLConnection con = (HttpURLConnection)newurl.openConnection();
			int responseCode = con.getResponseCode();
			
			if(responseCode >=200 && responseCode<300){
				return con.getInputStream();
			}
		}catch(IOException e){
			e.printStackTrace();
		}
		return null;
	}
	
	public static String download(InputStream in) throws IOException{
		return IOUtil.read(in);
	}
}
