package open.yexin.com.yxinfomation.base;

import android.app.Activity;

/**
 * Created by yexin on 2018/3/26.
 */

public class  BaseActivityManager extends BaseManager<Activity>{


    @Override
    public void finish() {
        remove().finish();
    }

    @Override
    public void finishAll() {
         while(null != getOnly()){
             remove().finish();
         }
    }
}
