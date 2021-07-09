package com.basicsstrong.Designpattern;

import java.util.function.Function;

class BurgerF {
    private String burgerType;

    public BurgerF() {
        this.burgerType = "";
    }

    private BurgerF(String burgerType) {
        this.burgerType = burgerType;
    }

    public BurgerF addVeggies() {
        System.out.println("Adding vegies to the burger");
        return new BurgerF(this.burgerType += " veggies");
    }


    public BurgerF addCheese() {
        System.out.println("Adding vegies to the burger");
        return new BurgerF(this.burgerType += " Cheese");

    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("BurgerF{");
        sb.append("burgerType='").append(burgerType).append('\'');
        sb.append('}');
        return sb.toString();
    }
}

class BurgerShop {
    Function<BurgerF, BurgerF> decoration;

    public BurgerShop(Function<BurgerF, BurgerF> decoration) {
        this.decoration = decoration;
    }

    public BurgerF use(BurgerF baseBurger) {
        System.out.println("Base Burger " + baseBurger);
        return decoration.apply(baseBurger);
    }
}

public class DecoratorPatternFunctional {
    public static void main(String[] args) {
        BurgerF myOrder = new BurgerShop(burgerF -> burgerF.addVeggies()).use(new BurgerF());
        System.out.println("I get " + myOrder);
        //add cheese
        BurgerF myOrder2 = new BurgerShop(burgerF -> burgerF.addCheese())
                .use(new BurgerShop(burgerF -> burgerF.addVeggies()).use(new BurgerF()));

        System.out.println("I get " + myOrder2);
    }
}
