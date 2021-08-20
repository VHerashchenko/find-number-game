package com.kpi.fict.vh.service;

import com.kpi.fict.vh.model.Number;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberServiceTest {

    Number number = new Number();
    NumberService numberService;

    @BeforeEach
    void setNumber(){
        number.setNumber(10);
        numberService = new NumberService(number);
    }

    @Test
    void guessNumberLogic() {
        assertEquals(1 , numberService.guessNumberLogic(11));
        assertEquals(-1, numberService.guessNumberLogic(9));
        assertEquals(0, numberService.guessNumberLogic(10));
    }

    @Test
    void isNumberRight(){
        assertTrue(numberService.isNumberRight(10));
        assertFalse(numberService.isNumberRight(9));
    }
}