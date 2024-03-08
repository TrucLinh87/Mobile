package com.example.intentexplicittruyennhan;

import java.io.Serializable;

public class sinhVien implements Serializable {
    private String name, namSinh;

    public sinhVien(String name, String namSinh) {
        this.name = name;
        this.namSinh = namSinh;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNamSinh() {
        return namSinh;
    }

    public void setNamSinh(String namSinh) {
        this.namSinh = namSinh;
    }
}
