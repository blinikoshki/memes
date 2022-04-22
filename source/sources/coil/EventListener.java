package coil;

import android.graphics.Bitmap;
import coil.decode.DecodeResult;
import coil.decode.Decoder;
import coil.decode.Options;
import coil.fetch.FetchResult;
import coil.fetch.Fetcher;
import coil.request.ImageRequest;
import coil.request.ImageResult;
import coil.size.Size;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u0000 (2\u00020\u0001:\u0002()J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0017J \u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0017J,\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\n\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\u000f2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0010H\u0017J$\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\n\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\u000f2\u0006\u0010\b\u001a\u00020\tH\u0017J\u0018\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0014H\u0017J\u0018\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0014H\u0017J\u0010\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0017J\u0018\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u001aH\u0017J\u0010\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0017J\u0018\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u001eH\u0017J\u0018\u0010\u001f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010 \u001a\u00020!H\u0017J\u0010\u0010\"\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0017J\u0018\u0010#\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020$H\u0017J\u0018\u0010%\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020$H\u0017J\u0010\u0010&\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0017J\u0010\u0010'\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0017¨\u0006*"}, mo26107d2 = {"Lcoil/EventListener;", "Lcoil/request/ImageRequest$Listener;", "decodeEnd", "", "request", "Lcoil/request/ImageRequest;", "decoder", "Lcoil/decode/Decoder;", "options", "Lcoil/decode/Options;", "result", "Lcoil/decode/DecodeResult;", "decodeStart", "fetchEnd", "fetcher", "Lcoil/fetch/Fetcher;", "Lcoil/fetch/FetchResult;", "fetchStart", "mapEnd", "output", "", "mapStart", "input", "onCancel", "onError", "throwable", "", "onStart", "onSuccess", "metadata", "Lcoil/request/ImageResult$Metadata;", "resolveSizeEnd", "size", "Lcoil/size/Size;", "resolveSizeStart", "transformEnd", "Landroid/graphics/Bitmap;", "transformStart", "transitionEnd", "transitionStart", "Companion", "Factory", "coil-base_release"}, mo26108k = 1, mo26109mv = {1, 4, 1})
/* compiled from: EventListener.kt */
public interface EventListener extends ImageRequest.Listener {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final EventListener NONE = new EventListener$Companion$NONE$1();

    @Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 4, 1})
    /* compiled from: EventListener.kt */
    public static final class DefaultImpls {
        public static void decodeEnd(EventListener eventListener, ImageRequest imageRequest, Decoder decoder, Options options, DecodeResult decodeResult) {
            Intrinsics.checkNotNullParameter(imageRequest, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
            Intrinsics.checkNotNullParameter(decoder, "decoder");
            Intrinsics.checkNotNullParameter(options, "options");
            Intrinsics.checkNotNullParameter(decodeResult, "result");
        }

        public static void decodeStart(EventListener eventListener, ImageRequest imageRequest, Decoder decoder, Options options) {
            Intrinsics.checkNotNullParameter(imageRequest, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
            Intrinsics.checkNotNullParameter(decoder, "decoder");
            Intrinsics.checkNotNullParameter(options, "options");
        }

        public static void fetchEnd(EventListener eventListener, ImageRequest imageRequest, Fetcher<?> fetcher, Options options, FetchResult fetchResult) {
            Intrinsics.checkNotNullParameter(imageRequest, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
            Intrinsics.checkNotNullParameter(fetcher, "fetcher");
            Intrinsics.checkNotNullParameter(options, "options");
            Intrinsics.checkNotNullParameter(fetchResult, "result");
        }

        public static void fetchStart(EventListener eventListener, ImageRequest imageRequest, Fetcher<?> fetcher, Options options) {
            Intrinsics.checkNotNullParameter(imageRequest, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
            Intrinsics.checkNotNullParameter(fetcher, "fetcher");
            Intrinsics.checkNotNullParameter(options, "options");
        }

        public static void mapEnd(EventListener eventListener, ImageRequest imageRequest, Object obj) {
            Intrinsics.checkNotNullParameter(imageRequest, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
            Intrinsics.checkNotNullParameter(obj, "output");
        }

        public static void mapStart(EventListener eventListener, ImageRequest imageRequest, Object obj) {
            Intrinsics.checkNotNullParameter(imageRequest, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
            Intrinsics.checkNotNullParameter(obj, "input");
        }

        public static void onCancel(EventListener eventListener, ImageRequest imageRequest) {
            Intrinsics.checkNotNullParameter(imageRequest, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        }

        public static void onError(EventListener eventListener, ImageRequest imageRequest, Throwable th) {
            Intrinsics.checkNotNullParameter(imageRequest, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
            Intrinsics.checkNotNullParameter(th, "throwable");
        }

        public static void onStart(EventListener eventListener, ImageRequest imageRequest) {
            Intrinsics.checkNotNullParameter(imageRequest, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        }

        public static void onSuccess(EventListener eventListener, ImageRequest imageRequest, ImageResult.Metadata metadata) {
            Intrinsics.checkNotNullParameter(imageRequest, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
            Intrinsics.checkNotNullParameter(metadata, TtmlNode.TAG_METADATA);
        }

        public static void resolveSizeEnd(EventListener eventListener, ImageRequest imageRequest, Size size) {
            Intrinsics.checkNotNullParameter(imageRequest, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
            Intrinsics.checkNotNullParameter(size, "size");
        }

        public static void resolveSizeStart(EventListener eventListener, ImageRequest imageRequest) {
            Intrinsics.checkNotNullParameter(imageRequest, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        }

        public static void transformEnd(EventListener eventListener, ImageRequest imageRequest, Bitmap bitmap) {
            Intrinsics.checkNotNullParameter(imageRequest, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
            Intrinsics.checkNotNullParameter(bitmap, "output");
        }

        public static void transformStart(EventListener eventListener, ImageRequest imageRequest, Bitmap bitmap) {
            Intrinsics.checkNotNullParameter(imageRequest, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
            Intrinsics.checkNotNullParameter(bitmap, "input");
        }

        public static void transitionEnd(EventListener eventListener, ImageRequest imageRequest) {
            Intrinsics.checkNotNullParameter(imageRequest, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        }

        public static void transitionStart(EventListener eventListener, ImageRequest imageRequest) {
            Intrinsics.checkNotNullParameter(imageRequest, ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID);
        }
    }

    void decodeEnd(ImageRequest imageRequest, Decoder decoder, Options options, DecodeResult decodeResult);

    void decodeStart(ImageRequest imageRequest, Decoder decoder, Options options);

    void fetchEnd(ImageRequest imageRequest, Fetcher<?> fetcher, Options options, FetchResult fetchResult);

    void fetchStart(ImageRequest imageRequest, Fetcher<?> fetcher, Options options);

    void mapEnd(ImageRequest imageRequest, Object obj);

    void mapStart(ImageRequest imageRequest, Object obj);

    void onCancel(ImageRequest imageRequest);

    void onError(ImageRequest imageRequest, Throwable th);

    void onStart(ImageRequest imageRequest);

    void onSuccess(ImageRequest imageRequest, ImageResult.Metadata metadata);

    void resolveSizeEnd(ImageRequest imageRequest, Size size);

    void resolveSizeStart(ImageRequest imageRequest);

    void transformEnd(ImageRequest imageRequest, Bitmap bitmap);

    void transformStart(ImageRequest imageRequest, Bitmap bitmap);

    void transitionEnd(ImageRequest imageRequest);

    void transitionStart(ImageRequest imageRequest);

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bæ\u0001\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0007"}, mo26107d2 = {"Lcoil/EventListener$Factory;", "", "create", "Lcoil/EventListener;", "request", "Lcoil/request/ImageRequest;", "Companion", "coil-base_release"}, mo26108k = 1, mo26109mv = {1, 4, 1})
    /* compiled from: EventListener.kt */
    public interface Factory {
        public static final Companion Companion;
        public static final Factory NONE;

        /* renamed from: coil.EventListener$Factory$-CC  reason: invalid class name */
        /* compiled from: EventListener.kt */
        public final /* synthetic */ class CC {
            @JvmStatic
            public static Factory create(EventListener eventListener) {
                return Factory.Companion.create(eventListener);
            }
        }

        EventListener create(ImageRequest imageRequest);

        @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0002¢\u0006\u0002\b\bR\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000¨\u0006\u0001\u0002\u0007\n\u0005\bF0\u0001¨\u0006\t"}, mo26107d2 = {"Lcoil/EventListener$Factory$Companion;", "", "()V", "NONE", "Lcoil/EventListener$Factory;", "invoke", "listener", "Lcoil/EventListener;", "create", "coil-base_release"}, mo26108k = 1, mo26109mv = {1, 4, 1})
        /* compiled from: EventListener.kt */
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = null;

            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @JvmStatic
            public final Factory create(EventListener eventListener) {
                Intrinsics.checkNotNullParameter(eventListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
                return new EventListener$Factory$Companion$invoke$1(eventListener);
            }
        }

        static {
            Companion companion = new Companion((DefaultConstructorMarker) null);
            Companion = companion;
            NONE = companion.create(EventListener.NONE);
        }
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000¨\u0006\u0001\u0002\u0007\n\u0005\bF0\u0001¨\u0006\u0005"}, mo26107d2 = {"Lcoil/EventListener$Companion;", "", "()V", "NONE", "Lcoil/EventListener;", "coil-base_release"}, mo26108k = 1, mo26109mv = {1, 4, 1})
    /* compiled from: EventListener.kt */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
