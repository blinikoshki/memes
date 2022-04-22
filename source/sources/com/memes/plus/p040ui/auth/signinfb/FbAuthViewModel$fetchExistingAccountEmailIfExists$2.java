package com.memes.plus.p040ui.auth.signinfb;

import com.memes.network.core.UniversalResult;
import com.memes.network.memes.api.MemesDataSource;
import com.memes.network.memes.api.model.auth.FbAccountCheckRequest;
import com.memes.network.memes.api.model.auth.FbAccountCheckResult;
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

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H@¢\u0006\u0004\b\u0003\u0010\u0004"}, mo26107d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, mo26108k = 3, mo26109mv = {1, 4, 2})
@DebugMetadata(mo26807c = "com.memes.plus.ui.auth.signinfb.FbAuthViewModel$fetchExistingAccountEmailIfExists$2", mo26808f = "FbAuthViewModel.kt", mo26809i = {}, mo26810l = {233}, mo26811m = "invokeSuspend", mo26812n = {}, mo26813s = {})
/* renamed from: com.memes.plus.ui.auth.signinfb.FbAuthViewModel$fetchExistingAccountEmailIfExists$2 */
/* compiled from: FbAuthViewModel.kt */
final class FbAuthViewModel$fetchExistingAccountEmailIfExists$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super String>, Object> {
    final /* synthetic */ FbProfile $fbProfile;
    int label;
    final /* synthetic */ FbAuthViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FbAuthViewModel$fetchExistingAccountEmailIfExists$2(FbAuthViewModel fbAuthViewModel, FbProfile fbProfile, Continuation continuation) {
        super(2, continuation);
        this.this$0 = fbAuthViewModel;
        this.$fbProfile = fbProfile;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        return new FbAuthViewModel$fetchExistingAccountEmailIfExists$2(this.this$0, this.$fbProfile, continuation);
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((FbAuthViewModel$fetchExistingAccountEmailIfExists$2) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            String localUserId = this.$fbProfile.getLocalUserId();
            if (localUserId != null) {
                FbAccountCheckRequest fbAccountCheckRequest = new FbAccountCheckRequest(localUserId);
                MemesDataSource access$getMemesDataSource$p = this.this$0.memesDataSource;
                this.label = 1;
                obj = access$getMemesDataSource$p.checkAccountExists(fbAccountCheckRequest, (Continuation<? super UniversalResult<FbAccountCheckResult>>) this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                throw new FbAuthExpectationFailedException("Fb user-id not available.");
            }
        } else if (i == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        FbAccountCheckResult fbAccountCheckResult = (FbAccountCheckResult) ((UniversalResult) obj).getItem();
        if (fbAccountCheckResult != null) {
            return fbAccountCheckResult.getEmail();
        }
        return null;
    }
}
