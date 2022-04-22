package com.memes.chat.util.usecases;

import com.memes.network.chat.source.remote.model.signin.ChatSignInRequest;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005H@"}, mo26107d2 = {"signIn", "", "request", "Lcom/memes/network/chat/source/remote/model/signin/ChatSignInRequest;", "continuation", "Lkotlin/coroutines/Continuation;", ""}, mo26108k = 3, mo26109mv = {1, 4, 2})
@DebugMetadata(mo26807c = "com.memes.chat.util.usecases.ChatSignInUseCase", mo26808f = "ChatSignInUseCase.kt", mo26809i = {}, mo26810l = {58}, mo26811m = "signIn", mo26812n = {}, mo26813s = {})
/* compiled from: ChatSignInUseCase.kt */
final class ChatSignInUseCase$signIn$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ChatSignInUseCase this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChatSignInUseCase$signIn$1(ChatSignInUseCase chatSignInUseCase, Continuation continuation) {
        super(continuation);
        this.this$0 = chatSignInUseCase;
    }

    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.signIn((ChatSignInRequest) null, this);
    }
}
