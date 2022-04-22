package com.iab.omid.library.giphy.publisher;

import android.os.Handler;
import android.webkit.WebView;
import com.iab.omid.library.giphy.adsession.VerificationScriptResource;
import com.iab.omid.library.giphy.p030b.C3973c;
import com.iab.omid.library.giphy.p030b.C3974d;
import java.util.List;

/* renamed from: com.iab.omid.library.giphy.publisher.b */
public class C3993b extends AdSessionStatePublisher {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public WebView f872a;

    /* renamed from: b */
    private List<VerificationScriptResource> f873b;

    /* renamed from: c */
    private final String f874c;

    public C3993b(List<VerificationScriptResource> list, String str) {
        this.f873b = list;
        this.f874c = str;
    }

    /* renamed from: a */
    public void mo55985a() {
        super.mo55985a();
        mo56006i();
    }

    /* renamed from: b */
    public void mo55997b() {
        super.mo55997b();
        new Handler().postDelayed(new Runnable() {

            /* renamed from: b */
            private WebView f876b;

            {
                this.f876b = C3993b.this.f872a;
            }

            public void run() {
                this.f876b.destroy();
            }
        }, 2000);
        this.f872a = null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public void mo56006i() {
        WebView webView = new WebView(C3973c.m648a().mo55960b());
        this.f872a = webView;
        webView.getSettings().setJavaScriptEnabled(true);
        mo55987a(this.f872a);
        C3974d.m651a().mo55970a(this.f872a, this.f874c);
        for (VerificationScriptResource resourceUrl : this.f873b) {
            C3974d.m651a().mo55972b(this.f872a, resourceUrl.getResourceUrl().toExternalForm());
        }
    }
}
