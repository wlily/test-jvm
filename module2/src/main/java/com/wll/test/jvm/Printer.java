package com.wll.test.jvm;

public class Printer {

    public void print() {
        System.out.println("####Classloader is: " + this.getClass().getClassLoader());
        System.out.println("####The number is: " + TestImpl.number);
    }
}
