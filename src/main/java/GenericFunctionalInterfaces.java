@FunctionalInterface
interface FunctionalGenric<T, R>{
    R execute(T t);
}

public class GenericFunctionalInterfaces {

    public static void main(String[] args) {
        FunctionalGenric<String, String> fun = s -> s.substring(1,5);
        String ret =fun.execute("BasicString");
        System.out.println(ret);

        FunctionalGenric<String, Integer> fun1 = s-> s.length();
        int len = fun1.execute("Hello World");
        System.out.println(len);
    }
}
