package com.example.oop;

public class SinhVien {
    public String name;
    public String address;
    private int year;

    public SinhVien(String name, String address, int year) {
        this.name = name;
        this.address = address;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
    //    public void setYear(int year1){
//        if(year1 > 1999){
//            year1 = 1999;
//        }
//        year = year1;
//    }
//    public int getYear(){
//        return year;
//    }
}
