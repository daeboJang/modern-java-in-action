package book.real_world_software.ch_03;

import book.real_world_software.common.BankTransaction;

@FunctionalInterface
public interface BankTransactionFilter {
    boolean test(BankTransaction bankTransaction);
}
