package editor.gpu.gpuimage.filter;

import java.util.List;

public class GlPhotoTwoPassFilter extends GlPhotoFilterGroup {
    public GlPhotoTwoPassFilter(String str, String str2, String str3, String str4) {
        super((List<GlPhotoFilter>) null);
        addFilter(new GlPhotoFilter(str, str2));
        addFilter(new GlPhotoFilter(str3, str4));
    }
}
