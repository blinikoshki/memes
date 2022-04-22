package com.google.android.gms.common.internal;

import android.content.Intent;
import com.google.android.gms.common.api.internal.LifecycleFragment;

/* compiled from: com.google.android.gms:play-services-base@@17.1.0 */
final class zae extends DialogRedirect {
    private final /* synthetic */ int val$requestCode;
    private final /* synthetic */ Intent zaos;
    private final /* synthetic */ LifecycleFragment zaot;

    zae(Intent intent, LifecycleFragment lifecycleFragment, int i) {
        this.zaos = intent;
        this.zaot = lifecycleFragment;
        this.val$requestCode = i;
    }

    public final void redirect() {
        Intent intent = this.zaos;
        if (intent != null) {
            this.zaot.startActivityForResult(intent, this.val$requestCode);
        }
    }
}
