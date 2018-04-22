import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * <pre>
 *
 * </pre>
 * Author: 王俊超
 * Date: 2018-02-22 17:50
 * Blog: http://blog.csdn.net/derrantcm
 * Github: https://github.com/wang-jun-chao
 * All Rights Reserved !!!
 */
public class MetadataAreaOverflow {
    static class OOMObject {
        private int[] array = new int[8*5432*1024*1024];
    }

    public static void main(String[] args) {
        while (true) {
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(OOMObject.class);
            enhancer.setUseCache(false);
            enhancer.setCallback(new MethodInterceptor() {
                @Override
                public Object intercept(Object obj, Method method,
                                        Object[] args, MethodProxy proxy) throws Throwable {
                    return method.invoke(obj, args);
                }
            });
            OOMObject proxy = (OOMObject) enhancer.create();
            System.out.println(proxy.getClass());
        }
    }
}
