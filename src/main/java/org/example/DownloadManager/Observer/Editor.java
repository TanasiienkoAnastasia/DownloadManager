package org.example.DownloadManager.Observer;


import org.example.DownloadManager.models.File;

public class Editor {
    public EventManager events;

    public Editor() {
        this.events = new EventManager("pause", "resume", "start");
    }

    public void pauseDownload(String url) {

        events.notify("pause");
    }

    public void resumeDownload(String url) throws Exception {
        events.notify("resume");
    }

    public void startDownload(String url) throws Exception {
        events.notify("start");
    }
}
