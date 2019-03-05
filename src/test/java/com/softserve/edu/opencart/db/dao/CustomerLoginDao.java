package com.softserve.edu.opencart.db.dao;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.softserve.edu.opencart.db.entity.CustomerLogin;
import com.softserve.edu.opencart.db.entity.CustomerLogin.CustomerLoginQueries;

public class CustomerLoginDao extends ADaoCRUD<CustomerLogin>  {

    //private final static String LOGIN_FIELDNAME = "Login";
    SimpleDateFormat simpleDateFormat;

    public CustomerLoginDao() {
        super();
        init();
        simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    }

    // TODO Create abstract method in ADao
    protected void init() {
        for (CustomerLoginQueries customerLoginQueries : CustomerLoginQueries.values()) {
            sqlQueries.put(customerLoginQueries.getSqlQuery(), customerLoginQueries);
        }
    }

    // TODO Use List<String>
    protected CustomerLogin createInstance(String[] args) {
        String currentTime = simpleDateFormat.format(new Date());
        Date date_added = null;
        Date date_modified = null;
        try {
            date_added = simpleDateFormat.parse(args[4] == null ? currentTime : args[4]);
            date_modified = simpleDateFormat.parse(args[5] == null ? currentTime : args[5]);
        } catch (Exception e) {
            throw new RuntimeException("TODO");
        }
        return new CustomerLogin(
                Long.parseLong(args[0] == null ? "0" : args[0]),
                args[1] == null ? new String() : args[1],
                args[2] == null ? new String() : args[2],
                Integer.parseInt(args[3] == null ? "0" : args[3]),
                date_added,
                date_modified);
    }

    protected String[] getUpdateFields(CustomerLogin entity) {
        String[] result = new String[6];
        String[] allFields = getFields(entity);
        result[0] = allFields[1]; // email
        result[1] = allFields[2]; // ip
        result[2] = allFields[3]; // total
        //result[3] = allFields[4]; // date_added
        //result[4] = allFields[5]; // date_modified
        result[3] = allFields[0]; // customer_login_id
        return result;
    }

    protected String[] getFields(CustomerLogin entity) {
        //String[] fields = new String[User.class.getDeclaredFields().length];
        String[] fields = new String[6];
        fields[0] = entity.getId().toString();
        fields[1] = entity.getEmail();
        fields[2] = entity.getIp();
        fields[3] = entity.getTotal().toString();
        fields[4] = simpleDateFormat.format(entity.getDate_added());
        fields[5] = simpleDateFormat.format(entity.getDate_modified());
        return fields;
    }

}
