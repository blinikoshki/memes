package p015io.getstream.chat.android.livedata.controller;

import androidx.lifecycle.LiveData;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.api.models.QuerySort;
import p015io.getstream.chat.android.client.models.Channel;
import p015io.getstream.chat.android.client.utils.FilterObject;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001#R\u001e\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u0007R\u0018\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u0007R\u0012\u0010\u000e\u001a\u00020\u000fX¦\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\f0\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0007R\u0018\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\f0\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0007R*\u0010\u0016\u001a\u0014\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\f0\u0017X¦\u000e¢\u0006\f\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0012\u0010\u001c\u001a\u00020\fX¦\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0018\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00050 X¦\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"¨\u0006$"}, mo26107d2 = {"Lio/getstream/chat/android/livedata/controller/QueryChannelsController;", "", "channels", "Landroidx/lifecycle/LiveData;", "", "Lio/getstream/chat/android/client/models/Channel;", "getChannels", "()Landroidx/lifecycle/LiveData;", "channelsState", "Lio/getstream/chat/android/livedata/controller/QueryChannelsController$ChannelsState;", "getChannelsState", "endOfChannels", "", "getEndOfChannels", "filter", "Lio/getstream/chat/android/client/utils/FilterObject;", "getFilter", "()Lio/getstream/chat/android/client/utils/FilterObject;", "loading", "getLoading", "loadingMore", "getLoadingMore", "newChannelEventFilter", "Lkotlin/Function2;", "getNewChannelEventFilter", "()Lkotlin/jvm/functions/Function2;", "setNewChannelEventFilter", "(Lkotlin/jvm/functions/Function2;)V", "recoveryNeeded", "getRecoveryNeeded", "()Z", "sort", "Lio/getstream/chat/android/client/api/models/QuerySort;", "getSort", "()Lio/getstream/chat/android/client/api/models/QuerySort;", "ChannelsState", "stream-chat-android-offline_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.livedata.controller.QueryChannelsController */
/* compiled from: QueryChannelsController.kt */
public interface QueryChannelsController {
    LiveData<List<Channel>> getChannels();

    LiveData<ChannelsState> getChannelsState();

    LiveData<Boolean> getEndOfChannels();

    FilterObject getFilter();

    LiveData<Boolean> getLoading();

    LiveData<Boolean> getLoadingMore();

    Function2<Channel, FilterObject, Boolean> getNewChannelEventFilter();

    boolean getRecoveryNeeded();

    QuerySort<Channel> getSort();

    void setNewChannelEventFilter(Function2<? super Channel, ? super FilterObject, Boolean> function2);

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0003\u0004\u0005\u0006B\u0007\b\u0002¢\u0006\u0002\u0010\u0002\u0001\u0004\u0007\b\t\n¨\u0006\u000b"}, mo26107d2 = {"Lio/getstream/chat/android/livedata/controller/QueryChannelsController$ChannelsState;", "", "()V", "Loading", "NoQueryActive", "OfflineNoResults", "Result", "Lio/getstream/chat/android/livedata/controller/QueryChannelsController$ChannelsState$NoQueryActive;", "Lio/getstream/chat/android/livedata/controller/QueryChannelsController$ChannelsState$Loading;", "Lio/getstream/chat/android/livedata/controller/QueryChannelsController$ChannelsState$OfflineNoResults;", "Lio/getstream/chat/android/livedata/controller/QueryChannelsController$ChannelsState$Result;", "stream-chat-android-offline_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: io.getstream.chat.android.livedata.controller.QueryChannelsController$ChannelsState */
    /* compiled from: QueryChannelsController.kt */
    public static abstract class ChannelsState {
        private ChannelsState() {
        }

        public /* synthetic */ ChannelsState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, mo26107d2 = {"Lio/getstream/chat/android/livedata/controller/QueryChannelsController$ChannelsState$NoQueryActive;", "Lio/getstream/chat/android/livedata/controller/QueryChannelsController$ChannelsState;", "()V", "stream-chat-android-offline_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
        /* renamed from: io.getstream.chat.android.livedata.controller.QueryChannelsController$ChannelsState$NoQueryActive */
        /* compiled from: QueryChannelsController.kt */
        public static final class NoQueryActive extends ChannelsState {
            public static final NoQueryActive INSTANCE = new NoQueryActive();

            private NoQueryActive() {
                super((DefaultConstructorMarker) null);
            }
        }

        @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, mo26107d2 = {"Lio/getstream/chat/android/livedata/controller/QueryChannelsController$ChannelsState$Loading;", "Lio/getstream/chat/android/livedata/controller/QueryChannelsController$ChannelsState;", "()V", "stream-chat-android-offline_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
        /* renamed from: io.getstream.chat.android.livedata.controller.QueryChannelsController$ChannelsState$Loading */
        /* compiled from: QueryChannelsController.kt */
        public static final class Loading extends ChannelsState {
            public static final Loading INSTANCE = new Loading();

            private Loading() {
                super((DefaultConstructorMarker) null);
            }
        }

        @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, mo26107d2 = {"Lio/getstream/chat/android/livedata/controller/QueryChannelsController$ChannelsState$OfflineNoResults;", "Lio/getstream/chat/android/livedata/controller/QueryChannelsController$ChannelsState;", "()V", "stream-chat-android-offline_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
        /* renamed from: io.getstream.chat.android.livedata.controller.QueryChannelsController$ChannelsState$OfflineNoResults */
        /* compiled from: QueryChannelsController.kt */
        public static final class OfflineNoResults extends ChannelsState {
            public static final OfflineNoResults INSTANCE = new OfflineNoResults();

            private OfflineNoResults() {
                super((DefaultConstructorMarker) null);
            }
        }

        @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\t\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, mo26107d2 = {"Lio/getstream/chat/android/livedata/controller/QueryChannelsController$ChannelsState$Result;", "Lio/getstream/chat/android/livedata/controller/QueryChannelsController$ChannelsState;", "channels", "", "Lio/getstream/chat/android/client/models/Channel;", "(Ljava/util/List;)V", "getChannels", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "stream-chat-android-offline_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
        /* renamed from: io.getstream.chat.android.livedata.controller.QueryChannelsController$ChannelsState$Result */
        /* compiled from: QueryChannelsController.kt */
        public static final class Result extends ChannelsState {
            private final List<Channel> channels;

            public static /* synthetic */ Result copy$default(Result result, List<Channel> list, int i, Object obj) {
                if ((i & 1) != 0) {
                    list = result.channels;
                }
                return result.copy(list);
            }

            public final List<Channel> component1() {
                return this.channels;
            }

            public final Result copy(List<Channel> list) {
                Intrinsics.checkNotNullParameter(list, "channels");
                return new Result(list);
            }

            public boolean equals(Object obj) {
                if (this != obj) {
                    return (obj instanceof Result) && Intrinsics.areEqual((Object) this.channels, (Object) ((Result) obj).channels);
                }
                return true;
            }

            public int hashCode() {
                List<Channel> list = this.channels;
                if (list != null) {
                    return list.hashCode();
                }
                return 0;
            }

            public String toString() {
                return "Result(channels=" + this.channels + ")";
            }

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public Result(List<Channel> list) {
                super((DefaultConstructorMarker) null);
                Intrinsics.checkNotNullParameter(list, "channels");
                this.channels = list;
            }

            public final List<Channel> getChannels() {
                return this.channels;
            }
        }
    }
}
