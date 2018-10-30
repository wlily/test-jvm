package com.wll.test.jvm.classloader.myClassloader;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URL;

/**
 * 在通过 NetworkClassLoader加载了某个版本的类之后，一般有两种做法来使用它。
 * 第一种做法是使用 Java 反射 API。另外一种做法是使用接口。
 * 需要注意的是，并不能直接在客户端代码中引用从服务器上下载的类，因为客户端代码的类加载器找不到这些类。
 * 使用 Java 反射 API 可以直接调用 Java 类的方法。
 * 而使用接口的做法则是把接口的类放在客户端中，从服务器上加载实现此接口的不同版本的类。
 * 在客户端通过相同的接口来使用这些实现类。
 */
public class NetworkClassLoader extends ClassLoader {

    private String rootUrl;

    public NetworkClassLoader(String rootUrl) {
        this.rootUrl = rootUrl;
    }

    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] classData = getClassData(name);
        if (classData == null) {
            throw new ClassNotFoundException();
        }
        else {
            return defineClass(name, classData, 0, classData.length);
        }
    }

    private byte[] getClassData(String className) {
        String path = classNameToPath(className);
        try {
            URL url = new URL(path);
            InputStream ins = url.openStream();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            int bufferSize = 4096;
            byte[] buffer = new byte[bufferSize];
            int bytesNumRead = 0;
            while ((bytesNumRead = ins.read(buffer)) != -1) {
                baos.write(buffer, 0, bytesNumRead);
            }
            return baos.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private String classNameToPath(String className) {
        return rootUrl + "/"
                + className.replace('.', '/') + ".class";
    }

    public static void main(String[] args) {
//        String url = "http://localhost:8080/ClassloaderTest/classes";
//        NetworkClassLoader ncl = new NetworkClassLoader(url);
//        String basicClassName = "com.example.CalculatorBasic";
//        String advancedClassName = "com.example.CalculatorAdvanced";
//        try {
//            Class<?> clazz = ncl.loadClass(basicClassName);
//            ICalculator calculator = (ICalculator) clazz.newInstance();
//            System.out.println(calculator.getVersion());
//            clazz = ncl.loadClass(advancedClassName);
//            calculator = (ICalculator) clazz.newInstance();
//            System.out.println(calculator.getVersion());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
}
