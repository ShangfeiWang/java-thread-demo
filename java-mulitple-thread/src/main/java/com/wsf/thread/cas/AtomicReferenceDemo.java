package com.wsf.thread.cas;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @author wsf
 * @since 20220623
 */
public class AtomicReferenceDemo {

    public static void main(String[] args) {
        AtomicReferenceAccount account = new AtomicReferenceAccount(new BigDecimal("10000"));
        Account.demo(account);
    }

    static class AtomicReferenceAccount implements Account {

        private AtomicReference<BigDecimal> balance;

        public AtomicReferenceAccount(BigDecimal balance) {
            this.balance = new AtomicReference<>(balance);
        }

        @Override
        public BigDecimal getBalance() {
            return balance.get();
        }

        @Override
        public void drawAmount(BigDecimal drawAmount) {
            while (true) {
                BigDecimal prev = balance.get();
                BigDecimal subtract = prev.subtract(drawAmount);
                if (balance.compareAndSet(prev, subtract)) {
                    break;
                }
            }
        }
    }

    interface Account {

        BigDecimal getBalance();

        void drawAmount(BigDecimal drawAmount);

        static void demo(Account account) {
            List<Thread> threadList = new ArrayList<>();
            for (int i = 0; i < 1000; i++) {
                threadList.add(new Thread(() -> {
                    account.drawAmount(new BigDecimal(10));
                }));
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

}
