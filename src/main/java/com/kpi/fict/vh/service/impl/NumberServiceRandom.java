package com.kpi.fict.vh.service.impl;

public class NumberServiceRandom extends AbstractNumberService {

    protected int getRandomNumber(int min, int max){
        ++min;
        --max;
        return (int) ((Math.random() * (max - min)) + min);
    }
}
