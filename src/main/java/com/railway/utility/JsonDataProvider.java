package com.railway.utility;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class JsonDataProvider {

    private static final String JSON_FILE = "dataset.json";   // nằm trong resources

    public static Object[][] getData(String... testCaseIds) {
        List<Object[]> rows = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();

        try (InputStream is = JsonDataProvider.class.getClassLoader()
                .getResourceAsStream(JSON_FILE)) {

            if (is == null) {
                throw new RuntimeException("Cannot find file: " + JSON_FILE);
            }

            // Parse toàn bộ file thành JsonNode
            JsonNode root = mapper.readTree(is);

            for (String id : testCaseIds) {
                JsonNode node = root.get(id);

                if (node == null) {
                    throw new RuntimeException("Cannot find data for: " + id);
                }

                if (node.isArray()) {
                    // TC là một mảng – mỗi phần tử → một dòng data
                    for (JsonNode item : node) {
                        rows.add(new Object[]{id, mapper.convertValue(item,
                                new TypeReference<Map<String, String>>() {})});
                    }
                } else if (node.isObject()) {
                    // TC là object duy nhất
                    rows.add(new Object[]{id, mapper.convertValue(node,
                            new TypeReference<Map<String, String>>() {})});
                } else {
                    throw new RuntimeException("Json format not support: " + id);
                }
            }

        } catch (Exception e) {
            throw new RuntimeException("Failed to read JSON file: " + JSON_FILE, e);
        }

        return rows.toArray(new Object[0][0]);
    }

    /* ---------- DataProvider cụ thể ---------- */

    // Dành cho đăng nhập (TC01, TC02, TC03…)
    @DataProvider(name = "LoginData")
    public static Object[][] loginData() {
        return getData("TC01");
    }

    // Đặt 1 vé (TC14 – mảng 1‑phần tử, nhưng ta vẫn dùng chung hàm)
    @DataProvider(name = "SingleTicketData")
    public static Object[][] singleTicketData() {
        return getData("TC14");
    }

    // Đặt nhiều vé (TC16 – mảng 3 phần tử)
    @DataProvider(name = "MultiTicketData")
    public static Object[][] multiTicketData() {
        return getData("TC16");
    }
}
