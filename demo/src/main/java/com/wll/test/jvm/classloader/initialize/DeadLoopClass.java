package com.wll.test.jvm.classloader.initialize;

/**
 * Demo of Initialization
 * 初始化阶段是执行类构造器<clinit>()方法的过程
 * 虚拟机会保证一个类的<clinit>()方法在多线程环境中被正确地加锁和同步,如果多个线程同时去初始化一个类,
 * 那么只会有一个线程去执行这个类的<clinit>方法,其他线程都需要阻塞等待,直到活动线程执行<clinit>()方法完毕.
 * 如果一个类的<clinit>()方法中有耗时很长的操作, 那就可能造成多个线程阻塞, 在实际应用中这种阻塞往往是很隐蔽的.
 */
public class DeadLoopClass {
    static {
        if(true){
            System.out.println(Thread.currentThread() + " init DeadLoopClass");
            while (true){
            }
        }
    }

    public static void main(String[] args) {
        Runnable script = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread() + " start");
                DeadLoopClass dls = new DeadLoopClass();
                System.out.println(Thread.currentThread() + " run over");
            }
        };
        Thread thread1 = new Thread(script);
        Thread thread2 = new Thread(script);
        thread1.start();
        thread2.start();
    }
}
