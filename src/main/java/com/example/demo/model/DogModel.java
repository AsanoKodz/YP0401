package com.example.demo.model;

public class DogModel {
    private int _id;
    private String _nickname;
    private int _age;
    private String _master;
    private String _breed;


    public  DogModel(){}

    public DogModel(int id, String nickname, int age,  String master, String breed){
        _id = id;
        _nickname = nickname;
        _age = age;
        _master = master;
        _breed = breed;
    }

    public String getNickname() {
        return _nickname;
    }
    public void setNickname(String nickname) {this._nickname = nickname;}
    public int getAge() { return _age;}
    public void setAge(int age) {
        this._age = age;
    }
    public String getMaster() {
        return _master;
    }
    public void setMaster(String master ) {
        this._master = master ;
    }

    public String getBreed() {
        return _breed;
    }

    public void setBreed(String breed) {
        this._breed = breed;
    }

    public int getId() {
        return _id;
    }

    public void setId(int id) {
        this._id = id;
    }
}
