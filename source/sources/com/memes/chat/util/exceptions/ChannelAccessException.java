package com.memes.chat.util.exceptions;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00060\u0001j\u0002`\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\t\u0010\u0006\u001a\u00020\u0004HÂ\u0003J\u0013\u0010\u0007\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u0004HÆ\u0001J\u0013\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bHÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0004HÖ\u0001R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, mo26107d2 = {"Lcom/memes/chat/util/exceptions/ChannelAccessException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "error", "", "(Ljava/lang/String;)V", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "chat_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: ChannelAccessException.kt */
public final class ChannelAccessException extends RuntimeException {
    private final String error;

    private final String component1() {
        return this.error;
    }

    public static /* synthetic */ ChannelAccessException copy$default(ChannelAccessException channelAccessException, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = channelAccessException.error;
        }
        return channelAccessException.copy(str);
    }

    public final ChannelAccessException copy(String str) {
        Intrinsics.checkNotNullParameter(str, "error");
        return new ChannelAccessException(str);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            return (obj instanceof ChannelAccessException) && Intrinsics.areEqual((Object) this.error, (Object) ((ChannelAccessException) obj).error);
        }
        return true;
    }

    public int hashCode() {
        String str = this.error;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "ChannelAccessException(error=" + this.error + ")";
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChannelAccessException(String str) {
        super(str);
        Intrinsics.checkNotNullParameter(str, "error");
        this.error = str;
    }
}
