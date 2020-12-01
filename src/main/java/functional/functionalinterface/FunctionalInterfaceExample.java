package functional.functionalinterface;

@FunctionalInterface
interface MyFunInterface{
    public void myMethod();
}

public class FunctionalInterfaceExample {
    public static void main(String[] args) {
        MyFunInterface fun = () -> System.out.println("Hello World!!");
        fun.myMethod();
        onTheFly(()-> System.out.println("Hello again!"));
    }

public static void onTheFly(MyFunInterface fun){
        fun.myMethod();
}
}
