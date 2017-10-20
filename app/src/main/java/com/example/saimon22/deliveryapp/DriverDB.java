package com.example.saimon22.deliveryapp;

import com.example.saimon22.deliveryapp.Driver;


import java.util.ArrayList;

public class DriverDB {

    private static ArrayList<Driver> drivers = new ArrayList<Driver>();

    public static ArrayList<Driver> getUsersArrayList() {
        return drivers;
    }

    public static void setUsersArrayList(ArrayList<Driver> users) {
        DriverDB.drivers = drivers;
    }

    public static void printArrayList() {
        for (int i=0; i < drivers.size(); i++) {
            System.out.print(drivers.get(i).getFirstName());
            System.out.print(" " + drivers.get(i).getLastName());
            System.out.print(" " + drivers.get(i).getMiddleName());
            System.out.print(" " + drivers.get(i).getSSN());
            System.out.print(" " + drivers.get(i).getDOB());
            System.out.print(" " + drivers.get(i).getAddress());
            System.out.print(" " + drivers.get(i).getUserName());
            System.out.print(" " + drivers.get(i).getPassword());
            System.out.print(" " + drivers.get(i).getStoreID());


            System.out.println();
        }
    }
}