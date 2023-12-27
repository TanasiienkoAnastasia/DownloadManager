package org.example.DownloadManager.Observer;

public class pauseResume {
    public static void main(String[] args) {
            Editor editor = new Editor();
            try {
                editor.pauseDownload("url");
                editor.resumeDownload("url");
                editor.startDownload("url");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
