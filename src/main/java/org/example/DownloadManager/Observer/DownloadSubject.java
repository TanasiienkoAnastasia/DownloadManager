package org.example.DownloadManager.Observer;

public interface DownloadSubject {
    void registerObserver(DownloadObserver observer);
    void removeObserver(DownloadObserver observer);
    void notifyObservers();
}