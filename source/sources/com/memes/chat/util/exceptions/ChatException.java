package com.memes.chat.util.exceptions;

import com.facebook.share.internal.ShareConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0016\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, mo26107d2 = {"Lcom/memes/chat/util/exceptions/ChatException;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "message", "", "fatal", "", "(Ljava/lang/String;Z)V", "getFatal", "()Z", "chat_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: ChatException.kt */
public class ChatException extends RuntimeException {
    private final boolean fatal;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ChatException(String str, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? false : z);
    }

    public final boolean getFatal() {
        return this.fatal;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChatException(String str, boolean z) {
        super(str);
        Intrinsics.checkNotNullParameter(str, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        this.fatal = z;
    }
}
