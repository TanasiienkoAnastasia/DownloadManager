package org.example.DownloadManager.CommandOpenBrowsers.Commands;


import org.example.DownloadManager.CommandOpenBrowsers.CommandInterface.Command;
import org.example.DownloadManager.CommandOpenBrowsers.ReceiverClasses.DownloadManagerFileSystemReceiver;

public class LaunchGoogleCommand implements Command {
    private DownloadManagerFileSystemReceiver downloadManager;

    public LaunchGoogleCommand(DownloadManagerFileSystemReceiver dm){
        this.downloadManager=dm;
    }

    @Override
    public void execute() {
        this.downloadManager.launchGoogle();
    }
}
