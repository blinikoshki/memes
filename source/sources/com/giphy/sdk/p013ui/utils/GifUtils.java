package com.giphy.sdk.p013ui.utils;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.facebook.imagepipeline.producers.DecodeProducer;
import com.giphy.sdk.core.models.Image;
import com.giphy.sdk.core.models.Images;
import com.giphy.sdk.core.models.Media;
import com.giphy.sdk.core.models.enums.RenditionType;
import com.giphy.sdk.p013ui.ConstantsKt;
import com.giphy.sdk.p013ui.drawables.ImageFormat;
import com.giphy.sdk.p013ui.drawables.ImageUriInfo;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bJ\u001a\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\u00042\b\u0010\f\u001a\u0004\u0018\u00010\rJ\u0010\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0006J\u001a\u0010\u0011\u001a\u0004\u0018\u00010\n2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00042\u0006\u0010\f\u001a\u00020\r¨\u0006\u0013"}, mo26107d2 = {"Lcom/giphy/sdk/ui/utils/GifUtils;", "", "()V", "getImageDataForType", "Lcom/giphy/sdk/core/models/Image;", "gif", "Lcom/giphy/sdk/core/models/Media;", "imageType", "Lcom/giphy/sdk/core/models/enums/RenditionType;", "getImageToLoad", "Lcom/giphy/sdk/ui/drawables/ImageUriInfo;", "imageData", "imageFormat", "Lcom/giphy/sdk/ui/drawables/ImageFormat;", "getViewGifIntent", "Landroid/content/Intent;", "media", "imageToImageUriInfo", "image", "ui-sdk_release"}, mo26108k = 1, mo26109mv = {1, 1, 13})
/* renamed from: com.giphy.sdk.ui.utils.GifUtils */
/* compiled from: GifUtils.kt */
public final class GifUtils {
    public static final GifUtils INSTANCE = new GifUtils();

    @Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 1, 13})
    /* renamed from: com.giphy.sdk.ui.utils.GifUtils$WhenMappings */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[RenditionType.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[RenditionType.original.ordinal()] = 1;
            iArr[RenditionType.downsized.ordinal()] = 2;
            iArr[RenditionType.downsizedMedium.ordinal()] = 3;
            iArr[RenditionType.downsizedLarge.ordinal()] = 4;
            iArr[RenditionType.fixedWidth.ordinal()] = 5;
            iArr[RenditionType.fixedWidthDownsampled.ordinal()] = 6;
            iArr[RenditionType.fixedWidthStill.ordinal()] = 7;
            iArr[RenditionType.looping.ordinal()] = 8;
            iArr[RenditionType.fixedHeight.ordinal()] = 9;
            int[] iArr2 = new int[ImageFormat.values().length];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[ImageFormat.WEBP.ordinal()] = 1;
            iArr2[ImageFormat.MP4.ordinal()] = 2;
            iArr2[ImageFormat.GIF.ordinal()] = 3;
        }
    }

    private GifUtils() {
    }

    public final Image getImageDataForType(Media media, RenditionType renditionType) {
        Images images;
        Images images2;
        Images images3;
        Images images4;
        Images images5;
        Images images6;
        Images images7;
        Images images8;
        Images images9;
        Intrinsics.checkParameterIsNotNull(renditionType, "imageType");
        switch (WhenMappings.$EnumSwitchMapping$0[renditionType.ordinal()]) {
            case 1:
                if (media == null || (images = media.getImages()) == null) {
                    return null;
                }
                return images.getOriginal();
            case 2:
                if (media == null || (images2 = media.getImages()) == null) {
                    return null;
                }
                return images2.getDownsized();
            case 3:
                if (media == null || (images3 = media.getImages()) == null) {
                    return null;
                }
                return images3.getDownsizedMedium();
            case 4:
                if (media == null || (images4 = media.getImages()) == null) {
                    return null;
                }
                return images4.getDownsizedLarge();
            case 5:
                if (media == null || (images5 = media.getImages()) == null) {
                    return null;
                }
                return images5.getFixedWidth();
            case 6:
                if (media == null || (images6 = media.getImages()) == null) {
                    return null;
                }
                return images6.getFixedWidthDownsampled();
            case 7:
                if (media == null || (images7 = media.getImages()) == null) {
                    return null;
                }
                return images7.getFixedWidthStill();
            case 8:
                if (media == null || (images8 = media.getImages()) == null) {
                    return null;
                }
                return images8.getLooping();
            case 9:
                if (media == null || (images9 = media.getImages()) == null) {
                    return null;
                }
                return images9.getFixedHeight();
            default:
                return null;
        }
    }

    public final ImageUriInfo imageToImageUriInfo(Image image, ImageFormat imageFormat) {
        Intrinsics.checkParameterIsNotNull(imageFormat, DecodeProducer.EXTRA_IMAGE_FORMAT_NAME);
        int i = WhenMappings.$EnumSwitchMapping$1[imageFormat.ordinal()];
        if (i == 1) {
            if (image == null) {
                Intrinsics.throwNpe();
            }
            if (image.getWebPUrl() == null) {
                return null;
            }
            Uri parse = Uri.parse(image.getWebPUrl());
            Intrinsics.checkExpressionValueIsNotNull(parse, "Uri.parse(image.webPUrl)");
            return new ImageUriInfo(parse, image.getWebPSize(), imageFormat);
        } else if (i == 2) {
            if (image == null) {
                Intrinsics.throwNpe();
            }
            if (image.getMp4Url() == null) {
                return null;
            }
            Uri parse2 = Uri.parse(image.getMp4Url());
            Intrinsics.checkExpressionValueIsNotNull(parse2, "Uri.parse(image.mp4Url)");
            return new ImageUriInfo(parse2, image.getMp4Size(), imageFormat);
        } else if (i == 3) {
            if (image == null) {
                Intrinsics.throwNpe();
            }
            if (image.getGifUrl() == null) {
                return null;
            }
            Uri parse3 = Uri.parse(image.getGifUrl());
            Intrinsics.checkExpressionValueIsNotNull(parse3, "Uri.parse(image.gifUrl)");
            return new ImageUriInfo(parse3, image.getGifSize(), imageFormat);
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    public final ImageUriInfo getImageToLoad(Image image, ImageFormat imageFormat) {
        Intrinsics.checkParameterIsNotNull(image, "imageData");
        if (imageFormat != null) {
            return imageToImageUriInfo(image, imageFormat);
        }
        if (TextUtils.isEmpty(image.getWebPUrl())) {
            return imageToImageUriInfo(image, ImageFormat.GIF);
        }
        return imageToImageUriInfo(image, ImageFormat.WEBP);
    }

    public final Intent getViewGifIntent(Media media) {
        Intent intent = new Intent("android.intent.action.VIEW");
        StringBuilder sb = new StringBuilder();
        sb.append(ConstantsKt.GIPHY_GIF_LINK);
        sb.append(media != null ? media.getId() : null);
        intent.setData(Uri.parse(sb.toString()));
        return intent;
    }
}
