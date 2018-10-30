package com.wll.test.jvm.classloader.myClassloader;

public class Worker {
    public Worker() {
        System.out.println("<<<<<<<<<<<<<<>>>>>>>>>>>>>>>>>>>【重磅消息】我被构造了");
    }
    public void doit() {
        System.out.println(this.getClass().getClassLoader().toString() + "--->----------------->6888222" );
    }
}