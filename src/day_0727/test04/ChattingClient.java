package day_0727.test04;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ChattingClient {

    static class Listener extends Thread {
        BufferedReader br;

        Listener(Socket socket) throws IOException {
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        }

        @Override
        public void run() {
            try {
                while (true) {
                    String receiveMsg = br.readLine();
                    System.out.println(receiveMsg);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    static class Speak extends Thread {
        BufferedWriter bw;
        Scanner sc;

        Speak(Socket socket) throws IOException {
            bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            sc = new Scanner(System.in);
            System.out.print("당신의 닉네임을 입력하세요. :");
            String nickName = sc.nextLine();
            bw.write(nickName + "\n");
            bw.flush();
        }

        @Override
        public void run() {
            try {
                while(true) {
                    System.out.println("내가 보내는 메세지 : ");
                    String sendMsg = sc.nextLine();
                    bw.write(sendMsg+"\n");
                    bw.flush();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        // Socket socket = new Socket("127.0.0.1", 9999);
        Socket socket = new Socket("59.27.84.200", 9999);

        System.out.println("서버와 연결 성공!");

        new Listener(socket).start();
        new Speak(socket).start();
    }
}
