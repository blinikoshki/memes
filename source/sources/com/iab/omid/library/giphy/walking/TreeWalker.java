package com.iab.omid.library.giphy.walking;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.iab.omid.library.giphy.p031c.C3977a;
import com.iab.omid.library.giphy.p031c.C3979b;
import com.iab.omid.library.giphy.p032d.C3983b;
import com.iab.omid.library.giphy.p032d.C3986d;
import com.iab.omid.library.giphy.p032d.C3988f;
import com.iab.omid.library.giphy.walking.p034a.C4003c;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

public class TreeWalker implements C3977a.C3978a {

    /* renamed from: a */
    private static TreeWalker f877a = new TreeWalker();

    /* renamed from: b */
    private static Handler f878b = new Handler(Looper.getMainLooper());
    /* access modifiers changed from: private */

    /* renamed from: c */
    public static Handler f879c = null;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public static final Runnable f880j = new Runnable() {
        public void run() {
            TreeWalker.getInstance().m757h();
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: k */
    public static final Runnable f881k = new Runnable() {
        public void run() {
            if (TreeWalker.f879c != null) {
                TreeWalker.f879c.post(TreeWalker.f880j);
                TreeWalker.f879c.postDelayed(TreeWalker.f881k, 200);
            }
        }
    };

    /* renamed from: d */
    private List<TreeWalkerTimeLogger> f882d = new ArrayList();

    /* renamed from: e */
    private int f883e;

    /* renamed from: f */
    private C3979b f884f = new C3979b();

    /* renamed from: g */
    private C3998a f885g = new C3998a();
    /* access modifiers changed from: private */

    /* renamed from: h */
    public C4007b f886h = new C4007b(new C4003c());

    /* renamed from: i */
    private double f887i;

    public interface TreeWalkerTimeLogger {
        void onTreeProcessed(int i, long j);
    }

    TreeWalker() {
    }

    /* renamed from: a */
    private void m749a(long j) {
        if (this.f882d.size() > 0) {
            for (TreeWalkerTimeLogger onTreeProcessed : this.f882d) {
                onTreeProcessed.onTreeProcessed(this.f883e, j);
            }
        }
    }

    /* renamed from: a */
    private void m750a(View view, C3977a aVar, JSONObject jSONObject, C4008c cVar) {
        aVar.mo55981a(view, jSONObject, this, cVar == C4008c.PARENT_VIEW);
    }

    /* renamed from: a */
    private boolean m751a(View view, JSONObject jSONObject) {
        String a = this.f885g.mo56018a(view);
        if (a == null) {
            return false;
        }
        C3983b.m693a(jSONObject, a);
        this.f885g.mo56025e();
        return true;
    }

    /* renamed from: b */
    private void m752b(View view, JSONObject jSONObject) {
        ArrayList<String> b = this.f885g.mo56020b(view);
        if (b != null) {
            C3983b.m695a(jSONObject, (List<String>) b);
        }
    }

    public static TreeWalker getInstance() {
        return f877a;
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public void m757h() {
        m758i();
        mo56012d();
        m759j();
    }

    /* renamed from: i */
    private void m758i() {
        this.f883e = 0;
        this.f887i = C3986d.m706a();
    }

    /* renamed from: j */
    private void m759j() {
        m749a((long) (C3986d.m706a() - this.f887i));
    }

    /* renamed from: k */
    private void m760k() {
        if (f879c == null) {
            Handler handler = new Handler(Looper.getMainLooper());
            f879c = handler;
            handler.post(f880j);
            f879c.postDelayed(f881k, 200);
        }
    }

    /* renamed from: l */
    private void m761l() {
        Handler handler = f879c;
        if (handler != null) {
            handler.removeCallbacks(f881k);
            f879c = null;
        }
    }

    /* renamed from: a */
    public void mo56008a() {
        m760k();
    }

    /* renamed from: a */
    public void mo55982a(View view, C3977a aVar, JSONObject jSONObject) {
        C4008c c;
        if (C3988f.m723d(view) && (c = this.f885g.mo56022c(view)) != C4008c.UNDERLYING_VIEW) {
            JSONObject a = aVar.mo55980a(view);
            C3983b.m696a(jSONObject, a);
            if (!m751a(view, a)) {
                m752b(view, a);
                m750a(view, aVar, a, c);
            }
            this.f883e++;
        }
    }

    public void addTimeLogger(TreeWalkerTimeLogger treeWalkerTimeLogger) {
        if (!this.f882d.contains(treeWalkerTimeLogger)) {
            this.f882d.add(treeWalkerTimeLogger);
        }
    }

    /* renamed from: b */
    public void mo56010b() {
        mo56011c();
        this.f882d.clear();
        f878b.post(new Runnable() {
            public void run() {
                TreeWalker.this.f886h.mo56040a();
            }
        });
    }

    /* renamed from: c */
    public void mo56011c() {
        m761l();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public void mo56012d() {
        this.f885g.mo56023c();
        double a = C3986d.m706a();
        C3977a a2 = this.f884f.mo55983a();
        if (this.f885g.mo56021b().size() > 0) {
            this.f886h.mo56042b(a2.mo55980a((View) null), this.f885g.mo56021b(), a);
        }
        if (this.f885g.mo56019a().size() > 0) {
            JSONObject a3 = a2.mo55980a((View) null);
            m750a((View) null, a2, a3, C4008c.PARENT_VIEW);
            C3983b.m692a(a3);
            this.f886h.mo56041a(a3, this.f885g.mo56019a(), a);
        } else {
            this.f886h.mo56040a();
        }
        this.f885g.mo56024d();
    }

    public void removeTimeLogger(TreeWalkerTimeLogger treeWalkerTimeLogger) {
        if (this.f882d.contains(treeWalkerTimeLogger)) {
            this.f882d.remove(treeWalkerTimeLogger);
        }
    }
}
