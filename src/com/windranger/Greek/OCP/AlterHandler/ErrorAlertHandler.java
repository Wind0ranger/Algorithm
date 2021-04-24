package com.windranger.Greek.OCP.AlterHandler;

import com.windranger.Greek.OCP.AlertRule;
import com.windranger.Greek.OCP.AlterHandler.IAlertHandler;
import com.windranger.Greek.OCP.ApiStatInfo;
import com.windranger.Greek.OCP.Notification;

public class ErrorAlertHandler extends IAlertHandler {
    public ErrorAlertHandler(AlertRule rule, Notification notification){
        super(rule, notification);
    }

    @Override
    public void check(ApiStatInfo apiStatInfo) {
        if (apiStatInfo.getErrorCount() > rule.getMatchedRule(apiStatInfo.getApi()).getMaxErrorCount()) {
            //notification.notify(NotificationEmergencyLevel.SEVERE, "...");
            System.out.println("错误告警");
        }
    }
}