package editor.optionsui.watermark;

import com.appsflyer.ServerParameters;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\b\u0016\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\r"}, mo26107d2 = {"Leditor/optionsui/watermark/Watermark;", "", "uid", "", "thumbnailPath", "timestamp", "", "(Ljava/lang/String;Ljava/lang/String;J)V", "getThumbnailPath", "()Ljava/lang/String;", "getTimestamp", "()J", "getUid", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: Watermark.kt */
public class Watermark {
    private final String thumbnailPath;
    private final long timestamp;
    private final String uid;

    public Watermark(String str, String str2, long j) {
        Intrinsics.checkNotNullParameter(str, ServerParameters.AF_USER_ID);
        this.uid = str;
        this.thumbnailPath = str2;
        this.timestamp = j;
    }

    public final String getUid() {
        return this.uid;
    }

    public final String getThumbnailPath() {
        return this.thumbnailPath;
    }

    public final long getTimestamp() {
        return this.timestamp;
    }
}
