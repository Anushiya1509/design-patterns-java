package com.anushiya.design_patterns.decorator.service;

import com.anushiya.design_patterns.decorator.decorator.CaramelDecorator;
import com.anushiya.design_patterns.decorator.decorator.MilkDecorator;
import com.anushiya.design_patterns.decorator.decorator.WhippedCreamDecorator;
import com.anushiya.design_patterns.decorator.model.Coffee;
import com.anushiya.design_patterns.decorator.model.SimpleCoffee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoffeeService {

    public Coffee prepareCoffee(List<String> toppings) {
        Coffee coffee = new SimpleCoffee();

        for (String topping : toppings) {
            switch (topping.toLowerCase()) {
                case "milk" -> coffee = new MilkDecorator(coffee);
                case "caramel" -> coffee = new CaramelDecorator(coffee);
                case "whippedcream" -> coffee = new WhippedCreamDecorator(coffee);
                default -> throw new IllegalArgumentException("Unknown topping: " + topping);
            }
        }

        return coffee;
    }
}
