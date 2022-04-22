package com.getstream.sdk.chat.utils.exomedia.core.video;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.os.Build;
import android.util.AttributeSet;
import android.view.TextureView;
import android.view.View;
import android.view.ViewTreeObserver;
import com.getstream.sdk.chat.utils.exomedia.core.video.scale.MatrixManager;
import com.getstream.sdk.chat.utils.exomedia.core.video.scale.ScaleType;
import java.util.concurrent.locks.ReentrantLock;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import p015io.getstream.chat.android.client.logger.ChatLogger;
import p015io.getstream.chat.android.client.logger.TaggedLogger;

public class ResizingTextureView extends TextureView implements ClearableSurface {
    private static final int EGL_CONTEXT_CLIENT_VERSION = 12440;
    private static final int[] GL_CLEAR_CONFIG_ATTRIBUTES = {12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, 4, 12344, 0, 12344};
    private static final int[] GL_CLEAR_CONTEXT_ATTRIBUTES = {EGL_CONTEXT_CLIENT_VERSION, 2, 12344};
    protected static final int MAX_DEGREES = 360;
    private static final String TAG = "ResizingTextureView";
    protected AttachedListener attachedListener = new AttachedListener();
    protected GlobalLayoutMatrixListener globalLayoutMatrixListener = new GlobalLayoutMatrixListener();
    protected final ReentrantLock globalLayoutMatrixListenerLock = new ReentrantLock(true);
    protected Point lastNotifiedSize = new Point(0, 0);
    private TaggedLogger logger = ChatLogger.Companion.get(this);
    protected MatrixManager matrixManager = new MatrixManager();
    protected boolean measureBasedOnAspectRatio;
    protected OnSizeChangeListener onSizeChangeListener;
    protected int requestedConfigurationRotation = 0;
    protected int requestedUserRotation = 0;
    protected Point videoSize = new Point(0, 0);

    public interface OnSizeChangeListener {
        void onVideoSurfaceSizeChange(int i, int i2);
    }

    public ResizingTextureView(Context context) {
        super(context);
    }

    public ResizingTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ResizingTextureView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public ResizingTextureView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        if (!this.measureBasedOnAspectRatio) {
            super.onMeasure(i, i2);
            notifyOnSizeChangeListener(getMeasuredWidth(), getMeasuredHeight());
            return;
        }
        int defaultSize = getDefaultSize(this.videoSize.x, i);
        int defaultSize2 = getDefaultSize(this.videoSize.y, i2);
        if (this.videoSize.x <= 0 || this.videoSize.y <= 0) {
            setMeasuredDimension(defaultSize, defaultSize2);
            notifyOnSizeChangeListener(defaultSize, defaultSize2);
            return;
        }
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        if (mode == 1073741824 && mode2 == 1073741824) {
            if (this.videoSize.x * size2 < this.videoSize.y * size) {
                size = (this.videoSize.x * size2) / this.videoSize.y;
            } else if (this.videoSize.x * size2 > this.videoSize.y * size) {
                size2 = (this.videoSize.y * size) / this.videoSize.x;
            }
        } else if (mode == 1073741824) {
            int i3 = (this.videoSize.y * size) / this.videoSize.x;
            if (mode2 != Integer.MIN_VALUE || i3 <= size2) {
                size2 = i3;
            }
        } else if (mode2 == 1073741824) {
            int i4 = (this.videoSize.x * size2) / this.videoSize.y;
            if (mode != Integer.MIN_VALUE || i4 <= size) {
                size = i4;
            }
        } else {
            int i5 = this.videoSize.x;
            int i6 = this.videoSize.y;
            if (mode2 != Integer.MIN_VALUE || i6 <= size2) {
                size2 = i6;
            } else {
                i5 = (this.videoSize.x * size2) / this.videoSize.y;
            }
            if (mode != Integer.MIN_VALUE || i5 <= size) {
                size = i5;
            } else {
                size2 = (this.videoSize.y * size) / this.videoSize.x;
            }
        }
        setMeasuredDimension(size, size2);
        notifyOnSizeChangeListener(size, size2);
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(Configuration configuration) {
        updateMatrixOnLayout();
        super.onConfigurationChanged(configuration);
    }

    public void setOnSizeChangeListener(OnSizeChangeListener onSizeChangeListener2) {
        this.onSizeChangeListener = onSizeChangeListener2;
    }

    public void clearSurface() {
        if (getSurfaceTexture() != null) {
            try {
                EGL10 egl10 = (EGL10) EGLContext.getEGL();
                EGLDisplay eglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
                egl10.eglInitialize(eglGetDisplay, (int[]) null);
                EGLConfig[] eGLConfigArr = new EGLConfig[1];
                egl10.eglChooseConfig(eglGetDisplay, GL_CLEAR_CONFIG_ATTRIBUTES, eGLConfigArr, 1, new int[1]);
                EGLContext eglCreateContext = egl10.eglCreateContext(eglGetDisplay, eGLConfigArr[0], EGL10.EGL_NO_CONTEXT, GL_CLEAR_CONTEXT_ATTRIBUTES);
                EGLSurface eglCreateWindowSurface = egl10.eglCreateWindowSurface(eglGetDisplay, eGLConfigArr[0], getSurfaceTexture(), new int[]{12344});
                egl10.eglMakeCurrent(eglGetDisplay, eglCreateWindowSurface, eglCreateWindowSurface, eglCreateContext);
                egl10.eglSwapBuffers(eglGetDisplay, eglCreateWindowSurface);
                egl10.eglDestroySurface(eglGetDisplay, eglCreateWindowSurface);
                egl10.eglMakeCurrent(eglGetDisplay, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
                egl10.eglDestroyContext(eglGetDisplay, eglCreateContext);
                egl10.eglTerminate(eglGetDisplay);
            } catch (Exception e) {
                this.logger.logE("Error clearing surface", (Throwable) e);
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean updateVideoSize(int i, int i2) {
        this.matrixManager.setIntrinsicVideoSize(i, i2);
        updateMatrixOnLayout();
        this.videoSize.x = i;
        this.videoSize.y = i2;
        if (i == 0 || i2 == 0) {
            return false;
        }
        if (Build.VERSION.SDK_INT < 15) {
            return true;
        }
        SurfaceTexture surfaceTexture = getSurfaceTexture();
        if (surfaceTexture == null) {
            return false;
        }
        surfaceTexture.setDefaultBufferSize(i, i2);
        return true;
    }

    public ScaleType getScaleType() {
        return this.matrixManager.getCurrentScaleType();
    }

    public void setScaleType(ScaleType scaleType) {
        this.matrixManager.scale(this, scaleType);
    }

    public void setMeasureBasedOnAspectRatioEnabled(boolean z) {
        this.measureBasedOnAspectRatio = z;
        requestLayout();
    }

    public void setVideoRotation(int i, boolean z) {
        int i2 = z ? i : this.requestedUserRotation;
        if (z) {
            i = this.requestedConfigurationRotation;
        }
        setVideoRotation(i2, i);
    }

    public void setVideoRotation(int i, int i2) {
        this.requestedUserRotation = i;
        this.requestedConfigurationRotation = i2;
        this.matrixManager.rotate(this, (i + i2) % MAX_DEGREES);
    }

    /* access modifiers changed from: protected */
    public void updateMatrixOnLayout() {
        this.globalLayoutMatrixListenerLock.lock();
        if (getWindowToken() == null) {
            addOnAttachStateChangeListener(this.attachedListener);
        } else {
            getViewTreeObserver().addOnGlobalLayoutListener(this.globalLayoutMatrixListener);
        }
        this.globalLayoutMatrixListenerLock.unlock();
    }

    /* access modifiers changed from: protected */
    public void notifyOnSizeChangeListener(int i, int i2) {
        if (this.lastNotifiedSize.x != i || this.lastNotifiedSize.y != i2) {
            this.lastNotifiedSize.x = i;
            this.lastNotifiedSize.y = i2;
            updateMatrixOnLayout();
            OnSizeChangeListener onSizeChangeListener2 = this.onSizeChangeListener;
            if (onSizeChangeListener2 != null) {
                onSizeChangeListener2.onVideoSurfaceSizeChange(i, i2);
            }
        }
    }

    private class AttachedListener implements View.OnAttachStateChangeListener {
        public void onViewDetachedFromWindow(View view) {
        }

        private AttachedListener() {
        }

        public void onViewAttachedToWindow(View view) {
            ResizingTextureView.this.globalLayoutMatrixListenerLock.lock();
            ResizingTextureView.this.getViewTreeObserver().addOnGlobalLayoutListener(ResizingTextureView.this.globalLayoutMatrixListener);
            ResizingTextureView.this.removeOnAttachStateChangeListener(this);
            ResizingTextureView.this.globalLayoutMatrixListenerLock.unlock();
        }
    }

    private class GlobalLayoutMatrixListener implements ViewTreeObserver.OnGlobalLayoutListener {
        private GlobalLayoutMatrixListener() {
        }

        public void onGlobalLayout() {
            ResizingTextureView resizingTextureView = ResizingTextureView.this;
            resizingTextureView.setScaleType(resizingTextureView.matrixManager.getCurrentScaleType());
            if (Build.VERSION.SDK_INT >= 16) {
                ResizingTextureView.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
            } else {
                ResizingTextureView.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            }
        }
    }
}
