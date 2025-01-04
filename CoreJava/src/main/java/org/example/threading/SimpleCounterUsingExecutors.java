package org.example.threading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SimpleCounterUsingExecutors {

    static int MAX_THREADS = 3;
    static int count = 1;
    public static void main(String[] args) throws InterruptedException {

        ExecutorService executor = Executors.newCachedThreadPool();
        final Object lock = new Object();
        Runnable task = () -> {

                while (true) {
                    synchronized (lock) {
                        if (count > 50) {
                            lock.notifyAll();
                            break;
                        }
                        System.out.println("Count is " + count + " by Thread name " + Thread.currentThread().getName());
                        count++;
                        lock.notifyAll();
                        try{
                            lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }

                    }
                }

        };

        for(int i=0;i<MAX_THREADS;i++){
            executor.submit(task);
        }


        executor.awaitTermination(2, TimeUnit.SECONDS);
        executor.shutdown();
    }
}
