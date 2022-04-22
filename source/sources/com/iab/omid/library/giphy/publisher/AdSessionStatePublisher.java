package com.iab.omid.library.giphy.publisher;

import android.webkit.WebView;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.iab.omid.library.giphy.adsession.AdEvents;
import com.iab.omid.library.giphy.adsession.AdSessionConfiguration;
import com.iab.omid.library.giphy.adsession.AdSessionContext;
import com.iab.omid.library.giphy.adsession.C3967a;
import com.iab.omid.library.giphy.adsession.ErrorType;
import com.iab.omid.library.giphy.adsession.VerificationScriptResource;
import com.iab.omid.library.giphy.adsession.video.VideoEvents;
import com.iab.omid.library.giphy.p030b.C3973c;
import com.iab.omid.library.giphy.p030b.C3974d;
import com.iab.omid.library.giphy.p032d.C3982a;
import com.iab.omid.library.giphy.p032d.C3983b;
import com.iab.omid.library.giphy.p032d.C3986d;
import com.iab.omid.library.giphy.p033e.C3990b;
import org.json.JSONArray;
import org.json.JSONObject;

public abstract class AdSessionStatePublisher {

    /* renamed from: a */
    private C3990b f863a = new C3990b((WebView) null);

    /* renamed from: b */
    private AdEvents f864b;

    /* renamed from: c */
    private VideoEvents f865c;

    /* renamed from: d */
    private C3991a f866d;

    /* renamed from: e */
    private double f867e;

    /* renamed from: com.iab.omid.library.giphy.publisher.AdSessionStatePublisher$a */
    enum C3991a {
        AD_STATE_IDLE,
        AD_STATE_VISIBLE,
        AD_STATE_HIDDEN
    }

    public AdSessionStatePublisher() {
        mo56005h();
    }

    /* renamed from: a */
    public void mo55985a() {
    }

    /* renamed from: a */
    public void mo55986a(float f) {
        C3974d.m651a().mo55962a(getWebView(), f);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo55987a(WebView webView) {
        this.f863a = new C3990b(webView);
    }

    /* renamed from: a */
    public void mo55988a(AdEvents adEvents) {
        this.f864b = adEvents;
    }

    /* renamed from: a */
    public void mo55989a(AdSessionConfiguration adSessionConfiguration) {
        C3974d.m651a().mo55968a(getWebView(), adSessionConfiguration.toJsonObject());
    }

    /* renamed from: a */
    public void mo55990a(ErrorType errorType, String str) {
        C3974d.m651a().mo55963a(getWebView(), errorType, str);
    }

    /* renamed from: a */
    public void mo55991a(C3967a aVar, AdSessionContext adSessionContext) {
        String adSessionId = aVar.getAdSessionId();
        JSONObject jSONObject = new JSONObject();
        C3983b.m694a(jSONObject, "environment", "app");
        C3983b.m694a(jSONObject, "adSessionType", adSessionContext.getAdSessionContextType());
        C3983b.m694a(jSONObject, "deviceInfo", C3982a.m688d());
        JSONArray jSONArray = new JSONArray();
        jSONArray.put("clid");
        jSONArray.put("vlid");
        C3983b.m694a(jSONObject, "supports", jSONArray);
        JSONObject jSONObject2 = new JSONObject();
        C3983b.m694a(jSONObject2, "partnerName", adSessionContext.getPartner().getName());
        C3983b.m694a(jSONObject2, "partnerVersion", adSessionContext.getPartner().getVersion());
        C3983b.m694a(jSONObject, "omidNativeInfo", jSONObject2);
        JSONObject jSONObject3 = new JSONObject();
        C3983b.m694a(jSONObject3, "libraryVersion", "1.2.13-Giphy");
        C3983b.m694a(jSONObject3, RemoteConfigConstants.RequestFieldKey.APP_ID, C3973c.m648a().mo55960b().getApplicationContext().getPackageName());
        C3983b.m694a(jSONObject, "app", jSONObject3);
        if (adSessionContext.getCustomReferenceData() != null) {
            C3983b.m694a(jSONObject, "customReferenceData", adSessionContext.getCustomReferenceData());
        }
        JSONObject jSONObject4 = new JSONObject();
        for (VerificationScriptResource next : adSessionContext.getVerificationScriptResources()) {
            C3983b.m694a(jSONObject4, next.getVendorKey(), next.getVerificationParameters());
        }
        C3974d.m651a().mo55965a(getWebView(), adSessionId, jSONObject, jSONObject4);
    }

    /* renamed from: a */
    public void mo55992a(VideoEvents videoEvents) {
        this.f865c = videoEvents;
    }

    /* renamed from: a */
    public void mo55993a(String str) {
        C3974d.m651a().mo55964a(getWebView(), str, (JSONObject) null);
    }

    /* renamed from: a */
    public void mo55994a(String str, double d) {
        if (d > this.f867e) {
            this.f866d = C3991a.AD_STATE_VISIBLE;
            C3974d.m651a().mo55973c(getWebView(), str);
        }
    }

    /* renamed from: a */
    public void mo55995a(String str, JSONObject jSONObject) {
        C3974d.m651a().mo55964a(getWebView(), str, jSONObject);
    }

    /* renamed from: a */
    public void mo55996a(boolean z) {
        if (mo56001e()) {
            C3974d.m651a().mo55974d(getWebView(), z ? "foregrounded" : "backgrounded");
        }
    }

    /* renamed from: b */
    public void mo55997b() {
        this.f863a.clear();
    }

    /* renamed from: b */
    public void mo55998b(String str, double d) {
        if (d > this.f867e && this.f866d != C3991a.AD_STATE_HIDDEN) {
            this.f866d = C3991a.AD_STATE_HIDDEN;
            C3974d.m651a().mo55973c(getWebView(), str);
        }
    }

    /* renamed from: c */
    public AdEvents mo55999c() {
        return this.f864b;
    }

    /* renamed from: d */
    public VideoEvents mo56000d() {
        return this.f865c;
    }

    /* renamed from: e */
    public boolean mo56001e() {
        return this.f863a.get() != null;
    }

    /* renamed from: f */
    public void mo56002f() {
        C3974d.m651a().mo55961a(getWebView());
    }

    /* renamed from: g */
    public void mo56003g() {
        C3974d.m651a().mo55971b(getWebView());
    }

    public WebView getWebView() {
        return (WebView) this.f863a.get();
    }

    /* renamed from: h */
    public void mo56005h() {
        this.f867e = C3986d.m706a();
        this.f866d = C3991a.AD_STATE_IDLE;
    }
}
