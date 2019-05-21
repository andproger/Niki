package com.niki.data.cache.file;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class JsonReadWriter {
    public static void writeJsonStr(String filepath, String json) {
        try (FileWriter file = new FileWriter(filepath)) {

            file.write(json);
            file.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static JSONObject readJsonObject(String filepath) {
        try {
            return (JSONObject) new JSONParser().parse(new FileReader(filepath));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
