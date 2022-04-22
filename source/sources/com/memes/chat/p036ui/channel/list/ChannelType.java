package com.memes.chat.p036ui.channel.list;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0004J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u0004J\u000e\u0010\n\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u0004J\u000e\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\f"}, mo26107d2 = {"Lcom/memes/chat/ui/channel/list/ChannelType;", "", "()V", "GLOBAL", "", "MESSAGING", "getTypeFromCid", "channelId", "isDirectMessaging", "", "isGlobal", "isMessaging", "chat_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.chat.ui.channel.list.ChannelType */
/* compiled from: ChannelType.kt */
public final class ChannelType {
    public static final String GLOBAL = "global";
    public static final ChannelType INSTANCE = new ChannelType();
    public static final String MESSAGING = "messaging";

    private ChannelType() {
    }

    public final boolean isMessaging(String str) {
        Intrinsics.checkNotNullParameter(str, "channelId");
        return StringsKt.startsWith$default(str, "messaging:", false, 2, (Object) null);
    }

    public final boolean isDirectMessaging(String str) {
        Intrinsics.checkNotNullParameter(str, "channelId");
        return StringsKt.startsWith$default(str, "messaging:!members", false, 2, (Object) null);
    }

    public final boolean isGlobal(String str) {
        Intrinsics.checkNotNullParameter(str, "channelId");
        return StringsKt.startsWith$default(str, "global:", false, 2, (Object) null);
    }

    public final String getTypeFromCid(String str) {
        Intrinsics.checkNotNullParameter(str, "channelId");
        if (StringsKt.startsWith$default(str, "messaging:", false, 2, (Object) null)) {
            return "messaging";
        }
        if (StringsKt.startsWith$default(str, "global:", false, 2, (Object) null)) {
            return GLOBAL;
        }
        return null;
    }
}
