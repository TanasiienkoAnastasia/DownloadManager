package org.example.DownloadManager.Observer;

import javafx.application.Platform;
import org.example.DownloadManager.models.FileInfo;

public class DownloadProgressObserver implements DownloadObserver{
    private DownloadController downloadController;

    public DownloadProgressObserver(DownloadController downloadController) {
        this.downloadController = downloadController;
    }

    @Override
    public void update(FileInfo fileInfo) {
        Platform.runLater(() -> downloadController.updateUI(fileInfo));
    }
}
