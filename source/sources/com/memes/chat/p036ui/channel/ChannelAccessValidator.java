package com.memes.chat.p036ui.channel;

import androidx.lifecycle.LiveData;
import com.memes.chat.p036ui.channel.list.ChannelType;
import com.memes.chat.util.usecases.channelaccess.ChannelAccessResult;
import com.memes.chat.util.usecases.channelaccess.ChannelAccessValidityUseCase;
import com.memes.commons.util.SingleLiveEvent;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import p015io.getstream.chat.android.client.ChatClient;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\u0011J\u0019\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0014H@ø\u0001\u0000¢\u0006\u0002\u0010\u0015J\u000e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0013\u001a\u00020\u0014R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\n\u001a\u00020\u000b8BX\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0018"}, mo26107d2 = {"Lcom/memes/chat/ui/channel/ChannelAccessValidator;", "", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "chatClient", "Lio/getstream/chat/android/client/ChatClient;", "(Lkotlinx/coroutines/CoroutineScope;Lio/getstream/chat/android/client/ChatClient;)V", "_channelAccessResult", "Lcom/memes/commons/util/SingleLiveEvent;", "Lcom/memes/chat/util/usecases/channelaccess/ChannelAccessResult;", "channelAccessValidityUseCase", "Lcom/memes/chat/util/usecases/channelaccess/ChannelAccessValidityUseCase;", "getChannelAccessValidityUseCase", "()Lcom/memes/chat/util/usecases/channelaccess/ChannelAccessValidityUseCase;", "channelAccessValidityUseCase$delegate", "Lkotlin/Lazy;", "channelAccessResult", "Landroidx/lifecycle/LiveData;", "checkChannelAccess", "channelId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "validateAccess", "", "chat_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.chat.ui.channel.ChannelAccessValidator */
/* compiled from: ChannelAccessValidator.kt */
public final class ChannelAccessValidator {
    /* access modifiers changed from: private */
    public final SingleLiveEvent<ChannelAccessResult> _channelAccessResult = new SingleLiveEvent<>();
    private final Lazy channelAccessValidityUseCase$delegate;
    private final CoroutineScope coroutineScope;

    private final ChannelAccessValidityUseCase getChannelAccessValidityUseCase() {
        return (ChannelAccessValidityUseCase) this.channelAccessValidityUseCase$delegate.getValue();
    }

    public ChannelAccessValidator(CoroutineScope coroutineScope2, ChatClient chatClient) {
        Intrinsics.checkNotNullParameter(coroutineScope2, "coroutineScope");
        Intrinsics.checkNotNullParameter(chatClient, "chatClient");
        this.coroutineScope = coroutineScope2;
        this.channelAccessValidityUseCase$delegate = LazyKt.lazy(new ChannelAccessValidator$channelAccessValidityUseCase$2(chatClient));
    }

    public final LiveData<ChannelAccessResult> channelAccessResult() {
        return this._channelAccessResult;
    }

    public final void validateAccess(String str) {
        Intrinsics.checkNotNullParameter(str, "channelId");
        Job unused = BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new ChannelAccessValidator$validateAccess$1(this, str, (Continuation) null), 3, (Object) null);
    }

    public final Object checkChannelAccess(String str, Continuation<? super ChannelAccessResult> continuation) {
        if (ChannelType.INSTANCE.isGlobal(str)) {
            return ChannelAccessResult.Success.INSTANCE;
        }
        return getChannelAccessValidityUseCase().execute(new ChannelAccessValidityUseCase.Request(str, (String) null, 2, (DefaultConstructorMarker) null), continuation);
    }
}
