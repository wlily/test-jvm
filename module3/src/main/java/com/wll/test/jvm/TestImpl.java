package com.wll.test.jvm;


import java.util.Random;

public class TestImpl implements Test {

    public static int number = -1;
    private Printer printer;

    public TestImpl() {
        printer = new Printer();
    }

    public void test() throws InterruptedException {
        if (number<0) number = Math.abs(new Random().nextInt(30));
        printer.print();
    }

}