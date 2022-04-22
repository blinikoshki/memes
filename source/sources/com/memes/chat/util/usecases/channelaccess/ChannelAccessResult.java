package com.memes.chat.util.usecases.channelaccess;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0002¢\u0006\u0002\u0010\u0002\u0001\u0003\u0006\u0007\b¨\u0006\t"}, mo26107d2 = {"Lcom/memes/chat/util/usecases/channelaccess/ChannelAccessResult;", "", "()V", "Failure", "Loading", "Success", "Lcom/memes/chat/util/usecases/channelaccess/ChannelAccessResult$Loading;", "Lcom/memes/chat/util/usecases/channelaccess/ChannelAccessResult$Success;", "Lcom/memes/chat/util/usecases/channelaccess/ChannelAccessResult$Failure;", "chat_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: ChannelAccessResult.kt */
public abstract class ChannelAccessResult {
    private ChannelAccessResult() {
    }

    public /* synthetic */ ChannelAccessResult(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, mo26107d2 = {"Lcom/memes/chat/util/usecases/channelaccess/ChannelAccessResult$Loading;", "Lcom/memes/chat/util/usecases/channelaccess/ChannelAccessResult;", "()V", "chat_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: ChannelAccessResult.kt */
    public static final class Loading extends ChannelAccessResult {
        public static final Loading INSTANCE = new Loading();

        private Loading() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, mo26107d2 = {"Lcom/memes/chat/util/usecases/channelaccess/ChannelAccessResult$Success;", "Lcom/memes/chat/util/usecases/channelaccess/ChannelAccessResult;", "()V", "chat_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: ChannelAccessResult.kt */
    public static final class Success extends ChannelAccessResult {
        public static final Success INSTANCE = new Success();

        private Success() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u00052\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, mo26107d2 = {"Lcom/memes/chat/util/usecases/channelaccess/ChannelAccessResult$Failure;", "Lcom/memes/chat/util/usecases/channelaccess/ChannelAccessResult;", "error", "", "canRetry", "", "(Ljava/lang/String;Z)V", "getCanRetry", "()Z", "getError", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "other", "", "hashCode", "", "toString", "chat_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: ChannelAccessResult.kt */
    public static final class Failure extends ChannelAccessResult {
        private final boolean canRetry;
        private final String error;

        public static /* synthetic */ Failure copy$default(Failure failure, String str, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                str = failure.error;
            }
            if ((i & 2) != 0) {
                z = failure.canRetry;
            }
            return failure.copy(str, z);
        }

        public final String component1() {
            return this.error;
        }

        public final boolean component2() {
            return this.canRetry;
        }

        public final Failure copy(String str, boolean z) {
            Intrinsics.checkNotNullParameter(str, "error");
            return new Failure(str, z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Failure)) {
                return false;
            }
            Failure failure = (Failure) obj;
            return Intrinsics.areEqual((Object) this.error, (Object) failure.error) && this.canRetry == failure.canRetry;
        }

        public int hashCode() {
            String str = this.error;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            boolean z = this.canRetry;
            if (z) {
                z = true;
            }
            return hashCode + (z ? 1 : 0);
        }

        public String toString() {
            return "Failure(error=" + this.error + ", canRetry=" + this.canRetry + ")";
        }

        public final String getError() {
            return this.error;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Failure(String str, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i & 2) != 0 ? true : z);
        }

        public final boolean getCanRetry() {
            return this.canRetry;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Failure(String str, boolean z) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "error");
            this.error = str;
            this.canRetry = z;
        }
    }
}
