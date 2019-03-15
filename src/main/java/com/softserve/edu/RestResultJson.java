package com.softserve.edu;

import java.util.Arrays;

public class RestResultJson {

	private String[] content;

	public RestResultJson() {
	}

	public String[] getContent() {
		return content;
	}

	public void setContent(String[] content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "RestResultJson [content=" + Arrays.toString(content) + "]";
	}
	
	
}
