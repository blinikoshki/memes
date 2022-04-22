package com.memes.plus.p040ui.post_comments.reply;

import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u0004XD¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, mo26107d2 = {"Lcom/memes/plus/ui/post_comments/reply/ReplyState;", "", "()V", "STATE_ADD", "", "getSTATE_ADD", "()I", "STATE_UPDATE", "getSTATE_UPDATE", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.post_comments.reply.ReplyState */
/* compiled from: ReplyState.kt */
public final class ReplyState {
    public static final ReplyState INSTANCE = new ReplyState();
    private static final int STATE_ADD = 0;
    private static final int STATE_UPDATE = 1;

    private ReplyState() {
    }

    public final int getSTATE_ADD() {
        return STATE_ADD;
    }

    public final int getSTATE_UPDATE() {
        return STATE_UPDATE;
    }
}
