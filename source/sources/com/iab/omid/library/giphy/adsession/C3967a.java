package com.iab.omid.library.giphy.adsession;

import android.view.View;
import com.iab.omid.library.giphy.p030b.C3969a;
import com.iab.omid.library.giphy.p030b.C3976e;
import com.iab.omid.library.giphy.p032d.C3987e;
import com.iab.omid.library.giphy.p033e.C3989a;
import com.iab.omid.library.giphy.publisher.AdSessionStatePublisher;
import com.iab.omid.library.giphy.publisher.C3992a;
import com.iab.omid.library.giphy.publisher.C3993b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

/* renamed from: com.iab.omid.library.giphy.adsession.a */
public class C3967a extends AdSession {

    /* renamed from: a */
    private final AdSessionContext f817a;

    /* renamed from: b */
    private final AdSessionConfiguration f818b;

    /* renamed from: c */
    private final List<C3989a> f819c = new ArrayList();

    /* renamed from: d */
    private C3989a f820d;

    /* renamed from: e */
    private AdSessionStatePublisher f821e;

    /* renamed from: f */
    private boolean f822f = false;

    /* renamed from: g */
    private boolean f823g = false;

    /* renamed from: h */
    private String f824h;

    /* renamed from: i */
    private boolean f825i;

    C3967a(AdSessionConfiguration adSessionConfiguration, AdSessionContext adSessionContext) {
        this.f818b = adSessionConfiguration;
        this.f817a = adSessionContext;
        this.f824h = UUID.randomUUID().toString();
        m612c((View) null);
        this.f821e = adSessionContext.getAdSessionContextType() == AdSessionContextType.HTML ? new C3992a(adSessionContext.getWebView()) : new C3993b(adSessionContext.getVerificationScriptResources(), adSessionContext.getOmidJsScriptContent());
        this.f821e.mo55985a();
        C3969a.m629a().mo55946a(this);
        this.f821e.mo55989a(adSessionConfiguration);
    }

    /* renamed from: a */
    private C3989a m610a(View view) {
        for (C3989a next : this.f819c) {
            if (next.get() == view) {
                return next;
            }
        }
        return null;
    }

    /* renamed from: b */
    private void m611b(View view) {
        if (view == null) {
            throw new IllegalArgumentException("FriendlyObstruction is null");
        }
    }

    /* renamed from: c */
    private void m612c(View view) {
        this.f820d = new C3989a(view);
    }

    /* renamed from: d */
    private void m613d(View view) {
        Collection<C3967a> b = C3969a.m629a().mo55947b();
        if (b != null && b.size() > 0) {
            for (C3967a next : b) {
                if (next != this && next.mo55922c() == view) {
                    next.f820d.clear();
                }
            }
        }
    }

    /* renamed from: i */
    private void m614i() {
        if (this.f825i) {
            throw new IllegalStateException("Impression event can only be sent once");
        }
    }

    /* renamed from: a */
    public List<C3989a> mo55920a() {
        return this.f819c;
    }

    public void addFriendlyObstruction(View view) {
        if (!this.f823g) {
            m611b(view);
            if (m610a(view) == null) {
                this.f819c.add(new C3989a(view));
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo55921b() {
        m614i();
        getAdSessionStatePublisher().mo56003g();
        this.f825i = true;
    }

    /* renamed from: c */
    public View mo55922c() {
        return (View) this.f820d.get();
    }

    /* renamed from: d */
    public boolean mo55923d() {
        return this.f822f && !this.f823g;
    }

    /* renamed from: e */
    public boolean mo55924e() {
        return this.f822f;
    }

    public void error(ErrorType errorType, String str) {
        if (!this.f823g) {
            C3987e.m710a((Object) errorType, "Error type is null");
            C3987e.m712a(str, "Message is null");
            getAdSessionStatePublisher().mo55990a(errorType, str);
            return;
        }
        throw new IllegalStateException("AdSession is finished");
    }

    /* renamed from: f */
    public boolean mo55925f() {
        return this.f823g;
    }

    public void finish() {
        if (!this.f823g) {
            this.f820d.clear();
            removeAllFriendlyObstructions();
            this.f823g = true;
            getAdSessionStatePublisher().mo56002f();
            C3969a.m629a().mo55950c(this);
            getAdSessionStatePublisher().mo55997b();
            this.f821e = null;
        }
    }

    /* renamed from: g */
    public boolean mo55926g() {
        return this.f818b.isNativeImpressionOwner();
    }

    public String getAdSessionId() {
        return this.f824h;
    }

    public AdSessionStatePublisher getAdSessionStatePublisher() {
        return this.f821e;
    }

    /* renamed from: h */
    public boolean mo55927h() {
        return this.f818b.isNativeVideoEventsOwner();
    }

    public void registerAdView(View view) {
        if (!this.f823g) {
            C3987e.m710a((Object) view, "AdView is null");
            if (mo55922c() != view) {
                m612c(view);
                getAdSessionStatePublisher().mo56005h();
                m613d(view);
            }
        }
    }

    public void removeAllFriendlyObstructions() {
        if (!this.f823g) {
            this.f819c.clear();
        }
    }

    public void removeFriendlyObstruction(View view) {
        if (!this.f823g) {
            m611b(view);
            C3989a a = m610a(view);
            if (a != null) {
                this.f819c.remove(a);
            }
        }
    }

    public void start() {
        if (!this.f822f) {
            this.f822f = true;
            C3969a.m629a().mo55948b(this);
            this.f821e.mo55986a(C3976e.m666a().mo55979d());
            this.f821e.mo55991a(this, this.f817a);
        }
    }
}
