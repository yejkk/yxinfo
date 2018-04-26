package open.yexin.com.yxinfomation.base;

import android.app.Application;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.UndeclaredThrowableException;

import open.yexin.com.yxinfomation.util.LogUtil;

/**
 * Created by yexin on 2018/3/20.
 */

public class BaseApplication extends Application {

    public final static String TAG = BaseApplication.class.getName();

    public static BaseApplication instance;

    public static BaseApplication getInstance() {
        return instance;
    }

    @Override
    public void  onCreate(){
        super.onCreate();
        int pid = android.os.Process.myPid();
        instance = this;
        Thread.setDefaultUncaughtExceptionHandler(uncaughtExceptionHandler);
        LogUtil.i(TAG, "Application oncreate  pid=" +pid);


    }

    /**
     * 捕获错误信息的handler
     */
    private Thread.UncaughtExceptionHandler uncaughtExceptionHandler = new Thread.UncaughtExceptionHandler() {

        @Override
        public void uncaughtException(Thread t, Throwable ex) {
            String msg = null;
            if (ex instanceof UndeclaredThrowableException){
                Throwable targetEx = ((UndeclaredThrowableException) ex).getUndeclaredThrowable();
                if (targetEx != null){
                    msg = targetEx.getMessage();
                }
            } else {
                msg = ex.getMessage();
            }

            String info = null;
            ByteArrayOutputStream baos = null;
            PrintStream printStream = null;
            try {
                baos = new ByteArrayOutputStream();
                printStream = new PrintStream(baos);
                ex.printStackTrace(printStream);
                byte[] data = baos.toByteArray();
                info = new String(data);
                data = null;
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    if (printStream != null) {
                        printStream.close();
                    }
                    if (baos != null) {
                        baos.close();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            LogUtil.i(TAG,info);
        }

    };


    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);

        switch (level) {
            case TRIM_MEMORY_UI_HIDDEN:
                LogUtil.d(TAG, "TRIM_MEMORY_UI_HIDDEN");
                break;
            case TRIM_MEMORY_RUNNING_MODERATE:
                LogUtil.d(TAG, "TRIM_MEMORY_RUNNING_MODERATE");
                break;
            case TRIM_MEMORY_RUNNING_LOW:
                LogUtil.d(TAG, "TRIM_MEMORY_RUNNING_LOW");
                break;
            case TRIM_MEMORY_RUNNING_CRITICAL:
                LogUtil.d(TAG, "TRIM_MEMORY_RUNNING_CRITICAL");
                break;
            case TRIM_MEMORY_BACKGROUND:
                LogUtil.d(TAG, "TRIM_MEMORY_BACKGROUND");
                break;
            case TRIM_MEMORY_MODERATE:
                LogUtil.d(TAG, "TRIM_MEMORY_MODERATE");
                break;
            case TRIM_MEMORY_COMPLETE:
                LogUtil.d(TAG, "TRIM_MEMORY_COMPLETE");
                break;
            default:
                LogUtil.d(TAG, "unknown level: " + level);
                break;
        }
    }
}
