package day_0726.test02;

public class Test {
    public static void main(String[] args) {
        System.out.println("시작..");
        Bank bank = new Bank();
        MyThread t1 = new MyThread(bank);
        MyThread t2 = new MyThread(bank);

        t1.start();
        t2.start();
    }
}
