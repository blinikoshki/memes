package com.memes.plus.p040ui.auth.signinfb;

import android.os.Bundle;
import com.facebook.GraphRequest;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H@¢\u0006\u0004\b\u0003\u0010\u0004"}, mo26107d2 = {"<anonymous>", "Lorg/json/JSONObject;", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, mo26108k = 3, mo26109mv = {1, 4, 2})
@DebugMetadata(mo26807c = "com.memes.plus.ui.auth.signinfb.FbAuthViewModel$fetchFbProfile$2$jsonObject$1", mo26808f = "FbAuthViewModel.kt", mo26809i = {}, mo26810l = {199}, mo26811m = "invokeSuspend", mo26812n = {}, mo26813s = {})
/* renamed from: com.memes.plus.ui.auth.signinfb.FbAuthViewModel$fetchFbProfile$2$jsonObject$1 */
/* compiled from: FbAuthViewModel.kt */
final class FbAuthViewModel$fetchFbProfile$2$jsonObject$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super JSONObject>, Object> {
    Object L$0;
    int label;
    final /* synthetic */ FbAuthViewModel$fetchFbProfile$2 this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FbAuthViewModel$fetchFbProfile$2$jsonObject$1(FbAuthViewModel$fetchFbProfile$2 fbAuthViewModel$fetchFbProfile$2, Continuation continuation) {
        super(2, continuation);
        this.this$0 = fbAuthViewModel$fetchFbProfile$2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        return new FbAuthViewModel$fetchFbProfile$2$jsonObject$1(this.this$0, continuation);
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((FbAuthViewModel$fetchFbProfile$2$jsonObject$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.L$0 = this;
            this.label = 1;
            SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(this));
            GraphRequest newMeRequest = GraphRequest.newMeRequest(this.this$0.$loginResult.getAccessToken(), new FbAuthViewModel$fetchFbProfile$2$jsonObject$1$1$graphRequest$1(safeContinuation));
            Bundle bundle = new Bundle();
            bundle.putString("fields", "name,email,id,picture.type(large),location");
            Intrinsics.checkNotNullExpressionValue(newMeRequest, "graphRequest");
            newMeRequest.setParameters(bundle);
            newMeRequest.executeAsync();
            obj = safeContinuation.getOrThrow();
            if (obj == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(this);
            }
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i == 1) {
            FbAuthViewModel$fetchFbProfile$2$jsonObject$1 fbAuthViewModel$fetchFbProfile$2$jsonObject$1 = (FbAuthViewModel$fetchFbProfile$2$jsonObject$1) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return obj;
    }
}
