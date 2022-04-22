package editor.optionsui.addcontent.contentpicker;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelKt;
import com.memes.commons.imageselection.ImageContent;
import com.memes.commons.media.MediaContent;
import com.memes.commons.media.MediaContentDownloader;
import com.memes.commons.output.OutputTargetGenerator;
import editor.common.mediapicker.MediaResolverHelper;
import editor.core.NicoViewModel;
import editor.ffmpeg.api.FfmpegFramework;
import editor.ffmpeg.core.callback.MultimediaFrameworkErrorNotifier;
import editor.ffmpeg.core.callback.OnMultimediaProgressListener;
import editor.util.FfmpegCommandUtil;
import java.io.File;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import timber.log.Timber;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u001b\u0010\u0014\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0015\u001a\u00020\u000bH@ø\u0001\u0000¢\u0006\u0002\u0010\u0016J\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0015\u001a\u00020\u0019J\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0015\u001a\u00020\u000bJ+\u0010\u0017\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH@ø\u0001\u0000¢\u0006\u0002\u0010\u001eJ\u0012\u0010\u001f\u001a\u00020\u00182\b\u0010\u0015\u001a\u0004\u0018\u00010\u000bH\u0002J\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u000b0!J\u001c\u0010\"\u001a\u00020\u00182\b\u0010#\u001a\u0004\u0018\u00010\u001d2\b\u0010$\u001a\u0004\u0018\u00010\u001dH\u0016J\u001a\u0010%\u001a\u00020\u00182\u0006\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010\u001dH\u0016J\u0010\u0010)\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u000bH\u0002R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\f\u001a\u00020\r8BX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006*"}, mo26107d2 = {"Leditor/optionsui/addcontent/contentpicker/ContentPickerViewModel;", "Leditor/core/NicoViewModel;", "Leditor/ffmpeg/core/callback/OnMultimediaProgressListener;", "Leditor/ffmpeg/core/callback/MultimediaFrameworkErrorNotifier;", "ffmpegFramework", "Leditor/ffmpeg/api/FfmpegFramework;", "outputTargetGenerator", "Lcom/memes/commons/output/OutputTargetGenerator;", "(Leditor/ffmpeg/api/FfmpegFramework;Lcom/memes/commons/output/OutputTargetGenerator;)V", "_contentDownloaded", "Landroidx/lifecycle/MutableLiveData;", "Lcom/memes/commons/media/MediaContent;", "commandUtil", "Leditor/util/FfmpegCommandUtil;", "getCommandUtil", "()Leditor/util/FfmpegCommandUtil;", "commandUtil$delegate", "Lkotlin/Lazy;", "downloaderExceptionHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "convertGifToVideo", "content", "(Lcom/memes/commons/media/MediaContent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "download", "", "Lcom/memes/commons/imageselection/ImageContent;", "outputFile", "Ljava/io/File;", "outputExtension", "", "(Lcom/memes/commons/media/MediaContent;Ljava/io/File;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "notifyDownloadComplete", "onContentDownloaded", "Landroidx/lifecycle/LiveData;", "onFrameworkErrorNotificationReceived", "message", "errorLog", "onMultimediaTaskProgressAvailable", "progress", "", "preparedMessage", "processFinalMediaContent", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: ContentPickerViewModel.kt */
public final class ContentPickerViewModel extends NicoViewModel implements OnMultimediaProgressListener, MultimediaFrameworkErrorNotifier {
    private final MutableLiveData<MediaContent> _contentDownloaded = new MutableLiveData<>();
    private final Lazy commandUtil$delegate = LazyKt.lazy(new ContentPickerViewModel$commandUtil$2(this));
    private final CoroutineExceptionHandler downloaderExceptionHandler = new C4842x243878b(CoroutineExceptionHandler.Key, this);
    /* access modifiers changed from: private */
    public final FfmpegFramework ffmpegFramework;
    /* access modifiers changed from: private */
    public final OutputTargetGenerator outputTargetGenerator;

    private final FfmpegCommandUtil getCommandUtil() {
        return (FfmpegCommandUtil) this.commandUtil$delegate.getValue();
    }

    public ContentPickerViewModel(FfmpegFramework ffmpegFramework2, OutputTargetGenerator outputTargetGenerator2) {
        Intrinsics.checkNotNullParameter(ffmpegFramework2, "ffmpegFramework");
        Intrinsics.checkNotNullParameter(outputTargetGenerator2, "outputTargetGenerator");
        this.ffmpegFramework = ffmpegFramework2;
        this.outputTargetGenerator = outputTargetGenerator2;
        ffmpegFramework2.setOnProgressListener(this);
        ffmpegFramework2.setFrameworkErrorNotifier(this);
    }

    public final LiveData<MediaContent> onContentDownloaded() {
        return this._contentDownloaded;
    }

    public final void download(ImageContent imageContent) {
        Intrinsics.checkNotNullParameter(imageContent, "content");
        download(imageContent.getFile().toMediaContent());
    }

    public final void download(MediaContent mediaContent) {
        Intrinsics.checkNotNullParameter(mediaContent, "content");
        Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), this.downloaderExceptionHandler, (CoroutineStart) null, new ContentPickerViewModel$download$1(this, mediaContent, (Continuation) null), 2, (Object) null);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object download(MediaContent mediaContent, File file, String str, Continuation<? super MediaContent> continuation) {
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        showBlockingProgress("Processing...");
        MediaContentDownloader.Companion.get().storeAt(file, str).callback(new C4843x286dea94(safeContinuation, this, file, str, mediaContent)).download(mediaContent);
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ java.lang.Object convertGifToVideo(com.memes.commons.media.MediaContent r10, kotlin.coroutines.Continuation<? super com.memes.commons.media.MediaContent> r11) {
        /*
            r9 = this;
            boolean r0 = r11 instanceof editor.optionsui.addcontent.contentpicker.ContentPickerViewModel$convertGifToVideo$1
            if (r0 == 0) goto L_0x0014
            r0 = r11
            editor.optionsui.addcontent.contentpicker.ContentPickerViewModel$convertGifToVideo$1 r0 = (editor.optionsui.addcontent.contentpicker.ContentPickerViewModel$convertGifToVideo$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r11 = r0.label
            int r11 = r11 - r2
            r0.label = r11
            goto L_0x0019
        L_0x0014:
            editor.optionsui.addcontent.contentpicker.ContentPickerViewModel$convertGifToVideo$1 r0 = new editor.optionsui.addcontent.contentpicker.ContentPickerViewModel$convertGifToVideo$1
            r0.<init>(r9, r11)
        L_0x0019:
            java.lang.Object r11 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x003a
            if (r2 != r3) goto L_0x0032
            java.lang.Object r10 = r0.L$1
            com.memes.commons.media.MediaContent r10 = (com.memes.commons.media.MediaContent) r10
            java.lang.Object r0 = r0.L$0
            editor.optionsui.addcontent.contentpicker.ContentPickerViewModel r0 = (editor.optionsui.addcontent.contentpicker.ContentPickerViewModel) r0
            kotlin.ResultKt.throwOnFailure(r11)
            goto L_0x0058
        L_0x0032:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r11)
            throw r10
        L_0x003a:
            kotlin.ResultKt.throwOnFailure(r11)
            java.lang.String r11 = "Importing Gif..."
            r9.showBlockingProgress(r11)
            editor.util.FfmpegCommandUtil r11 = r9.getCommandUtil()
            java.io.File r2 = r10.asFile()
            r0.L$0 = r9
            r0.L$1 = r10
            r0.label = r3
            java.lang.Object r11 = r11.executeGifToVideoConversionCommand(r2, r0)
            if (r11 != r1) goto L_0x0057
            return r1
        L_0x0057:
            r0 = r9
        L_0x0058:
            r2 = r10
            java.io.File r11 = (java.io.File) r11
            r0.hideBlockingProgress()
            boolean r10 = r11.exists()
            if (r10 != 0) goto L_0x0086
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r11 = "Unable to convert gif(="
            r10.append(r11)
            java.lang.String r11 = r2.getContentUrl()
            r10.append(r11)
            java.lang.String r11 = ") into video. Output file doesn't exist."
            r10.append(r11)
            java.lang.String r10 = r10.toString()
            r11 = 0
            java.lang.Object[] r11 = new java.lang.Object[r11]
            timber.log.Timber.m303e(r10, r11)
            r10 = 0
            return r10
        L_0x0086:
            r3 = 1232(0x4d0, float:1.726E-42)
            java.lang.String r4 = r11.getAbsolutePath()
            java.lang.String r10 = "outputFile.absolutePath"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r10)
            r5 = 0
            r6 = 0
            r7 = 12
            r8 = 0
            com.memes.commons.media.MediaContent r10 = com.memes.commons.media.MediaContent.copy$default(r2, r3, r4, r5, r6, r7, r8)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: editor.optionsui.addcontent.contentpicker.ContentPickerViewModel.convertGifToVideo(com.memes.commons.media.MediaContent, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public final void notifyDownloadComplete(MediaContent mediaContent) {
        this._contentDownloaded.setValue(mediaContent);
    }

    /* access modifiers changed from: private */
    public final MediaContent processFinalMediaContent(MediaContent mediaContent) {
        MediaContent mediaContent2;
        int contentType = mediaContent.contentType();
        if (contentType == 1231) {
            mediaContent2 = MediaResolverHelper.INSTANCE.tryProcessPhoto(mediaContent.contentType(), mediaContent.asFile());
            if (mediaContent2 == null) {
                return mediaContent;
            }
        } else if (!(contentType == 1232 || contentType == 1237) || (mediaContent2 = MediaResolverHelper.INSTANCE.tryProcessVideo(mediaContent.contentType(), mediaContent.asFile())) == null) {
            return mediaContent;
        }
        return mediaContent2;
    }

    public void onMultimediaTaskProgressAvailable(int i, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(i);
        sb.append('%');
        updateBlockingProgress(i, sb.toString());
    }

    public void onFrameworkErrorNotificationReceived(String str, String str2) {
        Timber.m303e(str2, new Object[0]);
    }
}
