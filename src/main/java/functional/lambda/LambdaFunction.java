package functional.lambda;
interface LengthOfString{
    public int apply(String s);
}

public class LambdaFunction {
    public static void main(String[] args) {
        LengthOfString2 ls =(s)->s.length();
        int length =ls.apply("Hello world");
        System.out.println(length);
    }
}
