package com.memes.plus.events;

import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\b"}, mo26107d2 = {"Lcom/memes/plus/events/NotifiableEvent;", "", "consume", "", "consumerId", "", "consumedBy", "", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: NotifiableEvent.kt */
public interface NotifiableEvent {
    void consume(String str);

    boolean consumedBy(String str);
}
