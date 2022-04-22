package editor.editor;

import android.content.Context;
import androidx.activity.result.ActivityResultCallback;
import com.facebook.internal.logging.monitor.MonitorLogServerProtocol;
import com.memes.commons.media.MediaContent;
import com.memes.commons.util.ExtensionsKt;
import editor.editor.equipment.property.MediaProperty;
import editor.editor.equipment.property.NicoPropertyBundle;
import editor.optionsui.addcontent.contentpicker.ContentPickerTarget;
import editor.optionsui.watermark.PhotoWatermarkSource;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012*\u0010\u0002\u001a&\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u0005 \u0006*\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0007"}, mo26107d2 = {"<anonymous>", "", "<name for destructuring parameter 0>", "Lkotlin/Pair;", "Lcom/memes/commons/media/MediaContent;", "", "kotlin.jvm.PlatformType", "onActivityResult"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: EditorActivity.kt */
final class EditorActivity$showContentPicker$1<O> implements ActivityResultCallback<Pair<? extends MediaContent, ? extends Boolean>> {
    final /* synthetic */ boolean $isWatermark;
    final /* synthetic */ ContentPickerTarget $target;
    final /* synthetic */ String $token;
    final /* synthetic */ EditorActivity this$0;

    EditorActivity$showContentPicker$1(EditorActivity editorActivity, String str, boolean z, ContentPickerTarget contentPickerTarget) {
        this.this$0 = editorActivity;
        this.$token = str;
        this.$isWatermark = z;
        this.$target = contentPickerTarget;
    }

    public final void onActivityResult(Pair<MediaContent, Boolean> pair) {
        MediaContent component1 = pair.component1();
        if (!pair.component2().booleanValue()) {
            if (component1 == null) {
                ExtensionsKt.toast((Context) this.this$0, "Failed to access/download selected content.");
                return;
            }
            String str = this.$token;
            if (str == null) {
                str = MonitorLogServerProtocol.DEFAULT_SAMPLE_RATES_KEY;
            }
            NicoPropertyBundle nicoPropertyBundle = new NicoPropertyBundle(str, (List) null, 2, (DefaultConstructorMarker) null);
            nicoPropertyBundle.setProperties(new MediaProperty.Content(component1));
            if (this.$isWatermark && this.$target == ContentPickerTarget.PHOTO) {
                nicoPropertyBundle.addProperties(new MediaProperty.Watermark(false, PhotoWatermarkSource.RAW, 1, (DefaultConstructorMarker) null));
            }
            this.this$0.getFrame().updateMediaEntity(nicoPropertyBundle);
        }
    }
}
