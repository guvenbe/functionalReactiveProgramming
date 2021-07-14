package com.basicsstrong.streams;

import java.util.List;
import java.util.stream.Collectors;

class StatelessStatefulOp {

    public static void main(String[] args) {

        List<Integer> list = List.of(1,2,4,5,6,7,9);

        List<Integer> collect = list
                .parallelStream()
                .skip(2) //Statefull operation
                .limit(5) //Statefull operation
                .collect(Collectors.toList());

    }

}
public class StatelessStateful {
}
