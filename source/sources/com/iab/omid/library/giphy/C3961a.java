package com.iab.omid.library.giphy;

import android.content.Context;
import com.iab.omid.library.giphy.p030b.C3970b;
import com.iab.omid.library.giphy.p030b.C3973c;
import com.iab.omid.library.giphy.p030b.C3976e;
import com.iab.omid.library.giphy.p032d.C3983b;
import com.iab.omid.library.giphy.p032d.C3987e;

/* renamed from: com.iab.omid.library.giphy.a */
public class C3961a {

    /* renamed from: a */
    private boolean f811a;

    /* renamed from: b */
    private void m595b(Context context) {
        C3987e.m710a((Object) context, "Application Context cannot be null");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public String mo55881a() {
        return "1.2.13-Giphy";
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo55882a(Context context) {
        m595b(context);
        if (!mo55885b()) {
            mo55883a(true);
            C3976e.m666a().mo55976a(context);
            C3970b.m636a().mo55952a(context);
            C3983b.m691a(context);
            C3973c.m648a().mo55959a(context);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo55883a(boolean z) {
        this.f811a = z;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo55884a(String str) {
        return true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public boolean mo55885b() {
        return this.f811a;
    }
}
