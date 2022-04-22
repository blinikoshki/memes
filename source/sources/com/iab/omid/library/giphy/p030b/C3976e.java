package com.iab.omid.library.giphy.p030b;

import android.content.Context;
import android.os.Handler;
import com.iab.omid.library.giphy.adsession.C3967a;
import com.iab.omid.library.giphy.p029a.C3963b;
import com.iab.omid.library.giphy.p029a.C3964c;
import com.iab.omid.library.giphy.p029a.C3965d;
import com.iab.omid.library.giphy.p029a.C3966e;
import com.iab.omid.library.giphy.p030b.C3970b;
import com.iab.omid.library.giphy.walking.TreeWalker;

/* renamed from: com.iab.omid.library.giphy.b.e */
public class C3976e implements C3964c, C3970b.C3972a {

    /* renamed from: a */
    private static C3976e f849a;

    /* renamed from: b */
    private float f850b = 0.0f;

    /* renamed from: c */
    private final C3966e f851c;

    /* renamed from: d */
    private final C3963b f852d;

    /* renamed from: e */
    private C3965d f853e;

    /* renamed from: f */
    private C3969a f854f;

    public C3976e(C3966e eVar, C3963b bVar) {
        this.f851c = eVar;
        this.f852d = bVar;
    }

    /* renamed from: a */
    public static C3976e m666a() {
        if (f849a == null) {
            f849a = new C3976e(new C3966e(), new C3963b());
        }
        return f849a;
    }

    /* renamed from: e */
    private C3969a m667e() {
        if (this.f854f == null) {
            this.f854f = C3969a.m629a();
        }
        return this.f854f;
    }

    /* renamed from: a */
    public void mo55888a(float f) {
        this.f850b = f;
        for (C3967a adSessionStatePublisher : m667e().mo55949c()) {
            adSessionStatePublisher.getAdSessionStatePublisher().mo55986a(f);
        }
    }

    /* renamed from: a */
    public void mo55976a(Context context) {
        this.f853e = this.f851c.mo55892a(new Handler(), context, this.f852d.mo55887a(), this);
    }

    /* renamed from: a */
    public void mo55958a(boolean z) {
        if (z) {
            TreeWalker.getInstance().mo56008a();
        } else {
            TreeWalker.getInstance().mo56011c();
        }
    }

    /* renamed from: b */
    public void mo55977b() {
        C3970b.m636a().mo55953a((C3970b.C3972a) this);
        C3970b.m636a().mo55954b();
        if (C3970b.m636a().mo55956d()) {
            TreeWalker.getInstance().mo56008a();
        }
        this.f853e.mo55889a();
    }

    /* renamed from: c */
    public void mo55978c() {
        TreeWalker.getInstance().mo56010b();
        C3970b.m636a().mo55955c();
        this.f853e.mo55890b();
    }

    /* renamed from: d */
    public float mo55979d() {
        return this.f850b;
    }
}
