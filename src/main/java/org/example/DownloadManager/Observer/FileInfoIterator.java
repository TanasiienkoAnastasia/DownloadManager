package org.example.DownloadManager.Observer;

import org.example.DownloadManager.models.FileInfo;

public interface FileInfoIterator {
        boolean hasNext();
        FileInfo next();
}
