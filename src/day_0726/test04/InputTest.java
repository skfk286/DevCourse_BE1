package day_0726.test04;

import java.io.*;

public class InputTest {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("ttttt2")));

        System.out.println(br.readLine());
        br.close();
    }
}
