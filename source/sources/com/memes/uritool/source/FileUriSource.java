package com.memes.uritool.source;

import android.net.Uri;
import com.facebook.share.internal.ShareConstants;
import com.memes.uritool.resolve.UriResolveResult;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import timber.log.Timber;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, mo26107d2 = {"Lcom/memes/uritool/source/FileUriSource;", "Lcom/memes/uritool/source/UriSource;", "uri", "Landroid/net/Uri;", "(Landroid/net/Uri;)V", "isSupportedUri", "", "resolve", "Lcom/memes/uritool/resolve/UriResolveResult;", "uritool_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: FileUriSource.kt */
public final class FileUriSource implements UriSource {
    private final Uri uri;

    public FileUriSource(Uri uri2) {
        Intrinsics.checkNotNullParameter(uri2, ShareConstants.MEDIA_URI);
        this.uri = uri2;
    }

    public boolean isSupportedUri() {
        return Intrinsics.areEqual((Object) "file", (Object) this.uri.getScheme());
    }

    public UriResolveResult resolve() {
        String path = this.uri.getPath();
        CharSequence charSequence = path;
        if (charSequence == null || StringsKt.isBlank(charSequence)) {
            return UriResolveResult.Companion.error("File uri doesn't have a valid path.");
        }
        File file = new File(path);
        if (file.exists()) {
            return UriResolveResult.Companion.mo61174of(file);
        }
        Timber.m300d("File pointed by File uri doesn't exist; file=" + file, new Object[0]);
        return UriResolveResult.Companion.error("File pointed by File uri doesn't exist.");
    }
}
