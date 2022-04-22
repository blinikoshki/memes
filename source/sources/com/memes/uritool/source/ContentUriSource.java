package com.memes.uritool.source;

import android.content.Context;
import android.net.Uri;
import com.facebook.share.internal.ShareConstants;
import com.memes.uritool.resolve.UriResolveResult;
import com.memes.uritool.util.ContentResolverUtil;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import timber.log.Timber;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, mo26107d2 = {"Lcom/memes/uritool/source/ContentUriSource;", "Lcom/memes/uritool/source/UriSource;", "context", "Landroid/content/Context;", "uri", "Landroid/net/Uri;", "(Landroid/content/Context;Landroid/net/Uri;)V", "isSupportedUri", "", "resolve", "Lcom/memes/uritool/resolve/UriResolveResult;", "uritool_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: ContentUriSource.kt */
public final class ContentUriSource implements UriSource {
    private final Context context;
    private final Uri uri;

    public ContentUriSource(Context context2, Uri uri2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(uri2, ShareConstants.MEDIA_URI);
        this.context = context2;
        this.uri = uri2;
    }

    public boolean isSupportedUri() {
        return Intrinsics.areEqual((Object) "content", (Object) this.uri.getScheme());
    }

    public UriResolveResult resolve() {
        String dataColumn = ContentResolverUtil.INSTANCE.dataColumn(this.context, this.uri, (String) null, (String[]) null);
        CharSequence charSequence = dataColumn;
        if (charSequence == null || StringsKt.isBlank(charSequence)) {
            Timber.m300d("Failed to resolve content uri with invalid path.", new Object[0]);
            return UriResolveResult.Companion.error("Failed to resolve content uri with invalid path.");
        }
        File file = new File(dataColumn);
        if (file.exists()) {
            return UriResolveResult.Companion.mo61174of(file);
        }
        Timber.m300d("File pointed by content uri doesn't exist; file=" + file, new Object[0]);
        return UriResolveResult.Companion.error("File pointed by content uri doesn't exist.");
    }
}
