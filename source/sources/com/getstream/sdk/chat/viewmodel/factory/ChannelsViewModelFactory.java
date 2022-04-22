package com.getstream.sdk.chat.viewmodel.factory;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.getstream.sdk.chat.viewmodel.channels.ChannelsViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.api.models.QuerySort;
import p015io.getstream.chat.android.client.models.Channel;
import p015io.getstream.chat.android.client.utils.FilterObject;
import p015io.getstream.chat.android.livedata.ChatDomain;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B+\b\u0007\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ%\u0010\n\u001a\u0002H\u000b\"\b\b\u0000\u0010\u000b*\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u000eH\u0016¢\u0006\u0002\u0010\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, mo26107d2 = {"Lcom/getstream/sdk/chat/viewmodel/factory/ChannelsViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "filter", "Lio/getstream/chat/android/client/utils/FilterObject;", "sort", "Lio/getstream/chat/android/client/api/models/QuerySort;", "Lio/getstream/chat/android/client/models/Channel;", "limit", "", "(Lio/getstream/chat/android/client/utils/FilterObject;Lio/getstream/chat/android/client/api/models/QuerySort;I)V", "create", "T", "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "stream-chat-android_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: ChannelsViewModelFactory.kt */
public final class ChannelsViewModelFactory implements ViewModelProvider.Factory {
    private final FilterObject filter;
    private final int limit;
    private final QuerySort<Channel> sort;

    public ChannelsViewModelFactory() {
        this((FilterObject) null, (QuerySort) null, 0, 7, (DefaultConstructorMarker) null);
    }

    public ChannelsViewModelFactory(FilterObject filterObject) {
        this(filterObject, (QuerySort) null, 0, 6, (DefaultConstructorMarker) null);
    }

    public ChannelsViewModelFactory(FilterObject filterObject, QuerySort<Channel> querySort) {
        this(filterObject, querySort, 0, 4, (DefaultConstructorMarker) null);
    }

    public ChannelsViewModelFactory(FilterObject filterObject, QuerySort<Channel> querySort, int i) {
        Intrinsics.checkNotNullParameter(filterObject, "filter");
        Intrinsics.checkNotNullParameter(querySort, "sort");
        this.filter = filterObject;
        this.sort = querySort;
        this.limit = i;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ ChannelsViewModelFactory(p015io.getstream.chat.android.client.utils.FilterObject r3, p015io.getstream.chat.android.client.api.models.QuerySort<p015io.getstream.chat.android.client.models.Channel> r4, int r5, int r6, kotlin.jvm.internal.DefaultConstructorMarker r7) {
        /*
            r2 = this;
            r7 = r6 & 1
            if (r7 == 0) goto L_0x003f
            r3 = 3
            io.getstream.chat.android.client.utils.FilterObject[] r3 = new p015io.getstream.chat.android.client.utils.FilterObject[r3]
            r7 = 0
            java.lang.String r0 = "type"
            java.lang.String r1 = "messaging"
            io.getstream.chat.android.client.utils.FilterObject r0 = p015io.getstream.chat.android.client.models.Filters.m1007eq(r0, r1)
            r3[r7] = r0
            io.getstream.chat.android.livedata.ChatDomain$Companion r7 = p015io.getstream.chat.android.livedata.ChatDomain.Companion
            io.getstream.chat.android.livedata.ChatDomain r7 = r7.instance()
            io.getstream.chat.android.client.models.User r7 = r7.getCurrentUser()
            java.lang.String r7 = r7.getId()
            java.util.List r7 = kotlin.collections.CollectionsKt.listOf(r7)
            java.lang.String r0 = "members"
            io.getstream.chat.android.client.utils.FilterObject r7 = p015io.getstream.chat.android.client.models.Filters.m1008in((java.lang.String) r0, (java.util.List<?>) r7)
            r0 = 1
            r3[r0] = r7
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r0)
            java.lang.String r0 = "draft"
            io.getstream.chat.android.client.utils.FilterObject r7 = p015io.getstream.chat.android.client.models.Filters.m1011ne(r0, r7)
            r0 = 2
            r3[r0] = r7
            io.getstream.chat.android.client.utils.FilterObject r3 = p015io.getstream.chat.android.client.models.Filters.and(r3)
        L_0x003f:
            r7 = r6 & 2
            if (r7 == 0) goto L_0x0045
            io.getstream.chat.android.client.api.models.QuerySort<io.getstream.chat.android.client.models.Channel> r4 = com.getstream.sdk.chat.viewmodel.channels.ChannelsViewModel.DEFAULT_SORT
        L_0x0045:
            r6 = r6 & 4
            if (r6 == 0) goto L_0x004b
            r5 = 30
        L_0x004b:
            r2.<init>(r3, r4, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.getstream.sdk.chat.viewmodel.factory.ChannelsViewModelFactory.<init>(io.getstream.chat.android.client.utils.FilterObject, io.getstream.chat.android.client.api.models.QuerySort, int, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public <T extends ViewModel> T create(Class<T> cls) {
        Intrinsics.checkNotNullParameter(cls, "modelClass");
        if (Intrinsics.areEqual((Object) cls, (Object) ChannelsViewModel.class)) {
            return (ViewModel) new ChannelsViewModel(ChatDomain.Companion.instance(), this.filter, this.sort, this.limit);
        }
        throw new IllegalArgumentException("ChannelsViewModelFactory can only create instances of ChannelsViewModel".toString());
    }
}
