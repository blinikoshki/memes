package com.facebook.imagepipeline.animated.factory;

import com.facebook.imagepipeline.animated.base.AnimatedImage;
import java.nio.ByteBuffer;

public interface AnimatedImageDecoder {
    AnimatedImage decode(long j, int i);

    AnimatedImage decode(ByteBuffer byteBuffer);
}
