package com.wll.test.jvm.classloader.initialize;


public class NotInitialization {

    public static void main(String[] args) {
//        System.out.println(Son.bb);
        //常量在编译阶段会存入调用类的常量池中，本质上没有直接引用到定义常量的类，因此也不会触发定义常量的类的初始化。
        System.out.println(Son.aa);
        System.out.println(Son.HELLOWORLD);
        //
        Parent[] sca = new Parent[10];
    }
}
