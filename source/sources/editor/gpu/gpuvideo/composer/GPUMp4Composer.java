package editor.gpu.gpuvideo.composer;

import android.util.Log;
import android.util.Size;
import editor.gpu.gpuvideo.composer.GPUMp4ComposerEngine;
import editor.gpu.gpuvideo.egl.filter.GlVideoFilter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GPUMp4Composer {
    /* access modifiers changed from: private */
    public static final String TAG = "GPUMp4Composer";
    /* access modifiers changed from: private */
    public int bitrate = -1;
    /* access modifiers changed from: private */
    public final String destPath;
    /* access modifiers changed from: private */
    public ExecutorService executorService;
    /* access modifiers changed from: private */
    public FillMode fillMode = FillMode.PRESERVE_ASPECT_FIT;
    /* access modifiers changed from: private */
    public FillModeCustomItem fillModeCustomItem;
    /* access modifiers changed from: private */
    public GlVideoFilter filter;
    /* access modifiers changed from: private */
    public boolean flipHorizontal = false;
    /* access modifiers changed from: private */
    public boolean flipVertical = false;
    /* access modifiers changed from: private */
    public Listener listener;
    /* access modifiers changed from: private */
    public boolean mute = false;
    /* access modifiers changed from: private */
    public Size outputResolution;
    /* access modifiers changed from: private */
    public Rotation rotation = Rotation.NORMAL;
    /* access modifiers changed from: private */
    public final String srcPath;
    /* access modifiers changed from: private */
    public int timeScale = 1;

    public interface Listener {
        void onCanceled();

        void onCompleted();

        void onFailed(Exception exc);

        void onProgress(double d);
    }

    public GPUMp4Composer(String str, String str2) {
        this.srcPath = str;
        this.destPath = str2;
    }

    public GPUMp4Composer filter(GlVideoFilter glVideoFilter) {
        this.filter = glVideoFilter;
        return this;
    }

    public GPUMp4Composer size(int i, int i2) {
        this.outputResolution = new Size(i, i2);
        return this;
    }

    public GPUMp4Composer videoBitrate(int i) {
        this.bitrate = i;
        return this;
    }

    public GPUMp4Composer mute(boolean z) {
        this.mute = z;
        return this;
    }

    public GPUMp4Composer flipVertical(boolean z) {
        this.flipVertical = z;
        return this;
    }

    public GPUMp4Composer flipHorizontal(boolean z) {
        this.flipHorizontal = z;
        return this;
    }

    public GPUMp4Composer rotation(Rotation rotation2) {
        this.rotation = rotation2;
        return this;
    }

    public GPUMp4Composer fillMode(FillMode fillMode2) {
        this.fillMode = fillMode2;
        return this;
    }

    public GPUMp4Composer customFillMode(FillModeCustomItem fillModeCustomItem2) {
        this.fillModeCustomItem = fillModeCustomItem2;
        this.fillMode = FillMode.CUSTOM;
        return this;
    }

    public GPUMp4Composer listener(Listener listener2) {
        this.listener = listener2;
        return this;
    }

    public GPUMp4Composer timeScale(int i) {
        this.timeScale = i;
        return this;
    }

    private ExecutorService getExecutorService() {
        if (this.executorService == null) {
            this.executorService = Executors.newSingleThreadExecutor();
        }
        return this.executorService;
    }

    public GPUMp4Composer start() {
        getExecutorService().execute(new Runnable() {
            public void run() {
                GPUMp4ComposerEngine gPUMp4ComposerEngine = new GPUMp4ComposerEngine();
                gPUMp4ComposerEngine.setProgressCallback(new GPUMp4ComposerEngine.ProgressCallback() {
                    public void onProgress(double d) {
                        if (GPUMp4Composer.this.listener != null) {
                            GPUMp4Composer.this.listener.onProgress(d);
                        }
                    }
                });
                try {
                    try {
                        gPUMp4ComposerEngine.setDataSource(new FileInputStream(new File(GPUMp4Composer.this.srcPath)).getFD());
                        GPUMp4Composer gPUMp4Composer = GPUMp4Composer.this;
                        int access$200 = gPUMp4Composer.getVideoRotation(gPUMp4Composer.srcPath);
                        GPUMp4Composer gPUMp4Composer2 = GPUMp4Composer.this;
                        Size access$300 = gPUMp4Composer2.getVideoResolution(gPUMp4Composer2.srcPath, access$200);
                        if (GPUMp4Composer.this.filter == null) {
                            GlVideoFilter unused = GPUMp4Composer.this.filter = new GlVideoFilter();
                        }
                        if (GPUMp4Composer.this.fillMode == null) {
                            FillMode unused2 = GPUMp4Composer.this.fillMode = FillMode.PRESERVE_ASPECT_FIT;
                        }
                        if (GPUMp4Composer.this.fillModeCustomItem != null) {
                            FillMode unused3 = GPUMp4Composer.this.fillMode = FillMode.CUSTOM;
                        }
                        if (GPUMp4Composer.this.outputResolution == null) {
                            if (GPUMp4Composer.this.fillMode == FillMode.CUSTOM) {
                                Size unused4 = GPUMp4Composer.this.outputResolution = access$300;
                            } else {
                                Rotation fromInt = Rotation.fromInt(GPUMp4Composer.this.rotation.getRotation() + access$200);
                                if (fromInt == Rotation.ROTATION_90 || fromInt == Rotation.ROTATION_270) {
                                    Size unused5 = GPUMp4Composer.this.outputResolution = new Size(access$300.getHeight(), access$300.getWidth());
                                } else {
                                    Size unused6 = GPUMp4Composer.this.outputResolution = access$300;
                                }
                            }
                        }
                        if (GPUMp4Composer.this.timeScale < 2) {
                            int unused7 = GPUMp4Composer.this.timeScale = 1;
                        }
                        String access$1000 = GPUMp4Composer.TAG;
                        Log.d(access$1000, "rotation = " + (GPUMp4Composer.this.rotation.getRotation() + access$200));
                        String access$10002 = GPUMp4Composer.TAG;
                        Log.d(access$10002, "inputResolution width = " + access$300.getWidth() + " height = " + access$300.getHeight());
                        String access$10003 = GPUMp4Composer.TAG;
                        Log.d(access$10003, "outputResolution width = " + GPUMp4Composer.this.outputResolution.getWidth() + " height = " + GPUMp4Composer.this.outputResolution.getHeight());
                        String access$10004 = GPUMp4Composer.TAG;
                        StringBuilder sb = new StringBuilder();
                        sb.append("fillMode = ");
                        sb.append(GPUMp4Composer.this.fillMode);
                        Log.d(access$10004, sb.toString());
                        try {
                            if (GPUMp4Composer.this.bitrate < 0) {
                                GPUMp4Composer gPUMp4Composer3 = GPUMp4Composer.this;
                                int unused8 = gPUMp4Composer3.bitrate = gPUMp4Composer3.calcBitRate(gPUMp4Composer3.outputResolution.getWidth(), GPUMp4Composer.this.outputResolution.getHeight());
                            }
                            gPUMp4ComposerEngine.compose(GPUMp4Composer.this.destPath, GPUMp4Composer.this.outputResolution, GPUMp4Composer.this.filter, GPUMp4Composer.this.bitrate, GPUMp4Composer.this.mute, Rotation.fromInt(GPUMp4Composer.this.rotation.getRotation() + access$200), access$300, GPUMp4Composer.this.fillMode, GPUMp4Composer.this.fillModeCustomItem, GPUMp4Composer.this.timeScale, GPUMp4Composer.this.flipVertical, GPUMp4Composer.this.flipHorizontal);
                            if (GPUMp4Composer.this.listener != null) {
                                GPUMp4Composer.this.listener.onCompleted();
                            }
                            GPUMp4Composer.this.executorService.shutdown();
                        } catch (Exception e) {
                            e.printStackTrace();
                            if (GPUMp4Composer.this.listener != null) {
                                GPUMp4Composer.this.listener.onFailed(e);
                            }
                            GPUMp4Composer.this.executorService.shutdown();
                        }
                    } catch (IOException e2) {
                        e2.printStackTrace();
                        if (GPUMp4Composer.this.listener != null) {
                            GPUMp4Composer.this.listener.onFailed(e2);
                        }
                    }
                } catch (FileNotFoundException e3) {
                    e3.printStackTrace();
                    if (GPUMp4Composer.this.listener != null) {
                        GPUMp4Composer.this.listener.onFailed(e3);
                    }
                }
            }
        });
        return this;
    }

    public void cancel() {
        getExecutorService().shutdownNow();
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0039 A[SYNTHETIC, Splitter:B:24:0x0039] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x004b A[SYNTHETIC, Splitter:B:34:0x004b] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x005d A[SYNTHETIC, Splitter:B:44:0x005d] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x006a A[SYNTHETIC, Splitter:B:50:0x006a] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int getVideoRotation(java.lang.String r6) {
        /*
            r5 = this;
            java.lang.String r0 = "MediaMetadataRetriever"
            java.lang.String r1 = "Failed to release mediaMetadataRetriever."
            r2 = 0
            r3 = 0
            android.media.MediaMetadataRetriever r4 = new android.media.MediaMetadataRetriever     // Catch:{ IllegalArgumentException -> 0x0056, RuntimeException -> 0x0044, Exception -> 0x0032 }
            r4.<init>()     // Catch:{ IllegalArgumentException -> 0x0056, RuntimeException -> 0x0044, Exception -> 0x0032 }
            r4.setDataSource(r6)     // Catch:{ IllegalArgumentException -> 0x002e, RuntimeException -> 0x002c, Exception -> 0x002a, all -> 0x0027 }
            r6 = 24
            java.lang.String r6 = r4.extractMetadata(r6)     // Catch:{ IllegalArgumentException -> 0x002e, RuntimeException -> 0x002c, Exception -> 0x002a, all -> 0x0027 }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ IllegalArgumentException -> 0x002e, RuntimeException -> 0x002c, Exception -> 0x002a, all -> 0x0027 }
            int r6 = r6.intValue()     // Catch:{ IllegalArgumentException -> 0x002e, RuntimeException -> 0x002c, Exception -> 0x002a, all -> 0x0027 }
            r4.release()     // Catch:{ RuntimeException -> 0x0020 }
            goto L_0x0026
        L_0x0020:
            r0 = move-exception
            java.lang.String r2 = TAG
            android.util.Log.e(r2, r1, r0)
        L_0x0026:
            return r6
        L_0x0027:
            r6 = move-exception
            r3 = r4
            goto L_0x0068
        L_0x002a:
            r3 = r4
            goto L_0x0032
        L_0x002c:
            r3 = r4
            goto L_0x0044
        L_0x002e:
            r3 = r4
            goto L_0x0056
        L_0x0030:
            r6 = move-exception
            goto L_0x0068
        L_0x0032:
            java.lang.String r6 = "getVideoRotation Exception"
            android.util.Log.e(r0, r6)     // Catch:{ all -> 0x0030 }
            if (r3 == 0) goto L_0x0043
            r3.release()     // Catch:{ RuntimeException -> 0x003d }
            goto L_0x0043
        L_0x003d:
            r6 = move-exception
            java.lang.String r0 = TAG
            android.util.Log.e(r0, r1, r6)
        L_0x0043:
            return r2
        L_0x0044:
            java.lang.String r6 = "getVideoRotation RuntimeException"
            android.util.Log.e(r0, r6)     // Catch:{ all -> 0x0030 }
            if (r3 == 0) goto L_0x0055
            r3.release()     // Catch:{ RuntimeException -> 0x004f }
            goto L_0x0055
        L_0x004f:
            r6 = move-exception
            java.lang.String r0 = TAG
            android.util.Log.e(r0, r1, r6)
        L_0x0055:
            return r2
        L_0x0056:
            java.lang.String r6 = "getVideoRotation IllegalArgumentException"
            android.util.Log.e(r0, r6)     // Catch:{ all -> 0x0030 }
            if (r3 == 0) goto L_0x0067
            r3.release()     // Catch:{ RuntimeException -> 0x0061 }
            goto L_0x0067
        L_0x0061:
            r6 = move-exception
            java.lang.String r0 = TAG
            android.util.Log.e(r0, r1, r6)
        L_0x0067:
            return r2
        L_0x0068:
            if (r3 == 0) goto L_0x0074
            r3.release()     // Catch:{ RuntimeException -> 0x006e }
            goto L_0x0074
        L_0x006e:
            r0 = move-exception
            java.lang.String r2 = TAG
            android.util.Log.e(r2, r1, r0)
        L_0x0074:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: editor.gpu.gpuvideo.composer.GPUMp4Composer.getVideoRotation(java.lang.String):int");
    }

    /* access modifiers changed from: private */
    public int calcBitRate(int i, int i2) {
        int i3 = (int) (((double) i) * 7.5d * ((double) i2));
        String str = TAG;
        Log.i(str, "bitrate=" + i3);
        return i3;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x003d A[SYNTHETIC, Splitter:B:14:0x003d] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.util.Size getVideoResolution(java.lang.String r4, int r5) {
        /*
            r3 = this;
            java.lang.String r5 = "Failed to release mediaMetadataRetriever."
            r0 = 0
            android.media.MediaMetadataRetriever r1 = new android.media.MediaMetadataRetriever     // Catch:{ all -> 0x003a }
            r1.<init>()     // Catch:{ all -> 0x003a }
            r1.setDataSource(r4)     // Catch:{ all -> 0x0037 }
            r4 = 18
            java.lang.String r4 = r1.extractMetadata(r4)     // Catch:{ all -> 0x0037 }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ all -> 0x0037 }
            int r4 = r4.intValue()     // Catch:{ all -> 0x0037 }
            r0 = 19
            java.lang.String r0 = r1.extractMetadata(r0)     // Catch:{ all -> 0x0037 }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ all -> 0x0037 }
            int r0 = r0.intValue()     // Catch:{ all -> 0x0037 }
            android.util.Size r2 = new android.util.Size     // Catch:{ all -> 0x0037 }
            r2.<init>(r4, r0)     // Catch:{ all -> 0x0037 }
            r1.release()     // Catch:{ RuntimeException -> 0x0030 }
            goto L_0x0036
        L_0x0030:
            r4 = move-exception
            java.lang.String r0 = TAG
            android.util.Log.e(r0, r5, r4)
        L_0x0036:
            return r2
        L_0x0037:
            r4 = move-exception
            r0 = r1
            goto L_0x003b
        L_0x003a:
            r4 = move-exception
        L_0x003b:
            if (r0 == 0) goto L_0x0047
            r0.release()     // Catch:{ RuntimeException -> 0x0041 }
            goto L_0x0047
        L_0x0041:
            r0 = move-exception
            java.lang.String r1 = TAG
            android.util.Log.e(r1, r5, r0)
        L_0x0047:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: editor.gpu.gpuvideo.composer.GPUMp4Composer.getVideoResolution(java.lang.String, int):android.util.Size");
    }
}
