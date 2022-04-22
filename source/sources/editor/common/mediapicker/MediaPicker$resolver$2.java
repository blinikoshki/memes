package editor.common.mediapicker;

import android.content.Context;
import com.memes.commons.output.OutputTarget;
import com.memes.commons.output.OutputTargetGenerator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo26107d2 = {"<anonymous>", "Leditor/common/mediapicker/MediaResolver;", "invoke"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* compiled from: MediaPicker.kt */
final class MediaPicker$resolver$2 extends Lambda implements Function0<MediaResolver> {
    final /* synthetic */ Context $context;
    final /* synthetic */ OutputTargetGenerator $outputTargetGenerator;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MediaPicker$resolver$2(Context context, OutputTargetGenerator outputTargetGenerator) {
        super(0);
        this.$context = context;
        this.$outputTargetGenerator = outputTargetGenerator;
    }

    public final MediaResolver invoke() {
        return new MediaResolver(this.$context, OutputTarget.FOLDER_CACHE, this.$outputTargetGenerator);
    }
}
