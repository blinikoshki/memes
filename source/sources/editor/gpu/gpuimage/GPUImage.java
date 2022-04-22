package editor.gpu.gpuimage;

import android.app.ActivityManager;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.hardware.Camera;
import android.media.ExifInterface;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.opengl.GLSurfaceView;
import android.os.AsyncTask;
import android.os.Environment;
import android.os.Handler;
import android.view.WindowManager;
import com.facebook.imagepipeline.common.RotationOptions;
import editor.gpu.gpuimage.filter.GlPhotoFilter;
import editor.gpu.gpuimage.util.Rotation;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class GPUImage {
    static final int SURFACE_TYPE_SURFACE_VIEW = 0;
    static final int SURFACE_TYPE_TEXTURE_VIEW = 1;
    /* access modifiers changed from: private */
    public final Context context;
    private Bitmap currentBitmap;
    /* access modifiers changed from: private */
    public GlPhotoFilter filter;
    private GLSurfaceView glSurfaceView;
    private GLTextureView glTextureView;
    /* access modifiers changed from: private */
    public final GPUImageRenderer renderer;
    /* access modifiers changed from: private */
    public int scaleHeight;
    /* access modifiers changed from: private */
    public ScaleType scaleType = ScaleType.CENTER_CROP;
    /* access modifiers changed from: private */
    public int scaleWidth;
    private int surfaceType = 0;

    public interface OnPictureSavedListener {
        void onPictureSaved(Uri uri);
    }

    public interface ResponseListener<T> {
        void response(T t);
    }

    public enum ScaleType {
        CENTER_INSIDE,
        CENTER_CROP
    }

    public GPUImage(Context context2) {
        if (supportsOpenGLES2(context2)) {
            this.context = context2;
            GlPhotoFilter glPhotoFilter = new GlPhotoFilter();
            this.filter = glPhotoFilter;
            this.renderer = new GPUImageRenderer(glPhotoFilter);
            return;
        }
        throw new IllegalStateException("OpenGL ES 2.0 is not supported on this phone.");
    }

    private boolean supportsOpenGLES2(Context context2) {
        return ((ActivityManager) context2.getSystemService("activity")).getDeviceConfigurationInfo().reqGlEsVersion >= 131072;
    }

    public void setGLSurfaceView(GLSurfaceView gLSurfaceView) {
        this.surfaceType = 0;
        this.glSurfaceView = gLSurfaceView;
        gLSurfaceView.setEGLContextClientVersion(2);
        this.glSurfaceView.setEGLConfigChooser(8, 8, 8, 8, 16, 0);
        this.glSurfaceView.getHolder().setFormat(1);
        this.glSurfaceView.setRenderer(this.renderer);
        this.glSurfaceView.setRenderMode(0);
        this.glSurfaceView.requestRender();
    }

    public void setGLTextureView(GLTextureView gLTextureView) {
        this.surfaceType = 1;
        this.glTextureView = gLTextureView;
        gLTextureView.setEGLContextClientVersion(2);
        this.glTextureView.setEGLConfigChooser(8, 8, 8, 8, 16, 0);
        this.glTextureView.setOpaque(false);
        this.glTextureView.setRenderer(this.renderer);
        this.glTextureView.setRenderMode(0);
        this.glTextureView.requestRender();
    }

    public void setBackgroundColor(float f, float f2, float f3) {
        this.renderer.setBackgroundColor(f, f2, f3);
    }

    public void requestRender() {
        GLTextureView gLTextureView;
        int i = this.surfaceType;
        if (i == 0) {
            GLSurfaceView gLSurfaceView = this.glSurfaceView;
            if (gLSurfaceView != null) {
                gLSurfaceView.requestRender();
            }
        } else if (i == 1 && (gLTextureView = this.glTextureView) != null) {
            gLTextureView.requestRender();
        }
    }

    @Deprecated
    public void setUpCamera(Camera camera) {
        setUpCamera(camera, 0, false, false);
    }

    @Deprecated
    public void setUpCamera(Camera camera, int i, boolean z, boolean z2) {
        int i2 = this.surfaceType;
        if (i2 == 0) {
            this.glSurfaceView.setRenderMode(1);
        } else if (i2 == 1) {
            this.glTextureView.setRenderMode(1);
        }
        this.renderer.setUpSurfaceTexture(camera);
        Rotation rotation = Rotation.NORMAL;
        if (i == 90) {
            rotation = Rotation.ROTATION_90;
        } else if (i == 180) {
            rotation = Rotation.ROTATION_180;
        } else if (i == 270) {
            rotation = Rotation.ROTATION_270;
        }
        this.renderer.setRotationCamera(rotation, z, z2);
    }

    public void setFilter(GlPhotoFilter glPhotoFilter) {
        this.filter = glPhotoFilter;
        this.renderer.setFilter(glPhotoFilter);
        requestRender();
    }

    public void setImage(Bitmap bitmap) {
        this.currentBitmap = bitmap;
        this.renderer.setImageBitmap(bitmap, false);
        requestRender();
    }

    public void updatePreviewFrame(byte[] bArr, int i, int i2) {
        this.renderer.onPreviewFrame(bArr, i, i2);
    }

    public void setScaleType(ScaleType scaleType2) {
        this.scaleType = scaleType2;
        this.renderer.setScaleType(scaleType2);
        this.renderer.deleteImage();
        this.currentBitmap = null;
        requestRender();
    }

    public int[] getScaleSize() {
        return new int[]{this.scaleWidth, this.scaleHeight};
    }

    public void setRotation(Rotation rotation) {
        this.renderer.setRotation(rotation);
    }

    public void setRotation(Rotation rotation, boolean z, boolean z2) {
        this.renderer.setRotation(rotation, z, z2);
    }

    public void deleteImage() {
        this.renderer.deleteImage();
        this.currentBitmap = null;
        requestRender();
    }

    public void setImage(Uri uri) {
        new LoadImageUriTask(this, uri).execute(new Void[0]);
    }

    public void setImage(File file) {
        new LoadImageFileTask(this, file).execute(new Void[0]);
    }

    private String getPath(Uri uri) {
        Cursor query = this.context.getContentResolver().query(uri, new String[]{"_data"}, (String) null, (String[]) null, (String) null);
        String str = null;
        if (query == null) {
            return null;
        }
        if (query.moveToFirst()) {
            str = query.getString(query.getColumnIndexOrThrow("_data"));
        }
        query.close();
        return str;
    }

    public Bitmap getBitmapWithFilterApplied() {
        return getBitmapWithFilterApplied(this.currentBitmap);
    }

    public Bitmap getBitmapWithFilterApplied(Bitmap bitmap) {
        return getBitmapWithFilterApplied(bitmap, false);
    }

    public Bitmap getBitmapWithFilterApplied(Bitmap bitmap, boolean z) {
        if (!(this.glSurfaceView == null && this.glTextureView == null)) {
            this.renderer.deleteImage();
            this.renderer.runOnDraw(new Runnable() {
                public void run() {
                    synchronized (GPUImage.this.filter) {
                        GPUImage.this.filter.destroy();
                        GPUImage.this.filter.notify();
                    }
                }
            });
            synchronized (this.filter) {
                requestRender();
                try {
                    this.filter.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        GPUImageRenderer gPUImageRenderer = new GPUImageRenderer(this.filter);
        gPUImageRenderer.setRotation(Rotation.NORMAL, this.renderer.isFlippedHorizontally(), this.renderer.isFlippedVertically());
        gPUImageRenderer.setScaleType(this.scaleType);
        PixelBuffer pixelBuffer = new PixelBuffer(bitmap.getWidth(), bitmap.getHeight());
        pixelBuffer.setRenderer(gPUImageRenderer);
        gPUImageRenderer.setImageBitmap(bitmap, z);
        Bitmap bitmap2 = pixelBuffer.getBitmap();
        this.filter.destroy();
        gPUImageRenderer.deleteImage();
        pixelBuffer.destroy();
        this.renderer.setFilter(this.filter);
        Bitmap bitmap3 = this.currentBitmap;
        if (bitmap3 != null) {
            this.renderer.setImageBitmap(bitmap3, false);
        }
        requestRender();
        return bitmap2;
    }

    public static void getBitmapForMultipleFilters(Bitmap bitmap, List<GlPhotoFilter> list, ResponseListener<Bitmap> responseListener) {
        if (!list.isEmpty()) {
            GPUImageRenderer gPUImageRenderer = new GPUImageRenderer(list.get(0));
            gPUImageRenderer.setImageBitmap(bitmap, false);
            PixelBuffer pixelBuffer = new PixelBuffer(bitmap.getWidth(), bitmap.getHeight());
            pixelBuffer.setRenderer(gPUImageRenderer);
            for (GlPhotoFilter next : list) {
                gPUImageRenderer.setFilter(next);
                responseListener.response(pixelBuffer.getBitmap());
                next.destroy();
            }
            gPUImageRenderer.deleteImage();
            pixelBuffer.destroy();
        }
    }

    public void saveToPictures(String str, String str2, OnPictureSavedListener onPictureSavedListener) {
        saveToPictures(this.currentBitmap, str, str2, onPictureSavedListener);
    }

    public void saveToPictures(Bitmap bitmap, String str, String str2, OnPictureSavedListener onPictureSavedListener) {
        new SaveTask(bitmap, str, str2, onPictureSavedListener).execute(new Void[0]);
    }

    /* access modifiers changed from: package-private */
    public void runOnGLThread(Runnable runnable) {
        this.renderer.runOnDrawEnd(runnable);
    }

    /* access modifiers changed from: private */
    public int getOutputWidth() {
        GPUImageRenderer gPUImageRenderer = this.renderer;
        if (gPUImageRenderer != null && gPUImageRenderer.getFrameWidth() != 0) {
            return this.renderer.getFrameWidth();
        }
        Bitmap bitmap = this.currentBitmap;
        if (bitmap != null) {
            return bitmap.getWidth();
        }
        return ((WindowManager) this.context.getSystemService("window")).getDefaultDisplay().getWidth();
    }

    /* access modifiers changed from: private */
    public int getOutputHeight() {
        GPUImageRenderer gPUImageRenderer = this.renderer;
        if (gPUImageRenderer != null && gPUImageRenderer.getFrameHeight() != 0) {
            return this.renderer.getFrameHeight();
        }
        Bitmap bitmap = this.currentBitmap;
        if (bitmap != null) {
            return bitmap.getHeight();
        }
        return ((WindowManager) this.context.getSystemService("window")).getDefaultDisplay().getHeight();
    }

    @Deprecated
    private class SaveTask extends AsyncTask<Void, Void, Void> {
        private final Bitmap bitmap;
        private final String fileName;
        private final String folderName;
        /* access modifiers changed from: private */
        public final Handler handler = new Handler();
        /* access modifiers changed from: private */
        public final OnPictureSavedListener listener;

        public SaveTask(Bitmap bitmap2, String str, String str2, OnPictureSavedListener onPictureSavedListener) {
            this.bitmap = bitmap2;
            this.folderName = str;
            this.fileName = str2;
            this.listener = onPictureSavedListener;
        }

        /* access modifiers changed from: protected */
        public Void doInBackground(Void... voidArr) {
            saveImage(this.folderName, this.fileName, GPUImage.this.getBitmapWithFilterApplied(this.bitmap));
            return null;
        }

        private void saveImage(String str, String str2, Bitmap bitmap2) {
            File externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
            File file = new File(externalStoragePublicDirectory, str + "/" + str2);
            try {
                file.getParentFile().mkdirs();
                bitmap2.compress(Bitmap.CompressFormat.JPEG, 80, new FileOutputStream(file));
                MediaScannerConnection.scanFile(GPUImage.this.context, new String[]{file.toString()}, (String[]) null, new MediaScannerConnection.OnScanCompletedListener() {
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

    private class LoadImageUriTask extends LoadImageTask {
        private final Uri uri;

        public LoadImageUriTask(GPUImage gPUImage, Uri uri2) {
            super(gPUImage);
            this.uri = uri2;
        }

        /* access modifiers changed from: protected */
        public Bitmap decode(BitmapFactory.Options options) {
            InputStream inputStream;
            try {
                if (!this.uri.getScheme().startsWith("http")) {
                    if (!this.uri.getScheme().startsWith("https")) {
                        if (this.uri.getPath().startsWith("/android_asset/")) {
                            inputStream = GPUImage.this.context.getAssets().open(this.uri.getPath().substring(15));
                        } else {
                            inputStream = GPUImage.this.context.getContentResolver().openInputStream(this.uri);
                        }
                        return BitmapFactory.decodeStream(inputStream, (Rect) null, options);
                    }
                }
                inputStream = new URL(this.uri.toString()).openStream();
                return BitmapFactory.decodeStream(inputStream, (Rect) null, options);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        /* access modifiers changed from: protected */
        public int getImageOrientation() throws IOException {
            Cursor query = GPUImage.this.context.getContentResolver().query(this.uri, new String[]{"orientation"}, (String) null, (String[]) null, (String) null);
            if (query == null || query.getCount() != 1) {
                return 0;
            }
            query.moveToFirst();
            int i = query.getInt(0);
            query.close();
            return i;
        }
    }

    private class LoadImageFileTask extends LoadImageTask {
        private final File imageFile;

        public LoadImageFileTask(GPUImage gPUImage, File file) {
            super(gPUImage);
            this.imageFile = file;
        }

        /* access modifiers changed from: protected */
        public Bitmap decode(BitmapFactory.Options options) {
            return BitmapFactory.decodeFile(this.imageFile.getAbsolutePath(), options);
        }

        /* access modifiers changed from: protected */
        public int getImageOrientation() throws IOException {
            int attributeInt = new ExifInterface(this.imageFile.getAbsolutePath()).getAttributeInt(androidx.exifinterface.media.ExifInterface.TAG_ORIENTATION, 1);
            if (attributeInt == 3) {
                return RotationOptions.ROTATE_180;
            }
            if (attributeInt == 6) {
                return 90;
            }
            if (attributeInt != 8) {
                return 0;
            }
            return RotationOptions.ROTATE_270;
        }
    }

    private abstract class LoadImageTask extends AsyncTask<Void, Void, Bitmap> {
        private final GPUImage gpuImage;
        private int outputHeight;
        private int outputWidth;

        /* access modifiers changed from: protected */
        public abstract Bitmap decode(BitmapFactory.Options options);

        /* access modifiers changed from: protected */
        public abstract int getImageOrientation() throws IOException;

        public LoadImageTask(GPUImage gPUImage) {
            this.gpuImage = gPUImage;
        }

        /* access modifiers changed from: protected */
        public Bitmap doInBackground(Void... voidArr) {
            if (GPUImage.this.renderer != null && GPUImage.this.renderer.getFrameWidth() == 0) {
                try {
                    synchronized (GPUImage.this.renderer.surfaceChangedWaiter) {
                        GPUImage.this.renderer.surfaceChangedWaiter.wait(3000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            this.outputWidth = GPUImage.this.getOutputWidth();
            this.outputHeight = GPUImage.this.getOutputHeight();
            return loadResizedImage();
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(Bitmap bitmap) {
            super.onPostExecute(bitmap);
            this.gpuImage.deleteImage();
            this.gpuImage.setImage(bitmap);
        }

        private Bitmap loadResizedImage() {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            decode(options);
            int i = 1;
            while (true) {
                boolean z = false;
                boolean z2 = options.outWidth / i > this.outputWidth;
                if (options.outHeight / i > this.outputHeight) {
                    z = true;
                }
                if (!checkSize(z2, z)) {
                    break;
                }
                i++;
            }
            int i2 = i - 1;
            if (i2 < 1) {
                i2 = 1;
            }
            BitmapFactory.Options options2 = new BitmapFactory.Options();
            options2.inSampleSize = i2;
            options2.inPreferredConfig = Bitmap.Config.RGB_565;
            options2.inPurgeable = true;
            options2.inTempStorage = new byte[32768];
            Bitmap decode = decode(options2);
            if (decode == null) {
                return null;
            }
            return scaleBitmap(rotateImage(decode));
        }

        private Bitmap scaleBitmap(Bitmap bitmap) {
            int[] scaleSize = getScaleSize(bitmap.getWidth(), bitmap.getHeight());
            Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, scaleSize[0], scaleSize[1], true);
            if (createScaledBitmap != bitmap) {
                bitmap.recycle();
                System.gc();
                bitmap = createScaledBitmap;
            }
            if (GPUImage.this.scaleType != ScaleType.CENTER_CROP) {
                return bitmap;
            }
            int i = scaleSize[0] - this.outputWidth;
            int i2 = scaleSize[1] - this.outputHeight;
            Bitmap createBitmap = Bitmap.createBitmap(bitmap, i / 2, i2 / 2, scaleSize[0] - i, scaleSize[1] - i2);
            if (createBitmap == bitmap) {
                return bitmap;
            }
            bitmap.recycle();
            return createBitmap;
        }

        private int[] getScaleSize(int i, int i2) {
            float f;
            float f2;
            float f3 = (float) i;
            float f4 = f3 / ((float) this.outputWidth);
            float f5 = (float) i2;
            float f6 = f5 / ((float) this.outputHeight);
            if (GPUImage.this.scaleType != ScaleType.CENTER_CROP ? f4 < f6 : f4 > f6) {
                f2 = (float) this.outputHeight;
                f = (f2 / f5) * f3;
            } else {
                float f7 = (float) this.outputWidth;
                float f8 = (f7 / f3) * f5;
                f = f7;
                f2 = f8;
            }
            int unused = GPUImage.this.scaleWidth = Math.round(f);
            int unused2 = GPUImage.this.scaleHeight = Math.round(f2);
            return new int[]{Math.round(f), Math.round(f2)};
        }

        private boolean checkSize(boolean z, boolean z2) {
            return GPUImage.this.scaleType == ScaleType.CENTER_CROP ? z && z2 : z || z2;
        }

        private Bitmap rotateImage(Bitmap bitmap) {
            Bitmap bitmap2;
            IOException e;
            if (bitmap == null) {
                return null;
            }
            try {
                int imageOrientation = getImageOrientation();
                if (imageOrientation == 0) {
                    return bitmap;
                }
                Matrix matrix = new Matrix();
                matrix.postRotate((float) imageOrientation);
                bitmap2 = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
                try {
                    bitmap.recycle();
                } catch (IOException e2) {
                    e = e2;
                }
                return bitmap2;
            } catch (IOException e3) {
                IOException iOException = e3;
                bitmap2 = bitmap;
                e = iOException;
                e.printStackTrace();
                return bitmap2;
            }
        }
    }

    public GPUImageRenderer getRenderer() {
        return this.renderer;
    }
}
