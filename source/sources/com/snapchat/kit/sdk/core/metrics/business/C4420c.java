package com.snapchat.kit.sdk.core.metrics.business;

import android.os.Build;
import com.snapchat.kit.sdk.core.dagger.scope.SnapConnectScope;
import com.snapchat.kit.sdk.core.metrics.C4402a;
import com.snapchat.kit.sdk.core.metrics.MetricQueue;
import com.snapchat.kit.sdk.core.metrics.model.ServerEvent;
import javax.inject.Inject;

@SnapConnectScope
/* renamed from: com.snapchat.kit.sdk.core.metrics.business.c */
public final class C4420c implements MetricQueue<ServerEvent> {

    /* renamed from: a */
    private final C4425h f1177a;

    /* renamed from: b */
    private final C4402a<ServerEvent> f1178b;

    public final /* synthetic */ void push(Object obj) {
        this.f1178b.push(((ServerEvent) obj).newBuilder().sequence_id(Long.valueOf(this.f1177a.mo61358b())).os_type("Android").os_version(Build.VERSION.RELEASE == null ? "" : Build.VERSION.RELEASE).build());
    }

    @Inject
    C4420c(C4425h hVar, C4402a<ServerEvent> aVar) {
        this.f1177a = hVar;
        this.f1178b = aVar;
    }
}
