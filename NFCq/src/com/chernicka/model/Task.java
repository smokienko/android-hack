package com.chernicka.model;

import org.json.JSONObject;

/**
 * Created by Sov on 26.10.13.
 */
public class Task {

    private static final String QUESTION = "question";
    private static final String ANSWER = "answer";
    private static final String POINT_W = "point_w";
    private static final String POINT_H = "point_h";
    private static final String TIMEOUT = "timeout";
    private static final String STATUS = "status";
    private static final String ERROR = "error";

    private String partId;
    private String fullId;
    private long taskDuration;
    private double latitude;
    private double longtitude;
    private long time;
    private String response;
    private String taskText;
    private boolean taskstatus;

    public void setResponse(String response) {
        this.response = response;
    }

    public String getResponse() {

        return response;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public long getTime() {
        return time;
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

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongtitude(double longtitude) {
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

    public double getLatitude() {
        return latitude;
    }

    public double getLongtitude() {
        return longtitude;
    }

    public String getTaskText() {
        return taskText;
    }

    public void setTaskstatus(boolean taskstatus) {
        this.taskstatus = taskstatus;
    }

    public boolean isTaskstatus() {
        return taskstatus;
    }

    public void setStartTaskDataFromJson(JSONObject object){
        //TODO smokienko start parse tasks
    }

    public void setTaskQuestionFromJson(JSONObject object) throws Exception{
        //TODO smokienko end parse tasks
        setTaskstatus(object.getBoolean(STATUS));
        if(isTaskstatus()){
            setTaskText(object.getString(QUESTION));
            setResponse(object.getString(ANSWER));
            setLongtitude(object.getDouble(POINT_W));
            setLatitude(object.getDouble(POINT_H));
            setTime(object.getLong(TIMEOUT));
        } else {
            throw new Exception("No user found");
        }
    }



}
