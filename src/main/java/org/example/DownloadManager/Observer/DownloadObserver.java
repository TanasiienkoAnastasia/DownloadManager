package org.example.DownloadManager.Observer;

import org.example.DownloadManager.models.FileInfo;

public interface DownloadObserver {
    void update(FileInfo fileInfo);
}
