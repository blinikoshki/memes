package editor.gpu.gpuimage.filter;

public class GlPhotoEmbossFilter extends GlPhoto3x3ConvolutionFilter {
    private float intensity;

    public GlPhotoEmbossFilter() {
        this(1.0f);
    }

    public GlPhotoEmbossFilter(float f) {
        this.intensity = f;
    }

    public void onInit() {
        super.onInit();
    }

    public void onInitialized() {
        super.onInitialized();
        setIntensity(this.intensity);
    }

    public void setIntensity(float f) {
        this.intensity = f;
        float f2 = -f;
        setConvolutionKernel(new float[]{-2.0f * f, f2, 0.0f, f2, 1.0f, f, 0.0f, f, f * 2.0f});
    }

    public float getIntensity() {
        return this.intensity;
    }
}
