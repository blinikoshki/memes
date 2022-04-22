package editor.editor.equipment.media;

import com.memes.commons.media.MediaContent;
import editor.editor.equipment.core.CoreLayer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010\b\u001a\u00020\u0006J\u0006\u0010\t\u001a\u00020\u0006J\u000e\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\fJ\u001a\u0010\r\u001a\u00020\u00062\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u0011R\u000e\u0010\u0003\u001a\u00020\u0002X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, mo26107d2 = {"Leditor/editor/equipment/media/MediaLayer;", "Leditor/editor/equipment/core/CoreLayer;", "Leditor/editor/equipment/media/MediaLayerView;", "mediaView", "(Leditor/editor/equipment/media/MediaLayerView;)V", "onRemoving", "", "pause", "play", "refresh", "setAspectRatio", "ratio", "", "setContent", "content", "Lcom/memes/commons/media/MediaContent;", "updateSize", "", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: MediaLayer.kt */
public final class MediaLayer extends CoreLayer<MediaLayerView> {
    private final MediaLayerView mediaView;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MediaLayer(MediaLayerView mediaLayerView) {
        super(mediaLayerView);
        Intrinsics.checkNotNullParameter(mediaLayerView, "mediaView");
        this.mediaView = mediaLayerView;
    }

    public final void play() {
        this.mediaView.play();
    }

    public final void pause() {
        this.mediaView.pause();
    }

    public final void refresh() {
        this.mediaView.refresh();
    }

    public static /* synthetic */ void setContent$default(MediaLayer mediaLayer, MediaContent mediaContent, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        mediaLayer.setContent(mediaContent, z);
    }

    public final void setContent(MediaContent mediaContent, boolean z) {
        boolean areAspectsFixed = this.mediaView.getAreAspectsFixed();
        if (!z) {
            this.mediaView.setAreAspectsFixed(true);
        }
        this.mediaView.setContent(mediaContent);
        if (!z) {
            this.mediaView.setAreAspectsFixed(areAspectsFixed);
        }
    }

    public final void setAspectRatio(float f) {
        this.mediaView.setAspectRatio(f);
    }

    public void onRemoving() {
        this.mediaView.destroy();
    }
}
