package com.jyx.algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class MyBlockingQueue<T> {
    private  List<T> container;
    private int capacity;
    private volatile int size;
    private  ReentrantLock lock = new ReentrantLock();
    private Condition isEmpty = lock.newCondition();
    private Condition isFull = lock.newCondition();

    MyBlockingQueue(int capacity) {
        this.capacity = capacity;
        container = new ArrayList<T>(capacity);
    }

    public void offer(T t) {
        lock.lock();
        try {
            while (size >= capacity) {
                System.out.println("队列满了了@@@@@@@@@@@@@@");
                isFull.await();
            }
            container.add(t);
            size++;
            isEmpty.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public T peek() {
        lock.lock();
        try {
            while (size == 0) {
                System.out.println("队列空了------------");
                isEmpty.await();
            }
            T t = container.remove(0);
            size--;
            isFull.signalAll();
            return t;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        MyBlockingQueue<Integer> myBlockingQueue = new MyBlockingQueue(10);
        Thread product = new Thread(() -> {
            for (int i =0; i < 100; i++) {
                myBlockingQueue.offer(i);
                System.out.println("生产： " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread consumer = new Thread(() -> {
            for (int i =0; i < 100; i++) {
                int t = myBlockingQueue.peek();
                System.out.println("消费： " + t);
                try {
                    Thread.sleep(700);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        product.start();
        consumer.start();
    }
}
