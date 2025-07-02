package com.tests.ultilities;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.Hashtable;

public class JsonHelper {

    public static Object[][] jsonArrayToObjectArray(JsonArray jsonArray) {
        Object[][] data = new Object[0][1];
        int index = 0;
        Gson gson = new Gson();

        if (!jsonArray.isEmpty()) {
            data = new Object[jsonArray.size()][1];
            for (JsonElement obj : jsonArray) {
                data[index][0] = gson.fromJson(obj, Hashtable.class);
                index++;
            }
        }
        return data;
    }

    public static Object[][] jsonObjectToObjectArray(JsonObject jsonObject) {
        JsonArray newArray = new JsonArray();
        newArray.add(jsonObject);
        return jsonArrayToObjectArray(newArray);
    }
}
