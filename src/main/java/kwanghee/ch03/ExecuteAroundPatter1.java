package kwanghee.ch03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

// 3.3 예제
public class ExecuteAroundPatter1 {
    public static void main(String[] args) {
        ExecuteAroundPatter1 program = new ExecuteAroundPatter1();
        String what = program.processFile();
        System.out.println(what);
        System.out.println("========================");

        try {
            String oneLine = program.processFile(BufferedReader::readLine); // 메서도 참조
            System.out.println( "one line : " + oneLine);

            String twoLine = program.processFile((BufferedReader br) -> br.readLine() + br.readLine());
            System.out.println("two line : " + twoLine);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String processFile() {
        try (BufferedReader br = new BufferedReader(new FileReader("D:\\Code\\Java\\modern-java\\out\\data.txt"))) {
            return br.readLine();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    // 함수형 인터페이스를 이용해서 동작 전달
    public String processFile(BufferedReaderProcessor p) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("D:\\Code\\Java\\modern-java\\out\\data.txt"))) {
            return p.process(br);
            // 설정 - 작업 - 정리
            // 실제 작업 부분을 분리하여 동작 파라미터화 하는 방법
        }
    }

    @FunctionalInterface
    public interface BufferedReaderProcessor {
        String process(BufferedReader br) throws IOException;
    }
}
