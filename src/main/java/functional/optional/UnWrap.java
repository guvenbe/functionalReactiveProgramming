package functional.optional;

import java.util.Optional;

public class UnWrap {
    public static void main(String[] args) {
        Integer a = 10;

        Optional<Integer> optional = Optional.of(a);

        //get
        Integer integerVal = optional.get(); //Don't unless you know it has a value
        System.out.println(integerVal);

        //NoSuchElementExceotion
        Optional<Integer> emptyOptional = Optional.empty();
        //emptyOptional.get();


        //instead do

        Integer val = optional.isPresent() ? optional.get() : 0;
        System.out.println(val);

        Integer val2 = emptyOptional.isPresent() ? optional.get() : 0;
        System.out.println(val2);

        //Beter way
        //orElse, orElseGet

        //orElse sets default value (It is always generated
        //may have performance immplicationm
        Integer orElse = optional.orElse(0);
        System.out.println(orElse);

        Integer orElseEmpty = emptyOptional.orElse(0);
        System.out.println(orElseEmpty);

        //orElseGet takes supplier and provide default value
        //only get generated when needed
        Integer orElseGet = emptyOptional.orElseGet(() -> 0);
        System.out.println(orElseGet);

        //For specific Exception (exception supplier)
        //orElseThrow
        //Integer orElseThrow = emptyOptional.orElseThrow(() -> new IllegalArgumentException());

        //java10 new overloaded version
        //orElseThrow() = get()

        Integer orElseThrowJava10 = emptyOptional.orElseThrow(); //throws java.util.NoSuchElementException: No value present


    }
}
