package com.wsf.queue.demo;

import org.junit.Test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author wsf
 * @since 20220623
 */
public class ArrayBlockingQueueDemo {

    public static void main(String[] args) throws InterruptedException {
        ArrayBlockingQueue<Integer> arrayBlockingQueue = new ArrayBlockingQueue<>(1);

        boolean add = arrayBlockingQueue.add(1);
        System.out.println(add);

        // add 方法如果队列满了会抛出异常
        //boolean add2 = arrayBlockingQueue.add(1);
        //System.out.println(add2);

        // offer方法如果添加不进去会返回false
        boolean offer = arrayBlockingQueue.offer(1);
        System.out.println(offer);

        // offer(1, 1, TimeUnit.SECONDS);  如果阻塞1秒超时退出
        boolean offerTimeout = arrayBlockingQueue.offer(1, 1, TimeUnit.SECONDS);
        System.out.println(offerTimeout);

        // put方法如果队列满了的话，那么就会阻塞在这里
        arrayBlockingQueue.put(2);
        System.out.println("end...");

    }

    @Test
    public void testGet() throws InterruptedException {
        ArrayBlockingQueue<Integer> arrayBlockingQueue = new ArrayBlockingQueue<>(1);
        boolean add = arrayBlockingQueue.add(1);
        System.out.println(add);

        // remove方法如果没有元素那么会抛出异常 java.util.NoSuchElementException
        System.out.println(arrayBlockingQueue.remove());
        // poll()方法如果没有元素那么会返回null
        System.out.println(arrayBlockingQueue.poll());
        // take()方法如果获取不到元素那么就会一直阻塞在那里
        // arrayBlockingQueue.take();
        System.out.println("end ....");

    }

}
