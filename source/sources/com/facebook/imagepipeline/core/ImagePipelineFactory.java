package com.facebook.imagepipeline.core;

import android.content.Context;
import android.os.Build;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.disk.FileCache;
import com.facebook.common.internal.AndroidPredicates;
import com.facebook.common.internal.Objects;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.logging.FLog;
import com.facebook.common.memory.PooledByteBuffer;
import com.facebook.common.references.CloseableReference;
import com.facebook.imageformat.ImageFormatChecker;
import com.facebook.imagepipeline.animated.factory.AnimatedFactory;
import com.facebook.imagepipeline.animated.factory.AnimatedFactoryProvider;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactory;
import com.facebook.imagepipeline.bitmaps.PlatformBitmapFactoryProvider;
import com.facebook.imagepipeline.cache.BitmapCountingMemoryCacheFactory;
import com.facebook.imagepipeline.cache.BitmapMemoryCacheFactory;
import com.facebook.imagepipeline.cache.BufferedDiskCache;
import com.facebook.imagepipeline.cache.CountingMemoryCache;
import com.facebook.imagepipeline.cache.EncodedCountingMemoryCacheFactory;
import com.facebook.imagepipeline.cache.EncodedMemoryCacheFactory;
import com.facebook.imagepipeline.cache.InstrumentedMemoryCache;
import com.facebook.imagepipeline.cache.MemoryCache;
import com.facebook.imagepipeline.decoder.DefaultImageDecoder;
import com.facebook.imagepipeline.decoder.ImageDecoder;
import com.facebook.imagepipeline.drawable.DrawableFactory;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.platform.PlatformDecoder;
import com.facebook.imagepipeline.platform.PlatformDecoderFactory;
import com.facebook.imagepipeline.producers.ExperimentalThreadHandoffProducerQueueImpl;
import com.facebook.imagepipeline.producers.ThreadHandoffProducerQueue;
import com.facebook.imagepipeline.producers.ThreadHandoffProducerQueueImpl;
import com.facebook.imagepipeline.systrace.FrescoSystrace;
import com.facebook.imagepipeline.transcoder.ImageTranscoderFactory;
import com.facebook.imagepipeline.transcoder.MultiImageTranscoderFactory;
import com.facebook.imagepipeline.transcoder.SimpleImageTranscoderFactory;
import javax.annotation.Nullable;

public class ImagePipelineFactory {
    private static final Class<?> TAG = ImagePipelineFactory.class;
    private static boolean sForceSinglePipelineInstance;
    private static ImagePipeline sImagePipeline;
    private static ImagePipelineFactory sInstance;
    private AnimatedFactory mAnimatedFactory;
    private CountingMemoryCache<CacheKey, CloseableImage> mBitmapCountingMemoryCache;
    private InstrumentedMemoryCache<CacheKey, CloseableImage> mBitmapMemoryCache;
    private final CloseableReferenceFactory mCloseableReferenceFactory;
    private final ImagePipelineConfig mConfig;
    private CountingMemoryCache<CacheKey, PooledByteBuffer> mEncodedCountingMemoryCache;
    private InstrumentedMemoryCache<CacheKey, PooledByteBuffer> mEncodedMemoryCache;
    private ImageDecoder mImageDecoder;
    private ImagePipeline mImagePipeline;
    private ImageTranscoderFactory mImageTranscoderFactory;
    private BufferedDiskCache mMainBufferedDiskCache;
    private FileCache mMainFileCache;
    private PlatformBitmapFactory mPlatformBitmapFactory;
    private PlatformDecoder mPlatformDecoder;
    private ProducerFactory mProducerFactory;
    private ProducerSequenceFactory mProducerSequenceFactory;
    private BufferedDiskCache mSmallImageBufferedDiskCache;
    private FileCache mSmallImageFileCache;
    private final ThreadHandoffProducerQueue mThreadHandoffProducerQueue;

    public static ImagePipelineFactory getInstance() {
        return (ImagePipelineFactory) Preconditions.checkNotNull(sInstance, "ImagePipelineFactory was not initialized!");
    }

    public static void setInstance(ImagePipelineFactory imagePipelineFactory) {
        sInstance = imagePipelineFactory;
    }

    public static synchronized void initialize(Context context) {
        synchronized (ImagePipelineFactory.class) {
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.beginSection("ImagePipelineFactory#initialize");
            }
            initialize(ImagePipelineConfig.newBuilder(context).build());
            if (FrescoSystrace.isTracing()) {
                FrescoSystrace.endSection();
            }
        }
    }

    public static synchronized void initialize(ImagePipelineConfig imagePipelineConfig, boolean z) {
        synchronized (ImagePipelineFactory.class) {
            if (sInstance != null) {
                FLog.m93w(TAG, "ImagePipelineFactory has already been initialized! `ImagePipelineFactory.initialize(...)` should only be called once to avoid unexpected behavior.");
            }
            sForceSinglePipelineInstance = z;
            sInstance = new ImagePipelineFactory(imagePipelineConfig);
        }
    }

    public static synchronized void initialize(ImagePipelineConfig imagePipelineConfig) {
        synchronized (ImagePipelineFactory.class) {
            if (sInstance != null) {
                FLog.m93w(TAG, "ImagePipelineFactory has already been initialized! `ImagePipelineFactory.initialize(...)` should only be called once to avoid unexpected behavior.");
            }
            sInstance = new ImagePipelineFactory(imagePipelineConfig);
        }
    }

    public static synchronized boolean hasBeenInitialized() {
        boolean z;
        synchronized (ImagePipelineFactory.class) {
            z = sInstance != null;
        }
        return z;
    }

    public static synchronized void shutDown() {
        synchronized (ImagePipelineFactory.class) {
            ImagePipelineFactory imagePipelineFactory = sInstance;
            if (imagePipelineFactory != null) {
                imagePipelineFactory.getBitmapMemoryCache().removeAll(AndroidPredicates.True());
                sInstance.getEncodedMemoryCache().removeAll(AndroidPredicates.True());
                sInstance = null;
            }
        }
    }

    public ImagePipelineFactory(ImagePipelineConfig imagePipelineConfig) {
        ThreadHandoffProducerQueue threadHandoffProducerQueue;
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.beginSection("ImagePipelineConfig()");
        }
        ImagePipelineConfig imagePipelineConfig2 = (ImagePipelineConfig) Preconditions.checkNotNull(imagePipelineConfig);
        this.mConfig = imagePipelineConfig2;
        if (imagePipelineConfig2.getExperiments().isExperimentalThreadHandoffQueueEnabled()) {
            threadHandoffProducerQueue = new ExperimentalThreadHandoffProducerQueueImpl(imagePipelineConfig.getExecutorSupplier().forLightweightBackgroundTasks());
        } else {
            threadHandoffProducerQueue = new ThreadHandoffProducerQueueImpl(imagePipelineConfig.getExecutorSupplier().forLightweightBackgroundTasks());
        }
        this.mThreadHandoffProducerQueue = threadHandoffProducerQueue;
        CloseableReference.setDisableCloseableReferencesForBitmaps(imagePipelineConfig.getExperiments().getBitmapCloseableRefType());
        this.mCloseableReferenceFactory = new CloseableReferenceFactory(imagePipelineConfig.getCloseableReferenceLeakTracker());
        if (FrescoSystrace.isTracing()) {
            FrescoSystrace.endSection();
        }
    }

    @Nullable
    private AnimatedFactory getAnimatedFactory() {
        if (this.mAnimatedFactory == null) {
            this.mAnimatedFactory = AnimatedFactoryProvider.getAnimatedFactory(getPlatformBitmapFactory(), this.mConfig.getExecutorSupplier(), getBitmapCountingMemoryCache(), this.mConfig.getExperiments().shouldDownscaleFrameToDrawableDimensions());
        }
        return this.mAnimatedFactory;
    }

    @Nullable
    public DrawableFactory getAnimatedDrawableFactory(Context context) {
        AnimatedFactory animatedFactory = getAnimatedFactory();
        if (animatedFactory == null) {
            return null;
        }
        return animatedFactory.getAnimatedDrawableFactory(context);
    }

    public CountingMemoryCache<CacheKey, CloseableImage> getBitmapCountingMemoryCache() {
        if (this.mBitmapCountingMemoryCache == null) {
            this.mBitmapCountingMemoryCache = BitmapCountingMemoryCacheFactory.get(this.mConfig.getBitmapMemoryCacheParamsSupplier(), this.mConfig.getMemoryTrimmableRegistry(), this.mConfig.getBitmapMemoryCacheTrimStrategy(), this.mConfig.getBitmapMemoryCacheEntryStateObserver());
        }
        return this.mBitmapCountingMemoryCache;
    }

    public InstrumentedMemoryCache<CacheKey, CloseableImage> getBitmapMemoryCache() {
        MemoryCache memoryCache;
        if (this.mBitmapMemoryCache == null) {
            if (this.mConfig.getBitmapCacheOverride() != null) {
                memoryCache = this.mConfig.getBitmapCacheOverride();
            } else {
                memoryCache = getBitmapCountingMemoryCache();
            }
            this.mBitmapMemoryCache = BitmapMemoryCacheFactory.get(memoryCache, this.mConfig.getImageCacheStatsTracker());
        }
        return this.mBitmapMemoryCache;
    }

    public CountingMemoryCache<CacheKey, PooledByteBuffer> getEncodedCountingMemoryCache() {
        if (this.mEncodedCountingMemoryCache == null) {
            this.mEncodedCountingMemoryCache = EncodedCountingMemoryCacheFactory.get(this.mConfig.getEncodedMemoryCacheParamsSupplier(), this.mConfig.getMemoryTrimmableRegistry());
        }
        return this.mEncodedCountingMemoryCache;
    }

    public InstrumentedMemoryCache<CacheKey, PooledByteBuffer> getEncodedMemoryCache() {
        MemoryCache memoryCache;
        if (this.mEncodedMemoryCache == null) {
            if (this.mConfig.getEncodedMemoryCacheOverride() != null) {
                memoryCache = this.mConfig.getEncodedMemoryCacheOverride();
            } else {
                memoryCache = getEncodedCountingMemoryCache();
            }
            this.mEncodedMemoryCache = EncodedMemoryCacheFactory.get(memoryCache, this.mConfig.getImageCacheStatsTracker());
        }
        return this.mEncodedMemoryCache;
    }

    private ImageDecoder getImageDecoder() {
        ImageDecoder imageDecoder;
        if (this.mImageDecoder == null) {
            if (this.mConfig.getImageDecoder() != null) {
                this.mImageDecoder = this.mConfig.getImageDecoder();
            } else {
                AnimatedFactory animatedFactory = getAnimatedFactory();
                ImageDecoder imageDecoder2 = null;
                if (animatedFactory != null) {
                    imageDecoder2 = animatedFactory.getGifDecoder(this.mConfig.getBitmapConfig());
                    imageDecoder = animatedFactory.getWebPDecoder(this.mConfig.getBitmapConfig());
                } else {
                    imageDecoder = null;
                }
                if (this.mConfig.getImageDecoderConfig() == null) {
                    this.mImageDecoder = new DefaultImageDecoder(imageDecoder2, imageDecoder, getPlatformDecoder());
                } else {
                    this.mImageDecoder = new DefaultImageDecoder(imageDecoder2, imageDecoder, getPlatformDecoder(), this.mConfig.getImageDecoderConfig().getCustomImageDecoders());
                    ImageFormatChecker.getInstance().setCustomImageFormatCheckers(this.mConfig.getImageDecoderConfig().getCustomImageFormats());
                }
            }
        }
        return this.mImageDecoder;
    }

    public BufferedDiskCache getMainBufferedDiskCache() {
        if (this.mMainBufferedDiskCache == null) {
            this.mMainBufferedDiskCache = new BufferedDiskCache(getMainFileCache(), this.mConfig.getPoolFactory().getPooledByteBufferFactory(this.mConfig.getMemoryChunkType()), this.mConfig.getPoolFactory().getPooledByteStreams(), this.mConfig.getExecutorSupplier().forLocalStorageRead(), this.mConfig.getExecutorSupplier().forLocalStorageWrite(), this.mConfig.getImageCacheStatsTracker());
        }
        return this.mMainBufferedDiskCache;
    }

    public FileCache getMainFileCache() {
        if (this.mMainFileCache == null) {
            this.mMainFileCache = this.mConfig.getFileCacheFactory().get(this.mConfig.getMainDiskCacheConfig());
        }
        return this.mMainFileCache;
    }

    public ImagePipeline getImagePipeline() {
        if (sForceSinglePipelineInstance) {
            if (sImagePipeline == null) {
                ImagePipeline createImagePipeline = createImagePipeline();
                sImagePipeline = createImagePipeline;
                this.mImagePipeline = createImagePipeline;
            }
            return sImagePipeline;
        }
        if (this.mImagePipeline == null) {
            this.mImagePipeline = createImagePipeline();
        }
        return this.mImagePipeline;
    }

    private ImagePipeline createImagePipeline() {
        return new ImagePipeline(getProducerSequenceFactory(), this.mConfig.getRequestListeners(), this.mConfig.getRequestListener2s(), this.mConfig.getIsPrefetchEnabledSupplier(), getBitmapMemoryCache(), getEncodedMemoryCache(), getMainBufferedDiskCache(), getSmallImageBufferedDiskCache(), this.mConfig.getCacheKeyFactory(), this.mThreadHandoffProducerQueue, this.mConfig.getExperiments().getSuppressBitmapPrefetchingSupplier(), this.mConfig.getExperiments().isLazyDataSource(), this.mConfig.getCallerContextVerifier(), this.mConfig);
    }

    public PlatformBitmapFactory getPlatformBitmapFactory() {
        if (this.mPlatformBitmapFactory == null) {
            this.mPlatformBitmapFactory = PlatformBitmapFactoryProvider.buildPlatformBitmapFactory(this.mConfig.getPoolFactory(), getPlatformDecoder(), getCloseableReferenceFactory());
        }
        return this.mPlatformBitmapFactory;
    }

    public PlatformDecoder getPlatformDecoder() {
        if (this.mPlatformDecoder == null) {
            this.mPlatformDecoder = PlatformDecoderFactory.buildPlatformDecoder(this.mConfig.getPoolFactory(), this.mConfig.getExperiments().isGingerbreadDecoderEnabled());
        }
        return this.mPlatformDecoder;
    }

    private ProducerFactory getProducerFactory() {
        if (this.mProducerFactory == null) {
            this.mProducerFactory = this.mConfig.getExperiments().getProducerFactoryMethod().createProducerFactory(this.mConfig.getContext(), this.mConfig.getPoolFactory().getSmallByteArrayPool(), getImageDecoder(), this.mConfig.getProgressiveJpegConfig(), this.mConfig.isDownsampleEnabled(), this.mConfig.isResizeAndRotateEnabledForNetwork(), this.mConfig.getExperiments().isDecodeCancellationEnabled(), this.mConfig.getExecutorSupplier(), this.mConfig.getPoolFactory().getPooledByteBufferFactory(this.mConfig.getMemoryChunkType()), getBitmapMemoryCache(), getEncodedMemoryCache(), getMainBufferedDiskCache(), getSmallImageBufferedDiskCache(), this.mConfig.getCacheKeyFactory(), getPlatformBitmapFactory(), this.mConfig.getExperiments().getBitmapPrepareToDrawMinSizeBytes(), this.mConfig.getExperiments().getBitmapPrepareToDrawMaxSizeBytes(), this.mConfig.getExperiments().getBitmapPrepareToDrawForPrefetch(), this.mConfig.getExperiments().getMaxBitmapSize(), getCloseableReferenceFactory(), this.mConfig.getExperiments().shouldKeepCancelledFetchAsLowPriority(), this.mConfig.getExperiments().getTrackedKeysSize());
        }
        return this.mProducerFactory;
    }

    private ProducerSequenceFactory getProducerSequenceFactory() {
        boolean z = Build.VERSION.SDK_INT >= 24 && this.mConfig.getExperiments().getUseBitmapPrepareToDraw();
        if (this.mProducerSequenceFactory == null) {
            this.mProducerSequenceFactory = new ProducerSequenceFactory(this.mConfig.getContext().getApplicationContext().getContentResolver(), getProducerFactory(), this.mConfig.getNetworkFetcher(), this.mConfig.isResizeAndRotateEnabledForNetwork(), this.mConfig.getExperiments().isWebpSupportEnabled(), this.mThreadHandoffProducerQueue, this.mConfig.isDownsampleEnabled(), z, this.mConfig.getExperiments().isPartialImageCachingEnabled(), this.mConfig.isDiskCacheEnabled(), getImageTranscoderFactory(), this.mConfig.getExperiments().isEncodedMemoryCacheProbingEnabled(), this.mConfig.getExperiments().isDiskCacheProbingEnabled());
        }
        return this.mProducerSequenceFactory;
    }

    public FileCache getSmallImageFileCache() {
        if (this.mSmallImageFileCache == null) {
            this.mSmallImageFileCache = this.mConfig.getFileCacheFactory().get(this.mConfig.getSmallImageDiskCacheConfig());
        }
        return this.mSmallImageFileCache;
    }

    public CloseableReferenceFactory getCloseableReferenceFactory() {
        return this.mCloseableReferenceFactory;
    }

    private BufferedDiskCache getSmallImageBufferedDiskCache() {
        if (this.mSmallImageBufferedDiskCache == null) {
            this.mSmallImageBufferedDiskCache = new BufferedDiskCache(getSmallImageFileCache(), this.mConfig.getPoolFactory().getPooledByteBufferFactory(this.mConfig.getMemoryChunkType()), this.mConfig.getPoolFactory().getPooledByteStreams(), this.mConfig.getExecutorSupplier().forLocalStorageRead(), this.mConfig.getExecutorSupplier().forLocalStorageWrite(), this.mConfig.getImageCacheStatsTracker());
        }
        return this.mSmallImageBufferedDiskCache;
    }

    private ImageTranscoderFactory getImageTranscoderFactory() {
        if (this.mImageTranscoderFactory == null) {
            if (this.mConfig.getImageTranscoderFactory() == null && this.mConfig.getImageTranscoderType() == null && this.mConfig.getExperiments().isNativeCodeDisabled()) {
                this.mImageTranscoderFactory = new SimpleImageTranscoderFactory(this.mConfig.getExperiments().getMaxBitmapSize());
            } else {
                this.mImageTranscoderFactory = new MultiImageTranscoderFactory(this.mConfig.getExperiments().getMaxBitmapSize(), this.mConfig.getExperiments().getUseDownsamplingRatioForResizing(), this.mConfig.getImageTranscoderFactory(), this.mConfig.getImageTranscoderType(), this.mConfig.getExperiments().isEnsureTranscoderLibraryLoaded());
            }
        }
        return this.mImageTranscoderFactory;
    }

    @Nullable
    public String reportData() {
        return Objects.toStringHelper("ImagePipelineFactory").add("bitmapCountingMemoryCache", (Object) this.mBitmapCountingMemoryCache.reportData()).add("encodedCountingMemoryCache", (Object) this.mEncodedCountingMemoryCache.reportData()).toString();
    }
}
