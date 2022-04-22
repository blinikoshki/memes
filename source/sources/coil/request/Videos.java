package coil.request;

import coil.fetch.VideoFrameFetcher;
import coil.request.ImageRequest;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.lang3.ClassUtils;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0011\u0010\u0000\u001a\u0004\u0018\u00010\u0003*\u00020\u0004¢\u0006\u0002\u0010\u0005\u001a\u0012\u0010\u0006\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u0003\u001a\u0012\u0010\b\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\t\u001a\u00020\n\u001a\u0011\u0010\b\u001a\u0004\u0018\u00010\n*\u00020\u0004¢\u0006\u0002\u0010\u000b¨\u0006\f"}, mo26107d2 = {"videoFrameMicros", "Lcoil/request/ImageRequest$Builder;", "frameMicros", "", "Lcoil/request/Parameters;", "(Lcoil/request/Parameters;)Ljava/lang/Long;", "videoFrameMillis", "frameMillis", "videoFrameOption", "option", "", "(Lcoil/request/Parameters;)Ljava/lang/Integer;", "coil-video_release"}, mo26108k = 2, mo26109mv = {1, 4, 1})
/* compiled from: Videos.kt */
public final class Videos {
    public static final ImageRequest.Builder videoFrameMillis(ImageRequest.Builder builder, long j) {
        Intrinsics.checkNotNullParameter(builder, "$this$videoFrameMillis");
        return videoFrameMicros(builder, ((long) 1000) * j);
    }

    public static final ImageRequest.Builder videoFrameMicros(ImageRequest.Builder builder, long j) {
        Intrinsics.checkNotNullParameter(builder, "$this$videoFrameMicros");
        if (j >= 0) {
            return ImageRequest.Builder.setParameter$default(builder, VideoFrameFetcher.VIDEO_FRAME_MICROS_KEY, Long.valueOf(j), (String) null, 4, (Object) null);
        }
        throw new IllegalArgumentException("frameMicros must be >= 0.".toString());
    }

    public static final ImageRequest.Builder videoFrameOption(ImageRequest.Builder builder, int i) {
        Intrinsics.checkNotNullParameter(builder, "$this$videoFrameOption");
        boolean z = true;
        if (!(i == 0 || i == 1 || i == 2 || i == 3)) {
            z = false;
        }
        if (z) {
            return ImageRequest.Builder.setParameter$default(builder, VideoFrameFetcher.VIDEO_FRAME_OPTION_KEY, Integer.valueOf(i), (String) null, 4, (Object) null);
        }
        throw new IllegalArgumentException(("Invalid video frame option: " + i + ClassUtils.PACKAGE_SEPARATOR_CHAR).toString());
    }

    public static final Long videoFrameMicros(Parameters parameters) {
        Intrinsics.checkNotNullParameter(parameters, "$this$videoFrameMicros");
        return (Long) parameters.value(VideoFrameFetcher.VIDEO_FRAME_MICROS_KEY);
    }

    public static final Integer videoFrameOption(Parameters parameters) {
        Intrinsics.checkNotNullParameter(parameters, "$this$videoFrameOption");
        return (Integer) parameters.value(VideoFrameFetcher.VIDEO_FRAME_OPTION_KEY);
    }
}
