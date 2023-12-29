package org.example.DownloadManager.Observer.Composite;

public class FileDownloadTask implements DownloadTask {
    private String filename;

    public FileDownloadTask(String filename) {
        this.filename = filename;
    }

    @Override
    public void execute() {
        System.out.println("Downloading file: " + filename);
    }
}