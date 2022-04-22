package com.memes.chat.p036ui.startup;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelKt;
import com.memes.chat.p035db.ChatDatabase;
import com.memes.chat.p036ui.startup.ChatStartupState;
import com.memes.chat.util.usecases.ChatSignInUseCase;
import com.memes.commons.viewmodel.BaseViewModel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import p015io.getstream.chat.android.client.ChatClient;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\u0017\u001a\u00020\u0018J\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001aJ\b\u0010\u001b\u001a\u00020\u001cH\u0002R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\f\u001a\u00020\r8BX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0012\u001a\u00020\u00138BX\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u001d"}, mo26107d2 = {"Lcom/memes/chat/ui/startup/ChatStartupViewModel;", "Lcom/memes/commons/viewmodel/BaseViewModel;", "chatClient", "Lio/getstream/chat/android/client/ChatClient;", "chatDatabase", "Lcom/memes/chat/db/ChatDatabase;", "credentialsSharedPref", "Lcom/memes/chat/ui/startup/ChatCredentialsSharedPref;", "(Lio/getstream/chat/android/client/ChatClient;Lcom/memes/chat/db/ChatDatabase;Lcom/memes/chat/ui/startup/ChatCredentialsSharedPref;)V", "_chatSignInState", "Landroidx/lifecycle/MutableLiveData;", "Lcom/memes/chat/ui/startup/ChatStartupState;", "signInExceptionHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "getSignInExceptionHandler", "()Lkotlinx/coroutines/CoroutineExceptionHandler;", "signInExceptionHandler$delegate", "Lkotlin/Lazy;", "signInUseCase", "Lcom/memes/chat/util/usecases/ChatSignInUseCase;", "getSignInUseCase", "()Lcom/memes/chat/util/usecases/ChatSignInUseCase;", "signInUseCase$delegate", "beginStartup", "", "chatSignInState", "Landroidx/lifecycle/LiveData;", "signIn", "Lkotlinx/coroutines/Job;", "chat_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.chat.ui.startup.ChatStartupViewModel */
/* compiled from: ChatStartupViewModel.kt */
public final class ChatStartupViewModel extends BaseViewModel {
    /* access modifiers changed from: private */
    public final MutableLiveData<ChatStartupState> _chatSignInState = new MutableLiveData<>();
    /* access modifiers changed from: private */
    public final ChatClient chatClient;
    /* access modifiers changed from: private */
    public final ChatDatabase chatDatabase;
    /* access modifiers changed from: private */
    public final ChatCredentialsSharedPref credentialsSharedPref;
    private final Lazy signInExceptionHandler$delegate = LazyKt.lazy(new ChatStartupViewModel$signInExceptionHandler$2(this));
    private final Lazy signInUseCase$delegate = LazyKt.lazy(new ChatStartupViewModel$signInUseCase$2(this));

    private final CoroutineExceptionHandler getSignInExceptionHandler() {
        return (CoroutineExceptionHandler) this.signInExceptionHandler$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final ChatSignInUseCase getSignInUseCase() {
        return (ChatSignInUseCase) this.signInUseCase$delegate.getValue();
    }

    public ChatStartupViewModel(ChatClient chatClient2, ChatDatabase chatDatabase2, ChatCredentialsSharedPref chatCredentialsSharedPref) {
        Intrinsics.checkNotNullParameter(chatClient2, "chatClient");
        Intrinsics.checkNotNullParameter(chatDatabase2, "chatDatabase");
        Intrinsics.checkNotNullParameter(chatCredentialsSharedPref, "credentialsSharedPref");
        this.chatClient = chatClient2;
        this.chatDatabase = chatDatabase2;
        this.credentialsSharedPref = chatCredentialsSharedPref;
    }

    public final LiveData<ChatStartupState> chatSignInState() {
        return this._chatSignInState;
    }

    public final void beginStartup() {
        if (this.chatClient.getCurrentUser() != null) {
            this._chatSignInState.setValue(ChatStartupState.Loaded.INSTANCE);
        } else {
            signIn();
        }
    }

    private final Job signIn() {
        return BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), getSignInExceptionHandler(), (CoroutineStart) null, new ChatStartupViewModel$signIn$1(this, (Continuation) null), 2, (Object) null);
    }
}
