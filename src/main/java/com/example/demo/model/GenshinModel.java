package com.example.demo.model;

public class GenshinModel {
    private int _id;

    private String _name;
    private String _gender;
    private String _element;
    private String _weapon;


    public  GenshinModel(){}

    public GenshinModel(int id, String name, String gender,   String element, String weapon){
        _id = id;
        _name = name;
        _gender = gender;
        _element = element;
        _weapon = weapon;
    }

    public String getGender() {
        return _gender;
    }
    public void setGender(String gender) {this._gender = gender;}
    public String getElement() {
        return _element;
    }
    public void setElement(String element) {
        this._element = element;
    }
    public String getWeapon() {
        return _weapon;
    }
    public void setWeapon(String weapon ) {
        this._weapon = weapon ;
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
