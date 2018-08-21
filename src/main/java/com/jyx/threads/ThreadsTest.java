package com.jyx.threads;

import java.util.concurrent.*;

/**
 * @author: jiangyexin
 * @Description:
 * @Date: 2018-08-21 15:23
 **/
public class ThreadsTest {
    public static final int coreSize = 1;
    public static final int queueSize = 1;
    public static final int maxSize = 1;
    public static final long keepAliveTime = 60;//秒
    public static final LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue(queueSize);
    public static final RejectedExecutionHandlerImpl rejectedExe = new RejectedExecutionHandlerImpl();
    public static final ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(coreSize, maxSize,keepAliveTime, TimeUnit.SECONDS,linkedBlockingQueue,rejectedExe);
    public static void main(String[] args) {
        Runnable runnable = new RunnableImpl();
        Thread trun = new Thread(runnable);
        trun.start();

        Thread threadSub = new ThreadSub();
        threadSub.start();

        Callable callable = new CallableImpl();

        threadPoolExecutor.submit(runnable);

        threadPoolExecutor.submit(callable);
        threadPoolExecutor.submit(threadSub);


    }
}

/*多线程实现的几种方式*/

/*1、实现runable接口*/
class RunnableImpl implements Runnable {
    public static final String runnable = "RunnableImpl RunnableImpl";
    public void run() {
        while (true) {
            System.out.println("runableImpl runing");
            System.out.println(ThreadsTest.threadPoolExecutor.getQueue().size());
        }
    }
}

/*2、继承Thread*/
class ThreadSub extends Thread {
    public static final String threadSub = "ThreadSub ThreadSub";
    @Override
    public void run() {
        while (true) {
            System.out.println("ThreadSub runing");
        }
    }
}

/*3、实现callable接口*/

class CallableImpl implements Callable {
    public static final String call = "call callableimpl";
    public Object call() throws Exception {
        while (true) {
            System.out.println("CallableImpl runing");
        }
    }
}

class RejectedExecutionHandlerImpl implements RejectedExecutionHandler {
    public static final String msg = "被拒绝";
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        if (r instanceof ThreadSub) {
            System.out.println(((ThreadSub)r).threadSub + msg);
        }
        if (r instanceof RunnableImpl) {
            System.out.println(((RunnableImpl)r).runnable + msg);
        }
        if (r instanceof CallableImpl) {
            System.out.println(((CallableImpl)r).call + msg);
        }
        System.out.println(r);
    }
}


