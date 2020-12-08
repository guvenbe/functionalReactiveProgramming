package functional.functionalinterface;

import java.util.List;
import java.util.function.Consumer;

public class ConsumerPractice {
    public static void main(String[] args) {
        List<Integer> list = List.of(34,66,5,7,8,3,4589,89);
        Consumer<Integer> consumer = e-> System.out.println(e);
        consumer.accept(56);
        printElements(list,consumer);
    }

    private static <T>void printElements(List<T> list, Consumer<T> consumer) {
        for (T t : list) {
            consumer.accept(t);
        }
    }
}
