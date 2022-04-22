package com.snapchat.kit.sdk.core.metrics.skate;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.memes.eventtracker.util.Util;
import com.snapchat.kit.sdk.core.models.Skate;
import com.snapchat.kit.sdk.core.models.SkateDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import javax.inject.Inject;

/* renamed from: com.snapchat.kit.sdk.core.metrics.skate.d */
public final class C4446d {

    /* renamed from: a */
    private final SharedPreferences f1238a;

    /* renamed from: b */
    private final Random f1239b;

    @Inject
    C4446d(SharedPreferences sharedPreferences, Random random) {
        this.f1238a = sharedPreferences;
        this.f1239b = random;
        m902e();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final Skate mo61662a() {
        try {
            long j = this.f1238a.getLong("com.snapchat.kit.sdk.core.metrics.skate.SkateStore.skateDay", -1);
            long j2 = this.f1238a.getLong("com.snapchat.kit.sdk.core.metrics.skate.SkateStore.skateMonth", -1);
            long j3 = this.f1238a.getLong("com.snapchat.kit.sdk.core.metrics.skate.SkateStore.skateYear", -1);
            int i = this.f1238a.getInt("com.snapchat.kit.sdk.core.metrics.skate.SkateStore.skateCount", -1);
            if (j < 1 || j > 31 || j2 < 1 || j2 > 12 || j3 < 2020 || i <= 0) {
                return null;
            }
            return new Skate(new SkateDate(j, j2, j3), i);
        } catch (ClassCastException unused) {
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo61663a(Skate skate) {
        this.f1238a.edit().putLong("com.snapchat.kit.sdk.core.metrics.skate.SkateStore.skateDay", skate.mDate.mDay).putLong("com.snapchat.kit.sdk.core.metrics.skate.SkateStore.skateMonth", skate.mDate.mMonth).putLong("com.snapchat.kit.sdk.core.metrics.skate.SkateStore.skateYear", skate.mDate.mYear).putInt("com.snapchat.kit.sdk.core.metrics.skate.SkateStore.skateCount", skate.getCount()).apply();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final String mo61664b() {
        return this.f1238a.getString("com.snapchat.kit.sdk.core.metrics.skate.SkateStore.kitVariants", (String) null);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public final double mo61665c() {
        float d;
        if (!this.f1238a.contains("com.snapchat.kit.sdk.core.metrics.skate.deviceSampleValue")) {
            d = m901d();
        } else {
            try {
                return (double) this.f1238a.getFloat("com.snapchat.kit.sdk.core.metrics.skate.deviceSampleValue", 0.99999f);
            } catch (ClassCastException unused) {
                d = m901d();
            }
        }
        return (double) d;
    }

    /* renamed from: d */
    private float m901d() {
        float nextFloat = this.f1239b.nextFloat();
        this.f1238a.edit().putFloat("com.snapchat.kit.sdk.core.metrics.skate.deviceSampleValue", nextFloat).apply();
        return nextFloat;
    }

    /* renamed from: e */
    private void m902e() {
        HashMap hashMap = new HashMap();
        hashMap.put("com.snapchat.kit.sdk.SnapLogin", "LOGIN");
        hashMap.put("com.snapchat.kit.sdk.Bitmoji", "BITMOJI");
        hashMap.put("com.snapchat.kit.sdk.SnapCreative", "CREATIVE");
        hashMap.put("com.snapchat.kit.sdk.SnapStory", "STORY");
        ArrayList arrayList = new ArrayList();
        for (String str : hashMap.keySet()) {
            try {
                Class.forName(str);
                arrayList.add(hashMap.get(str));
            } catch (ClassNotFoundException unused) {
            }
        }
        this.f1238a.edit().putString("com.snapchat.kit.sdk.core.metrics.skate.SkateStore.kitVariants", TextUtils.join(Util.EVENT_ID_SEPARATOR, arrayList)).apply();
    }
}
