package com.example.leetcodeserver.question.thread;


import java.util.HashSet;
import java.util.Set;

public class TestThread {
    private final static Object lock = new Object();
    private static volatile Set<String> stringSet = new HashSet<>();
    private static volatile Set<Object> stringSet1 = new HashSet<>();
    private volatile static Integer i = 1;
    public static void main(String[] args) {


        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    while (i <= 100) {
                        if (i % 2 == 0) {
                            System.out.println(Thread.currentThread().getName() + i++);
                            lock.notifyAll();
                        } else {
                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        };
        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    while (i <= 100) {
                        if (i % 2 == 1) {
                            System.out.println(Thread.currentThread().getName() + i++);
                            lock.notifyAll();
                        } else {
                            try {
                                lock.wait();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        };

        Thread thread1 = new Thread(runnable);
        thread1.setName("Thread-1: ");
        thread1.start();
        Thread thread2 = new Thread(runnable1);
        thread2.setName("Thread-2: ");
        thread2.start();
    }
}
