package p015io.noties.markwon.image.file;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import p015io.noties.markwon.image.ImageItem;
import p015io.noties.markwon.image.SchemeHandler;

/* renamed from: io.noties.markwon.image.file.FileSchemeHandler */
public class FileSchemeHandler extends SchemeHandler {
    private static final String FILE_ANDROID_ASSETS = "android_asset";
    public static final String SCHEME = "file";
    private final AssetManager assetManager;

    public static FileSchemeHandler createWithAssets(AssetManager assetManager2) {
        return new FileSchemeHandler(assetManager2);
    }

    public static FileSchemeHandler createWithAssets(Context context) {
        return new FileSchemeHandler(context.getAssets());
    }

    public static FileSchemeHandler create() {
        return new FileSchemeHandler((AssetManager) null);
    }

    FileSchemeHandler(AssetManager assetManager2) {
        this.assetManager = assetManager2;
    }

    public ImageItem handle(String str, Uri uri) {
        InputStream inputStream;
        List<String> pathSegments = uri.getPathSegments();
        if (pathSegments == null || pathSegments.size() == 0) {
            throw new IllegalStateException("Invalid file path: " + str);
        }
        boolean equals = "android_asset".equals(pathSegments.get(0));
        String lastPathSegment = uri.getLastPathSegment();
        if (!equals) {
            String path = uri.getPath();
            if (!TextUtils.isEmpty(path)) {
                try {
                    inputStream = new BufferedInputStream(new FileInputStream(new File(path)));
                } catch (FileNotFoundException e) {
                    throw new IllegalStateException("Exception reading file: " + str, e);
                }
            } else {
                throw new IllegalStateException("Invalid file path: " + str + ", " + path);
            }
        } else if (this.assetManager != null) {
            StringBuilder sb = new StringBuilder();
            int size = pathSegments.size();
            for (int i = 1; i < size; i++) {
                if (i != 1) {
                    sb.append('/');
                }
                sb.append(pathSegments.get(i));
            }
            try {
                inputStream = this.assetManager.open(sb.toString());
            } catch (IOException e2) {
                throw new IllegalStateException("Exception obtaining asset file: " + str + ", path: " + sb.toString(), e2);
            }
        } else {
            throw new IllegalStateException("Supplied file path points to assets, but FileSchemeHandler was not supplied with AssetsManager. Use `#createWithAssets` factory method to create FileSchemeHandler that can handle android assets");
        }
        return ImageItem.withDecodingNeeded(MimeTypeMap.getSingleton().getMimeTypeFromExtension(MimeTypeMap.getFileExtensionFromUrl(lastPathSegment)), inputStream);
    }

    public Collection<String> supportedSchemes() {
        return Collections.singleton("file");
    }
}
