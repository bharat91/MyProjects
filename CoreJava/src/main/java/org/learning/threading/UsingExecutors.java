package org.learning.threading;

import java.util.concurrent.*;

public class UsingExecutors {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
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
        executor.shutdown();
    }
}
