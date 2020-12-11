package functional.optional;

import org.w3c.dom.ls.LSOutput;

import java.util.Optional;
import java.util.stream.Stream;

public class MoreOperations {
    public static void main(String[] args) {
        // if present
        Optional<String> optional = Optional.of("Value");
        optional.ifPresent(System.out :: println);
        optional.ifPresent(val-> System.out.println("This is a " + val));

        //ifPresentOrElse
        optional.ifPresentOrElse(System.out :: println, () -> System.out.println("Value is absent"));
        Optional.empty().ifPresentOrElse(System.out :: println, () -> System.out.println("Value is absent"));

        //stream
        optional.stream().forEach(System.out::println);
        Stream<String> stream = optional.stream();
        Optional.empty().stream().forEach(System.out::println);

        //or
        optional.or(()->Optional
                .of("New value")).ifPresent(System.out::println);
        Optional.empty()
                .or(()->Optional.of("New value"))
                .ifPresent(System.out::println);
        //Optional.empty().or(()->null).ifPresent(System.out::println); //null pointer
        //equals
        //optional - they noth have to be optional
        //either both ar empty
        //or if the values in optionals are equal to each other via equal method

        System.out.println(optional.equals(Optional.of("Value")));

        //hascode
        System.out.println(optional.hashCode());
        System.out.println(Optional.empty().hashCode());
    }
}
