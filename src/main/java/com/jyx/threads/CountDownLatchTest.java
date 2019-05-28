package com.jyx.threads;

import java.util.concurrent.CountDownLatch;

/**
 * @author: jiangyexin
 * @Description:
 * @Date: 2019-05-28 22:04
 **/
public class CountDownLatchTest {
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        for (int i = 0; i < 10; i++) {
            Workerc worker = new Workerc(i, countDownLatch);
            new Thread(worker).start();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        countDownLatch.countDown();
    }
}

class Workerc implements Runnable {
    private int state;
    private CountDownLatch countDownLatch;
    public Workerc(int s, CountDownLatch c) {
        state = s;
        countDownLatch = c;
    }

    @Override
    public void run() {
        System.out.println("Worker " + state + " begin---------------------!" + System.currentTimeMillis());
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Worker " + state + " is do worker!" + System.currentTimeMillis());
    }
}