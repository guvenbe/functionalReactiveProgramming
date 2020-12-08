package functional.functionalinterface;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PracticePredicate {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Basics");
        list.add("");
        list.add("Strong");
        list.add("");
        list.add("BasicsStrong");

        Predicate<String> predicate = s->!s.isEmpty();

        List<String> newList= filterList(list, predicate);
        System.out.println(newList);

        Predicate<String> filter = s-> s.contains("Basics");

        List<String> filteredList = filterList(list, filter);

        System.out.println(filteredList);

        List<Integer> intList = List.of(1,2,3,4,5,6,7,8,9,10);
        Predicate<Integer> integerFilter = e -> e%2==0;
        List<Integer> evensList = filterList(intList,integerFilter);
        System.out.println(evensList);
    }

    private static <T> List<T> filterList(List<T> list, Predicate<T> predicate) {
        List<T> newList = new ArrayList<>();
        for (T t : list) {
            if(predicate.test(t)){
                newList.add(t);
            }
        }
        return newList;
    }
}
