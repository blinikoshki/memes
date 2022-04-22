package kotlin.reflect.jvm.internal.impl.types.model;

import editor.ffmpeg.api.FfmpegCommand;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TypeSystemContext.kt */
public interface TypeSystemOptimizationContext {

    /* compiled from: TypeSystemContext.kt */
    public static final class DefaultImpls {
        public static boolean identicalArguments(TypeSystemOptimizationContext typeSystemOptimizationContext, SimpleTypeMarker simpleTypeMarker, SimpleTypeMarker simpleTypeMarker2) {
            Intrinsics.checkNotNullParameter(typeSystemOptimizationContext, "this");
            Intrinsics.checkNotNullParameter(simpleTypeMarker, FfmpegCommand.AUDIO_STREAM);
            Intrinsics.checkNotNullParameter(simpleTypeMarker2, "b");
            return false;
        }
    }

    boolean identicalArguments(SimpleTypeMarker simpleTypeMarker, SimpleTypeMarker simpleTypeMarker2);
}
