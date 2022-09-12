package service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class LeitorDeArquivos {

    private LeitorDeArquivos() {
    }

    public static Stream<String> readPorLinha(Path path) {
        try {
            return Files.lines(path);
        } catch (Exception e) {
            return Stream.empty();
        }
    }
    
}
