package editor.gpu.gpuimage.util;

import com.facebook.imagepipeline.common.RotationOptions;

public enum Rotation {
    NORMAL,
    ROTATION_90,
    ROTATION_180,
    ROTATION_270;

    /* renamed from: editor.gpu.gpuimage.util.Rotation$1 */
    static /* synthetic */ class C47731 {
        static final /* synthetic */ int[] $SwitchMap$editor$gpu$gpuimage$util$Rotation = null;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                editor.gpu.gpuimage.util.Rotation[] r0 = editor.gpu.gpuimage.util.Rotation.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$editor$gpu$gpuimage$util$Rotation = r0
                editor.gpu.gpuimage.util.Rotation r1 = editor.gpu.gpuimage.util.Rotation.NORMAL     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$editor$gpu$gpuimage$util$Rotation     // Catch:{ NoSuchFieldError -> 0x001d }
                editor.gpu.gpuimage.util.Rotation r1 = editor.gpu.gpuimage.util.Rotation.ROTATION_90     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$editor$gpu$gpuimage$util$Rotation     // Catch:{ NoSuchFieldError -> 0x0028 }
                editor.gpu.gpuimage.util.Rotation r1 = editor.gpu.gpuimage.util.Rotation.ROTATION_180     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$editor$gpu$gpuimage$util$Rotation     // Catch:{ NoSuchFieldError -> 0x0033 }
                editor.gpu.gpuimage.util.Rotation r1 = editor.gpu.gpuimage.util.Rotation.ROTATION_270     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: editor.gpu.gpuimage.util.Rotation.C47731.<clinit>():void");
        }
    }

    public int asInt() {
        int i = C47731.$SwitchMap$editor$gpu$gpuimage$util$Rotation[ordinal()];
        if (i == 1) {
            return 0;
        }
        if (i == 2) {
            return 90;
        }
        if (i == 3) {
            return RotationOptions.ROTATE_180;
        }
        if (i == 4) {
            return RotationOptions.ROTATE_270;
        }
        throw new IllegalStateException("Unknown Rotation!");
    }

    public static Rotation fromInt(int i) {
        if (i == 0) {
            return NORMAL;
        }
        if (i == 90) {
            return ROTATION_90;
        }
        if (i == 180) {
            return ROTATION_180;
        }
        if (i == 270) {
            return ROTATION_270;
        }
        if (i == 360) {
            return NORMAL;
        }
        throw new IllegalStateException(i + " is an unknown rotation. Needs to be either 0, 90, 180 or 270!");
    }
}
