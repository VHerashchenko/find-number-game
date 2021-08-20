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
        number.appendTextToLogList("Border set from " + Number.DEFAULT_MIN_VALUE + " to " + Number.DEFAULT_MAX_VALUE);
    }

    public void setNumberIntByMaxMinValues(int minValue, int maxValue){
        number.setMinInt(minValue);
        number.setMaxInt(maxValue);
        number.setNumber(getRandomNumber(minValue, maxValue));
        number.appendTextToLogList("Border set from " + minValue + " to " + maxValue);
    }

    public boolean isNumberRight(int enteredNumber){
        if (number.getNumber() == enteredNumber){
            number.appendTextToLogList("Your number is " + enteredNumber + " and you are right!");
        }

        return number.getNumber() == enteredNumber;
    }

    public int guessNumberLogic(int enteredNumber){
        int currentNumber = number.getNumber();
        int result = 0;

         if (currentNumber < enteredNumber){
            number.appendTextToLogList("Number was higher then needed! It was: " + enteredNumber);
            number.setMaxInt(enteredNumber);

            number.appendTextToLogList("Border set from " + number.getMinInt() + " to " + enteredNumber);
            result = 1;
        }
        else if (currentNumber > enteredNumber){
            number.appendTextToLogList("Number was lower then needed! It was: " + enteredNumber);
            number.setMinInt(enteredNumber);

            number.appendTextToLogList("Border set from " + enteredNumber + " to " + number.getMaxInt());
            result = -1;
        }

        return result;
    }

    private int getRandomNumber(int min, int max){
        return (int) ((Math.random() * (max - min)) + min);
    }
}
