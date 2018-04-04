package open.yexin.com.yxinfomation.util;

import android.util.Log;

/**
 * Created by yexin on 2018/3/26.
 */

public class LogUtil {

    public final static String TAG = LogUtil.class.getName();


    public static void v(String tag, String msg) {
        Log.v(tag, msg);
    }

    public static void d(String tag, String msg) {
        Log.d(tag, msg);
    }

    public static void i(String tag, String msg) {
        Log.i(tag, msg);
    }

    public static void w(String tag, String msg) {
        Log.w(tag, msg);
    }

    public static void e(String tag, String msg) {
        Log.d(tag, msg);
    }
}
