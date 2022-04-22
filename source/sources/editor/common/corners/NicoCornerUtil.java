package editor.common.corners;

import android.view.View;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0016\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t¨\u0006\n"}, mo26107d2 = {"Leditor/common/corners/NicoCornerUtil;", "", "()V", "resetCorners", "", "view", "Landroid/view/View;", "setCornerType", "type", "Leditor/common/corners/NicoCornerType;", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: NicoCornerUtil.kt */
public final class NicoCornerUtil {
    public static final NicoCornerUtil INSTANCE = new NicoCornerUtil();

    private NicoCornerUtil() {
    }

    public final void setCornerType(View view, NicoCornerType nicoCornerType) {
        Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
        Intrinsics.checkNotNullParameter(nicoCornerType, "type");
        view.setOutlineProvider(new NicoCornerOutlineProvider(nicoCornerType));
        view.setClipToOutline(true);
    }

    public final void resetCorners(View view) {
        Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
        view.setOutlineProvider(new NicoCornerOutlineProvider(NicoCornerType.SQUARE));
        view.setClipToOutline(true);
    }
}
