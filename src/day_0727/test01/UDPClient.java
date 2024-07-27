package day_0727.test01;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;

public class UDPClient {
    public static void main(String[] args) throws IOException {
        // 데이터 내보내는게 목적이라 특정한 포트를 지정하지 않음.
        DatagramSocket sendSocket = new DatagramSocket();
        String msg = "안녕하세요. 정예찬입니다.";
        byte[] byteMsg = msg.getBytes(StandardCharsets.UTF_8);

        DatagramPacket sendPacket = new DatagramPacket(byteMsg, byteMsg.length, new InetSocketAddress("127.0.0.1", 9999));
        // DatagramPacket sendPacket = new DatagramPacket(byteMsg, byteMsg.length, new InetSocketAddress("59.27.84.200", 9999));

        System.out.println("데이터를 송신합니다.");
        sendSocket.send(sendPacket);
        System.out.println("데이터 송신 완료.");
    }
}
