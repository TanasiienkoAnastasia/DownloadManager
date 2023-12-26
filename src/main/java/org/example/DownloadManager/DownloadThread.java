package org.example.DownloadManager;

import org.example.DownloadManager.models.FileInfo;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

public class DownloadThread extends Thread {

    public FileInfo file;
    private static final int MAX_DOWNLOAD_SPEED = 1024 * 1024;
    private long downloadSpeedLimit = Long.MAX_VALUE;
    private long lastUpdateTime;
    private long bytesDownloadedSinceLastUpdate;
    private volatile boolean downloadFailed = false;
    DownloadManager manager;

    private volatile boolean paused = false;

    public DownloadThread(FileInfo file, DownloadManager manager) {
        this.file = file;
        this.manager = manager;
    }

    public void pauseDownload() {
        paused = true;
    }

    public void resumeDownload() {
        paused = false;
    }

    public void setDownloadSpeed(long speedLimit) {
        if (speedLimit > 0) {
            downloadSpeedLimit = speedLimit;
        } else {
            // Якщо передане обмеження є від'ємним або нульовим, встановіть без обмеження
            downloadSpeedLimit = Long.MAX_VALUE;
        }
    }

    @Override
    public void run() {
        this.file.setStatus("DOWNLOADING");
        this.manager.updateUI(this.file);

        try {
            URL url = new URL(this.file.getUrl());
            URLConnection urlConnection = url.openConnection();
            int fileSize = urlConnection.getContentLength();
            System.out.println("File size: " + fileSize);

            int countByte = 0;
            double per = 0.0;
            double byteSum = 0.0;

            BufferedInputStream bufferedInputStream = new BufferedInputStream(url.openStream());
            FileOutputStream fos = new FileOutputStream(this.file.getPath());
            byte data[] = new byte[1024];
            long startTime = System.currentTimeMillis();

            while (true) {
                if (paused) {
                    try {
                        sleep(1000); // Sleep for 1 second, you can adjust this value
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    continue;
                }

                countByte = bufferedInputStream.read(data, 0, 1024);
                if (countByte == -1) {
                    break;
                }

                fos.write(data, 0, countByte);
                byteSum = byteSum + countByte;

                if (fileSize > 0) {
                    per = (byteSum / fileSize * 100);
                    System.out.println(per);
                    this.file.setPer(per + "");
                    this.manager.updateUI(file);

                    long currentTime = System.currentTimeMillis();
                    long elapsedTime = currentTime - startTime;
                    bytesDownloadedSinceLastUpdate += countByte;

                    if (elapsedTime >= 1000) { // Перевірка кожну секунду
                        long averageSpeed = bytesDownloadedSinceLastUpdate / elapsedTime;
                        if (averageSpeed > downloadSpeedLimit) {
                            try {
                                long sleepTime = (bytesDownloadedSinceLastUpdate / downloadSpeedLimit) - elapsedTime;
                                if (sleepTime > 0) {
                                    sleep(sleepTime);
                                }
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        bytesDownloadedSinceLastUpdate = 0;
                        startTime = currentTime;
                    }
                    }
            }

            fos.close();
            bufferedInputStream.close();

            this.setName("100");
            this.file.setStatus("DONE");
        } catch (IOException e) {
            this.file.setStatus("Failed");
            this.downloadFailed = true;
            System.out.println("Downloading error");
            e.printStackTrace();
        }
        this.manager.updateUI(this.file);
    }
}