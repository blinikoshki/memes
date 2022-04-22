package com.memes.chat.p036ui.channel.settings;

import android.webkit.URLUtil;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelKt;
import com.memes.chat.C4059R;
import com.memes.chat.p036ui.startup.ChatCredentialsSharedPref;
import com.memes.chat.util.Constants;
import com.memes.chat.util.extensions.ChannelExtKt;
import com.memes.chat.util.usecases.FileUploadUseCase;
import com.memes.chat.util.usecases.UpdateChannelUseCase;
import com.memes.commons.util.SingleLiveEvent;
import com.memes.commons.viewmodel.BaseViewModel;
import com.memes.network.chat.api.ChatDataSource;
import java.io.File;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import p015io.getstream.chat.android.client.ChatClient;
import p015io.getstream.chat.android.client.models.Channel;
import p015io.getstream.chat.android.client.models.User;
import p015io.getstream.chat.android.livedata.ChatDomain;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\b\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0011J\u0010\u0010\u001e\u001a\u00020\u001c2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0011J\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u000b0!J\u0011\u0010\"\u001a\u00020\u0011H@ø\u0001\u0000¢\u0006\u0002\u0010#J\b\u0010$\u001a\u0004\u0018\u00010\u0011J\u0006\u0010%\u001a\u00020\u000eJ\u0006\u0010&\u001a\u00020\u000eJ\b\u0010'\u001a\u00020\u001cH\u0002J\u000e\u0010(\u001a\u00020\u001c2\u0006\u0010\u000f\u001a\u00020\u000bJ\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u000e0!J\u0006\u0010*\u001a\u00020\u001cR\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000bX.¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006+"}, mo26107d2 = {"Lcom/memes/chat/ui/channel/settings/ChannelSettingsViewModel;", "Lcom/memes/commons/viewmodel/BaseViewModel;", "chatClient", "Lio/getstream/chat/android/client/ChatClient;", "chatDataSource", "Lcom/memes/network/chat/api/ChatDataSource;", "credentialsSharedPref", "Lcom/memes/chat/ui/startup/ChatCredentialsSharedPref;", "(Lio/getstream/chat/android/client/ChatClient;Lcom/memes/network/chat/api/ChatDataSource;Lcom/memes/chat/ui/startup/ChatCredentialsSharedPref;)V", "_channelUpdated", "Landroidx/lifecycle/MutableLiveData;", "Lio/getstream/chat/android/client/models/Channel;", "_unsavedChangesAvailable", "Lcom/memes/commons/util/SingleLiveEvent;", "", "channel", "channelImageInput", "", "channelNameInput", "currentUser", "Lio/getstream/chat/android/client/models/User;", "fileUploadUseCase", "Lcom/memes/chat/util/usecases/FileUploadUseCase;", "updateChannelExceptionHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "updateChannelUseCase", "Lcom/memes/chat/util/usecases/UpdateChannelUseCase;", "channelImageChanged", "", "image", "channelNameChanged", "name", "channelUpdated", "Landroidx/lifecycle/LiveData;", "fetchChannelImageUrl", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getLatestChannelImageInput", "hasChannelImageInput", "hasUnsavedChanges", "refreshUnsavedChangesAvailability", "setChannel", "unsavedChangesAvailable", "updateChannel", "chat_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.chat.ui.channel.settings.ChannelSettingsViewModel */
/* compiled from: ChannelSettingsViewModel.kt */
public final class ChannelSettingsViewModel extends BaseViewModel {
    /* access modifiers changed from: private */
    public final MutableLiveData<Channel> _channelUpdated = new MutableLiveData<>();
    private final SingleLiveEvent<Boolean> _unsavedChangesAvailable = new SingleLiveEvent<>();
    /* access modifiers changed from: private */
    public Channel channel;
    private String channelImageInput;
    private String channelNameInput;
    private final User currentUser = ChatDomain.Companion.instance().getCurrentUser();
    private final FileUploadUseCase fileUploadUseCase;
    private final CoroutineExceptionHandler updateChannelExceptionHandler;
    /* access modifiers changed from: private */
    public final UpdateChannelUseCase updateChannelUseCase;

    public static final /* synthetic */ Channel access$getChannel$p(ChannelSettingsViewModel channelSettingsViewModel) {
        Channel channel2 = channelSettingsViewModel.channel;
        if (channel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("channel");
        }
        return channel2;
    }

    public ChannelSettingsViewModel(ChatClient chatClient, ChatDataSource chatDataSource, ChatCredentialsSharedPref chatCredentialsSharedPref) {
        Intrinsics.checkNotNullParameter(chatClient, "chatClient");
        Intrinsics.checkNotNullParameter(chatDataSource, "chatDataSource");
        Intrinsics.checkNotNullParameter(chatCredentialsSharedPref, "credentialsSharedPref");
        this.updateChannelUseCase = new UpdateChannelUseCase(chatClient);
        this.fileUploadUseCase = new FileUploadUseCase(chatDataSource, chatCredentialsSharedPref);
        this.updateChannelExceptionHandler = new C4137xc00190cc(CoroutineExceptionHandler.Key, this);
    }

    public final LiveData<Boolean> unsavedChangesAvailable() {
        return this._unsavedChangesAvailable;
    }

    public final void setChannel(Channel channel2) {
        Intrinsics.checkNotNullParameter(channel2, "channel");
        this.channel = channel2;
        this.channelNameInput = ChannelExtKt.channelName(channel2);
        this.channelImageInput = ChannelExtKt.channelImage(channel2);
        refreshUnsavedChangesAvailability();
    }

    public final void channelNameChanged(String str) {
        String str2;
        if (str != null) {
            Objects.requireNonNull(str, "null cannot be cast to non-null type kotlin.CharSequence");
            str2 = StringsKt.trim((CharSequence) str).toString();
        } else {
            str2 = null;
        }
        this.channelNameInput = str2;
        refreshUnsavedChangesAvailability();
    }

    public final void channelImageChanged(String str) {
        this.channelImageInput = str;
        refreshUnsavedChangesAvailability();
    }

    public final boolean hasChannelImageInput() {
        CharSequence charSequence = this.channelImageInput;
        return !(charSequence == null || StringsKt.isBlank(charSequence)) && (Intrinsics.areEqual((Object) this.channelImageInput, (Object) Constants.DEFAULT_GROUP_CHANNEL_AVATAR) ^ true);
    }

    public final String getLatestChannelImageInput() {
        String str = this.channelImageInput;
        CharSequence charSequence = str;
        if ((charSequence == null || StringsKt.isBlank(charSequence)) || Intrinsics.areEqual((Object) str, (Object) Constants.DEFAULT_GROUP_CHANNEL_AVATAR)) {
            return null;
        }
        return str;
    }

    public final boolean hasUnsavedChanges() {
        return Intrinsics.areEqual((Object) this._unsavedChangesAvailable.getValue(), (Object) true);
    }

    private final void refreshUnsavedChangesAvailability() {
        if (this.channel != null) {
            String id = this.currentUser.getId();
            Channel channel2 = this.channel;
            if (channel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("channel");
            }
            boolean areEqual = Intrinsics.areEqual((Object) id, (Object) ChannelExtKt.owner(channel2).getId());
            boolean z = false;
            if (!areEqual) {
                this._unsavedChangesAvailable.setValue(false);
            }
            String str = this.channelNameInput;
            Channel channel3 = this.channel;
            if (channel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("channel");
            }
            boolean z2 = !Intrinsics.areEqual((Object) str, (Object) ChannelExtKt.channelName(channel3));
            String str2 = this.channelImageInput;
            Channel channel4 = this.channel;
            if (channel4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("channel");
            }
            boolean z3 = !Intrinsics.areEqual((Object) str2, (Object) ChannelExtKt.channelImage(channel4));
            SingleLiveEvent<Boolean> singleLiveEvent = this._unsavedChangesAvailable;
            if (z2 || z3) {
                z = true;
            }
            singleLiveEvent.setValue(Boolean.valueOf(z));
        }
    }

    public final LiveData<Channel> channelUpdated() {
        return this._channelUpdated;
    }

    public final void updateChannel() {
        String id = this.currentUser.getId();
        Channel channel2 = this.channel;
        if (channel2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("channel");
        }
        boolean areEqual = Intrinsics.areEqual((Object) id, (Object) ChannelExtKt.owner(channel2).getId());
        boolean z = true;
        if (!areEqual) {
            toast("Unable to update channel: you're not channel owner");
            return;
        }
        Channel channel3 = this.channel;
        if (channel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("channel");
        }
        if (ChannelExtKt.isDirectMessaging(channel3)) {
            toast("Unable to update channel: channel is not a group");
            return;
        }
        String str = this.channelNameInput;
        CharSequence charSequence = str;
        if (charSequence != null && !StringsKt.isBlank(charSequence)) {
            z = false;
        }
        if (z) {
            toast(C4059R.string.chat_error_empty_channel_name_input);
        } else if (str.length() > 25) {
            toast(C4059R.string.chat_error_channel_name_too_long);
        } else {
            Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), this.updateChannelExceptionHandler, (CoroutineStart) null, new ChannelSettingsViewModel$updateChannel$1(this, str, (Continuation) null), 2, (Object) null);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object fetchChannelImageUrl(Continuation<? super String> continuation) {
        String str = this.channelImageInput;
        CharSequence charSequence = str;
        if (charSequence == null || StringsKt.isBlank(charSequence)) {
            return "";
        }
        if (URLUtil.isNetworkUrl(str)) {
            return str;
        }
        return this.fileUploadUseCase.execute(new FileUploadUseCase.Request(new File(str)), continuation);
    }
}
