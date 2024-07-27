package day_0727.test02;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TCPServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("서버 연결 오기를 기다리는중...");
        Socket socket = serverSocket.accept();
        System.out.println("연결 들어옴! 클라이언트와 소켓 확보!");

        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
                        Scanner sc = new Scanner(System.in);
                        String msg = sc.nextLine();
                        bw.write(msg + "\n");
                        bw.flush();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread.start();

        while (true) {
            System.out.println("서버는 계속 응답 대기중 >> " + br.readLine());
        }
    }
}
