package day_0727.test03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ListenThread extends Thread {
    BufferedReader br;

    public ListenThread(Socket socket) {
        try {
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException e) {
            System.out.println("ListenThread 생성사 오류");
            throw new RuntimeException();
        }
    }

    @Override
    public void run() {
        try {
            while(true) {
                String msg = br.readLine();
                System.out.println("받은 메세지 : " + msg);
            }
        } catch (IOException e) {
            System.out.println("ListenThread 더이상 메세지 수신 못함.");
        }
    }
}
