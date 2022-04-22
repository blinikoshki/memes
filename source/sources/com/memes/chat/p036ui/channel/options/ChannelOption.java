package com.memes.chat.p036ui.channel.options;

import com.memes.commons.choices.Choice;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, mo26107d2 = {"Lcom/memes/chat/ui/channel/options/ChannelOption;", "", "(Ljava/lang/String;I)V", "choice", "Lcom/memes/commons/choices/Choice;", "getChoice", "()Lcom/memes/commons/choices/Choice;", "MUTE", "UNMUTE", "chat_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.chat.ui.channel.options.ChannelOption */
/* compiled from: ChannelOption.kt */
public enum ChannelOption {
    ;

    public abstract Choice getChoice();

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0001\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, mo26107d2 = {"Lcom/memes/chat/ui/channel/options/ChannelOption$MUTE;", "Lcom/memes/chat/ui/channel/options/ChannelOption;", "choice", "Lcom/memes/commons/choices/Choice;", "getChoice", "()Lcom/memes/commons/choices/Choice;", "chat_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: com.memes.chat.ui.channel.options.ChannelOption$MUTE */
    /* compiled from: ChannelOption.kt */
    static final class MUTE extends ChannelOption {
        private final Choice choice;

        MUTE(String str, int i) {
            super(str, i, (DefaultConstructorMarker) null);
            this.choice = Choice.Companion.create$default(Choice.Companion, "channel-mute", "Mute", false, (Choice.HighlightType) null, 12, (Object) null);
        }

        public Choice getChoice() {
            return this.choice;
        }
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0001\u0018\u00002\u00020\u0001R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, mo26107d2 = {"Lcom/memes/chat/ui/channel/options/ChannelOption$UNMUTE;", "Lcom/memes/chat/ui/channel/options/ChannelOption;", "choice", "Lcom/memes/commons/choices/Choice;", "getChoice", "()Lcom/memes/commons/choices/Choice;", "chat_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: com.memes.chat.ui.channel.options.ChannelOption$UNMUTE */
    /* compiled from: ChannelOption.kt */
    static final class UNMUTE extends ChannelOption {
        private final Choice choice;

        UNMUTE(String str, int i) {
            super(str, i, (DefaultConstructorMarker) null);
            this.choice = Choice.Companion.create$default(Choice.Companion, "channel-unmute", "Unmute", false, (Choice.HighlightType) null, 12, (Object) null);
        }

        public Choice getChoice() {
            return this.choice;
        }
    }
}
