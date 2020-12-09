package functional.method.reference;

import java.util.function.BiFunction;

public class StaticReference {
    public static void main(String[] args) {
        BiFunction<String, String, String> biFunction = A_Class::staticMethod;
        System.out.println(biFunction.apply("Basics", "Strong"));
    }
}
