package com.downloader.database;

import java.util.List;

public class NoOpsDbHelper implements DbHelper {
    public void clear() {
    }

    public DownloadModel find(int i) {
        return null;
    }

    public List<DownloadModel> getUnwantedModels(int i) {
        return null;
    }

    public void insert(DownloadModel downloadModel) {
    }

    public void remove(int i) {
    }

    public void update(DownloadModel downloadModel) {
    }

    public void updateProgress(int i, long j, long j2) {
    }
}
