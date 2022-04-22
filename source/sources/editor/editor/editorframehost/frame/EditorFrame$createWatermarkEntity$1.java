package editor.editor.editorframehost.frame;

import android.view.ViewGroup;
import android.widget.ImageView;
import editor.editor.equipment.core.CoreEntity;
import editor.editor.equipment.core.CoreLayer;
import editor.editor.equipment.core.CoreStyle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00040\u0001J\"\u0010\t\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u0004\u0012\u00020\u00040\u00012\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u0014\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\f"}, mo26107d2 = {"editor/editor/editorframehost/frame/EditorFrame$createWatermarkEntity$1", "Leditor/editor/equipment/core/CoreEntity;", "Leditor/editor/equipment/core/CoreLayer;", "Landroid/widget/ImageView;", "Leditor/editor/equipment/core/CoreStyle;", "token", "", "getToken", "()Ljava/lang/String;", "duplicate", "parent", "Landroid/view/ViewGroup;", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: EditorFrame.kt */
public final class EditorFrame$createWatermarkEntity$1 extends CoreEntity<CoreLayer<ImageView>, CoreStyle> {
    final /* synthetic */ ImageView $watermarkView;
    private final String token = createEntityToken("watermark");

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    EditorFrame$createWatermarkEntity$1(ImageView imageView, CoreLayer coreLayer, CoreStyle coreStyle) {
        super(coreLayer, coreStyle);
        this.$watermarkView = imageView;
    }

    public String getToken() {
        return this.token;
    }

    public CoreEntity<CoreLayer<ImageView>, CoreStyle> duplicate(ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        throw new RuntimeException("Watermark entity can't be duplicated.");
    }
}
