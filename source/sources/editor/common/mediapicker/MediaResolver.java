package editor.common.mediapicker;

import android.content.Context;
import android.net.Uri;
import com.memes.commons.media.MediaContent;
import com.memes.commons.output.OutputExtension;
import com.memes.commons.output.OutputTargetGenerator;
import com.memes.uritool.UriResolver;
import com.memes.uritool.resolve.UriResolveResult;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001:\u0001\u001cB!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0005H\u0002J\"\u0010\u0018\u001a\u00020\u00162\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00142\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, mo26107d2 = {"Leditor/common/mediapicker/MediaResolver;", "", "context", "Landroid/content/Context;", "outputRelativePath", "", "outputTargetGenerator", "Lcom/memes/commons/output/OutputTargetGenerator;", "(Landroid/content/Context;Ljava/lang/String;Lcom/memes/commons/output/OutputTargetGenerator;)V", "callback", "Leditor/common/mediapicker/MediaResolver$Callback;", "uriResolver", "Lcom/memes/uritool/UriResolver;", "canReadFile", "", "file", "Ljava/io/File;", "createMediaContent", "Lcom/memes/commons/media/MediaContent;", "type", "", "reportError", "", "error", "resolve", "contentUri", "Landroid/net/Uri;", "contentType", "Callback", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: MediaResolver.kt */
public final class MediaResolver {
    private Callback callback;
    private final String outputRelativePath;
    private final OutputTargetGenerator outputTargetGenerator;
    private final UriResolver uriResolver;

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&¨\u0006\t"}, mo26107d2 = {"Leditor/common/mediapicker/MediaResolver$Callback;", "", "onUriResolveError", "", "error", "", "onUriResolved", "content", "Lcom/memes/commons/media/MediaContent;", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: MediaResolver.kt */
    public interface Callback {
        void onUriResolveError(String str);

        void onUriResolved(MediaContent mediaContent);
    }

    public MediaResolver(Context context, String str, OutputTargetGenerator outputTargetGenerator2) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "outputRelativePath");
        this.outputRelativePath = str;
        UriResolver.Companion companion = UriResolver.Companion;
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "context.applicationContext");
        this.uriResolver = companion.from(applicationContext);
        this.outputTargetGenerator = outputTargetGenerator2 == null ? OutputTargetGenerator.Companion.fromCacheDirectory(context) : outputTargetGenerator2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MediaResolver(Context context, String str, OutputTargetGenerator outputTargetGenerator2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, str, (i & 4) != 0 ? null : outputTargetGenerator2);
    }

    public static /* synthetic */ void resolve$default(MediaResolver mediaResolver, Uri uri, int i, Callback callback2, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            callback2 = null;
        }
        mediaResolver.resolve(uri, i, callback2);
    }

    public final void resolve(Uri uri, int i, Callback callback2) {
        Intrinsics.checkNotNullParameter(uri, "contentUri");
        this.callback = callback2;
        File outputFile = OutputTargetGenerator.setDefaultOutputDestination$default(this.outputTargetGenerator, this.outputRelativePath, (String) null, i != 1231 ? i != 1232 ? i != 1235 ? OutputExtension.UNKNOWN : OutputExtension.GIF : OutputExtension.MP4 : OutputExtension.JPG, false, false, 26, (Object) null).getOutputFile();
        UriResolveResult createResolve$default = UriResolver.createResolve$default(this.uriResolver.setUri(uri), outputFile, (List) null, 2, (Object) null);
        if (!createResolve$default.hasFile()) {
            reportError("Failed to resolve Uri; error=" + createResolve$default.getError());
            return;
        }
        File file = createResolve$default.getFile();
        if (!canReadFile(file)) {
            reportError("File access is private & it can't be read.");
            return;
        }
        if (!Intrinsics.areEqual((Object) file.getAbsolutePath(), (Object) outputFile.getAbsolutePath())) {
            outputFile.delete();
        }
        Timber.m300d("Uri resolved to file=" + file, new Object[0]);
        MediaContent createMediaContent = createMediaContent(file, i);
        if (callback2 != null) {
            callback2.onUriResolved(createMediaContent);
        }
    }

    private final boolean canReadFile(File file) {
        try {
            return file.canRead();
        } catch (Exception unused) {
            return false;
        }
    }

    private final MediaContent createMediaContent(File file, int i) {
        MediaContent mediaContent;
        if (i == 1231) {
            mediaContent = MediaResolverHelper.INSTANCE.tryProcessPhoto(i, file);
        } else if (i != 1232) {
            mediaContent = i != 1235 ? null : MediaResolverHelper.INSTANCE.tryProcessGif(file);
        } else {
            mediaContent = MediaResolverHelper.INSTANCE.tryProcessVideo(i, file);
        }
        if (mediaContent != null) {
            return mediaContent;
        }
        String absolutePath = file.getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath, "file.absolutePath");
        return new MediaContent(i, absolutePath, (Integer) null, (Integer) null, 12, (DefaultConstructorMarker) null);
    }

    private final void reportError(String str) {
        Callback callback2 = this.callback;
        if (callback2 != null) {
            callback2.onUriResolveError(str);
        }
    }
}
