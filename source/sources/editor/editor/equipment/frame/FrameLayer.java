package editor.editor.equipment.frame;

import com.facebook.appevents.internal.ViewHierarchyConstants;
import editor.editor.equipment.core.CoreLayer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bR\u000e\u0010\u0003\u001a\u00020\u0002X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, mo26107d2 = {"Leditor/editor/equipment/frame/FrameLayer;", "Leditor/editor/equipment/core/CoreLayer;", "Leditor/editor/equipment/frame/FrameLayerView;", "view", "(Leditor/editor/equipment/frame/FrameLayerView;)V", "setAspectRatio", "", "value", "", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: FrameLayer.kt */
public final class FrameLayer extends CoreLayer<FrameLayerView> {
    /* access modifiers changed from: private */
    public final FrameLayerView view;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FrameLayer(FrameLayerView frameLayerView) {
        super(frameLayerView);
        Intrinsics.checkNotNullParameter(frameLayerView, ViewHierarchyConstants.VIEW_KEY);
        this.view = frameLayerView;
    }

    public final void setAspectRatio(float f) {
        this.view.post(new FrameLayer$setAspectRatio$1(this, f));
    }
}
