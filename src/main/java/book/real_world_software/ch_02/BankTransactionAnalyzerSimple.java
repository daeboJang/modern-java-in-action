package book.real_world_software.ch_02;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * 입출금 내역 분석기 첫 예제
 * ========================
 * - 총 수입과 지출은 얼마인가?
 * - 특정 달엔 몇 건의 입충금 내역이 발셍하느ㄴ가?
 * - 지출이 가장 높은 상위 10건은 무엇인가?
 * - 돈을 가장 많이 지출하는 항목은 무엇?
 */
public class BankTransactionAnalyzerSimple {
    private static final String RESOURCES = "src/main/resources/";

    public static void main(String[] args) throws IOException {

        final Path path = Paths.get(RESOURCES + args[0]);
        final List<String> lines = Files.readAllLines(path);
        double total = 0d;
        for (final String line: lines) {
            final String[] columns = line.split(",");
            final double amount = Double.parseDouble(columns[1]);
            total += amount;
        }

        System.out.println("The total for all transacions is " + total);
    }
}
