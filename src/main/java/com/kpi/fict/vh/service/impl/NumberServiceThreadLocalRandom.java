package com.kpi.fict.vh.service.impl;


import java.util.concurrent.ThreadLocalRandom;

public class NumberServiceThreadLocalRandom extends AbstractNumberService {

    protected int getRandomNumber(int min, int max){
        ++min;
        --max;
        return ThreadLocalRandom.current().nextInt(min, max);
    }
}
