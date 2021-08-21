package com.kpi.fict.vh.view;

import java.util.List;

public class NumberView {

    public static final String INPUT_INT_DATA = "Input INT value = ";
    public static final String WRONG_INPUT_INT_DATA_REPEAT = "Wrong input! Repeat please! ";
    public static final String WRONG_INPUT_INT_DATA = "Wrong input! ";

    public void printMessage(String message){
        System.out.println(message);
    }

    public void printBorderValues(int minValue, int maxValue){
        System.out.println("Current border from " + minValue + " to " + maxValue);
    }

    public void printLog(List<String> inputList){
        for (String value : inputList){
            System.out.println(value);
        }
    }

}
