package exersize;
import java.nio.file.*;
import java.io.IOException;

public class FileManager {
    public static void writeToFile(Path path, String content) throws IOException {
        Files.writeString(path, "");
        Files.writeString(
            path,
            content
        );
    }

    public static String readFromFile(Path path) throws IOException {
        if (Files.exists(path)) {
            return Files.readString(path);
        } else {
            return "Файл не найден";
        }
    }
}
