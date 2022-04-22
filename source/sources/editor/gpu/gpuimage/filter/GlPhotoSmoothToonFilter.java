package editor.gpu.gpuimage.filter;

public class GlPhotoSmoothToonFilter extends GlPhotoFilterGroup {
    private GlPhotoGaussianBlurFilter blurFilter;
    private GlPhotoToonFilter toonFilter;

    public GlPhotoSmoothToonFilter() {
        GlPhotoGaussianBlurFilter glPhotoGaussianBlurFilter = new GlPhotoGaussianBlurFilter();
        this.blurFilter = glPhotoGaussianBlurFilter;
        addFilter(glPhotoGaussianBlurFilter);
        GlPhotoToonFilter glPhotoToonFilter = new GlPhotoToonFilter();
        this.toonFilter = glPhotoToonFilter;
        addFilter(glPhotoToonFilter);
        getFilters().add(this.blurFilter);
    }

    public void onInitialized() {
        super.onInitialized();
        setBlurSize(0.5f);
        setThreshold(0.2f);
        setQuantizationLevels(10.0f);
    }

    public void setTexelWidth(float f) {
        this.toonFilter.setTexelWidth(f);
    }

    public void setTexelHeight(float f) {
        this.toonFilter.setTexelHeight(f);
    }

    public void setBlurSize(float f) {
        this.blurFilter.setBlurSize(f);
    }

    public void setThreshold(float f) {
        this.toonFilter.setThreshold(f);
    }

    public void setQuantizationLevels(float f) {
        this.toonFilter.setQuantizationLevels(f);
    }
}
