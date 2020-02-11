package ua.com.simplews.example.concurrency;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class ConcarrencyExample {

    public static class Account {
        private volatile int balance;

        private AtomicInteger failCount;

        public void incFailCount() {
            failCount.incrementAndGet();
        }

        ReentrantLock lock = new ReentrantLock();

        public ReentrantLock getLock() {
            return lock;
        }

        public Account(int balance) {
            this.balance = balance;
        }

        public void withdraw(int amount) {
            this.balance -= amount;
        }

        public void deposit(int amount) {
            this.balance += amount;
        }

        public int getBalance() {
            return balance;
        }

        public void setBalance(int balance) {
            this.balance = balance;
        }
    }

    static class Operation {
        public static void main(String[] args) {
            Account a = new Account(1000);
            Account b = new Account(2000);

            new Thread(() -> {
                transfer(a, b, 300);
            }).start();

            new Thread(() -> {
                transfer(a, b, 700);
            }).start();

            new Thread(() -> {
                transfer(a, b, 700);
            }).start();
        }

        static void transfer(Account acc1, Account acc2, int amount) throws IllegalArgumentException {

            if (acc1.getBalance() < 0) {
                System.out.println("ZOPA Exception ");
                throw new IllegalArgumentException();
            }
            synchronized (acc1) {
                synchronized (acc2) {
                    acc1.withdraw(amount);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    acc2.deposit(amount);
                    System.out.println("transfer succesful: acc1 =  " + acc1.getBalance() + " >acc2 > " + acc2.getBalance());
                }
            }
        }

    }

    static class TestThread implements Runnable {

        @Override
        public void run() {
            System.out.println("Runnable ");
        }
    }

    static class StartThread {
        public static void main(String[] args) {
            new Thread(new TestThread()).start();
            new Tu().start();
        }
    }

    static class Tu extends Thread {
        @Override
        public void run() {
            System.out.println("Run zopa2");
        }
    }


    class TransFero implements Callable<Boolean> {
        Account from;
        Account to;
        int amount;


        public TransFero(Account from, Account to, int amount) {
            this.from = from;
            this.to = to;
            this.amount = amount;
        }

        @Override
        public Boolean call() throws Exception {




            if(from.getLock().tryLock(2, TimeUnit.SECONDS)) {
                if (to.getLock().tryLock(2, TimeUnit.SECONDS)) {
                    to.deposit(from.getBalance());
                    return true;
                } else {
                    return false;
                }

            } else {
                return false;
            }
        }
    }

}
