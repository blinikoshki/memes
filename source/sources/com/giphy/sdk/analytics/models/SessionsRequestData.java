package com.giphy.sdk.analytics.models;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0013\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006¢\u0006\u0002\u0010\u0007R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00030\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, mo26107d2 = {"Lcom/giphy/sdk/analytics/models/SessionsRequestData;", "", "session", "Lcom/giphy/sdk/analytics/models/Session;", "(Lcom/giphy/sdk/analytics/models/Session;)V", "sessions", "", "(Ljava/util/List;)V", "getSessions", "()Ljava/util/List;", "giphy-android-sdk-analytics_release"}, mo26108k = 1, mo26109mv = {1, 1, 13})
/* compiled from: SessionsRequestData.kt */
public final class SessionsRequestData {
    private final List<Session> sessions;

    public SessionsRequestData(List<Session> list) {
        Intrinsics.checkParameterIsNotNull(list, "sessions");
        this.sessions = list;
    }

    public final List<Session> getSessions() {
        return this.sessions;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public SessionsRequestData(Session session) {
        this((List<Session>) CollectionsKt.listOf(session));
        Intrinsics.checkParameterIsNotNull(session, "session");
    }
}
