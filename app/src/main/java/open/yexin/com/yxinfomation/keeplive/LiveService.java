package open.yexin.com.yxinfomation.keeplive;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by yexin on 2018/3/26.
 */

public class LiveService extends Service {

    private static final String TAG = LiveService.class.getName();

    @Override
    public void onCreate() {
        Log.i(TAG,"MyService is oncreate");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TAG, "MyProcessActivity is created: ");
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        Log.i(TAG,"OnDestory");
    }


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


}
