package com.kpi.fict.vh.controller;

import com.kpi.fict.vh.model.Number;
import com.kpi.fict.vh.service.NumberService;
import com.kpi.fict.vh.view.NumberView;

import java.util.Scanner;

public class NumberController {

    NumberService numberService;
    NumberView numberView;

    public NumberController(NumberService numberService, NumberView numberView){
        this.numberService = numberService;
        this.numberView = numberView;
    }

    public void processUser(){
        Scanner scanner = new Scanner(System.in);

        int minValue = borderPatrol(Number.DEFAULT_MIN_VALUE, Number.DEFAULT_MAX_VALUE, scanner);
        int maxValue = borderPatrol(minValue, Number.DEFAULT_MAX_VALUE, scanner);
        numberService.setNumberIntByMaxMinValues(minValue, maxValue);
//------------------------------------------------------
        numberService.isNumberRight(10);
        System.out.println(minValue);
        System.out.println(maxValue);
    }

    private int borderPatrol(int minValue, int maxValue, Scanner scanner){
        numberView.printBorderValues(minValue, maxValue);
        int currentNumber = inputIntValueWithScanner(scanner);

        while( ! (currentNumber >= minValue && currentNumber <= maxValue)){
            numberView.printMessage(NumberView.WRONG_INPUT_INT_DATA);
            currentNumber = inputIntValueWithScanner(scanner);
        }

        return currentNumber;
    }

    private int inputIntValueWithScanner(Scanner scanner) {
        numberView.printMessage(NumberView.INPUT_INT_DATA);
        while( ! scanner.hasNextInt()) {
            numberView.printMessage(NumberView.WRONG_INPUT_INT_DATA_REPEAT);
            scanner.next();
        }
        return scanner.nextInt();
    }
}
