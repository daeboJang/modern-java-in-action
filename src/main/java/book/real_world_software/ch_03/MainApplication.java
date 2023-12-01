package book.real_world_software.ch_03;

import java.io.IOException;

/**
 * 1.입력읽기 (파일, DB 등등)
 * 2. 주어진 형식의 입력 파싱
 * 3. 결과 처리
 * 4. 결과 요약 리포트
 */
public class MainApplication {

    public static void main(String[] args) throws IOException {
        final String filename = args[0];

        final BankStatementAnalyzer bankStatementAnalyzer
                = new BankStatementAnalyzer();

        final BankStatementParser bankStatementParser
                = new BankStatementCSVParser();

        // BankStatementAnalyzer 와 BankStatementCSVParser 결합 제거
        // BankStatementAnalyzer -> BankStatementParser <- BankStatementCSVParser
        bankStatementAnalyzer.analyze(filename, bankStatementParser);
    }

}
