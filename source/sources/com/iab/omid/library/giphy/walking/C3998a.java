package com.iab.omid.library.giphy.walking;

import android.view.View;
import android.view.ViewParent;
import com.iab.omid.library.giphy.adsession.C3967a;
import com.iab.omid.library.giphy.p030b.C3969a;
import com.iab.omid.library.giphy.p032d.C3988f;
import com.iab.omid.library.giphy.p033e.C3989a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

/* renamed from: com.iab.omid.library.giphy.walking.a */
public class C3998a {

    /* renamed from: a */
    private final HashMap<View, String> f889a = new HashMap<>();

    /* renamed from: b */
    private final HashMap<View, ArrayList<String>> f890b = new HashMap<>();

    /* renamed from: c */
    private final HashSet<View> f891c = new HashSet<>();

    /* renamed from: d */
    private final HashSet<String> f892d = new HashSet<>();

    /* renamed from: e */
    private final HashSet<String> f893e = new HashSet<>();

    /* renamed from: f */
    private boolean f894f;

    /* renamed from: a */
    private void m767a(View view, C3967a aVar) {
        ArrayList arrayList = this.f890b.get(view);
        if (arrayList == null) {
            arrayList = new ArrayList();
            this.f890b.put(view, arrayList);
        }
        arrayList.add(aVar.getAdSessionId());
    }

    /* renamed from: a */
    private void m768a(C3967a aVar) {
        for (C3989a aVar2 : aVar.mo55920a()) {
            View view = (View) aVar2.get();
            if (view != null) {
                m767a(view, aVar);
            }
        }
    }

    /* renamed from: d */
    private boolean m769d(View view) {
        if (!view.hasWindowFocus()) {
            return false;
        }
        HashSet hashSet = new HashSet();
        while (view != null) {
            if (!C3988f.m723d(view)) {
                return false;
            }
            hashSet.add(view);
            ViewParent parent = view.getParent();
            view = parent instanceof View ? (View) parent : null;
        }
        this.f891c.addAll(hashSet);
        return true;
    }

    /* renamed from: a */
    public String mo56018a(View view) {
        if (this.f889a.size() == 0) {
            return null;
        }
        String str = this.f889a.get(view);
        if (str != null) {
            this.f889a.remove(view);
        }
        return str;
    }

    /* renamed from: a */
    public HashSet<String> mo56019a() {
        return this.f892d;
    }

    /* renamed from: b */
    public ArrayList<String> mo56020b(View view) {
        if (this.f890b.size() == 0) {
            return null;
        }
        ArrayList<String> arrayList = this.f890b.get(view);
        if (arrayList != null) {
            this.f890b.remove(view);
            Collections.sort(arrayList);
        }
        return arrayList;
    }

    /* renamed from: b */
    public HashSet<String> mo56021b() {
        return this.f893e;
    }

    /* renamed from: c */
    public C4008c mo56022c(View view) {
        return this.f891c.contains(view) ? C4008c.PARENT_VIEW : this.f894f ? C4008c.OBSTRUCTION_VIEW : C4008c.UNDERLYING_VIEW;
    }

    /* renamed from: c */
    public void mo56023c() {
        C3969a a = C3969a.m629a();
        if (a != null) {
            for (C3967a next : a.mo55949c()) {
                View c = next.mo55922c();
                if (next.mo55923d()) {
                    if (c == null || !m769d(c)) {
                        this.f893e.add(next.getAdSessionId());
                    } else {
                        this.f892d.add(next.getAdSessionId());
                        this.f889a.put(c, next.getAdSessionId());
                        m768a(next);
                    }
                }
            }
        }
    }

    /* renamed from: d */
    public void mo56024d() {
        this.f889a.clear();
        this.f890b.clear();
        this.f891c.clear();
        this.f892d.clear();
        this.f893e.clear();
        this.f894f = false;
    }

    /* renamed from: e */
    public void mo56025e() {
        this.f894f = true;
    }
}
