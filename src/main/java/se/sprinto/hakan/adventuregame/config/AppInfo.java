package se.sprinto.hakan.adventuregame.config;

import se.sprinto.hakan.adventuregame.dao.AppFileHandler;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

// Syfte att ladda och ge tillgång till programmets inställningar (version och
// namn) från ett ställe

public class AppInfo {

        private static AppInfo instance;
        private Properties properties;


        // det finns bara ett enda AppInfo-objekt i hela programmet (Singleton)
        private AppInfo() {

            // ser till att filen finns först
            AppFileHandler.createConfigFile();

            // läser in configurationsfilen (innehållet) till ett Properties-objekt
            properties = new Properties();
            try (FileReader reader = new FileReader("configuration.txt")) {
                properties.load(reader);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // skapar den enda instansen av AppInfo
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


