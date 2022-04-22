package com.memes.chat.p036ui.channel;

import com.memes.chat.util.usecases.channelaccess.ChannelAccessValidityUseCase;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import p015io.getstream.chat.android.client.ChatClient;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo26107d2 = {"<anonymous>", "Lcom/memes/chat/util/usecases/channelaccess/ChannelAccessValidityUseCase;", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.chat.ui.channel.ChannelAccessValidator$channelAccessValidityUseCase$2 */
/* compiled from: ChannelAccessValidator.kt */
final class ChannelAccessValidator$channelAccessValidityUseCase$2 extends Lambda implements Function0<ChannelAccessValidityUseCase> {
    final /* synthetic */ ChatClient $chatClient;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChannelAccessValidator$channelAccessValidityUseCase$2(ChatClient chatClient) {
        super(0);
        this.$chatClient = chatClient;
    }

    public final ChannelAccessValidityUseCase invoke() {
        return new ChannelAccessValidityUseCase(this.$chatClient);
    }
}
