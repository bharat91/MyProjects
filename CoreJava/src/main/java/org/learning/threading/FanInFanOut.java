package org.learning.threading;

import java.util.ArrayList;

public class FanInFanOut {

    public static void main(String[] args) throws InterruptedException {
        new FanOutFanInJob(50, 4).run();
    }

    static class FanOutFanInJob {
        ArrayList<Integer> items;
        ArrayList<Thread> threads;
        int i;

        public FanOutFanInJob(int count, int threads) {
            this.items = new ArrayList<Integer>(count);
            this.threads = new ArrayList<>(4);

            for (int i = 1; i <= count; i++) {
                this.items.add(i);
            }
        }

        private synchronized void printNext() {
            printItem(i);
            i++;
            notify();
        }

        private void printItem(int index) {
            System.out.println(Thread.currentThread().getName() + "  :  " + index);
        }

        void run() throws InterruptedException {
            i = 0;
            while (i <= 10) {
                printNext();
            }
            /**
             * Current Problem: some numbers get printed twice
             * Assignment: fix that.
             */

            // print 11 to 40 using 4 threads
            for (int j = 0; j < 4; j++) {
                threads.add(new Thread(() -> {
                    while (i <= 40) {
                        printNext();
                    }
                }));
            }

            threads.forEach(Thread::start);
            for (Thread thread : threads) {
                thread.join();
            }

            // print 41-50 using single thread again
            while (i <= 50) {
                printNext();
            }
        }
    }
}
