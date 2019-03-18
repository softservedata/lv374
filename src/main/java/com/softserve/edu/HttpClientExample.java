package com.softserve.edu;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;

public class HttpClientExample {
    // private final String USER_AGENT = "Mozilla/5.0";

    public static void main(String[] args) throws Exception {
        HttpClientExample http = new HttpClientExample();
        System.out.println("Testing 1 - Send Http GET request");
        http.sendPut();
        http.sendGet();
        //System.out.println("\nTesting 2 - Send Http POST request");
        //http.sendPost();
    }

    // HTTP GET request
    private void sendGet() throws Exception {
        // String url = "http://localhost:8080/tokenlifetime/";
        String url = "http://localhost:8080/";
        // HttpClient client = new DefaultHttpClient(); // Deprecated
        HttpClient client = HttpClientBuilder.create().build();
        // HttpClient client = DefaultHttpClient.setDefaultHttpParams(params);
        // HttpGet request = new HttpGet(url);
        HttpGet request = new HttpGet("/tokenlifetime/");
        // add request header
        // request.addHeader("User-Agent", USER_AGENT);
        // HttpResponse response = client.execute(request);
        // HttpHost httpHost = new HttpHost("127.0.0.1", 8080);
        HttpHost httpHost = new HttpHost("localhost", 8080);
        HttpResponse response = client.execute(httpHost, request);
        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + response.getStatusLine().getStatusCode());
        BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        StringBuffer result = new StringBuffer();
        String line = "";
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }
        System.out.println(result.toString());
    }

    // HTTP POST request
    private void sendPost() throws Exception {
        String url = "http://192.168.103.210/opencart/upload/index.php?route=api/cart/products";
        // HttpClient client = new DefaultHttpClient();
        // HttpClient client = new DefaultHttpClient();
        HttpClient client = HttpClientBuilder.create().build();
        HttpHost httpHost = new HttpHost("localhost", 8080);
        // HttpPost post = new HttpPost(url);
        HttpPost request = new HttpPost("/login/");
        // add header
        // post.setHeader("User-Agent", USER_AGENT);
        List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
//		urlParameters.add(new BasicNameValuePair("sn", "C02G8416DRJM"));
//		urlParameters.add(new BasicNameValuePair("cn", ""));
//		urlParameters.add(new BasicNameValuePair("locale", ""));
//		urlParameters.add(new BasicNameValuePair("caller", ""));
//		urlParameters.add(new BasicNameValuePair("num", "12345"));
//		urlParameters.add(new BasicNameValuePair("route", "api/cart/products"));
//		urlParameters.add(new BasicNameValuePair("token", "7LlqzyLeo4ZjLxoTyoe9zhGf6wNJM0Iu"));
        urlParameters.add(new BasicNameValuePair("name", "admin"));
        urlParameters.add(new BasicNameValuePair("password", "qwerty"));
        //
        // post.setEntity(new UrlEncodedFormEntity(urlParameters));
        request.setEntity(new UrlEncodedFormEntity(urlParameters));
        // HttpResponse response = client.execute(request);
        HttpResponse response = client.execute(httpHost, request);
        System.out.println("\nSending 'POST' request to URL : " + url);
        System.out.println("Post parameters : " + request.getEntity());
        System.out.println("Response Code : " + response.getStatusLine().getStatusCode());
        BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        StringBuffer result = new StringBuffer();
        String line = "";
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }
        System.out.println(result.toString());
    }

    // HTTP PUT request
    private void sendPut() throws Exception {
        String url = "http://192.168.103.210/opencart/upload/index.php?route=api/cart/products";
        // HttpClient client = new DefaultHttpClient();
        // HttpClient client = new DefaultHttpClient();
        HttpClient client = HttpClientBuilder.create().build();
        HttpHost httpHost = new HttpHost("localhost", 8080);
        // HttpPost post = new HttpPost(url);
        HttpPut request = new HttpPut("/tokenlifetime/");
        // add header
        // post.setHeader("User-Agent", USER_AGENT);
        List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
//              urlParameters.add(new BasicNameValuePair("sn", "C02G8416DRJM"));
//              urlParameters.add(new BasicNameValuePair("cn", ""));
//              urlParameters.add(new BasicNameValuePair("locale", ""));
//              urlParameters.add(new BasicNameValuePair("caller", ""));
//              urlParameters.add(new BasicNameValuePair("num", "12345"));
//              urlParameters.add(new BasicNameValuePair("route", "api/cart/products"));
//              urlParameters.add(new BasicNameValuePair("token", "7LlqzyLeo4ZjLxoTyoe9zhGf6wNJM0Iu"));
        urlParameters.add(new BasicNameValuePair("token", "VRSG88CMALPMBEGU4LHR5XRHRFEXPWQS"));
        urlParameters.add(new BasicNameValuePair("time", "200000"));
        //
        // post.setEntity(new UrlEncodedFormEntity(urlParameters));
        request.setEntity(new UrlEncodedFormEntity(urlParameters));
        // HttpResponse response = client.execute(request);
        HttpResponse response = client.execute(httpHost, request);
        System.out.println("\nSending 'POST' request to URL : " + url);
        System.out.println("Post parameters : " + request.getEntity());
        System.out.println("Response Code : " + response.getStatusLine().getStatusCode());
        BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
        StringBuffer result = new StringBuffer();
        String line = "";
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }
        System.out.println(result.toString());
    }

}
