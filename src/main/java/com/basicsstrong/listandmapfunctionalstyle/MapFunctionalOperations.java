package com.basicsstrong.listandmapfunctionalstyle;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MapFunctionalOperations {
    public static void main(String[] args) {
        Map<String,String > contacts = new HashMap<>();
        contacts.put("1237589020", "John");
        contacts.put("1237009020", "John");
        contacts.put("7890291111", "Neal");
        contacts.put("2647210290", "Raju");
        contacts.put("9999999999", "Peter");
        contacts.put("9081234567", "Neha");

        //Imperative
        for(Map.Entry<String,String> entry: contacts.entrySet()){
            System.out.println(entry.getKey() +" - "+ entry.getValue());
        }
        //Functional
        System.out.println("--------------------------");
        contacts.forEach((k,v)-> System.out.println(k + " -" + v));

        //Filter
        System.out.println("--------------------------");
        contacts.entrySet().stream()
                .filter(contact -> contact.getValue().equalsIgnoreCase("John"))
                .forEach(System.out::println);


        Map<String, String> filteredContacts = contacts.entrySet().stream()
                .filter(contact -> contact.getValue().equalsIgnoreCase("John"))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        System.out.println(filteredContacts);

        //Map
        contacts.entrySet().stream()
                .distinct()
                .map(c->c.getValue())
                .forEach(System.out::println);
        //or
        String names = contacts.entrySet().stream()
                .distinct()
                .map(c -> c.getValue())
                .collect(Collectors.joining(","));
        System.out.println(names);

        //sort
        LinkedHashMap<String, String> sortedMap = contacts.entrySet().stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(
                        Collectors
                                .toMap(c -> c.getKey(),
                                        c -> c.getValue(),
                                        (v1, v2) -> v1,
                                        LinkedHashMap::new));//Hash map not in sorted order

        sortedMap.forEach((k,v)->System.out.println(k +"-"+v));

        //reduce
        Map<String,Double> marks = new HashMap<>();
        marks.put("Science", 66.00);
        marks.put("Maths", 78.00);
        marks.put("English", 90.00);
        OptionalDouble average = marks.values().stream()
                .mapToDouble(m -> m)
                .average();

        System.out.println(average.getAsDouble());
    }

}
