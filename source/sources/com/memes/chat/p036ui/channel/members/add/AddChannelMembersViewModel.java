package com.memes.chat.p036ui.channel.members.add;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelKt;
import com.memes.chat.util.usecases.AddChannelMembersUseCase;
import com.memes.commons.util.SingleLiveEvent;
import com.memes.commons.viewmodel.BaseViewModel;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import p015io.getstream.chat.android.client.ChatClient;
import p015io.getstream.chat.android.client.models.ModelFields;
import p015io.getstream.chat.android.client.models.User;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u0011J\u0016\u0010\u0017\u001a\u0012\u0012\u000e\u0012\f\u0012\b\u0012\u00060\bj\u0002`\t0\u00070\u0018J\u0018\u0010\u0019\u001a\u00020\u00152\u0010\u0010\u001a\u001a\f\u0012\b\u0012\u00060\bj\u0002`\t0\u0007R\u001e\u0010\u0005\u001a\u0012\u0012\u000e\u0012\f\u0012\b\u0012\u00060\bj\u0002`\t0\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X.¢\u0006\u0002\n\u0000R\u0018\u0010\u0012\u001a\f\u0012\b\u0012\u00060\bj\u0002`\t0\u0013X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, mo26107d2 = {"Lcom/memes/chat/ui/channel/members/add/AddChannelMembersViewModel;", "Lcom/memes/commons/viewmodel/BaseViewModel;", "chatClient", "Lio/getstream/chat/android/client/ChatClient;", "(Lio/getstream/chat/android/client/ChatClient;)V", "_channelMembersAdded", "Lcom/memes/commons/util/SingleLiveEvent;", "", "Lio/getstream/chat/android/client/models/User;", "Lcom/memes/chat/ui/channel/create/stages/memberselection/ChannelMember;", "addChannelMembersExceptionHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "addChannelMembersJob", "Lkotlinx/coroutines/Job;", "addChannelMembersUseCase", "Lcom/memes/chat/util/usecases/AddChannelMembersUseCase;", "channelId", "", "channelMembers", "", "addSelectedMembers", "", "channelIdChanged", "channelMembersAdded", "Landroidx/lifecycle/LiveData;", "channelMembersChanged", "members", "chat_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.chat.ui.channel.members.add.AddChannelMembersViewModel */
/* compiled from: AddChannelMembersViewModel.kt */
public final class AddChannelMembersViewModel extends BaseViewModel {
    /* access modifiers changed from: private */
    public final SingleLiveEvent<List<User>> _channelMembersAdded;
    private final CoroutineExceptionHandler addChannelMembersExceptionHandler;
    /* access modifiers changed from: private */
    public Job addChannelMembersJob;
    /* access modifiers changed from: private */
    public final AddChannelMembersUseCase addChannelMembersUseCase;
    /* access modifiers changed from: private */
    public String channelId;
    /* access modifiers changed from: private */
    public final List<User> channelMembers = new ArrayList();

    public static final /* synthetic */ Job access$getAddChannelMembersJob$p(AddChannelMembersViewModel addChannelMembersViewModel) {
        Job job = addChannelMembersViewModel.addChannelMembersJob;
        if (job == null) {
            Intrinsics.throwUninitializedPropertyAccessException("addChannelMembersJob");
        }
        return job;
    }

    public static final /* synthetic */ String access$getChannelId$p(AddChannelMembersViewModel addChannelMembersViewModel) {
        String str = addChannelMembersViewModel.channelId;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("channelId");
        }
        return str;
    }

    public AddChannelMembersViewModel(ChatClient chatClient) {
        Intrinsics.checkNotNullParameter(chatClient, "chatClient");
        this.addChannelMembersUseCase = new AddChannelMembersUseCase(chatClient);
        this._channelMembersAdded = new SingleLiveEvent<>();
        this.addChannelMembersExceptionHandler = new C4119x6ba96a5b(CoroutineExceptionHandler.Key, this);
    }

    public final LiveData<List<User>> channelMembersAdded() {
        return this._channelMembersAdded;
    }

    public final void channelIdChanged(String str) {
        Intrinsics.checkNotNullParameter(str, "channelId");
        this.channelId = str;
    }

    public final void channelMembersChanged(List<User> list) {
        Intrinsics.checkNotNullParameter(list, ModelFields.MEMBERS);
        this.channelMembers.clear();
        this.channelMembers.addAll(list);
    }

    public final void addSelectedMembers() {
        if (this.channelMembers.isEmpty()) {
            toast("Please select at least one member to add");
            return;
        }
        if (this.addChannelMembersJob != null) {
            Job job = this.addChannelMembersJob;
            if (job == null) {
                Intrinsics.throwUninitializedPropertyAccessException("addChannelMembersJob");
            }
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.addChannelMembersJob = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), this.addChannelMembersExceptionHandler, (CoroutineStart) null, new AddChannelMembersViewModel$addSelectedMembers$2(this, (Continuation) null), 2, (Object) null);
    }
}
