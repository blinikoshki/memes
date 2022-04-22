package coil;

import android.graphics.Bitmap;
import coil.EventListener;
import coil.decode.DecodeResult;
import coil.decode.Decoder;
import coil.decode.Options;
import coil.fetch.FetchResult;
import coil.fetch.Fetcher;
import coil.request.ImageRequest;
import coil.request.ImageResult;
import coil.size.Size;
import com.facebook.share.internal.ShareConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001¨\u0006\u0002"}, mo26107d2 = {"coil/EventListener$Companion$NONE$1", "Lcoil/EventListener;", "coil-base_release"}, mo26108k = 1, mo26109mv = {1, 4, 1})
/* compiled from: EventListener.kt */
public final class EventListener$Companion$NONE$1 implements EventListener {
    EventListener$Companion$NONE$1() {
    }

    public void decodeEnd(ImageRequest imageRequest, Decoder decoder, Options options, DecodeResult decodeResult) {
        Intrinsics.checkNotNullParameter(imageRequest, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        Intrinsics.checkNotNullParameter(options, "options");
        Intrinsics.checkNotNullParameter(decodeResult, "result");
        EventListener.DefaultImpls.decodeEnd(this, imageRequest, decoder, options, decodeResult);
    }

    public void decodeStart(ImageRequest imageRequest, Decoder decoder, Options options) {
        Intrinsics.checkNotNullParameter(imageRequest, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        Intrinsics.checkNotNullParameter(options, "options");
        EventListener.DefaultImpls.decodeStart(this, imageRequest, decoder, options);
    }

    public void fetchEnd(ImageRequest imageRequest, Fetcher<?> fetcher, Options options, FetchResult fetchResult) {
        Intrinsics.checkNotNullParameter(imageRequest, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        Intrinsics.checkNotNullParameter(fetcher, "fetcher");
        Intrinsics.checkNotNullParameter(options, "options");
        Intrinsics.checkNotNullParameter(fetchResult, "result");
        EventListener.DefaultImpls.fetchEnd(this, imageRequest, fetcher, options, fetchResult);
    }

    public void fetchStart(ImageRequest imageRequest, Fetcher<?> fetcher, Options options) {
        Intrinsics.checkNotNullParameter(imageRequest, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        Intrinsics.checkNotNullParameter(fetcher, "fetcher");
        Intrinsics.checkNotNullParameter(options, "options");
        EventListener.DefaultImpls.fetchStart(this, imageRequest, fetcher, options);
    }

    public void mapEnd(ImageRequest imageRequest, Object obj) {
        Intrinsics.checkNotNullParameter(imageRequest, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        Intrinsics.checkNotNullParameter(obj, "output");
        EventListener.DefaultImpls.mapEnd(this, imageRequest, obj);
    }

    public void mapStart(ImageRequest imageRequest, Object obj) {
        Intrinsics.checkNotNullParameter(imageRequest, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        Intrinsics.checkNotNullParameter(obj, "input");
        EventListener.DefaultImpls.mapStart(this, imageRequest, obj);
    }

    public void onCancel(ImageRequest imageRequest) {
        Intrinsics.checkNotNullParameter(imageRequest, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        EventListener.DefaultImpls.onCancel(this, imageRequest);
    }

    public void onError(ImageRequest imageRequest, Throwable th) {
        Intrinsics.checkNotNullParameter(imageRequest, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        Intrinsics.checkNotNullParameter(th, "throwable");
        EventListener.DefaultImpls.onError(this, imageRequest, th);
    }

    public void onStart(ImageRequest imageRequest) {
        Intrinsics.checkNotNullParameter(imageRequest, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        EventListener.DefaultImpls.onStart(this, imageRequest);
    }

    public void onSuccess(ImageRequest imageRequest, ImageResult.Metadata metadata) {
        Intrinsics.checkNotNullParameter(imageRequest, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        Intrinsics.checkNotNullParameter(metadata, TtmlNode.TAG_METADATA);
        EventListener.DefaultImpls.onSuccess(this, imageRequest, metadata);
    }

    public void resolveSizeEnd(ImageRequest imageRequest, Size size) {
        Intrinsics.checkNotNullParameter(imageRequest, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        Intrinsics.checkNotNullParameter(size, "size");
        EventListener.DefaultImpls.resolveSizeEnd(this, imageRequest, size);
    }

    public void resolveSizeStart(ImageRequest imageRequest) {
        Intrinsics.checkNotNullParameter(imageRequest, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        EventListener.DefaultImpls.resolveSizeStart(this, imageRequest);
    }

    public void transformEnd(ImageRequest imageRequest, Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(imageRequest, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        Intrinsics.checkNotNullParameter(bitmap, "output");
        EventListener.DefaultImpls.transformEnd(this, imageRequest, bitmap);
    }

    public void transformStart(ImageRequest imageRequest, Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(imageRequest, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        Intrinsics.checkNotNullParameter(bitmap, "input");
        EventListener.DefaultImpls.transformStart(this, imageRequest, bitmap);
    }

    public void transitionEnd(ImageRequest imageRequest) {
        Intrinsics.checkNotNullParameter(imageRequest, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        EventListener.DefaultImpls.transitionEnd(this, imageRequest);
    }

    public void transitionStart(ImageRequest imageRequest) {
        Intrinsics.checkNotNullParameter(imageRequest, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        EventListener.DefaultImpls.transitionStart(this, imageRequest);
    }
}
