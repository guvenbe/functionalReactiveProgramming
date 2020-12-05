package lambda.lambdaunderthehood;


@FunctionalInterface
interface MyFunctionalInterface {
    public void myMethod();
}

public class LambdaUnderTheHood {
    public static void main(String[] args) {
        MyFunctionalInterface fun1 = new MyFunctionalInterface() {

            @Override
            public void myMethod() {
                System.out.println("Implementation 1");
            }
        };

        MyFunctionalInterface fun2 = new MyFunctionalInterface() {

            @Override
            public void myMethod() {
                System.out.println("Implementation 1");
            }
        };
        fun1.myMethod();
        fun2.myMethod();
        MyFunctionalInterface fun = () -> System.out.println("I am Light Weight");
        fun.myMethod();
    }


}
