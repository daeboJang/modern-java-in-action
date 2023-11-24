package book.RealWorldSoftwareDev.ch_03;

import book.RealWorldSoftwareDev.common.BankTransaction;

import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class BankStatementProcessor {

    private final List<BankTransaction> bankTransactions;

    public BankStatementProcessor(List<BankTransaction> bankTransactions) {
        this.bankTransactions = bankTransactions;
    }

    /**
     * 총 합 구하기
     * @return double 은행거래 금액의 총계
     */
    public double calculateTotalAmount() {
        return bankTransactions.stream().mapToDouble(BankTransaction::getAmount).sum();
    }

    /**
     * 특정달의 거래내역 리스트를 반환한다
     * @param month 검색월
     * @return List<BankTransaction>
     */
    public double calculateTotalInMonth(final Month month) {

        /*
         * LocalDate, Month 타입과 getMonth() 메서드
         * java 에서 날짜, 시간을 다루는 방법
         */
        List<BankTransaction> bankTransactions = findTransactions(bankTransaction ->
                bankTransaction.getDate().getMonth() == month
        );

        // stream 을 사용하여 합계 계산 리팩토링
        return bankTransactions.stream()
                .mapToDouble(BankTransaction::getAmount)
                .sum();
    }

    /**
     * 특정 category 의 합을 반환한다
     * @param category 카테고리
     * @return double (default 0)
     */
    public double calculateTotalForCategory(final String category) {
        // findTransactions 과 functional interface 를 사용하여 변경
        List<BankTransaction> transactions = findTransactions(bankTransaction ->
                bankTransaction.getDescription().equals(category) );

        return  transactions.stream()
                .mapToDouble(BankTransaction::getAmount)
                .sum();
    }

    /**
     * 툭정 금액 이상의 은행 거래 내역 찾기
     */
    public List<BankTransaction> findTransactionsGreaterThanOrEqual(final int amount) {
        final List<BankTransaction> result = new ArrayList<>();
        for (final BankTransaction bankTransaction: bankTransactions) {
            if (bankTransaction.getAmount() >= amount) {
                result.add(bankTransaction);
            }
        }
        return result;
    }

    /**
     * 특정 월의 입출금 내역 찾기
     */
    public List<BankTransaction> findTransactionsInMonth(final Month month) {
        final List<BankTransaction> result = new ArrayList<>();
        for (final BankTransaction bankTransaction: bankTransactions) {
            if (bankTransaction.getDate().getMonth() == month) {
                result.add(bankTransaction);
            }
        }
        return result;
    }

    /**
     * 특정 카테고리의 입출금 찾기
     */
    public List<BankTransaction> findTransactionsForCategory(final String category) {
        final List<BankTransaction> result = new ArrayList<>();
        for (final BankTransaction bankTransaction: bankTransactions) {
            if (bankTransaction.getDescription().equals(category)) {
                result.add(bankTransaction);
            }
        }
        return result;
    }

    /**
     * (공통) 특정 조건을 검사하여 List 를 반환하는 메서드
     * @param filter 조건 Predicate Functional Interface 구현체
     * @return List of BankTransactions
     */
    public List<BankTransaction> findTransactions(BankTransactionFilter filter) {
        final List<BankTransaction> result = new ArrayList<>();
        for (final BankTransaction bankTransaction: bankTransactions) {
            if (filter.test(bankTransaction)) {
                result.add(bankTransaction);
            }
        }
        return result;
    }


}
