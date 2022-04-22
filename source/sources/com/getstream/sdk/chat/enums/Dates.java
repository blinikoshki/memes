package com.getstream.sdk.chat.enums;

import com.getstream.sdk.chat.C1673R;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, mo26107d2 = {"Lcom/getstream/sdk/chat/enums/Dates;", "", "labelId", "", "(Ljava/lang/String;II)V", "getLabelId$stream_chat_android_release", "()I", "TODAY", "YESTERDAY", "JUST_NOW", "stream-chat-android_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: Dates.kt */
public enum Dates {
    TODAY(C1673R.string.stream_today),
    YESTERDAY(C1673R.string.stream_yesterday),
    JUST_NOW(C1673R.string.stream_just_now);
    
    private final int labelId;

    private Dates(int i) {
        this.labelId = i;
    }

    public final int getLabelId$stream_chat_android_release() {
        return this.labelId;
    }
}
