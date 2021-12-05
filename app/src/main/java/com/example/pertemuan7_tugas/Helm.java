package com.example.pertemuan7_tugas;

public class Helm {
    private String _id, _nama, _brand;
    public Helm (String id, String nama, String brand) {
        this._id = id;
        this._nama = nama;
        this._brand = brand;
    }
    public Helm() {
    }
    public String get_id() {
        return _id;
    }
    public void set_id(String _id) {
        this._id = _id;
    }
    public String get_nama() {
        return _nama;
    }
    public void set_nama(String _nama) {
        this._nama = _nama;
    }
    public String get_brand() {
        return _brand;
    }
    public void set_brand(String _brand) {
        this._brand = _brand;
    }
}
