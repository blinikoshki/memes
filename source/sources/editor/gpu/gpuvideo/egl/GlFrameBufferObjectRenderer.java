package editor.gpu.gpuvideo.egl;

import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import editor.gpu.gpuvideo.egl.filter.GlVideoFilter;
import java.util.LinkedList;
import java.util.Queue;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public abstract class GlFrameBufferObjectRenderer implements GLSurfaceView.Renderer {
    private GlFramebufferObject framebufferObject;
    private GlVideoFilter normalShader;
    private final Queue<Runnable> runOnDraw = new LinkedList();

    /* access modifiers changed from: protected */
    public void finalize() throws Throwable {
    }

    public abstract void onDrawFrame(GlFramebufferObject glFramebufferObject);

    public abstract void onSurfaceChanged(int i, int i2);

    public abstract void onSurfaceCreated(EGLConfig eGLConfig);

    protected GlFrameBufferObjectRenderer() {
    }

    public final void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        this.framebufferObject = new GlFramebufferObject();
        GlVideoFilter glVideoFilter = new GlVideoFilter();
        this.normalShader = glVideoFilter;
        glVideoFilter.setup();
        onSurfaceCreated(eGLConfig);
    }

    public final void onSurfaceChanged(GL10 gl10, int i, int i2) {
        this.framebufferObject.setup(i, i2);
        this.normalShader.setFrameSize(i, i2);
        onSurfaceChanged(i, i2);
        GLES20.glViewport(0, 0, this.framebufferObject.getWidth(), this.framebufferObject.getHeight());
    }

    public final void onDrawFrame(GL10 gl10) {
        synchronized (this.runOnDraw) {
            while (!this.runOnDraw.isEmpty()) {
                this.runOnDraw.poll().run();
            }
        }
        this.framebufferObject.enable();
        onDrawFrame(this.framebufferObject);
        GLES20.glBindFramebuffer(36160, 0);
        GLES20.glClear(16640);
        this.normalShader.draw(this.framebufferObject.getTexName(), (GlFramebufferObject) null);
    }
}
