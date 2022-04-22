package com.snapchat.kit.sdk.core.metrics.business;

import com.snapchat.kit.sdk.core.metrics.model.LoginKitAuthComplete;
import com.snapchat.kit.sdk.core.metrics.model.LoginKitAuthStart;
import com.snapchat.kit.sdk.core.metrics.model.LoginKitEventBase;
import com.snapchat.kit.sdk.core.metrics.model.ServerEvent;
import com.snapchat.kit.sdk.core.metrics.model.ServerEventData;
import com.snapchat.kit.sdk.core.models.SnapKitFeatureOptions;
import javax.inject.Inject;

/* renamed from: com.snapchat.kit.sdk.core.metrics.business.e */
public final class C4422e {

    /* renamed from: a */
    private final KitEventBaseFactory f1181a;

    @Inject
    C4422e(KitEventBaseFactory kitEventBaseFactory) {
        this.f1181a = kitEventBaseFactory;
    }

    /* renamed from: a */
    public final ServerEvent mo61355a(SnapKitFeatureOptions snapKitFeatureOptions) {
        return m871a(new ServerEventData.Builder().login_kit_auth_start(new LoginKitAuthStart.Builder().log_kit_event_base(m870a()).features_requested_string_list(snapKitFeatureOptions.profileLinkEnabled ? "PROFILE_LINK" : null).build()).build());
    }

    /* renamed from: a */
    public final ServerEvent mo61356a(boolean z) {
        return m871a(new ServerEventData.Builder().login_kit_auth_complete(new LoginKitAuthComplete.Builder().log_kit_event_base(m870a()).is_success(Boolean.valueOf(z)).build()).build());
    }

    /* renamed from: a */
    private static ServerEvent m871a(ServerEventData serverEventData) {
        return new ServerEvent.Builder().event_data(serverEventData).build();
    }

    /* renamed from: a */
    private LoginKitEventBase m870a() {
        return new LoginKitEventBase.Builder().kit_event_base(this.f1181a.createLoginKitEventBase()).build();
    }
}
