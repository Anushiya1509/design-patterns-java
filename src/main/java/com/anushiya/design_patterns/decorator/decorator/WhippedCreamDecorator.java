package com.anushiya.design_patterns.decorator.decorator;

import com.anushiya.design_patterns.decorator.model.Coffee;

public class WhippedCreamDecorator extends CoffeeDecorator {

    public WhippedCreamDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return coffee.getDescription() + ", Whipped Cream";
    }

    @Override
    public double getCost() {
        return coffee.getCost() + 1.2;
    }
}
