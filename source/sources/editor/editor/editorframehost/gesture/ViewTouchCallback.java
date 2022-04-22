package editor.editor.editorframehost.gesture;

import android.view.View;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\b`\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\"\u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\f\u001a\u00020\rH&¨\u0006\u000e"}, mo26107d2 = {"Leditor/editor/editorframehost/gesture/ViewTouchCallback;", "", "onOverlayViewDragStarted", "", "identifier", "", "view", "Landroid/view/View;", "onOverlayViewDragStopped", "onOverlayViewDragging", "onOverlayViewLongPressed", "onOverlayViewTapped", "isDoubleTap", "", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: ViewTouchCallback.kt */
public interface ViewTouchCallback {
    void onOverlayViewDragStarted(String str, View view);

    void onOverlayViewDragStopped(String str, View view);

    void onOverlayViewDragging(String str, View view);

    void onOverlayViewLongPressed(String str, View view);

    void onOverlayViewTapped(String str, View view, boolean z);

    @Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 4, 2})
    /* compiled from: ViewTouchCallback.kt */
    public static final class DefaultImpls {
        public static /* synthetic */ void onOverlayViewTapped$default(ViewTouchCallback viewTouchCallback, String str, View view, boolean z, int i, Object obj) {
            if (obj == null) {
                if ((i & 4) != 0) {
                    z = false;
                }
                viewTouchCallback.onOverlayViewTapped(str, view, z);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: onOverlayViewTapped");
        }
    }
}
