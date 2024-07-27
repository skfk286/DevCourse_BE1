package day_0727.test02;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class TCPClient {
    public static void main(String[] args) throws IOException {
        System.out.println("서버에게 연결을 시도합니다!");
        /**
         * 서버가 실행되지 않았으면 에러 발생 : ConnectException
         * 클라이언트가 한 번 연결을 맺고 다시 시도 해도 에러 발생 : ConnectionException
         */
        Socket socket = new Socket("127.0.0.1", 9999);
        System.out.println("서버가 요청을 받아줬습니다.");

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        Scanner sc = new Scanner(System.in);

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                    while (true) {
                        System.out.println("클라이언트는 계속 응답 대기중 >> " + br.readLine());
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();

        while(true) {
            System.out.print("보낼 메세지 입력 >> ");
            String msg = sc.nextLine();
            bw.write(msg + "\n"); // 끝인 부분("\n")을 해야 된다.
            bw.flush();
        }
    }
}
