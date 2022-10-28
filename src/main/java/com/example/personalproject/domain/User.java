package com.example.personalproject.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userID = 0;
    private String userName;
    private String password;
    private String firstName = null;
    private String lastName = null;
    private String email = null;
    private String address = null;
    private String phoneNum = null;
    private boolean isActive = true;
    private boolean isAdmin = false;

    public User() {}

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public User(String userName, String password, String firstName, String lastName, String email, String address, String phoneNum) {
        this.userName = userName;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.phoneNum = phoneNum;
    }

    public User(int id, String userName, String password, String firstName, String lastName, String email, String address, String phoneNum, boolean isActive, boolean isAdmin) {
        this.userID = id;
        this.userName = userName;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.address = address;
        this.phoneNum = phoneNum;
        this.isActive = isActive;
        this.isAdmin = isAdmin;
    }

    public User(UserBuilder builder) {
        this.userID = builder.userID;
        this.userName = builder.userName;
        this.password = builder.password;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.email = builder.email;
        this.address = builder.address;
        this.phoneNum = builder.phoneNum;
        this.isActive = builder.isActive;
        this.isAdmin = builder.isAdmin;
    }
    public static class UserBuilder {
        private int userID;
        private String userName;
        private String password;
        private String firstName;
        private String lastName;
        private String email;
        private String address;
        private String phoneNum;
        private boolean isActive;
        private boolean isAdmin;

        public UserBuilder setUserID(Integer id) {
            this.userID = id;
            return this;
        }
        public UserBuilder setUserName(String name) {
            this.userName = name;
            return this;
        }
        public UserBuilder setPassword(String password) {
            this.password = password;
            return this;
        }
        public UserBuilder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }
        public UserBuilder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }
        public UserBuilder setEmail(String email) {
            this.email = email;
            return this;
        }
        public UserBuilder setAddress(String address) {
            this.address = address;
            return this;
        }
        public UserBuilder setPhoneNum(String phoneNum) {
            this.phoneNum = phoneNum;
            return this;
        }
        public UserBuilder setActive(boolean active) {
            this.isActive = active;
            return this;
        }
        public UserBuilder setAdmin(boolean admin) {
            this.isAdmin = admin;
            return this;
        }
        public User build() { return new User(this); }

    }

    @Override
    public String toString() {
        return "User {" +
                "userID = " + this.userID +
                ", userName = '" + this.userName + '\'' +
                ", password = '" + this.password + '\'' +
                ", firstName = '" + this.firstName + '\'' +
                ", lastName = '" + this.lastName + '\'' +
                ", email = '" + this.email + '\'' +
                ", address = '" + this.address + '\'' +
                ", phoneNum = '" + this.phoneNum + '\'' +
                ", isActive = '" + this.isActive + '\'' +
                ", isAdmin = '" + this.isAdmin + '\'' +
                '}';
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public boolean isActive() { return isActive; }

    public void setActive(boolean active) { isActive = active; }

    public boolean isAdmin() { return isAdmin; }

    public void setAdmin(boolean admin) { isAdmin = admin; }
}
