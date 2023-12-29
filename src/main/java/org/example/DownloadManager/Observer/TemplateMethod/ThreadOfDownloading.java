package org.example.DownloadManager.Observer.TemplateMethod;

import org.example.DownloadManager.Observer.Iterator.DownloadController;
import org.example.DownloadManager.models.FileInfo;

public class ThreadOfDownloading extends AbstractDownloadThread {

    private static final int MAX_DOWNLOAD_SPEED = 1024 * 1024;
    private long downloadSpeedLimit = Long.MAX_VALUE;
    private long lastUpdateTime;
    private long bytesDownloadedSinceLastUpdate;
    private volatile boolean downloadFailed = false;
    private volatile boolean paused = false;
    public ThreadOfDownloading(FileInfo file, DownloadController controller) {
        super(file, controller);
    }


    @Override
    public void pauseDownload() {
        paused = true;
    }

    @Override
    public void resumeDownload() {
        paused = false;
    }

    @Override
    public void setDownloadSpeed(long speedLimit) {
        if (speedLimit > 0) {
            downloadSpeedLimit = speedLimit;
        } else {
            // Якщо передане обмеження є від'ємним або нульовим, встановіть без обмеження
            downloadSpeedLimit = Long.MAX_VALUE;
        }
    }


}