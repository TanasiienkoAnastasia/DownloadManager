package org.example.DownloadManager.CommandDownloadViaBrowser.Commands;

import org.example.DownloadManager.CommandDownloadViaBrowser.CommandInterface.Command;

import java.io.IOException;

public class DownloadLinkViaInternetExplorerCommand implements Command {
    private String url;

    public DownloadLinkViaInternetExplorerCommand(String url) {
        this.url = url;
    }

    @Override
    public void execute() {
        try {
            String command = "\"C:\\Program Files (x86)\\Microsoft\\Edge\\Application\\msedge.exe\"" + url;
            Runtime.getRuntime().exec(command);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
