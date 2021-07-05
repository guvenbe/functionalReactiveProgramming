package com.basicsstring.generics.functional.depth;

import java.util.Objects;
import java.util.function.Function;

@FunctionalInterface
interface Consumer<T>{
    void accept(T t);


    default Consumer<T> thenAccept(Consumer<T> next){
        Objects.requireNonNull(next);
        return (T t) -> {
            this.accept(t);
            next.accept(t);
        };
    }
}

public class Chaining {
    public static void main(String[] args) {
        Consumer<String> c1 = s-> System.out.println(s);
        Consumer<String> c2 = s-> System.out.println(s);
        c1.accept("hello");
        c2.accept("hello");

        Consumer<String> c3 = s ->{
            c1.accept(s);
            c2.accept(s);
        };

        c3.accept("hello");
        Consumer<String> c4 = c1.thenAccept(c2);
        c4.accept("BasicsStrong");

        Function<Integer,Integer> f1 = s -> s+2;
        Function<Integer,Integer> f2 = s -> s*2;
        Function<Integer,Integer> f3 = f1.andThen(f2);
        System.out.println(f3.apply(10));
    }
}
