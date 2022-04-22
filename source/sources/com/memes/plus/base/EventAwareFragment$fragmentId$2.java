package com.memes.plus.base;

import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo26107d2 = {"<anonymous>", "", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: EventAwareFragment.kt */
final class EventAwareFragment$fragmentId$2 extends Lambda implements Function0<String> {
    public static final EventAwareFragment$fragmentId$2 INSTANCE = new EventAwareFragment$fragmentId$2();

    EventAwareFragment$fragmentId$2() {
        super(0);
    }

    public final String invoke() {
        return UUID.randomUUID().toString();
    }
}
