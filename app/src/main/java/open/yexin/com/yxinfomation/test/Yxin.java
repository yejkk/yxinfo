package open.yexin.com.yxinfomation.test;

/**
 * Created by yexin on 2018/4/13.
 */


import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/** Make a POST request. */
@Documented
@Target(METHOD)
@Retention(RUNTIME)
public @interface Yxin {

    String value() default "";
}
