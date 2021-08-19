package com.kpi.fict.vh;

import com.kpi.fict.vh.controller.NumberController;
import com.kpi.fict.vh.model.Number;
import com.kpi.fict.vh.service.NumberService;
import com.kpi.fict.vh.view.NumberView;

public class Main {

    public static void main(String[] args) {
        Number number = new Number();
        NumberView numberView = new NumberView();

        NumberService numberService = new NumberService(number);

        NumberController numberController = new NumberController(numberService, numberView);

        numberController.processUser();
    }
}
