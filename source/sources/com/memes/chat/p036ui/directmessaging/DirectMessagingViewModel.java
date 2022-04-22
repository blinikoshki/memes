package com.memes.chat.p036ui.directmessaging;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelKt;
import com.memes.chat.util.usecases.CheckUserExistenceUseCase;
import com.memes.chat.util.usecases.CreateChannelUseCase;
import com.memes.commons.util.SingleLiveEvent;
import com.memes.commons.viewmodel.BaseViewModel;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import p015io.getstream.chat.android.client.ChatClient;
import p015io.getstream.chat.android.client.models.Channel;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0015\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0012ø\u0001\u0000J\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016R\u001d\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0017"}, mo26107d2 = {"Lcom/memes/chat/ui/directmessaging/DirectMessagingViewModel;", "Lcom/memes/commons/viewmodel/BaseViewModel;", "chatClient", "Lio/getstream/chat/android/client/ChatClient;", "(Lio/getstream/chat/android/client/ChatClient;)V", "_channelCreation", "Lcom/memes/commons/util/SingleLiveEvent;", "Lkotlin/Result;", "Lio/getstream/chat/android/client/models/Channel;", "checkUserExistenceUseCase", "Lcom/memes/chat/util/usecases/CheckUserExistenceUseCase;", "createChannelExceptionHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "createChannelJob", "Lkotlinx/coroutines/Job;", "createChannelUseCase", "Lcom/memes/chat/util/usecases/CreateChannelUseCase;", "channelCreation", "Landroidx/lifecycle/LiveData;", "createChannel", "", "targetUserId", "", "chat_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.chat.ui.directmessaging.DirectMessagingViewModel */
/* compiled from: DirectMessagingViewModel.kt */
public final class DirectMessagingViewModel extends BaseViewModel {
    /* access modifiers changed from: private */
    public final SingleLiveEvent<Result<Channel>> _channelCreation = new SingleLiveEvent<>();
    /* access modifiers changed from: private */
    public final CheckUserExistenceUseCase checkUserExistenceUseCase;
    private final CoroutineExceptionHandler createChannelExceptionHandler = new C4140x69589e57(CoroutineExceptionHandler.Key, this);
    /* access modifiers changed from: private */
    public Job createChannelJob;
    /* access modifiers changed from: private */
    public final CreateChannelUseCase createChannelUseCase;

    public static final /* synthetic */ Job access$getCreateChannelJob$p(DirectMessagingViewModel directMessagingViewModel) {
        Job job = directMessagingViewModel.createChannelJob;
        if (job == null) {
            Intrinsics.throwUninitializedPropertyAccessException("createChannelJob");
        }
        return job;
    }

    public DirectMessagingViewModel(ChatClient chatClient) {
        Intrinsics.checkNotNullParameter(chatClient, "chatClient");
        this.checkUserExistenceUseCase = new CheckUserExistenceUseCase(chatClient);
        this.createChannelUseCase = new CreateChannelUseCase(chatClient);
    }

    public final LiveData<Result<Channel>> channelCreation() {
        return this._channelCreation;
    }

    public final void createChannel(String str) {
        Intrinsics.checkNotNullParameter(str, "targetUserId");
        if (this.createChannelJob != null) {
            Job job = this.createChannelJob;
            if (job == null) {
                Intrinsics.throwUninitializedPropertyAccessException("createChannelJob");
            }
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.createChannelJob = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), this.createChannelExceptionHandler, (CoroutineStart) null, new DirectMessagingViewModel$createChannel$2(this, str, (Continuation) null), 2, (Object) null);
    }
}
