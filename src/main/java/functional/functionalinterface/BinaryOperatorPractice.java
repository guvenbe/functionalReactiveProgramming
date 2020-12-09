package functional.functionalinterface;

import java.util.function.BinaryOperator;

public class BinaryOperatorPractice {
    public static void main(String[] args) {
        BinaryOperator<String> operator = (a, b) -> a + "." + b;
        System.out.println(operator.apply("BasicStrong", "com"));
    }
}
