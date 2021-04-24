package com.windranger.Greek.OCP.AlterHandler;


import com.windranger.Greek.OCP.AlertRule;
import com.windranger.Greek.OCP.ApiStatInfo;
import com.windranger.Greek.OCP.Notification;

public abstract class IAlertHandler {
    protected AlertRule rule;
    protected Notification notification;
    public IAlertHandler(AlertRule rule, Notification notification) {
        this.rule = rule;
        this.notification = notification;
    }
    public abstract void check(ApiStatInfo apiStatInfo);
}