package com.wll.test.jvm.classloader;

public class TestParentDelegation {

    public static class Flower{

    }

    /**
     * put TestParentDelegation$Sample.class
     * under JAVA_HOME/jre/classes
     * or JAVA_HOME/jre/lib/ext, run again
     */
    public static void main(String[] args) {
        System.out.println(TestParentDelegation.Flower.class.getClassLoader());
    }
}
