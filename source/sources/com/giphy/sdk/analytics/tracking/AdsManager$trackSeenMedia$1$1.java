package com.giphy.sdk.analytics.tracking;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@ø\u0001\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, mo26107d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, mo26108k = 3, mo26109mv = {1, 1, 13})
@DebugMetadata(mo26807c = "com.giphy.sdk.analytics.tracking.AdsManager$trackSeenMedia$1$1", mo26808f = "AdsManager.kt", mo26809i = {}, mo26810l = {}, mo26811m = "invokeSuspend", mo26812n = {}, mo26813s = {})
/* compiled from: AdsManager.kt */
final class AdsManager$trackSeenMedia$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List $it;
    int label;

    /* renamed from: p$ */
    private CoroutineScope f175p$;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AdsManager$trackSeenMedia$1$1(List list, Continuation continuation) {
        super(2, continuation);
        this.$it = list;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkParameterIsNotNull(continuation, "completion");
        AdsManager$trackSeenMedia$1$1 adsManager$trackSeenMedia$1$1 = new AdsManager$trackSeenMedia$1$1(this.$it, continuation);
        adsManager$trackSeenMedia$1$1.f175p$ = (CoroutineScope) obj;
        return adsManager$trackSeenMedia$1$1;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((AdsManager$trackSeenMedia$1$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else if (!(obj instanceof Result.Failure)) {
            Iterable<String> iterable = this.$it;
            Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
            for (String access$urlRequestFromTag : iterable) {
                arrayList.add(AdsManager.INSTANCE.urlRequestFromTag(access$urlRequestFromTag));
            }
            for (String access$callTrackingUrl : (List) arrayList) {
                AdsManager.INSTANCE.callTrackingUrl(access$callTrackingUrl);
            }
            return Unit.INSTANCE;
        } else {
            throw ((Result.Failure) obj).exception;
        }
    }
}
