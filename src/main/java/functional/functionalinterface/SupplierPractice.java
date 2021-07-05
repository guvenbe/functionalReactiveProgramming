package functional.functionalinterface;

import java.util.function.Supplier;

public class SupplierPractice {
    public static void main(String[] args) {
        Supplier<String> stringSupplier = ()-> new String("A string");
        System.out.println(stringSupplier.get());

//        Supplier<Double> randomNumber = () -> Math.random();
        Supplier<Double> randomNumber = Math::random;
        System.out.println(randomNumber.get());
    }
}
