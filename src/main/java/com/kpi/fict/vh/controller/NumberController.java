package com.kpi.fict.vh.controller;

import com.kpi.fict.vh.model.NumberContainer;
import com.kpi.fict.vh.service.NumberService;
import com.kpi.fict.vh.service.impl.NumberServiceRandom;
import com.kpi.fict.vh.service.impl.NumberServiceThreadLocalRandom;
import com.kpi.fict.vh.view.NumberView;

import java.time.Instant;
import java.util.Scanner;

public class NumberController {

    private final NumberContainer numberContainer;
    private final NumberService numberService;
    private final NumberView numberView;

    public NumberController(NumberContainer numberContainer, NumberView numberView){
        this.numberContainer = numberContainer;
        this.numberView = numberView;
        numberService = Instant.now().getEpochSecond() % 2 == 0 ? new NumberServiceRandom() : new NumberServiceThreadLocalRandom();
    }

    public void processUser(){
        Scanner scanner = new Scanner(System.in);

        String borderControl = setBorderQuestion(scanner);

        setBorderByBorderString(borderControl, scanner);

        setRandomNumber();

        guessGame(scanner);

        numberView.printLog(numberContainer.getLogList());
    }

    private String setBorderQuestion(Scanner scanner){
        numberView.printMessage("Do you want to change default border? y/n");
        String borderControl = scanner.nextLine();
        while( ! (borderControl.equalsIgnoreCase("y") || borderControl.equalsIgnoreCase("n"))) {
            numberView.printMessage(NumberView.WRONG_INPUT_INT_DATA_REPEAT);
            borderControl = scanner.nextLine();
        }
        return borderControl;
    }

    private void setBorderByBorderString(String borderControl, Scanner scanner){
        if(borderControl.equalsIgnoreCase("y")) {
            int minValue = borderPatrol(NumberContainer.DEFAULT_MIN_VALUE, NumberContainer.DEFAULT_MAX_VALUE, scanner);
            int maxValue = borderPatrol(minValue, NumberContainer.DEFAULT_MAX_VALUE, scanner);

            numberService.setNumberIntByMaxMinValues(numberContainer, minValue, maxValue);
            numberView.printMessage("Border is changed");
        }
        else {
            numberService.setNumberIntByMaxMinValues(numberContainer);
        }
    }

    private void setRandomNumber(){
        numberService.setRandomNumber(numberContainer);
    }

    private void guessGame(Scanner scanner){
        int enteredNumber = borderPatrol(numberContainer.getMinInt(), numberContainer.getMaxInt(), scanner);
        while (! numberService.isNumberRight(numberContainer, enteredNumber)){

            switch (numberService.guessNumberLogic(numberContainer, enteredNumber)){
                case -1:
                    numberView.printMessage("Your number is lower then needed");
                    break;
                case 1:
                    numberView.printMessage("Your number is higher then needed");
                    break;
            }
            enteredNumber = borderPatrol(numberContainer.getMinInt(), numberContainer.getMaxInt(), scanner);
        }
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
