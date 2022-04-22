package p015io.noties.markwon.image;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Collections;

/* renamed from: io.noties.markwon.image.DefaultDownScalingMediaDecoder */
public class DefaultDownScalingMediaDecoder extends MediaDecoder {
    private final int maxHeight;
    private final int maxWidth;
    private final Resources resources;

    public static DefaultDownScalingMediaDecoder create(int i, int i2) {
        return create(Resources.getSystem(), i, i2);
    }

    public static DefaultDownScalingMediaDecoder create(Resources resources2, int i, int i2) {
        return new DefaultDownScalingMediaDecoder(resources2, i, i2);
    }

    private DefaultDownScalingMediaDecoder(Resources resources2, int i, int i2) {
        this.resources = resources2;
        this.maxWidth = i;
        this.maxHeight = i2;
    }

    public Drawable decode(String str, InputStream inputStream) {
        File writeToTempFile = writeToTempFile(inputStream);
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            decode(writeToTempFile, options);
            options.inSampleSize = calculateInSampleSize(options, this.maxWidth, this.maxHeight);
            options.inJustDecodeBounds = false;
            return new BitmapDrawable(this.resources, decode(writeToTempFile, options));
        } finally {
            writeToTempFile.delete();
        }
    }

    private static File writeToTempFile(InputStream inputStream) {
        try {
            File createTempFile = File.createTempFile("markwon", (String) null);
            try {
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(createTempFile, false));
                byte[] bArr = new byte[8192];
                while (true) {
                    try {
                        int read = inputStream.read(bArr);
                        if (read > 0) {
                            bufferedOutputStream.write(bArr, 0, read);
                        } else {
                            try {
                                break;
                            } catch (IOException unused) {
                            }
                        }
                    } catch (IOException e) {
                        throw new IllegalStateException(e);
                    } catch (Throwable th) {
                        try {
                            bufferedOutputStream.close();
                        } catch (IOException unused2) {
                        }
                        throw th;
                    }
                }
                bufferedOutputStream.close();
                return createTempFile;
            } catch (FileNotFoundException e2) {
                throw new IllegalStateException(e2);
            }
        } catch (IOException e3) {
            throw new IllegalStateException(e3);
        }
    }

    private static Bitmap decode(File file, BitmapFactory.Options options) {
        InputStream readFile = readFile(file);
        try {
            return BitmapFactory.decodeStream(readFile, (Rect) null, options);
        } finally {
            try {
                readFile.close();
            } catch (IOException unused) {
            }
        }
    }

    private static InputStream readFile(File file) {
        try {
            return new BufferedInputStream(new FileInputStream(file));
        } catch (FileNotFoundException e) {
            throw new IllegalStateException(e);
        }
    }

    private static int calculateInSampleSize(BitmapFactory.Options options, int i, int i2) {
        int i3 = options.outWidth;
        int i4 = options.outHeight;
        boolean z = false;
        boolean z2 = i > 0;
        if (i2 > 0) {
            z = true;
        }
        if (z2 && z) {
            return Math.min(calculateInSampleSize(i3, i), calculateInSampleSize(i4, i2));
        }
        if (z2) {
            return calculateInSampleSize(i3, i);
        }
        if (z) {
            return calculateInSampleSize(i4, i2);
        }
        return 1;
    }

    private static int calculateInSampleSize(int i, int i2) {
        int i3 = 1;
        while ((i / 2) / i3 > i2) {
            i3 *= 2;
        }
        return i3;
    }

    public Collection<String> supportedTypes() {
        return Collections.emptySet();
    }
}
