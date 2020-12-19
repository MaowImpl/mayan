package maow.mayan.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public final class IOUtils {
    public static List<String> toStringList(Path path) throws IOException {
        final BufferedReader br = Files.newBufferedReader(path);
        return br.lines().collect(Collectors.toList());
    }

    public static boolean newFolder(String name) throws IOException {
        final Path folder = Paths.get(name);
        return Files.exists(Files.createDirectory(folder));
    }

    public static boolean newFile(String name) throws IOException {
        final Path file = Paths.get(name);
        return Files.exists(Files.createFile(file));
    }

    public static InputStream getResourceAsStream(String name) {
        final String begin = (name.startsWith("/")) ? "" : "/";
        return IOUtils.class.getResourceAsStream(begin + name);
    }

    public static List<Path> listFiles(Path dir) throws IOException {
        final List<Path> files = new ArrayList<>();
        if (Files.isDirectory(dir)) {
            return Files.list(dir).collect(Collectors.toList());
        }
        return files;
    }

    public static List<Path> listFiles(Path dir, String extension) throws IOException {
        final List<Path> files = new ArrayList<>();
        if (Files.isDirectory(dir)) {
            return Files.list(dir).filter(path -> path.toFile().getName().endsWith(extension)).collect(Collectors.toList());
        }
        return files;
    }
}