package paho.mqtt.java.example.service;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.IBinder;
import android.support.v7.app.NotificationCompat;
import android.util.Log;

import paho.mqtt.java.example.R;

import static android.content.ContentValues.TAG;

/**
 * Created by liangzhenghui on 2018/1/25.
 */

public class BootstrapService extends Service {
    private static int notificationId = 666;
    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "BootstrapService: onCreate()");
        startForeground(this);
        // stop self to clear the notification
        stopSelf();
    }
    @Override
    public IBinder onBind(Intent intent) {
        // What we pass back to the Activity on binding -
        // a reference to ourself, and the activityToken
        // we were given when started
        return null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        stopForeground(true);
    }

    public static void startForeground(Service context){
        //定义一个notification
        NotificationManager   notificationManager = (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(context);
        Bitmap largeIcon = ((BitmapDrawable) context.getResources().getDrawable(R.mipmap.ic_launcher)).getBitmap();
        notificationBuilder.setLargeIcon(largeIcon)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("色情App")
                .setContentText("正在运行中");
        Notification notification = notificationBuilder.getNotification();
        //把该service创建为前台service
        context.startForeground(notificationId, notification);
    }
}
