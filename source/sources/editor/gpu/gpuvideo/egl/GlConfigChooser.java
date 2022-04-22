package editor.gpu.gpuvideo.egl;

public class GlConfigChooser extends DefaultConfigChooser {
    private static final int EGL_CONTEXT_CLIENT_VERSION = 2;

    public GlConfigChooser(boolean z) {
        super(z, 2);
    }
}
