package com.iab.omid.library.giphy.p029a;

import android.content.Context;
import android.database.ContentObserver;
import android.media.AudioManager;
import android.os.Handler;
import android.provider.Settings;
import com.google.android.exoplayer2.util.MimeTypes;

/* renamed from: com.iab.omid.library.giphy.a.d */
public final class C3965d extends ContentObserver {

    /* renamed from: a */
    private final Context f812a;

    /* renamed from: b */
    private final AudioManager f813b;

    /* renamed from: c */
    private final C3962a f814c;

    /* renamed from: d */
    private final C3964c f815d;

    /* renamed from: e */
    private float f816e;

    public C3965d(Handler handler, Context context, C3962a aVar, C3964c cVar) {
        super(handler);
        this.f812a = context;
        this.f813b = (AudioManager) context.getSystemService(MimeTypes.BASE_TYPE_AUDIO);
        this.f814c = aVar;
        this.f815d = cVar;
    }

    /* renamed from: a */
    private boolean m604a(float f) {
        return f != this.f816e;
    }

    /* renamed from: c */
    private float m605c() {
        return this.f814c.mo55886a(this.f813b.getStreamVolume(3), this.f813b.getStreamMaxVolume(3));
    }

    /* renamed from: d */
    private void m606d() {
        this.f815d.mo55888a(this.f816e);
    }

    /* renamed from: a */
    public void mo55889a() {
        this.f816e = m605c();
        m606d();
        this.f812a.getContentResolver().registerContentObserver(Settings.System.CONTENT_URI, true, this);
    }

    /* renamed from: b */
    public void mo55890b() {
        this.f812a.getContentResolver().unregisterContentObserver(this);
    }

    public void onChange(boolean z) {
        super.onChange(z);
        float c = m605c();
        if (m604a(c)) {
            this.f816e = c;
            m606d();
        }
    }
}
