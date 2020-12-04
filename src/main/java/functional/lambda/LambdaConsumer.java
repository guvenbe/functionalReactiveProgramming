package functional.lambda;

@FunctionalInterface
interface MathOperation{
    public void accept(int a , int b);
}

public class LambdaConsumer {
    public static void main(String[] args) {

        MathOperation add = (a,b) -> System.out.println(a+b);
        add.accept(1,2);

        MathOperation multiply =(a,b)-> System.out.println(a*b);
        multiply.accept(4,5);
    }
}
