package day_0727.test04;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class MultiChattingServer {
    private List<UserThread> userList; // 접속한 모든 사용자 담당 쓰레드를 여기 다 모아놓는다.
    private ServerSocket serverSocket; // 새로 접속하는 참여자가 있을 때마다 소켓을 생성해야 한다.

    public MultiChattingServer() {
        userList = new ArrayList<>();

        try {
            serverSocket = new ServerSocket(9999);
            while (true) { // 소켓으로 메세지 주고받는 것은 신경안쓰고 그냥 사용자를 계속 받아서 전체 관리만한다.
                System.out.println("클라이언트 대기중..");
                Socket socket = serverSocket.accept(); // 여기가 실행되면 클라이언트가 하나 또 접속한거다.
                System.out.println("접속 들어옴! : " + socket.getInetAddress());

                UserThread t = new UserThread(socket);
                userList.add(t);
                t.start();
            }

        } catch (IOException e) {
            System.out.println("프로그램이 종료됩니다. 서버 종료");
            throw new RuntimeException(e);
        }
    }

    public void broadcast(String msg) { // 현재 서버가 여러 쓰레드를 리스트로 유지중. 모든 쓰레드에게 speak 하라고 명령하기.
        for (UserThread user : userList) {
            user.speak(msg);
        }
    }

    public void removeUser(UserThread user) {
        userList.remove(user);
    }

    // 나는 중재자이고, 지급 접속한 한명의 사용자를 담당하는 하나의 쓰레드를 돌려놓는다.
    class UserThread extends Thread {
        private String nicname;
        private BufferedReader br;
        private BufferedWriter bw;

        public UserThread(Socket socket) {
            try {
                br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        @Override
        public void run() {
            try {
                nicname = br.readLine(); // 일단 이 사용자 메세지 오기 전에 가장 첫 메세지를 닉네임으로 쓰자.
                broadcast(nicname + "님이 입장하셨습니다.");
                while (true) {
                    String msg = br.readLine();
                    broadcast("["+nicname+"] : "+msg);
                }
            } catch (IOException e) {
                removeUser(this); // 현재 내 객체를 이제 리스트에서 지워준다.
                System.out.println(userList);
                System.out.println(nicname + " 사용자가 퇴장하셨습니다.");
            }
        }

        public void speak(String sendMsg) {
            try {
                bw.write(sendMsg + "\n");
                bw.flush();
            } catch (IOException e) {
                System.out.println(nicname + "님이 더이상 유효하지 않습니다.");
            }
        }
    }

    public static void main(String[] args) {
        MultiChattingServer server = new MultiChattingServer();
    }
}
