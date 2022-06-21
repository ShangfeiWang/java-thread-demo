package com.wsf.thread.test;

import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

/**
 * @author wsf
 * @since 20220623
 */

public class JoinTest {

    private int i = 10;

    @Test
    public void testJoin() throws InterruptedException {
        Thread thread = new Thread(() -> {
            try {
                TimeUnit.MILLISECONDS.sleep(1500);
                i = 20;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread.start();

        thread.join(1000);
        System.out.println(i);

        Thread.sleep(2000);
        System.out.println(i);
    }
}
