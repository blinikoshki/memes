package com.getstream.sdk.chat.view;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, mo26107d2 = {"createText", "", "formatString", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.getstream.sdk.chat.view.MessageListView$DefaultScrollButtonBehaviour$formatNewMessagesText$1 */
/* compiled from: MessageListView.kt */
final class C1739x10331042 extends Lambda implements Function1<String, String> {
    final /* synthetic */ int $unseenItems;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C1739x10331042(int i) {
        super(1);
        this.$unseenItems = i;
    }

    public final String invoke(String str) {
        if (str == null) {
            return String.valueOf(this.$unseenItems);
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format(str, Arrays.copyOf(new Object[]{Integer.valueOf(this.$unseenItems)}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
        return format;
    }
}
