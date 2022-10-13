package test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class test {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class runtimeClass=Class.forName("java.lang.Runtime");
        Method getRuntimeMethod = runtimeClass.getMethod("getRuntime",null);
        Runtime r = (Runtime) getRuntimeMethod.invoke(null,null);
        Method execMethod = runtimeClass.getMethod("exec",String.class);
        execMethod.invoke(r,"calc");
//        Object runtime=runtimeClass.getMethod("getRuntime").invoke(null);// getRuntime是静态方法，invoke时不需要传入对象
//        runtimeClass.getMethod("exec", String.class).invoke(runtime,"calc.exe");
    }
}
