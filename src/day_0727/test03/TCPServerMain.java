package day_0727.test03;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServerMain {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("서버 연결 오기를 기다리는중...");
        Socket socket = serverSocket.accept();
        System.out.println("연결 들어옴! 클라이언트와 소켓 확보!");

        Thread lisnten = new ListenThread(socket);
        Thread speak = new SpeakThread(socket);

        lisnten.start();
        speak.start();
    }
}
