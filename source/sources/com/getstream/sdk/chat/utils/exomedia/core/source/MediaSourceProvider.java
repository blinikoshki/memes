package com.getstream.sdk.chat.utils.exomedia.core.source;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import com.getstream.sdk.chat.utils.exomedia.ExoMedia;
import com.getstream.sdk.chat.utils.exomedia.core.source.builder.DefaultMediaSourceBuilder;
import com.getstream.sdk.chat.utils.exomedia.core.source.builder.MediaSourceBuilder;
import com.getstream.sdk.chat.utils.exomedia.util.MediaSourceUtil;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.upstream.TransferListener;
import p015io.getstream.chat.android.client.BuildConfig;

public class MediaSourceProvider {
    protected static final String USER_AGENT_FORMAT = "ExoMedia %s / Android %s / %s";
    protected String userAgent = String.format(USER_AGENT_FORMAT, new Object[]{BuildConfig.STREAM_CHAT_VERSION, Build.VERSION.RELEASE, Build.MODEL});

    protected static SourceTypeBuilder findByProviders(Uri uri) {
        SourceTypeBuilder findByScheme = findByScheme(uri);
        if (findByScheme != null) {
            return findByScheme;
        }
        SourceTypeBuilder findByExtension = findByExtension(uri);
        if (findByExtension != null) {
            return findByExtension;
        }
        return findByLooseComparison(uri);
    }

    protected static SourceTypeBuilder findByScheme(Uri uri) {
        String scheme = uri.getScheme();
        if (scheme != null && !scheme.isEmpty()) {
            for (SourceTypeBuilder next : ExoMedia.Data.sourceTypeBuilders) {
                if (next.uriScheme != null && next.uriScheme.equalsIgnoreCase(scheme)) {
                    return next;
                }
            }
        }
        return null;
    }

    protected static SourceTypeBuilder findByExtension(Uri uri) {
        String extension = MediaSourceUtil.getExtension(uri);
        if (extension != null && !extension.isEmpty()) {
            for (SourceTypeBuilder next : ExoMedia.Data.sourceTypeBuilders) {
                if (next.extension != null && next.extension.equalsIgnoreCase(extension)) {
                    return next;
                }
            }
        }
        return null;
    }

    protected static SourceTypeBuilder findByLooseComparison(Uri uri) {
        for (SourceTypeBuilder next : ExoMedia.Data.sourceTypeBuilders) {
            if (next.looseComparisonRegex != null && uri.toString().matches(next.looseComparisonRegex)) {
                return next;
            }
        }
        return null;
    }

    public MediaSource generate(Context context, Handler handler, Uri uri, TransferListener transferListener) {
        SourceTypeBuilder findByProviders = findByProviders(uri);
        return (findByProviders != null ? findByProviders.builder : new DefaultMediaSourceBuilder()).build(context, uri, this.userAgent, handler, transferListener);
    }

    public static class SourceTypeBuilder {
        public final MediaSourceBuilder builder;
        public final String extension;
        public final String looseComparisonRegex;
        public final String uriScheme;

        @Deprecated
        public SourceTypeBuilder(MediaSourceBuilder mediaSourceBuilder, String str, String str2) {
            this(mediaSourceBuilder, (String) null, str, str2);
        }

        public SourceTypeBuilder(MediaSourceBuilder mediaSourceBuilder, String str, String str2, String str3) {
            this.builder = mediaSourceBuilder;
            this.uriScheme = str;
            this.extension = str2;
            this.looseComparisonRegex = str3;
        }
    }
}
