package org.example.threading;

public class SimpleCounterUsingSynchronisation {

    public static int COUNT=1;
    public static void main(String[] args) {
        for (int i = 0; i < 4; i++) {
            Thread t = new Thread(() -> {
                while (true) {
                    synchronized (SimpleCounterUsingSynchronisation.class) {
                        if (COUNT > 50) {
                            break;
                        }
                        System.out.println("Count is " + COUNT + " by " + Thread.currentThread().getName());
                        COUNT++;
                    }

                }
            });
            t.start();
        }
    }
}
