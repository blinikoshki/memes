package editor.gpu.command;

import com.facebook.share.internal.ShareConstants;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0010\b\u0002\u0010\b\u001a\n\u0018\u00010\tj\u0004\u0018\u0001`\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0011\u0010\u0017\u001a\n\u0018\u00010\tj\u0004\u0018\u0001`\nHÆ\u0003J;\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0010\b\u0002\u0010\b\u001a\n\u0018\u00010\tj\u0004\u0018\u0001`\nHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u00032\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\u0006\u0010\u001d\u001a\u00020\u0003J\t\u0010\u001e\u001a\u00020\u0005HÖ\u0001R\u0019\u0010\b\u001a\n\u0018\u00010\tj\u0004\u0018\u0001`\n¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001f"}, mo26107d2 = {"Leditor/gpu/command/GpuFrameworkCommandResult;", "", "success", "", "message", "", "resultFile", "Ljava/io/File;", "exception", "Ljava/lang/Exception;", "Lkotlin/Exception;", "(ZLjava/lang/String;Ljava/io/File;Ljava/lang/Exception;)V", "getException", "()Ljava/lang/Exception;", "getMessage", "()Ljava/lang/String;", "getResultFile", "()Ljava/io/File;", "getSuccess", "()Z", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "isError", "toString", "gputool_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: GpuFrameworkCommandResult.kt */
public final class GpuFrameworkCommandResult {
    private final Exception exception;
    private final String message;
    private final File resultFile;
    private final boolean success;

    public static /* synthetic */ GpuFrameworkCommandResult copy$default(GpuFrameworkCommandResult gpuFrameworkCommandResult, boolean z, String str, File file, Exception exc, int i, Object obj) {
        if ((i & 1) != 0) {
            z = gpuFrameworkCommandResult.success;
        }
        if ((i & 2) != 0) {
            str = gpuFrameworkCommandResult.message;
        }
        if ((i & 4) != 0) {
            file = gpuFrameworkCommandResult.resultFile;
        }
        if ((i & 8) != 0) {
            exc = gpuFrameworkCommandResult.exception;
        }
        return gpuFrameworkCommandResult.copy(z, str, file, exc);
    }

    public final boolean component1() {
        return this.success;
    }

    public final String component2() {
        return this.message;
    }

    public final File component3() {
        return this.resultFile;
    }

    public final Exception component4() {
        return this.exception;
    }

    public final GpuFrameworkCommandResult copy(boolean z, String str, File file, Exception exc) {
        Intrinsics.checkNotNullParameter(str, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        return new GpuFrameworkCommandResult(z, str, file, exc);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GpuFrameworkCommandResult)) {
            return false;
        }
        GpuFrameworkCommandResult gpuFrameworkCommandResult = (GpuFrameworkCommandResult) obj;
        return this.success == gpuFrameworkCommandResult.success && Intrinsics.areEqual((Object) this.message, (Object) gpuFrameworkCommandResult.message) && Intrinsics.areEqual((Object) this.resultFile, (Object) gpuFrameworkCommandResult.resultFile) && Intrinsics.areEqual((Object) this.exception, (Object) gpuFrameworkCommandResult.exception);
    }

    public int hashCode() {
        boolean z = this.success;
        if (z) {
            z = true;
        }
        int i = (z ? 1 : 0) * true;
        String str = this.message;
        int i2 = 0;
        int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        File file = this.resultFile;
        int hashCode2 = (hashCode + (file != null ? file.hashCode() : 0)) * 31;
        Exception exc = this.exception;
        if (exc != null) {
            i2 = exc.hashCode();
        }
        return hashCode2 + i2;
    }

    public String toString() {
        return "GpuFrameworkCommandResult(success=" + this.success + ", message=" + this.message + ", resultFile=" + this.resultFile + ", exception=" + this.exception + ")";
    }

    public GpuFrameworkCommandResult(boolean z, String str, File file, Exception exc) {
        Intrinsics.checkNotNullParameter(str, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        this.success = z;
        this.message = str;
        this.resultFile = file;
        this.exception = exc;
    }

    public final boolean getSuccess() {
        return this.success;
    }

    public final String getMessage() {
        return this.message;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GpuFrameworkCommandResult(boolean z, String str, File file, Exception exc, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, (i & 2) != 0 ? "" : str, (i & 4) != 0 ? null : file, (i & 8) != 0 ? null : exc);
    }

    public final File getResultFile() {
        return this.resultFile;
    }

    public final Exception getException() {
        return this.exception;
    }

    public final boolean isError() {
        return !this.success;
    }
}
