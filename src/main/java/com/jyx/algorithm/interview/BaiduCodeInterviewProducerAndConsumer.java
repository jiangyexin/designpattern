package com.jyx.algorithm.interview;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * 生产者消费者
 * @author jiangyexin
 * @date 2021/9/9 14:59
 */
public class BaiduCodeInterviewProducerAndConsumer {

    public static void main(String[] args) {
        ArrayBlockingQueue<Integer> arrayBlockingQueue = new ArrayBlockingQueue(1);

        Thread tP = new Thread(new MyProducer(arrayBlockingQueue));
        Thread tC = new Thread(new MyConsumer(arrayBlockingQueue));

        tP.start();
        tC.start();
    }

    static class MyProducer implements Runnable {
        private ArrayBlockingQueue<Integer> arrayBlockingQueue;
        MyProducer(ArrayBlockingQueue arrayBlockingQueue) {
            this.arrayBlockingQueue = arrayBlockingQueue;
        }
        @Override
        public void run() {
            while (true) {
                try {
                    arrayBlockingQueue.put(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(1);
            }
        }
    }

    static class MyConsumer implements Runnable {
        private ArrayBlockingQueue arrayBlockingQueue;
        MyConsumer(ArrayBlockingQueue arrayBlockingQueue) {
            this.arrayBlockingQueue = arrayBlockingQueue;
        }
        @Override
        public void run() {
            while (true) {
                try {
                    arrayBlockingQueue.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(2);
            }
        }
    }
}
