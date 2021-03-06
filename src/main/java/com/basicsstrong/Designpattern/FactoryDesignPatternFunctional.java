package com.basicsstrong.Designpattern;

import java.util.function.Supplier;

interface Flooring{
    public void installation();
}

class WoodenFlooring implements Flooring{

    @Override
    public void installation() {
        System.out.println("The wooden flooring is installed");
    }
}

class ConcreteFlooring implements Flooring{

    @Override
    public void installation() {
        System.out.println("The Concrete flooring is installed");
    }
}

class CorkFlooring implements Flooring{

    @Override
    public void installation() {
        System.out.println("The Cork flooring is installed");
    }
}

class FlooringFactory{
    public static Flooring getFlooring(int minTemperature, int maxTemperature){
        Supplier<Flooring> flooring;
        if (minTemperature<=5 && maxTemperature <=20) {
            flooring = () -> new WoodenFlooring();
        }else if(minTemperature<=5 && maxTemperature >45){
            flooring= ()->new CorkFlooring();
        }else{
            flooring=()->new ConcreteFlooring();
        }
        return flooring.get();
    }
}

public class FactoryDesignPatternFunctional {
    public static void main(String[] args) {
        Flooring floor = FlooringFactory.getFlooring(-1,18);
        floor.installation();
        Flooring floor2 = FlooringFactory.getFlooring(13,46);
        floor2.installation();
    }
}
