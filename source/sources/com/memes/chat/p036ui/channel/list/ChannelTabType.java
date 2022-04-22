package com.memes.chat.p036ui.channel.list;

import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\n"}, mo26107d2 = {"Lcom/memes/chat/ui/channel/list/ChannelTabType;", "", "position", "", "(Ljava/lang/String;II)V", "getPosition", "()I", "PUBLIC", "PRIVATE", "Companion", "chat_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.chat.ui.channel.list.ChannelTabType */
/* compiled from: ChannelTabType.kt */
public enum ChannelTabType {
    PUBLIC(0),
    PRIVATE(1);
    
    public static final Companion Companion = null;
    private final int position;

    private ChannelTabType(int i) {
        this.position = i;
    }

    public final int getPosition() {
        return this.position;
    }

    static {
        Companion = new Companion((DefaultConstructorMarker) null);
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, mo26107d2 = {"Lcom/memes/chat/ui/channel/list/ChannelTabType$Companion;", "", "()V", "tabTypeForPosition", "Lcom/memes/chat/ui/channel/list/ChannelTabType;", "tabPosition", "", "chat_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: com.memes.chat.ui.channel.list.ChannelTabType$Companion */
    /* compiled from: ChannelTabType.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ChannelTabType tabTypeForPosition(int i) {
            if (i == ChannelTabType.PRIVATE.getPosition()) {
                return ChannelTabType.PRIVATE;
            }
            if (i == ChannelTabType.PUBLIC.getPosition()) {
                return ChannelTabType.PUBLIC;
            }
            throw new RuntimeException("Unknown tab-position for Channel Tab Type: " + i);
        }
    }
}
