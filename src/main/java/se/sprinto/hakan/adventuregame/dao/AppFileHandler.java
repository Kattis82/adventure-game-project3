package se.sprinto.hakan.adventuregame.dao;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class AppFileHandler {

    public static void createConfigFile() {

        Path configPath = Path.of("configuration.txt");

        try {
            if (Files.notExists(configPath)) {
                Files.createFile(configPath);
                Files.writeString(configPath,
                        "app.author=Kattis Calmvik\n" +
                                "app.version=1.1\n");
                System.out.println("Configuration file created at: " + configPath.toAbsolutePath());
            }
        } catch (IOException e) {
            System.err.println("Error creating configuration file: " + e.getMessage());
        }
    }
}
