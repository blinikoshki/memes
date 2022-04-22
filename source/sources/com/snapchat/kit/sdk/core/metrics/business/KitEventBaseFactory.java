package com.snapchat.kit.sdk.core.metrics.business;

import com.snapchat.kit.sdk.core.metrics.model.KitEventBase;
import com.snapchat.kit.sdk.core.metrics.model.KitType;
import com.snapchat.kit.sdk.core.networking.C4451d;
import java.util.Locale;
import javax.inject.Inject;
import javax.inject.Named;

public class KitEventBaseFactory {

    /* renamed from: a */
    private final String f1165a;

    /* renamed from: b */
    private String f1166b = "";

    @Inject
    KitEventBaseFactory(@Named("client_id") String str) {
        this.f1165a = str;
    }

    public void setLoginKitVersion(String str) {
        this.f1166b = str;
    }

    public KitEventBase createLoginKitEventBase() {
        return createKitEventBase(KitType.LOGIN_KIT, this.f1166b);
    }

    public KitEventBase createKitEventBase(KitType kitType, String str) {
        String str2;
        KitEventBase.Builder kit_user_agent = new KitEventBase.Builder().kit_variant(kitType).kit_variant_version(str).oauth_client_id(this.f1165a).kit_user_agent(C4451d.f1257a);
        Locale locale = Locale.getDefault();
        if (locale == null) {
            str2 = "";
        } else {
            str2 = locale.toString();
        }
        return kit_user_agent.locale(str2).kit_client_timestamp_millis(Long.valueOf(System.currentTimeMillis())).build();
    }
}
