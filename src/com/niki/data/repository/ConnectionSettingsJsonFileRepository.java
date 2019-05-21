package com.niki.data.repository;

import com.niki.domain.entities.ConnectionSettings;
import com.niki.domain.gateways.repositories.ConnectionSettingsRepository;
import org.json.simple.JSONObject;

import static com.niki.data.cache.file.JsonReadWriter.readJsonObject;
import static com.niki.data.cache.file.JsonReadWriter.writeJsonStr;

public class ConnectionSettingsJsonFileRepository implements ConnectionSettingsRepository {

    private static final String SETTINGS_FILE = "db-settings.json";

    @Override
    public ConnectionSettings get() {
        JSONObject jsonObject = readJsonObject(SETTINGS_FILE);

        if (jsonObject != null) {
            return fromJson(jsonObject);
        } else {
            return null;
        }
    }

    @Override
    public void save(ConnectionSettings settings) {
        JSONObject settingsJson = toJson(settings);

        writeJsonStr(SETTINGS_FILE, settingsJson.toJSONString());
    }

    private static JSONObject toJson(ConnectionSettings settings) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("host", settings.getHost());
        jsonObject.put("db_name", settings.getDatabase());
        jsonObject.put("user", settings.getUser());
        jsonObject.put("password", settings.getPassword());

        return jsonObject;
    }

    private static ConnectionSettings fromJson(JSONObject jsonObject) {
        return new ConnectionSettings(
                (String) jsonObject.get("host"),
                (String) jsonObject.get("db_name"),
                (String) jsonObject.get("user"),
                (String) jsonObject.get("password")
        );
    }
}
