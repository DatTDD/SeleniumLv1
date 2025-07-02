package com.tests.ultilities;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Iterator;

public class JsonDataProvider {
    private static final String FILE_PATH = "src/main/resources/dataset.json";

    @DataProvider(name = "JsonData")
    public static Object[][] getTestData(Method method) throws IOException {
        String testClass = method.getDeclaringClass().getSimpleName();

        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(new File(FILE_PATH));
        JsonNode testData = root.get(testClass);

        if (testData == null || !testData.isArray()) {
            throw new RuntimeException("Test data not found or invalid format for: " + testClass);
        }

        Object[][] data = new Object[testData.size()][1];
        int index = 0;
        for (Iterator<JsonNode> it = testData.iterator(); it.hasNext(); ) {
            data[index++][0] = it.next();
        }
        return data;
    }

}