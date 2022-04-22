package editor.gpu.command;

import android.graphics.Bitmap;
import editor.gpu.gpuimage.GPUImage;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref;
import timber.log.Timber;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, mo26107d2 = {"<anonymous>", "", "item", "Landroid/graphics/Bitmap;", "kotlin.jvm.PlatformType", "response"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: GpuImageCommandExecutor.kt */
final class GpuImageCommandExecutor$executeInternal$callback$1<T> implements GPUImage.ResponseListener<Bitmap> {
    final /* synthetic */ Ref.ObjectRef $latestBitmap;

    GpuImageCommandExecutor$executeInternal$callback$1(Ref.ObjectRef objectRef) {
        this.$latestBitmap = objectRef;
    }

    public final void response(Bitmap bitmap) {
        StringBuilder sb = new StringBuilder();
        sb.append("Applied one filter: hasBitmap=");
        sb.append(bitmap != null);
        Timber.m300d(sb.toString(), new Object[0]);
        this.$latestBitmap.element = bitmap;
    }
}
