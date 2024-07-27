package day_0727.test03;

import java.io.IOException;
import java.net.Socket;

public class TCPClientMain {
    public static void main(String[] args) throws IOException {
        System.out.println("서버에게 연결을 시도합니다!");
        /**
         * 서버가 실행되지 않았으면 에러 발생 : ConnectException
         * 클라이언트가 한 번 연결을 맺고 다시 시도 해도 에러 발생 : ConnectionException
         */
        Socket socket = new Socket("127.0.0.1", 9999);
        System.out.println("서버가 요청을 받아줬습니다.");

        Thread lisnten = new ListenThread(socket);
        Thread speak = new SpeakThread(socket);

        lisnten.start();
        speak.start();
    }
}
