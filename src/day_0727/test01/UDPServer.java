package day_0727.test01;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPServer {
    public static void main(String[] args) throws IOException {
        DatagramSocket receiveSocket = new DatagramSocket(9999);
        System.out.println("서버 시작됨.");

        while (true) {
            // packet 은 저쪽에서 던지는 데이터 꾸러미(택배상자). receive 은 무인택배함이라고 상상.
            DatagramPacket receivedPacket = new DatagramPacket(new byte[1024], 1024);
            System.out.println("데이터 수신 대기중.");

            receiveSocket.receive(receivedPacket);
            String receiveMsg = new String(receivedPacket.getData(), 0, receivedPacket.getLength());
            System.out.println("메세지 수신함>> " + receiveMsg);
        }
    }
}
