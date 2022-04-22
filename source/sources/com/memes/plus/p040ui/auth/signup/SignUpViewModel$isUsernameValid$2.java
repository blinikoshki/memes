package com.memes.plus.p040ui.auth.signup;

import com.memes.network.core.UniversalResult;
import com.memes.network.memes.api.MemesDataSource;
import com.memes.network.memes.api.model.auth.UsernameCheckRequest;
import com.memes.plus.C4199R;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@¢\u0006\u0004\b\u0003\u0010\u0004"}, mo26107d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, mo26108k = 3, mo26109mv = {1, 4, 2})
@DebugMetadata(mo26807c = "com.memes.plus.ui.auth.signup.SignUpViewModel$isUsernameValid$2", mo26808f = "SignUpViewModel.kt", mo26809i = {}, mo26810l = {178}, mo26811m = "invokeSuspend", mo26812n = {}, mo26813s = {})
/* renamed from: com.memes.plus.ui.auth.signup.SignUpViewModel$isUsernameValid$2 */
/* compiled from: SignUpViewModel.kt */
final class SignUpViewModel$isUsernameValid$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ String $username;
    int label;
    final /* synthetic */ SignUpViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SignUpViewModel$isUsernameValid$2(SignUpViewModel signUpViewModel, String str, Continuation continuation) {
        super(2, continuation);
        this.this$0 = signUpViewModel;
        this.$username = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        return new SignUpViewModel$isUsernameValid$2(this.this$0, this.$username, continuation);
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((SignUpViewModel$isUsernameValid$2) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            CharSequence charSequence = this.$username;
            if (charSequence == null || StringsKt.isBlank(charSequence)) {
                this.this$0.toast((int) C4199R.string.error_username_empty);
                return Boxing.boxBoolean(false);
            }
            UsernameCheckRequest usernameCheckRequest = new UsernameCheckRequest(this.$username);
            MemesDataSource access$getMemesDataSource$p = this.this$0.memesDataSource;
            this.label = 1;
            obj = access$getMemesDataSource$p.checkAccountExists(usernameCheckRequest, (Continuation<? super UniversalResult<Object>>) this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        UniversalResult universalResult = (UniversalResult) obj;
        if (!universalResult.isError()) {
            return Boxing.boxBoolean(true);
        }
        this.this$0.toast(universalResult.getMessage());
        return Boxing.boxBoolean(false);
    }
}
