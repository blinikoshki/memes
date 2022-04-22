package com.memes.chat.p036ui.channel.create.stages.memberselection;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H@¢\u0006\u0004\b\u0003\u0010\u0004"}, mo26107d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, mo26108k = 3, mo26109mv = {1, 4, 2})
@DebugMetadata(mo26807c = "com.memes.chat.ui.channel.create.stages.memberselection.ChooseChannelMembersViewModel$searchUsers$1", mo26808f = "ChooseChannelMembersViewModel.kt", mo26809i = {0}, mo26810l = {115}, mo26811m = "invokeSuspend", mo26812n = {"currentPage"}, mo26813s = {"I$0"})
/* renamed from: com.memes.chat.ui.channel.create.stages.memberselection.ChooseChannelMembersViewModel$searchUsers$1 */
/* compiled from: ChooseChannelMembersViewModel.kt */
final class ChooseChannelMembersViewModel$searchUsers$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $query;
    int I$0;
    int label;
    final /* synthetic */ ChooseChannelMembersViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChooseChannelMembersViewModel$searchUsers$1(ChooseChannelMembersViewModel chooseChannelMembersViewModel, String str, Continuation continuation) {
        super(2, continuation);
        this.this$0 = chooseChannelMembersViewModel;
        this.$query = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        return new ChooseChannelMembersViewModel$searchUsers$1(this.this$0, this.$query, continuation);
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((ChooseChannelMembersViewModel$searchUsers$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0026, code lost:
        r13 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r13.getCurrentPage());
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r13) {
        /*
            r12 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r12.label
            r2 = 2
            r3 = 1
            r4 = 0
            if (r1 == 0) goto L_0x001b
            if (r1 != r3) goto L_0x0013
            int r0 = r12.I$0
            kotlin.ResultKt.throwOnFailure(r13)
            goto L_0x0063
        L_0x0013:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r0)
            throw r13
        L_0x001b:
            kotlin.ResultKt.throwOnFailure(r13)
            com.memes.chat.ui.channel.create.stages.memberselection.ChooseChannelMembersViewModel r13 = r12.this$0
            com.memes.network.core.pagination.PageBasedPaginationInfo r13 = r13.userSearchResultsPagination
            if (r13 == 0) goto L_0x0035
            int r13 = r13.getCurrentPage()
            java.lang.Integer r13 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r13)
            if (r13 == 0) goto L_0x0035
            int r13 = r13.intValue()
            goto L_0x0036
        L_0x0035:
            r13 = 0
        L_0x0036:
            if (r13 != 0) goto L_0x0043
            com.memes.chat.ui.channel.create.stages.memberselection.ChooseChannelMembersViewModel r1 = r12.this$0
            com.memes.commons.util.SingleLiveEvent r5 = r1._userSearchResultsState
            androidx.lifecycle.MutableLiveData r5 = (androidx.lifecycle.MutableLiveData) r5
            com.memes.commons.viewmodel.BaseViewModel.showProgress$default(r1, r5, r4, r2, r4)
        L_0x0043:
            com.memes.network.memes.source.remote.model.usersearch.UserSearchRequest r1 = new com.memes.network.memes.source.remote.model.usersearch.UserSearchRequest
            java.lang.String r7 = r12.$query
            r8 = 0
            int r9 = r13 + 1
            r10 = 2
            r11 = 0
            r6 = r1
            r6.<init>(r7, r8, r9, r10, r11)
            com.memes.chat.ui.channel.create.stages.memberselection.ChooseChannelMembersViewModel r5 = r12.this$0
            com.memes.network.memes.api.MemesDataSource r5 = r5.memesDataSource
            r12.I$0 = r13
            r12.label = r3
            java.lang.Object r1 = r5.searchUsers(r1, r12)
            if (r1 != r0) goto L_0x0061
            return r0
        L_0x0061:
            r0 = r13
            r13 = r1
        L_0x0063:
            com.memes.network.core.UniversalResult r13 = (com.memes.network.core.UniversalResult) r13
            com.memes.chat.ui.channel.create.stages.memberselection.ChooseChannelMembersViewModel r1 = r12.this$0
            r1.notifyPaginationLoadingStopped()
            boolean r1 = r13.isError()
            if (r1 == 0) goto L_0x009a
            boolean r0 = r13.isSessionExpired()
            if (r0 == 0) goto L_0x0088
            com.memes.chat.ui.channel.create.stages.memberselection.ChooseChannelMembersViewModel r0 = r12.this$0
            com.memes.commons.util.SingleLiveEvent r1 = r0._userSearchResultsState
            androidx.lifecycle.MutableLiveData r1 = (androidx.lifecycle.MutableLiveData) r1
            java.lang.String r13 = r13.getMessage()
            r0.showLoginError(r1, r13)
            kotlin.Unit r13 = kotlin.Unit.INSTANCE
            return r13
        L_0x0088:
            com.memes.chat.ui.channel.create.stages.memberselection.ChooseChannelMembersViewModel r0 = r12.this$0
            com.memes.commons.util.SingleLiveEvent r1 = r0._userSearchResultsState
            androidx.lifecycle.MutableLiveData r1 = (androidx.lifecycle.MutableLiveData) r1
            java.lang.String r13 = r13.getMessage()
            r0.showError(r1, r13)
            kotlin.Unit r13 = kotlin.Unit.INSTANCE
            return r13
        L_0x009a:
            boolean r1 = r13.hasNoItems()
            if (r1 == 0) goto L_0x00ae
            com.memes.chat.ui.channel.create.stages.memberselection.ChooseChannelMembersViewModel r13 = r12.this$0
            com.memes.commons.util.SingleLiveEvent r0 = r13._userSearchResultsState
            androidx.lifecycle.MutableLiveData r0 = (androidx.lifecycle.MutableLiveData) r0
            com.memes.commons.viewmodel.BaseViewModel.showContentNotAvailable$default(r13, r0, r4, r2, r4)
            kotlin.Unit r13 = kotlin.Unit.INSTANCE
            return r13
        L_0x00ae:
            java.util.List r1 = r13.requireItems()
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.ArrayList r5 = new java.util.ArrayList
            r5.<init>()
            java.util.Collection r5 = (java.util.Collection) r5
            java.util.Iterator r1 = r1.iterator()
        L_0x00bf:
            boolean r6 = r1.hasNext()
            if (r6 == 0) goto L_0x00e5
            java.lang.Object r6 = r1.next()
            r7 = r6
            com.memes.network.memes.source.remote.model.usersearch.UserSearchResult r7 = (com.memes.network.memes.source.remote.model.usersearch.UserSearchResult) r7
            com.memes.network.memes.MemesSession r8 = com.memes.network.memes.MemesSession.INSTANCE
            java.lang.String r7 = r7.chatUserId()
            boolean r7 = r8.isOf(r7)
            r7 = r7 ^ r3
            java.lang.Boolean r7 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r7)
            boolean r7 = r7.booleanValue()
            if (r7 == 0) goto L_0x00bf
            r5.add(r6)
            goto L_0x00bf
        L_0x00e5:
            java.util.List r5 = (java.util.List) r5
            boolean r1 = r5.isEmpty()
            if (r1 == 0) goto L_0x00fb
            com.memes.chat.ui.channel.create.stages.memberselection.ChooseChannelMembersViewModel r13 = r12.this$0
            com.memes.commons.util.SingleLiveEvent r0 = r13._userSearchResultsState
            androidx.lifecycle.MutableLiveData r0 = (androidx.lifecycle.MutableLiveData) r0
            com.memes.commons.viewmodel.BaseViewModel.showContentNotAvailable$default(r13, r0, r4, r2, r4)
            kotlin.Unit r13 = kotlin.Unit.INSTANCE
            return r13
        L_0x00fb:
            com.memes.chat.ui.channel.create.stages.memberselection.ChooseChannelMembersViewModel r1 = r12.this$0
            com.memes.commons.util.SingleLiveEvent r1 = r1._userSearchResults
            com.memes.commons.recycleradapter.AdapterUpdate r2 = new com.memes.commons.recycleradapter.AdapterUpdate
            r2.<init>(r0, r5)
            r1.setValue(r2)
            com.memes.chat.ui.channel.create.stages.memberselection.ChooseChannelMembersViewModel r0 = r12.this$0
            com.memes.network.core.pagination.PaginationInfo r13 = r13.getPagination()
            java.lang.String r1 = "null cannot be cast to non-null type com.memes.network.core.pagination.PageBasedPaginationInfo"
            java.util.Objects.requireNonNull(r13, r1)
            com.memes.network.core.pagination.PageBasedPaginationInfo r13 = (com.memes.network.core.pagination.PageBasedPaginationInfo) r13
            r0.userSearchResultsPagination = r13
            com.memes.chat.ui.channel.create.stages.memberselection.ChooseChannelMembersViewModel r13 = r12.this$0
            com.memes.commons.util.SingleLiveEvent r0 = r13._userSearchResultsState
            androidx.lifecycle.MutableLiveData r0 = (androidx.lifecycle.MutableLiveData) r0
            r13.showContent(r0)
            kotlin.Unit r13 = kotlin.Unit.INSTANCE
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.memes.chat.p036ui.channel.create.stages.memberselection.ChooseChannelMembersViewModel$searchUsers$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
