package paho.mqtt.java.example.BroadcastReceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import paho.mqtt.java.example.service.MqttMessageHandleService;

import static android.content.ContentValues.TAG;

/**
 * Created by liangzhenghui on 2018/2/5.
 */

public class BootBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        //后边的XXX.class就是要启动的服务
        Log.v("-----------------","BootBroadcastReceiver: onReceive()");
        Intent service = new Intent(context, MqttMessageHandleService.class);
        context.startService(service);
    }
}
