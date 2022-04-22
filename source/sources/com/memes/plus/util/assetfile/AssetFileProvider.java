package com.memes.plus.util.assetfile;

import android.content.res.AssetManager;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006H@ø\u0001\u0000¢\u0006\u0002\u0010\u0007J\u0019\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH@ø\u0001\u0000¢\u0006\u0002\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\r"}, mo26107d2 = {"Lcom/memes/plus/util/assetfile/AssetFileProvider;", "", "assets", "Landroid/content/res/AssetManager;", "(Landroid/content/res/AssetManager;)V", "createDefaultProfileThumbBitmap", "Landroid/graphics/Bitmap;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createInputStream", "Ljava/io/InputStream;", "fileName", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: AssetFileProvider.kt */
public final class AssetFileProvider {
    private final AssetManager assets;

    public AssetFileProvider(AssetManager assetManager) {
        Intrinsics.checkNotNullParameter(assetManager, "assets");
        this.assets = assetManager;
    }

    public final Object createInputStream(String str, Continuation<? super InputStream> continuation) {
        InputStream open = this.assets.open(str);
        Intrinsics.checkNotNullExpressionValue(open, "assets.open(fileName)");
        return open;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object createDefaultProfileThumbBitmap(kotlin.coroutines.Continuation<? super android.graphics.Bitmap> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.memes.plus.util.assetfile.AssetFileProvider$createDefaultProfileThumbBitmap$1
            if (r0 == 0) goto L_0x0014
            r0 = r5
            com.memes.plus.util.assetfile.AssetFileProvider$createDefaultProfileThumbBitmap$1 r0 = (com.memes.plus.util.assetfile.AssetFileProvider$createDefaultProfileThumbBitmap$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r5 = r0.label
            int r5 = r5 - r2
            r0.label = r5
            goto L_0x0019
        L_0x0014:
            com.memes.plus.util.assetfile.AssetFileProvider$createDefaultProfileThumbBitmap$1 r0 = new com.memes.plus.util.assetfile.AssetFileProvider$createDefaultProfileThumbBitmap$1
            r0.<init>(r4, r5)
        L_0x0019:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0032
            if (r2 != r3) goto L_0x002a
            kotlin.ResultKt.throwOnFailure(r5)
            goto L_0x0040
        L_0x002a:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L_0x0032:
            kotlin.ResultKt.throwOnFailure(r5)
            r0.label = r3
            java.lang.String r5 = "default/thumb/profile.png"
            java.lang.Object r5 = r4.createInputStream(r5, r0)
            if (r5 != r1) goto L_0x0040
            return r1
        L_0x0040:
            java.io.InputStream r5 = (java.io.InputStream) r5
            android.graphics.BitmapFactory$Options r0 = new android.graphics.BitmapFactory$Options
            r0.<init>()
            r1 = 198(0xc6, float:2.77E-43)
            r0.outWidth = r1
            r0.outHeight = r1
            r1 = 0
            android.graphics.Bitmap r5 = android.graphics.BitmapFactory.decodeStream(r5, r1, r0)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.memes.plus.util.assetfile.AssetFileProvider.createDefaultProfileThumbBitmap(kotlin.coroutines.Continuation):java.lang.Object");
    }
}
