package com.kpi.fict.vh.service;

import com.kpi.fict.vh.model.NumberContainer;

public interface NumberService {

    void setNumberIntByMaxMinValues(NumberContainer numberContainer);

    void setNumberIntByMaxMinValues(NumberContainer numberContainer, int minValue, int maxValue);

    boolean isNumberRight(NumberContainer numberContainer, int enteredNumber);

    int guessNumberLogic(NumberContainer numberContainer, int enteredNumber);
}
