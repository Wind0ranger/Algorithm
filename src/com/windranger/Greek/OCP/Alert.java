package com.windranger.Greek.OCP;


import com.windranger.Greek.OCP.AlterHandler.IAlertHandler;

import java.util.ArrayList;
import java.util.List;

public class Alert {
    private List<IAlertHandler> alertHandlers = new ArrayList<>();

    public void addAlertHandler(IAlertHandler alertHandler) {
        this.alertHandlers.add(alertHandler);
    }

    public void check(ApiStatInfo apiStatInfo) {
        for (IAlertHandler handler : alertHandlers) {
            handler.check(apiStatInfo);
        }
    }
}







