package coil.request;

import coil.request.ImageRequest;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0000\u001a\u00020\u0002\u001a\u0011\u0010\u0000\u001a\u0004\u0018\u00010\u0002*\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, mo26107d2 = {"repeatCount", "Lcoil/request/ImageRequest$Builder;", "", "Lcoil/request/Parameters;", "(Lcoil/request/Parameters;)Ljava/lang/Integer;", "coil-gif_release"}, mo26108k = 2, mo26109mv = {1, 4, 1})
/* compiled from: Gifs.kt */
public final class Gifs {
    public static final ImageRequest.Builder repeatCount(ImageRequest.Builder builder, int i) {
        Intrinsics.checkNotNullParameter(builder, "$this$repeatCount");
        if (i >= -1) {
            return ImageRequest.Builder.setParameter$default(builder, "coil#repeat_count", Integer.valueOf(i), (String) null, 4, (Object) null);
        }
        throw new IllegalArgumentException(("Invalid repeatCount: " + i).toString());
    }

    public static final Integer repeatCount(Parameters parameters) {
        Intrinsics.checkNotNullParameter(parameters, "$this$repeatCount");
        return (Integer) parameters.value("coil#repeat_count");
    }
}
