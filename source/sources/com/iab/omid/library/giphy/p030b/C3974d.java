package com.iab.omid.library.giphy.p030b;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.webkit.WebView;
import com.iab.omid.library.giphy.adsession.ErrorType;
import com.iab.omid.library.giphy.p032d.C3985c;
import com.memes.eventtracker.util.Util;
import kotlin.text.Typography;
import org.json.JSONObject;

/* renamed from: com.iab.omid.library.giphy.b.d */
public class C3974d {

    /* renamed from: a */
    private static C3974d f845a = new C3974d();

    private C3974d() {
    }

    /* renamed from: a */
    public static C3974d m651a() {
        return f845a;
    }

    /* renamed from: a */
    public void mo55961a(WebView webView) {
        mo55966a(webView, "finishSession", new Object[0]);
    }

    /* renamed from: a */
    public void mo55962a(WebView webView, float f) {
        mo55966a(webView, "setDeviceVolume", Float.valueOf(f));
    }

    /* renamed from: a */
    public void mo55963a(WebView webView, ErrorType errorType, String str) {
        mo55966a(webView, "error", errorType.toString(), str);
    }

    /* renamed from: a */
    public void mo55964a(WebView webView, String str, JSONObject jSONObject) {
        if (jSONObject != null) {
            mo55966a(webView, "publishVideoEvent", str, jSONObject);
            return;
        }
        mo55966a(webView, "publishVideoEvent", str);
    }

    /* renamed from: a */
    public void mo55965a(WebView webView, String str, JSONObject jSONObject, JSONObject jSONObject2) {
        mo55966a(webView, "startSession", str, jSONObject, jSONObject2);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo55966a(WebView webView, String str, Object... objArr) {
        if (webView != null) {
            StringBuilder sb = new StringBuilder(128);
            sb.append("javascript: if(window.omidBridge!==undefined){omidBridge.");
            sb.append(str);
            sb.append("(");
            mo55969a(sb, objArr);
            sb.append(")}");
            mo55967a(webView, sb);
            return;
        }
        C3985c.m704a("The WebView is null for " + str);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo55967a(final WebView webView, StringBuilder sb) {
        final String sb2 = sb.toString();
        Handler handler = webView.getHandler();
        if (handler == null || Looper.myLooper() == handler.getLooper()) {
            webView.loadUrl(sb2);
        } else {
            handler.post(new Runnable() {
                public void run() {
                    webView.loadUrl(sb2);
                }
            });
        }
    }

    /* renamed from: a */
    public void mo55968a(WebView webView, JSONObject jSONObject) {
        mo55966a(webView, "init", jSONObject);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo55969a(StringBuilder sb, Object[] objArr) {
        if (objArr != null && objArr.length > 0) {
            for (Object obj : objArr) {
                if (obj == null) {
                    sb.append(Typography.quote);
                } else {
                    if (obj instanceof String) {
                        String obj2 = obj.toString();
                        if (obj2.startsWith("{")) {
                            sb.append(obj2);
                        } else {
                            sb.append(Typography.quote);
                            sb.append(obj2);
                        }
                    } else {
                        sb.append(obj);
                    }
                    sb.append(Util.EVENT_ID_SEPARATOR);
                }
                sb.append(Typography.quote);
                sb.append(Util.EVENT_ID_SEPARATOR);
            }
            sb.setLength(sb.length() - 1);
        }
    }

    /* renamed from: a */
    public boolean mo55970a(WebView webView, String str) {
        if (webView == null || TextUtils.isEmpty(str)) {
            return false;
        }
        webView.loadUrl("javascript: " + str);
        return true;
    }

    /* renamed from: b */
    public void mo55971b(WebView webView) {
        mo55966a(webView, "publishImpressionEvent", new Object[0]);
    }

    /* renamed from: b */
    public void mo55972b(WebView webView, String str) {
        if (str != null) {
            mo55970a(webView, "var script=document.createElement('script');script.setAttribute(\"type\",\"text/javascript\");script.setAttribute(\"src\",\"%SCRIPT_SRC%\");document.body.appendChild(script);".replace("%SCRIPT_SRC%", str));
        }
    }

    /* renamed from: c */
    public void mo55973c(WebView webView, String str) {
        mo55966a(webView, "setNativeViewHierarchy", str);
    }

    /* renamed from: d */
    public void mo55974d(WebView webView, String str) {
        mo55966a(webView, "setState", str);
    }
}
