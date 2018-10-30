package com.wll.test.jvm.classloader.myClassloader;

public class RamClassLoader extends ClassLoader {


    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        return super.findClass(name);
    }
}
