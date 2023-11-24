package book.RealWorldSoftwareDev.ch_03;

import book.RealWorldSoftwareDev.common.BankTransaction;

@FunctionalInterface
public interface BankTransactionFilter {
    boolean test(BankTransaction bankTransaction);
}
