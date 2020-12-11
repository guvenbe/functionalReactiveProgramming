package functional.optional;

import java.util.Optional;

public class Operations {
    public static void main(String[] args) {
        Optional<String> optional =Optional.of("Value");
        //map return transformed value
        Optional<String> map = optional.map(val -> "Replaced");
        System.out.println(map.orElseGet(()->"No Value present"));

        Optional<String> optionalEmpty =Optional.empty();
        String result = optionalEmpty.map(s -> "Replaced").orElseGet(() -> "empty");
        System.out.println(result);

        //filter
        Optional<String> filter = optional.filter(val -> val.equalsIgnoreCase("Value"));
        System.out.println(filter.get());
        //flatmap (it self return an optional)
        Optional<String> flatMap = optional.flatMap(val -> Optional.of("ReplACED"));
        System.out.println(flatMap.orElseGet(()->"empty"));
    }
}
