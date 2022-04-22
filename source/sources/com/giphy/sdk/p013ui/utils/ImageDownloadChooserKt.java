package com.giphy.sdk.p013ui.utils;

import android.net.Uri;
import com.facebook.imagepipeline.producers.DecodeProducer;
import com.giphy.sdk.core.models.Image;
import com.giphy.sdk.core.models.Media;
import com.giphy.sdk.core.models.enums.RenditionType;
import com.giphy.sdk.p013ui.drawables.ImageFormat;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0014\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u0006*\u00020\u00012\u0006\u0010\u0007\u001a\u00020\b\u001a\u0014\u0010\t\u001a\u0004\u0018\u00010\u0006*\u00020\u00012\u0006\u0010\u0007\u001a\u00020\b¨\u0006\n"}, mo26107d2 = {"imageWithRenditionType", "Lcom/giphy/sdk/core/models/Image;", "Lcom/giphy/sdk/core/models/Media;", "imageType", "Lcom/giphy/sdk/core/models/enums/RenditionType;", "uriWithFormat", "Landroid/net/Uri;", "imageFormat", "Lcom/giphy/sdk/ui/drawables/ImageFormat;", "uriWithFormatOrFallback", "ui-sdk_release"}, mo26108k = 2, mo26109mv = {1, 1, 13})
/* renamed from: com.giphy.sdk.ui.utils.ImageDownloadChooserKt */
/* compiled from: ImageDownloadChooser.kt */
public final class ImageDownloadChooserKt {

    @Metadata(mo26105bv = {1, 0, 3}, mo26108k = 3, mo26109mv = {1, 1, 13})
    /* renamed from: com.giphy.sdk.ui.utils.ImageDownloadChooserKt$WhenMappings */
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[ImageFormat.values().length];
            $EnumSwitchMapping$0 = iArr;
            iArr[ImageFormat.WEBP.ordinal()] = 1;
            iArr[ImageFormat.MP4.ordinal()] = 2;
            iArr[ImageFormat.GIF.ordinal()] = 3;
            int[] iArr2 = new int[RenditionType.values().length];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[RenditionType.original.ordinal()] = 1;
            iArr2[RenditionType.downsized.ordinal()] = 2;
            iArr2[RenditionType.downsizedMedium.ordinal()] = 3;
            iArr2[RenditionType.downsizedLarge.ordinal()] = 4;
            iArr2[RenditionType.fixedWidth.ordinal()] = 5;
            iArr2[RenditionType.fixedWidthSmall.ordinal()] = 6;
            iArr2[RenditionType.fixedWidthDownsampled.ordinal()] = 7;
            iArr2[RenditionType.fixedWidthStill.ordinal()] = 8;
            iArr2[RenditionType.looping.ordinal()] = 9;
            iArr2[RenditionType.fixedHeight.ordinal()] = 10;
        }
    }

    public static final Uri uriWithFormatOrFallback(Image image, ImageFormat imageFormat) {
        Intrinsics.checkParameterIsNotNull(image, "receiver$0");
        Intrinsics.checkParameterIsNotNull(imageFormat, DecodeProducer.EXTRA_IMAGE_FORMAT_NAME);
        Uri uriWithFormat = uriWithFormat(image, imageFormat);
        if (uriWithFormat == null) {
            uriWithFormat = uriWithFormat(image, ImageFormat.WEBP);
        }
        return uriWithFormat != null ? uriWithFormat : uriWithFormat(image, ImageFormat.GIF);
    }

    public static final Uri uriWithFormat(Image image, ImageFormat imageFormat) {
        Intrinsics.checkParameterIsNotNull(image, "receiver$0");
        Intrinsics.checkParameterIsNotNull(imageFormat, DecodeProducer.EXTRA_IMAGE_FORMAT_NAME);
        int i = WhenMappings.$EnumSwitchMapping$0[imageFormat.ordinal()];
        boolean z = false;
        if (i == 1) {
            CharSequence webPUrl = image.getWebPUrl();
            if (webPUrl == null || webPUrl.length() == 0) {
                z = true;
            }
            if (!z) {
                return Uri.parse(image.getWebPUrl());
            }
            return null;
        } else if (i == 2) {
            CharSequence mp4Url = image.getMp4Url();
            if (mp4Url == null || mp4Url.length() == 0) {
                z = true;
            }
            if (!z) {
                return Uri.parse(image.getMp4Url());
            }
            return null;
        } else if (i == 3) {
            CharSequence gifUrl = image.getGifUrl();
            if (gifUrl == null || gifUrl.length() == 0) {
                z = true;
            }
            if (!z) {
                return Uri.parse(image.getGifUrl());
            }
            return null;
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    public static final Image imageWithRenditionType(Media media, RenditionType renditionType) {
        Intrinsics.checkParameterIsNotNull(media, "receiver$0");
        Intrinsics.checkParameterIsNotNull(renditionType, "imageType");
        switch (WhenMappings.$EnumSwitchMapping$1[renditionType.ordinal()]) {
            case 1:
                return media.getImages().getOriginal();
            case 2:
                return media.getImages().getDownsized();
            case 3:
                return media.getImages().getDownsizedMedium();
            case 4:
                return media.getImages().getDownsizedLarge();
            case 5:
                return media.getImages().getFixedWidth();
            case 6:
                return media.getImages().getFixedWidthSmall();
            case 7:
                return media.getImages().getFixedWidthDownsampled();
            case 8:
                return media.getImages().getFixedWidthStill();
            case 9:
                return media.getImages().getLooping();
            case 10:
                return media.getImages().getFixedHeight();
            default:
                return null;
        }
    }
}
