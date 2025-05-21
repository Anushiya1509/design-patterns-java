package com.anushiya.design_patterns.decorator.decorator;

import com.anushiya.design_patterns.decorator.model.Coffee;

public abstract class CoffeeDecorator implements Coffee {
    protected final Coffee coffee;

    public CoffeeDecorator(Coffee coffee) {
        this.coffee = coffee;
    }
}
