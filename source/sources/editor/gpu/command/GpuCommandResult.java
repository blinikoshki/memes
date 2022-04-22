package editor.gpu.command;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0002¢\u0006\u0002\u0010\u0002\u0001\u0002\u0005\u0006¨\u0006\u0007"}, mo26107d2 = {"Leditor/gpu/command/GpuCommandResult;", "", "()V", "Failure", "Success", "Leditor/gpu/command/GpuCommandResult$Success;", "Leditor/gpu/command/GpuCommandResult$Failure;", "gputool_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: GpuCommandResult.kt */
public abstract class GpuCommandResult {
    private GpuCommandResult() {
    }

    public /* synthetic */ GpuCommandResult(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, mo26107d2 = {"Leditor/gpu/command/GpuCommandResult$Success;", "Leditor/gpu/command/GpuCommandResult;", "()V", "gputool_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: GpuCommandResult.kt */
    public static final class Success extends GpuCommandResult {
        public static final Success INSTANCE = new Success();

        private Success() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, mo26107d2 = {"Leditor/gpu/command/GpuCommandResult$Failure;", "Leditor/gpu/command/GpuCommandResult;", "error", "", "(Ljava/lang/String;)V", "getError", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "gputool_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: GpuCommandResult.kt */
    public static final class Failure extends GpuCommandResult {
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
}
