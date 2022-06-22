package com.wsf.queue.demo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.SynchronousQueue;

/**
 * @author wsf
 * @since 20220623
 */
public class SynchronousQueueDemo {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        SynchronousQueue<Integer> synchronousQueue = new SynchronousQueue<>();

        executorService.submit(() -> {
            try {
                synchronousQueue.put(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        executorService.submit(() -> {
            try {
                Integer take = synchronousQueue.take();
                Thread.sleep(3000);
                System.out.println(take);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        executorService.shutdown();
    }

}
