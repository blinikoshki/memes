package com.appsflyer;

import com.appsflyer.internal.event.uninstall.Register;
import com.google.firebase.messaging.FirebaseMessagingService;

public class FirebaseMessagingServiceListener extends FirebaseMessagingService {
    public void onNewToken(String str) {
        new Register(getApplicationContext()).send(str);
    }
}
