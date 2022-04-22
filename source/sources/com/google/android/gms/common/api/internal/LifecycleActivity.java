package com.google.android.gms.common.api.internal;

import android.app.Activity;
import android.content.ContextWrapper;
import androidx.fragment.app.FragmentActivity;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-basement@@17.2.1 */
public class LifecycleActivity {
    private final Object zzbk;

    public LifecycleActivity(Activity activity) {
        this.zzbk = Preconditions.checkNotNull(activity, "Activity must not be null");
    }

    public boolean isChimera() {
        return false;
    }

    public LifecycleActivity(ContextWrapper contextWrapper) {
        throw new UnsupportedOperationException();
    }

    public boolean isSupport() {
        return this.zzbk instanceof FragmentActivity;
    }

    public final boolean zzh() {
        return this.zzbk instanceof Activity;
    }

    public Activity asActivity() {
        return (Activity) this.zzbk;
    }

    public FragmentActivity asFragmentActivity() {
        return (FragmentActivity) this.zzbk;
    }

    public Object asObject() {
        return this.zzbk;
    }
}
