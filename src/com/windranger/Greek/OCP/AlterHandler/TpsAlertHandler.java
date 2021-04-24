package com.windranger.Greek.OCP.AlterHandler;

import com.windranger.Greek.OCP.AlertRule;
import com.windranger.Greek.OCP.AlterHandler.IAlertHandler;
import com.windranger.Greek.OCP.ApiStatInfo;
import com.windranger.Greek.OCP.Notification;

public class TpsAlertHandler extends IAlertHandler {
    public TpsAlertHandler(AlertRule rule, Notification notification) {
        super(rule, notification);
    }

    @Override
    public void check(ApiStatInfo apiStatInfo) {
        long tps = apiStatInfo.getRequestCount()/ apiStatInfo.getDurationOfSeconds();
        if (tps > rule.getMatchedRule(apiStatInfo.getApi()).getMaxTps()) {
            System.out.println("异常告警");
        }
    }
}
