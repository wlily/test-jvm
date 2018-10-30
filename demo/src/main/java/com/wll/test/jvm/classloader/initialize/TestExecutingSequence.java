package com.wll.test.jvm.classloader.initialize;

/**
 * 测试初始化执行顺序
 * 1. 父类static变量初始化, static代码块按照声明顺序执行
 * 2. 子类static变量初始化, static代码块按照声明顺序执行
 * 3. 父类实例变量初始化, 构造函数
 * 4. 子类实例变量初始化, 构造函数
 */
public class TestExecutingSequence {

    public static void main(String[] args) {
        new Son();
    }
}
