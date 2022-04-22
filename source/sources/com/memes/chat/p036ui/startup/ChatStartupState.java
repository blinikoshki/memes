package com.memes.chat.p036ui.startup;

import com.facebook.share.internal.ShareConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0002¢\u0006\u0002\u0010\u0002\u0001\u0003\u0006\u0007\b¨\u0006\t"}, mo26107d2 = {"Lcom/memes/chat/ui/startup/ChatStartupState;", "", "()V", "Failure", "Loaded", "Loading", "Lcom/memes/chat/ui/startup/ChatStartupState$Loading;", "Lcom/memes/chat/ui/startup/ChatStartupState$Failure;", "Lcom/memes/chat/ui/startup/ChatStartupState$Loaded;", "chat_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.chat.ui.startup.ChatStartupState */
/* compiled from: ChatStartupState.kt */
public abstract class ChatStartupState {
    private ChatStartupState() {
    }

    public /* synthetic */ ChatStartupState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, mo26107d2 = {"Lcom/memes/chat/ui/startup/ChatStartupState$Loading;", "Lcom/memes/chat/ui/startup/ChatStartupState;", "message", "", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "chat_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: com.memes.chat.ui.startup.ChatStartupState$Loading */
    /* compiled from: ChatStartupState.kt */
    public static final class Loading extends ChatStartupState {
        private final String message;

        public Loading() {
            this((String) null, 1, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ Loading copy$default(Loading loading, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = loading.message;
            }
            return loading.copy(str);
        }

        public final String component1() {
            return this.message;
        }

        public final Loading copy(String str) {
            Intrinsics.checkNotNullParameter(str, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
            return new Loading(str);
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof Loading) && Intrinsics.areEqual((Object) this.message, (Object) ((Loading) obj).message);
            }
            return true;
        }

        public int hashCode() {
            String str = this.message;
            if (str != null) {
                return str.hashCode();
            }
            return 0;
        }

        public String toString() {
            return "Loading(message=" + this.message + ")";
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Loading(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? "Please wait..." : str);
        }

        public final String getMessage() {
            return this.message;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Loading(String str) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
            this.message = str;
        }
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, mo26107d2 = {"Lcom/memes/chat/ui/startup/ChatStartupState$Failure;", "Lcom/memes/chat/ui/startup/ChatStartupState;", "error", "", "(Ljava/lang/String;)V", "getError", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "chat_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: com.memes.chat.ui.startup.ChatStartupState$Failure */
    /* compiled from: ChatStartupState.kt */
    public static final class Failure extends ChatStartupState {
        private final String error;

        public static /* synthetic */ Failure copy$default(Failure failure, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = failure.error;
            }
            return failure.copy(str);
        }

        public final String component1() {
            return this.error;
        }

        public final Failure copy(String str) {
            Intrinsics.checkNotNullParameter(str, "error");
            return new Failure(str);
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof Failure) && Intrinsics.areEqual((Object) this.error, (Object) ((Failure) obj).error);
            }
            return true;
        }

        public int hashCode() {
            String str = this.error;
            if (str != null) {
                return str.hashCode();
            }
            return 0;
        }

        public String toString() {
            return "Failure(error=" + this.error + ")";
        }

        public final String getError() {
            return this.error;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Failure(String str) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "error");
            this.error = str;
        }
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, mo26107d2 = {"Lcom/memes/chat/ui/startup/ChatStartupState$Loaded;", "Lcom/memes/chat/ui/startup/ChatStartupState;", "()V", "chat_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: com.memes.chat.ui.startup.ChatStartupState$Loaded */
    /* compiled from: ChatStartupState.kt */
    public static final class Loaded extends ChatStartupState {
        public static final Loaded INSTANCE = new Loaded();

        private Loaded() {
            super((DefaultConstructorMarker) null);
        }
    }
}
