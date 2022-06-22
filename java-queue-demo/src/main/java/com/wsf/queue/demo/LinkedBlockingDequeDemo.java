package com.wsf.queue.demo;

import java.util.concurrent.LinkedBlockingDeque;

/**
 * @author wsf
 * @since 20220623
 */
public class LinkedBlockingDequeDemo {

    public static void main(String[] args) throws InterruptedException {
        // Deque是支持双向链表的，既可以头插法 也可以尾插法
        LinkedBlockingDeque<Integer> linkedBlockingDeque = new LinkedBlockingDeque<>();
        linkedBlockingDeque.addFirst(1);
        linkedBlockingDeque.addFirst(2);
        linkedBlockingDeque.addLast(3);
        linkedBlockingDeque.addLast(4);
        System.out.println(linkedBlockingDeque);

        System.out.println(linkedBlockingDeque.getFirst());
        System.out.println(linkedBlockingDeque.take());
        System.out.println(linkedBlockingDeque.element());
        System.out.println(linkedBlockingDeque.peek());
    }

}
