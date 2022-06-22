package com.wsf.thread.test;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

/**
 * @author wsf
 * @since 20220623
 */
@Slf4j
public class InterruptTest {

    // 睡眠被打断
    @Test
    public void test1() throws InterruptedException {
        Thread thread = new Thread(() -> {
            try {
                TimeUnit.MILLISECONDS.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread.start();

        Thread.sleep(1000);
        thread.interrupt();
        log.debug("打断标记:{}", thread.isInterrupted());
    }

    // 执行过程中被打断
    @Test
    public void test2() {
        Thread thread = new Thread(() -> {
            while (true) {

            }
        });
        thread.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();
        log.debug("打断标记:{}", thread.isInterrupted());
    }

}
