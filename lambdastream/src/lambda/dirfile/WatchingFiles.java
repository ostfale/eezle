package de.ostfale.fp.lambda.dirfile;

import java.io.IOException;
import java.nio.file.*;
import java.util.concurrent.TimeUnit;

/**
 * Created by Uwe Sauerbrei on 25.02.2018
 */
public class WatchingFiles {
    public static void main(String[] args) {
        new WatchingFiles().doIt();
    }

    private void doIt() {
        try {
            watchFileChange();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void watchFileChange() throws IOException, InterruptedException {
        final Path path = Paths.get(".");
        final WatchService watchService = path.getFileSystem().newWatchService();
        path.register(watchService, StandardWatchEventKinds.ENTRY_MODIFY);
        System.out.println("Report any file changed within next 1 minute...");

        final WatchKey watchKey = watchService.poll(1, TimeUnit.MINUTES);
        if (watchKey != null) {
            watchKey.pollEvents()
                    .forEach(watchEvent -> System.out.println(watchEvent.context()) );
        }
    }
}
