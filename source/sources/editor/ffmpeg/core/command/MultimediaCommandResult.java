package editor.ffmpeg.core.command;

import com.facebook.share.internal.ShareConstants;
import editor.ffmpeg.core.info.DataPacket;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0010\b\u0002\u0010\n\u001a\n\u0018\u00010\u000bj\u0004\u0018\u0001`\f¢\u0006\u0002\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\tHÆ\u0003J\u0011\u0010\u001c\u001a\n\u0018\u00010\u000bj\u0004\u0018\u0001`\fHÆ\u0003JG\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\u0010\b\u0002\u0010\n\u001a\n\u0018\u00010\u000bj\u0004\u0018\u0001`\fHÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u00032\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020!HÖ\u0001J\u0006\u0010\"\u001a\u00020\u0003J\t\u0010#\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0019\u0010\n\u001a\n\u0018\u00010\u000bj\u0004\u0018\u0001`\f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006$"}, mo26107d2 = {"Leditor/ffmpeg/core/command/MultimediaCommandResult;", "", "success", "", "message", "", "resultFile", "Ljava/io/File;", "dataPacket", "Leditor/ffmpeg/core/info/DataPacket;", "exception", "Ljava/lang/Exception;", "Lkotlin/Exception;", "(ZLjava/lang/String;Ljava/io/File;Leditor/ffmpeg/core/info/DataPacket;Ljava/lang/Exception;)V", "getDataPacket", "()Leditor/ffmpeg/core/info/DataPacket;", "getException", "()Ljava/lang/Exception;", "getMessage", "()Ljava/lang/String;", "getResultFile", "()Ljava/io/File;", "getSuccess", "()Z", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "isError", "toString", "ffmpegtool_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: MultimediaCommandResult.kt */
public final class MultimediaCommandResult {
    private final DataPacket dataPacket;
    private final Exception exception;
    private final String message;
    private final File resultFile;
    private final boolean success;

    public static /* synthetic */ MultimediaCommandResult copy$default(MultimediaCommandResult multimediaCommandResult, boolean z, String str, File file, DataPacket dataPacket2, Exception exc, int i, Object obj) {
        if ((i & 1) != 0) {
            z = multimediaCommandResult.success;
        }
        if ((i & 2) != 0) {
            str = multimediaCommandResult.message;
        }
        String str2 = str;
        if ((i & 4) != 0) {
            file = multimediaCommandResult.resultFile;
        }
        File file2 = file;
        if ((i & 8) != 0) {
            dataPacket2 = multimediaCommandResult.dataPacket;
        }
        DataPacket dataPacket3 = dataPacket2;
        if ((i & 16) != 0) {
            exc = multimediaCommandResult.exception;
        }
        return multimediaCommandResult.copy(z, str2, file2, dataPacket3, exc);
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

    public final DataPacket component4() {
        return this.dataPacket;
    }

    public final Exception component5() {
        return this.exception;
    }

    public final MultimediaCommandResult copy(boolean z, String str, File file, DataPacket dataPacket2, Exception exc) {
        Intrinsics.checkNotNullParameter(str, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        return new MultimediaCommandResult(z, str, file, dataPacket2, exc);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MultimediaCommandResult)) {
            return false;
        }
        MultimediaCommandResult multimediaCommandResult = (MultimediaCommandResult) obj;
        return this.success == multimediaCommandResult.success && Intrinsics.areEqual((Object) this.message, (Object) multimediaCommandResult.message) && Intrinsics.areEqual((Object) this.resultFile, (Object) multimediaCommandResult.resultFile) && Intrinsics.areEqual((Object) this.dataPacket, (Object) multimediaCommandResult.dataPacket) && Intrinsics.areEqual((Object) this.exception, (Object) multimediaCommandResult.exception);
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
        DataPacket dataPacket2 = this.dataPacket;
        int hashCode3 = (hashCode2 + (dataPacket2 != null ? dataPacket2.hashCode() : 0)) * 31;
        Exception exc = this.exception;
        if (exc != null) {
            i2 = exc.hashCode();
        }
        return hashCode3 + i2;
    }

    public String toString() {
        return "MultimediaCommandResult(success=" + this.success + ", message=" + this.message + ", resultFile=" + this.resultFile + ", dataPacket=" + this.dataPacket + ", exception=" + this.exception + ")";
    }

    public MultimediaCommandResult(boolean z, String str, File file, DataPacket dataPacket2, Exception exc) {
        Intrinsics.checkNotNullParameter(str, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        this.success = z;
        this.message = str;
        this.resultFile = file;
        this.dataPacket = dataPacket2;
        this.exception = exc;
    }

    public final boolean getSuccess() {
        return this.success;
    }

    public final String getMessage() {
        return this.message;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MultimediaCommandResult(boolean z, String str, File file, DataPacket dataPacket2, Exception exc, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, (i & 2) != 0 ? "" : str, (i & 4) != 0 ? null : file, (i & 8) != 0 ? null : dataPacket2, (i & 16) != 0 ? null : exc);
    }

    public final File getResultFile() {
        return this.resultFile;
    }

    public final DataPacket getDataPacket() {
        return this.dataPacket;
    }

    public final Exception getException() {
        return this.exception;
    }

    public final boolean isError() {
        return !this.success;
    }
}
