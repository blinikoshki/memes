package editor.editor.entry;

import android.content.Intent;
import editor.optionsui.frame.frameresize.FrameSize;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import tools.activityproxy.ActivityExtra;
import tools.activityproxy.ActivityProxyBridge;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, mo26107d2 = {"<anonymous>", "", "updatedFrameSize", "Leditor/optionsui/frame/frameresize/FrameSize;", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: EditorEntrySelectionActivity.kt */
final class EditorEntrySelectionActivity$showFrameSizeInputSheet$1 extends Lambda implements Function1<FrameSize, Unit> {
    final /* synthetic */ EditorEntrySelectionActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    EditorEntrySelectionActivity$showFrameSizeInputSheet$1(EditorEntrySelectionActivity editorEntrySelectionActivity) {
        super(1);
        this.this$0 = editorEntrySelectionActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((FrameSize) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(final FrameSize frameSize) {
        Intrinsics.checkNotNullParameter(frameSize, "updatedFrameSize");
        ActivityProxyBridge.INSTANCE.launchEditorPage(this.this$0, new Function2<Intent, String, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((Intent) obj, (String) obj2);
                return Unit.INSTANCE;
            }

            public final void invoke(Intent intent, String str) {
                Intrinsics.checkNotNullParameter(intent, "$receiver");
                Intrinsics.checkNotNullParameter(str, "key");
                if (Intrinsics.areEqual((Object) str, (Object) ActivityExtra.FRAME_SIZE)) {
                    intent.putExtra(str, frameSize);
                }
            }
        });
    }
}
