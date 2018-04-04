package open.yexin.com.yxinfomation.base;

import android.support.annotation.CallSuper;

import java.util.Stack;

/**
 * Created by yexin on 2018/3/20.
 */

public abstract class BaseManager<T> {

    private Stack<T> objectStack = new Stack<T>();

    @CallSuper
    public void save(T t) {
        objectStack.push(t);
    }

    @CallSuper
    public T getOnly() {
        return objectStack.size() == 0 ? null : objectStack.peek();
    }

    @CallSuper
    public T remove(){
        return objectStack.pop();
    }

    public abstract void finish();

    public abstract void finishAll();
}
