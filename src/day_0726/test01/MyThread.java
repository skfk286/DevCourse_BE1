package day_0726.test01;

public class MyThread extends Thread {
    private String name;
    private int time;

    MyThread(String name, int time) {
        this.name = name;
        this.time = time;
    }

    @Override
    public void run() { // 해당 일꾼 객체가 생성되서 일 시작.
        for (int i = 0; i < time; i++) {
            System.out.println(name+" 일하고 있습니다~ "+i);
        }

        System.out.println(name+"이 모든 작업을 완료하였습니다.");
    }
}
