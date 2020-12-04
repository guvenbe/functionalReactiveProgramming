package functional.lambda;

@FunctionalInterface
interface Name{
    public void get();
}

public class LambdaBiConsumer {

    public static void main(String[] args) {
        Name name = ()-> System.out.println("Bora");
        name.get();

    }
}

