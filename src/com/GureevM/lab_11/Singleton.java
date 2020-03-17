package com.GureevM.lab_11;

import java.util.Properties;
import java.io.*;

public class Singleton {

    private static Singleton INSTANCE;
    private static Properties properties = new Properties();

    private Singleton() {
    }

    public synchronized static Singleton getInstance() {
        if(INSTANCE == null){
            INSTANCE = new Singleton();
            loadPropertiesFile();
        }
        return INSTANCE;
    }

    public Properties getProperties(){
        return properties;
    }

    private static String getPropertiesFilePath() {
        File file = new File("src/com/GureevM/lab_11/config.properties");
        return file.getPath();
    }


    public static void loadPropertiesFile(){
        String configPath = getPropertiesFilePath();
        try {
            properties.load(new FileInputStream(configPath));
            System.out.println("Значения загружены из файла.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}