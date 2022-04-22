package com.giphy.sdk.tracking;

import com.giphy.sdk.analytics.models.enums.EventType;
import com.giphy.sdk.core.network.api.CompletionHandler;
import com.giphy.sdk.core.network.response.ListMediaResponse;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a2\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006¨\u0006\b"}, mo26107d2 = {"completionHandlerWithUserDictionary", "Lcom/giphy/sdk/core/network/api/CompletionHandler;", "Lcom/giphy/sdk/core/network/response/ListMediaResponse;", "eventType", "Lcom/giphy/sdk/analytics/models/enums/EventType;", "isEmoji", "", "isText", "giphy-sdk_release"}, mo26108k = 2, mo26109mv = {1, 1, 13})
/* compiled from: CompletionHandlerExtension.kt */
public final class CompletionHandlerExtensionKt {
    public static /* synthetic */ CompletionHandler completionHandlerWithUserDictionary$default(CompletionHandler completionHandler, EventType eventType, boolean z, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        if ((i & 4) != 0) {
            z2 = false;
        }
        return completionHandlerWithUserDictionary(completionHandler, eventType, z, z2);
    }

    public static final CompletionHandler<ListMediaResponse> completionHandlerWithUserDictionary(CompletionHandler<? super ListMediaResponse> completionHandler, EventType eventType, boolean z, boolean z2) {
        Intrinsics.checkParameterIsNotNull(completionHandler, "receiver$0");
        Intrinsics.checkParameterIsNotNull(eventType, "eventType");
        return new C1799x3a509539(eventType, z, z2, new C1798x3a509538(completionHandler));
    }
}
