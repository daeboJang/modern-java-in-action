package book.real_world_software.ch_02;

import book.real_world_software.common.BankTransaction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;

import static org.assertj.core.api.Assertions.*;


class BankStatementCSVParserTest {
    private  final BankStatementParser statementParser = new BankStatementCSVParser();

    @Test
    @DisplayName("1줄 파싱")
    public void shouldParseOneCorrectLine() {
        //given - when - then
        final String line = "30-01-2017,-50,Tesco";

        final BankTransaction result = statementParser.parseFrom(line);

        // 예상 결과 BankTransaction 인스턴스 생성
        final BankTransaction expected = new BankTransaction(LocalDate.of(2017, Month.JANUARY, 30), -50, "Tesco");
        final double tolerance = 0.0d;

        assertThat(result.getDate()).isEqualTo(expected.getDate());
        assertThat(result.getAmount()).isEqualTo(expected.getAmount());
        assertThat(result.getDate()).isEqualTo(expected.getDate());
    }

}