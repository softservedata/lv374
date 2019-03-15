package com.softserve.edu.rest.service;

import com.softserve.edu.rest.data.User;
import com.softserve.edu.rest.engine.LoginResource;
import com.softserve.edu.rest.engine.TokenlifetimeResource;
import com.softserve.edu.rest.entity.RestParameters;
import com.softserve.edu.rest.entity.SimpleEntity;

public class UserService extends GuestService {
	
	protected User user;
	
	public UserService(User user) {
		// super(); // by default
		this.user = user;
	}
	
	public UserService(LoginResource loginResource,
			TokenlifetimeResource tokenlifetimeResource,
			User user) {
		super(loginResource, tokenlifetimeResource);
		this.user = user;
	}

	public GuestService LogoutUser()
    {
        RestParameters bodyParameters = new RestParameters()
            .addParameter("name", user.getName())
            .addParameter("token", user.getToken());
        SimpleEntity simpleEntity = loginResource.httpPostAsEntity(null, null, bodyParameters);
        throwCustomException(simpleEntity, "Error Logout");
        user.setToken("");
        return new GuestService();
    }
	
}
