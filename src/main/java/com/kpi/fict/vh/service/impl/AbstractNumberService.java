package com.kpi.fict.vh.service.impl;

import com.kpi.fict.vh.model.NumberContainer;
import com.kpi.fict.vh.service.NumberService;


public abstract class AbstractNumberService implements NumberService {

    public void setNumberIntByMaxMinValues(NumberContainer numberContainer){
        setNumberIntByMaxMinValues(numberContainer,
                NumberContainer.DEFAULT_MIN_VALUE,
                getRandomNumber(NumberContainer.DEFAULT_MIN_VALUE, NumberContainer.DEFAULT_MAX_VALUE));
    }

    public void setNumberIntByMaxMinValues(NumberContainer numberContainer, int minValue, int maxValue){
        numberContainer.setMinInt(minValue);
        numberContainer.setMaxInt(maxValue);
        numberContainer.setNumber(getRandomNumber(minValue, maxValue));
        numberContainer.appendTextToLogList("Border set from " + minValue + " to " + maxValue);
    }

    public boolean isNumberRight(NumberContainer numberContainer, int enteredNumber){
        if (numberContainer.getNumber() == enteredNumber){
            numberContainer.appendTextToLogList("Your number is " + enteredNumber + " and you are right!");
        }

        return numberContainer.getNumber() == enteredNumber;
    }

    public int guessNumberLogic(NumberContainer numberContainer, int enteredNumber){
        int currentNumber = numberContainer.getNumber();
        int result = 0;

         if (currentNumber < enteredNumber){
            numberContainer.appendTextToLogList("Number was higher then needed! It was: " + enteredNumber);
            numberContainer.setMaxInt(enteredNumber - 1);

            numberContainer.appendTextToLogList("Border set from " + numberContainer.getMinInt() + " to " + (enteredNumber - 1));
            result = 1;
        }
        else if (currentNumber > enteredNumber){
            numberContainer.appendTextToLogList("Number was lower then needed! It was: " + enteredNumber);
            numberContainer.setMinInt(enteredNumber + 1);

            numberContainer.appendTextToLogList("Border set from " + (enteredNumber + 1) + " to " + numberContainer.getMaxInt());
            result = -1;
        }

        return result;
    }

    protected abstract int getRandomNumber(int min, int max);
}
