package com.wll.test.jvm.classloader.initialize;

public class Son extends Parent {
    public static final String HELLOWORLD = "hello world";
    public final static int aa = 1;
    public static int bb = 2;
    private int cc = 3;

    static {
        System.out.println("Son static block");
    }

    public Son(){
        System.out.println("Son constructor");
    }
}
