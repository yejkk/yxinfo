package open.yexin.com.yxinfomation.api;


import io.reactivex.Observable;
import open.yexin.com.yxinfomation.data.Login;
import open.yexin.com.yxinfomation.data.LoginParams;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * Created by yexin on 2018/3/26.
 */

public interface ApiService {

    @POST("login")
    Observable<Login> heartBeat (@Body LoginParams mLoginParams);
}
