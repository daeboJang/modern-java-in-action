package book.RealWorldSoftwareDev.ch_02;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

/**
 * 1.입력읽기 (파일, DB 등등)
 * 2. 주어진 형식의 입력 파싱
 * 3. 결과 처리
 * 4. 결과 요약 리포트
 */
public class MainApplication {
    private static final String RESOURCES = "src/main/resources/";

    public static void main(String[] args) throws IOException {
        final String filename = args[0];
        final Path path = Paths.get(RESOURCES + filename);
        final List<String> lines = Files.readAllLines(path);

        // 1줄을 BankTransaction type으로
        // 파일에서 읽은 lines 를 List 구조로 만들어 파서에 넘김

        BankStatementCSVParser bankStatementParser = new BankStatementCSVParser();
        final List<BankTransaction> bankTransactions = bankStatementParser.parse(lines);

        /**
         * 입출금 내역 분석기 첫 예제
         * ========================
         * - 총 수입과 지출은 얼마인가?
         * - 특정 달엔 몇 건의 입충금 내역이 발셍하는가?
         * - 지출이 가장 높은 상위 10건은 무엇인가?
         * - 돈을 가장 많이 지출하는 항목은 무엇?
         */
//        bankTransactions.stream()

        System.out.println("======================================");
        System.out.println("total amount is " + calculateTotalAmount(bankTransactions));
        System.out.println("거래내역 in January is " + calculateTotalAmount(selectInMonth(bankTransactions, Month.JANUARY)));

    }

    public static double calculateTotalAmount(List<BankTransaction> bankTransactions) {
        double sum  = 0d;
        for ( BankTransaction bt: bankTransactions) {
            sum += bt.getAmount();
        }
        return sum;
    }

    /**
     * 특정달의 거래내역 리스트를 반환한다
     * @param bankTransactions
     * @param month
     * @return List<BankTransaction>
     */
    public static List<BankTransaction> selectInMonth(final List<BankTransaction> bankTransactions, final Month month) {
        final List<BankTransaction> bankTransactionsInMonth = new ArrayList<>();
        for (final BankTransaction bankTransaction: bankTransactions) {
            /**
             * LocalDate, Month 타입과 getMonth() 메서드
             * java 에서 날짜, 시간을 다루는 방법
             */
            if (bankTransaction.getDate().getMonth() == month) {
                bankTransactionsInMonth.add(bankTransaction);
            }
        }
        return bankTransactionsInMonth;
    }
}
