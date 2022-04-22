package coil.fetch;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import coil.bitmap.BitmapPool;
import coil.decode.DataSource;
import coil.decode.DrawableDecoderService;
import coil.decode.Options;
import coil.fetch.Fetcher;
import coil.size.Size;
import coil.util.Extensions;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J1\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH@ø\u0001\u0000¢\u0006\u0002\u0010\u000fJ\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\n\u001a\u00020\u0002H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, mo26107d2 = {"Lcoil/fetch/DrawableFetcher;", "Lcoil/fetch/Fetcher;", "Landroid/graphics/drawable/Drawable;", "drawableDecoder", "Lcoil/decode/DrawableDecoderService;", "(Lcoil/decode/DrawableDecoderService;)V", "fetch", "Lcoil/fetch/FetchResult;", "pool", "Lcoil/bitmap/BitmapPool;", "data", "size", "Lcoil/size/Size;", "options", "Lcoil/decode/Options;", "(Lcoil/bitmap/BitmapPool;Landroid/graphics/drawable/Drawable;Lcoil/size/Size;Lcoil/decode/Options;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "key", "", "coil-base_release"}, mo26108k = 1, mo26109mv = {1, 4, 1})
/* compiled from: DrawableFetcher.kt */
public final class DrawableFetcher implements Fetcher<Drawable> {
    private final DrawableDecoderService drawableDecoder;

    public String key(Drawable drawable) {
        Intrinsics.checkNotNullParameter(drawable, "data");
        return null;
    }

    public DrawableFetcher(DrawableDecoderService drawableDecoderService) {
        Intrinsics.checkNotNullParameter(drawableDecoderService, "drawableDecoder");
        this.drawableDecoder = drawableDecoderService;
    }

    public boolean handles(Drawable drawable) {
        Intrinsics.checkNotNullParameter(drawable, "data");
        return Fetcher.DefaultImpls.handles(this, drawable);
    }

    public Object fetch(BitmapPool bitmapPool, Drawable drawable, Size size, Options options, Continuation<? super FetchResult> continuation) {
        boolean isVector = Extensions.isVector(drawable);
        if (isVector) {
            Bitmap convert = this.drawableDecoder.convert(drawable, options.getConfig(), size, options.getScale(), options.getAllowInexactSize());
            Resources resources = options.getContext().getResources();
            Intrinsics.checkNotNullExpressionValue(resources, "context.resources");
            drawable = new BitmapDrawable(resources, convert);
        }
        return new DrawableResult(drawable, isVector, DataSource.MEMORY);
    }
}
