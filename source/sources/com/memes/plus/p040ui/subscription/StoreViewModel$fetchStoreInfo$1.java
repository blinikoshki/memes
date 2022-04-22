package com.memes.plus.p040ui.subscription;

import androidx.lifecycle.MutableLiveData;
import com.memes.plus.data.mapped_response.UniversalResult;
import com.memes.plus.data.source.purchase.StoreRepository;
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

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@¢\u0006\u0004\b\u0003\u0010\u0004"}, mo26107d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, mo26108k = 3, mo26109mv = {1, 4, 2})
@DebugMetadata(mo26807c = "com.memes.plus.ui.subscription.StoreViewModel$fetchStoreInfo$1", mo26808f = "StoreViewModel.kt", mo26809i = {}, mo26810l = {46}, mo26811m = "invokeSuspend", mo26812n = {}, mo26813s = {})
/* renamed from: com.memes.plus.ui.subscription.StoreViewModel$fetchStoreInfo$1 */
/* compiled from: StoreViewModel.kt */
final class StoreViewModel$fetchStoreInfo$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ StoreViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    StoreViewModel$fetchStoreInfo$1(StoreViewModel storeViewModel, Continuation continuation) {
        super(2, continuation);
        this.this$0 = storeViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        return new StoreViewModel$fetchStoreInfo$1(this.this$0, continuation);
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((StoreViewModel$fetchStoreInfo$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            StoreViewModel storeViewModel = this.this$0;
            storeViewModel.showProgress(storeViewModel._contentVisibilityLiveData, "Fetching store info..");
            StoreRepository access$getRepository$p = this.this$0.repository;
            this.label = 1;
            obj = access$getRepository$p.fetchStoreInfo(this);
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
            if (universalResult.hasNoItem()) {
                StoreViewModel storeViewModel2 = this.this$0;
                MutableLiveData access$get_contentVisibilityLiveData$p = storeViewModel2._contentVisibilityLiveData;
                storeViewModel2.showError(access$get_contentVisibilityLiveData$p, "Unable to fetch store information\n" + "cause: " + universalResult.getMessage());
            }
            this.this$0._storeInfoLiveData.setValue(universalResult.requireItem());
            StoreViewModel storeViewModel3 = this.this$0;
            storeViewModel3.showContent(storeViewModel3._contentVisibilityLiveData);
            return Unit.INSTANCE;
        } else if (universalResult.isSessionExpired()) {
            StoreViewModel storeViewModel4 = this.this$0;
            storeViewModel4.showLoginError(storeViewModel4._contentVisibilityLiveData, universalResult.getMessage());
            return Unit.INSTANCE;
        } else {
            StoreViewModel storeViewModel5 = this.this$0;
            MutableLiveData access$get_contentVisibilityLiveData$p2 = storeViewModel5._contentVisibilityLiveData;
            storeViewModel5.showError(access$get_contentVisibilityLiveData$p2, "Unable to fetch store information\n" + "cause: " + universalResult.getMessage());
            return Unit.INSTANCE;
        }
    }
}
