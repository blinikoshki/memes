package editor.gpu.gpuvideo.composer;

import com.facebook.imagepipeline.common.RotationOptions;

public enum Rotation {
    NORMAL(0),
    ROTATION_90(90),
    ROTATION_180(RotationOptions.ROTATE_180),
    ROTATION_270(RotationOptions.ROTATE_270);
    
    private final int rotation;

    private Rotation(int i) {
        this.rotation = i;
    }

    public int getRotation() {
        return this.rotation;
    }

    public static Rotation fromInt(int i) {
        for (Rotation rotation2 : values()) {
            if (i == rotation2.getRotation()) {
                return rotation2;
            }
        }
        return NORMAL;
    }
}
