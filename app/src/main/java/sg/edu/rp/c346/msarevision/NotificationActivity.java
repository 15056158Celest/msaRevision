package sg.edu.rp.c346.msarevision;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Calendar;

public class NotificationActivity extends AppCompatActivity {

    Button btnNormal, btnBigText, btnInbox, btnBigPicture;
    int reqCode = 12345;
    int notificationID = 888;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);

        btnBigPicture = (Button)findViewById(R.id.btnBigPicture);
        btnBigText = (Button) findViewById(R.id.btnBigText);
        btnInbox = (Button) findViewById(R.id.btnInbox);
        btnNormal = (Button) findViewById(R.id.btnNormalNotification);

        btnNormal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NotificationActivity.this, NotificationActivity.class);

                PendingIntent pIntent = PendingIntent.getActivity(NotificationActivity.this,
                        reqCode, intent, PendingIntent.FLAG_CANCEL_CURRENT);

                Notification.Builder builder = new Notification.Builder(

                        NotificationActivity.this );
                builder.setContentTitle("Amazing Offer!");
                builder.setContentText("Subject");
                builder.setSmallIcon(R.mipmap.ic_launcher);
                builder.setContentIntent(pIntent);
                builder.setAutoCancel(true);

                Uri uri = RingtoneManager.getDefaultUri
                        (RingtoneManager.TYPE_NOTIFICATION);
                builder.setSound(uri);
                builder.setPriority(Notification.PRIORITY_HIGH);

                Notification n = builder.build();
                NotificationManager notificationManager = (NotificationManager)
                        getSystemService(NOTIFICATION_SERVICE);

                notificationManager.notify(notificationID, n);
                finish();


            }
        });
        btnBigText.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NotificationActivity.this, NotificationActivity.class);

                PendingIntent pIntent = PendingIntent.getActivity(NotificationActivity.this,
                        reqCode, intent, PendingIntent.FLAG_CANCEL_CURRENT);

                //build Notification

                Notification.BigTextStyle bigText = new Notification.BigTextStyle();
                bigText.setBigContentTitle("Promotions - BuySell.com");
                bigText.bigText("Sale - June 2016");
                bigText.setSummaryText("Click to check for unbelievable promotions");


                Notification.Builder builder = new Notification.Builder(
                        NotificationActivity.this
                );
                builder.setContentTitle("Amazing Offer");
                builder.setContentText("Brought to you by BuySell.com");
                builder.setContentIntent(pIntent);
                builder.setSmallIcon(R.mipmap.ic_launcher);
                builder.setAutoCancel(true);
                builder.setStyle(bigText);


                Uri uri = RingtoneManager.getDefaultUri
                        (RingtoneManager.TYPE_NOTIFICATION);
                builder.setSound(uri);
                builder.setPriority(Notification.PRIORITY_HIGH);

                Notification n = builder.build();
                NotificationManager notificationManager = (NotificationManager)
                        getSystemService(NOTIFICATION_SERVICE);

                notificationManager.notify(notificationID, n);
                finish();

            }
        });

        btnInbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NotificationActivity.this, NotificationActivity.class);

                PendingIntent pIntent = PendingIntent.getActivity(NotificationActivity.this,
                        reqCode, intent, PendingIntent.FLAG_CANCEL_CURRENT);

                //build Notification

                Notification.InboxStyle inboxStyle = new Notification.InboxStyle();
                inboxStyle.addLine("This is the first");
                inboxStyle.addLine("This is the second");
                inboxStyle.addLine("This is the third");
                inboxStyle.addLine("This is the fourth");
                inboxStyle.setBigContentTitle("Inbox style");
                inboxStyle.setSummaryText("List of entries");

                Notification.Builder builder = new Notification.Builder(
                        NotificationActivity.this
                );
                builder.setContentTitle("Amazing Offer");
                builder.setContentText("Brought to you by BuySell.com");
                builder.setContentIntent(pIntent);
                builder.setSmallIcon(R.mipmap.ic_launcher);
                builder.setAutoCancel(true);
                builder.setStyle(inboxStyle);


                Uri uri = RingtoneManager.getDefaultUri
                        (RingtoneManager.TYPE_NOTIFICATION);
                builder.setSound(uri);
                builder.setPriority(Notification.PRIORITY_HIGH);

                Notification n = builder.build();
                NotificationManager notificationManager = (NotificationManager)
                        getSystemService(NOTIFICATION_SERVICE);

                notificationManager.notify(notificationID, n);
                finish();



            }
        });

        btnBigPicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NotificationActivity.this, NotificationActivity.class);

                PendingIntent pIntent = PendingIntent.getActivity(NotificationActivity.this,
                        reqCode, intent, PendingIntent.FLAG_CANCEL_CURRENT);

                //build Notification


                Bitmap bitmap_image = BitmapFactory.decodeResource(NotificationActivity.this.getResources(),R.drawable.kola);
                Notification.BigPictureStyle bigPicture = new Notification.BigPictureStyle();
                bigPicture.bigPicture(bitmap_image);
                bigPicture.setBigContentTitle("Big Picture - Big Content Title");
                bigPicture.setSummaryText("Kolas are cute animal");

                Notification.Builder builder = new Notification.Builder(
                        NotificationActivity.this
                );
                builder.setContentTitle("Amazing Offer");
                builder.setContentText("Brought to you by BuySell.com");
                builder.setContentIntent(pIntent);
                builder.setSmallIcon(R.mipmap.ic_launcher);
                builder.setAutoCancel(true);
                builder.setStyle(bigPicture);


                Uri uri = RingtoneManager.getDefaultUri
                        (RingtoneManager.TYPE_NOTIFICATION);
                builder.setSound(uri);
                builder.setPriority(Notification.PRIORITY_HIGH);

                Notification n = builder.build();
                NotificationManager notificationManager = (NotificationManager)
                        getSystemService(NOTIFICATION_SERVICE);

                notificationManager.notify(notificationID, n);
                finish();



            }
        });

    }
}
