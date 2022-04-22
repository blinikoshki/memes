package com.memes.chat.p036ui.channel.info;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelKt;
import com.memes.chat.p036ui.channel.ChannelAccessValidator;
import com.memes.chat.p036ui.channel.options.ChannelMuteStatus;
import com.memes.chat.util.usecases.ChannelDeletionUseCase;
import com.memes.chat.util.usecases.ChannelInfoUseCase;
import com.memes.chat.util.usecases.ChannelMutingUseCase;
import com.memes.chat.util.usecases.CheckChannelMutedUseCase;
import com.memes.chat.util.usecases.LeaveChannelUseCase;
import com.memes.chat.util.usecases.RemoveChannelMemberUseCase;
import com.memes.commons.contentlayout.ContentVisibilityAction;
import com.memes.commons.viewmodel.BaseViewModel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import p015io.getstream.chat.android.client.ChatClient;
import p015io.getstream.chat.android.client.models.Channel;
import p015io.getstream.chat.android.client.models.Member;
import p015io.getstream.chat.android.client.models.User;
import p015io.getstream.chat.android.livedata.ChatDomain;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010I\u001a\u00020J2\u0006\u0010K\u001a\u00020\rJ\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\t0LJ\f\u0010M\u001a\b\u0012\u0004\u0012\u00020\u000b0LJ\f\u0010N\u001a\b\u0012\u0004\u0012\u00020\r0LJ\f\u0010O\u001a\b\u0012\u0004\u0012\u00020\r0LJ\f\u0010P\u001a\b\u0012\u0004\u0012\u00020\u00160LJ\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00180LJ\u0011\u0010Q\u001a\u00020\rH@ø\u0001\u0000¢\u0006\u0002\u0010RJ\u0006\u0010S\u001a\u00020JJ\u0006\u0010T\u001a\u00020JJ\u000e\u0010U\u001a\u00020J2\u0006\u0010(\u001a\u00020\u0016J\u0010\u0010V\u001a\u00020J2\u0006\u0010(\u001a\u00020\u0016H\u0002J\u0006\u0010W\u001a\u00020JJ\u0006\u0010X\u001a\u00020JJ\u000e\u0010Y\u001a\u00020J2\u0006\u0010Z\u001a\u00020[J\u0006\u0010\\\u001a\u00020]J\u0010\u0010^\u001a\u00020J2\u0006\u0010_\u001a\u00020\u0018H\u0002R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\bX\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\r0\bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\bX\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0019\u001a\u00020\u000f8BX\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0013\u001a\u0004\b\u001a\u0010\u0011R\u001b\u0010\u001c\u001a\u00020\u000f8BX\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u0013\u001a\u0004\b\u001d\u0010\u0011R\u001b\u0010\u001f\u001a\u00020\u000f8BX\u0002¢\u0006\f\n\u0004\b!\u0010\u0013\u001a\u0004\b \u0010\u0011R\u001b\u0010\"\u001a\u00020\u000f8BX\u0002¢\u0006\f\n\u0004\b$\u0010\u0013\u001a\u0004\b#\u0010\u0011R\u0010\u0010%\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0016X.¢\u0006\u0002\n\u0000R\u001b\u0010)\u001a\u00020*8BX\u0002¢\u0006\f\n\u0004\b-\u0010\u0013\u001a\u0004\b+\u0010,R\u000e\u0010.\u001a\u00020\u0018X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010/\u001a\u0002008BX\u0002¢\u0006\f\n\u0004\b3\u0010\u0013\u001a\u0004\b1\u00102R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u001b\u00104\u001a\u0002058BX\u0002¢\u0006\f\n\u0004\b8\u0010\u0013\u001a\u0004\b6\u00107R\u001b\u00109\u001a\u00020:8BX\u0002¢\u0006\f\n\u0004\b=\u0010\u0013\u001a\u0004\b;\u0010<R\u000e\u0010>\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010?\u001a\u00020@8BX\u0002¢\u0006\f\n\u0004\bC\u0010\u0013\u001a\u0004\bA\u0010BR\u001b\u0010D\u001a\u00020E8BX\u0002¢\u0006\f\n\u0004\bH\u0010\u0013\u001a\u0004\bF\u0010G\u0002\u0004\n\u0002\b\u0019¨\u0006`"}, mo26107d2 = {"Lcom/memes/chat/ui/channel/info/ChannelInfoViewModel;", "Lcom/memes/commons/viewmodel/BaseViewModel;", "chatClient", "Lio/getstream/chat/android/client/ChatClient;", "chatDomain", "Lio/getstream/chat/android/livedata/ChatDomain;", "(Lio/getstream/chat/android/client/ChatClient;Lio/getstream/chat/android/livedata/ChatDomain;)V", "_channel", "Landroidx/lifecycle/MutableLiveData;", "Lio/getstream/chat/android/client/models/Channel;", "_channelContentLVisibility", "Lcom/memes/commons/contentlayout/ContentVisibilityAction;", "_channelDeleted", "", "_channelExceptionHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "get_channelExceptionHandler", "()Lkotlinx/coroutines/CoroutineExceptionHandler;", "_channelExceptionHandler$delegate", "Lkotlin/Lazy;", "_channelLeft", "_channelMemberRemoved", "", "_channelMuteStatus", "Lcom/memes/chat/ui/channel/options/ChannelMuteStatus;", "_checkChannelMuteExceptionHandler", "get_checkChannelMuteExceptionHandler", "_checkChannelMuteExceptionHandler$delegate", "_deleteChannelExceptionHandler", "get_deleteChannelExceptionHandler", "_deleteChannelExceptionHandler$delegate", "_leaveChannelExceptionHandler", "get_leaveChannelExceptionHandler", "_leaveChannelExceptionHandler$delegate", "_removeChannelMemberExceptionHandler", "get_removeChannelMemberExceptionHandler", "_removeChannelMemberExceptionHandler$delegate", "channel", "channelAccessValidator", "Lcom/memes/chat/ui/channel/ChannelAccessValidator;", "channelId", "channelInfoUseCase", "Lcom/memes/chat/util/usecases/ChannelInfoUseCase;", "getChannelInfoUseCase", "()Lcom/memes/chat/util/usecases/ChannelInfoUseCase;", "channelInfoUseCase$delegate", "channelMuteStatus", "channelMutingUseCase", "Lcom/memes/chat/util/usecases/ChannelMutingUseCase;", "getChannelMutingUseCase", "()Lcom/memes/chat/util/usecases/ChannelMutingUseCase;", "channelMutingUseCase$delegate", "checkChannelMutedUseCase", "Lcom/memes/chat/util/usecases/CheckChannelMutedUseCase;", "getCheckChannelMutedUseCase", "()Lcom/memes/chat/util/usecases/CheckChannelMutedUseCase;", "checkChannelMutedUseCase$delegate", "deleteChannelUseCase", "Lcom/memes/chat/util/usecases/ChannelDeletionUseCase;", "getDeleteChannelUseCase", "()Lcom/memes/chat/util/usecases/ChannelDeletionUseCase;", "deleteChannelUseCase$delegate", "hasFetchedChannelAtLeastOnce", "leaveChannelUseCase", "Lcom/memes/chat/util/usecases/LeaveChannelUseCase;", "getLeaveChannelUseCase", "()Lcom/memes/chat/util/usecases/LeaveChannelUseCase;", "leaveChannelUseCase$delegate", "removeChannelMemberUseCase", "Lcom/memes/chat/util/usecases/RemoveChannelMemberUseCase;", "getRemoveChannelMemberUseCase", "()Lcom/memes/chat/util/usecases/RemoveChannelMemberUseCase;", "removeChannelMemberUseCase$delegate", "changeChannelMuteStatus", "", "isMuted", "Landroidx/lifecycle/LiveData;", "channelContentVisibilityChanged", "channelDeleted", "channelLeft", "channelMemberRemoved", "checkChannelAccess", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteChannel", "ensureChannelAccess", "fetchChannel", "fetchChannelMuteStatus", "leaveChannel", "refreshChannel", "removeChannelMember", "channelMember", "Lio/getstream/chat/android/client/models/Member;", "requireCurrentUser", "Lio/getstream/chat/android/client/models/User;", "updateChannelMuteStatus", "status", "chat_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.chat.ui.channel.info.ChannelInfoViewModel */
/* compiled from: ChannelInfoViewModel.kt */
public final class ChannelInfoViewModel extends BaseViewModel {
    /* access modifiers changed from: private */
    public final MutableLiveData<Channel> _channel = new MutableLiveData<>();
    /* access modifiers changed from: private */
    public final MutableLiveData<ContentVisibilityAction> _channelContentLVisibility = new MutableLiveData<>();
    /* access modifiers changed from: private */
    public final MutableLiveData<Boolean> _channelDeleted;
    private final Lazy _channelExceptionHandler$delegate = LazyKt.lazy(new ChannelInfoViewModel$_channelExceptionHandler$2(this));
    /* access modifiers changed from: private */
    public final MutableLiveData<Boolean> _channelLeft;
    /* access modifiers changed from: private */
    public final MutableLiveData<String> _channelMemberRemoved;
    private final MutableLiveData<ChannelMuteStatus> _channelMuteStatus;
    private final Lazy _checkChannelMuteExceptionHandler$delegate;
    private final Lazy _deleteChannelExceptionHandler$delegate;
    private final Lazy _leaveChannelExceptionHandler$delegate;
    private final Lazy _removeChannelMemberExceptionHandler$delegate;
    /* access modifiers changed from: private */
    public Channel channel;
    private final ChannelAccessValidator channelAccessValidator;
    /* access modifiers changed from: private */
    public String channelId;
    private final Lazy channelInfoUseCase$delegate = LazyKt.lazy(new ChannelInfoViewModel$channelInfoUseCase$2(this));
    private ChannelMuteStatus channelMuteStatus;
    private final Lazy channelMutingUseCase$delegate;
    /* access modifiers changed from: private */
    public final ChatClient chatClient;
    /* access modifiers changed from: private */
    public final ChatDomain chatDomain;
    private final Lazy checkChannelMutedUseCase$delegate;
    private final Lazy deleteChannelUseCase$delegate;
    /* access modifiers changed from: private */
    public boolean hasFetchedChannelAtLeastOnce;
    private final Lazy leaveChannelUseCase$delegate;
    private final Lazy removeChannelMemberUseCase$delegate;

    /* access modifiers changed from: private */
    public final ChannelInfoUseCase getChannelInfoUseCase() {
        return (ChannelInfoUseCase) this.channelInfoUseCase$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final ChannelMutingUseCase getChannelMutingUseCase() {
        return (ChannelMutingUseCase) this.channelMutingUseCase$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final CheckChannelMutedUseCase getCheckChannelMutedUseCase() {
        return (CheckChannelMutedUseCase) this.checkChannelMutedUseCase$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final ChannelDeletionUseCase getDeleteChannelUseCase() {
        return (ChannelDeletionUseCase) this.deleteChannelUseCase$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final LeaveChannelUseCase getLeaveChannelUseCase() {
        return (LeaveChannelUseCase) this.leaveChannelUseCase$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final RemoveChannelMemberUseCase getRemoveChannelMemberUseCase() {
        return (RemoveChannelMemberUseCase) this.removeChannelMemberUseCase$delegate.getValue();
    }

    private final CoroutineExceptionHandler get_channelExceptionHandler() {
        return (CoroutineExceptionHandler) this._channelExceptionHandler$delegate.getValue();
    }

    private final CoroutineExceptionHandler get_checkChannelMuteExceptionHandler() {
        return (CoroutineExceptionHandler) this._checkChannelMuteExceptionHandler$delegate.getValue();
    }

    private final CoroutineExceptionHandler get_deleteChannelExceptionHandler() {
        return (CoroutineExceptionHandler) this._deleteChannelExceptionHandler$delegate.getValue();
    }

    private final CoroutineExceptionHandler get_leaveChannelExceptionHandler() {
        return (CoroutineExceptionHandler) this._leaveChannelExceptionHandler$delegate.getValue();
    }

    private final CoroutineExceptionHandler get_removeChannelMemberExceptionHandler() {
        return (CoroutineExceptionHandler) this._removeChannelMemberExceptionHandler$delegate.getValue();
    }

    public static final /* synthetic */ String access$getChannelId$p(ChannelInfoViewModel channelInfoViewModel) {
        String str = channelInfoViewModel.channelId;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("channelId");
        }
        return str;
    }

    public ChannelInfoViewModel(ChatClient chatClient2, ChatDomain chatDomain2) {
        Intrinsics.checkNotNullParameter(chatClient2, "chatClient");
        Intrinsics.checkNotNullParameter(chatDomain2, "chatDomain");
        this.chatClient = chatClient2;
        this.chatDomain = chatDomain2;
        this.channelAccessValidator = new ChannelAccessValidator(ViewModelKt.getViewModelScope(this), chatClient2);
        this.channelMuteStatus = ChannelMuteStatus.UNKNOWN;
        this.checkChannelMutedUseCase$delegate = LazyKt.lazy(new ChannelInfoViewModel$checkChannelMutedUseCase$2(this));
        this._channelMuteStatus = new MutableLiveData<>();
        this._checkChannelMuteExceptionHandler$delegate = LazyKt.lazy(new ChannelInfoViewModel$_checkChannelMuteExceptionHandler$2(this));
        this.channelMutingUseCase$delegate = LazyKt.lazy(new ChannelInfoViewModel$channelMutingUseCase$2(this));
        this.removeChannelMemberUseCase$delegate = LazyKt.lazy(new ChannelInfoViewModel$removeChannelMemberUseCase$2(this));
        this._channelMemberRemoved = new MutableLiveData<>();
        this._removeChannelMemberExceptionHandler$delegate = LazyKt.lazy(new ChannelInfoViewModel$_removeChannelMemberExceptionHandler$2(this));
        this.leaveChannelUseCase$delegate = LazyKt.lazy(new ChannelInfoViewModel$leaveChannelUseCase$2(this));
        this._channelLeft = new MutableLiveData<>();
        this._leaveChannelExceptionHandler$delegate = LazyKt.lazy(new ChannelInfoViewModel$_leaveChannelExceptionHandler$2(this));
        this.deleteChannelUseCase$delegate = LazyKt.lazy(new ChannelInfoViewModel$deleteChannelUseCase$2(this));
        this._channelDeleted = new MutableLiveData<>();
        this._deleteChannelExceptionHandler$delegate = LazyKt.lazy(new ChannelInfoViewModel$_deleteChannelExceptionHandler$2(this));
    }

    public final LiveData<Channel> channel() {
        return this._channel;
    }

    public final LiveData<ContentVisibilityAction> channelContentVisibilityChanged() {
        return this._channelContentLVisibility;
    }

    public final LiveData<ChannelMuteStatus> channelMuteStatus() {
        return this._channelMuteStatus;
    }

    public final User requireCurrentUser() {
        User currentUser = this.chatClient.getCurrentUser();
        if (currentUser != null) {
            return currentUser;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public final void fetchChannel(String str) {
        Intrinsics.checkNotNullParameter(str, "channelId");
        this.channelId = str;
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), get_channelExceptionHandler(), (CoroutineStart) null, new ChannelInfoViewModel$fetchChannel$1(this, str, (Continuation) null), 2, (Object) null);
    }

    public final void refreshChannel() {
        String str = this.channelId;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("channelId");
        }
        fetchChannel(str);
    }

    public final void ensureChannelAccess() {
        if (this.hasFetchedChannelAtLeastOnce) {
            Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new ChannelInfoViewModel$ensureChannelAccess$1(this, (Continuation) null), 3, (Object) null);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0056  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x007c  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object checkChannelAccess(kotlin.coroutines.Continuation<? super java.lang.Boolean> r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof com.memes.chat.p036ui.channel.info.ChannelInfoViewModel$checkChannelAccess$1
            if (r0 == 0) goto L_0x0014
            r0 = r6
            com.memes.chat.ui.channel.info.ChannelInfoViewModel$checkChannelAccess$1 r0 = (com.memes.chat.p036ui.channel.info.ChannelInfoViewModel$checkChannelAccess$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L_0x0019
        L_0x0014:
            com.memes.chat.ui.channel.info.ChannelInfoViewModel$checkChannelAccess$1 r0 = new com.memes.chat.ui.channel.info.ChannelInfoViewModel$checkChannelAccess$1
            r0.<init>(r5, r6)
        L_0x0019:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0036
            if (r2 != r3) goto L_0x002e
            java.lang.Object r0 = r0.L$0
            com.memes.chat.ui.channel.info.ChannelInfoViewModel r0 = (com.memes.chat.p036ui.channel.info.ChannelInfoViewModel) r0
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0050
        L_0x002e:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L_0x0036:
            kotlin.ResultKt.throwOnFailure(r6)
            com.memes.chat.ui.channel.ChannelAccessValidator r6 = r5.channelAccessValidator
            java.lang.String r2 = r5.channelId
            if (r2 != 0) goto L_0x0044
            java.lang.String r4 = "channelId"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r4)
        L_0x0044:
            r0.L$0 = r5
            r0.label = r3
            java.lang.Object r6 = r6.checkChannelAccess(r2, r0)
            if (r6 != r1) goto L_0x004f
            return r1
        L_0x004f:
            r0 = r5
        L_0x0050:
            com.memes.chat.util.usecases.channelaccess.ChannelAccessResult r6 = (com.memes.chat.util.usecases.channelaccess.ChannelAccessResult) r6
            boolean r1 = r6 instanceof com.memes.chat.util.usecases.channelaccess.ChannelAccessResult.Success
            if (r1 != 0) goto L_0x007c
            java.lang.String r1 = "null cannot be cast to non-null type com.memes.chat.util.usecases.channelaccess.ChannelAccessResult.Failure"
            java.util.Objects.requireNonNull(r6, r1)
            com.memes.chat.util.usecases.channelaccess.ChannelAccessResult$Failure r6 = (com.memes.chat.util.usecases.channelaccess.ChannelAccessResult.Failure) r6
            boolean r1 = r6.getCanRetry()
            if (r1 == 0) goto L_0x006d
            androidx.lifecycle.MutableLiveData<com.memes.commons.contentlayout.ContentVisibilityAction> r1 = r0._channelContentLVisibility
            java.lang.String r6 = r6.getError()
            r0.showError(r1, r6)
            goto L_0x0076
        L_0x006d:
            androidx.lifecycle.MutableLiveData<com.memes.commons.contentlayout.ContentVisibilityAction> r1 = r0._channelContentLVisibility
            java.lang.String r6 = r6.getError()
            r0.showContentNotAvailable(r1, r6)
        L_0x0076:
            r6 = 0
            java.lang.Boolean r6 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r6)
            return r6
        L_0x007c:
            java.lang.Boolean r6 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r3)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.memes.chat.p036ui.channel.info.ChannelInfoViewModel.checkChannelAccess(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public final void fetchChannelMuteStatus(String str) {
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), get_checkChannelMuteExceptionHandler(), (CoroutineStart) null, new ChannelInfoViewModel$fetchChannelMuteStatus$1(this, str, (Continuation) null), 2, (Object) null);
    }

    public final void changeChannelMuteStatus(boolean z) {
        ChannelMuteStatus channelMuteStatus2;
        if (z) {
            channelMuteStatus2 = ChannelMuteStatus.MUTED;
        } else {
            channelMuteStatus2 = ChannelMuteStatus.UNMUTED;
        }
        if (this.channelMuteStatus != channelMuteStatus2) {
            Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), new C4105x3f55e5a(CoroutineExceptionHandler.Key, this, z), (CoroutineStart) null, new ChannelInfoViewModel$changeChannelMuteStatus$2(this, z, channelMuteStatus2, (Continuation) null), 2, (Object) null);
        }
    }

    /* access modifiers changed from: private */
    public final void updateChannelMuteStatus(ChannelMuteStatus channelMuteStatus2) {
        this.channelMuteStatus = channelMuteStatus2;
        this._channelMuteStatus.setValue(channelMuteStatus2);
    }

    public final LiveData<String> channelMemberRemoved() {
        return this._channelMemberRemoved;
    }

    public final void removeChannelMember(Member member) {
        Intrinsics.checkNotNullParameter(member, "channelMember");
        Channel channel2 = this.channel;
        if (channel2 != null) {
            Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), get_removeChannelMemberExceptionHandler(), (CoroutineStart) null, new ChannelInfoViewModel$removeChannelMember$1(this, channel2, member, (Continuation) null), 2, (Object) null);
        }
    }

    public final LiveData<Boolean> channelLeft() {
        return this._channelLeft;
    }

    public final void leaveChannel() {
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), get_leaveChannelExceptionHandler(), (CoroutineStart) null, new ChannelInfoViewModel$leaveChannel$1(this, (Continuation) null), 2, (Object) null);
    }

    public final LiveData<Boolean> channelDeleted() {
        return this._channelDeleted;
    }

    public final void deleteChannel() {
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), get_deleteChannelExceptionHandler(), (CoroutineStart) null, new ChannelInfoViewModel$deleteChannel$1(this, (Continuation) null), 2, (Object) null);
    }
}
