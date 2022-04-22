package com.memes.plus.p040ui.auth.signinfb;

import com.facebook.login.LoginResult;
import com.google.gson.Gson;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.TimeoutKt;
import org.json.JSONObject;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H@¢\u0006\u0004\b\u0003\u0010\u0004"}, mo26107d2 = {"<anonymous>", "Lcom/memes/plus/ui/auth/signinfb/FbProfile;", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, mo26108k = 3, mo26109mv = {1, 4, 2})
@DebugMetadata(mo26807c = "com.memes.plus.ui.auth.signinfb.FbAuthViewModel$fetchFbProfile$2", mo26808f = "FbAuthViewModel.kt", mo26809i = {}, mo26810l = {197}, mo26811m = "invokeSuspend", mo26812n = {}, mo26813s = {})
/* renamed from: com.memes.plus.ui.auth.signinfb.FbAuthViewModel$fetchFbProfile$2 */
/* compiled from: FbAuthViewModel.kt */
final class FbAuthViewModel$fetchFbProfile$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super FbProfile>, Object> {
    final /* synthetic */ LoginResult $loginResult;
    int label;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FbAuthViewModel$fetchFbProfile$2(LoginResult loginResult, Continuation continuation) {
        super(2, continuation);
        this.$loginResult = loginResult;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        return new FbAuthViewModel$fetchFbProfile$2(this.$loginResult, continuation);
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((FbAuthViewModel$fetchFbProfile$2) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = TimeoutKt.withTimeoutOrNull(40000, new FbAuthViewModel$fetchFbProfile$2$jsonObject$1(this, (Continuation) null), this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        JSONObject jSONObject = (JSONObject) obj;
        if (jSONObject != null) {
            return new Gson().fromJson(jSONObject.toString(), FbProfile.class);
        }
        return null;
    }
}
