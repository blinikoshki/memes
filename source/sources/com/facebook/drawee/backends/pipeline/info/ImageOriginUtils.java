package com.facebook.drawee.backends.pipeline.info;

import com.appsflyer.ServerParameters;
import com.facebook.imagepipeline.producers.BitmapMemoryCacheGetProducer;
import com.facebook.imagepipeline.producers.BitmapMemoryCacheProducer;
import com.facebook.imagepipeline.producers.DataFetchProducer;
import com.facebook.imagepipeline.producers.DiskCacheReadProducer;
import com.facebook.imagepipeline.producers.EncodedMemoryCacheProducer;
import com.facebook.imagepipeline.producers.LocalAssetFetchProducer;
import com.facebook.imagepipeline.producers.LocalContentUriFetchProducer;
import com.facebook.imagepipeline.producers.LocalContentUriThumbnailFetchProducer;
import com.facebook.imagepipeline.producers.LocalFileFetchProducer;
import com.facebook.imagepipeline.producers.LocalResourceFetchProducer;
import com.facebook.imagepipeline.producers.LocalVideoThumbnailProducer;
import com.facebook.imagepipeline.producers.NetworkFetchProducer;
import com.facebook.imagepipeline.producers.PartialDiskCacheProducer;
import com.facebook.imagepipeline.producers.PostprocessedBitmapMemoryCacheProducer;
import com.facebook.imagepipeline.producers.QualifiedResourceFetchProducer;
import com.google.android.gms.common.internal.ImagesContract;
import org.apache.commons.lang3.CharUtils;

public class ImageOriginUtils {
    public static String toString(int i) {
        switch (i) {
            case 2:
                return ServerParameters.NETWORK;
            case 3:
                return "disk";
            case 4:
                return "memory_encoded";
            case 5:
                return "memory_bitmap";
            case 6:
                return "memory_bitmap_shortcut";
            case 7:
                return ImagesContract.LOCAL;
            default:
                return "unknown";
        }
    }

    public static int mapProducerNameToImageOrigin(String str) {
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -1917159454:
                if (str.equals(QualifiedResourceFetchProducer.PRODUCER_NAME)) {
                    c = 0;
                    break;
                }
                break;
            case -1914072202:
                if (str.equals(BitmapMemoryCacheGetProducer.PRODUCER_NAME)) {
                    c = 1;
                    break;
                }
                break;
            case -1683996557:
                if (str.equals(LocalResourceFetchProducer.PRODUCER_NAME)) {
                    c = 2;
                    break;
                }
                break;
            case -1579985851:
                if (str.equals(LocalFileFetchProducer.PRODUCER_NAME)) {
                    c = 3;
                    break;
                }
                break;
            case -1307634203:
                if (str.equals(EncodedMemoryCacheProducer.PRODUCER_NAME)) {
                    c = 4;
                    break;
                }
                break;
            case -1224383234:
                if (str.equals(NetworkFetchProducer.PRODUCER_NAME)) {
                    c = 5;
                    break;
                }
                break;
            case 473552259:
                if (str.equals(LocalVideoThumbnailProducer.PRODUCER_NAME)) {
                    c = 6;
                    break;
                }
                break;
            case 656304759:
                if (str.equals(DiskCacheReadProducer.PRODUCER_NAME)) {
                    c = 7;
                    break;
                }
                break;
            case 957714404:
                if (str.equals(BitmapMemoryCacheProducer.PRODUCER_NAME)) {
                    c = 8;
                    break;
                }
                break;
            case 1019542023:
                if (str.equals(LocalAssetFetchProducer.PRODUCER_NAME)) {
                    c = 9;
                    break;
                }
                break;
            case 1023071510:
                if (str.equals(PostprocessedBitmapMemoryCacheProducer.PRODUCER_NAME)) {
                    c = 10;
                    break;
                }
                break;
            case 1721672898:
                if (str.equals(DataFetchProducer.PRODUCER_NAME)) {
                    c = 11;
                    break;
                }
                break;
            case 1793127518:
                if (str.equals(LocalContentUriThumbnailFetchProducer.PRODUCER_NAME)) {
                    c = 12;
                    break;
                }
                break;
            case 2109593398:
                if (str.equals(PartialDiskCacheProducer.PRODUCER_NAME)) {
                    c = CharUtils.f463CR;
                    break;
                }
                break;
            case 2113652014:
                if (str.equals(LocalContentUriFetchProducer.PRODUCER_NAME)) {
                    c = 14;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
            case 2:
            case 3:
            case 6:
            case 9:
            case 11:
            case 12:
            case 14:
                return 7;
            case 1:
            case 8:
            case 10:
                return 5;
            case 4:
                return 4;
            case 5:
                return 2;
            case 7:
            case 13:
                return 3;
            default:
                return 1;
        }
    }

    private ImageOriginUtils() {
    }
}
