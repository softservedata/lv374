package com.softserve.edu.rest.engine;

import com.softserve.edu.rest.data.RestUrl;
import com.softserve.edu.rest.entity.RestParameters;

public abstract class RestQueries<T> extends RestCRUD {

	// private JsonDeserializer jsonDeserializer;

	protected RestQueries(RestUrl restUrl) {
		super(restUrl);
		// jsonDeserializer =
	}

	private T ConvertToEntity(String json) {
		// TODO ++++++++++++++++++++++++++++++++++++
		return null;
	}

	public T httpGetAsEntity(RestParameters pathVariables, RestParameters urlParameters) {
		return ConvertToEntity(httpGetAsText(pathVariables, urlParameters));
	}

	public T httpPostAsEntity(RestParameters pathVariables,
			RestParameters urlParameters, RestParameters bodyParameters) {
		return ConvertToEntity(httpPostAsText(pathVariables, urlParameters, bodyParameters));
	}

	public T httpPutAsEntity(RestParameters pathVariables,
			RestParameters urlParameters, RestParameters bodyParameters) {
		return ConvertToEntity(httpPutAsText(pathVariables, urlParameters, bodyParameters));
	}

	public T httpDeleteAsEntity(RestParameters pathVariables,
			RestParameters urlParameters, RestParameters bodyParameters) {
		return ConvertToEntity(httpDeleteAsText(pathVariables, urlParameters, bodyParameters));
	}

}
