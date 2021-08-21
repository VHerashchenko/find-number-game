package com.kpi.fict.vh.service.impl;

import com.kpi.fict.vh.model.NumberContainer;
import com.kpi.fict.vh.service.NumberService;


public class NumberServiceRandom extends AbstractNumberService {

    protected int getRandomNumber(int min, int max){
        return (int) ((Math.random() * (max - min)) + min);
    }
}
