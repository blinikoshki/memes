package com.memes.chat.p036ui.channel.create;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelKt;
import com.memes.chat.C4059R;
import com.memes.chat.p036ui.channel.create.stages.CreateChannelStage;
import com.memes.chat.p036ui.startup.ChatCredentialsSharedPref;
import com.memes.chat.util.usecases.CreateChannelUseCase;
import com.memes.chat.util.usecases.FileUploadUseCase;
import com.memes.commons.util.SingleLiveEvent;
import com.memes.commons.viewmodel.BaseViewModel;
import com.memes.network.chat.api.ChatDataSource;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import p015io.getstream.chat.android.client.ChatClient;
import p015io.getstream.chat.android.client.models.Channel;
import p015io.getstream.chat.android.client.models.ModelFields;
import p015io.getstream.chat.android.client.models.User;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u000eH\u0002J\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u000b0#J\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u000e0#J\u0010\u0010%\u001a\u00020 2\b\u0010&\u001a\u0004\u0018\u00010\u0010J\u0018\u0010'\u001a\u00020 2\u0010\u0010(\u001a\f\u0012\b\u0012\u00060\u0013j\u0002`\u00140)J\u0010\u0010*\u001a\u00020 2\b\u0010+\u001a\u0004\u0018\u00010\u0010J\b\u0010,\u001a\u00020 H\u0002J\u0006\u0010-\u001a\u00020.J\u0006\u0010/\u001a\u000200J\u0006\u00101\u001a\u000200J\u0006\u00102\u001a\u00020 R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u0011\u001a\f\u0012\b\u0012\u00060\u0013j\u0002`\u00140\u0012X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X.¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0004¢\u0006\u0002\n\u0000¨\u00063"}, mo26107d2 = {"Lcom/memes/chat/ui/channel/create/CreateChannelViewModel;", "Lcom/memes/commons/viewmodel/BaseViewModel;", "chatClient", "Lio/getstream/chat/android/client/ChatClient;", "chatDataSource", "Lcom/memes/network/chat/api/ChatDataSource;", "credentialsSharedPref", "Lcom/memes/chat/ui/startup/ChatCredentialsSharedPref;", "(Lio/getstream/chat/android/client/ChatClient;Lcom/memes/network/chat/api/ChatDataSource;Lcom/memes/chat/ui/startup/ChatCredentialsSharedPref;)V", "_channelCreated", "Lcom/memes/commons/util/SingleLiveEvent;", "Lio/getstream/chat/android/client/models/Channel;", "_channelCreationStage", "Landroidx/lifecycle/MutableLiveData;", "Lcom/memes/chat/ui/channel/create/stages/CreateChannelStage;", "channelImageInput", "", "channelMembers", "", "Lio/getstream/chat/android/client/models/User;", "Lcom/memes/chat/ui/channel/create/stages/memberselection/ChannelMember;", "channelNameInput", "createChannelExceptionHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "createChannelJob", "Lkotlinx/coroutines/Job;", "createChannelUseCase", "Lcom/memes/chat/util/usecases/CreateChannelUseCase;", "currentStage", "fileUploadUseCase", "Lcom/memes/chat/util/usecases/FileUploadUseCase;", "changeStage", "", "stage", "channelCreated", "Landroidx/lifecycle/LiveData;", "channelCreationStage", "channelImageInputChanged", "channelImage", "channelMembersChanged", "members", "", "channelNameInputChanged", "channelName", "createChannel", "getSelectedMemberCount", "", "handleOnBackPressed", "", "hasChannelImageInput", "proceedToNextStage", "chat_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.chat.ui.channel.create.CreateChannelViewModel */
/* compiled from: CreateChannelViewModel.kt */
public final class CreateChannelViewModel extends BaseViewModel {
    /* access modifiers changed from: private */
    public final SingleLiveEvent<Channel> _channelCreated;
    private final MutableLiveData<CreateChannelStage> _channelCreationStage = new MutableLiveData<>();
    /* access modifiers changed from: private */
    public String channelImageInput;
    /* access modifiers changed from: private */
    public final List<User> channelMembers;
    /* access modifiers changed from: private */
    public String channelNameInput;
    private final CoroutineExceptionHandler createChannelExceptionHandler;
    /* access modifiers changed from: private */
    public Job createChannelJob;
    /* access modifiers changed from: private */
    public final CreateChannelUseCase createChannelUseCase;
    private CreateChannelStage currentStage = CreateChannelStage.CHOOSE_MEMBERS;
    /* access modifiers changed from: private */
    public final FileUploadUseCase fileUploadUseCase;

    @Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 4, 2})
    /* renamed from: com.memes.chat.ui.channel.create.CreateChannelViewModel$WhenMappings */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[CreateChannelStage.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[CreateChannelStage.CHOOSE_MEMBERS.ordinal()] = 1;
            iArr[CreateChannelStage.CHANNEL_INFO_INPUT.ordinal()] = 2;
            int[] iArr2 = new int[CreateChannelStage.values().length];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[CreateChannelStage.CHANNEL_INFO_INPUT.ordinal()] = 1;
            iArr2[CreateChannelStage.CHOOSE_MEMBERS.ordinal()] = 2;
        }
    }

    public static final /* synthetic */ Job access$getCreateChannelJob$p(CreateChannelViewModel createChannelViewModel) {
        Job job = createChannelViewModel.createChannelJob;
        if (job == null) {
            Intrinsics.throwUninitializedPropertyAccessException("createChannelJob");
        }
        return job;
    }

    public CreateChannelViewModel(ChatClient chatClient, ChatDataSource chatDataSource, ChatCredentialsSharedPref chatCredentialsSharedPref) {
        Intrinsics.checkNotNullParameter(chatClient, "chatClient");
        Intrinsics.checkNotNullParameter(chatDataSource, "chatDataSource");
        Intrinsics.checkNotNullParameter(chatCredentialsSharedPref, "credentialsSharedPref");
        this.createChannelUseCase = new CreateChannelUseCase(chatClient);
        this.fileUploadUseCase = new FileUploadUseCase(chatDataSource, chatCredentialsSharedPref);
        this._channelCreated = new SingleLiveEvent<>();
        this.createChannelExceptionHandler = new C4082x2e90518b(CoroutineExceptionHandler.Key, this);
        this.channelMembers = new ArrayList();
        changeStage(this.currentStage);
    }

    public final LiveData<CreateChannelStage> channelCreationStage() {
        return this._channelCreationStage;
    }

    public final LiveData<Channel> channelCreated() {
        return this._channelCreated;
    }

    public final void channelNameInputChanged(String str) {
        this.channelNameInput = str;
    }

    public final void channelImageInputChanged(String str) {
        this.channelImageInput = str;
    }

    public final boolean hasChannelImageInput() {
        CharSequence charSequence = this.channelImageInput;
        return !(charSequence == null || StringsKt.isBlank(charSequence));
    }

    public final void channelMembersChanged(List<User> list) {
        Intrinsics.checkNotNullParameter(list, ModelFields.MEMBERS);
        this.channelMembers.clear();
        this.channelMembers.addAll(list);
    }

    public final int getSelectedMemberCount() {
        return this.channelMembers.size();
    }

    public final void proceedToNextStage() {
        int size = this.channelMembers.size();
        int i = WhenMappings.$EnumSwitchMapping$0[this.currentStage.ordinal()];
        boolean z = true;
        if (i != 1) {
            if (i == 2) {
                if (size <= 1) {
                    changeStage(CreateChannelStage.CHOOSE_MEMBERS);
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
                    createChannel();
                }
            }
        } else if (size == 0) {
            toast("Please add at least one member to create a chat");
        } else if (size != 1) {
            changeStage(CreateChannelStage.CHANNEL_INFO_INPUT);
        } else {
            createChannel();
        }
    }

    private final void changeStage(CreateChannelStage createChannelStage) {
        this.currentStage = createChannelStage;
        this._channelCreationStage.setValue(createChannelStage);
    }

    public final boolean handleOnBackPressed() {
        CreateChannelStage createChannelStage;
        int i = WhenMappings.$EnumSwitchMapping$1[this.currentStage.ordinal()];
        if (i == 1) {
            createChannelStage = CreateChannelStage.CHOOSE_MEMBERS;
        } else if (i == 2) {
            createChannelStage = null;
        } else {
            throw new NoWhenBranchMatchedException();
        }
        if (createChannelStage == null) {
            return false;
        }
        changeStage(createChannelStage);
        return true;
    }

    private final void createChannel() {
        if (this.createChannelJob != null) {
            Job job = this.createChannelJob;
            if (job == null) {
                Intrinsics.throwUninitializedPropertyAccessException("createChannelJob");
            }
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.createChannelJob = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), this.createChannelExceptionHandler, (CoroutineStart) null, new CreateChannelViewModel$createChannel$2(this, (Continuation) null), 2, (Object) null);
    }
}
