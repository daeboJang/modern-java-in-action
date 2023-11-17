package book.RealWorldSoftwareDev.ch_02;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

import java.time.LocalDate;
import java.time.Month;

class BankStatementCSVParserTest {
    private  final BankStatementParser statementParser = new BankStatementCSVParser();

    @Test
    public void test1() {
//        Assertions.fail("not yet implemented!!");
        final String line = "30-01-2017,-50,Tesco";

        final BankTransaction result = statementParser.parseFrom(line);

        final BankTransaction expected = new BankTransaction(LocalDate.of(2017, Month.JANUARY, 30), -50, "Tesco");
        final double tolerance = 0.0d;

        assertThat(expected.getDate()).isEqualTo(result.getDate());
        assertThat(result.getAmount()).isEqualTo(50);
    }

}