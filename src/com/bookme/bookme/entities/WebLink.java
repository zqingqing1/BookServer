package com.bookme.bookme.entities;

import com.bookme.bookme.partner.Shareable;

public class WebLink extends Bookmark implements Shareable{
	private String url;
	private String host;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	@Override
	public String toString() {
		return "WebLink [url=" + url + ", host=" + host + "]";
	}

	@Override
	public boolean isKidFriendlyEligible() {
		// TODO Auto-generated method stub
		System.out.println(url);
		if(url.contains("porn")||getTitle().contains("porn"))
			return false;
		return true;
	}

	@Override
	public String getItemData() {
		StringBuilder sb = new StringBuilder();
		sb.append("<item>");
			sb.append("<type>WebLink</type>");
			sb.append("<title>").append(getTitle()).append("</title>");
			sb.append("<host>").append(host).append("</host>");
			sb.append("<url>").append(url).append("</url>");		
		sb.append("</item>");
		
		return sb.toString();
	}

}
