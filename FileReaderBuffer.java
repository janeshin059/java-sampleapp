import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderBuffer {
    public static void main(String[] args) {
        String fileName = "evil"; // 파일 이름

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;

            System.out.println("--- 파일 내용 ---");
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            System.out.println("--- 읽기 완료 ---");

        } catch (IOException e) {
            System.err.println("파일을 읽는 중 오류 발생: " + e.getMessage());
        }
    }
}
