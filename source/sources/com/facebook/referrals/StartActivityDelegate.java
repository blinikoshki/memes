package com.facebook.referrals;

import android.app.Activity;
import android.content.Intent;

interface StartActivityDelegate {
    Activity getActivityContext();

    void startActivityForResult(Intent intent, int i);
}
