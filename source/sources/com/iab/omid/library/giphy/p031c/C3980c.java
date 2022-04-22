package com.iab.omid.library.giphy.p031c;

import android.view.View;
import com.iab.omid.library.giphy.adsession.C3967a;
import com.iab.omid.library.giphy.p030b.C3969a;
import com.iab.omid.library.giphy.p031c.C3977a;
import com.iab.omid.library.giphy.p032d.C3983b;
import com.iab.omid.library.giphy.p032d.C3988f;
import java.util.ArrayList;
import java.util.Collection;
import java.util.IdentityHashMap;
import java.util.Iterator;
import org.json.JSONObject;

/* renamed from: com.iab.omid.library.giphy.c.c */
public class C3980c implements C3977a {

    /* renamed from: a */
    private final C3977a f856a;

    public C3980c(C3977a aVar) {
        this.f856a = aVar;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public ArrayList<View> mo55984a() {
        View rootView;
        ArrayList<View> arrayList = new ArrayList<>();
        C3969a a = C3969a.m629a();
        if (a != null) {
            Collection<C3967a> c = a.mo55949c();
            IdentityHashMap identityHashMap = new IdentityHashMap((c.size() * 2) + 3);
            for (C3967a c2 : c) {
                View c3 = c2.mo55922c();
                if (c3 != null && C3988f.m722c(c3) && (rootView = c3.getRootView()) != null && !identityHashMap.containsKey(rootView)) {
                    identityHashMap.put(rootView, rootView);
                    float a2 = C3988f.m720a(rootView);
                    int size = arrayList.size();
                    while (size > 0 && C3988f.m720a(arrayList.get(size - 1)) > a2) {
                        size--;
                    }
                    arrayList.add(size, rootView);
                }
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public JSONObject mo55980a(View view) {
        return C3983b.m690a(0, 0, 0, 0);
    }

    /* renamed from: a */
    public void mo55981a(View view, JSONObject jSONObject, C3977a.C3978a aVar, boolean z) {
        Iterator<View> it = mo55984a().iterator();
        while (it.hasNext()) {
            aVar.mo55982a(it.next(), this.f856a, jSONObject);
        }
    }
}
