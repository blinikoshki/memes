package com.downloader.internal.stream;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

public class FileDownloadRandomAccessFile implements FileDownloadOutputStream {

    /* renamed from: fd */
    private final FileDescriptor f126fd;
    private final BufferedOutputStream out;
    private final RandomAccessFile randomAccess;

    private FileDownloadRandomAccessFile(File file) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
        this.randomAccess = randomAccessFile;
        this.f126fd = randomAccessFile.getFD();
        this.out = new BufferedOutputStream(new FileOutputStream(randomAccessFile.getFD()));
    }

    public void write(byte[] bArr, int i, int i2) throws IOException {
        this.out.write(bArr, i, i2);
    }

    public void flushAndSync() throws IOException {
        this.out.flush();
        this.f126fd.sync();
    }

    public void close() throws IOException {
        this.out.close();
        this.randomAccess.close();
    }

    public void seek(long j) throws IOException {
        this.randomAccess.seek(j);
    }

    public void setLength(long j) throws IOException {
        this.randomAccess.setLength(j);
    }

    public static FileDownloadOutputStream create(File file) throws IOException {
        return new FileDownloadRandomAccessFile(file);
    }
}
