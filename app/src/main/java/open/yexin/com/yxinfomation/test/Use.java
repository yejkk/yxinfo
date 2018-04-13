package open.yexin.com.yxinfomation.test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import okhttp3.internal.platform.Platform;


/**
 * Created by yexin on 2018/4/13.
 */

public class Use {


    public <T> void testNeo(final Class<T> service){
        Proxy.newProxyInstance(service.getClassLoader(), new Class<?>[] { service },
                new InvocationHandler() {
                    private final Platform platform = Platform.get();

                    @Override public Object invoke(Object proxy, Method method,  Object[] args)
                            throws Throwable {
                        // If the method is a method from Object then defer to normal invocation.
                        if (method.getDeclaringClass() == Object.class) {
                            return method.invoke(this, args);
                        }

                    }
                });
    }

    public void test(){
        Use use = new Use();
        use.testNeo(Xuanji.class);
    }

}
