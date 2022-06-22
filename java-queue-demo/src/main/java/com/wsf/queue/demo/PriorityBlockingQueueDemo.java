package com.wsf.queue.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.stream.Collectors;

/**
 * @author wsf
 * @since 20220623
 */
public class PriorityBlockingQueueDemo {

    public static void main(String[] args) {
        // 降序
        PriorityBlockingQueue<Integer> priorityBlockingQueue = new PriorityBlockingQueue<>(10, (o1, o2) -> o2 - o1);
        priorityBlockingQueue.offer(3);
        priorityBlockingQueue.offer(8);
        priorityBlockingQueue.offer(5);
        priorityBlockingQueue.offer(4);
        System.out.println(priorityBlockingQueue);

        PriorityBlockingQueue<String> priorityBlockingQueue2 = new PriorityBlockingQueue<>(10, String::compareTo);
        priorityBlockingQueue2.offer("a");
        priorityBlockingQueue2.offer("d");
        priorityBlockingQueue2.offer("c");
        priorityBlockingQueue2.offer("b");
        System.out.println(priorityBlockingQueue2);

        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("d");
        list.add("c");
        list.add("b");
        list = list.stream().sorted(String::compareTo).collect(Collectors.toList());
        System.out.println(list);
    }

}
