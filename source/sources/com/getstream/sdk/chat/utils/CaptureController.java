package com.getstream.sdk.chat.utils;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import com.getstream.sdk.chat.C1673R;
import com.memes.commons.output.OutputExtension;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CaptureController {
    private static Uri imageUri;
    private static Uri videoUri;

    public static Intent getTakePictureIntent(Context context) {
        String folderPath = getFolderPath(true, context);
        imageUri = Uri.fromFile(new File(folderPath, "IMG_" + getFileName() + OutputExtension.JPG));
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        ContentValues contentValues = new ContentValues();
        contentValues.put("title", "New Picture");
        contentValues.put("description", "From your Camera");
        intent.putExtra("output", imageUri);
        return intent;
    }

    public static Intent getTakeVideoIntent(Context context) {
        String folderPath = getFolderPath(false, context);
        videoUri = Uri.fromFile(new File(folderPath, "VID_" + getFileName() + OutputExtension.MP4));
        Intent intent = new Intent("android.media.action.VIDEO_CAPTURE");
        ContentValues contentValues = new ContentValues();
        contentValues.put("title", "New Video");
        contentValues.put("description", "From your Camera");
        intent.putExtra("output", videoUri);
        return intent;
    }

    private static String getFileName() {
        return new SimpleDateFormat("yyyyMMdd_HHmmss").format(Long.valueOf(new Date().getTime()));
    }

    private static String getFolderPath(boolean z, Context context) {
        String applicationName = Utils.getApplicationName(context);
        File file = new File(Environment.getExternalStorageDirectory() + "/" + applicationName, context.getString(z ? C1673R.string.stream_image : C1673R.string.stream_video));
        if (!file.exists()) {
            file.mkdirs();
        }
        return file.getAbsolutePath();
    }

    public static File getCaptureFile(boolean z) {
        return getFileFromUri(z ? imageUri : videoUri);
    }

    public static File getFileFromUri(Uri uri) {
        String path = uri.getPath();
        if (path == null) {
            return null;
        }
        return new File(path);
    }
}
