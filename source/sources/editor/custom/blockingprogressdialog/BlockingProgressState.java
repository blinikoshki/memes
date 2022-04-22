package editor.custom.blockingprogressdialog;

import com.facebook.share.internal.ShareConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0003\u0004\u0005\u0006B\u0007\b\u0002¢\u0006\u0002\u0010\u0002\u0001\u0004\u0007\b\t\n¨\u0006\u000b"}, mo26107d2 = {"Leditor/custom/blockingprogressdialog/BlockingProgressState;", "", "()V", "Error", "Hidden", "Progress", "Visible", "Leditor/custom/blockingprogressdialog/BlockingProgressState$Visible;", "Leditor/custom/blockingprogressdialog/BlockingProgressState$Hidden;", "Leditor/custom/blockingprogressdialog/BlockingProgressState$Progress;", "Leditor/custom/blockingprogressdialog/BlockingProgressState$Error;", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: BlockingProgressState.kt */
public abstract class BlockingProgressState {
    private BlockingProgressState() {
    }

    public /* synthetic */ BlockingProgressState(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, mo26107d2 = {"Leditor/custom/blockingprogressdialog/BlockingProgressState$Visible;", "Leditor/custom/blockingprogressdialog/BlockingProgressState;", "message", "", "(Ljava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: BlockingProgressState.kt */
    public static final class Visible extends BlockingProgressState {
        private final String message;

        public static /* synthetic */ Visible copy$default(Visible visible, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = visible.message;
            }
            return visible.copy(str);
        }

        public final String component1() {
            return this.message;
        }

        public final Visible copy(String str) {
            Intrinsics.checkNotNullParameter(str, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
            return new Visible(str);
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof Visible) && Intrinsics.areEqual((Object) this.message, (Object) ((Visible) obj).message);
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
            return "Visible(message=" + this.message + ")";
        }

        public final String getMessage() {
            return this.message;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Visible(String str) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
            this.message = str;
        }
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, mo26107d2 = {"Leditor/custom/blockingprogressdialog/BlockingProgressState$Hidden;", "Leditor/custom/blockingprogressdialog/BlockingProgressState;", "()V", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: BlockingProgressState.kt */
    public static final class Hidden extends BlockingProgressState {
        public static final Hidden INSTANCE = new Hidden();

        private Hidden() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, mo26107d2 = {"Leditor/custom/blockingprogressdialog/BlockingProgressState$Progress;", "Leditor/custom/blockingprogressdialog/BlockingProgressState;", "progress", "", "message", "", "(ILjava/lang/String;)V", "getMessage", "()Ljava/lang/String;", "getProgress", "()I", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: BlockingProgressState.kt */
    public static final class Progress extends BlockingProgressState {
        private final String message;
        private final int progress;

        public static /* synthetic */ Progress copy$default(Progress progress2, int i, String str, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = progress2.progress;
            }
            if ((i2 & 2) != 0) {
                str = progress2.message;
            }
            return progress2.copy(i, str);
        }

        public final int component1() {
            return this.progress;
        }

        public final String component2() {
            return this.message;
        }

        public final Progress copy(int i, String str) {
            Intrinsics.checkNotNullParameter(str, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
            return new Progress(i, str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Progress)) {
                return false;
            }
            Progress progress2 = (Progress) obj;
            return this.progress == progress2.progress && Intrinsics.areEqual((Object) this.message, (Object) progress2.message);
        }

        public int hashCode() {
            int i = this.progress * 31;
            String str = this.message;
            return i + (str != null ? str.hashCode() : 0);
        }

        public String toString() {
            return "Progress(progress=" + this.progress + ", message=" + this.message + ")";
        }

        public final int getProgress() {
            return this.progress;
        }

        public final String getMessage() {
            return this.message;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Progress(int i, String str) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
            this.progress = i;
            this.message = str;
        }
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, mo26107d2 = {"Leditor/custom/blockingprogressdialog/BlockingProgressState$Error;", "Leditor/custom/blockingprogressdialog/BlockingProgressState;", "error", "", "(Ljava/lang/String;)V", "getError", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: BlockingProgressState.kt */
    public static final class Error extends BlockingProgressState {
        private final String error;

        public static /* synthetic */ Error copy$default(Error error2, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = error2.error;
            }
            return error2.copy(str);
        }

        public final String component1() {
            return this.error;
        }

        public final Error copy(String str) {
            Intrinsics.checkNotNullParameter(str, "error");
            return new Error(str);
        }

        public boolean equals(Object obj) {
            if (this != obj) {
                return (obj instanceof Error) && Intrinsics.areEqual((Object) this.error, (Object) ((Error) obj).error);
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
            return "Error(error=" + this.error + ")";
        }

        public final String getError() {
            return this.error;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Error(String str) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "error");
            this.error = str;
        }
    }
}
