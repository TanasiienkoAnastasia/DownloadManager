package org.example.DownloadManager.CommandDownloadViaBrowser.Commands;

import org.example.DownloadManager.CommandDownloadViaBrowser.CommandInterface.Command;

import java.io.IOException;

public class DownloadLinkViaOperaCommand implements Command{
    private String url;

    public DownloadLinkViaOperaCommand(String url) {
        this.url = url;
    }

    @Override
    public void execute() {
        try {
            String command = "\"C:\\Users\\shepe\\AppData\\Local\\Programs\\Opera\\launcher.exe\"" + url;
            Runtime.getRuntime().exec(command);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


