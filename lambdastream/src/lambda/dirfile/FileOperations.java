package de.ostfale.fp.lambda.dirfile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by Uwe Sauerbrei on 19.02.2018
 */
public class FileOperations {

    public static void main(String[] args) {
        new FileOperations().doIt();
    }

    private void doIt() {
        try {
            listAllSubdirectoriesInCurrentDirectory();
            listAllFilesInCurrentDirectory();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void listAllSubdirectoriesInCurrentDirectory() throws IOException {
        System.out.println("List all Subdirectories...");
        Files.list(Paths.get("."))
                .filter(Files::isDirectory)
                .forEach(System.out::println);
    }

    private void listAllFilesInCurrentDirectory() throws IOException {
        System.out.println("List all files...");
        Files.list(Paths.get("."))
                .forEach(System.out::println);
    }
}
