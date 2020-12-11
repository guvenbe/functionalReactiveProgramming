package com.basicsstring.generics.functional.depth;

interface IProducer<T> {
    T produce();
}

interface IConfigurator<T, R> {
    R configure(T t);
}

interface IFactory<T> {
    T create();
}

public class HigherOrderFunctions {
    public static void main(String[] args) {
        IFactory<Integer> createFactory = createFactory(() -> Math.random() * 100, r -> r.intValue());
        Integer product = createFactory.create();
        System.out.println(product);

    }

    public static <T, R> IFactory<R> createFactory(IProducer<T> producer, IConfigurator<T, R> configurator) {
        return () -> {
            T product = producer.produce();
            System.out.println(product);
            R configured = configurator.configure(product);
            System.out.println(configured);
            return configured;
        };
    }
}
