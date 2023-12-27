package org.example.DownloadManager.Command.InvokerClasses;

import org.example.DownloadManager.Command.CommandInterface.Command;


public class FileInvoker {
    public Command command;

    public FileInvoker(Command c){
        this.command=c;
    }

    public void execute(){
        this.command.execute();
    }
}
