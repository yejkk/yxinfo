package open.yexin.com.yxinfomation.test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import okhttp3.internal.platform.Platform;


/**
 * Created by yexin on 2018/4/13.
 */

public class UseHandler implements InvocationHandler {

    private final Platform platform = Platform.get();

    public <T> T testNeo(final Class<T> service) {
        return (T) Proxy.newProxyInstance(service.getClassLoader(), new Class<?>[]{service},
                this);
    }

    public Object testNeo(final Object service) {
        return Proxy.newProxyInstance(service.getClass().getClassLoader(), new Class<?>[]{service.getClass()},
                this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args)
            throws Throwable {
        // If the method is a method from Object then defer to normal invocation.
        if (method.getDeclaringClass() == Object.class) {
            return method.invoke(this, args);
        }
        return  null;
    }

    public void test() {
        UseHandler use = new UseHandler();
        Object service = null;
        try {
            service = Class.forName("Xuanji").newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Xuanji test =(Xuanji) use.testNeo(Xuanji.class);
        test.test();
    }

}
