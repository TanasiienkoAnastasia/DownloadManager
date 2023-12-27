package org.example.DownloadManager.CommandDownloadViaBrowser.Commands;

import org.example.DownloadManager.CommandDownloadViaBrowser.CommandInterface.Command;

import java.io.IOException;

public class DownloadLinkViaGoogleCommand implements Command {
    private String url;

    public DownloadLinkViaGoogleCommand(String url) {
        this.url = url;
    }

    @Override
    public void execute() {
        try {
            String command = "\"C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe\" " + url;
            Runtime.getRuntime().exec(command);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
