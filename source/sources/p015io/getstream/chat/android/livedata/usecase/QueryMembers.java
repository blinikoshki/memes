package p015io.getstream.chat.android.livedata.usecase;

import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.api.models.QuerySort;
import p015io.getstream.chat.android.client.call.Call;
import p015io.getstream.chat.android.client.call.CoroutineCall;
import p015io.getstream.chat.android.client.models.Member;
import p015io.getstream.chat.android.client.models.ModelFields;
import p015io.getstream.chat.android.client.utils.FilterObject;
import p015io.getstream.chat.android.livedata.ChatDomainImpl;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J[\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00062\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\u00112\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0002JC\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00142\u0006\u0010\t\u001a\u00020\n2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\u00112\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH@ø\u0001\u0000¢\u0006\u0002\u0010\u0015JY\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u00142\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H@ø\u0001\u0000¢\u0006\u0002\u0010\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0018"}, mo26107d2 = {"Lio/getstream/chat/android/livedata/usecase/QueryMembers;", "", "domainImpl", "Lio/getstream/chat/android/livedata/ChatDomainImpl;", "(Lio/getstream/chat/android/livedata/ChatDomainImpl;)V", "invoke", "Lio/getstream/chat/android/client/call/Call;", "", "Lio/getstream/chat/android/client/models/Member;", "cid", "", "offset", "", "limit", "filter", "Lio/getstream/chat/android/client/utils/FilterObject;", "sort", "Lio/getstream/chat/android/client/api/models/QuerySort;", "members", "queryMembersOffline", "Lio/getstream/chat/android/client/utils/Result;", "(Ljava/lang/String;Lio/getstream/chat/android/client/api/models/QuerySort;IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "queryMembersOnline", "(Ljava/lang/String;IILio/getstream/chat/android/client/utils/FilterObject;Lio/getstream/chat/android/client/api/models/QuerySort;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "stream-chat-android-offline_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.livedata.usecase.QueryMembers */
/* compiled from: QueryMembers.kt */
public final class QueryMembers {
    /* access modifiers changed from: private */
    public final ChatDomainImpl domainImpl;

    public QueryMembers(ChatDomainImpl chatDomainImpl) {
        Intrinsics.checkNotNullParameter(chatDomainImpl, "domainImpl");
        this.domainImpl = chatDomainImpl;
    }

    public static /* synthetic */ Call invoke$default(QueryMembers queryMembers, String str, int i, int i2, FilterObject filterObject, QuerySort querySort, List list, int i3, Object obj) {
        int i4 = 0;
        int i5 = (i3 & 2) != 0 ? 0 : i;
        if ((i3 & 4) == 0) {
            i4 = i2;
        }
        return queryMembers.invoke(str, i5, i4, (i3 & 8) != 0 ? new FilterObject((Map) null, 1, (DefaultConstructorMarker) null) : filterObject, (i3 & 16) != 0 ? QuerySort.Companion.desc(QueryMembers$invoke$1.INSTANCE) : querySort, (i3 & 32) != 0 ? CollectionsKt.emptyList() : list);
    }

    public final Call<List<Member>> invoke(String str, int i, int i2, FilterObject filterObject, QuerySort<Member> querySort, List<Member> list) {
        Intrinsics.checkNotNullParameter(str, "cid");
        FilterObject filterObject2 = filterObject;
        Intrinsics.checkNotNullParameter(filterObject2, "filter");
        QuerySort<Member> querySort2 = querySort;
        Intrinsics.checkNotNullParameter(querySort2, "sort");
        List<Member> list2 = list;
        Intrinsics.checkNotNullParameter(list2, ModelFields.MEMBERS);
        return new CoroutineCall<>(this.domainImpl.getScope$stream_chat_android_offline_release(), new QueryMembers$invoke$2(this, str, querySort2, i, i2, filterObject2, list2, (Continuation) null));
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x007a  */
    /* JADX WARNING: Removed duplicated region for block: B:26:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0029  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ java.lang.Object queryMembersOnline(java.lang.String r15, int r16, int r17, p015io.getstream.chat.android.client.utils.FilterObject r18, p015io.getstream.chat.android.client.api.models.QuerySort<p015io.getstream.chat.android.client.models.Member> r19, java.util.List<p015io.getstream.chat.android.client.models.Member> r20, kotlin.coroutines.Continuation<? super p015io.getstream.chat.android.client.utils.Result<java.util.List<p015io.getstream.chat.android.client.models.Member>>> r21) {
        /*
            r14 = this;
            r0 = r14
            r1 = r15
            r2 = r21
            boolean r3 = r2 instanceof p015io.getstream.chat.android.livedata.usecase.QueryMembers$queryMembersOnline$1
            if (r3 == 0) goto L_0x0018
            r3 = r2
            io.getstream.chat.android.livedata.usecase.QueryMembers$queryMembersOnline$1 r3 = (p015io.getstream.chat.android.livedata.usecase.QueryMembers$queryMembersOnline$1) r3
            int r4 = r3.label
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r4 & r5
            if (r4 == 0) goto L_0x0018
            int r2 = r3.label
            int r2 = r2 - r5
            r3.label = r2
            goto L_0x001d
        L_0x0018:
            io.getstream.chat.android.livedata.usecase.QueryMembers$queryMembersOnline$1 r3 = new io.getstream.chat.android.livedata.usecase.QueryMembers$queryMembersOnline$1
            r3.<init>(r14, r2)
        L_0x001d:
            java.lang.Object r2 = r3.result
            java.lang.Object r4 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r5 = r3.label
            r6 = 2
            r7 = 1
            if (r5 == 0) goto L_0x0049
            if (r5 == r7) goto L_0x003d
            if (r5 != r6) goto L_0x0035
            java.lang.Object r1 = r3.L$0
            io.getstream.chat.android.client.utils.Result r1 = (p015io.getstream.chat.android.client.utils.Result) r1
            kotlin.ResultKt.throwOnFailure(r2)
            goto L_0x0095
        L_0x0035:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x003d:
            java.lang.Object r1 = r3.L$1
            java.lang.String r1 = (java.lang.String) r1
            java.lang.Object r5 = r3.L$0
            io.getstream.chat.android.livedata.usecase.QueryMembers r5 = (p015io.getstream.chat.android.livedata.usecase.QueryMembers) r5
            kotlin.ResultKt.throwOnFailure(r2)
            goto L_0x0072
        L_0x0049:
            kotlin.ResultKt.throwOnFailure(r2)
            io.getstream.chat.android.livedata.ChatDomainImpl r2 = r0.domainImpl
            io.getstream.chat.android.client.ChatClient r2 = r2.getClient$stream_chat_android_offline_release()
            io.getstream.chat.android.client.channel.ChannelClient r8 = r2.channel(r15)
            r9 = r16
            r10 = r17
            r11 = r18
            r12 = r19
            r13 = r20
            io.getstream.chat.android.client.call.Call r2 = r8.queryMembers(r9, r10, r11, r12, r13)
            r3.L$0 = r0
            r3.L$1 = r1
            r3.label = r7
            java.lang.Object r2 = p015io.getstream.chat.android.client.call.CallKt.await(r2, r3)
            if (r2 != r4) goto L_0x0071
            return r4
        L_0x0071:
            r5 = r0
        L_0x0072:
            io.getstream.chat.android.client.utils.Result r2 = (p015io.getstream.chat.android.client.utils.Result) r2
            boolean r7 = r2.isSuccess()
            if (r7 == 0) goto L_0x0096
            io.getstream.chat.android.livedata.ChatDomainImpl r5 = r5.domainImpl
            io.getstream.chat.android.livedata.repository.RepositoryFacade r5 = r5.getRepos$stream_chat_android_offline_release()
            java.lang.Object r7 = r2.data()
            java.util.List r7 = (java.util.List) r7
            r3.L$0 = r2
            r8 = 0
            r3.L$1 = r8
            r3.label = r6
            java.lang.Object r1 = r5.updateMembersForChannel(r1, r7, r3)
            if (r1 != r4) goto L_0x0094
            return r4
        L_0x0094:
            r1 = r2
        L_0x0095:
            r2 = r1
        L_0x0096:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: p015io.getstream.chat.android.livedata.usecase.QueryMembers.queryMembersOnline(java.lang.String, int, int, io.getstream.chat.android.client.utils.FilterObject, io.getstream.chat.android.client.api.models.QuerySort, java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ java.lang.Object queryMembersOffline(java.lang.String r6, p015io.getstream.chat.android.client.api.models.QuerySort<p015io.getstream.chat.android.client.models.Member> r7, int r8, int r9, kotlin.coroutines.Continuation<? super p015io.getstream.chat.android.client.utils.Result<java.util.List<p015io.getstream.chat.android.client.models.Member>>> r10) {
        /*
            r5 = this;
            boolean r0 = r10 instanceof p015io.getstream.chat.android.livedata.usecase.QueryMembers$queryMembersOffline$1
            if (r0 == 0) goto L_0x0014
            r0 = r10
            io.getstream.chat.android.livedata.usecase.QueryMembers$queryMembersOffline$1 r0 = (p015io.getstream.chat.android.livedata.usecase.QueryMembers$queryMembersOffline$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r10 = r0.label
            int r10 = r10 - r2
            r0.label = r10
            goto L_0x0019
        L_0x0014:
            io.getstream.chat.android.livedata.usecase.QueryMembers$queryMembersOffline$1 r0 = new io.getstream.chat.android.livedata.usecase.QueryMembers$queryMembersOffline$1
            r0.<init>(r5, r10)
        L_0x0019:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x003d
            if (r2 != r3) goto L_0x0035
            int r6 = r0.I$1
            int r7 = r0.I$0
            java.lang.Object r8 = r0.L$0
            io.getstream.chat.android.client.api.models.QuerySort r8 = (p015io.getstream.chat.android.client.api.models.QuerySort) r8
            kotlin.ResultKt.throwOnFailure(r10)
            r4 = r8
            r8 = r7
            r7 = r4
            goto L_0x005f
        L_0x0035:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x003d:
            kotlin.ResultKt.throwOnFailure(r10)
            r10 = 0
            int r8 = kotlin.ranges.RangesKt.coerceAtLeast((int) r8, (int) r10)
            int r9 = kotlin.ranges.RangesKt.coerceAtLeast((int) r9, (int) r10)
            io.getstream.chat.android.livedata.ChatDomainImpl r10 = r5.domainImpl
            io.getstream.chat.android.livedata.repository.RepositoryFacade r10 = r10.getRepos$stream_chat_android_offline_release()
            r0.L$0 = r7
            r0.I$0 = r8
            r0.I$1 = r9
            r0.label = r3
            java.lang.Object r10 = r10.selectMembersForChannel(r6, r0)
            if (r10 != r1) goto L_0x005e
            return r1
        L_0x005e:
            r6 = r9
        L_0x005f:
            java.lang.Iterable r10 = (java.lang.Iterable) r10
            java.util.Comparator r7 = r7.getComparator()
            java.util.List r7 = kotlin.collections.CollectionsKt.sortedWith(r10, r7)
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            java.util.List r7 = kotlin.collections.CollectionsKt.drop(r7, r8)
            if (r6 <= 0) goto L_0x0077
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            java.util.List r7 = kotlin.collections.CollectionsKt.take(r7, r6)
        L_0x0077:
            io.getstream.chat.android.client.utils.Result r6 = new io.getstream.chat.android.client.utils.Result
            r6.<init>(r7)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: p015io.getstream.chat.android.livedata.usecase.QueryMembers.queryMembersOffline(java.lang.String, io.getstream.chat.android.client.api.models.QuerySort, int, int, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
