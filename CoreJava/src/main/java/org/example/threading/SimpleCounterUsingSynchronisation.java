package org.example.threading;

public class SimpleCounterUsingSynchronisation {

    public static int COUNT=1;
    public static void main(String[] args) {
        final Object lock = new Object();
        for (int i = 0; i < 4; i++) {
            Thread t = new Thread(() -> {
                while (true) {
                    synchronized (lock) {
                        if (COUNT > 50) {
                            lock.notifyAll();
                            break;
                        }
                        System.out.println("Count is " + COUNT + " by " + Thread.currentThread().getName());
                        COUNT++;
                        lock.notifyAll();
                        try{
                            lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }

                }
            });
            t.start();
        }
    }
}
