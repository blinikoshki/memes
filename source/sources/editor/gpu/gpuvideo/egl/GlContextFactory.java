package editor.gpu.gpuvideo.egl;

public class GlContextFactory extends DefaultContextFactory {
    private static final int EGL_CONTEXT_CLIENT_VERSION = 2;

    public GlContextFactory() {
        super(2);
    }
}
