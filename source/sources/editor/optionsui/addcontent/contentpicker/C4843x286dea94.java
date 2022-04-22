package editor.optionsui.addcontent.contentpicker;

import com.facebook.share.internal.ShareConstants;
import com.memes.commons.media.MediaContent;
import com.memes.commons.media.MediaContentDownloader;
import java.io.File;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f¸\u0006\u0000"}, mo26107d2 = {"editor/optionsui/addcontent/contentpicker/ContentPickerViewModel$download$3$1", "Lcom/memes/commons/media/MediaContentDownloader$Callback;", "onDownloadComplete", "", "file", "Ljava/io/File;", "onError", "message", "", "onProgressChanged", "progress", "", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: editor.optionsui.addcontent.contentpicker.ContentPickerViewModel$download$$inlined$suspendCoroutine$lambda$1 */
/* compiled from: ContentPickerViewModel.kt */
public final class C4843x286dea94 implements MediaContentDownloader.Callback {
    final /* synthetic */ MediaContent $content$inlined;
    final /* synthetic */ Continuation $continuation;
    final /* synthetic */ String $outputExtension$inlined;
    final /* synthetic */ File $outputFile$inlined;
    final /* synthetic */ ContentPickerViewModel this$0;

    C4843x286dea94(Continuation continuation, ContentPickerViewModel contentPickerViewModel, File file, String str, MediaContent mediaContent) {
        this.$continuation = continuation;
        this.this$0 = contentPickerViewModel;
        this.$outputFile$inlined = file;
        this.$outputExtension$inlined = str;
        this.$content$inlined = mediaContent;
    }

    public void onProgressChanged(int i) {
        ContentPickerViewModel contentPickerViewModel = this.this$0;
        StringBuilder sb = new StringBuilder();
        sb.append(i);
        sb.append('%');
        contentPickerViewModel.updateBlockingProgress(i, sb.toString());
    }

    public void onDownloadComplete(File file) {
        Intrinsics.checkNotNullParameter(file, "file");
        this.this$0.hideBlockingProgress();
        MediaContent mediaContent = this.$content$inlined;
        String absolutePath = file.getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath, "file.absolutePath");
        mediaContent.setContentUrl(absolutePath);
        this.$content$inlined.optimizeContentType();
        Continuation continuation = this.$continuation;
        MediaContent mediaContent2 = this.$content$inlined;
        Result.Companion companion = Result.Companion;
        continuation.resumeWith(Result.m1029constructorimpl(mediaContent2));
    }

    public void onError(String str) {
        Intrinsics.checkNotNullParameter(str, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        this.this$0.hideBlockingProgress();
        Continuation continuation = this.$continuation;
        Result.Companion companion = Result.Companion;
        continuation.resumeWith(Result.m1029constructorimpl((Object) null));
    }
}
