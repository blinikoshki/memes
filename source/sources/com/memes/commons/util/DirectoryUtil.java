package com.memes.commons.util;

import android.os.Build;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0003J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u000b"}, mo26107d2 = {"Lcom/memes/commons/util/DirectoryUtil;", "", "()V", "delete", "", "targetDirectory", "", "deleteLegacy", "safeDelete", "directory", "Ljava/io/File;", "commons_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
@Deprecated(message = "unused")
/* compiled from: DirectoryUtil.kt */
public final class DirectoryUtil {
    public static final DirectoryUtil INSTANCE = new DirectoryUtil();

    private DirectoryUtil() {
    }

    public final void safeDelete(File file) {
        Intrinsics.checkNotNullParameter(file, "directory");
        String absolutePath = file.getAbsolutePath();
        Intrinsics.checkNotNullExpressionValue(absolutePath, "directory.absolutePath");
        safeDelete(absolutePath);
    }

    public final void safeDelete(String str) {
        Intrinsics.checkNotNullParameter(str, "targetDirectory");
        if (Build.VERSION.SDK_INT >= 26) {
            delete(str);
        } else {
            deleteLegacy(str);
        }
    }

    private final void delete(String str) {
        Path path = Paths.get(str, new String[0]);
        Intrinsics.checkNotNullExpressionValue(path, "Paths.get(targetDirectory)");
        try {
            Files.walkFileTree(path, new DirectoryUtil$delete$1());
        } catch (NoSuchFileException e) {
            Timber.m300d("File/Directory doesn't exist. exception=" + e, new Object[0]);
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    private final void deleteLegacy(String str) {
        File file = new File(str);
        if (!file.exists()) {
            System.out.println("File/Directory " + file + " does not exist.");
        } else if (!file.isDirectory()) {
            file.delete();
            System.out.println("File is deleted: " + file.getAbsolutePath());
        } else {
            String[] list = file.list();
            if (list != null) {
                boolean z = false;
                if (list.length == 0) {
                    file.delete();
                    System.out.println("Directory is deleted: " + file.getAbsolutePath());
                    return;
                }
                for (String file2 : list) {
                    String absolutePath = new File(file, file2).getAbsolutePath();
                    Intrinsics.checkNotNullExpressionValue(absolutePath, "File(file, temp).absolutePath");
                    deleteLegacy(absolutePath);
                }
                String[] list2 = file.list();
                if (list2 != null) {
                    if (list2.length == 0) {
                        z = true;
                    }
                    if (z) {
                        file.delete();
                        System.out.println("Directory is deleted: " + file.getAbsolutePath());
                    }
                }
            }
        }
    }
}
