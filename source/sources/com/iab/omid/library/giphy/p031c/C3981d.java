package com.iab.omid.library.giphy.p031c;

import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import com.iab.omid.library.giphy.p031c.C3977a;
import com.iab.omid.library.giphy.p032d.C3983b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;

/* renamed from: com.iab.omid.library.giphy.c.d */
public class C3981d implements C3977a {

    /* renamed from: a */
    private final int[] f857a = new int[2];

    /* renamed from: a */
    private void m681a(ViewGroup viewGroup, JSONObject jSONObject, C3977a.C3978a aVar) {
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            aVar.mo55982a(viewGroup.getChildAt(i), this, jSONObject);
        }
    }

    /* renamed from: b */
    private void m682b(ViewGroup viewGroup, JSONObject jSONObject, C3977a.C3978a aVar) {
        HashMap hashMap = new HashMap();
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View childAt = viewGroup.getChildAt(i);
            ArrayList arrayList = (ArrayList) hashMap.get(Float.valueOf(childAt.getZ()));
            if (arrayList == null) {
                arrayList = new ArrayList();
                hashMap.put(Float.valueOf(childAt.getZ()), arrayList);
            }
            arrayList.add(childAt);
        }
        ArrayList arrayList2 = new ArrayList(hashMap.keySet());
        Collections.sort(arrayList2);
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            Iterator it2 = ((ArrayList) hashMap.get((Float) it.next())).iterator();
            while (it2.hasNext()) {
                aVar.mo55982a((View) it2.next(), this, jSONObject);
            }
        }
    }

    /* renamed from: a */
    public JSONObject mo55980a(View view) {
        int width = view.getWidth();
        int height = view.getHeight();
        view.getLocationOnScreen(this.f857a);
        int[] iArr = this.f857a;
        return C3983b.m690a(iArr[0], iArr[1], width, height);
    }

    /* renamed from: a */
    public void mo55981a(View view, JSONObject jSONObject, C3977a.C3978a aVar, boolean z) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (!z || Build.VERSION.SDK_INT < 21) {
                m681a(viewGroup, jSONObject, aVar);
            } else {
                m682b(viewGroup, jSONObject, aVar);
            }
        }
    }
}
