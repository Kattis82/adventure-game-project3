package se.sprinto.hakan.adventuregame.config;

import se.sprinto.hakan.adventuregame.dao.AppFileHandler;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class AppInfo {

        private static AppInfo instance;
        private Properties properties;

        private AppInfo() {

            // ser till att filen finns först

            AppFileHandler.createConfigFile();

            // läser in configurationen

            properties = new Properties();
            try (FileReader reader = new FileReader("configuration.txt")) {
                properties.load(reader);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public static AppInfo getInstance() {
            if (instance == null) {
                instance = new AppInfo();
            }
            return instance;
        }


        public String getProperty(String key) {
            return properties.getProperty(key);
        }

    }


