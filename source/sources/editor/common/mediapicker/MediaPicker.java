package editor.common.mediapicker;

import android.content.Context;
import android.net.Uri;
import com.memes.commons.media.MediaContent;
import com.memes.commons.output.OutputTargetGenerator;
import editor.common.mediapicker.MediaResolver;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b \u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H&J\u0010\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0010\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0018\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0004R\u001b\u0010\u0007\u001a\u00020\b8BX\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\n¨\u0006\u001c"}, mo26107d2 = {"Leditor/common/mediapicker/MediaPicker;", "Leditor/common/mediapicker/MediaResolver$Callback;", "context", "Landroid/content/Context;", "outputTargetGenerator", "Lcom/memes/commons/output/OutputTargetGenerator;", "(Landroid/content/Context;Lcom/memes/commons/output/OutputTargetGenerator;)V", "resolver", "Leditor/common/mediapicker/MediaResolver;", "getResolver", "()Leditor/common/mediapicker/MediaResolver;", "resolver$delegate", "Lkotlin/Lazy;", "onPickResultAvailable", "", "result", "Leditor/common/mediapicker/MediaPickResult;", "onUriResolveError", "error", "", "onUriResolved", "content", "Lcom/memes/commons/media/MediaContent;", "resolveContent", "contentType", "", "contentUri", "Landroid/net/Uri;", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: MediaPicker.kt */
public abstract class MediaPicker implements MediaResolver.Callback {
    private final Lazy resolver$delegate;

    private final MediaResolver getResolver() {
        return (MediaResolver) this.resolver$delegate.getValue();
    }

    public abstract void onPickResultAvailable(MediaPickResult mediaPickResult);

    public MediaPicker(Context context, OutputTargetGenerator outputTargetGenerator) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(outputTargetGenerator, "outputTargetGenerator");
        this.resolver$delegate = LazyKt.lazy(new MediaPicker$resolver$2(context, outputTargetGenerator));
    }

    /* access modifiers changed from: protected */
    public final void resolveContent(int i, Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "contentUri");
        String uri2 = uri.toString();
        Intrinsics.checkNotNullExpressionValue(uri2, "contentUri.toString()");
        try {
            getResolver().resolve(uri, new MediaContent(i, uri2, (Integer) null, (Integer) null, 12, (DefaultConstructorMarker) null).contentType(), this);
        } catch (Exception unused) {
            onUriResolveError("Unable to access this content");
        }
    }

    public void onUriResolved(MediaContent mediaContent) {
        Intrinsics.checkNotNullParameter(mediaContent, "content");
        if (mediaContent.asFile().exists()) {
            onPickResultAvailable(new MediaPickResult(mediaContent, (String) null, 2, (DefaultConstructorMarker) null));
        } else {
            onUriResolveError("Unable to access this content");
        }
    }

    public void onUriResolveError(String str) {
        Intrinsics.checkNotNullParameter(str, "error");
        onPickResultAvailable(new MediaPickResult((MediaContent) null, str));
    }
}
