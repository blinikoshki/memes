package com.memes.chat.p036ui.channel.info;

import com.memes.chat.util.usecases.CheckChannelMutedUseCase;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo26107d2 = {"<anonymous>", "Lcom/memes/chat/util/usecases/CheckChannelMutedUseCase;", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.chat.ui.channel.info.ChannelInfoViewModel$checkChannelMutedUseCase$2 */
/* compiled from: ChannelInfoViewModel.kt */
final class ChannelInfoViewModel$checkChannelMutedUseCase$2 extends Lambda implements Function0<CheckChannelMutedUseCase> {
    final /* synthetic */ ChannelInfoViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChannelInfoViewModel$checkChannelMutedUseCase$2(ChannelInfoViewModel channelInfoViewModel) {
        super(0);
        this.this$0 = channelInfoViewModel;
    }

    public final CheckChannelMutedUseCase invoke() {
        return new CheckChannelMutedUseCase(this.this$0.chatClient);
    }
}
