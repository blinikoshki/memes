package com.memes.uritool;

import android.content.Context;
import android.net.Uri;
import com.facebook.share.internal.ShareConstants;
import com.memes.uritool.resolve.UriResolveResult;
import com.memes.uritool.source.ContentUriSource;
import com.memes.uritool.source.DocumentsUriSource;
import com.memes.uritool.source.FileUriSource;
import com.memes.uritool.source.GooglePhotosUriSource;
import com.memes.uritool.source.InputStreamUriSource;
import com.memes.uritool.source.UriSource;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import timber.log.Timber;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J$\u0010\t\u001a\u00020\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rJ&\u0010\u000f\u001a\u00020\u00062\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0010\b\u0002\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rH\u0002J\u000e\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0013R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, mo26107d2 = {"Lcom/memes/uritool/UriResolver;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "resolveResult", "Lcom/memes/uritool/resolve/UriResolveResult;", "uri", "Landroid/net/Uri;", "createResolve", "outputFile", "Ljava/io/File;", "additionalUriSources", "", "Lcom/memes/uritool/source/UriSource;", "createResolveInternal", "setUri", "setUriString", "uriString", "", "Companion", "uritool_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: UriResolver.kt */
public final class UriResolver {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final Context context;
    private UriResolveResult resolveResult;
    private Uri uri;

    private UriResolver(Context context2) {
        this.context = context2;
        Uri uri2 = Uri.EMPTY;
        Intrinsics.checkNotNullExpressionValue(uri2, "Uri.EMPTY");
        this.uri = uri2;
    }

    public /* synthetic */ UriResolver(Context context2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context2);
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, mo26107d2 = {"Lcom/memes/uritool/UriResolver$Companion;", "", "()V", "from", "Lcom/memes/uritool/UriResolver;", "context", "Landroid/content/Context;", "uritool_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: UriResolver.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final UriResolver from(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return new UriResolver(context, (DefaultConstructorMarker) null);
        }
    }

    public final UriResolver setUri(Uri uri2) {
        Intrinsics.checkNotNullParameter(uri2, ShareConstants.MEDIA_URI);
        this.uri = uri2;
        return this;
    }

    public final UriResolver setUriString(String str) {
        Intrinsics.checkNotNullParameter(str, "uriString");
        Uri parse = Uri.parse(str);
        Intrinsics.checkNotNullExpressionValue(parse, "Uri.parse(uriString)");
        return setUri(parse);
    }

    public static /* synthetic */ UriResolveResult createResolve$default(UriResolver uriResolver, File file, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            file = null;
        }
        if ((i & 2) != 0) {
            list = null;
        }
        return uriResolver.createResolve(file, list);
    }

    public final UriResolveResult createResolve(File file, List<? extends UriSource> list) {
        UriResolveResult uriResolveResult;
        Timber.m300d("creating resolve for uri: " + this.uri, new Object[0]);
        try {
            uriResolveResult = createResolveInternal(file, list);
        } catch (Exception unused) {
            uriResolveResult = UriResolveResult.Companion.error("Unable to find file.");
        }
        Timber.m300d("create-resolve returning-result: " + uriResolveResult, new Object[0]);
        return uriResolveResult;
    }

    static /* synthetic */ UriResolveResult createResolveInternal$default(UriResolver uriResolver, File file, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            file = null;
        }
        if ((i & 2) != 0) {
            list = null;
        }
        return uriResolver.createResolveInternal(file, list);
    }

    private final UriResolveResult createResolveInternal(File file, List<? extends UriSource> list) {
        File file2 = file;
        if (Intrinsics.areEqual((Object) this.uri, (Object) Uri.EMPTY)) {
            UriResolveResult error = UriResolveResult.Companion.error("Uri has no resolve.");
            this.resolveResult = error;
            if (error == null) {
                Intrinsics.throwUninitializedPropertyAccessException("resolveResult");
            }
            return error;
        }
        String uri2 = this.uri.toString();
        Intrinsics.checkNotNullExpressionValue(uri2, "uri.toString()");
        CharSequence charSequence = uri2;
        if (!StringsKt.isBlank(charSequence)) {
            File file3 = new File(this.uri.toString());
            if (file3.exists()) {
                return UriResolveResult.Companion.mo61174of(file3);
            }
            if (StringsKt.contains$default(charSequence, (CharSequence) "file://", false, 2, (Object) null)) {
                File file4 = new File("file://" + ((String) StringsKt.split$default(charSequence, new String[]{"file://"}, false, 0, 6, (Object) null).get(1)));
                if (file4.exists()) {
                    return UriResolveResult.Companion.mo61174of(file4);
                }
            }
            if (StringsKt.contains$default(charSequence, (CharSequence) "/storage/emulated/0", false, 2, (Object) null)) {
                File file5 = new File("/storage/emulated/0" + ((String) StringsKt.split$default(charSequence, new String[]{"/storage/emulated/0"}, false, 0, 6, (Object) null).get(1)));
                if (file5.exists()) {
                    return UriResolveResult.Companion.mo61174of(file5);
                }
            }
        }
        DocumentsUriSource documentsUriSource = new DocumentsUriSource(this.context, this.uri);
        if (documentsUriSource.isSupportedUri()) {
            this.resolveResult = documentsUriSource.resolve();
            StringBuilder sb = new StringBuilder();
            sb.append("resolve-result (document-uri): ");
            UriResolveResult uriResolveResult = this.resolveResult;
            if (uriResolveResult == null) {
                Intrinsics.throwUninitializedPropertyAccessException("resolveResult");
            }
            sb.append(uriResolveResult);
            Timber.m300d(sb.toString(), new Object[0]);
            UriResolveResult uriResolveResult2 = this.resolveResult;
            if (uriResolveResult2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("resolveResult");
            }
            if (uriResolveResult2.hasFile()) {
                UriResolveResult uriResolveResult3 = this.resolveResult;
                if (uriResolveResult3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("resolveResult");
                }
                return uriResolveResult3;
            }
        }
        ContentUriSource contentUriSource = new ContentUriSource(this.context, this.uri);
        if (contentUriSource.isSupportedUri()) {
            GooglePhotosUriSource googlePhotosUriSource = new GooglePhotosUriSource(this.uri);
            if (googlePhotosUriSource.isSupportedUri()) {
                this.resolveResult = googlePhotosUriSource.resolve();
                StringBuilder sb2 = new StringBuilder();
                sb2.append("resolve-result (google-photos-uri): ");
                UriResolveResult uriResolveResult4 = this.resolveResult;
                if (uriResolveResult4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("resolveResult");
                }
                sb2.append(uriResolveResult4);
                Timber.m300d(sb2.toString(), new Object[0]);
                UriResolveResult uriResolveResult5 = this.resolveResult;
                if (uriResolveResult5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("resolveResult");
                }
                if (uriResolveResult5.hasFile()) {
                    UriResolveResult uriResolveResult6 = this.resolveResult;
                    if (uriResolveResult6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("resolveResult");
                    }
                    return uriResolveResult6;
                }
            }
            this.resolveResult = contentUriSource.resolve();
            StringBuilder sb3 = new StringBuilder();
            sb3.append("resolve-result (content-uri): ");
            UriResolveResult uriResolveResult7 = this.resolveResult;
            if (uriResolveResult7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("resolveResult");
            }
            sb3.append(uriResolveResult7);
            Timber.m300d(sb3.toString(), new Object[0]);
            UriResolveResult uriResolveResult8 = this.resolveResult;
            if (uriResolveResult8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("resolveResult");
            }
            if (uriResolveResult8.hasFile()) {
                UriResolveResult uriResolveResult9 = this.resolveResult;
                if (uriResolveResult9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("resolveResult");
                }
                return uriResolveResult9;
            }
        }
        FileUriSource fileUriSource = new FileUriSource(this.uri);
        if (fileUriSource.isSupportedUri()) {
            this.resolveResult = fileUriSource.resolve();
            StringBuilder sb4 = new StringBuilder();
            sb4.append("resolve-result (file-uri): ");
            UriResolveResult uriResolveResult10 = this.resolveResult;
            if (uriResolveResult10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("resolveResult");
            }
            sb4.append(uriResolveResult10);
            Timber.m300d(sb4.toString(), new Object[0]);
            UriResolveResult uriResolveResult11 = this.resolveResult;
            if (uriResolveResult11 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("resolveResult");
            }
            if (uriResolveResult11.hasFile()) {
                UriResolveResult uriResolveResult12 = this.resolveResult;
                if (uriResolveResult12 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("resolveResult");
                }
                return uriResolveResult12;
            }
        }
        if (list != null && (!list.isEmpty())) {
            for (UriSource uriSource : list) {
                if (uriSource.isSupportedUri()) {
                    this.resolveResult = uriSource.resolve();
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("resolve-result (additional-uri-");
                    sb5.append(uriSource);
                    sb5.append("): ");
                    UriResolveResult uriResolveResult13 = this.resolveResult;
                    if (uriResolveResult13 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("resolveResult");
                    }
                    sb5.append(uriResolveResult13);
                    Timber.m300d(sb5.toString(), new Object[0]);
                    UriResolveResult uriResolveResult14 = this.resolveResult;
                    if (uriResolveResult14 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("resolveResult");
                    }
                    if (uriResolveResult14.hasFile()) {
                        UriResolveResult uriResolveResult15 = this.resolveResult;
                        if (uriResolveResult15 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("resolveResult");
                        }
                        return uriResolveResult15;
                    }
                }
            }
        }
        if (file2 != null) {
            InputStreamUriSource inputStreamUriSource = new InputStreamUriSource(this.context, this.uri, file2);
            if (inputStreamUriSource.isSupportedUri()) {
                this.resolveResult = inputStreamUriSource.resolve();
                StringBuilder sb6 = new StringBuilder();
                sb6.append("resolve-result (input-stream-uri): ");
                UriResolveResult uriResolveResult16 = this.resolveResult;
                if (uriResolveResult16 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("resolveResult");
                }
                sb6.append(uriResolveResult16);
                Timber.m300d(sb6.toString(), new Object[0]);
                UriResolveResult uriResolveResult17 = this.resolveResult;
                if (uriResolveResult17 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("resolveResult");
                }
                if (uriResolveResult17.hasFile()) {
                    UriResolveResult uriResolveResult18 = this.resolveResult;
                    if (uriResolveResult18 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("resolveResult");
                    }
                    return uriResolveResult18;
                }
            }
        }
        Timber.m300d("Uri didn't match any of the available sources; uri=" + this.uri, new Object[0]);
        return UriResolveResult.Companion.error("File uri didn't match any of the available sources");
    }
}
