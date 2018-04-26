package open.yexin.com.yxinfomation.data

import open.yexin.com.yxinfomation.test.fromNow
import open.yexin.com.yxinfomation.test.months
import open.yexin.com.yxinfomation.test.years

/**
 * Created by yexin on 2018/3/29.
 */


public data class LoginParams (var key:String ,var userId:String , var password:String)

public data class Login (var key:String ,var userId:String , var password:String)


class yxtest{

    val array = arrayOf(1,2,3)


    val test =  2 months fromNow   //中缀调用
    val test1 = 2.months(fromNow)
    val test2 = 2.years
}