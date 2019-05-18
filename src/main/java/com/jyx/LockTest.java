package com.jyx;

import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class LockTest {
    public static void main(String[] args) {
        ReentrantLock t = new ReentrantLock();
        ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock();
        rwLock.writeLock().lock();
    }
}
