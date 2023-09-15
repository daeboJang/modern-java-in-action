package kwanghee.ch03;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * 예제 3-2
 */
public class PredicateSample {
    public static void main(String[] args) {
        List<String> listOfStrings = Arrays.asList("apple", "", "orange", "", "banana");

        Predicate<String> nonEmptyStringPredicate = (String s) -> !s.isEmpty();
        List<String> nonEmpty = filter(listOfStrings, nonEmptyStringPredicate);

        System.out.println(nonEmpty);
    }

    public static <T> List<T> filter(List<T> list, Predicate<T> p) {
        List<T> result = new ArrayList<>();
        for (T t : list) {
            if (p.test(t)) {
                result.add(t);
            }
        }
        return  result;
    }
}
