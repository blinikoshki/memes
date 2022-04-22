package editor.gpu.gpuimage;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.hardware.Camera;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.opengl.GLSurfaceView;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import editor.gpu.C4735R;
import editor.gpu.gpuimage.GPUImage;
import editor.gpu.gpuimage.filter.GlPhotoFilter;
import editor.gpu.gpuimage.util.Rotation;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.concurrent.Semaphore;

public class GPUImageView extends FrameLayout {
    public static final int RENDERMODE_CONTINUOUSLY = 1;
    public static final int RENDERMODE_WHEN_DIRTY = 0;
    private GlPhotoFilter filter;
    public Size forceSize = null;
    private GPUImage gpuImage;
    /* access modifiers changed from: private */
    public boolean isShowLoading = true;
    private float ratio = 0.0f;
    private int surfaceType = 0;
    /* access modifiers changed from: private */
    public View surfaceView;

    public interface OnPictureSavedListener {
        void onPictureSaved(Uri uri);
    }

    public GPUImageView(Context context) {
        super(context);
        init(context, (AttributeSet) null);
    }

    public GPUImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet);
    }

    private void init(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, C4735R.styleable.GPUImageView, 0, 0);
            try {
                this.surfaceType = obtainStyledAttributes.getInt(C4735R.styleable.GPUImageView_gpuimage_surface_type, this.surfaceType);
                this.isShowLoading = obtainStyledAttributes.getBoolean(C4735R.styleable.GPUImageView_gpuimage_show_loading, this.isShowLoading);
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
        this.gpuImage = new GPUImage(context);
        if (this.surfaceType == 1) {
            GPUImageGLTextureView gPUImageGLTextureView = new GPUImageGLTextureView(context, attributeSet);
            this.surfaceView = gPUImageGLTextureView;
            this.gpuImage.setGLTextureView(gPUImageGLTextureView);
        } else {
            GPUImageGLSurfaceView gPUImageGLSurfaceView = new GPUImageGLSurfaceView(context, attributeSet);
            this.surfaceView = gPUImageGLSurfaceView;
            this.gpuImage.setGLSurfaceView(gPUImageGLSurfaceView);
        }
        addView(this.surfaceView);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        if (this.ratio != 0.0f) {
            int size = View.MeasureSpec.getSize(i);
            int size2 = View.MeasureSpec.getSize(i2);
            float f = (float) size;
            float f2 = this.ratio;
            float f3 = (float) size2;
            if (f / f2 < f3) {
                size2 = Math.round(f / f2);
            } else {
                size = Math.round(f3 * f2);
            }
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(size2, 1073741824));
            return;
        }
        super.onMeasure(i, i2);
    }

    public GPUImage getGPUImage() {
        return this.gpuImage;
    }

    @Deprecated
    public void setUpCamera(Camera camera) {
        this.gpuImage.setUpCamera(camera);
    }

    @Deprecated
    public void setUpCamera(Camera camera, int i, boolean z, boolean z2) {
        this.gpuImage.setUpCamera(camera, i, z, z2);
    }

    public void updatePreviewFrame(byte[] bArr, int i, int i2) {
        this.gpuImage.updatePreviewFrame(bArr, i, i2);
    }

    public void setBackgroundColor(float f, float f2, float f3) {
        this.gpuImage.setBackgroundColor(f, f2, f3);
    }

    public void setRenderMode(int i) {
        View view = this.surfaceView;
        if (view instanceof GLSurfaceView) {
            ((GLSurfaceView) view).setRenderMode(i);
        } else if (view instanceof GLTextureView) {
            ((GLTextureView) view).setRenderMode(i);
        }
    }

    public void setRatio(float f) {
        this.ratio = f;
        this.surfaceView.requestLayout();
        this.gpuImage.deleteImage();
    }

    public void setScaleType(GPUImage.ScaleType scaleType) {
        this.gpuImage.setScaleType(scaleType);
    }

    public void setRotation(Rotation rotation) {
        this.gpuImage.setRotation(rotation);
        requestRender();
    }

    public void setFilter(GlPhotoFilter glPhotoFilter) {
        this.filter = glPhotoFilter;
        this.gpuImage.setFilter(glPhotoFilter);
        requestRender();
    }

    public GlPhotoFilter getFilter() {
        return this.filter;
    }

    public void setImage(Bitmap bitmap) {
        this.gpuImage.setImage(bitmap);
    }

    public void setImage(Uri uri) {
        this.gpuImage.setImage(uri);
    }

    public void setImage(File file) {
        this.gpuImage.setImage(file);
    }

    public void requestRender() {
        View view = this.surfaceView;
        if (view instanceof GLSurfaceView) {
            ((GLSurfaceView) view).requestRender();
        } else if (view instanceof GLTextureView) {
            ((GLTextureView) view).requestRender();
        }
    }

    public void saveToPictures(String str, String str2, OnPictureSavedListener onPictureSavedListener) {
        new SaveTask(this, str, str2, onPictureSavedListener).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    public void saveToPictures(String str, String str2, int i, int i2, OnPictureSavedListener onPictureSavedListener) {
        new SaveTask(str, str2, i, i2, onPictureSavedListener).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    public Bitmap capture(int i, int i2) throws InterruptedException {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            this.forceSize = new Size(i, i2);
            final Semaphore semaphore = new Semaphore(0);
            getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
                public void onGlobalLayout() {
                    if (Build.VERSION.SDK_INT < 16) {
                        GPUImageView.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                    } else {
                        GPUImageView.this.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                    }
                    semaphore.release();
                }
            });
            post(new Runnable() {
                public void run() {
                    if (GPUImageView.this.isShowLoading) {
                        GPUImageView gPUImageView = GPUImageView.this;
                        GPUImageView gPUImageView2 = GPUImageView.this;
                        gPUImageView.addView(new LoadingView(gPUImageView2.getContext()));
                    }
                    GPUImageView.this.surfaceView.requestLayout();
                }
            });
            semaphore.acquire();
            this.gpuImage.runOnGLThread(new Runnable() {
                public void run() {
                    semaphore.release();
                }
            });
            requestRender();
            semaphore.acquire();
            Bitmap capture = capture();
            this.forceSize = null;
            post(new Runnable() {
                public void run() {
                    GPUImageView.this.surfaceView.requestLayout();
                }
            });
            requestRender();
            if (this.isShowLoading) {
                postDelayed(new Runnable() {
                    public void run() {
                        GPUImageView.this.removeViewAt(1);
                    }
                }, 300);
            }
            return capture;
        }
        throw new IllegalStateException("Do not call this method from the UI thread!");
    }

    public Bitmap capture() throws InterruptedException {
        final Semaphore semaphore = new Semaphore(0);
        final Bitmap createBitmap = Bitmap.createBitmap(this.surfaceView.getMeasuredWidth(), this.surfaceView.getMeasuredHeight(), Bitmap.Config.ARGB_8888);
        this.gpuImage.runOnGLThread(new Runnable() {
            public void run() {
                GPUImageNativeLibrary.adjustBitmap(createBitmap);
                semaphore.release();
            }
        });
        requestRender();
        semaphore.acquire();
        return createBitmap;
    }

    public void onPause() {
        View view = this.surfaceView;
        if (view instanceof GLSurfaceView) {
            ((GLSurfaceView) view).onPause();
        } else if (view instanceof GLTextureView) {
            ((GLTextureView) view).onPause();
        }
    }

    public void onResume() {
        View view = this.surfaceView;
        if (view instanceof GLSurfaceView) {
            ((GLSurfaceView) view).onResume();
        } else if (view instanceof GLTextureView) {
            ((GLTextureView) view).onResume();
        }
    }

    public static class Size {
        int height;
        int width;

        public Size(int i, int i2) {
            this.width = i;
            this.height = i2;
        }
    }

    private class GPUImageGLSurfaceView extends GLSurfaceView {
        public GPUImageGLSurfaceView(Context context) {
            super(context);
        }

        public GPUImageGLSurfaceView(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        /* access modifiers changed from: protected */
        public void onMeasure(int i, int i2) {
            if (GPUImageView.this.forceSize != null) {
                super.onMeasure(View.MeasureSpec.makeMeasureSpec(GPUImageView.this.forceSize.width, 1073741824), View.MeasureSpec.makeMeasureSpec(GPUImageView.this.forceSize.height, 1073741824));
            } else {
                super.onMeasure(i, i2);
            }
        }
    }

    private class GPUImageGLTextureView extends GLTextureView {
        public GPUImageGLTextureView(Context context) {
            super(context);
        }

        public GPUImageGLTextureView(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        /* access modifiers changed from: protected */
        public void onMeasure(int i, int i2) {
            if (GPUImageView.this.forceSize != null) {
                super.onMeasure(View.MeasureSpec.makeMeasureSpec(GPUImageView.this.forceSize.width, 1073741824), View.MeasureSpec.makeMeasureSpec(GPUImageView.this.forceSize.height, 1073741824));
            } else {
                super.onMeasure(i, i2);
            }
        }
    }

    private class LoadingView extends FrameLayout {
        public LoadingView(Context context) {
            super(context);
            init();
        }

        public LoadingView(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            init();
        }

        public LoadingView(Context context, AttributeSet attributeSet, int i) {
            super(context, attributeSet, i);
            init();
        }

        private void init() {
            ProgressBar progressBar = new ProgressBar(getContext());
            progressBar.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 17));
            addView(progressBar);
            setBackgroundColor(-16777216);
        }
    }

    private class SaveTask extends AsyncTask<Void, Void, Void> {
        private final String fileName;
        private final String folderName;
        /* access modifiers changed from: private */
        public final Handler handler;
        private final int height;
        /* access modifiers changed from: private */
        public final OnPictureSavedListener listener;
        private final int width;

        public SaveTask(GPUImageView gPUImageView, String str, String str2, OnPictureSavedListener onPictureSavedListener) {
            this(str, str2, 0, 0, onPictureSavedListener);
        }

        public SaveTask(String str, String str2, int i, int i2, OnPictureSavedListener onPictureSavedListener) {
            this.folderName = str;
            this.fileName = str2;
            this.width = i;
            this.height = i2;
            this.listener = onPictureSavedListener;
            this.handler = new Handler();
        }

        /* access modifiers changed from: protected */
        public Void doInBackground(Void... voidArr) {
            try {
                int i = this.width;
                saveImage(this.folderName, this.fileName, i != 0 ? GPUImageView.this.capture(i, this.height) : GPUImageView.this.capture());
                return null;
            } catch (InterruptedException e) {
                e.printStackTrace();
                return null;
            }
        }

        private void saveImage(String str, String str2, Bitmap bitmap) {
            File externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
            File file = new File(externalStoragePublicDirectory, str + "/" + str2);
            try {
                file.getParentFile().mkdirs();
                bitmap.compress(Bitmap.CompressFormat.JPEG, 80, new FileOutputStream(file));
                MediaScannerConnection.scanFile(GPUImageView.this.getContext(), new String[]{file.toString()}, (String[]) null, new MediaScannerConnection.OnScanCompletedListener() {
                    public void onScanCompleted(String str, final Uri uri) {
                        if (SaveTask.this.listener != null) {
                            SaveTask.this.handler.post(new Runnable() {
                                public void run() {
                                    SaveTask.this.listener.onPictureSaved(uri);
                                }
                            });
                        }
                    }
                });
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
