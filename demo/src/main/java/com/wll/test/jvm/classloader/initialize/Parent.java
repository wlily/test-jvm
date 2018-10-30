package com.wll.test.jvm.classloader.initialize;

public class Parent {
    private static final int a = 1;
    private static int b = 2;
    private int c = 3;
    static{
        System.out.println("parent static block");
    }

    Parent(){
        System.out.println("parent constructor");
    }
}
