package com.chernicka.model;

import org.json.JSONObject;

/**
 * Created by Sov on 26.10.13.
 */
public class User {

    private static final String SCORE = "score";
    private static final String STATUS = "status";
    private static final String ID = "result";

    private String id;
    private String name;
    private String pass;
    private String key;
    private String score;

    private int latitude;
    private int longtitude;

    public User(){}

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getKey() {
        return key;
    }

    public String getPass() {
        return pass;
    }

    public String getScore() {
        return score;
    }

    public int getLatitude() {
        return latitude;
    }

    public int getLongtitude() {
        return longtitude;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public void setLatitude(int latitude) {
        this.latitude = latitude;
    }

    public void setLongtitude(int longtitude) {
        this.longtitude = longtitude;
    }

    public void setUserDataFromJson(JSONObject object) throws Exception {
        if (object.getBoolean(STATUS)){
            setScore(object.getString(SCORE));
            setId(object.getString(ID));
        } else {
            throw new Exception("Ooops!! Serrver error");
        }

    }

    public void setUserNewScoreFromJson(JSONObject object) throws Exception{
        if (object.getBoolean(STATUS)){
            setScore(object.getString(ID));
        } else {
            throw new Exception("Ooops!! Serrver error");
        }
    }

}
