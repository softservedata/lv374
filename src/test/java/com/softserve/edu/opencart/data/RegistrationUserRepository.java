package com.softserve.edu.opencart.data;

import com.softserve.edu.EmailRandomizer;

public final class RegistrationUserRepository {

    private RegistrationUserRepository() {
    }

    public static RegistrationUser getValidUser() {
        return new RegistrationUser("Anna", "Smith", new EmailRandomizer(),
                "+38(067)123-45-67", "11-22-33", "SoftServe",
                "SoftServe", "SoftServe 2", "Lviv", "79000",
                "Ss*Jj&1*2#3", "Ss*Jj&1*2#3");
    }
}
