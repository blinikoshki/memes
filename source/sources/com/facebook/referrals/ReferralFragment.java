package com.facebook.referrals;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;

public class ReferralFragment extends Fragment {
    public static final String TAG = "ReferralFragment";
    private ReferralClient referralClient;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.referralClient = new ReferralClient(this);
    }

    public void onResume() {
        super.onResume();
        this.referralClient.startReferral();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        this.referralClient.onActivityResult(i, i2, intent);
    }
}
