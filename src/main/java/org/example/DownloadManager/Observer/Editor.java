package org.example.DownloadManager.Observer;


import org.example.DownloadManager.models.File;

public class Editor {
    public EventManager events;

    public Editor() {
        this.events = new EventManager("pause", "resume");
    }

    public void pauseFile(String url) {
        events.notify("pause");
    }

    public void resumeFile(String url) throws Exception {
        events.notify("resume");
    }
}
