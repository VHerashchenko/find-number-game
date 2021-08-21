package com.kpi.fict.vh;

import com.kpi.fict.vh.controller.NumberController;
import com.kpi.fict.vh.model.NumberContainer;
import com.kpi.fict.vh.view.NumberView;

public class Main {

    public static void main(String[] args) {
        NumberContainer numberContainer = new NumberContainer();
        NumberView numberView = new NumberView();

        NumberController numberController = new NumberController(numberContainer, numberView);

        numberController.processUser();
    }
}
