package functional.lambda;
interface LengthOfString2 {
    public int apply(String s);
}

public class LambdaMultiLine {
    public static void main(String[] args) {
        LengthOfString2 ls =(s)->{
            int len = s.length();
            System.out.println("Length of the string=" + len);
            return len;
        };
        ls.apply("Row, Row your baot");

    }
}
