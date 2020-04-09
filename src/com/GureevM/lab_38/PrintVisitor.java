package com.GureevM.lab_38;

import com.GureevM.lab_12.Car;
import com.GureevM.lab_12.Motorcycle;
import com.GureevM.lab_12.Transport;

public class PrintVisitor implements Visitor {
    /*
    * Паттерн Посетитель предлагает разместить новое поведение в отдельном классе,
    * вместо того чтобы множить его сразу в нескольких классах. Объекты, с которыми
    * должно было быть связано поведение, не будут выполнять его самостоятельно.
    * Вместо этого вы будете передавать эти объекты в методы посетителя.
    */

    @Override
    public void visit(Car car) {
        String mark = car.getMark();
        int count = car.getArrayModelLength();
        double[] prices = car.getArrayOfModelPrice();
        String[] models = car.getArrayOfModelNames();
        System.out.println("--- --- --- --- --- --- --- --- ---");
        System.out.print(String.format("Mark: %s, count: %d \n", mark, count));
        for (int a = 0; a < count; a++) {
            System.out.print(String.format("Model: %s, price: %d", models[a], (int) prices[a]));
            if (a != count - 1)  System.out.print("; "); else System.out.print(".");
        }
    }

    @Override
    public void visit(Motorcycle motorcycle) {
        String mark = motorcycle.getMark();
        int count = motorcycle.getArrayModelLength();
        double[] prices = motorcycle.getArrayOfModelPrice();
        String[] models = motorcycle.getArrayOfModelNames();
        System.out.println("--- --- --- --- --- --- --- --- ---");
        System.out.println(String.format("Mark: %s, count: %d \n", mark, count));
        for (int a = 0; a < count; a++) {
            System.out.println(String.format("Model: %s, price: %d", models[a], (int) prices[a]));
            if (a != count - 1)  System.out.print("; "); else System.out.print(".");
        }
    }
}
