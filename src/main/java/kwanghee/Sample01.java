package kwanghee;

import java.util.Arrays;
import java.util.List;

import java.lang.Math;

public class Sample01 {
    public static void main(String[] args) {
        List<String> myList = Arrays.asList("i", "am", "a", "boy", "!", "You", "ard", "a", "girl", "?");        // mutable


        int jdx = 0;    //초기화
        // 1~100건 : 1회
        // 101~200 : 2회
        for (int idx=0; idx < myList.size(); idx++) {
            //1.some process
            jdx++;

            if (jdx > 100) {
                //2. 저장 프로세스
                System.out.println("=============");
                jdx = 0;    //다시 초기화
            }
            System.out.println(myList.get(idx));
        }

        //2. 저장 프로세스
        System.out.println("=============");
    }
}
