package org.example.DownloadManager.Observer;

public class pauseResumeDemo {
    public static void main(String[] args) {
            Editor editor = new Editor();
            editor.events.subscribe("pause", new pauseListener("/path/to/log/file.txt"));
            editor.events.subscribe("resume", new resumeListener("/path/to/log/file.txt"));

            try {
                editor.pauseFile("test.txt");
                editor.resumeFile("test.txt");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
