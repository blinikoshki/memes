package com.memes.network.core;

import com.facebook.share.internal.ShareConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000*\n\b\u0000\u0010\u0001 \u0001*\u00020\u00022\u00020\u0002:\u0003\u0004\u0005\u0006B\u0007\b\u0002¢\u0006\u0002\u0010\u0003\u0001\u0003\u0007\b\t¨\u0006\n"}, mo26107d2 = {"Lcom/memes/network/core/ResultState;", "T", "", "()V", "Error", "Loading", "Success", "Lcom/memes/network/core/ResultState$Success;", "Lcom/memes/network/core/ResultState$Error;", "Lcom/memes/network/core/ResultState$Loading;", "network_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: ResultState.kt */
public abstract class ResultState<T> {
    private ResultState() {
    }

    public /* synthetic */ ResultState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u0000*\n\b\u0001\u0010\u0001 \u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00028\u0001¢\u0006\u0002\u0010\u0005J\u000e\u0010\t\u001a\u00028\u0001HÆ\u0003¢\u0006\u0002\u0010\u0007J\u001e\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00010\u00002\b\b\u0002\u0010\u0004\u001a\u00028\u0001HÆ\u0001¢\u0006\u0002\u0010\u000bJ\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0013\u0010\u0004\u001a\u00028\u0001¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0013"}, mo26107d2 = {"Lcom/memes/network/core/ResultState$Success;", "T", "", "Lcom/memes/network/core/ResultState;", "data", "(Ljava/lang/Object;)V", "getData", "()Ljava/lang/Object;", "Ljava/lang/Object;", "component1", "copy", "(Ljava/lang/Object;)Lcom/memes/network/core/ResultState$Success;", "equals", "", "other", "hashCode", "", "toString", "", "network_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: ResultState.kt */
    public static final class Success<T> extends ResultState<T> {
        private final T data;

        public static /* synthetic */ Success copy$default(Success success, T t, int i, Object obj) {
            if ((i & 1) != 0) {
                t = success.data;
            }
            return success.copy(t);
        }

        public final T component1() {
            return this.data;
        }

        public final Success<T> copy(T t) {
            Intrinsics.checkNotNullParameter(t, "data");
            return new Success<>(t);
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof Success) && Intrinsics.areEqual((Object) this.data, (Object) ((Success) obj).data);
            }
            return true;
        }

        public int hashCode() {
            T t = this.data;
            if (t != null) {
                return t.hashCode();
            }
            return 0;
        }

        public String toString() {
            return "Success(data=" + this.data + ")";
        }

        public final T getData() {
            return this.data;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Success(T t) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(t, "data");
            this.data = t;
        }
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B)\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\u0011\u001a\u00020\u0004HÆ\u0003J\u0011\u0010\u0012\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u0007HÆ\u0003J\t\u0010\u0013\u001a\u00020\tHÆ\u0003J/\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\u0010\b\u0002\u0010\u0005\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0015\u001a\u00020\t2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0004HÖ\u0001R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0019\u0010\u0005\u001a\n\u0018\u00010\u0006j\u0004\u0018\u0001`\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, mo26107d2 = {"Lcom/memes/network/core/ResultState$Error;", "Lcom/memes/network/core/ResultState;", "", "message", "", "cause", "Ljava/lang/Exception;", "Lkotlin/Exception;", "canRetry", "", "(Ljava/lang/String;Ljava/lang/Exception;Z)V", "getCanRetry", "()Z", "getCause", "()Ljava/lang/Exception;", "getMessage", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "", "toString", "network_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: ResultState.kt */
    public static final class Error extends ResultState {
        private final boolean canRetry;
        private final Exception cause;
        private final String message;

        public static /* synthetic */ Error copy$default(Error error, String str, Exception exc, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                str = error.message;
            }
            if ((i & 2) != 0) {
                exc = error.cause;
            }
            if ((i & 4) != 0) {
                z = error.canRetry;
            }
            return error.copy(str, exc, z);
        }

        public final String component1() {
            return this.message;
        }

        public final Exception component2() {
            return this.cause;
        }

        public final boolean component3() {
            return this.canRetry;
        }

        public final Error copy(String str, Exception exc, boolean z) {
            Intrinsics.checkNotNullParameter(str, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
            return new Error(str, exc, z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Error)) {
                return false;
            }
            Error error = (Error) obj;
            return Intrinsics.areEqual((Object) this.message, (Object) error.message) && Intrinsics.areEqual((Object) this.cause, (Object) error.cause) && this.canRetry == error.canRetry;
        }

        public int hashCode() {
            String str = this.message;
            int i = 0;
            int hashCode = (str != null ? str.hashCode() : 0) * 31;
            Exception exc = this.cause;
            if (exc != null) {
                i = exc.hashCode();
            }
            int i2 = (hashCode + i) * 31;
            boolean z = this.canRetry;
            if (z) {
                z = true;
            }
            return i2 + (z ? 1 : 0);
        }

        public String toString() {
            return "Error(message=" + this.message + ", cause=" + this.cause + ", canRetry=" + this.canRetry + ")";
        }

        public final String getMessage() {
            return this.message;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Error(String str, Exception exc, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i & 2) != 0 ? null : exc, (i & 4) != 0 ? true : z);
        }

        public final Exception getCause() {
            return this.cause;
        }

        public final boolean getCanRetry() {
            return this.canRetry;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Error(String str, Exception exc, boolean z) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
            this.message = str;
            this.cause = exc;
            this.canRetry = z;
        }
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003¨\u0006\u0004"}, mo26107d2 = {"Lcom/memes/network/core/ResultState$Loading;", "Lcom/memes/network/core/ResultState;", "", "()V", "network_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: ResultState.kt */
    public static final class Loading extends ResultState {
        public static final Loading INSTANCE = new Loading();

        private Loading() {
            super((DefaultConstructorMarker) null);
        }
    }
}
