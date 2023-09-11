package com.example.demo.model;

public class CharterModel {
    private int _id;
    private String _name;
    private String _universe;

    private int _art;
    private String _link;


    public  CharterModel(){}

    public CharterModel(int id, String name, String universe,  int art, String link){
        _id = id;
        _name = name;
        _universe = universe;
        _art = art;
        _link = link;
    }

    public String getUniverse() { return _universe;}
    public void setUniverse(String universe) {this._universe = universe;}
    public int getArt() {return _art;}
    public void setArt(int art) {
        this._art = art;
    }
    public String getLink() {
        return _link;
    }
    public void setLink(String link ) {
        this._link = link ;
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
