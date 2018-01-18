package com.ryl.eventbuslib;


import org.greenrobot.eventbus.EventBus;

/**
 * Created by TANG on 2016/5/17.
 */
public class EventBusHelper {

    public static void post(Object object) {
        EventBus.getDefault().post(object);
    }
}
