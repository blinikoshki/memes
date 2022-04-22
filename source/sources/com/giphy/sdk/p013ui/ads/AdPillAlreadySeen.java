package com.giphy.sdk.p013ui.ads;

import java.util.HashSet;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0005R\u001e\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, mo26107d2 = {"Lcom/giphy/sdk/ui/ads/AdPillAlreadySeen;", "", "()V", "alreadySeen", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "clear", "", "markSeen", "", "position", "ui-sdk_release"}, mo26108k = 1, mo26109mv = {1, 1, 13})
/* renamed from: com.giphy.sdk.ui.ads.AdPillAlreadySeen */
/* compiled from: AdPillAlreadySeen.kt */
public final class AdPillAlreadySeen {
    private final HashSet<Integer> alreadySeen = new HashSet<>();

    public final boolean markSeen(int i) {
        boolean contains = this.alreadySeen.contains(Integer.valueOf(i));
        this.alreadySeen.add(Integer.valueOf(i));
        return contains;
    }

    public final void clear() {
        this.alreadySeen.clear();
    }
}
