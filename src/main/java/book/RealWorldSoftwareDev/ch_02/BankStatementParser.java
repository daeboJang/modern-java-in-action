package book.RealWorldSoftwareDev.ch_02;

import book.RealWorldSoftwareDev.common.BankTransaction;

import java.util.List;

public interface BankStatementParser {

    BankTransaction parseFrom(String line);
    List<BankTransaction> parseLinesFrom(List<String> lines);
}
