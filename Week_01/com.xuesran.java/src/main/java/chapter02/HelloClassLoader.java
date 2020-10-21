package chapter02;

import java.io.*;

/**
 * 自定义加载Hello.class类加载器
 *
 * @author xueshun
 */
public class HelloClassLoader extends ClassLoader {

    public HelloClassLoader(ClassLoader parent) {
        super(parent);
    }

    public HelloClassLoader() {
    }

    @Override
    protected Class<?> findClass(String name) {
        String path = this.getClass().getResource("/Hello.class").getPath();
        File file = new File(path);
        int length = (int) file.length();
        byte[] bytes = new byte[length];
        try {
            new FileInputStream(file).read(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] = (byte) (255 - bytes[i]);
        }
        return defineClass(name, bytes, 0, bytes.length);
    }

}
