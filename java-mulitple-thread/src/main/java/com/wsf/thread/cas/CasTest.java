package com.wsf.thread.cas;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author wsf
 * @since 20220623
 */
public class CasTest {

    public static void main(String[] args) {

        Account unSafeAccount = new UnSafeAccount(10000);
        Account.demo(unSafeAccount);

        CasAccount casAccount = new CasAccount(10000);
        Account.demo(casAccount);
    }
}

class UnSafeAccount implements Account {

    private Integer balance;

    public UnSafeAccount(Integer balance) {
        this.balance = balance;
    }

    @Override
    public Integer getBalance() {
        synchronized (this) {
            return this.balance;
        }
    }

    @Override
    public void withdraw(Integer amount) {
        synchronized (this) {
            this.balance = balance - amount;
        }
    }
}

class CasAccount implements Account {

    private AtomicInteger atomicInteger;

    public CasAccount(int balance) {
        this.atomicInteger = new AtomicInteger(balance);
    }

    @Override
    public Integer getBalance() {
        return atomicInteger.get();
    }

    @Override
    public void withdraw(Integer amount) {
        while (true) {
            int prev = atomicInteger.get();
            int update = prev - amount;
            boolean b = atomicInteger.compareAndSet(prev, update);
            if (b) {
                break;
            }
        }
    }
}

interface Account {

    Integer getBalance();

    void withdraw(Integer amount);

    static void demo(Account account) {
        List<Thread> threadList = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            Thread thread = new Thread(() -> {
                account.withdraw(10);
            });
            threadList.add(thread);
        }
        Long startTime = System.nanoTime();
        threadList.forEach(Thread::start);
        threadList.forEach(t -> {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Long endTime = System.nanoTime();
        System.out.println(account.getBalance());
        System.out.println("cost：" + (endTime - startTime) / 1000_000);
    }
}
