package com.downloader.database;

public class DownloadModel {
    static final String DIR_PATH = "dir_path";
    static final String DOWNLOADED_BYTES = "downloaded_bytes";
    static final String ETAG = "etag";
    static final String FILE_NAME = "file_name";

    /* renamed from: ID */
    static final String f124ID = "id";
    static final String LAST_MODIFIED_AT = "last_modified_at";
    static final String TOTAL_BYTES = "total_bytes";
    static final String URL = "url";
    private String dirPath;
    private long downloadedBytes;
    private String eTag;
    private String fileName;

    /* renamed from: id */
    private int f125id;
    private long lastModifiedAt;
    private long totalBytes;
    private String url;

    public int getId() {
        return this.f125id;
    }

    public void setId(int i) {
        this.f125id = i;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public String getETag() {
        return this.eTag;
    }

    public void setETag(String str) {
        this.eTag = str;
    }

    public String getDirPath() {
        return this.dirPath;
    }

    public void setDirPath(String str) {
        this.dirPath = str;
    }

    public String getFileName() {
        return this.fileName;
    }

    public void setFileName(String str) {
        this.fileName = str;
    }

    public long getTotalBytes() {
        return this.totalBytes;
    }

    public void setTotalBytes(long j) {
        this.totalBytes = j;
    }

    public long getDownloadedBytes() {
        return this.downloadedBytes;
    }

    public void setDownloadedBytes(long j) {
        this.downloadedBytes = j;
    }

    public long getLastModifiedAt() {
        return this.lastModifiedAt;
    }

    public void setLastModifiedAt(long j) {
        this.lastModifiedAt = j;
    }
}
