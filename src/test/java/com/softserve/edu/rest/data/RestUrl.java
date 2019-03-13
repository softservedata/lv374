package com.softserve.edu.rest.data;

public class RestUrl {

	private String urlBase;
	private String uriGet;
	private String uriPost;
	private String uriPut;
	private String uriDelete;
	
	public RestUrl(String urlBase, String uriGet, String uriPost,
			String uriPut, String uriDelete) {
		this.urlBase = urlBase;
		this.uriGet = uriGet;
		this.uriPost = uriPost;
		this.uriPut = uriPut;
		this.uriDelete = uriDelete;
	}
	
	public RestUrl() {
		urlBase = null;
		uriGet = null;
		uriPost = null;
		uriPut = null;
		uriDelete = null;
	}
	
	public RestUrl addUriBase(String uri)
    {
		uriGet = uri;
        return this;
    }
	
	public RestUrl addUriGet(String uri)
    {
		uriGet = uri;
        return this;
    }
	
	public RestUrl addUriPost(String uri)
    {
		uriPost = uri;
        return this;
    }

	public RestUrl addUriPut(String uri)
    {
		uriPut = uri;
        return this;
    }

	public RestUrl addUriDelete(String uri)
    {
		uriDelete = uri;
        return this;
    }

	// getters
	
	public String getUrlBase() {
		return urlBase;
	}

	public String getUriGet() {
		return uriGet;
	}

	public String getUriPost() {
		return uriPost;
	}

	public String getUriPut() {
		return uriPut;
	}

	public String getUriDelete() {
		return uriDelete;
	}

	public String getUrlGet() {
		return getUrlBase() + getUriGet();
	}

	public String getUrlPost() {
		return getUrlBase() + getUriPost();
	}

	public String getUrlPut() {
		return getUrlBase() + getUriPut();
	}

	public String getUrlDelete() {
		return getUrlBase() + getUriDelete();
	}

}
