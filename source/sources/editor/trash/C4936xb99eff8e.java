package editor.trash;

import android.graphics.Bitmap;
import android.view.PixelCopy;
import android.view.View;
import com.memes.commons.util.Bitmaps;
import java.io.File;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004¨\u0006\u0005"}, mo26107d2 = {"<anonymous>", "", "result", "", "onPixelCopyFinished", "editor/trash/ViewContentSaver$saveWithPixelCopy$2$1"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: editor.trash.ViewContentSaver$saveWithPixelCopy$$inlined$suspendCoroutine$lambda$1 */
/* compiled from: ViewContentSaver.kt */
final class C4936xb99eff8e implements PixelCopy.OnPixelCopyFinishedListener {
    final /* synthetic */ Bitmap $bitmap;
    final /* synthetic */ Continuation $continuation;
    final /* synthetic */ Ref.ObjectRef $targetRect$inlined;
    final /* synthetic */ View $view$inlined;
    final /* synthetic */ Ref.ObjectRef $window$inlined;
    final /* synthetic */ ViewContentSaver this$0;

    C4936xb99eff8e(Bitmap bitmap, Continuation continuation, ViewContentSaver viewContentSaver, View view, Ref.ObjectRef objectRef, Ref.ObjectRef objectRef2) {
        this.$bitmap = bitmap;
        this.$continuation = continuation;
        this.this$0 = viewContentSaver;
        this.$view$inlined = view;
        this.$window$inlined = objectRef;
        this.$targetRect$inlined = objectRef2;
    }

    public final void onPixelCopyFinished(int i) {
        if (i == 0) {
            Bitmaps bitmaps = Bitmaps.INSTANCE;
            Bitmap bitmap = this.$bitmap;
            Intrinsics.checkNotNullExpressionValue(bitmap, "bitmap");
            File save$default = Bitmaps.save$default(bitmaps, bitmap, ViewContentSaver.access$getOutputFile$p(this.this$0), (Bitmap.CompressFormat) null, 0, 12, (Object) null);
            Continuation continuation = this.$continuation;
            Result.Companion companion = Result.Companion;
            continuation.resumeWith(Result.m1029constructorimpl(save$default));
            return;
        }
        Continuation continuation2 = this.$continuation;
        Result.Companion companion2 = Result.Companion;
        continuation2.resumeWith(Result.m1029constructorimpl((Object) null));
    }
}
