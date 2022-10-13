package classload;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public class urlclassloader {
    public static void main(String[] args) throws MalformedURLException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        URL[] urls = {new URL("Http://localhost:8000/")};
        URLClassLoader loader = URLClassLoader.newInstance(urls);
        Class c = loader.loadClass("Evil");
        c.newInstance();
    }
}
