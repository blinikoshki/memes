package com.memes.chat.p036ui.channel.create.stages;

import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\tB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\n"}, mo26107d2 = {"Lcom/memes/chat/ui/channel/create/stages/CreateChannelStage;", "", "position", "", "(Ljava/lang/String;II)V", "getPosition", "()I", "CHOOSE_MEMBERS", "CHANNEL_INFO_INPUT", "Companion", "chat_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.chat.ui.channel.create.stages.CreateChannelStage */
/* compiled from: CreateChannelStage.kt */
public enum CreateChannelStage {
    CHOOSE_MEMBERS(0),
    CHANNEL_INFO_INPUT(1);
    
    public static final Companion Companion = null;
    public static final int stageCount = 2;
    private final int position;

    private CreateChannelStage(int i) {
        this.position = i;
    }

    public final int getPosition() {
        return this.position;
    }

    static {
        Companion = new Companion((DefaultConstructorMarker) null);
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo26107d2 = {"Lcom/memes/chat/ui/channel/create/stages/CreateChannelStage$Companion;", "", "()V", "stageCount", "", "chat_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: com.memes.chat.ui.channel.create.stages.CreateChannelStage$Companion */
    /* compiled from: CreateChannelStage.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
