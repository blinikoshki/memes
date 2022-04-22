package com.iab.omid.library.giphy.p032d;

import android.text.TextUtils;
import com.iab.omid.library.giphy.Omid;
import com.iab.omid.library.giphy.adsession.C3967a;
import com.iab.omid.library.giphy.adsession.Owner;

/* renamed from: com.iab.omid.library.giphy.d.e */
public class C3987e {
    /* renamed from: a */
    public static void m707a() {
        if (!Omid.isActive()) {
            throw new IllegalStateException("Method called before OM SDK activation");
        }
    }

    /* renamed from: a */
    public static void m708a(Owner owner) {
        if (owner.equals(Owner.NONE)) {
            throw new IllegalArgumentException("Impression owner is none");
        }
    }

    /* renamed from: a */
    public static void m709a(C3967a aVar) {
        if (aVar.mo55924e()) {
            throw new IllegalStateException("AdSession is started");
        }
    }

    /* renamed from: a */
    public static void m710a(Object obj, String str) {
        if (obj == null) {
            throw new IllegalArgumentException(str);
        }
    }

    /* renamed from: a */
    public static void m711a(String str, int i, String str2) {
        if (str.length() > i) {
            throw new IllegalArgumentException(str2);
        }
    }

    /* renamed from: a */
    public static void m712a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException(str2);
        }
    }

    /* renamed from: b */
    public static void m713b(C3967a aVar) {
        if (aVar.mo55925f()) {
            throw new IllegalStateException("AdSession is finished");
        }
    }

    /* renamed from: c */
    public static void m714c(C3967a aVar) {
        m719h(aVar);
        m713b(aVar);
    }

    /* renamed from: d */
    public static void m715d(C3967a aVar) {
        if (aVar.getAdSessionStatePublisher().mo55999c() != null) {
            throw new IllegalStateException("AdEvents already exists for AdSession");
        }
    }

    /* renamed from: e */
    public static void m716e(C3967a aVar) {
        if (aVar.getAdSessionStatePublisher().mo56000d() != null) {
            throw new IllegalStateException("VideoEvents already exists for AdSession");
        }
    }

    /* renamed from: f */
    public static void m717f(C3967a aVar) {
        if (!aVar.mo55926g()) {
            throw new IllegalStateException("Impression event is not expected from the Native AdSession");
        }
    }

    /* renamed from: g */
    public static void m718g(C3967a aVar) {
        if (!aVar.mo55927h()) {
            throw new IllegalStateException("Cannot create VideoEvents for JavaScript AdSession");
        }
    }

    /* renamed from: h */
    private static void m719h(C3967a aVar) {
        if (!aVar.mo55924e()) {
            throw new IllegalStateException("AdSession is not started");
        }
    }
}
