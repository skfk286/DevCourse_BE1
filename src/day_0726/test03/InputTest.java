package day_0726.test03;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class InputTest {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("ttttt");
            
        // 2진수 읽기
//        int b = 0;
//        while((b = fis.read())!= -1) {
//            System.out.println(b);
//        }
        
        // 문자열 읽기
        int b;
        byte[] buffer = new byte[30];
        int i=0;

        while ((b = fis.read()) != -1) {
            buffer[i++] = (byte) b;
        }

        fis.close();
    }
}
