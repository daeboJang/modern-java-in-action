package kwanghee;

import java.util.*;

/**
 * Stream 예제
 */
public class StreamTest {
    public static void main(String[] args) {
        List<String> words = new ArrayList<>();

        words.add("staple");
        words.add("aplest");
        words.add("taples");
        words.add("apple");
        words.add("eappl");

        anagrams(words);
    }

    private static void anagrams(final List<String> words) {
        final Map<String, Set<String>> groups = new HashMap<>();
        for (String word: words) {
            groups.computeIfAbsent(aplhabetize(word), (unused) -> new TreeSet<>()).add(word);
        }

        for (Set<String> group: groups.values()) {
            System.out.println(group.size() + ": " + group);
        }
    }

    private static String aplhabetize(String s) {
        char[] a = s.toCharArray();
        Arrays.sort(a);

        return new String(a);
    }
}
