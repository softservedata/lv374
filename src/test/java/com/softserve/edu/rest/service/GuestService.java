package com.softserve.edu.rest.service;

import com.softserve.edu.rest.data.Lifetime;
import com.softserve.edu.rest.engine.LoginResource;
import com.softserve.edu.rest.engine.TokenlifetimeResource;
import com.softserve.edu.rest.entity.SimpleEntity;

public class GuestService {

	private LoginResource loginResource;
	private TokenlifetimeResource tokenlifetimeResource;
	
	public GuestService() {
		loginResource = new LoginResource();
		tokenlifetimeResource = new TokenlifetimeResource();
	}

	public GuestService(LoginResource loginResource,
			TokenlifetimeResource tokenlifetimeResource) {
		this.loginResource = loginResource;
		this.tokenlifetimeResource = tokenlifetimeResource;
	}

	public Lifetime getCurrentLifetime() {
		SimpleEntity simpleEntity = tokenlifetimeResource
				.httpGetAsEntity(null, null); 
		return new Lifetime(simpleEntity.getContent());
	}

//    public void UnsuccessfulUserLogin(IUser user)
//    {
//    }
//
//    public void SuccessfulUserLogin(IUser user)
//    {
//    }

//	public AdminBLL SuccessfulAdminLogin(User adminUser)
//    {
//        RestParameters bodyParameters = new RestParameters()
//            .AddParameters("name", adminUser.Name)
//            .AddParameters("password", adminUser.Password);
//        SimpleEntity simpleEntity = loginCRUD.HttpPostAsObject(bodyParameters, null, null);
//        adminUser.Token = simpleEntity.content;
//        return new AdminBLL(adminUser);
//    }
}
