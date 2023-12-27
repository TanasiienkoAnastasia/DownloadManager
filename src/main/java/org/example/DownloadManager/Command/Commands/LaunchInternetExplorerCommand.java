package org.example.DownloadManager.Command.Commands;


import org.example.DownloadManager.Command.CommandInterface.Command;
import org.example.DownloadManager.Command.ReceiverClasses.DownloadManagerFileSystemReceiver;

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
