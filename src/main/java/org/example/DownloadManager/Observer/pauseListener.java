package org.example.DownloadManager.Observer;

import java.io.File;

public class pauseListener implements EventListener {
    private File url;

    public pauseListener(String fileUrl) {
        this.url = new File(fileUrl);
    }

    @Override
    public void update(String eventType, File file) {
        System.out.println("Pause for url " + url + ": Someone has performed "
                + eventType + " operation with the following file: " + file.getName());
    }
}
