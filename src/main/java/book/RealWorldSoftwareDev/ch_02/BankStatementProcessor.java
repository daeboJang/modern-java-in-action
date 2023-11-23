package book.RealWorldSoftwareDev.ch_02;

import book.RealWorldSoftwareDev.common.BankTransaction;

import java.time.Month;
import java.util.List;

public class BankStatementProcessor {

    private final List<BankTransaction> bankTransactions;

    public BankStatementProcessor(List<BankTransaction> bankTransactions) {
        this.bankTransactions = bankTransactions;
    }

    public double calculateTotalAmount() {
        double sum  = 0d;
        for ( BankTransaction bt: bankTransactions) {
            sum += bt.getAmount();
        }
        return sum;
    }

    /**
     * 특정달의 거래내역 리스트를 반환한다
     * @param month 검색월
     * @return List<BankTransaction>
     */
    public double calculateTotalInMonth(final Month month) {
        double total = 0;
        for (final BankTransaction bankTransaction: bankTransactions) {
            /*
             * LocalDate, Month 타입과 getMonth() 메서드
             * java 에서 날짜, 시간을 다루는 방법
             */
            if (bankTransaction.getDate().getMonth() == month) {
                total += bankTransaction.getAmount();
            }
        }
        return total;
    }

    /**
     * 특정 category 의 합을 반환한다
     * @param category 카테고리
     * @return double (default 0)
     */
    public double calculateTotalForCategory(final String category) {
        double total = 0;
        for (final BankTransaction bankTransaction: bankTransactions) {
            if (category.equals(bankTransaction.getDescription())) {
                total += bankTransaction.getAmount();
            }
        }
        return  total;
    }
}
