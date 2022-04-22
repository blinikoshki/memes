package editor.mediaselection;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelKt;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.memes.commons.media.MediaContent;
import com.memes.commons.media.MediaContentDownloader;
import com.memes.commons.media.MediaType;
import com.memes.commons.output.OutputTargetGenerator;
import com.memes.network.giphy.api.model.GiphyGif;
import com.memes.network.memes.api.model.stockmemes.StockMeme;
import com.memes.network.reddit.api.model.RedditPost;
import editor.core.NicoViewModel;
import editor.ffmpeg.api.FfmpegFramework;
import editor.ffmpeg.core.callback.MultimediaFrameworkErrorNotifier;
import editor.ffmpeg.core.callback.OnMultimediaProgressListener;
import editor.mediaselection.items.MediaSelectionItem;
import editor.mediaselection.localmedia.LocalMedia;
import editor.mediaselection.localmedia.LocalMediaExtKt;
import editor.util.FfmpegCommandUtil;
import java.io.File;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import timber.log.Timber;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u001b\u0010\u0017\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0018\u001a\u00020\u000eH@ø\u0001\u0000¢\u0006\u0002\u0010\u0019J\u0010\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u0010\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u0010\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020 H\u0002J\u001b\u0010!\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0018\u001a\u00020\u000eH@ø\u0001\u0000¢\u0006\u0002\u0010\u0019J+\u0010!\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u000bH@ø\u0001\u0000¢\u0006\u0002\u0010%J\u000e\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)J\u0014\u0010*\u001a\u00020+2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020-0\rJ\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u000b0/J\u0012\u00100\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0/J\u001c\u00101\u001a\u00020'2\b\u00102\u001a\u0004\u0018\u00010\u000b2\b\u00103\u001a\u0004\u0018\u00010\u000bH\u0016J\u001a\u00104\u001a\u00020'2\u0006\u00105\u001a\u0002062\b\u00107\u001a\u0004\u0018\u00010\u000bH\u0016J\u001d\u00108\u001a\u0004\u0018\u00010\u000e2\b\u00109\u001a\u0004\u0018\u00010\u000eH@ø\u0001\u0000¢\u0006\u0002\u0010\u0019R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\nX\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u000f\u001a\u00020\u00108BX\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006:"}, mo26107d2 = {"Leditor/mediaselection/MediaImportViewModel;", "Leditor/core/NicoViewModel;", "Leditor/ffmpeg/core/callback/OnMultimediaProgressListener;", "Leditor/ffmpeg/core/callback/MultimediaFrameworkErrorNotifier;", "ffmpegFramework", "Leditor/ffmpeg/api/FfmpegFramework;", "outputTargetGenerator", "Lcom/memes/commons/output/OutputTargetGenerator;", "(Leditor/ffmpeg/api/FfmpegFramework;Lcom/memes/commons/output/OutputTargetGenerator;)V", "_contentDownloadFailed", "Landroidx/lifecycle/MutableLiveData;", "", "_contentsDownloaded", "", "Lcom/memes/commons/media/MediaContent;", "commandUtil", "Leditor/util/FfmpegCommandUtil;", "getCommandUtil", "()Leditor/util/FfmpegCommandUtil;", "commandUtil$delegate", "Lkotlin/Lazy;", "importExceptionHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "convertGifToVideo", "content", "(Lcom/memes/commons/media/MediaContent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createMediaContent", "giphyGif", "Lcom/memes/network/giphy/api/model/GiphyGif;", "stockMeme", "Lcom/memes/network/memes/api/model/stockmemes/StockMeme;", "redditPost", "Lcom/memes/network/reddit/api/model/RedditPost;", "download", "outputFile", "Ljava/io/File;", "outputExtension", "(Lcom/memes/commons/media/MediaContent;Ljava/io/File;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "import", "", "item", "", "importItems", "Lkotlinx/coroutines/Job;", "items", "Leditor/mediaselection/items/MediaSelectionItem;", "onContentDownloadFailed", "Landroidx/lifecycle/LiveData;", "onContentsDownloaded", "onFrameworkErrorNotificationReceived", "message", "errorLog", "onMultimediaTaskProgressAvailable", "progress", "", "preparedMessage", "processDownloadedContent", "downloadedContent", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: MediaImportViewModel.kt */
public final class MediaImportViewModel extends NicoViewModel implements OnMultimediaProgressListener, MultimediaFrameworkErrorNotifier {
    /* access modifiers changed from: private */
    public final MutableLiveData<String> _contentDownloadFailed = new MutableLiveData<>();
    /* access modifiers changed from: private */
    public final MutableLiveData<List<MediaContent>> _contentsDownloaded = new MutableLiveData<>();
    private final Lazy commandUtil$delegate = LazyKt.lazy(new MediaImportViewModel$commandUtil$2(this));
    /* access modifiers changed from: private */
    public final FfmpegFramework ffmpegFramework;
    private final CoroutineExceptionHandler importExceptionHandler = new C4790x40250309(CoroutineExceptionHandler.Key, this);
    /* access modifiers changed from: private */
    public final OutputTargetGenerator outputTargetGenerator;

    private final FfmpegCommandUtil getCommandUtil() {
        return (FfmpegCommandUtil) this.commandUtil$delegate.getValue();
    }

    public MediaImportViewModel(FfmpegFramework ffmpegFramework2, OutputTargetGenerator outputTargetGenerator2) {
        Intrinsics.checkNotNullParameter(ffmpegFramework2, "ffmpegFramework");
        Intrinsics.checkNotNullParameter(outputTargetGenerator2, "outputTargetGenerator");
        this.ffmpegFramework = ffmpegFramework2;
        this.outputTargetGenerator = outputTargetGenerator2;
    }

    public final LiveData<List<MediaContent>> onContentsDownloaded() {
        return this._contentsDownloaded;
    }

    public final LiveData<String> onContentDownloadFailed() {
        return this._contentDownloadFailed;
    }

    /* renamed from: import  reason: not valid java name */
    public final void m2586import(Object obj) {
        MediaSelectionItem mediaSelectionItem;
        Intrinsics.checkNotNullParameter(obj, "item");
        if (obj instanceof MediaSelectionItem) {
            mediaSelectionItem = (MediaSelectionItem) obj;
        } else if (obj instanceof LocalMedia) {
            mediaSelectionItem = new MediaSelectionItem.LocalContent(LocalMediaExtKt.toIdBasedMedia((LocalMedia) obj));
        } else if (obj instanceof GiphyGif) {
            mediaSelectionItem = new MediaSelectionItem.Giphy((GiphyGif) obj);
        } else if (obj instanceof StockMeme) {
            mediaSelectionItem = new MediaSelectionItem.Meme((StockMeme) obj);
        } else {
            throw new RuntimeException("Use 'MediaSelectionItem' to import content.");
        }
        importItems(CollectionsKt.listOf(mediaSelectionItem));
    }

    public final Job importItems(List<? extends MediaSelectionItem> list) {
        Intrinsics.checkNotNullParameter(list, FirebaseAnalytics.Param.ITEMS);
        return BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), this.importExceptionHandler, (CoroutineStart) null, new MediaImportViewModel$importItems$1(this, list, (Continuation) null), 2, (Object) null);
    }

    /* access modifiers changed from: private */
    public final MediaContent createMediaContent(GiphyGif giphyGif) {
        return new MediaContent(MediaType.NETWORK_VIDEO, giphyGif.getMp4Url(), Integer.valueOf(giphyGif.getWidth()), Integer.valueOf(giphyGif.getHeight()));
    }

    /* access modifiers changed from: private */
    public final MediaContent createMediaContent(StockMeme stockMeme) {
        String absoluteImageUrl = stockMeme.absoluteImageUrl();
        if (absoluteImageUrl != null) {
            return new MediaContent(MediaType.NETWORK_PHOTO, absoluteImageUrl, stockMeme.getThumbWidth(), stockMeme.getThumbHeight());
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    /* access modifiers changed from: private */
    public final MediaContent createMediaContent(RedditPost redditPost) {
        int i;
        RedditPost.Media videoMedia = redditPost.getVideoMedia();
        if (videoMedia == null) {
            videoMedia = redditPost.getImageMedia();
        }
        if (Intrinsics.areEqual((Object) videoMedia, (Object) redditPost.getVideoMedia())) {
            i = MediaType.NETWORK_VIDEO;
        } else if (Intrinsics.areEqual((Object) videoMedia, (Object) redditPost.getImageMedia())) {
            i = MediaType.NETWORK_PHOTO;
        } else {
            throw new RuntimeException("Unknown content-media type in reddit-post: " + redditPost);
        }
        return new MediaContent(i, videoMedia.getThumbnail(), Integer.valueOf(videoMedia.getWidth()), Integer.valueOf(videoMedia.getHeight()));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object download(MediaContent mediaContent, Continuation<? super MediaContent> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new MediaImportViewModel$download$2(this, mediaContent, (Continuation) null), continuation);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object download(MediaContent mediaContent, File file, String str, Continuation<? super MediaContent> continuation) {
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        MediaContentDownloader.Companion.get().storeAt(file, str).callback(new MediaImportViewModel$download$$inlined$suspendCoroutine$lambda$1(safeContinuation, this, file, str, mediaContent)).download(mediaContent);
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x005b  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0075  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ java.lang.Object processDownloadedContent(com.memes.commons.media.MediaContent r5, kotlin.coroutines.Continuation<? super com.memes.commons.media.MediaContent> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof editor.mediaselection.MediaImportViewModel$processDownloadedContent$1
            if (r0 == 0) goto L_0x0014
            r0 = r6
            editor.mediaselection.MediaImportViewModel$processDownloadedContent$1 r0 = (editor.mediaselection.MediaImportViewModel$processDownloadedContent$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L_0x0019
        L_0x0014:
            editor.mediaselection.MediaImportViewModel$processDownloadedContent$1 r0 = new editor.mediaselection.MediaImportViewModel$processDownloadedContent$1
            r0.<init>(r4, r6)
        L_0x0019:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0036
            if (r2 != r3) goto L_0x002e
            java.lang.Object r5 = r0.L$0
            com.memes.commons.media.MediaContent r5 = (com.memes.commons.media.MediaContent) r5
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x004e
        L_0x002e:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0036:
            kotlin.ResultKt.throwOnFailure(r6)
            if (r5 == 0) goto L_0x0087
            int r6 = r5.contentType()
            r2 = 1235(0x4d3, float:1.73E-42)
            if (r6 != r2) goto L_0x0053
            r0.L$0 = r5
            r0.label = r3
            java.lang.Object r6 = r4.convertGifToVideo(r5, r0)
            if (r6 != r1) goto L_0x004e
            return r1
        L_0x004e:
            com.memes.commons.media.MediaContent r6 = (com.memes.commons.media.MediaContent) r6
            if (r6 == 0) goto L_0x0053
            r5 = r6
        L_0x0053:
            int r6 = r5.contentType()
            r0 = 1231(0x4cf, float:1.725E-42)
            if (r6 == r0) goto L_0x0075
            r0 = 1232(0x4d0, float:1.726E-42)
            if (r6 == r0) goto L_0x0064
            r0 = 1237(0x4d5, float:1.733E-42)
            if (r6 == r0) goto L_0x0064
            goto L_0x0086
        L_0x0064:
            editor.common.mediapicker.MediaResolverHelper r6 = editor.common.mediapicker.MediaResolverHelper.INSTANCE
            int r0 = r5.contentType()
            java.io.File r1 = r5.asFile()
            com.memes.commons.media.MediaContent r6 = r6.tryProcessVideo(r0, r1)
            if (r6 == 0) goto L_0x0086
            goto L_0x0085
        L_0x0075:
            editor.common.mediapicker.MediaResolverHelper r6 = editor.common.mediapicker.MediaResolverHelper.INSTANCE
            int r0 = r5.contentType()
            java.io.File r1 = r5.asFile()
            com.memes.commons.media.MediaContent r6 = r6.tryProcessPhoto(r0, r1)
            if (r6 == 0) goto L_0x0086
        L_0x0085:
            r5 = r6
        L_0x0086:
            return r5
        L_0x0087:
            r5 = 0
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: editor.mediaselection.MediaImportViewModel.processDownloadedContent(com.memes.commons.media.MediaContent, kotlin.coroutines.Continuation):java.lang.Object");
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
            boolean r0 = r11 instanceof editor.mediaselection.MediaImportViewModel$convertGifToVideo$1
            if (r0 == 0) goto L_0x0014
            r0 = r11
            editor.mediaselection.MediaImportViewModel$convertGifToVideo$1 r0 = (editor.mediaselection.MediaImportViewModel$convertGifToVideo$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r11 = r0.label
            int r11 = r11 - r2
            r0.label = r11
            goto L_0x0019
        L_0x0014:
            editor.mediaselection.MediaImportViewModel$convertGifToVideo$1 r0 = new editor.mediaselection.MediaImportViewModel$convertGifToVideo$1
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
            editor.mediaselection.MediaImportViewModel r0 = (editor.mediaselection.MediaImportViewModel) r0
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
        throw new UnsupportedOperationException("Method not decompiled: editor.mediaselection.MediaImportViewModel.convertGifToVideo(com.memes.commons.media.MediaContent, kotlin.coroutines.Continuation):java.lang.Object");
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
