package com.memes.plus.work;

import android.content.Context;
import androidx.work.BackoffPolicy;
import androidx.work.Constraints;
import androidx.work.CoroutineWorker;
import androidx.work.Data;
import androidx.work.NetworkType;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import androidx.work.WorkRequest;
import androidx.work.WorkerParameters;
import com.google.gson.Gson;
import com.memes.plus.p040ui.subscription.PurchaseRecord;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0011\u0010\u0007\u001a\u00020\bH@ø\u0001\u0000¢\u0006\u0002\u0010\t\u0002\u0004\n\u0002\b\u0019¨\u0006\u000b"}, mo26107d2 = {"Lcom/memes/plus/work/RegisterPurchaseWorker;", "Landroidx/work/CoroutineWorker;", "appContext", "Landroid/content/Context;", "workerParams", "Landroidx/work/WorkerParameters;", "(Landroid/content/Context;Landroidx/work/WorkerParameters;)V", "doWork", "Landroidx/work/ListenableWorker$Result;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: RegisterPurchaseWorker.kt */
public final class RegisterPurchaseWorker extends CoroutineWorker {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String EXTRA_PURCHASE_RECORD_JSON = "intent_extra_purchase_record";

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RegisterPurchaseWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        Intrinsics.checkNotNullParameter(context, "appContext");
        Intrinsics.checkNotNullParameter(workerParameters, "workerParams");
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\u0004H\u0002J\u0010\u0010\r\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000e"}, mo26107d2 = {"Lcom/memes/plus/work/RegisterPurchaseWorker$Companion;", "", "()V", "EXTRA_PURCHASE_RECORD_JSON", "", "enqueue", "", "context", "Landroid/content/Context;", "purchaseRecord", "Lcom/memes/plus/ui/subscription/PurchaseRecord;", "purchaseRecordJsonToPurchaseRecord", "recordJson", "purchaseRecordToJson", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: RegisterPurchaseWorker.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final String purchaseRecordToJson(PurchaseRecord purchaseRecord) {
            String json = new Gson().toJson((Object) purchaseRecord);
            Intrinsics.checkNotNullExpressionValue(json, "Gson().toJson(purchaseRecord)");
            return json;
        }

        /* access modifiers changed from: private */
        public final PurchaseRecord purchaseRecordJsonToPurchaseRecord(String str) {
            Object fromJson = new Gson().fromJson(str, PurchaseRecord.class);
            Intrinsics.checkNotNullExpressionValue(fromJson, "Gson().fromJson(recordJs…rchaseRecord::class.java)");
            return (PurchaseRecord) fromJson;
        }

        public final void enqueue(Context context, PurchaseRecord purchaseRecord) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(purchaseRecord, "purchaseRecord");
            Constraints build = new Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build();
            Intrinsics.checkNotNullExpressionValue(build, "Constraints.Builder()\n\t\t…e.CONNECTED)\n\t\t\t\t.build()");
            OneTimeWorkRequest.Builder builder = new OneTimeWorkRequest.Builder(RegisterPurchaseWorker.class);
            Pair[] pairArr = {TuplesKt.m181to(RegisterPurchaseWorker.EXTRA_PURCHASE_RECORD_JSON, purchaseRecordToJson(purchaseRecord))};
            Data.Builder builder2 = new Data.Builder();
            for (int i = 0; i < 1; i++) {
                Pair pair = pairArr[i];
                builder2.put((String) pair.getFirst(), pair.getSecond());
            }
            Data build2 = builder2.build();
            Intrinsics.checkNotNullExpressionValue(build2, "dataBuilder.build()");
            WorkRequest build3 = ((OneTimeWorkRequest.Builder) ((OneTimeWorkRequest.Builder) ((OneTimeWorkRequest.Builder) builder.setInputData(build2)).setConstraints(build)).setBackoffCriteria(BackoffPolicy.LINEAR, WorkRequest.MIN_BACKOFF_MILLIS, TimeUnit.MILLISECONDS)).build();
            Intrinsics.checkNotNullExpressionValue(build3, "OneTimeWorkRequestBuilde…LLISECONDS)\n\t\t\t\t\t.build()");
            WorkManager.getInstance(context.getApplicationContext()).enqueue((WorkRequest) (OneTimeWorkRequest) build3);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0077  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object doWork(kotlin.coroutines.Continuation<? super androidx.work.ListenableWorker.Result> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.memes.plus.work.RegisterPurchaseWorker$doWork$1
            if (r0 == 0) goto L_0x0014
            r0 = r5
            com.memes.plus.work.RegisterPurchaseWorker$doWork$1 r0 = (com.memes.plus.work.RegisterPurchaseWorker$doWork$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r5 = r0.label
            int r5 = r5 - r2
            r0.label = r5
            goto L_0x0019
        L_0x0014:
            com.memes.plus.work.RegisterPurchaseWorker$doWork$1 r0 = new com.memes.plus.work.RegisterPurchaseWorker$doWork$1
            r0.<init>(r4, r5)
        L_0x0019:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0032
            if (r2 != r3) goto L_0x002a
            kotlin.ResultKt.throwOnFailure(r5)
            goto L_0x006f
        L_0x002a:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L_0x0032:
            kotlin.ResultKt.throwOnFailure(r5)
            androidx.work.Data r5 = r4.getInputData()
            java.lang.String r2 = "intent_extra_purchase_record"
            java.lang.String r5 = r5.getString(r2)
            r2 = r5
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            if (r2 == 0) goto L_0x004d
            boolean r2 = kotlin.text.StringsKt.isBlank(r2)
            if (r2 == 0) goto L_0x004b
            goto L_0x004d
        L_0x004b:
            r2 = 0
            goto L_0x004e
        L_0x004d:
            r2 = 1
        L_0x004e:
            if (r2 == 0) goto L_0x005a
            androidx.work.ListenableWorker$Result r5 = androidx.work.ListenableWorker.Result.failure()
            java.lang.String r0 = "Result.failure()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r0)
            return r5
        L_0x005a:
            com.memes.plus.work.RegisterPurchaseWorker$Companion r2 = Companion
            com.memes.plus.ui.subscription.PurchaseRecord r5 = r2.purchaseRecordJsonToPurchaseRecord(r5)
            com.memes.plus.util.RepositoryInjection r2 = com.memes.plus.util.RepositoryInjection.INSTANCE
            com.memes.plus.data.source.memes.MemesRepository r2 = r2.memesRepository()
            r0.label = r3
            java.lang.Object r5 = r2.registerPurchaseToServer(r5, r0)
            if (r5 != r1) goto L_0x006f
            return r1
        L_0x006f:
            com.memes.plus.data.mapped_response.UniversalResult r5 = (com.memes.plus.data.mapped_response.UniversalResult) r5
            boolean r5 = r5.isError()
            if (r5 == 0) goto L_0x0081
            androidx.work.ListenableWorker$Result r5 = androidx.work.ListenableWorker.Result.retry()
            java.lang.String r0 = "Result.retry()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r0)
            return r5
        L_0x0081:
            androidx.work.ListenableWorker$Result r5 = androidx.work.ListenableWorker.Result.success()
            java.lang.String r0 = "Result.success()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r0)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.memes.plus.work.RegisterPurchaseWorker.doWork(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
