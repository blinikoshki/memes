package com.iab.omid.library.giphy.p030b;

import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.iab.omid.library.giphy.adsession.C3967a;

/* renamed from: com.iab.omid.library.giphy.b.b */
public class C3970b {

    /* renamed from: a */
    private static C3970b f836a = new C3970b();

    /* renamed from: b */
    private Context f837b;

    /* renamed from: c */
    private BroadcastReceiver f838c;

    /* renamed from: d */
    private boolean f839d;

    /* renamed from: e */
    private boolean f840e;

    /* renamed from: f */
    private C3972a f841f;

    /* renamed from: com.iab.omid.library.giphy.b.b$a */
    public interface C3972a {
        /* renamed from: a */
        void mo55958a(boolean z);
    }

    private C3970b() {
    }

    /* renamed from: a */
    public static C3970b m636a() {
        return f836a;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m638a(boolean z) {
        if (this.f840e != z) {
            this.f840e = z;
            if (this.f839d) {
                m641g();
                C3972a aVar = this.f841f;
                if (aVar != null) {
                    aVar.mo55958a(mo55956d());
                }
            }
        }
    }

    /* renamed from: e */
    private void m639e() {
        this.f838c = new BroadcastReceiver() {
            public void onReceive(Context context, Intent intent) {
                KeyguardManager keyguardManager;
                if (intent != null) {
                    if ("android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
                        C3970b.this.m638a(true);
                    } else if ("android.intent.action.USER_PRESENT".equals(intent.getAction()) || ("android.intent.action.SCREEN_ON".equals(intent.getAction()) && (keyguardManager = (KeyguardManager) context.getSystemService("keyguard")) != null && !keyguardManager.inKeyguardRestrictedInputMode())) {
                        C3970b.this.m638a(false);
                    }
                }
            }
        };
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        intentFilter.addAction("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.USER_PRESENT");
        this.f837b.registerReceiver(this.f838c, intentFilter);
    }

    /* renamed from: f */
    private void m640f() {
        BroadcastReceiver broadcastReceiver;
        Context context = this.f837b;
        if (context != null && (broadcastReceiver = this.f838c) != null) {
            context.unregisterReceiver(broadcastReceiver);
            this.f838c = null;
        }
    }

    /* renamed from: g */
    private void m641g() {
        boolean z = !this.f840e;
        for (C3967a adSessionStatePublisher : C3969a.m629a().mo55947b()) {
            adSessionStatePublisher.getAdSessionStatePublisher().mo55996a(z);
        }
    }

    /* renamed from: a */
    public void mo55952a(Context context) {
        this.f837b = context.getApplicationContext();
    }

    /* renamed from: a */
    public void mo55953a(C3972a aVar) {
        this.f841f = aVar;
    }

    /* renamed from: b */
    public void mo55954b() {
        m639e();
        this.f839d = true;
        m641g();
    }

    /* renamed from: c */
    public void mo55955c() {
        m640f();
        this.f839d = false;
        this.f840e = false;
        this.f841f = null;
    }

    /* renamed from: d */
    public boolean mo55956d() {
        return !this.f840e;
    }
}
