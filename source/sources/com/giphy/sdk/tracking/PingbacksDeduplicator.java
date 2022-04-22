package com.giphy.sdk.tracking;

import java.util.HashMap;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\t\u001a\u00020\nJ\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0005R@\u0010\u0003\u001a4\u0012\u0004\u0012\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00060\u0004j\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u00050\u0006j\b\u0012\u0004\u0012\u00020\u0005`\b`\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, mo26107d2 = {"Lcom/giphy/sdk/tracking/PingbacksDeduplicator;", "", "()V", "tracked", "Ljava/util/HashMap;", "", "Ljava/util/HashSet;", "Lkotlin/collections/HashMap;", "Lkotlin/collections/HashSet;", "reset", "", "trackNeeded", "", "mediaId", "responseId", "giphy-sdk_release"}, mo26108k = 1, mo26109mv = {1, 1, 13})
/* compiled from: PingbacksDeduplicator.kt */
public final class PingbacksDeduplicator {
    private final HashMap<String, HashSet<String>> tracked = new HashMap<>();

    public final boolean trackNeeded(String str, String str2) {
        Intrinsics.checkParameterIsNotNull(str, "mediaId");
        Intrinsics.checkParameterIsNotNull(str2, "responseId");
        HashSet hashSet = this.tracked.get(str2);
        if (hashSet == null) {
            this.tracked.put(str2, SetsKt.hashSetOf(str));
            return true;
        } else if (hashSet.contains(str)) {
            return false;
        } else {
            hashSet.add(str);
            return true;
        }
    }

    public final void reset() {
        this.tracked.clear();
    }
}
