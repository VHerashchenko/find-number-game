package com.kpi.fict.vh.service;

import com.kpi.fict.vh.model.Number;


public class NumberService {

    private final Number number;

    public NumberService(Number number){
        this.number = number;
    }

    public void setNumberIntByMaxMinValues(){
        number.setMinInt(Number.DEFAULT_MIN_VALUE);
        number.setMaxInt(Number.DEFAULT_MAX_VALUE);
        number.setNumber(getRandomNumber(Number.DEFAULT_MIN_VALUE, Number.DEFAULT_MAX_VALUE));
    }

    public void setNumberIntByMaxMinValues(int minValue, int maxValue){
        number.setMinInt(minValue);
        number.setMaxInt(maxValue);
        number.setNumber(getRandomNumber(minValue, maxValue));
    }

    public boolean isNumberRight(int enteredNumber){
        return number.getNumber() == enteredNumber;
    }

    public int guessNumberLogic(int enteredNumber){
        int currentNumber = number.getNumber();
        int result;

        if (currentNumber == enteredNumber){
            System.out.println("same");
            result = 0;
        }
        else if (currentNumber < enteredNumber){
            System.out.println("higher");
            result = 1;
        }
        else {
            System.out.println("lower");
            result = -1;
        }

        return result;
    }

    private int getRandomNumber(int min, int max){
        return (int) ((Math.random() * (max - min)) + min);
    }
}
