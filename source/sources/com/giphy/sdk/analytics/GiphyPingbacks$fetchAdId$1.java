package com.giphy.sdk.analytics;

import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@ø\u0001\u0000¢\u0006\u0004\b\u0003\u0010\u0004"}, mo26107d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, mo26108k = 3, mo26109mv = {1, 1, 13})
@DebugMetadata(mo26807c = "com.giphy.sdk.analytics.GiphyPingbacks$fetchAdId$1", mo26808f = "GiphyPingbacks.kt", mo26809i = {}, mo26810l = {}, mo26811m = "invokeSuspend", mo26812n = {}, mo26813s = {})
/* compiled from: GiphyPingbacks.kt */
final class GiphyPingbacks$fetchAdId$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;

    /* renamed from: p$ */
    private CoroutineScope f170p$;

    GiphyPingbacks$fetchAdId$1(Continuation continuation) {
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkParameterIsNotNull(continuation, "completion");
        GiphyPingbacks$fetchAdId$1 giphyPingbacks$fetchAdId$1 = new GiphyPingbacks$fetchAdId$1(continuation);
        giphyPingbacks$fetchAdId$1.f170p$ = (CoroutineScope) obj;
        return giphyPingbacks$fetchAdId$1;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((GiphyPingbacks$fetchAdId$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        } else if (!(obj instanceof Result.Failure)) {
            AdvertisingIdClient.Info info = null;
            try {
                info = AdvertisingIdClient.getAdvertisingIdInfo(GiphyPingbacks.access$getContext$p(GiphyPingbacks.INSTANCE).getApplicationContext());
            } catch (GooglePlayServicesNotAvailableException e) {
                e.printStackTrace();
            } catch (GooglePlayServicesRepairableException e2) {
                e2.printStackTrace();
            } catch (Exception e3) {
                e3.printStackTrace();
            }
            String str = null;
            if (info == null) {
                try {
                    Intrinsics.throwNpe();
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
            }
            str = info.getId();
            GiphyPingbacks.INSTANCE.saveAdId(str);
            GiphyPingbacks.INSTANCE.saveUUID();
            GiphyPingbacks.INSTANCE.savePingbackId(str);
            return Unit.INSTANCE;
        } else {
            throw ((Result.Failure) obj).exception;
        }
    }
}
