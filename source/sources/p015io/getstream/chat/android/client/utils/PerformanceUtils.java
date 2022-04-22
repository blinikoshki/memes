package p015io.getstream.chat.android.client.utils;

import android.util.Log;
import com.facebook.share.internal.ShareConstants;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Typography;
import p015io.getstream.chat.android.core.internal.InternalStreamChatApi;

@InternalStreamChatApi
@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\u0017B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u0006H\u0002J\u000e\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u0005J\u000e\u0010\r\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0005J\u000e\u0010\u000e\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0005J=\u0010\u000f\u001a\u0002H\u0010\"\u0004\b\u0000\u0010\u00102\u0006\u0010\t\u001a\u00020\u00052\u001c\u0010\u0011\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00100\u0013\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0012H@ø\u0001\u0000¢\u0006\u0002\u0010\u0014J'\u0010\u0011\u001a\u0002H\u0010\"\u0004\b\u0000\u0010\u00102\u0006\u0010\t\u001a\u00020\u00052\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u00100\u0015¢\u0006\u0002\u0010\u0016R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u000e¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0018"}, mo26107d2 = {"Lio/getstream/chat/android/client/utils/PerformanceUtils;", "", "()V", "tasks", "", "", "Lio/getstream/chat/android/client/utils/PerformanceUtils$TaskEntry;", "doMeasureAndUpdateResult", "", "taskName", "entry", "log", "message", "startTask", "stopTask", "suspendTask", "T", "task", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlin/Function0;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "TaskEntry", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.utils.PerformanceUtils */
/* compiled from: PerformanceUtils.kt */
public final class PerformanceUtils {
    public static final PerformanceUtils INSTANCE = new PerformanceUtils();
    private static volatile Map<String, TaskEntry> tasks = MapsKt.emptyMap();

    private PerformanceUtils() {
    }

    public final void startTask(String str) {
        Map<String, TaskEntry> map;
        Intrinsics.checkNotNullParameter(str, "taskName");
        synchronized (str) {
            long currentTimeMillis = System.currentTimeMillis();
            TaskEntry taskEntry = tasks.get(str);
            if (taskEntry == null) {
                map = MapsKt.plus(tasks, TuplesKt.m181to(str, new TaskEntry(str, 0, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, Long.valueOf(currentTimeMillis))));
            } else {
                map = MapsKt.plus(tasks, TuplesKt.m181to(str, TaskEntry.copy$default(taskEntry, (String) null, 0, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, Long.valueOf(currentTimeMillis), 7, (Object) null)));
            }
            tasks = map;
            PerformanceUtils performanceUtils = INSTANCE;
            performanceUtils.log("Task \"" + str + "\" started");
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void stopTask(String str) {
        Intrinsics.checkNotNullParameter(str, "taskName");
        synchronized (str) {
            TaskEntry taskEntry = tasks.get(str);
            if (taskEntry == null) {
                PerformanceUtils performanceUtils = INSTANCE;
                performanceUtils.log("There is no such task \"" + str + Typography.quote);
                return;
            }
            INSTANCE.doMeasureAndUpdateResult(str, taskEntry);
            Unit unit = Unit.INSTANCE;
        }
    }

    private final void doMeasureAndUpdateResult(String str, TaskEntry taskEntry) {
        String str2 = str;
        Long lastStart = taskEntry.getLastStart();
        if (lastStart != null) {
            double currentTimeMillis = ((double) (System.currentTimeMillis() - lastStart.longValue())) / 1000.0d;
            double sumDuration = taskEntry.getSumDuration() + currentTimeMillis;
            int count = taskEntry.getCount() + 1;
            tasks = MapsKt.plus(tasks, TuplesKt.m181to(str2, TaskEntry.copy$default(taskEntry, (String) null, count, sumDuration, (Long) null, 1, (Object) null)));
            PerformanceUtils performanceUtils = INSTANCE;
            performanceUtils.log("Task \"" + str2 + "\" completed for " + currentTimeMillis + " seconds\n" + "The average duration for task \"" + str2 + "\" is " + (sumDuration / ((double) count)) + " seconds");
        }
    }

    public final <T> T task(String str, Function0<? extends T> function0) {
        T invoke;
        Intrinsics.checkNotNullParameter(str, "taskName");
        Intrinsics.checkNotNullParameter(function0, "task");
        synchronized (str) {
            TaskEntry taskEntry = tasks.get(str);
            int count = taskEntry != null ? taskEntry.getCount() : 0;
            long currentTimeMillis = System.currentTimeMillis();
            invoke = function0.invoke();
            INSTANCE.doMeasureAndUpdateResult(str, new TaskEntry(str, count, FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE, Long.valueOf(currentTimeMillis), 4, (DefaultConstructorMarker) null));
        }
        return invoke;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0051, code lost:
        r1 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r1.getCount());
     */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <T> java.lang.Object suspendTask(java.lang.String r18, kotlin.jvm.functions.Function1<? super kotlin.coroutines.Continuation<? super T>, ? extends java.lang.Object> r19, kotlin.coroutines.Continuation<? super T> r20) {
        /*
            r17 = this;
            r0 = r18
            r1 = r20
            boolean r2 = r1 instanceof p015io.getstream.chat.android.client.utils.PerformanceUtils$suspendTask$1
            if (r2 == 0) goto L_0x001a
            r2 = r1
            io.getstream.chat.android.client.utils.PerformanceUtils$suspendTask$1 r2 = (p015io.getstream.chat.android.client.utils.PerformanceUtils$suspendTask$1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L_0x001a
            int r1 = r2.label
            int r1 = r1 - r4
            r2.label = r1
            r3 = r17
            goto L_0x0021
        L_0x001a:
            io.getstream.chat.android.client.utils.PerformanceUtils$suspendTask$1 r2 = new io.getstream.chat.android.client.utils.PerformanceUtils$suspendTask$1
            r3 = r17
            r2.<init>(r3, r1)
        L_0x0021:
            java.lang.Object r1 = r2.result
            java.lang.Object r4 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r5 = r2.label
            r6 = 1
            if (r5 == 0) goto L_0x0044
            if (r5 != r6) goto L_0x003c
            long r4 = r2.J$0
            int r0 = r2.I$0
            java.lang.Object r2 = r2.L$0
            java.lang.String r2 = (java.lang.String) r2
            kotlin.ResultKt.throwOnFailure(r1)
            r11 = r0
            r0 = r2
            goto L_0x0079
        L_0x003c:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0044:
            kotlin.ResultKt.throwOnFailure(r1)
            java.util.Map<java.lang.String, io.getstream.chat.android.client.utils.PerformanceUtils$TaskEntry> r1 = tasks
            java.lang.Object r1 = r1.get(r0)
            io.getstream.chat.android.client.utils.PerformanceUtils$TaskEntry r1 = (p015io.getstream.chat.android.client.utils.PerformanceUtils.TaskEntry) r1
            if (r1 == 0) goto L_0x0060
            int r1 = r1.getCount()
            java.lang.Integer r1 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r1)
            if (r1 == 0) goto L_0x0060
            int r1 = r1.intValue()
            goto L_0x0061
        L_0x0060:
            r1 = 0
        L_0x0061:
            long r7 = java.lang.System.currentTimeMillis()
            r2.L$0 = r0
            r2.I$0 = r1
            r2.J$0 = r7
            r2.label = r6
            r5 = r19
            java.lang.Object r2 = r5.invoke(r2)
            if (r2 != r4) goto L_0x0076
            return r4
        L_0x0076:
            r11 = r1
            r1 = r2
            r4 = r7
        L_0x0079:
            io.getstream.chat.android.client.utils.PerformanceUtils r2 = INSTANCE
            io.getstream.chat.android.client.utils.PerformanceUtils$TaskEntry r6 = new io.getstream.chat.android.client.utils.PerformanceUtils$TaskEntry
            java.lang.Long r14 = kotlin.coroutines.jvm.internal.Boxing.boxLong(r4)
            r12 = 0
            r15 = 4
            r16 = 0
            r9 = r6
            r10 = r0
            r9.<init>(r10, r11, r12, r14, r15, r16)
            r2.doMeasureAndUpdateResult(r0, r6)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: p015io.getstream.chat.android.client.utils.PerformanceUtils.suspendTask(java.lang.String, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void log(String str) {
        Intrinsics.checkNotNullParameter(str, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        Log.d("Performance", str);
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\t\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u000eJ8\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010\u0019J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001f"}, mo26107d2 = {"Lio/getstream/chat/android/client/utils/PerformanceUtils$TaskEntry;", "", "name", "", "count", "", "sumDuration", "", "lastStart", "", "(Ljava/lang/String;IDLjava/lang/Long;)V", "getCount", "()I", "getLastStart", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getName", "()Ljava/lang/String;", "getSumDuration", "()D", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;IDLjava/lang/Long;)Lio/getstream/chat/android/client/utils/PerformanceUtils$TaskEntry;", "equals", "", "other", "hashCode", "toString", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: io.getstream.chat.android.client.utils.PerformanceUtils$TaskEntry */
    /* compiled from: PerformanceUtils.kt */
    private static final class TaskEntry {
        private final int count;
        private final Long lastStart;
        private final String name;
        private final double sumDuration;

        public static /* synthetic */ TaskEntry copy$default(TaskEntry taskEntry, String str, int i, double d, Long l, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = taskEntry.name;
            }
            if ((i2 & 2) != 0) {
                i = taskEntry.count;
            }
            int i3 = i;
            if ((i2 & 4) != 0) {
                d = taskEntry.sumDuration;
            }
            double d2 = d;
            if ((i2 & 8) != 0) {
                l = taskEntry.lastStart;
            }
            return taskEntry.copy(str, i3, d2, l);
        }

        public final String component1() {
            return this.name;
        }

        public final int component2() {
            return this.count;
        }

        public final double component3() {
            return this.sumDuration;
        }

        public final Long component4() {
            return this.lastStart;
        }

        public final TaskEntry copy(String str, int i, double d, Long l) {
            Intrinsics.checkNotNullParameter(str, "name");
            return new TaskEntry(str, i, d, l);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof TaskEntry)) {
                return false;
            }
            TaskEntry taskEntry = (TaskEntry) obj;
            return Intrinsics.areEqual((Object) this.name, (Object) taskEntry.name) && this.count == taskEntry.count && Double.compare(this.sumDuration, taskEntry.sumDuration) == 0 && Intrinsics.areEqual((Object) this.lastStart, (Object) taskEntry.lastStart);
        }

        public int hashCode() {
            String str = this.name;
            int i = 0;
            int hashCode = (((((str != null ? str.hashCode() : 0) * 31) + this.count) * 31) + Double.doubleToLongBits(this.sumDuration)) * 31;
            Long l = this.lastStart;
            if (l != null) {
                i = l.hashCode();
            }
            return hashCode + i;
        }

        public String toString() {
            return "TaskEntry(name=" + this.name + ", count=" + this.count + ", sumDuration=" + this.sumDuration + ", lastStart=" + this.lastStart + ")";
        }

        public TaskEntry(String str, int i, double d, Long l) {
            Intrinsics.checkNotNullParameter(str, "name");
            this.name = str;
            this.count = i;
            this.sumDuration = d;
            this.lastStart = l;
        }

        public final String getName() {
            return this.name;
        }

        public final int getCount() {
            return this.count;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ TaskEntry(String str, int i, double d, Long l, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i2 & 2) != 0 ? 0 : i, (i2 & 4) != 0 ? FirebaseRemoteConfig.DEFAULT_VALUE_FOR_DOUBLE : d, l);
        }

        public final double getSumDuration() {
            return this.sumDuration;
        }

        public final Long getLastStart() {
            return this.lastStart;
        }
    }
}
