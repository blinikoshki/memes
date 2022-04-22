package com.facebook.soloader;

import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileLock;
import javax.annotation.Nullable;

public final class FileLocker implements Closeable {
    @Nullable
    private final FileLock mLock;
    private final FileOutputStream mLockFileOutputStream;

    public static FileLocker lock(File file) throws IOException {
        return new FileLocker(file);
    }

    private FileLocker(File file) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        this.mLockFileOutputStream = fileOutputStream;
        try {
            FileLock lock = fileOutputStream.getChannel().lock();
            if (lock == null) {
                fileOutputStream.close();
            }
            this.mLock = lock;
        } catch (Throwable th) {
            this.mLockFileOutputStream.close();
            throw th;
        }
    }

    public void close() throws IOException {
        try {
            FileLock fileLock = this.mLock;
            if (fileLock != null) {
                fileLock.release();
            }
        } finally {
            this.mLockFileOutputStream.close();
        }
    }
}
