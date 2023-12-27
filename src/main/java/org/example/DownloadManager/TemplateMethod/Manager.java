package org.example.DownloadManager.TemplateMethod;

public abstract class Manager {
    String userName;
    String password;
    Manager() {}
    public boolean post() {
        if (logIn(this.userName, this.password)) {
            logOut();
        }
        return false;
    }

    abstract boolean logIn(String userName, String password);
    abstract void logOut();
}
