package com.taaaaad.domain;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class Account implements Serializable {

    private String username;
    private String password;
    private Double money;
//    private User user;

    private List<User> users;

    private Map<String, User> mapUsers;

    public Map<String, User> getMapUsers() {
        return mapUsers;
    }

    public void setMapUsers(Map<String, User> mapUsers) {
        this.mapUsers = mapUsers;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Account{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", money=" + money +
                ", users=" + users +
                ", mapUsers=" + mapUsers +
                '}';
    }
}
