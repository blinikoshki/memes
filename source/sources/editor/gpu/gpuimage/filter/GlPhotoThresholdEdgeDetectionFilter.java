package editor.gpu.gpuimage.filter;

public class GlPhotoThresholdEdgeDetectionFilter extends GlPhotoFilterGroup {
    public GlPhotoThresholdEdgeDetectionFilter() {
        addFilter(new GlPhotoGrayscaleFilter());
        addFilter(new GlPhotoSobelThresholdFilter());
    }

    public void setLineSize(float f) {
        ((GlPhoto3x3TextureSamplingFilter) getFilters().get(1)).setLineSize(f);
    }

    public void setThreshold(float f) {
        ((GlPhotoSobelThresholdFilter) getFilters().get(1)).setThreshold(f);
    }
}
