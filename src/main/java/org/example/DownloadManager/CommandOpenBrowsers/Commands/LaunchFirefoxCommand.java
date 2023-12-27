package org.example.DownloadManager.CommandOpenBrowsers.Commands;


import org.example.DownloadManager.CommandOpenBrowsers.CommandInterface.Command;
import org.example.DownloadManager.CommandOpenBrowsers.ReceiverClasses.DownloadManagerFileSystemReceiver;

public class LaunchFirefoxCommand implements Command {
    private DownloadManagerFileSystemReceiver downloadManager;

    public LaunchFirefoxCommand(DownloadManagerFileSystemReceiver dm){
        this.downloadManager=dm;
    }

    @Override
    public void execute() {
        this.downloadManager.launchFirefox();
    }
}
