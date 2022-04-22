package p015io.getstream.chat.android.livedata.usecase;

import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.api.models.QuerySort;
import p015io.getstream.chat.android.client.call.Call;
import p015io.getstream.chat.android.client.call.CoroutineCall;
import p015io.getstream.chat.android.client.models.User;
import p015io.getstream.chat.android.client.utils.FilterObject;
import p015io.getstream.chat.android.livedata.ChatDomainImpl;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J5\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\u000e2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J5\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\u00192\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H@ø\u0001\u0000¢\u0006\u0002\u0010\u001aJ=\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\u00192\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u0017H@ø\u0001\u0000¢\u0006\u0002\u0010\u001cR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R!\u0010\u0005\u001a\u00020\u00068@X\u0002¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\u0002\u0004\n\u0002\b\u0019¨\u0006\u001e"}, mo26107d2 = {"Lio/getstream/chat/android/livedata/usecase/SearchUsersByName;", "", "chatDomainImpl", "Lio/getstream/chat/android/livedata/ChatDomainImpl;", "(Lio/getstream/chat/android/livedata/ChatDomainImpl;)V", "defaultUsersQueryFilter", "Lio/getstream/chat/android/client/utils/FilterObject;", "getDefaultUsersQueryFilter$stream_chat_android_offline_release$annotations", "()V", "getDefaultUsersQueryFilter$stream_chat_android_offline_release", "()Lio/getstream/chat/android/client/utils/FilterObject;", "defaultUsersQueryFilter$delegate", "Lkotlin/Lazy;", "invoke", "Lio/getstream/chat/android/client/call/Call;", "", "Lio/getstream/chat/android/client/models/User;", "querySearch", "", "offset", "", "userLimit", "userPresence", "", "performOfflineSearch", "Lio/getstream/chat/android/client/utils/Result;", "(Ljava/lang/String;IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "performOnlineSearch", "(Ljava/lang/String;IIZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "stream-chat-android-offline_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.livedata.usecase.SearchUsersByName */
/* compiled from: SearchUsersByName.kt */
public final class SearchUsersByName {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String FIELD_ID = "id";
    public static final String FIELD_NAME = "name";
    private static final QuerySort<User> USERS_QUERY_SORT = QuerySort.Companion.asc(SearchUsersByName$Companion$USERS_QUERY_SORT$1.INSTANCE);
    /* access modifiers changed from: private */
    public final ChatDomainImpl chatDomainImpl;
    private final Lazy defaultUsersQueryFilter$delegate = LazyKt.lazy(new SearchUsersByName$defaultUsersQueryFilter$2(this));

    /* renamed from: getDefaultUsersQueryFilter$stream_chat_android_offline_release$annotations */
    public static /* synthetic */ void m1023xa1ad7d12() {
    }

    public final FilterObject getDefaultUsersQueryFilter$stream_chat_android_offline_release() {
        return (FilterObject) this.defaultUsersQueryFilter$delegate.getValue();
    }

    public SearchUsersByName(ChatDomainImpl chatDomainImpl2) {
        Intrinsics.checkNotNullParameter(chatDomainImpl2, "chatDomainImpl");
        this.chatDomainImpl = chatDomainImpl2;
    }

    public final Call<List<User>> invoke(String str, int i, int i2, boolean z) {
        Intrinsics.checkNotNullParameter(str, "querySearch");
        return new CoroutineCall<>(this.chatDomainImpl.getScope$stream_chat_android_offline_release(), new SearchUsersByName$invoke$1(this, str, i, i2, z, (Continuation) null));
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ java.lang.Object performOfflineSearch(java.lang.String r6, int r7, int r8, kotlin.coroutines.Continuation<? super p015io.getstream.chat.android.client.utils.Result<java.util.List<p015io.getstream.chat.android.client.models.User>>> r9) {
        /*
            r5 = this;
            boolean r0 = r9 instanceof p015io.getstream.chat.android.livedata.usecase.SearchUsersByName$performOfflineSearch$1
            if (r0 == 0) goto L_0x0014
            r0 = r9
            io.getstream.chat.android.livedata.usecase.SearchUsersByName$performOfflineSearch$1 r0 = (p015io.getstream.chat.android.livedata.usecase.SearchUsersByName$performOfflineSearch$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L_0x0019
        L_0x0014:
            io.getstream.chat.android.livedata.usecase.SearchUsersByName$performOfflineSearch$1 r0 = new io.getstream.chat.android.livedata.usecase.SearchUsersByName$performOfflineSearch$1
            r0.<init>(r5, r9)
        L_0x0019:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0039
            if (r2 == r4) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x006e
        L_0x002d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0035:
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x0059
        L_0x0039:
            kotlin.ResultKt.throwOnFailure(r9)
            r9 = r6
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            int r9 = r9.length()
            if (r9 != 0) goto L_0x0047
            r9 = 1
            goto L_0x0048
        L_0x0047:
            r9 = 0
        L_0x0048:
            if (r9 == 0) goto L_0x005f
            io.getstream.chat.android.livedata.ChatDomainImpl r6 = r5.chatDomainImpl
            io.getstream.chat.android.livedata.repository.RepositoryFacade r6 = r6.getRepos$stream_chat_android_offline_release()
            r0.label = r4
            java.lang.Object r9 = r6.selectAllUsers(r8, r7, r0)
            if (r9 != r1) goto L_0x0059
            return r1
        L_0x0059:
            io.getstream.chat.android.client.utils.Result r6 = new io.getstream.chat.android.client.utils.Result
            r6.<init>(r9)
            goto L_0x0073
        L_0x005f:
            io.getstream.chat.android.livedata.ChatDomainImpl r9 = r5.chatDomainImpl
            io.getstream.chat.android.livedata.repository.RepositoryFacade r9 = r9.getRepos$stream_chat_android_offline_release()
            r0.label = r3
            java.lang.Object r9 = r9.selectUsersLikeName(r6, r8, r7, r0)
            if (r9 != r1) goto L_0x006e
            return r1
        L_0x006e:
            io.getstream.chat.android.client.utils.Result r6 = new io.getstream.chat.android.client.utils.Result
            r6.<init>(r9)
        L_0x0073:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: p015io.getstream.chat.android.livedata.usecase.SearchUsersByName.performOfflineSearch(java.lang.String, int, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ java.lang.Object performOnlineSearch(java.lang.String r11, int r12, int r13, boolean r14, kotlin.coroutines.Continuation<? super p015io.getstream.chat.android.client.utils.Result<java.util.List<p015io.getstream.chat.android.client.models.User>>> r15) {
        /*
            r10 = this;
            boolean r0 = r15 instanceof p015io.getstream.chat.android.livedata.usecase.SearchUsersByName$performOnlineSearch$1
            if (r0 == 0) goto L_0x0014
            r0 = r15
            io.getstream.chat.android.livedata.usecase.SearchUsersByName$performOnlineSearch$1 r0 = (p015io.getstream.chat.android.livedata.usecase.SearchUsersByName$performOnlineSearch$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r15 = r0.label
            int r15 = r15 - r2
            r0.label = r15
            goto L_0x0019
        L_0x0014:
            io.getstream.chat.android.livedata.usecase.SearchUsersByName$performOnlineSearch$1 r0 = new io.getstream.chat.android.livedata.usecase.SearchUsersByName$performOnlineSearch$1
            r0.<init>(r10, r15)
        L_0x0019:
            java.lang.Object r15 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0037
            if (r2 != r3) goto L_0x002f
            java.lang.Object r11 = r0.L$0
            io.getstream.chat.android.client.utils.Result r11 = (p015io.getstream.chat.android.client.utils.Result) r11
            kotlin.ResultKt.throwOnFailure(r15)
            goto L_0x00b3
        L_0x002f:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r12)
            throw r11
        L_0x0037:
            kotlin.ResultKt.throwOnFailure(r15)
            r15 = r11
            java.lang.CharSequence r15 = (java.lang.CharSequence) r15
            int r15 = r15.length()
            r2 = 0
            if (r15 != 0) goto L_0x0046
            r15 = 1
            goto L_0x0047
        L_0x0046:
            r15 = 0
        L_0x0047:
            if (r15 == 0) goto L_0x004e
            io.getstream.chat.android.client.utils.FilterObject r11 = r10.getDefaultUsersQueryFilter$stream_chat_android_offline_release()
            goto L_0x006f
        L_0x004e:
            r15 = 2
            io.getstream.chat.android.client.utils.FilterObject[] r15 = new p015io.getstream.chat.android.client.utils.FilterObject[r15]
            java.lang.String r4 = "name"
            io.getstream.chat.android.client.utils.FilterObject r11 = p015io.getstream.chat.android.client.models.Filters.autocomplete(r4, r11)
            r15[r2] = r11
            io.getstream.chat.android.livedata.ChatDomainImpl r11 = r10.chatDomainImpl
            io.getstream.chat.android.client.models.User r11 = r11.getCurrentUser()
            java.lang.String r11 = r11.getId()
            java.lang.String r2 = "id"
            io.getstream.chat.android.client.utils.FilterObject r11 = p015io.getstream.chat.android.client.models.Filters.m1011ne(r2, r11)
            r15[r3] = r11
            io.getstream.chat.android.client.utils.FilterObject r11 = p015io.getstream.chat.android.client.models.Filters.and(r15)
        L_0x006f:
            r5 = r11
            io.getstream.chat.android.livedata.ChatDomainImpl r11 = r10.chatDomainImpl
            io.getstream.chat.android.client.ChatClient r11 = r11.getClient$stream_chat_android_offline_release()
            io.getstream.chat.android.client.api.models.QueryUsersRequest r15 = new io.getstream.chat.android.client.api.models.QueryUsersRequest
            io.getstream.chat.android.client.api.models.QuerySort<io.getstream.chat.android.client.models.User> r8 = USERS_QUERY_SORT
            r4 = r15
            r6 = r12
            r7 = r13
            r9 = r14
            r4.<init>(r5, r6, r7, r8, r9)
            io.getstream.chat.android.client.call.Call r11 = r11.queryUsers(r15)
            io.getstream.chat.android.client.utils.Result r11 = r11.execute()
            boolean r12 = r11.isSuccess()
            if (r12 == 0) goto L_0x00b3
            java.lang.Object r12 = r11.data()
            java.util.Collection r12 = (java.util.Collection) r12
            boolean r12 = r12.isEmpty()
            r12 = r12 ^ r3
            if (r12 == 0) goto L_0x00b3
            io.getstream.chat.android.livedata.ChatDomainImpl r12 = r10.chatDomainImpl
            io.getstream.chat.android.livedata.repository.RepositoryFacade r12 = r12.getRepos$stream_chat_android_offline_release()
            java.lang.Object r13 = r11.data()
            java.util.Collection r13 = (java.util.Collection) r13
            r0.L$0 = r11
            r0.label = r3
            java.lang.Object r12 = r12.insertUsers(r13, r0)
            if (r12 != r1) goto L_0x00b3
            return r1
        L_0x00b3:
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: p015io.getstream.chat.android.livedata.usecase.SearchUsersByName.performOnlineSearch(java.lang.String, int, int, boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\u00020\u00048\u0000XT¢\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0002R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, mo26107d2 = {"Lio/getstream/chat/android/livedata/usecase/SearchUsersByName$Companion;", "", "()V", "FIELD_ID", "", "FIELD_NAME", "getFIELD_NAME$stream_chat_android_offline_release$annotations", "USERS_QUERY_SORT", "Lio/getstream/chat/android/client/api/models/QuerySort;", "Lio/getstream/chat/android/client/models/User;", "stream-chat-android-offline_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: io.getstream.chat.android.livedata.usecase.SearchUsersByName$Companion */
    /* compiled from: SearchUsersByName.kt */
    public static final class Companion {
        public static /* synthetic */ void getFIELD_NAME$stream_chat_android_offline_release$annotations() {
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
