package com.memes.chat.util.extensions;

import java.util.Comparator;
import java.util.Date;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.models.ChannelUserRead;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u00032\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0006"}, mo26107d2 = {"<anonymous>", "", "o1", "Lio/getstream/chat/android/client/models/ChannelUserRead;", "kotlin.jvm.PlatformType", "o2", "compare"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: ChannelExt.kt */
final class ChannelExtKt$getLastMessageReads$1<T> implements Comparator<ChannelUserRead> {
    public static final ChannelExtKt$getLastMessageReads$1 INSTANCE = new ChannelExtKt$getLastMessageReads$1();

    ChannelExtKt$getLastMessageReads$1() {
    }

    public final int compare(ChannelUserRead channelUserRead, ChannelUserRead channelUserRead2) {
        Date lastRead = channelUserRead.getLastRead();
        Intrinsics.checkNotNull(lastRead);
        return lastRead.compareTo(channelUserRead2.getLastRead());
    }
}
