package com.memes.uritool.source;

import android.net.Uri;
import com.facebook.share.internal.ShareConstants;
import com.memes.uritool.resolve.UriResolveResult;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import timber.log.Timber;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, mo26107d2 = {"Lcom/memes/uritool/source/GooglePhotosUriSource;", "Lcom/memes/uritool/source/UriSource;", "uri", "Landroid/net/Uri;", "(Landroid/net/Uri;)V", "isSupportedUri", "", "resolve", "Lcom/memes/uritool/resolve/UriResolveResult;", "uritool_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: GooglePhotosUriSource.kt */
public final class GooglePhotosUriSource implements UriSource {
    private final Uri uri;

    public GooglePhotosUriSource(Uri uri2) {
        Intrinsics.checkNotNullParameter(uri2, ShareConstants.MEDIA_URI);
        this.uri = uri2;
    }

    public boolean isSupportedUri() {
        String authority = this.uri.getAuthority();
        CharSequence charSequence = authority;
        if ((charSequence == null || StringsKt.isBlank(charSequence)) || !StringsKt.startsWith$default(authority, "com.google.android.apps.photos.content", false, 2, (Object) null)) {
            return false;
        }
        return true;
    }

    public UriResolveResult resolve() {
        String lastPathSegment = this.uri.getLastPathSegment();
        CharSequence charSequence = lastPathSegment;
        if (charSequence == null || StringsKt.isBlank(charSequence)) {
            Timber.m300d("Failed to resolve google-photos uri with invalid path.", new Object[0]);
            return UriResolveResult.Companion.error("Failed to resolve google-photos uri with invalid path.");
        }
        File file = new File(lastPathSegment);
        if (file.exists()) {
            return UriResolveResult.Companion.mo61174of(file);
        }
        Timber.m300d("File pointed by google-photos uri doesn't exist; file=" + file, new Object[0]);
        return UriResolveResult.Companion.error("File pointed by google-photos uri doesn't exist.");
    }
}
