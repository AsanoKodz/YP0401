package com.example.demo.model;

public class EmployeeModel {
    private int _id;
    private String _surname;
    private String _name;
    private String _patronymic;
    private String _post;


    public  EmployeeModel(){}

    public EmployeeModel(int id, String surname, String name,  String patronymic, String post){
        _id = id;
         _surname = surname;
        _name = name;
        _patronymic = patronymic;
        _post = post;
    }

    public String getSurname() {
        return _surname;
    }
    public void setSurname(String surname) {this._surname = surname;}
    public String getPatronymic() {
        return _patronymic;
    }
    public void setPatronymic(String patronymic) {
        this._patronymic = patronymic;
    }
    public String getPost() {
        return _post;
    }
    public void setPost(String post ) {
        this._post = post ;
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
