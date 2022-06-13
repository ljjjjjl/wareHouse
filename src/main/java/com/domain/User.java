package com.domain;

public class User {
    private int id;
    private String user_id;
    private String user_password;
    private String user_name;
    private int user_authority;
    private int isadmin;
    private String user_status;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", user_id='" + user_id + '\'' +
                ", user_password='" + user_password + '\'' +
                ", user_name=" + user_name +
                ", user_authority=" + user_authority +
                ", isadmin=" + isadmin +
                ", user_status='" + user_status + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public int getUser_authority() {
        return user_authority;
    }

    public void setUser_authority(int user_authority) {
        this.user_authority = user_authority;
    }

    public int getIsadmin() {
        return isadmin;
    }

    public void setIsadmin(int isadmin) {
        this.isadmin = isadmin;
    }

    public String getUser_status() {
        return user_status;
    }

    public void setUser_status(String user_status) {
        this.user_status = user_status;
    }
}
