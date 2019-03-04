package com.softserve.edu.opencart.db.entity;

import java.util.Date;

public class CustomerLogin implements IEntity {

    public static enum CustomerLoginQueries {
        INSERT(SqlQueries.INSERT, "INSERT INTO oc_customer_login (email, ip, total, date_added, date_modified) VALUES ('%s', '%s', %s, %s, %s);"),
        GET_BY_ID(SqlQueries.GET_BY_ID, "SELECT customer_login_id, email, ip, total, date_added, date_modified FROM oc_customer_login WHERE customer_login_id = %s;"),
        GET_BY_FIELD(SqlQueries.GET_BY_FIELD, "SELECT customer_login_id, email, ip, total, date_added, date_modified FROM oc_customer_login WHERE %s = '%s';"),
        GET_ALL(SqlQueries.GET_ALL, "SELECT customer_login_id, email, ip, total, date_added, date_modified FROM oc_customer_login;"),
        UPDATE_BY_ID(SqlQueries.UPDATE_BY_ID, "UPDATE oc_customer_login SET email = '%s', ip = '%s' total = %s date_added = %s date_modified = %s WHERE customer_login_id = %s;"),
        UPDATE_BY_FIELD(SqlQueries.UPDATE_BY_FIELD, "UPDATE oc_customer_login SET %s = '%s' WHERE %s = '%s';"),
        DELETE_BY_ID(SqlQueries.DELETE_BY_ID, "DELETE FROM oc_customer_login WHERE id = %s;"),
        DELETE_BY_FIELD(SqlQueries.DELETE_BY_FIELD, "DELETE FROM oc_customer_login WHERE %s = '%s';");
        //
        private SqlQueries sqlQuery;
        private String query;

        private CustomerLoginQueries(SqlQueries sqlQuery, String query) {
            this.sqlQuery = sqlQuery;
            this.query = query;
        }

        public SqlQueries getSqlQuery() {
            return sqlQuery;
        }

        @Override
        public String toString() {
            return query;
        }
    }

    private Long customer_login_id;
    private String email;
    private String ip;
    private Integer total;
    private Date date_added;
    private Date date_modified;

    public CustomerLogin(Long customer_login_id, String email, String ip,
            Integer total, Date date_added, Date date_modified) {
        this.customer_login_id = customer_login_id;
        this.email = email;
        this.ip = ip;
        this.total = total;
        this.date_added = date_added;
        this.date_modified = date_modified;
    }

    public Long getId() {
        return getCustomer_login_id();
    }

    public Long getCustomer_login_id() {
        return customer_login_id;
    }

    public String getEmail() {
        return email;
    }

    public String getIp() {
        return ip;
    }

    public Integer getTotal() {
        return total;
    }

    public Date getDate_added() {
        return date_added;
    }

    public Date getDate_modified() {
        return date_modified;
    }

    public void setCustomer_login_id(Long customer_login_id) {
        this.customer_login_id = customer_login_id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public void setDate_added(Date date_added) {
        this.date_added = date_added;
    }

    public void setDate_modified(Date date_modified) {
        this.date_modified = date_modified;
    }
    
}
