package book.RealWorldSoftwareDev.ch_03;

import book.RealWorldSoftwareDev.common.BankTransaction;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.List;

public class BankStatementAnalyzer {
    private static final String RESOURCES = "src/main/resources/";

    public void analyze(final String filename, final BankStatementParser bankStatementParser) throws IOException {
        // 파일을 읽어 1라인 -> String 로 변환한다.
        final Path path = Paths.get(RESOURCES + filename);
        final List<String> lines = Files.readAllLines(path);

        // 1줄을 Parsing 하여 BankTransaction type 변환으로
        // 파일에서 읽은 List<String> 을 파라미터로 넘김
//        BankStatementParser bankStatementParser = new BankStatementCSVParser();
        final List<BankTransaction> bankTransactions = bankStatementParser.parseLinesFrom(lines);

        final BankStatementProcessor bankStatementProcessor
                = new BankStatementProcessor(bankTransactions);

        collectSummary(bankStatementProcessor);
    }

    /*
     * 입출금 내역 분석기 첫 예제
     * ========================
     * - 총 수입과 지출은 얼마인가?
     * - 특정 달엔 몇 건의 입충금 내역이 발셍하는가?
     * - 지출이 가장 높은 상위 10건은 무엇인가?
     * - 돈을 가장 많이 지출하는 항목은 무엇?
     */
    private void collectSummary(final BankStatementProcessor bankStatementProcessor) {
        System.out.println("======================================");
        System.out.println("total amount is "
                + bankStatementProcessor.calculateTotalAmount());

        System.out.println("거래내역 in January is "
                + bankStatementProcessor.calculateTotalInMonth(Month.JANUARY));

        System.out.println("거래내역 in February is "
                + bankStatementProcessor.calculateTotalInMonth(Month.FEBRUARY));

        System.out.println("total amount of Salary is "
                + bankStatementProcessor.calculateTotalForCategory("Salary"));
    }

}
