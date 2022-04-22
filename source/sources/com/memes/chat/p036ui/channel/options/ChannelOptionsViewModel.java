package com.memes.chat.p036ui.channel.options;

import androidx.lifecycle.ViewModelKt;
import com.memes.chat.util.usecases.ChannelMutingUseCase;
import com.memes.commons.viewmodel.BaseViewModel;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import p015io.getstream.chat.android.client.ChatClient;
import p015io.getstream.chat.android.client.models.Channel;
import p015io.getstream.chat.android.client.models.ChannelMute;
import p015io.getstream.chat.android.client.models.User;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u0015R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u000f0\u000ej\b\u0012\u0004\u0012\u00020\u000f`\u0010X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, mo26107d2 = {"Lcom/memes/chat/ui/channel/options/ChannelOptionsViewModel;", "Lcom/memes/commons/viewmodel/BaseViewModel;", "chatClient", "Lio/getstream/chat/android/client/ChatClient;", "(Lio/getstream/chat/android/client/ChatClient;)V", "_channelMutingExceptionHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "channelMutingUseCase", "Lcom/memes/chat/util/usecases/ChannelMutingUseCase;", "getChannelMutingUseCase", "()Lcom/memes/chat/util/usecases/ChannelMutingUseCase;", "channelMutingUseCase$delegate", "Lkotlin/Lazy;", "mutedChannelIds", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "getChannelOptions", "", "Lcom/memes/chat/ui/channel/options/ChannelOption;", "channel", "Lio/getstream/chat/android/client/models/Channel;", "muteChannel", "", "unmuteChannel", "chat_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.chat.ui.channel.options.ChannelOptionsViewModel */
/* compiled from: ChannelOptionsViewModel.kt */
public final class ChannelOptionsViewModel extends BaseViewModel {
    private final CoroutineExceptionHandler _channelMutingExceptionHandler = new C4136x178a6b17(CoroutineExceptionHandler.Key, this);
    private final Lazy channelMutingUseCase$delegate = LazyKt.lazy(new ChannelOptionsViewModel$channelMutingUseCase$2(this));
    /* access modifiers changed from: private */
    public final ChatClient chatClient;
    /* access modifiers changed from: private */
    public final HashSet<String> mutedChannelIds = new HashSet<>();

    /* access modifiers changed from: private */
    public final ChannelMutingUseCase getChannelMutingUseCase() {
        return (ChannelMutingUseCase) this.channelMutingUseCase$delegate.getValue();
    }

    public ChannelOptionsViewModel(ChatClient chatClient2) {
        Intrinsics.checkNotNullParameter(chatClient2, "chatClient");
        this.chatClient = chatClient2;
    }

    public final List<ChannelOption> getChannelOptions(Channel channel) {
        Object obj;
        Intrinsics.checkNotNullParameter(channel, "channel");
        User currentUser = this.chatClient.getCurrentUser();
        if (currentUser != null) {
            List<ChannelOption> arrayList = new ArrayList<>();
            Iterator it = currentUser.getChannelMutes().iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (Intrinsics.areEqual((Object) ((ChannelMute) obj).getChannel().getId(), (Object) channel.getId())) {
                    break;
                }
            }
            if (((ChannelMute) obj) != null || this.mutedChannelIds.contains(channel.getId())) {
                arrayList.add(ChannelOption.UNMUTE);
            } else {
                arrayList.add(ChannelOption.MUTE);
            }
            return arrayList;
        }
        throw new RuntimeException("User is not logged in.");
    }

    public final void muteChannel(Channel channel) {
        Intrinsics.checkNotNullParameter(channel, "channel");
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), this._channelMutingExceptionHandler, (CoroutineStart) null, new ChannelOptionsViewModel$muteChannel$1(this, channel, (Continuation) null), 2, (Object) null);
    }

    public final void unmuteChannel(Channel channel) {
        Intrinsics.checkNotNullParameter(channel, "channel");
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), this._channelMutingExceptionHandler, (CoroutineStart) null, new ChannelOptionsViewModel$unmuteChannel$1(this, channel, (Continuation) null), 2, (Object) null);
    }
}
