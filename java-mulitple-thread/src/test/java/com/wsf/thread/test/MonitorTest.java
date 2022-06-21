package com.wsf.thread.test;

import lombok.extern.slf4j.Slf4j;

/**
 * @author wsf
 * @since 20220623
 */
public class MonitorTest {

    public static void main(String[] args) throws InterruptedException {
        TwoPhaseTermination twoPhaseTermination = new TwoPhaseTermination();
        twoPhaseTermination.start();

        Thread.sleep(3000);
        twoPhaseTermination.stop();
    }

}

@Slf4j(topic = "TwoPhaseTermination")
class TwoPhaseTermination {

    private Thread monitor;

    // 启动监控线程
    public void start() {
        monitor = new Thread(() -> {
            Thread thread = Thread.currentThread();
            while (true) {
                if (thread.isInterrupted()) {
                    log.debug("料理后事");
                    break;
                }
                try {
                    Thread.sleep(1000);
                    log.debug("执行监控。。。。");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    thread.interrupt();
                }
            }
        }, "t1");
        monitor.start();
    }

    public void stop() {
        monitor.interrupt();
    }
}
