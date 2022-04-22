package editor.gpu.gpuimage.filter;

import android.opengl.GLES20;

public class GlPhotoMixBlendFilter extends GlPhotoTwoInputFilter {
    private float mix;
    private int mixLocation;

    public GlPhotoMixBlendFilter(String str) {
        this(str, 0.5f);
    }

    public GlPhotoMixBlendFilter(String str, float f) {
        super(str);
        this.mix = f;
    }

    public void onInit() {
        super.onInit();
        this.mixLocation = GLES20.glGetUniformLocation(getProgram(), "mixturePercent");
    }

    public void onInitialized() {
        super.onInitialized();
        setMix(this.mix);
    }

    public void setMix(float f) {
        this.mix = f;
        setFloat(this.mixLocation, f);
    }
}
