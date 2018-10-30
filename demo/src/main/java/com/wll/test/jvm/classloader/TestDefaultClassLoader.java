package com.wll.test.jvm.classloader;

import sun.misc.Launcher;

/**
 * Test three default class loaders
 */
public class TestDefaultClassLoader {

    /**
     * Three default classloader
     * Both AppClassLoader and ExtClassLoader are loaded by BootstrapClassLoader
     */
    static void testDefaultClassLoader(){
        System.out.println(ClassLoader.getSystemClassLoader());
        System.out.println(ClassLoader.getSystemClassLoader().getParent());
        System.out.println(ClassLoader.getSystemClassLoader().getParent().getParent());

        System.out.println(ClassLoader.getSystemClassLoader().getClass().getClassLoader());
        System.out.println(ClassLoader.getSystemClassLoader().getParent().getClass().getClassLoader());
        System.out.println(Class.class.getClassLoader());
    }

    /**
     * Can you specify any classloader to any class?
     * Absolutely not
     * Every classloader has its own searching path
     */
    static void testLoadPath(){
        System.out.println(System.getProperty("sun.boot.class.path"));
        System.out.println(Launcher.getBootstrapClassPath());
        System.out.println(System.getProperty("java.ext.dirs"));
        System.out.println(System.getProperty("java.class.path"));
    }

    /**
     * Main class is loaded by AppClassLoader
     */
    static void testClassLoaderOfMainClass(){
        System.out.println(TestDefaultClassLoader.class.getClassLoader());
    }

    public static void main(String[] args) {
        TestDefaultClassLoader.testLoadPath();
        TestDefaultClassLoader.testDefaultClassLoader();
        TestDefaultClassLoader.testClassLoaderOfMainClass();
    }
}
