package com.memes.chat.p036ui.channel.members;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelKt;
import com.memes.chat.util.usecases.ChannelInfoUseCase;
import com.memes.chat.util.usecases.ChannelMembersUseCase;
import com.memes.chat.util.usecases.RemoveChannelMemberUseCase;
import com.memes.commons.contentlayout.ContentVisibilityAction;
import com.memes.commons.pagination.Paginator;
import com.memes.commons.recycleradapter.AdapterUpdate;
import com.memes.commons.util.SingleLiveEvent;
import com.memes.commons.viewmodel.BaseViewModel;
import java.util.concurrent.CancellationException;
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
import p015io.getstream.chat.android.client.models.Member;
import p015io.getstream.chat.android.client.models.User;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\f\u00107\u001a\b\u0012\u0004\u0012\u00020\t08J\f\u00109\u001a\b\u0012\u0004\u0012\u00020\f08J\f\u0010:\u001a\b\u0012\u0004\u0012\u00020\u000e08J\u0012\u0010;\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u001008J\f\u0010<\u001a\b\u0012\u0004\u0012\u00020\u001308J\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u001508J\u0006\u0010=\u001a\u00020>J\b\u0010?\u001a\u00020>H\u0002J\f\u0010@\u001a\b\u0012\u0004\u0012\u00020\t08J\u0006\u0010A\u001a\u00020>J\u000e\u0010B\u001a\u00020>2\u0006\u0010C\u001a\u00020\u0011J\b\u0010D\u001a\u00020>H\u0002J\u000e\u0010E\u001a\u00020>2\u0006\u0010 \u001a\u00020\u000eR\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000bX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u000bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u000bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u000bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\t0\u000bX\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0017\u001a\u00020\u00188BX\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u0019\u0010\u001aR\u001b\u0010\u001d\u001a\u00020\u00188BX\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u001c\u001a\u0004\b\u001e\u0010\u001aR\u000e\u0010 \u001a\u00020\u000eX.¢\u0006\u0002\n\u0000R\u001b\u0010!\u001a\u00020\"8BX\u0002¢\u0006\f\n\u0004\b%\u0010\u001c\u001a\u0004\b#\u0010$R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020(X.¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020+X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020+X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010-\u001a\u00020.8BX\u0002¢\u0006\f\n\u0004\b1\u0010\u001c\u001a\u0004\b/\u00100R\u001b\u00102\u001a\u0002038BX\u0002¢\u0006\f\n\u0004\b6\u0010\u001c\u001a\u0004\b4\u00105¨\u0006F"}, mo26107d2 = {"Lcom/memes/chat/ui/channel/members/ChannelMembersViewModel;", "Lcom/memes/commons/viewmodel/BaseViewModel;", "chatClient", "Lio/getstream/chat/android/client/ChatClient;", "membersPaginator", "Lcom/memes/commons/pagination/Paginator;", "(Lio/getstream/chat/android/client/ChatClient;Lcom/memes/commons/pagination/Paginator;)V", "_canAddMembers", "Lcom/memes/commons/util/SingleLiveEvent;", "", "_channel", "Landroidx/lifecycle/MutableLiveData;", "Lio/getstream/chat/android/client/models/Channel;", "_channelMemberRemoved", "", "_channelMembers", "Lcom/memes/commons/recycleradapter/AdapterUpdate;", "Lio/getstream/chat/android/client/models/Member;", "_channelMembersContentVisibility", "Lcom/memes/commons/contentlayout/ContentVisibilityAction;", "_currentUser", "Lio/getstream/chat/android/client/models/User;", "_loadingNextMembers", "_membersExceptionHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "get_membersExceptionHandler", "()Lkotlinx/coroutines/CoroutineExceptionHandler;", "_membersExceptionHandler$delegate", "Lkotlin/Lazy;", "_removeChannelMemberExceptionHandler", "get_removeChannelMemberExceptionHandler", "_removeChannelMemberExceptionHandler$delegate", "channelId", "channelInfoUseCase", "Lcom/memes/chat/util/usecases/ChannelInfoUseCase;", "getChannelInfoUseCase", "()Lcom/memes/chat/util/usecases/ChannelInfoUseCase;", "channelInfoUseCase$delegate", "currentUser", "membersJob", "Lkotlinx/coroutines/Job;", "membersPaginationEndReached", "membersPaginationLimit", "", "membersPaginationPage", "membersUseCase", "Lcom/memes/chat/util/usecases/ChannelMembersUseCase;", "getMembersUseCase", "()Lcom/memes/chat/util/usecases/ChannelMembersUseCase;", "membersUseCase$delegate", "removeChannelMemberUseCase", "Lcom/memes/chat/util/usecases/RemoveChannelMemberUseCase;", "getRemoveChannelMemberUseCase", "()Lcom/memes/chat/util/usecases/RemoveChannelMemberUseCase;", "removeChannelMemberUseCase$delegate", "canAddMembers", "Landroidx/lifecycle/LiveData;", "channel", "channelMemberRemoved", "channelMembers", "channelMembersContentVisibilityChanged", "fetchChannelMembers", "", "loadNextChannelMembers", "loadingNextMembers", "refreshChannelMembers", "removeChannelMember", "channelMember", "resetPagination", "setChannelId", "chat_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.chat.ui.channel.members.ChannelMembersViewModel */
/* compiled from: ChannelMembersViewModel.kt */
public final class ChannelMembersViewModel extends BaseViewModel {
    /* access modifiers changed from: private */
    public final SingleLiveEvent<Boolean> _canAddMembers;
    /* access modifiers changed from: private */
    public final MutableLiveData<Channel> _channel;
    /* access modifiers changed from: private */
    public final MutableLiveData<String> _channelMemberRemoved;
    /* access modifiers changed from: private */
    public final MutableLiveData<AdapterUpdate<Member>> _channelMembers;
    /* access modifiers changed from: private */
    public final MutableLiveData<ContentVisibilityAction> _channelMembersContentVisibility;
    private final MutableLiveData<User> _currentUser;
    /* access modifiers changed from: private */
    public final MutableLiveData<Boolean> _loadingNextMembers;
    private final Lazy _membersExceptionHandler$delegate;
    private final Lazy _removeChannelMemberExceptionHandler$delegate;
    /* access modifiers changed from: private */
    public String channelId;
    private final Lazy channelInfoUseCase$delegate;
    /* access modifiers changed from: private */
    public final ChatClient chatClient;
    /* access modifiers changed from: private */
    public final User currentUser;
    /* access modifiers changed from: private */
    public Job membersJob;
    /* access modifiers changed from: private */
    public boolean membersPaginationEndReached;
    /* access modifiers changed from: private */
    public int membersPaginationLimit;
    /* access modifiers changed from: private */
    public int membersPaginationPage;
    private final Paginator membersPaginator;
    private final Lazy membersUseCase$delegate;
    private final Lazy removeChannelMemberUseCase$delegate;

    /* access modifiers changed from: private */
    public final ChannelInfoUseCase getChannelInfoUseCase() {
        return (ChannelInfoUseCase) this.channelInfoUseCase$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final ChannelMembersUseCase getMembersUseCase() {
        return (ChannelMembersUseCase) this.membersUseCase$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final RemoveChannelMemberUseCase getRemoveChannelMemberUseCase() {
        return (RemoveChannelMemberUseCase) this.removeChannelMemberUseCase$delegate.getValue();
    }

    private final CoroutineExceptionHandler get_membersExceptionHandler() {
        return (CoroutineExceptionHandler) this._membersExceptionHandler$delegate.getValue();
    }

    private final CoroutineExceptionHandler get_removeChannelMemberExceptionHandler() {
        return (CoroutineExceptionHandler) this._removeChannelMemberExceptionHandler$delegate.getValue();
    }

    public static final /* synthetic */ String access$getChannelId$p(ChannelMembersViewModel channelMembersViewModel) {
        String str = channelMembersViewModel.channelId;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("channelId");
        }
        return str;
    }

    public static final /* synthetic */ Job access$getMembersJob$p(ChannelMembersViewModel channelMembersViewModel) {
        Job job = channelMembersViewModel.membersJob;
        if (job == null) {
            Intrinsics.throwUninitializedPropertyAccessException("membersJob");
        }
        return job;
    }

    public ChannelMembersViewModel(ChatClient chatClient2, Paginator paginator) {
        Intrinsics.checkNotNullParameter(chatClient2, "chatClient");
        Intrinsics.checkNotNullParameter(paginator, "membersPaginator");
        this.chatClient = chatClient2;
        this.membersPaginator = paginator;
        User currentUser2 = chatClient2.getCurrentUser();
        if (currentUser2 != null) {
            this.currentUser = currentUser2;
            this._channel = new MutableLiveData<>();
            MutableLiveData<User> mutableLiveData = new MutableLiveData<>();
            this._currentUser = mutableLiveData;
            this._canAddMembers = new SingleLiveEvent<>();
            this.membersPaginationLimit = 20;
            paginator.setOnLoadMoreListener(new Paginator.OnLoadMoreListener(this) {
                final /* synthetic */ ChannelMembersViewModel this$0;

                {
                    this.this$0 = r1;
                }

                public final void onLoadMore() {
                    this.this$0.loadNextChannelMembers();
                }
            });
            mutableLiveData.setValue(currentUser2);
            this.channelInfoUseCase$delegate = LazyKt.lazy(new ChannelMembersViewModel$channelInfoUseCase$2(this));
            this.membersUseCase$delegate = LazyKt.lazy(new ChannelMembersViewModel$membersUseCase$2(this));
            this._channelMembers = new MutableLiveData<>();
            this._channelMembersContentVisibility = new MutableLiveData<>();
            this._loadingNextMembers = new MutableLiveData<>();
            this._membersExceptionHandler$delegate = LazyKt.lazy(new ChannelMembersViewModel$_membersExceptionHandler$2(this));
            this.removeChannelMemberUseCase$delegate = LazyKt.lazy(new ChannelMembersViewModel$removeChannelMemberUseCase$2(this));
            this._channelMemberRemoved = new MutableLiveData<>();
            this._removeChannelMemberExceptionHandler$delegate = LazyKt.lazy(new ChannelMembersViewModel$_removeChannelMemberExceptionHandler$2(this));
            return;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public final LiveData<Channel> channel() {
        return this._channel;
    }

    public final LiveData<User> currentUser() {
        return this._currentUser;
    }

    public final LiveData<Boolean> canAddMembers() {
        return this._canAddMembers;
    }

    public final void setChannelId(String str) {
        Intrinsics.checkNotNullParameter(str, "channelId");
        this.channelId = str;
        resetPagination();
    }

    public final LiveData<AdapterUpdate<Member>> channelMembers() {
        return this._channelMembers;
    }

    public final LiveData<ContentVisibilityAction> channelMembersContentVisibilityChanged() {
        return this._channelMembersContentVisibility;
    }

    public final LiveData<Boolean> loadingNextMembers() {
        return this._loadingNextMembers;
    }

    public final void fetchChannelMembers() {
        if (this.membersJob != null) {
            Job job = this.membersJob;
            if (job == null) {
                Intrinsics.throwUninitializedPropertyAccessException("membersJob");
            }
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.membersJob = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), get_membersExceptionHandler(), (CoroutineStart) null, new ChannelMembersViewModel$fetchChannelMembers$2(this, (Continuation) null), 2, (Object) null);
    }

    public final void refreshChannelMembers() {
        resetPagination();
        fetchChannelMembers();
    }

    /* access modifiers changed from: private */
    public final void loadNextChannelMembers() {
        if (!this.membersPaginationEndReached) {
            this._loadingNextMembers.setValue(true);
            fetchChannelMembers();
        }
    }

    private final void resetPagination() {
        this.membersPaginator.resetState();
        this.membersPaginationPage = 0;
        this.membersPaginationEndReached = false;
    }

    public final LiveData<String> channelMemberRemoved() {
        return this._channelMemberRemoved;
    }

    public final void removeChannelMember(Member member) {
        Intrinsics.checkNotNullParameter(member, "channelMember");
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), get_removeChannelMemberExceptionHandler(), (CoroutineStart) null, new ChannelMembersViewModel$removeChannelMember$1(this, member, (Continuation) null), 2, (Object) null);
    }
}
