package book.real_world_software.ch_03;

import book.real_world_software.common.BankTransaction;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

public class BankStatementCSVParser implements BankStatementParser {
    // 상수처럼 쓰인다.
    private static final String CSV_SEPERATOR = ",";
    private static final DateTimeFormatter DATE_PATTERN = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public BankStatementCSVParser() {
    }

    public BankTransaction parseFrom(String line) {
        final String[] columns = line.split(CSV_SEPERATOR);

        final LocalDate date = LocalDate.parse(columns[0], DATE_PATTERN);
        final double amount = Double.parseDouble(columns[1]);

        return new BankTransaction(date, amount, columns[2]);
    }

    public List<BankTransaction> parseLinesFrom(List<String> lines) {
        // 아래코드를 refactoring
        // 와, 간단하다!!!
        return lines.stream().map(this::parseFrom).collect(Collectors.toList());

        /*
        final List<BankTransaction> bankTransactions = new ArrayList<>();

        // 빈파일인지 검사는 어디서??
        if(lines.size() < 1) {
            return null;
        }

        for (final String line: lines) {
            bankTransactions.add(parseFrom(line));
        }
        return bankTransactions;
        */
    }
}
