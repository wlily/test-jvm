package com.wll.test.jvm.classloader;

import com.wll.test.jvm.classloader.myClassloader.FileSystemClassLoader;

/**
 * A class is identified by both classloader and class itself
 */
public class TestClassIdentity {
    private static String DIR = "C:\\Users\\ezlilwa\\Desktop\\jvmtest\\";
    private static String NAME = "TestClassIdentity$Rose.class";

    /**
     * Different class loader load the same class file
     * @throws ClassNotFoundException
     */
    static void test1() throws ClassNotFoundException {
        FileSystemClassLoader cl1 = new FileSystemClassLoader(DIR);
        System.out.println(cl1.loadClass(NAME) == TestClassIdentity.Rose.class);
    }

    /**
     * Different class loader instances load the same class file
     * @throws ClassNotFoundException
     */
    static void test2() throws ClassNotFoundException {
        FileSystemClassLoader cl1 = new FileSystemClassLoader(DIR);
        FileSystemClassLoader cl2 = new FileSystemClassLoader(DIR);
        System.out.println(cl1.loadClass(NAME) == cl2.loadClass(NAME));
    }

    /**
     * Different class loader loaded class cast
     */
    static void test3() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Flower f1 = (Flower)new FileSystemClassLoader(DIR).loadClass(NAME).newInstance();
        Flower f2 = (Flower)new FileSystemClassLoader(DIR).loadClass(NAME).newInstance();
        f1 = f2;
    }

    public interface Flower{
    }

    public static class Rose implements Flower{
    }

    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        TestClassIdentity.test1();
        TestClassIdentity.test2();
        TestClassIdentity.test3();
    }
}
