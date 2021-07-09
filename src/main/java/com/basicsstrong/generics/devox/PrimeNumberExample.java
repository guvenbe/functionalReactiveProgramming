package com.basicsstrong.generics.devox;

import java.util.function.Predicate;
import java.util.stream.IntStream;

public class PrimeNumberExample {
    public static void main(String[] args) {
        System.out.println(isPrime(1));
        System.out.println(isPrime(2));
        System.out.println(isPrime(3));
        System.out.println(isPrime(4));
        System.out.println(isPrime(453443430));
    }

    private static boolean isPrime(final int number) {
        Predicate<Integer> isDivisable =divisor -> number % divisor == 0;
//        return number>1 &&
//                IntStream.range(2,number)
//                .noneMatch(index ->number % index==0);
        return number>1 &&
        IntStream.range(2,number)
        .noneMatch(index -> isDivisable.test(index));
    }
}
