package com.calendar2345;

/**
 * Created by fanxh on 2017/10/12.
 */

public interface HttpCallBackListener {
    void onFinish(String response);
    void onError(Exception e);
}
