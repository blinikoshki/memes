package com.iab.omid.library.giphy.walking;

import com.iab.omid.library.giphy.walking.p034a.C4000b;
import com.iab.omid.library.giphy.walking.p034a.C4003c;
import com.iab.omid.library.giphy.walking.p034a.C4004d;
import com.iab.omid.library.giphy.walking.p034a.C4005e;
import com.iab.omid.library.giphy.walking.p034a.C4006f;
import java.util.HashSet;
import org.json.JSONObject;

/* renamed from: com.iab.omid.library.giphy.walking.b */
public class C4007b implements C4000b.C4002b {

    /* renamed from: a */
    private JSONObject f904a;

    /* renamed from: b */
    private final C4003c f905b;

    public C4007b(C4003c cVar) {
        this.f905b = cVar;
    }

    /* renamed from: a */
    public void mo56040a() {
        this.f905b.mo56033b(new C4004d(this));
    }

    /* renamed from: a */
    public void mo56031a(JSONObject jSONObject) {
        this.f904a = jSONObject;
    }

    /* renamed from: a */
    public void mo56041a(JSONObject jSONObject, HashSet<String> hashSet, double d) {
        this.f905b.mo56033b(new C4006f(this, hashSet, jSONObject, d));
    }

    /* renamed from: b */
    public JSONObject mo56032b() {
        return this.f904a;
    }

    /* renamed from: b */
    public void mo56042b(JSONObject jSONObject, HashSet<String> hashSet, double d) {
        this.f905b.mo56033b(new C4005e(this, hashSet, jSONObject, d));
    }
}
