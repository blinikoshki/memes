package com.memes.plus.events;

import java.util.HashSet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0005H\u0016J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u0005H\u0016R\u001e\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, mo26107d2 = {"Lcom/memes/plus/events/BaseNotifiableEvent;", "Lcom/memes/plus/events/NotifiableEvent;", "()V", "consumers", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "consume", "", "consumerId", "consumedBy", "", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: BaseNotifiableEvent.kt */
public class BaseNotifiableEvent implements NotifiableEvent {
    private final HashSet<String> consumers = new HashSet<>();

    public void consume(String str) {
        Intrinsics.checkNotNullParameter(str, "consumerId");
        this.consumers.add(str);
    }

    public boolean consumedBy(String str) {
        Intrinsics.checkNotNullParameter(str, "consumerId");
        return this.consumers.contains(str);
    }
}
