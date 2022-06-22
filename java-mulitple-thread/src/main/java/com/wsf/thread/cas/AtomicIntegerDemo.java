package com.wsf.thread.cas;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author wsf
 * @since 20220623
 */
public class AtomicIntegerDemo {

    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(0);

        System.out.println(atomicInteger.incrementAndGet()); //1
        System.out.println(atomicInteger.getAndIncrement()); //1

        System.out.println(atomicInteger.addAndGet(2));// 4
        System.out.println(atomicInteger.getAndAdd(2));// 4

        System.out.println(atomicInteger.updateAndGet(x -> x + 3)); // 9
        System.out.println(atomicInteger.getAndUpdate(x -> x + 3)); // 9
    }

}
