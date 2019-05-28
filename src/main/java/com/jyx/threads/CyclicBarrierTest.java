package com.jyx.threads;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author: jiangyexin
 * @Description:
 * @Date: 2019-05-28 21:24
 **/
public class CyclicBarrierTest {

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(50);
        for (int i = 0; i < 200; i++) {
            Worker worker = new Worker(i, cyclicBarrier);
            new Thread(worker).start();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}

class Worker implements Runnable {
    private int state;
    private CyclicBarrier cyclicBarrier;
    public Worker(int s, CyclicBarrier c) {
        state = s;
        cyclicBarrier = c;
    }

    @Override
    public void run() {
        System.out.println("Worker " + state + " begin---------------------!" + System.currentTimeMillis());
        try {
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        System.out.println("Worker " + state + " is do worker!" + System.currentTimeMillis());
    }
}