package com.memes.chat.p036ui.channel.members.options;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelKt;
import com.memes.chat.p035db.ChatDatabase;
import com.memes.commons.viewmodel.BaseViewModel;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import p015io.getstream.chat.android.client.ChatClient;
import p015io.getstream.chat.android.client.models.Channel;
import p015io.getstream.chat.android.client.models.User;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u000f\u001a\u00020\u0010J\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\t0\u0012J\u000e\u0010\u0013\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0012J\u0006\u0010\u0014\u001a\u00020\u0010J\u0006\u0010\u0015\u001a\u00020\u0010J\u0016\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u0019J\u0006\u0010\u001a\u001a\u00020\u0010J\u0006\u0010\u001b\u001a\u00020\u0010J\u0018\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0010\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\rH\u0002R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\tX.¢\u0006\u0002\n\u0000¨\u0006\u001e"}, mo26107d2 = {"Lcom/memes/chat/ui/channel/members/options/UserActionsViewModel;", "Lcom/memes/commons/viewmodel/BaseViewModel;", "chatClient", "Lio/getstream/chat/android/client/ChatClient;", "chatDatabase", "Lcom/memes/chat/db/ChatDatabase;", "(Lio/getstream/chat/android/client/ChatClient;Lcom/memes/chat/db/ChatDatabase;)V", "_messageUserActionState", "Landroidx/lifecycle/MutableLiveData;", "Lcom/memes/chat/ui/channel/members/options/UserActionState;", "_messageUserOnline", "", "currentUser", "Lio/getstream/chat/android/client/models/User;", "userActionState", "banUser", "", "messageUserActionState", "Landroidx/lifecycle/LiveData;", "messageUserOnline", "muteUser", "reportUser", "setUserAndChannel", "user", "channel", "Lio/getstream/chat/android/client/models/Channel;", "unbanUser", "unmuteUser", "updateUserActionState", "watchUserPresence", "chat_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.chat.ui.channel.members.options.UserActionsViewModel */
/* compiled from: UserActionsViewModel.kt */
public final class UserActionsViewModel extends BaseViewModel {
    /* access modifiers changed from: private */
    public final MutableLiveData<UserActionState> _messageUserActionState = new MutableLiveData<>();
    /* access modifiers changed from: private */
    public final MutableLiveData<Boolean> _messageUserOnline = new MutableLiveData<>();
    /* access modifiers changed from: private */
    public final ChatClient chatClient;
    /* access modifiers changed from: private */
    public final ChatDatabase chatDatabase;
    /* access modifiers changed from: private */
    public final User currentUser;
    /* access modifiers changed from: private */
    public UserActionState userActionState;

    public static final /* synthetic */ UserActionState access$getUserActionState$p(UserActionsViewModel userActionsViewModel) {
        UserActionState userActionState2 = userActionsViewModel.userActionState;
        if (userActionState2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("userActionState");
        }
        return userActionState2;
    }

    public UserActionsViewModel(ChatClient chatClient2, ChatDatabase chatDatabase2) {
        Intrinsics.checkNotNullParameter(chatClient2, "chatClient");
        Intrinsics.checkNotNullParameter(chatDatabase2, "chatDatabase");
        this.chatClient = chatClient2;
        this.chatDatabase = chatDatabase2;
        User currentUser2 = chatClient2.getCurrentUser();
        if (currentUser2 != null) {
            this.currentUser = currentUser2;
            return;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public final LiveData<Boolean> messageUserOnline() {
        return this._messageUserOnline;
    }

    public final LiveData<UserActionState> messageUserActionState() {
        return this._messageUserActionState;
    }

    public final void setUserAndChannel(User user, Channel channel) {
        Intrinsics.checkNotNullParameter(user, "user");
        Intrinsics.checkNotNullParameter(channel, "channel");
        updateUserActionState(user, channel);
        watchUserPresence(user);
    }

    private final void updateUserActionState(User user, Channel channel) {
        if (this.userActionState != null) {
            String id = user.getId();
            UserActionState userActionState2 = this.userActionState;
            if (userActionState2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("userActionState");
            }
            if (Intrinsics.areEqual((Object) id, (Object) userActionState2.getUser().getId())) {
                String cid = channel.getCid();
                UserActionState userActionState3 = this.userActionState;
                if (userActionState3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("userActionState");
                }
                if (Intrinsics.areEqual((Object) cid, (Object) userActionState3.getChannel().getCid())) {
                    MutableLiveData<UserActionState> mutableLiveData = this._messageUserActionState;
                    UserActionState userActionState4 = this.userActionState;
                    if (userActionState4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("userActionState");
                    }
                    mutableLiveData.setValue(userActionState4);
                    return;
                }
            }
        }
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new UserActionsViewModel$updateUserActionState$2(this, user, channel, (Continuation) null), 3, (Object) null);
    }

    private final void watchUserPresence(User user) {
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new UserActionsViewModel$watchUserPresence$1(this, user, (Continuation) null), 3, (Object) null);
    }

    public final void muteUser() {
        UserActionState userActionState2 = this.userActionState;
        if (userActionState2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("userActionState");
        }
        if (userActionState2.getCanMute()) {
            Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new UserActionsViewModel$muteUser$1(this, userActionState2, (Continuation) null), 3, (Object) null);
        }
    }

    public final void unmuteUser() {
        UserActionState userActionState2 = this.userActionState;
        if (userActionState2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("userActionState");
        }
        if (userActionState2.getCanMute()) {
            Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new UserActionsViewModel$unmuteUser$1(this, userActionState2, (Continuation) null), 3, (Object) null);
        }
    }

    public final void banUser() {
        toast("Unable to ban user.");
    }

    public final void unbanUser() {
        toast("Unable to unban user.");
    }

    public final void reportUser() {
        UserActionState userActionState2 = this.userActionState;
        if (userActionState2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("userActionState");
        }
        if (userActionState2.getCanReport()) {
            Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new UserActionsViewModel$reportUser$1(this, userActionState2, (Continuation) null), 3, (Object) null);
        }
    }
}
