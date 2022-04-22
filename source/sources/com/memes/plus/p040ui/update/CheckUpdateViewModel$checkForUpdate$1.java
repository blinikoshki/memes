package com.memes.plus.p040ui.update;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@¢\u0006\u0004\b\u0003\u0010\u0004"}, mo26107d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, mo26108k = 3, mo26109mv = {1, 4, 2})
@DebugMetadata(mo26807c = "com.memes.plus.ui.update.CheckUpdateViewModel$checkForUpdate$1", mo26808f = "CheckUpdateViewModel.kt", mo26809i = {}, mo26810l = {67, 73}, mo26811m = "invokeSuspend", mo26812n = {}, mo26813s = {})
/* renamed from: com.memes.plus.ui.update.CheckUpdateViewModel$checkForUpdate$1 */
/* compiled from: CheckUpdateViewModel.kt */
final class CheckUpdateViewModel$checkForUpdate$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ CheckUpdateViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CheckUpdateViewModel$checkForUpdate$1(CheckUpdateViewModel checkUpdateViewModel, Continuation continuation) {
        super(2, continuation);
        this.this$0 = checkUpdateViewModel;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        return new CheckUpdateViewModel$checkForUpdate$1(this.this$0, continuation);
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((CheckUpdateViewModel$checkForUpdate$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x0093  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x009a  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00a2  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r5) {
        /*
            r4 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r4.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L_0x001f
            if (r1 == r3) goto L_0x001b
            if (r1 != r2) goto L_0x0013
            kotlin.ResultKt.throwOnFailure(r5)
            goto L_0x0087
        L_0x0013:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L_0x001b:
            kotlin.ResultKt.throwOnFailure(r5)
            goto L_0x006c
        L_0x001f:
            kotlin.ResultKt.throwOnFailure(r5)
            com.memes.plus.ui.update.CheckUpdateViewModel r5 = r4.this$0
            com.memes.plus.data.storage.StorageRepository r5 = r5.storageRepository
            boolean r5 = r5.isWelcomed()
            if (r5 != 0) goto L_0x003a
            com.memes.plus.ui.update.CheckUpdateViewModel r5 = r4.this$0
            com.memes.plus.util.OneShotLiveData r5 = r5.getShowWelcomePageLiveData()
            r5.fire()
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        L_0x003a:
            com.memes.plus.ui.update.CheckUpdateViewModel r5 = r4.this$0
            boolean r5 = r5.hasLocalAppUpdateConfig()
            com.memes.plus.ui.update.CheckUpdateViewModel r1 = r4.this$0
            boolean r1 = r1.isConfigRefreshRequired()
            if (r5 == 0) goto L_0x0054
            if (r5 == 0) goto L_0x004d
            if (r1 == 0) goto L_0x004d
            goto L_0x0054
        L_0x004d:
            com.memes.plus.ui.update.CheckUpdateViewModel r5 = r4.this$0
            com.memes.plus.ui.update.AppUpdateConfig r5 = r5.fetchLastAppUpdateConfig()
            goto L_0x0098
        L_0x0054:
            com.memes.plus.ui.update.CheckUpdateViewModel r5 = r4.this$0
            androidx.lifecycle.MutableLiveData r5 = r5.getShowCheckingUpdatesLiveData()
            java.lang.Boolean r1 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r3)
            r5.setValue(r1)
            com.memes.plus.ui.update.CheckUpdateViewModel r5 = r4.this$0
            r4.label = r3
            java.lang.Object r5 = r5.fetchRemoteConfig(r4)
            if (r5 != r0) goto L_0x006c
            return r0
        L_0x006c:
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            boolean r5 = r5.booleanValue()
            if (r5 != 0) goto L_0x007c
            com.memes.plus.ui.update.CheckUpdateViewModel r5 = r4.this$0
            r5.moveToNextNavigation()
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        L_0x007c:
            com.memes.plus.ui.update.CheckUpdateViewModel r5 = r4.this$0
            r4.label = r2
            java.lang.Object r5 = r5.getAppUpdateRemoteConfig(r4)
            if (r5 != r0) goto L_0x0087
            return r0
        L_0x0087:
            com.memes.plus.ui.update.AppUpdateConfig r5 = (com.memes.plus.p040ui.update.AppUpdateConfig) r5
            if (r5 != 0) goto L_0x0093
            com.memes.plus.ui.update.CheckUpdateViewModel r5 = r4.this$0
            r5.moveToNextNavigation()
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        L_0x0093:
            com.memes.plus.ui.update.CheckUpdateViewModel r0 = r4.this$0
            r0.saveAppUpdateConfig(r5)
        L_0x0098:
            if (r5 != 0) goto L_0x00a2
            com.memes.plus.ui.update.CheckUpdateViewModel r5 = r4.this$0
            r5.moveToNextNavigation()
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        L_0x00a2:
            com.memes.plus.ui.update.CheckUpdateViewModel r0 = r4.this$0
            r0.receivedUpdateConfig = r5
            boolean r0 = r5.isUpdateAvailable()
            if (r0 != 0) goto L_0x00b5
            com.memes.plus.ui.update.CheckUpdateViewModel r5 = r4.this$0
            r5.moveToNextNavigation()
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        L_0x00b5:
            boolean r0 = r5.isForceUpdateRequired()
            r1 = 0
            if (r0 == 0) goto L_0x00d7
            com.memes.plus.ui.update.CheckUpdateViewModel r0 = r4.this$0
            androidx.lifecycle.MutableLiveData r0 = r0.getForceUpdateDialogLiveData()
            java.lang.String r5 = r5.getPackageName()
            r0.setValue(r5)
            com.memes.plus.ui.update.CheckUpdateViewModel r5 = r4.this$0
            androidx.lifecycle.MutableLiveData r5 = r5.getShowCheckingUpdatesLiveData()
            java.lang.Boolean r0 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r1)
            r5.setValue(r0)
            goto L_0x00f1
        L_0x00d7:
            com.memes.plus.ui.update.CheckUpdateViewModel r0 = r4.this$0
            androidx.lifecycle.MutableLiveData r0 = r0.getSkippableUpdateDialogLiveData()
            java.lang.String r5 = r5.getPackageName()
            r0.setValue(r5)
            com.memes.plus.ui.update.CheckUpdateViewModel r5 = r4.this$0
            androidx.lifecycle.MutableLiveData r5 = r5.getShowCheckingUpdatesLiveData()
            java.lang.Boolean r0 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r1)
            r5.setValue(r0)
        L_0x00f1:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.memes.plus.p040ui.update.CheckUpdateViewModel$checkForUpdate$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
