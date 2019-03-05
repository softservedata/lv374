package com.softserve.edu.opencart.db.service;

import java.util.List;

import com.softserve.edu.opencart.data.IUser;
import com.softserve.edu.opencart.db.dao.CustomerLoginDao;
import com.softserve.edu.opencart.db.entity.CustomerLogin;
import com.softserve.edu.opencart.db.entity.CustomerLogin.CustomerLoginFields;

public class LoginService {

    private CustomerLoginDao customerLoginDao;

    public LoginService() {
        customerLoginDao = new CustomerLoginDao();
    }

    private List<CustomerLogin> getAllCustomerLogins() {
        List<CustomerLogin> customers = customerLoginDao.getAll();
        if (customers.isEmpty()) {
            // TODO Develop Custom Exception
            throw new RuntimeException("customerLogins not found");
        }
        return customers;
    }

    private CustomerLogin getCustomerLoginByIUser(IUser user) {
        List<CustomerLogin> customers = customerLoginDao
                .getByFieldName(CustomerLoginFields.EMAIL.toString(), user.getEmail());
        if (customers.isEmpty()) {
            // TODO Develop Custom Exception
            throw new RuntimeException("User "+ user +" not found");
        }
        return customers.get(0);
    }

    public int getLoginAttemptCount(IUser user) {
        return getCustomerLoginByIUser(user).getTotal();
    }

    public int getLoginAttemptCount() {
        int result = 0;
        for (CustomerLogin customer : getAllCustomerLogins()) {
            if (customer.getTotal() >= 5) {
                result++;
            }
        } 
        return result; 
    }

    public List<IUser> getBannedUsers() {
        // TODO Use UserDBDao
        throw new RuntimeException("TODO");
        //return null;
    }

    public boolean unlockBannedUser(IUser user) {
        boolean result = false;
        CustomerLogin customer = getCustomerLoginByIUser(user);
        result = customer.getTotal() >= 5;
        if (result) {
            customer.setTotal(0);
            result = result && customerLoginDao.updateByEntity(customer);
        }
        return result;
    }

    public int unlockAllBannedUsers() {
        int result = 0;
        for (CustomerLogin customer : getAllCustomerLogins()) {
            if (customer.getTotal() >= 5) {
                customer.setTotal(0);
                customerLoginDao.updateByEntity(customer);
                result++;
            }
        } 
        return result;
    }

}
