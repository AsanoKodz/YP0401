package com.example.demo.model;

public class BookModel {
    private int _id;
    private String _name;
    private String _author;
    private int _numberofpages;
    private int _year;


    public  BookModel(){}

    public BookModel(int id,  String name, String author, int numberofpages, int year){
        _id = id;
        _name = name;
        _author = author;
        _numberofpages = numberofpages;
        _year = year;
    }

    public String getAuthor() {
        return _author;
    }
    public void setAuthor(String author) {this._author = author;}
    public int getNumberofpages() {
        return _numberofpages;
    }
    public void setNumberofpages(int numberofpages) {
        this._numberofpages = numberofpages;
    }
    public int getYear() {return _year;}
    public void setYear(int year ) {
        this._year = year ;
    }

    public String getName() {
        return _name;
    }

    public void setName(String name) {
        this._name = name;
    }

    public int getId() {
        return _id;
    }

    public void setId(int id) {
        this._id = id;
    }
}
