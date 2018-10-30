package com.wll.test.jvm.classloader;

/**
 * check where Object is loaded from
 */
public class TestWhereObjectLoaded {

    //set xbootclasspath=C:\Users\ezlilwa\1-study\1-code\test-jvm\hacker\target\classes
    //set classpath=hacker\target\classes
    //set mainclass=com.wll.test.jvm.classloader.TestWhereObjectLoaded
    //java -verbose:class -cp %classpath% %mainclass%

    public static void main(String[] args) {
        new Object();
    }
}

//java -Xbootclasspath/p:%xbootclasspath% -verbose:class -cp %classpath% %mainclass%
//java -Xbootclasspath/a:%xbootclasspath% -verbose:class -cp %classpath% %mainclass%
//java -Xbootclasspath:%xbootclasspath% -verbose:class -cp %classpath% %mainclass%
