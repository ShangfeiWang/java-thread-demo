package com.wsf.queue.demo;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author wsf
 * @since 20220623
 */
public class LinkedBlockingQueueDemo {

    public static void main(String[] args) throws InterruptedException {
        LinkedBlockingQueue<Integer> linkedBlockingQueue = new LinkedBlockingQueue<>(3);
        linkedBlockingQueue.offer(1);
        System.out.println(linkedBlockingQueue.take());
        System.out.println(linkedBlockingQueue.size());

    }

}
