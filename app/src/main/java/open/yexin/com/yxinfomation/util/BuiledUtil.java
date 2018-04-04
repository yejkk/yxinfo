package open.yexin.com.yxinfomation.util;


import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;

/**
 * Created by yexin on 2018/3/29.
 */

public class BuiledUtil {

    public static String getFlavorChannel(Context context) {
        PackageManager pm = context.getPackageManager();
        ApplicationInfo info = null;
        try {
            info = pm.getApplicationInfo(context.getPackageName(), PackageManager.GET_META_DATA);
            return info.metaData.getString("channel");
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return "";
    }
}
