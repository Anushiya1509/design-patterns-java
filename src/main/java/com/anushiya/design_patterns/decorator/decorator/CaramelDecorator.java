package com.anushiya.design_patterns.decorator.decorator;

import com.anushiya.design_patterns.decorator.model.Coffee;

public class CaramelDecorator extends CoffeeDecorator {

    public CaramelDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return coffee.getDescription() + ", Caramel";
    }

    @Override
    public double getCost() {
        return coffee.getCost() + 1.5;
    }
}
