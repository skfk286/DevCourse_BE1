package day_0726.test04;

import java.io.*;

public class OutputTest {
    public static void main(String[] args) throws IOException {
        // OutputStreamWriter : 문자열 처리 도와주는 클래스
        // BufferedWriter : 전송 효율성
        // FileOutputStream : 외부로 전송할 수 있는 선택 클래스
        // 이 위치를 네트워크 등으로 변경 가능하다.
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("ttttt2")));

        bw.write("이 메세지가 편하게 파일로 전달됩니다. 전송 효율도 보장한다.");
        bw.flush();
        bw.close();
    }
}
