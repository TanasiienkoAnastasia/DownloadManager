package org.example.DownloadManager.CommandOpenBrowsers.Commands;


import org.example.DownloadManager.CommandOpenBrowsers.CommandInterface.Command;
import org.example.DownloadManager.CommandOpenBrowsers.ReceiverClasses.DownloadManagerFileSystemReceiver;

public class LaunchInternetExplorerCommand implements Command {
    private DownloadManagerFileSystemReceiver downloadManager;

    public LaunchInternetExplorerCommand(DownloadManagerFileSystemReceiver dm){
        this.downloadManager=dm;
    }

    @Override
    public void execute() {
        this.downloadManager.launchInternetExplorer();
    }
}
