package p015io.getstream.chat.android.client.helpers;

import com.facebook.share.internal.ShareConstants;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.api.ChatApi;
import p015io.getstream.chat.android.client.api.models.QueryChannelRequest;
import p015io.getstream.chat.android.client.api.models.QueryChannelsRequest;
import p015io.getstream.chat.android.client.call.Call;
import p015io.getstream.chat.android.client.clientstate.ClientStateService;
import p015io.getstream.chat.android.client.models.Channel;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000  2\u00020\u0001:\u0001 B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ/\u0010\u000b\u001a\u0002H\f\"\u0004\b\u0000\u0010\f2\b\b\u0002\u0010\r\u001a\u00020\t2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\f0\u000fHPø\u0001\u0000¢\u0006\u0002\u0010\u0010J5\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\f0\u0012\"\b\b\u0000\u0010\f*\u00020\u00012\u0012\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\f0\u00120\u000fH@ø\u0001\u0000¢\u0006\u0002\u0010\u0013J+\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u00122\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001aH\u0000¢\u0006\u0002\b\u001bJ!\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u001d0\u00122\u0006\u0010\u0019\u001a\u00020\u001eH\u0000¢\u0006\u0002\b\u001fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006!"}, mo26107d2 = {"Lio/getstream/chat/android/client/helpers/QueryChannelsPostponeHelper;", "", "api", "Lio/getstream/chat/android/client/api/ChatApi;", "clientStateService", "Lio/getstream/chat/android/client/clientstate/ClientStateService;", "delayDuration", "", "attemptsCount", "", "(Lio/getstream/chat/android/client/api/ChatApi;Lio/getstream/chat/android/client/clientstate/ClientStateService;JI)V", "doJob", "T", "attemptCount", "job", "Lkotlin/Function0;", "(ILkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "doSafeJob", "Lio/getstream/chat/android/client/call/Call;", "(Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "queryChannel", "Lio/getstream/chat/android/client/models/Channel;", "channelType", "", "channelId", "request", "Lio/getstream/chat/android/client/api/models/QueryChannelRequest;", "queryChannel$stream_chat_android_client_release", "queryChannels", "", "Lio/getstream/chat/android/client/api/models/QueryChannelsRequest;", "queryChannels$stream_chat_android_client_release", "Companion", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.helpers.QueryChannelsPostponeHelper */
/* compiled from: QueryChannelsPostponeHelper.kt */
public final class QueryChannelsPostponeHelper {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final long DELAY_DURATION = 200;
    private static final int MAX_ATTEMPTS_COUNT;
    private static final long MAX_DURATION;
    /* access modifiers changed from: private */
    public final ChatApi api;
    private final int attemptsCount;
    private final ClientStateService clientStateService;
    private final long delayDuration;

    public QueryChannelsPostponeHelper(ChatApi chatApi, ClientStateService clientStateService2, long j, int i) {
        Intrinsics.checkNotNullParameter(chatApi, "api");
        Intrinsics.checkNotNullParameter(clientStateService2, "clientStateService");
        this.api = chatApi;
        this.clientStateService = clientStateService2;
        this.delayDuration = j;
        this.attemptsCount = i;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ QueryChannelsPostponeHelper(ChatApi chatApi, ClientStateService clientStateService2, long j, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(chatApi, clientStateService2, (i2 & 4) != 0 ? 200 : j, (i2 & 8) != 0 ? MAX_ATTEMPTS_COUNT : i);
    }

    public final Call<Channel> queryChannel$stream_chat_android_client_release(String str, String str2, QueryChannelRequest queryChannelRequest) {
        Intrinsics.checkNotNullParameter(str, "channelType");
        Intrinsics.checkNotNullParameter(str2, "channelId");
        Intrinsics.checkNotNullParameter(queryChannelRequest, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        return (Call) BuildersKt__BuildersKt.runBlocking$default((CoroutineContext) null, new QueryChannelsPostponeHelper$queryChannel$1(this, str, str2, queryChannelRequest, (Continuation) null), 1, (Object) null);
    }

    public final Call<List<Channel>> queryChannels$stream_chat_android_client_release(QueryChannelsRequest queryChannelsRequest) {
        Intrinsics.checkNotNullParameter(queryChannelsRequest, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        return (Call) BuildersKt__BuildersKt.runBlocking$default((CoroutineContext) null, new QueryChannelsPostponeHelper$queryChannels$1(this, queryChannelsRequest, (Continuation) null), 1, (Object) null);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0034  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ <T> java.lang.Object doSafeJob(kotlin.jvm.functions.Function0<? extends p015io.getstream.chat.android.client.call.Call<T>> r5, kotlin.coroutines.Continuation<? super p015io.getstream.chat.android.client.call.Call<T>> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof p015io.getstream.chat.android.client.helpers.QueryChannelsPostponeHelper$doSafeJob$1
            if (r0 == 0) goto L_0x0014
            r0 = r6
            io.getstream.chat.android.client.helpers.QueryChannelsPostponeHelper$doSafeJob$1 r0 = (p015io.getstream.chat.android.client.helpers.QueryChannelsPostponeHelper$doSafeJob$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L_0x0019
        L_0x0014:
            io.getstream.chat.android.client.helpers.QueryChannelsPostponeHelper$doSafeJob$1 r0 = new io.getstream.chat.android.client.helpers.QueryChannelsPostponeHelper$doSafeJob$1
            r0.<init>(r4, r6)
        L_0x0019:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0034
            if (r2 != r3) goto L_0x002c
            kotlin.ResultKt.throwOnFailure(r6)     // Catch:{ Exception -> 0x002a }
            goto L_0x0042
        L_0x002a:
            r5 = move-exception
            goto L_0x0045
        L_0x002c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0034:
            kotlin.ResultKt.throwOnFailure(r6)
            int r6 = r4.attemptsCount     // Catch:{ Exception -> 0x002a }
            r0.label = r3     // Catch:{ Exception -> 0x002a }
            java.lang.Object r6 = r4.doJob(r6, r5, r0)     // Catch:{ Exception -> 0x002a }
            if (r6 != r1) goto L_0x0042
            return r1
        L_0x0042:
            io.getstream.chat.android.client.call.Call r6 = (p015io.getstream.chat.android.client.call.Call) r6     // Catch:{ Exception -> 0x002a }
            goto L_0x0057
        L_0x0045:
            io.getstream.chat.android.client.api.ErrorCall r6 = new io.getstream.chat.android.client.api.ErrorCall
            io.getstream.chat.android.client.errors.ChatError r0 = new io.getstream.chat.android.client.errors.ChatError
            java.lang.String r1 = r5.getMessage()
            java.lang.Throwable r5 = (java.lang.Throwable) r5
            r0.<init>(r1, r5)
            r6.<init>(r0)
            io.getstream.chat.android.client.call.Call r6 = (p015io.getstream.chat.android.client.call.Call) r6
        L_0x0057:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: p015io.getstream.chat.android.client.helpers.QueryChannelsPostponeHelper.doSafeJob(kotlin.jvm.functions.Function0, kotlin.coroutines.Continuation):java.lang.Object");
    }

    static /* synthetic */ Object doJob$default(QueryChannelsPostponeHelper queryChannelsPostponeHelper, int i, Function0 function0, Continuation continuation, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = queryChannelsPostponeHelper.attemptsCount;
        }
        return queryChannelsPostponeHelper.doJob(i, function0, continuation);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0042  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0047  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x007b  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ <T> java.lang.Object doJob(int r7, kotlin.jvm.functions.Function0<? extends T> r8, kotlin.coroutines.Continuation<? super T> r9) {
        /*
            r6 = this;
            boolean r0 = r9 instanceof p015io.getstream.chat.android.client.helpers.QueryChannelsPostponeHelper$doJob$1
            if (r0 == 0) goto L_0x0014
            r0 = r9
            io.getstream.chat.android.client.helpers.QueryChannelsPostponeHelper$doJob$1 r0 = (p015io.getstream.chat.android.client.helpers.QueryChannelsPostponeHelper$doJob$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L_0x0019
        L_0x0014:
            io.getstream.chat.android.client.helpers.QueryChannelsPostponeHelper$doJob$1 r0 = new io.getstream.chat.android.client.helpers.QueryChannelsPostponeHelper$doJob$1
            r0.<init>(r6, r9)
        L_0x0019:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x003c
            if (r2 != r3) goto L_0x0034
            int r7 = r0.I$0
            java.lang.Object r8 = r0.L$1
            kotlin.jvm.functions.Function0 r8 = (kotlin.jvm.functions.Function0) r8
            java.lang.Object r2 = r0.L$0
            io.getstream.chat.android.client.helpers.QueryChannelsPostponeHelper r2 = (p015io.getstream.chat.android.client.helpers.QueryChannelsPostponeHelper) r2
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x0079
        L_0x0034:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x003c:
            kotlin.ResultKt.throwOnFailure(r9)
            r2 = r6
        L_0x0040:
            if (r7 <= 0) goto L_0x0044
            r9 = 1
            goto L_0x0045
        L_0x0044:
            r9 = 0
        L_0x0045:
            if (r9 == 0) goto L_0x008f
            io.getstream.chat.android.client.clientstate.ClientStateService r9 = r2.clientStateService
            io.getstream.chat.android.client.clientstate.ClientState r9 = r9.getState$stream_chat_android_client_release()
            boolean r4 = r9 instanceof p015io.getstream.chat.android.client.clientstate.ClientState.Idle
            if (r4 != 0) goto L_0x0081
            boolean r4 = r9 instanceof p015io.getstream.chat.android.client.clientstate.ClientState.User.Authorized
            if (r4 == 0) goto L_0x0056
            goto L_0x005a
        L_0x0056:
            boolean r4 = r9 instanceof p015io.getstream.chat.android.client.clientstate.ClientState.Anonymous.Authorized
            if (r4 == 0) goto L_0x005f
        L_0x005a:
            java.lang.Object r7 = r8.invoke()
            return r7
        L_0x005f:
            boolean r4 = r9 instanceof p015io.getstream.chat.android.client.clientstate.ClientState.User.Pending
            if (r4 == 0) goto L_0x0064
            goto L_0x0068
        L_0x0064:
            boolean r9 = r9 instanceof p015io.getstream.chat.android.client.clientstate.ClientState.Anonymous.Pending
            if (r9 == 0) goto L_0x007b
        L_0x0068:
            long r4 = r2.delayDuration
            r0.L$0 = r2
            r0.L$1 = r8
            r0.I$0 = r7
            r0.label = r3
            java.lang.Object r9 = kotlinx.coroutines.DelayKt.delay(r4, r0)
            if (r9 != r1) goto L_0x0079
            return r1
        L_0x0079:
            int r7 = r7 - r3
            goto L_0x0040
        L_0x007b:
            kotlin.NoWhenBranchMatchedException r7 = new kotlin.NoWhenBranchMatchedException
            r7.<init>()
            throw r7
        L_0x0081:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "User must be set before querying channels"
            java.lang.String r8 = r8.toString()
            r7.<init>(r8)
            java.lang.Throwable r7 = (java.lang.Throwable) r7
            throw r7
        L_0x008f:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "Failed to perform job. Waiting for set user completion was too long. Limit of attempts was reached."
            java.lang.String r8 = r8.toString()
            r7.<init>(r8)
            java.lang.Throwable r7 = (java.lang.Throwable) r7
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: p015io.getstream.chat.android.client.helpers.QueryChannelsPostponeHelper.doJob(int, kotlin.jvm.functions.Function0, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, mo26107d2 = {"Lio/getstream/chat/android/client/helpers/QueryChannelsPostponeHelper$Companion;", "", "()V", "DELAY_DURATION", "", "MAX_ATTEMPTS_COUNT", "", "MAX_DURATION", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: io.getstream.chat.android.client.helpers.QueryChannelsPostponeHelper$Companion */
    /* compiled from: QueryChannelsPostponeHelper.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        long millis = TimeUnit.SECONDS.toMillis(5);
        MAX_DURATION = millis;
        MAX_ATTEMPTS_COUNT = (int) (millis / 200);
    }
}
