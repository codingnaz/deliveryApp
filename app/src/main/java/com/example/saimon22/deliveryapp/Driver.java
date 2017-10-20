package com.example.saimon22.deliveryapp;

import java.io.Serializable;

/**
 * Created by SAimon22 on 9/19/2017.
 */

public class Driver  {
    String firstName, middleName, lastName, address, password, userName;
    int SSN,DOB,storeID;

    public Driver(String firstName, String middleName, String lastName, String userName, String password, String address, int DOB, int SSN, int storeID){
        this.firstName =firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.userName= userName;
        this.password= password;
        this.address= address;
        this.DOB= DOB;
        this.SSN= SSN;
        this.storeID= storeID;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getSSN() {
        return SSN;
    }

    public void setSSN(int SSN) {
        this.SSN = SSN;
    }

    public int getDOB() {
        return DOB;
    }

    public void setDOB(int DOB) {
        this.DOB = DOB;
    }

    public int getStoreID() {
        return storeID;
    }

    public void setStoreID(int storeID) {
        this.storeID = storeID;
    }
}
