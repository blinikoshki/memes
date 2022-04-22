package editor.work;

import android.content.Context;
import androidx.work.CoroutineWorker;
import androidx.work.ExistingPeriodicWorkPolicy;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkManager;
import androidx.work.WorkRequest;
import androidx.work.WorkerParameters;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0011\u0010\u0007\u001a\u00020\bH@ø\u0001\u0000¢\u0006\u0002\u0010\t\u0002\u0004\n\u0002\b\u0019¨\u0006\u000b"}, mo26107d2 = {"Leditor/work/EditorCacheDeletionWorker;", "Landroidx/work/CoroutineWorker;", "appContext", "Landroid/content/Context;", "workerParams", "Landroidx/work/WorkerParameters;", "(Landroid/content/Context;Landroidx/work/WorkerParameters;)V", "doWork", "Landroidx/work/ListenableWorker$Result;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: EditorCacheDeletionWorker.kt */
public final class EditorCacheDeletionWorker extends CoroutineWorker {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final long MIN_AGE_MILLIS = 86400000;
    public static final String TAG = "EditorCacheDeletionWorker";

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public EditorCacheDeletionWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        Intrinsics.checkNotNullParameter(context, "appContext");
        Intrinsics.checkNotNullParameter(workerParameters, "workerParams");
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, mo26107d2 = {"Leditor/work/EditorCacheDeletionWorker$Companion;", "", "()V", "MIN_AGE_MILLIS", "", "TAG", "", "enqueue", "", "context", "Landroid/content/Context;", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: EditorCacheDeletionWorker.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void enqueue(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            WorkRequest build = ((PeriodicWorkRequest.Builder) new PeriodicWorkRequest.Builder(EditorCacheDeletionWorker.class, 1, TimeUnit.DAYS, 1, TimeUnit.HOURS).addTag(EditorCacheDeletionWorker.TAG)).build();
            Intrinsics.checkNotNullExpressionValue(build, "PeriodicWorkRequestBuild…\t\t\t\t).addTag(TAG).build()");
            WorkManager.getInstance(context.getApplicationContext()).enqueueUniquePeriodicWork(EditorCacheDeletionWorker.TAG, ExistingPeriodicWorkPolicy.REPLACE, (PeriodicWorkRequest) build);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v1, resolved type: java.util.Collection} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: java.util.List} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x007c  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x007f A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object doWork(kotlin.coroutines.Continuation<? super androidx.work.ListenableWorker.Result> r14) {
        /*
            r13 = this;
            com.memes.commons.output.OutputTargetGenerator$Companion r14 = com.memes.commons.output.OutputTargetGenerator.Companion
            r0 = 0
            r1 = 1
            com.memes.commons.output.OutputTargetGenerator r14 = com.memes.commons.output.OutputTargetGenerator.Companion.fromExternalCacheDirectory$default(r14, r0, r1, r0)
            java.io.File r14 = r14.getRootDirectory()
            boolean r2 = r14.isDirectory()
            java.lang.String r3 = "Result.success()"
            if (r2 == 0) goto L_0x00c2
            java.io.File[] r14 = r14.listFiles()
            r2 = 0
            if (r14 == 0) goto L_0x0085
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            java.util.Collection r4 = (java.util.Collection) r4
            int r5 = r14.length
            r6 = 0
        L_0x0024:
            if (r6 >= r5) goto L_0x0082
            r7 = r14[r6]
            java.lang.String r8 = "innerFile"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r8)
            boolean r8 = r7.isDirectory()
            if (r8 == 0) goto L_0x0071
            java.lang.String r8 = r7.getName()
            java.lang.String r9 = "innerFile.name"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r9)
            r9 = 2
            java.lang.String r10 = "."
            boolean r8 = kotlin.text.StringsKt.startsWith$default(r8, r10, r2, r9, r0)
            if (r8 != 0) goto L_0x0071
            java.lang.String r8 = r7.getName()
            java.lang.String r9 = "default"
            boolean r8 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r8, (java.lang.Object) r9)
            r8 = r8 ^ r1
            if (r8 == 0) goto L_0x0071
            java.lang.String r8 = r7.getName()
            java.lang.String r9 = "messaging"
            boolean r8 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r8, (java.lang.Object) r9)
            r8 = r8 ^ r1
            if (r8 == 0) goto L_0x0071
            long r8 = java.lang.System.currentTimeMillis()
            long r10 = r7.lastModified()
            long r8 = r8 - r10
            r10 = 86400000(0x5265c00, double:4.2687272E-316)
            int r12 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r12 < 0) goto L_0x0071
            r8 = 1
            goto L_0x0072
        L_0x0071:
            r8 = 0
        L_0x0072:
            java.lang.Boolean r8 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r8)
            boolean r8 = r8.booleanValue()
            if (r8 == 0) goto L_0x007f
            r4.add(r7)
        L_0x007f:
            int r6 = r6 + 1
            goto L_0x0024
        L_0x0082:
            r0 = r4
            java.util.List r0 = (java.util.List) r0
        L_0x0085:
            r14 = r0
            java.util.Collection r14 = (java.util.Collection) r14
            if (r14 == 0) goto L_0x0092
            boolean r14 = r14.isEmpty()
            if (r14 == 0) goto L_0x0091
            goto L_0x0092
        L_0x0091:
            r1 = 0
        L_0x0092:
            if (r1 == 0) goto L_0x00a3
            java.lang.Object[] r14 = new java.lang.Object[r2]
            java.lang.String r0 = "No directory can be deleted."
            timber.log.Timber.m306i(r0, r14)
            androidx.work.ListenableWorker$Result r14 = androidx.work.ListenableWorker.Result.success()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r14, r3)
            return r14
        L_0x00a3:
            java.util.Iterator r14 = r0.iterator()
        L_0x00a7:
            boolean r0 = r14.hasNext()
            if (r0 == 0) goto L_0x00c2
            java.lang.Object r0 = r14.next()
            java.io.File r0 = (java.io.File) r0
            boolean r1 = r0.exists()
            if (r1 == 0) goto L_0x00a7
            java.lang.String r1 = "innerFolder"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            kotlin.p017io.FilesKt.deleteRecursively(r0)
            goto L_0x00a7
        L_0x00c2:
            androidx.work.ListenableWorker$Result r14 = androidx.work.ListenableWorker.Result.success()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r14, r3)
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: editor.work.EditorCacheDeletionWorker.doWork(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
