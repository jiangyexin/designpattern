package com.jyx.threads;

import java.util.concurrent.Semaphore;

/**
 * @author: jiangyexin
 * @Description:
 * @Date: 2019-05-28 21:41
 **/
public class SemaphoreTest {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(10);
        try {
            semaphore.acquire(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < 10; i++) {
            Workers workers = new Workers(i, semaphore);
            new Thread(workers).start();
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        semaphore.release(10);
    }
}

class Workers implements Runnable {
    private int state;
    private Semaphore semaphore;
    public Workers(int s, Semaphore sem) {
        state = s;
        semaphore = sem;
    }

    @Override
    public void run() {
        System.out.println("Worker " + state + " begin---------------------!" + System.currentTimeMillis());
        try {
            semaphore.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Worker " + state + " is do worker!" + System.currentTimeMillis());
        semaphore.release();
    }
}
