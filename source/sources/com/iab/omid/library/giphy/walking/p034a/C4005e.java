package com.iab.omid.library.giphy.walking.p034a;

import com.iab.omid.library.giphy.adsession.C3967a;
import com.iab.omid.library.giphy.p030b.C3969a;
import com.iab.omid.library.giphy.walking.p034a.C4000b;
import java.util.HashSet;
import org.json.JSONObject;

/* renamed from: com.iab.omid.library.giphy.walking.a.e */
public class C4005e extends C3999a {
    public C4005e(C4000b.C4002b bVar, HashSet<String> hashSet, JSONObject jSONObject, double d) {
        super(bVar, hashSet, jSONObject, d);
    }

    /* renamed from: b */
    private void m788b(String str) {
        C3969a a = C3969a.m629a();
        if (a != null) {
            for (C3967a next : a.mo55947b()) {
                if (this.f895a.contains(next.getAdSessionId())) {
                    next.getAdSessionStatePublisher().mo55998b(str, this.f897c);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public String doInBackground(Object... objArr) {
        return this.f896b.toString();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void onPostExecute(String str) {
        m788b(str);
        super.onPostExecute(str);
    }
}
