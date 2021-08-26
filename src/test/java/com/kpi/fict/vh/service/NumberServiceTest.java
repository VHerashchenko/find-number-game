package com.kpi.fict.vh.service;

import com.kpi.fict.vh.model.NumberContainer;
import com.kpi.fict.vh.service.impl.NumberServiceRandom;
import com.kpi.fict.vh.service.impl.NumberServiceThreadLocalRandom;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class NumberServiceTest {

    private final NumberContainer numberContainer = new NumberContainer();

    private static Stream<NumberService> dataTest(){
        return Stream.of(new NumberServiceRandom(), new NumberServiceThreadLocalRandom());
    }

    @BeforeEach
    void setNumber(){
        numberContainer.setNumber(10);
    }

    @ParameterizedTest
    @MethodSource("dataTest")
    void guessNumberLogic(NumberService numberService) {
        assertEquals(1 , numberService.guessNumberLogic(numberContainer,11));
        assertEquals(-1, numberService.guessNumberLogic(numberContainer,9));
        assertEquals(0, numberService.guessNumberLogic(numberContainer,10));
    }

    @ParameterizedTest
    @MethodSource("dataTest")
    void isNumberRight(NumberService numberService){
        assertTrue(numberService.isNumberRight(numberContainer,10));
        assertFalse(numberService.isNumberRight(numberContainer,9));
    }

    @ParameterizedTest
    @MethodSource("dataTest")
    void setRandomNumber(NumberService numberService){
        for(int i = 0; i < 1000; ++i) {
            numberService.setNumberIntByMaxMinValues(numberContainer, 45, 50);
            numberService.setRandomNumber(numberContainer);
            assertTrue(numberContainer.getNumber() > 45 && numberContainer.getNumber() < 50);
        }
    }
}