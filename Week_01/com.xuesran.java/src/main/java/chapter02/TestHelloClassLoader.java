package chapter02;


import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 测试HelloClassLoader
 *
 * @author xueshun
 */
public class TestHelloClassLoader {

    public static void main(String[] args) {
        try {
            HelloClassLoader classLoader = new HelloClassLoader();
            Class<?> clazz = classLoader.findClass("Hello");
            Object o = clazz.newInstance();
            Method hello = clazz.getMethod("hello");
            hello.invoke(o);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
