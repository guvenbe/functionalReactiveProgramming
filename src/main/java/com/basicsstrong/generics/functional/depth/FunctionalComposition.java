package com.basicsstrong.generics.functional.depth;

import java.util.Objects;

interface Function <T,R>{
    R apply(T t);
    default <V> Function <V,R> compose(Function <V,T> before){
        Objects.requireNonNull(before);
        return (V v) ->apply(before.apply(v));

    }
}

public class FunctionalComposition {
    public static void main(String[] args) {
        Function<Square, Integer> fun1 = s->s.getArea();
        Function<Integer,Double> fun2 = area-> Math.sqrt(area);

        Function<Square ,Double> getSide=fun2.compose(fun1);
        Square s = new Square();
        s.setArea(100);
        Double side = getSide.apply(s);
        System.out.println(side);

    }
}

class Square{
    private int area;

    public void setArea(int area) {
        this.area = area;
    }

    public int getArea(){
        return area;
    }
}
