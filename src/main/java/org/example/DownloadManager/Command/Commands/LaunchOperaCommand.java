package org.example.DownloadManager.Command.Commands;


import org.example.DownloadManager.Command.CommandInterface.Command;
import org.example.DownloadManager.Command.ReceiverClasses.DownloadManagerFileSystemReceiver;

public class LaunchOperaCommand implements Command {
    private DownloadManagerFileSystemReceiver downloadManager;

    public LaunchOperaCommand(DownloadManagerFileSystemReceiver dm){
        this.downloadManager=dm;
    }

    @Override
    public void execute() {
        this.downloadManager.launchOpera();
    }
}
