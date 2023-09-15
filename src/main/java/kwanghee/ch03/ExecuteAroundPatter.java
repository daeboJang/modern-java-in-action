package kwanghee.ch03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ExecuteAroundPatter {
    public static void main(String[] args) {
        ExecuteAroundPatter program = new ExecuteAroundPatter();
        String what = program.processFile();

        System.out.println(what);
    }

    public String processFile() {
        try (BufferedReader br = new BufferedReader(new FileReader("D:\\Code\\Java\\modern-java\\out\\data.txt"))) {
            return br.readLine();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
