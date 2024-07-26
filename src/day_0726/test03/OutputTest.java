package day_0726.test03;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class OutputTest {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("ttttt");

        // 2진수 던지기.
//        for(int i = 1 ; i < 10 ; i++){
//            fos.write(i);
//        }

        // 문자열 던지기. ex) 채팅같은 것.
        String msg = "안녕하세요.";
        byte[] bytes = msg.getBytes();

        for(byte b : bytes) {
            fos.write(b);
        }

        fos.close();
    }
}
