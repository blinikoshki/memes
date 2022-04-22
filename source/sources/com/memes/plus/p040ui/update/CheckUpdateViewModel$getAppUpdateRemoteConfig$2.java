package com.memes.plus.p040ui.update;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
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
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import timber.log.Timber;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H@¢\u0006\u0004\b\u0003\u0010\u0004"}, mo26107d2 = {"<anonymous>", "Lcom/memes/plus/ui/update/AppUpdateConfig;", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, mo26108k = 3, mo26109mv = {1, 4, 2})
@DebugMetadata(mo26807c = "com.memes.plus.ui.update.CheckUpdateViewModel$getAppUpdateRemoteConfig$2", mo26808f = "CheckUpdateViewModel.kt", mo26809i = {}, mo26810l = {}, mo26811m = "invokeSuspend", mo26812n = {}, mo26813s = {})
/* renamed from: com.memes.plus.ui.update.CheckUpdateViewModel$getAppUpdateRemoteConfig$2 */
/* compiled from: CheckUpdateViewModel.kt */
final class CheckUpdateViewModel$getAppUpdateRemoteConfig$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super AppUpdateConfig>, Object> {
    int label;

    CheckUpdateViewModel$getAppUpdateRemoteConfig$2(Continuation continuation) {
        super(2, continuation);
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        return new CheckUpdateViewModel$getAppUpdateRemoteConfig$2(continuation);
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((CheckUpdateViewModel$getAppUpdateRemoteConfig$2) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            FirebaseRemoteConfig instance = FirebaseRemoteConfig.getInstance();
            Intrinsics.checkNotNullExpressionValue(instance, "FirebaseRemoteConfig.getInstance()");
            String string = instance.getString(AppUpdateConfig.KEY);
            Intrinsics.checkNotNullExpressionValue(string, "remoteConfig.getString(AppUpdateConfig.KEY)");
            Timber.m300d("remote-config: android_auc_73 = " + string, new Object[0]);
            if (!StringsKt.isBlank(string)) {
                return (AppUpdateConfig) new Gson().fromJson(string, AppUpdateConfig.class);
            }
            return null;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
