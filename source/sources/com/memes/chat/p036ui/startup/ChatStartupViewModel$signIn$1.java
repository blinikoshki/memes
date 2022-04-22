package com.memes.chat.p036ui.startup;

import com.memes.chat.p036ui.startup.ChatStartupState;
import com.memes.chat.util.usecases.ChatSignInUseCase;
import com.memes.network.chat.source.remote.model.signin.ChatSignInRequest;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import p015io.getstream.chat.android.client.models.User;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@¢\u0006\u0004\b\u0003\u0010\u0004"}, mo26107d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, mo26108k = 3, mo26109mv = {1, 4, 2})
@DebugMetadata(mo26807c = "com.memes.chat.ui.startup.ChatStartupViewModel$signIn$1", mo26808f = "ChatStartupViewModel.kt", mo26809i = {0}, mo26810l = {77, 80}, mo26811m = "invokeSuspend", mo26812n = {"chatSignInResponse"}, mo26813s = {"L$0"})
/* renamed from: com.memes.chat.ui.startup.ChatStartupViewModel$signIn$1 */
/* compiled from: ChatStartupViewModel.kt */
final class ChatStartupViewModel$signIn$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ ChatStartupViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChatStartupViewModel$signIn$1(ChatStartupViewModel chatStartupViewModel, Continuation continuation) {
        super(2, continuation);
        this.this$0 = chatStartupViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        return new ChatStartupViewModel$signIn$1(this.this$0, continuation);
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((ChatStartupViewModel$signIn$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(T t) {
        final Ref.ObjectRef objectRef;
        Ref.ObjectRef objectRef2;
        T coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(t);
            this.this$0._chatSignInState.setValue(new ChatStartupState.Loading("Initializing..."));
            String userId = this.this$0.credentialsSharedPref.userId();
            String realUserId = this.this$0.credentialsSharedPref.realUserId();
            String userName = this.this$0.credentialsSharedPref.userName();
            String str = this.this$0.credentialsSharedPref.token();
            CharSequence charSequence = userId;
            boolean z = false;
            if (!(charSequence == null || StringsKt.isBlank(charSequence))) {
                CharSequence charSequence2 = realUserId;
                if (!(charSequence2 == null || StringsKt.isBlank(charSequence2))) {
                    CharSequence charSequence3 = userName;
                    if (!(charSequence3 == null || StringsKt.isBlank(charSequence3))) {
                        CharSequence charSequence4 = str;
                        if (charSequence4 == null || StringsKt.isBlank(charSequence4)) {
                            z = true;
                        }
                        if (!z) {
                            ChatSignInRequest chatSignInRequest = new ChatSignInRequest(realUserId, str, userName, this.this$0.credentialsSharedPref.profilePic());
                            objectRef2 = new Ref.ObjectRef();
                            ChatSignInUseCase access$getSignInUseCase$p = this.this$0.getSignInUseCase();
                            this.L$0 = objectRef2;
                            this.L$1 = objectRef2;
                            this.label = 1;
                            t = access$getSignInUseCase$p.execute(chatSignInRequest, this);
                            if (t == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            objectRef = objectRef2;
                        }
                    }
                }
            }
            throw new RuntimeException("User is not signed in. Please try signing in again.");
        } else if (i == 1) {
            objectRef2 = (Ref.ObjectRef) this.L$1;
            objectRef = (Ref.ObjectRef) this.L$0;
            ResultKt.throwOnFailure(t);
        } else if (i == 2) {
            ResultKt.throwOnFailure(t);
            this.this$0._chatSignInState.setValue(ChatStartupState.Loaded.INSTANCE);
            return Unit.INSTANCE;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        objectRef2.element = (ChatSignInUseCase.Response) t;
        this.this$0.credentialsSharedPref.setChatToken(((ChatSignInUseCase.Response) objectRef.element).getChatToken());
        this.L$0 = null;
        this.L$1 = null;
        this.label = 2;
        if (BuildersKt.withContext(Dispatchers.getIO(), new C41431(this, (Continuation) null), this) == coroutine_suspended) {
            return coroutine_suspended;
        }
        this.this$0._chatSignInState.setValue(ChatStartupState.Loaded.INSTANCE);
        return Unit.INSTANCE;
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@¢\u0006\u0004\b\u0003\u0010\u0004"}, mo26107d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, mo26108k = 3, mo26109mv = {1, 4, 2})
    @DebugMetadata(mo26807c = "com.memes.chat.ui.startup.ChatStartupViewModel$signIn$1$1", mo26808f = "ChatStartupViewModel.kt", mo26809i = {}, mo26810l = {}, mo26811m = "invokeSuspend", mo26812n = {}, mo26813s = {})
    /* renamed from: com.memes.chat.ui.startup.ChatStartupViewModel$signIn$1$1 */
    /* compiled from: ChatStartupViewModel.kt */
    static final class C41431 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ ChatStartupViewModel$signIn$1 this$0;

        {
            this.this$0 = r1;
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Intrinsics.checkNotNullParameter(continuation, "completion");
            return new C41431(this.this$0, objectRef, continuation);
        }

        public final Object invoke(Object obj, Object obj2) {
            return ((C41431) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                User chatUser = ((ChatSignInUseCase.Response) objectRef.element).getChatUser();
                this.this$0.this$0.chatDatabase.getMutedUsersDao().replaceMutes(chatUser.getMutes());
                this.this$0.this$0.chatDatabase.getMutedChannelsDao().replaceChannelMutes(chatUser.getChannelMutes());
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
