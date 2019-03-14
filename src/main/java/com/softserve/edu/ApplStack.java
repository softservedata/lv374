package com.softserve.edu;

public class ApplStack {
	
	public void httpGetAsResponse() {
		m2();
	}

	public void httpPostAsResponse() {
		m2();
	}

	public void m1() {
		m2();
	}

	public void m2() {
		StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
		for (StackTraceElement e : stackTrace) {
			System.out.println(e.toString());
		}
		String method = stackTrace[2].getMethodName();
		System.out.println("MethodName = " + method);
		method = method.substring(4).replace("AsResponse", "");
		System.out.println("Method = " + method);
	}

	public static void main(String[] args) {
		ApplStack app = new ApplStack();
		//app.m1();
		//app.httpGetAsResponse();
		app.httpPostAsResponse();
	}
}
