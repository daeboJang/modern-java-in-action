package kwanghee;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Map01 {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();

        map.put("blue", 96);
        map.put("hong", 86);
        map.put("jang", 99);
        map.put("white", 78);
        map.put("white2", 50);

        // 지역변수임
        String answer1 = "";
        int highScore = 0 ;
        int avgScore = 0;

        // 1.최고 점수 받은 아이디
//        map.entrySet().stream().filter(); // stream으로 할 수 있을 거 같은데
        for ( Map.Entry<String,Integer> entry : map.entrySet()) {
            // 이렇게 할수도 있지만
        }

        // stream 을 사용하여
        // comparator 를 람다식으로 정의
        answer1 = map.entrySet().stream().max((e1, e2) -> {
            return e1.getValue() - e2.getValue();
        }).orElse(null).getKey();

        // 정렬해서 출력
        map.entrySet().stream().sorted((e1, e2) -> {
            return e2.getValue() - e1.getValue();
        }).forEach(System.out::println);

        // 2.최고 점수는
        // sol) values() 로 구한다
        for (int val: map.values()) {
            if (val > highScore) {
                highScore = val;
            }
        }

        highScore = 0;
        highScore= map.entrySet().stream().mapToInt(entry -> entry.getValue()).max().getAsInt();

        // 3.점수 평균
        int total = 0;
//        for (int val: map.values()) {
//            total += val;
//        }

        int scoreSum = map.values().stream().mapToInt(v -> v).sum();
        avgScore = (int) map.entrySet().stream().mapToInt(entry -> entry.getValue()).average().getAsDouble();
//        avgScore =  scoreSum / map.size();

        System.out.printf("누구: %s , 최고점수: %d , 평균점수: %d", answer1, highScore, avgScore);
    }
}
