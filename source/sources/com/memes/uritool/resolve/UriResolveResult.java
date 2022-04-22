package com.memes.uritool.resolve;

import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0007\u001a\u00020\u0004J\u0006\u0010\b\u001a\u00020\u0006J\u0006\u0010\t\u001a\u00020\nJ\b\u0010\u000b\u001a\u00020\u0004H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000¨\u0006\r"}, mo26107d2 = {"Lcom/memes/uritool/resolve/UriResolveResult;", "", "()V", "error", "", "file", "Ljava/io/File;", "getError", "getFile", "hasFile", "", "toString", "Companion", "uritool_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: UriResolveResult.kt */
public final class UriResolveResult {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public String error;
    /* access modifiers changed from: private */
    public File file;

    private UriResolveResult() {
    }

    public /* synthetic */ UriResolveResult(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public static final /* synthetic */ String access$getError$p(UriResolveResult uriResolveResult) {
        String str = uriResolveResult.error;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("error");
        }
        return str;
    }

    public static final /* synthetic */ File access$getFile$p(UriResolveResult uriResolveResult) {
        File file2 = uriResolveResult.file;
        if (file2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("file");
        }
        return file2;
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0005J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, mo26107d2 = {"Lcom/memes/uritool/resolve/UriResolveResult$Companion;", "", "()V", "error", "Lcom/memes/uritool/resolve/UriResolveResult;", "", "of", "file", "Ljava/io/File;", "uritool_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* compiled from: UriResolveResult.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: of */
        public final UriResolveResult mo61174of(File file) {
            Intrinsics.checkNotNullParameter(file, "file");
            UriResolveResult uriResolveResult = new UriResolveResult((DefaultConstructorMarker) null);
            uriResolveResult.file = file;
            return uriResolveResult;
        }

        public final UriResolveResult error(String str) {
            Intrinsics.checkNotNullParameter(str, "error");
            UriResolveResult uriResolveResult = new UriResolveResult((DefaultConstructorMarker) null);
            uriResolveResult.error = str;
            return uriResolveResult;
        }
    }

    public final boolean hasFile() {
        return this.file != null;
    }

    public final File getFile() {
        File file2 = this.file;
        if (file2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("file");
        }
        return file2;
    }

    public final String getError() {
        String str = this.error;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("error");
        }
        return str;
    }

    public String toString() {
        String str;
        UriResolveResult uriResolveResult = this;
        String str2 = null;
        if (uriResolveResult.file != null) {
            File file2 = this.file;
            if (file2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("file");
            }
            str = file2.getAbsolutePath();
        } else {
            str = null;
        }
        if (uriResolveResult.error != null && (str2 = this.error) == null) {
            Intrinsics.throwUninitializedPropertyAccessException("error");
        }
        return "UriResolveResult(file=" + str + ", error='" + str2 + "')";
    }
}
