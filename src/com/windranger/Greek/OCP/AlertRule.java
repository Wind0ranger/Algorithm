package com.windranger.Greek.OCP;

import java.util.HashMap;

public class AlertRule {
    private String name; // 服务名
    private static HashMap<String, HashMap<String,Integer>> rule = new HashMap<>();

    static {
        HashMap<String,Integer> config = new HashMap<>();
        config.put("tps", 1);
        config.put("error", 1);
        rule.put("a server",config);
    }

    public AlertRule(String name) {
        this.name = name;
    }

    public AlertRule getMatchedRule(String api) {
        return new AlertRule(api);
    }

    public int getMaxTps() {
        return rule.get(name).get("tps");
    }
    public int getMaxErrorCount() {
        return rule.get(name).get("error");
    }
}
