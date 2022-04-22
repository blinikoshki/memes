package com.downloader.database;

import java.util.List;

public interface DbHelper {
    void clear();

    DownloadModel find(int i);

    List<DownloadModel> getUnwantedModels(int i);

    void insert(DownloadModel downloadModel);

    void remove(int i);

    void update(DownloadModel downloadModel);

    void updateProgress(int i, long j, long j2);
}
