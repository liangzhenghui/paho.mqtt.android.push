package paho.mqtt.java.example.BroadcastReceiver;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.NotificationCompat;

import java.util.Date;
import java.util.UUID;

import paho.mqtt.java.example.MainActivity;
import paho.mqtt.java.example.R;

import static android.R.id.message;

/**
 * Created by liangzhenghui on 2018/1/24.
 */

public class SinobestPushReceiver extends BroadcastReceiver{
    private NotificationCompat.Builder notificationBuilder;
    private NotificationManager notificationManager ;
    @Override
    public void onReceive(Context context, Intent intent) {
        String msg = intent.getStringExtra("msg");
        initNotification(context);
        startNotification(context,msg);
    }
    private void initNotification(Context context) {
        notificationManager = (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationBuilder = new NotificationCompat.Builder(context);
    }
    private void startNotification(Context context,String message) {

        // params
        Bitmap largeIcon = ((BitmapDrawable) context.getResources().getDrawable(R.mipmap.ic_launcher)).getBitmap();
        Intent intent = new Intent(context,MainActivity.class);
        intent.putExtra("msg",message);
        notificationBuilder.setLargeIcon(largeIcon)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("推送消息啦")
                .setContentText(message)
                .setTicker(message)
                .setContentIntent(PendingIntent.getActivity(context, 0, intent, 0));
        Notification notification = notificationBuilder.getNotification();
        notificationManager.notify((int)new Date().getTime(), notification);
    }
}
