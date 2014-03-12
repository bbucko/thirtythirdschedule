package pl.iogreen.thirtythree.schedule.service;

import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.gcm.GoogleCloudMessaging;

import pl.iogreen.thirtythree.schedule.gcm.ScheduleGCMService;

public class ScheduleService extends IntentService {

    private static final String TAG = ScheduleService.class.getSimpleName();

    public ScheduleService() {
        super("ScheduleService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        final Bundle extras = intent.getExtras();
        final GoogleCloudMessaging gcm = GoogleCloudMessaging.getInstance(this);

        final String messageType = gcm.getMessageType(intent);

        if (!extras.isEmpty()) {
            switch (messageType) {
                case GoogleCloudMessaging.MESSAGE_TYPE_SEND_ERROR:
                    Log.i(TAG, "Message Send Error");
                    break;
                case GoogleCloudMessaging.MESSAGE_TYPE_DELETED:
                    Log.i(TAG, "Message Type Deleted");
                    break;
                case GoogleCloudMessaging.MESSAGE_TYPE_MESSAGE:
                    Log.i(TAG, "Message Type Message");
                    break;
                default:
                    break;
            }
        }
        // Release the wake lock provided by the WakefulBroadcastReceiver.
        ScheduleGCMService.completeWakefulIntent(intent);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Toast.makeText(this, "ScheduleService starting", Toast.LENGTH_SHORT).show();
        return super.onStartCommand(intent, flags, startId);
    }
}
