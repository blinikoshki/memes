package editor.optionsui.frame.frameresize;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, mo26107d2 = {"Leditor/optionsui/frame/frameresize/FrameSizeConfig;", "", "()V", "ASSET_PATH", "", "contentJsonPath", "filePath", "fileName", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: FrameSizeConfig.kt */
public final class FrameSizeConfig {
    public static final String ASSET_PATH = "framesizeentries/";
    public static final FrameSizeConfig INSTANCE = new FrameSizeConfig();

    public final String contentJsonPath() {
        return "framesizeentries/content2.json";
    }

    private FrameSizeConfig() {
    }

    public final String filePath(String str) {
        Intrinsics.checkNotNullParameter(str, "fileName");
        return ASSET_PATH + str;
    }
}
