package com.windranger.DesignPattern.Factory.Simplefactory;

import com.windranger.DesignPattern.Factory.Simplefactory.Pizza.*;

public class SimpleFactory {

    public Pizza createPizza(String orderType) {
        Pizza pizza = null;
        System.out.println("预定");
        if ("greek".equals(orderType)) {
            pizza = new GreekPizza();
        } else if ("cheese".equals(orderType)) {
            pizza = new CheesePizza();
        } else if ("pepper".equals(orderType)) {
            pizza = new PepperPizza();
        }

        return pizza;
    }

}
