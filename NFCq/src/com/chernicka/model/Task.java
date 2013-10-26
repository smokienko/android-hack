package com.chernicka.model;

import org.json.JSONObject;

/**
 * Created by Sov on 26.10.13.
 */
public class Task {

    private String partId;
    private String fullId;
    private long taskDuration;
    private int latitude;
    private int longtitude;
    private String response;
    private String taskText;

    public void setResponse(String response) {
        this.response = response;
    }

    public String getResponse() {

        return response;
    }

    public void setPartId(String partId) {
        this.partId = partId;
    }

    public void setFullId(String fullId) {
        this.fullId = fullId;
    }

    public void setTaskDuration(long taskDuration) {
        this.taskDuration = taskDuration;
    }

    public void setLatitude(int latitude) {
        this.latitude = latitude;
    }

    public void setLongtitude(int longtitude) {
        this.longtitude = longtitude;
    }

    public void setTaskText(String taskText) {
        this.taskText = taskText;
    }

    public String getPartId() {
        return partId;
    }

    public String getFullId() {
        return fullId;
    }

    public long getTaskDuration() {
        return taskDuration;
    }

    public int getLatitude() {
        return latitude;
    }

    public int getLongtitude() {
        return longtitude;
    }

    public String getTaskText() {
        return taskText;
    }

    public void setStartTaskDataFromJson(JSONObject object){
        //TODO smokienko start parse tasks
    }

    public void setTaskQuestionFromJson(JSONObject objext){
        //TODO smokienko end parse tasks
    }



}
