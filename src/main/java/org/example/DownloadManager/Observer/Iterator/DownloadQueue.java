package org.example.DownloadManager.Observer.Iterator;

import org.example.DownloadManager.Observer.Composite.DownloadTask;
import org.example.DownloadManager.models.FileInfo;

import java.util.*;

class DownloadQueue implements Iterable<FileInfo>, DownloadTask {
    private Queue<FileInfo> queue = new LinkedList<>();

    public void enqueue(FileInfo file) {
        queue.offer(file);
    }

    public FileInfo dequeue() {
        return queue.poll();
    }

    public int size() {
        return queue.size();
    }

    @Override
    public Iterator<FileInfo> iterator() {
        return new DownloadIterator();
    }

    private class DownloadIterator implements Iterator<FileInfo> {
        @Override
        public boolean hasNext() {
            return !queue.isEmpty();
        }

        @Override
        public FileInfo next() {
            if (!hasNext()) {
                throw new IllegalStateException("Queue is empty");
            }
            return queue.poll();
        }
    }

    private List<DownloadTask> tasks = new ArrayList<>();

    public void addTask(DownloadTask task) {
        tasks.add(task);
    }

    @Override
    public void execute() {
        for (DownloadTask task : tasks) {
            task.execute();
        }
    }
}