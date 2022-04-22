package com.memes.commons.util;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u001c\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u001c\u0010\b\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\u00022\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016¨\u0006\f"}, mo26107d2 = {"com/memes/commons/util/DirectoryUtil$delete$1", "Ljava/nio/file/SimpleFileVisitor;", "Ljava/nio/file/Path;", "postVisitDirectory", "Ljava/nio/file/FileVisitResult;", "dir", "exc", "Ljava/io/IOException;", "visitFile", "file", "attrs", "Ljava/nio/file/attribute/BasicFileAttributes;", "commons_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: DirectoryUtil.kt */
public final class DirectoryUtil$delete$1 extends SimpleFileVisitor<Path> {
    DirectoryUtil$delete$1() {
    }

    public FileVisitResult visitFile(Path path, BasicFileAttributes basicFileAttributes) {
        if (path != null) {
            System.out.println("Deleting file: " + path);
            Files.delete(path);
        }
        return FileVisitResult.CONTINUE;
    }

    public FileVisitResult postVisitDirectory(Path path, IOException iOException) {
        System.out.println("Deleting dir: " + path);
        if (iOException != null) {
            throw iOException;
        } else if (path != null) {
            Files.delete(path);
            return FileVisitResult.CONTINUE;
        } else {
            FileVisitResult postVisitDirectory = super.postVisitDirectory(path, iOException);
            Intrinsics.checkNotNullExpressionValue(postVisitDirectory, "super.postVisitDirectory(dir, exc)");
            return postVisitDirectory;
        }
    }
}
