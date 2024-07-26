package day_0726.test02;

public class MyThread extends Thread{
    private Bank bank;

    public MyThread(Bank bank) {
        this.bank = bank;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            bank.plus();
            bank.minus();
        }
    }
}
