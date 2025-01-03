package org.example.threading;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class UsingExecutors {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newCachedThreadPool();

        Runnable task = () -> {
            for(int i=0;i<5;i++){
                System.out.println("count "+i+" by Thread "+Thread.currentThread().getName());
            }
        };

        for (int i = 0; i < 20; i++) {
            executor.submit(task);
        }
        executor.awaitTermination(2, TimeUnit.SECONDS);
    }
}
