package com.example.demo.entity;


public class User {

    private String id;

    private String userName;

    private String password;

    private String phone;

    private String name;

    private String sex;

    private String age;


    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }


    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }


    public void setUserName(String userName) { this.userName = userName; }

    public String getUserName() {
        return userName;
    }


    public void setPassword(String password) { this.password = password; }

    public String getPassword() {
        return password;
    }


    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSex() {
        return sex;
    }
}
