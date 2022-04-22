package com.iab.omid.library.giphy.walking.p034a;

import android.os.AsyncTask;
import java.util.concurrent.ThreadPoolExecutor;
import org.json.JSONObject;

/* renamed from: com.iab.omid.library.giphy.walking.a.b */
public abstract class C4000b extends AsyncTask<Object, Void, String> {

    /* renamed from: a */
    private C4001a f898a;

    /* renamed from: d */
    protected final C4002b f899d;

    /* renamed from: com.iab.omid.library.giphy.walking.a.b$a */
    public interface C4001a {
        /* renamed from: a */
        void mo56030a(C4000b bVar);
    }

    /* renamed from: com.iab.omid.library.giphy.walking.a.b$b */
    public interface C4002b {
        /* renamed from: a */
        void mo56031a(JSONObject jSONObject);

        /* renamed from: b */
        JSONObject mo56032b();
    }

    public C4000b(C4002b bVar) {
        this.f899d = bVar;
    }

    /* renamed from: a */
    public void mo56026a(C4001a aVar) {
        this.f898a = aVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void onPostExecute(String str) {
        C4001a aVar = this.f898a;
        if (aVar != null) {
            aVar.mo56030a(this);
        }
    }

    /* renamed from: a */
    public void mo56028a(ThreadPoolExecutor threadPoolExecutor) {
        executeOnExecutor(threadPoolExecutor, new Object[0]);
    }
}
