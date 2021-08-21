package com.kpi.fict.vh.model;

import java.util.ArrayList;
import java.util.List;

public class NumberContainer {
    int number;

    private final List<String> logList;

    private int maxInt;
    private int minInt;

    public static final int DEFAULT_MAX_VALUE = 100;
    public static final int DEFAULT_MIN_VALUE = 0;

    public NumberContainer(){
        logList = new ArrayList<>();
    }

    public int getMaxInt() {
        return maxInt;
    }

    public int getMinInt() {
        return minInt;
    }

    public void setMaxInt(int maxInt) {
        this.maxInt = maxInt;
    }

    public void setMinInt(int minInt) {
        this.minInt = minInt;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public List<String> getLogList() {
        return logList;
    }

    public void appendTextToLogList(String newLogMessage){
        logList.add(newLogMessage);
    }
}
