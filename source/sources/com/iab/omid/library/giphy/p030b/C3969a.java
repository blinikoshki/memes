package com.iab.omid.library.giphy.p030b;

import com.iab.omid.library.giphy.adsession.C3967a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/* renamed from: com.iab.omid.library.giphy.b.a */
public class C3969a {

    /* renamed from: a */
    private static C3969a f833a = new C3969a();

    /* renamed from: b */
    private final ArrayList<C3967a> f834b = new ArrayList<>();

    /* renamed from: c */
    private final ArrayList<C3967a> f835c = new ArrayList<>();

    private C3969a() {
    }

    /* renamed from: a */
    public static C3969a m629a() {
        return f833a;
    }

    /* renamed from: a */
    public void mo55946a(C3967a aVar) {
        this.f834b.add(aVar);
    }

    /* renamed from: b */
    public Collection<C3967a> mo55947b() {
        return Collections.unmodifiableCollection(this.f834b);
    }

    /* renamed from: b */
    public void mo55948b(C3967a aVar) {
        boolean d = mo55951d();
        this.f835c.add(aVar);
        if (!d) {
            C3976e.m666a().mo55977b();
        }
    }

    /* renamed from: c */
    public Collection<C3967a> mo55949c() {
        return Collections.unmodifiableCollection(this.f835c);
    }

    /* renamed from: c */
    public void mo55950c(C3967a aVar) {
        boolean d = mo55951d();
        this.f834b.remove(aVar);
        this.f835c.remove(aVar);
        if (d && !mo55951d()) {
            C3976e.m666a().mo55978c();
        }
    }

    /* renamed from: d */
    public boolean mo55951d() {
        return this.f835c.size() > 0;
    }
}
