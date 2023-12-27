package org.example.DownloadManager.Observer;

import java.io.File;

public class urlResumeListener implements EventListener {

    private File url;

    @Override
    public void update(String eventType) {
        System.out.println(": Someone has performed "
                + eventType + "with url" + url);
    }
}
