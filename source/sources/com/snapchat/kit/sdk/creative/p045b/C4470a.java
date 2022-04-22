package com.snapchat.kit.sdk.creative.p045b;

import com.snapchat.kit.sdk.core.metrics.business.KitEventBaseFactory;
import com.snapchat.kit.sdk.core.metrics.model.CreativeKitEventBase;
import com.snapchat.kit.sdk.core.metrics.model.CreativeKitShareStart;
import com.snapchat.kit.sdk.core.metrics.model.KitType;
import com.snapchat.kit.sdk.core.metrics.model.ServerEvent;
import com.snapchat.kit.sdk.core.metrics.model.ServerEventData;
import javax.inject.Inject;

/* renamed from: com.snapchat.kit.sdk.creative.b.a */
public final class C4470a {

    /* renamed from: a */
    private final KitEventBaseFactory f1276a;

    @Inject
    C4470a(KitEventBaseFactory kitEventBaseFactory) {
        this.f1276a = kitEventBaseFactory;
    }

    /* renamed from: a */
    public final ServerEvent mo61748a() {
        return new ServerEvent.Builder().event_data(new ServerEventData.Builder().creative_kit_share_start(new CreativeKitShareStart.Builder().creative_kit_event_base(new CreativeKitEventBase.Builder().kit_event_base(this.f1276a.createKitEventBase(KitType.CREATIVE_KIT, "1.6.8")).build()).build()).build()).build();
    }
}
