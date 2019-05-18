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
    public CountDownLatch countDownLatch = new CountDownLatch(10);
    public static void main(String[] args) {
        /*核心线程数和最大线程数都是 1 阻塞队列是 linkedBlockingQueue 默认队列大小是 int最大值*/
        Executor singleThreadExecutor = Executors.newSingleThreadExecutor();
        /*核心线程数和最大线程数都是 传入的值 阻塞队列是 linkedBlockingQueue 默认队列大小是 int最大值*/
        Executor fixedThreadPool = Executors.newFixedThreadPool(5);
        /*核心线程数 0 最大线程数 max int 传入的值 阻塞队列是 SynchronousQueue*/
        Executor cachedThreadPool = Executors.newCachedThreadPool();
        /*核心线程数 传入值 最大线程数 max int 传入的值 阻塞队列是 DelayedWorkQueue 延时队列*/
        Executor scheduledThreadPool = Executors.newScheduledThreadPool(5);
        Runnable runnable = new RunnableImpl();
        Runnable runnable1 = new RunnableImpl();
        Runnable runnable2 = new RunnableImpl();
        Runnable runnable3 = new RunnableImpl();

        Thread threadSub = new ThreadSub();

        Callable callable = new CallableImpl();

        threadPoolExecutor.submit(runnable);
        threadPoolExecutor.submit(runnable);
        threadPoolExecutor.submit(runnable);
        threadPoolExecutor.submit(runnable);
        threadPoolExecutor.submit(runnable);
        threadPoolExecutor.submit(runnable);


        Future future = threadPoolExecutor.submit(callable);
        threadPoolExecutor.submit(threadSub);

        try {
            Object o = future.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        while (true) {
            if (threadPoolExecutor.getQueue().size() > 1) {
                System.out.println("队列数大于1" + threadPoolExecutor.getQueue().size());
            }
        }
    }
}

/*多线程实现的几种方式*/

/*1、实现runable接口*/
class RunnableImpl implements Runnable {
    public static final String runnable = "RunnableImpl RunnableImpl";
    public void run() {
        while (true) {
            try {
                System.out.println("runableImpl runing");
                Thread.sleep(15000);
                System.out.println("runableImpl end");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}

/*2、继承Thread*/
class ThreadSub extends Thread {
    public static final String threadSub = "ThreadSub ThreadSub";
    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("ThreadSub runing");
                Thread.sleep(15000);
                System.out.println("ThreadSub end");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}

/*3、实现callable接口*/

class CallableImpl implements Callable {
    public static final String call = "call callableimpl";
    public Object call() throws Exception {
        while (true) {
            try {
                System.out.println("call runing");
                Thread.sleep(15000);
                System.out.println("call end");
            } catch (Exception ex) {
                ex.printStackTrace();
            }
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


