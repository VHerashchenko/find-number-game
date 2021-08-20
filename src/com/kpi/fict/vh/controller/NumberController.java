package com.kpi.fict.vh.controller;

import com.kpi.fict.vh.model.Number;
import com.kpi.fict.vh.service.NumberService;
import com.kpi.fict.vh.view.NumberView;

import java.util.Scanner;

public class NumberController {

    Number number;
    NumberService numberService;
    NumberView numberView;

    public NumberController(Number number, NumberView numberView){
        this.number = number;
        this.numberView = numberView;
        numberService = new NumberService(number);
    }

    public void processUser(){
        Scanner scanner = new Scanner(System.in);

        numberView.printMessage("Do you want to change default border? y/n");
        String borderControl = scanner.nextLine();
        while( ! (borderControl.equals("y") || borderControl.equals("n"))) {
            numberView.printMessage(NumberView.WRONG_INPUT_INT_DATA_REPEAT);
            scanner.nextLine();
        }

        if(borderControl.equals("y")) {
            int minValue = borderPatrol(Number.DEFAULT_MIN_VALUE, Number.DEFAULT_MAX_VALUE, scanner);
            int maxValue = borderPatrol(minValue, Number.DEFAULT_MAX_VALUE, scanner);

            numberService.setNumberIntByMaxMinValues(minValue, maxValue);
            numberView.printMessage("Border is changed");
        }
        else {
            numberService.setNumberIntByMaxMinValues();
        }

        int enteredNumber = borderPatrol(number.getMinInt(), number.getMaxInt(), scanner);
        while (! numberService.isNumberRight(enteredNumber)){

            switch (numberService.guessNumberLogic(enteredNumber)){
                case -1:
                    numberView.printMessage("Your number is lower then needed");
                    break;
                case 1:
                    numberView.printMessage("Your number is higher then needed");
                    break;
            }
            enteredNumber = borderPatrol(number.getMinInt(), number.getMaxInt(), scanner);
        }

        numberView.printLog(number.getLogList());

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
