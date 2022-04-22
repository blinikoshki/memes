package com.memes.commons.media;

import android.content.Context;
import com.downloader.PRDownloader;
import java.io.File;
import java.net.URL;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.p017io.FilesKt;
import kotlin.text.StringsKt;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u001b2\u00020\u0001:\u0002\u001a\u001bB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0004J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0012J,\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0002J,\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00062\b\u0010\u0015\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0002J\u0006\u0010\b\u001a\u00020\u0000J\u0018\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u0006J\u0010\u0010\u0018\u001a\u00020\u00002\b\u0010\u0019\u001a\u0004\u0018\u00010\u0006R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, mo26107d2 = {"Lcom/memes/commons/media/MediaContentDownloader;", "", "()V", "callback", "Lcom/memes/commons/media/MediaContentDownloader$Callback;", "fileExtension", "", "fileName", "overwrite", "", "storageDirectory", "download", "", "content", "Lcom/memes/commons/media/MediaContent;", "file", "Ljava/io/File;", "url", "Ljava/net/URL;", "downloadLocalFile", "path", "dir", "downloadNetworkFile", "storeAt", "withFileName", "name", "Callback", "Companion", "commons_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: MediaContentDownloader.kt */
public final class MediaContentDownloader {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private Callback callback;
    private String fileExtension;
    private String fileName;
    private boolean overwrite;
    private String storageDirectory;

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\u0010\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH&¨\u0006\f"}, mo26107d2 = {"Lcom/memes/commons/media/MediaContentDownloader$Callback;", "", "onDownloadComplete", "", "file", "Ljava/io/File;", "onError", "message", "", "onProgressChanged", "progress", "", "commons_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: MediaContentDownloader.kt */
    public interface Callback {
        void onDownloadComplete(File file);

        void onError(String str);

        void onProgressChanged(int i);
    }

    private MediaContentDownloader() {
    }

    public /* synthetic */ MediaContentDownloader(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, mo26107d2 = {"Lcom/memes/commons/media/MediaContentDownloader$Companion;", "", "()V", "get", "Lcom/memes/commons/media/MediaContentDownloader;", "initialize", "", "applicationContext", "Landroid/content/Context;", "commons_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: MediaContentDownloader.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void initialize(Context context) {
            Intrinsics.checkNotNullParameter(context, "applicationContext");
            PRDownloader.initialize(context);
        }

        public final MediaContentDownloader get() {
            return new MediaContentDownloader((DefaultConstructorMarker) null);
        }
    }

    public final MediaContentDownloader callback(Callback callback2) {
        Intrinsics.checkNotNullParameter(callback2, "callback");
        this.callback = callback2;
        return this;
    }

    public final MediaContentDownloader storeAt(String str) {
        Intrinsics.checkNotNullParameter(str, "path");
        this.storageDirectory = str;
        return this;
    }

    public static /* synthetic */ MediaContentDownloader storeAt$default(MediaContentDownloader mediaContentDownloader, File file, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = "";
        }
        return mediaContentDownloader.storeAt(file, str);
    }

    public final MediaContentDownloader storeAt(File file, String str) {
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(str, "fileExtension");
        if (file.isDirectory()) {
            this.storageDirectory = file.toString();
        } else {
            File parentFile = file.getParentFile();
            this.storageDirectory = parentFile != null ? parentFile.toString() : null;
        }
        this.fileExtension = str;
        return this;
    }

    public final MediaContentDownloader withFileName(String str) {
        this.fileName = str;
        return this;
    }

    public final MediaContentDownloader overwrite() {
        this.overwrite = true;
        return this;
    }

    public final void download(File file) {
        String str;
        Intrinsics.checkNotNullParameter(file, "file");
        String str2 = this.fileName;
        if (str2 == null) {
            str = UUID.randomUUID().toString() + this.fileExtension;
        } else {
            str = Intrinsics.stringPlus(str2, this.fileExtension);
        }
        if (!file.exists()) {
            Callback callback2 = this.callback;
            if (callback2 != null) {
                callback2.onError("File doesn't exist.");
                return;
            }
            return;
        }
        String absolutePath = file.getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath, "file.absolutePath");
        downloadLocalFile(absolutePath, this.storageDirectory, str, this.callback);
    }

    public final void download(URL url) {
        String str;
        Intrinsics.checkNotNullParameter(url, "url");
        String str2 = this.fileName;
        if (str2 == null) {
            str = UUID.randomUUID().toString() + this.fileExtension;
        } else {
            str = Intrinsics.stringPlus(str2, this.fileExtension);
        }
        String url2 = url.toString();
        Intrinsics.checkNotNullExpressionValue(url2, "url.toString()");
        downloadNetworkFile(url2, this.storageDirectory, str, this.callback);
    }

    public final void download(MediaContent mediaContent) {
        String str;
        Intrinsics.checkNotNullParameter(mediaContent, "content");
        String str2 = this.fileName;
        if (str2 == null) {
            str = UUID.randomUUID().toString() + this.fileExtension;
        } else {
            str = Intrinsics.stringPlus(str2, this.fileExtension);
        }
        String contentUrl = mediaContent.getContentUrl();
        if (StringsKt.isBlank(contentUrl)) {
            Callback callback2 = this.callback;
            if (callback2 != null) {
                callback2.onError("Content url/path is blank.");
            }
        } else if (mediaContent.isLocal()) {
            downloadLocalFile(contentUrl, this.storageDirectory, str, this.callback);
        } else if (mediaContent.isRemote()) {
            downloadNetworkFile(contentUrl, this.storageDirectory, str, this.callback);
        } else {
            Callback callback3 = this.callback;
            if (callback3 != null) {
                callback3.onError("Failed to determine content-source.");
            }
        }
    }

    private final void downloadLocalFile(String str, String str2, String str3, Callback callback2) {
        File file = new File(str);
        if (file.exists()) {
            CharSequence charSequence = str2;
            if (!(charSequence == null || StringsKt.isBlank(charSequence))) {
                File copyTo$default = FilesKt.copyTo$default(file, new File(str2, str3), false, 0, 6, (Object) null);
                if (callback2 != null) {
                    callback2.onDownloadComplete(copyTo$default);
                }
            } else if (callback2 != null) {
                callback2.onError("Unable to download file to selected path.");
            }
        } else if (callback2 != null) {
            callback2.onError("Selected content not found.");
        }
    }

    private final void downloadNetworkFile(String str, String str2, String str3, Callback callback2) {
        if (str2 != null && !this.overwrite) {
            File file = new File(new File(str2), str3);
            if (file.exists()) {
                if (callback2 != null) {
                    callback2.onDownloadComplete(file);
                    return;
                }
                return;
            }
        }
        PRDownloader.download(str, str2, str3).build().setOnProgressListener(new MediaContentDownloader$downloadNetworkFile$1(callback2)).start(new MediaContentDownloader$downloadNetworkFile$2(callback2, str2, str3));
    }
}
