package book.RealWorldSoftwareDev.ch_02;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class BankStatementCSVParser {
    private static final String CSV_SEPERATOR = ",";
    private static final DateTimeFormatter DATE_PATTERN = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public BankStatementCSVParser() {
    }

    public List<BankTransaction> parse(List<String> lines) {
        final List<BankTransaction> bankTransactions = new ArrayList<>();
        // 빈파일인지 검사는 어디서??
        if(lines.size() < 1) {
            return null;
        }

        for (final String line: lines) {
            bankTransactions.add(pareFromCSV(line));
        }
        return bankTransactions;
    }

    private BankTransaction pareFromCSV(String line) {
        final String[] columns = line.split(CSV_SEPERATOR);

        final LocalDate date = LocalDate.parse(columns[0], DATE_PATTERN);
        final double amount = Double.parseDouble(columns[1]);
        final String description = columns[2];

        return new BankTransaction(date, amount, description);
    }
}
