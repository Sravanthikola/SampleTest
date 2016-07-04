package com.example.smargav.myapplication;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ButtonBarLayout;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    EditText name,subject,address;
    Button enter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=(TextView)findViewById(R.id.textView);
        name=(EditText)findViewById(R.id.editText);
        subject=(EditText)findViewById(R.id.editText2);
        address=(EditText)findViewById(R.id.editText3);
        enter =(Button)findViewById(R.id.button);
        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nameString= name.getText().toString().trim();
                String subjectString = subject.getText().toString().trim();
                String addressString =address.getText().toString().trim();
                NotificationManager notificationManager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
                Notification notification = new Notification(R.drawable.notif,nameString,System.currentTimeMillis());
                PendingIntent pendingIntent =PendingIntent.getActivity(getApplicationContext(),0,new Intent(),0);
                notification.setLatestEventInfo(getApplicationContext(),subject,address,pendingIntent);
                notificationManager.notify(0,notification);

            }
        });

    }
}
