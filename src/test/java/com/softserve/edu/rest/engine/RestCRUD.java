package com.softserve.edu.rest.engine;

import java.io.IOException;

import com.softserve.edu.rest.data.RestUrl;
import com.softserve.edu.rest.entity.RestParameters;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public abstract class RestCRUD<T> {
	
	private RestUrl restUrl;
	private OkHttpClient httpClient;
	//private JsonDeserializer deserial;
	
	protected RestCRUD(RestUrl restUrl) {
		this.restUrl = restUrl;
		httpClient = new OkHttpClient();
	}
	
	protected void throwException(String message)
    {
        // TODO Develop Custom Exception
        throw new RuntimeException(String.format("Method %s not Support for Resource %s", message, this.getClass().getName()));
    }
	
	//private T ConvertToObject(IRestResponse response){}
	
	private String prepareUrlParameters(String urlTemplate, RestParameters urlParameters) {
		String url = urlTemplate;
		if (urlParameters != null) {
			boolean isFirstParameter = true;
			for (String currentKey : urlParameters.getAllParameters().keySet()) {
				url = url + (isFirstParameter ? "?" : "&");
				url = url + currentKey + "=" + urlParameters.getParameter(currentKey);
				isFirstParameter = false;
			}
		}
		return url;
	}

	private String preparePathVariables(String urlTemplate, RestParameters pathVariables) {
		String url = urlTemplate;
		String searchVariable;
		if (pathVariables != null) {
			for (String currentKey : pathVariables.getAllParameters().keySet()) {
				searchVariable = "{" + currentKey + "}";
				if (url.contains(searchVariable)) {
					url = url.replaceFirst(searchVariable, pathVariables.getParameter(currentKey));
				}
			}
		}
		return url;
	}

	private RequestBody prepareRequestBody(RestParameters bodyParameters) {
		RequestBody requestBody = null;
		if (bodyParameters != null) {
			FormBody.Builder formBodyBuilder = new FormBody.Builder();
			for (String currentKey : bodyParameters.getAllParameters().keySet()) {
				formBodyBuilder.add(currentKey, bodyParameters.getParameter(currentKey));
			}
			requestBody = formBodyBuilder.build();
		}
		return requestBody;
	}
	
	private Request.Builder prepareRequestBuilder(RestParameters pathVariables, RestParameters urlParameters) {
		String url = preparePathVariables(restUrl.getUrlGet(), pathVariables);
		url = prepareUrlParameters(url, urlParameters);
		return new Request.Builder().url(url);
	}
	
	private Response executeRequest(Request request) {
		Response result = null;
		try {
			result = httpClient.newCall(request).execute();
		} catch(IOException e) {
			// TODO Develop Custom Exception + Log
			throw new RuntimeException("Request Error " + e.toString());
		}
		return result;
	}
	
	// Http Get - - - - - - - - - - - - - - - - - - - -
	
	public Response HttpGetAsResponse(RestParameters pathVariables, RestParameters urlParameters) {
		return executeRequest(
					prepareRequestBuilder(pathVariables, urlParameters)
						.get()
						.build());
	}

	public String HttpGetAsText(RestParameters pathVariables, RestParameters urlParameters) {
		return HttpGetAsResponse( pathVariables,  urlParameters)
				.body().toString();
	}
	
	// Http Post - - - - - - - - - - - - - - - - - - - -

	public Response HttpPostAsResponse(RestParameters pathVariables, RestParameters urlParameters, RestParameters bodyParameters) {
		return executeRequest(
					prepareRequestBuilder(pathVariables, urlParameters)
						.post(prepareRequestBody(bodyParameters))
						.build());
	}

	public String HttpPostAsText(RestParameters pathVariables, RestParameters urlParameters, RestParameters bodyParameters) {
		return HttpPostAsResponse(pathVariables, urlParameters, bodyParameters)
				.body().toString();
	}

	// Http Put - - - - - - - - - - - - - - - - - - - -

	public Response HttpPutAsResponse(RestParameters pathVariables, RestParameters urlParameters, RestParameters bodyParameters) {
		return executeRequest(
					prepareRequestBuilder(pathVariables, urlParameters)
						.put(prepareRequestBody(bodyParameters))
						.build());
	}

	// Http Delete - - - - - - - - - - - - - - - - - - - -

	public Response HttpDeleteAsResponse(RestParameters pathVariables, RestParameters urlParameters, RestParameters bodyParameters) {
		return executeRequest(
					prepareRequestBuilder(pathVariables, urlParameters)
						.delete(prepareRequestBody(bodyParameters))
						.build());
	}

}
