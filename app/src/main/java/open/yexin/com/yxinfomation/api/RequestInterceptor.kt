package open.yexin.com.yxinfomation.api

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

/**
 * Created by yexin on 2018/4/19.
 */


class RequestInterceptor: Interceptor {

    init {

    }
    // 消息头
    private val HEADER_X_HB_Client_Type = "X-HB-Client-Type"
    private val FROM_ANDROID = "ayb-android"

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
                .newBuilder()
                .addHeader(HEADER_X_HB_Client_Type, FROM_ANDROID)
                .build()
        return chain.proceed(request)
    }



}