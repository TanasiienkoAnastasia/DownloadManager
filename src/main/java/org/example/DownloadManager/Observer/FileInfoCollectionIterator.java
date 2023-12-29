package org.example.DownloadManager.Observer;


import org.example.DownloadManager.models.FileInfo;

import java.util.List;
import java.util.NoSuchElementException;

public class FileInfoCollectionIterator implements FileInfoIterator {
    private List<FileInfo> fileInfoList;
    private int currentIndex;

    public FileInfoCollectionIterator(List<FileInfo> fileInfoList) {
        this.fileInfoList = fileInfoList;
        this.currentIndex = 0;
    }

    @Override
    public boolean hasNext() {
        return currentIndex < fileInfoList.size();
    }

    @Override
    public FileInfo next() {
        if (hasNext()) {
            return fileInfoList.get(currentIndex++);
        }
        throw new NoSuchElementException("No more elements in the collection.");
    }
}