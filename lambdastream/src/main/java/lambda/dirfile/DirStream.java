package lambda.dirfile;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 * Dirstream should be used with large directories.
 * Created by Uwe Sauerbrei on 23.02.2018
 */
public class DirStream {

    private final static String localPath = "/lambdastream/src/lambda/dirfile";
    private final static String parentLocalPath = "/lambdastream/src/lambda";


    public static void main(String[] args) {
        try {
            new DirStream().doIt();
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }

    private void doIt() throws IOException, URISyntaxException {
        listingImmediateSubdirectoriesFlatMap();
        listingImmediateSubdirectoriesTraditionally();
        listAllJavaFiles();
    }

    private void listingImmediateSubdirectoriesFlatMap() {
        List<File> files =
                Stream.of(Objects.requireNonNull(new File(".").listFiles()))
                        .flatMap(file -> file.listFiles() == null ? Stream.of(file) : Stream.of(Objects.requireNonNull(file.listFiles())))
                        .collect(toList());
        System.out.println("Flatmap count: " + files.size());
    }

    private void listingImmediateSubdirectoriesTraditionally() {
        List<File> files = new ArrayList<>();
        File[] filesInCurrentDir = new File(".").listFiles();
        for (File file : filesInCurrentDir) {
            File[] filesInSubDir = file.listFiles();
            if (filesInSubDir != null) {
                files.addAll(Arrays.asList(filesInSubDir));
            } else {
                files.add(file);
            }
        }
        System.out.println("Count: " + files.size());
    }

    private void listAllJavaFiles() throws IOException, URISyntaxException {
        Files.newDirectoryStream(Paths.get(getLocalProgramPath()), path -> path.toString().endsWith(".java"))
                .forEach(System.out::println);
    }

    private String getLocalProgramPath() throws URISyntaxException {
        String s = Paths.get(".").toAbsolutePath().normalize().toString();
        return s + localPath;
    }
}
