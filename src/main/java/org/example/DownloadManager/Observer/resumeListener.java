package org.example.DownloadManager.Observer;

import java.io.File;

public class resumeListener implements EventListener {
    private File log;

    public resumeListener(String fileName) {
        this.log = new File(fileName);
    }

    @Override
    public void update(String eventType, File file) {
        System.out.println("resume url " + log + ": Someone has performed "
                + eventType + " operation with the following file: " + file.getName());
    }
}
