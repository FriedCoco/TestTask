//import java.io.FileReader;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.util.HashMap;
//import java.util.Map;
//import javax.json.Json;
//import javax.json.JsonObject;
//import javax.json.JsonReader;
//import javax.json.JsonWriter;
//import javax.json.JsonWriterFactory;
//import javax.json.stream.JsonGenerator;
//import java.util.Collections;
//
//
//public class GenerateReport {
//    public static void main(String[] args) {
//        if (args.length != 2) {
//            System.out.println("Usage: java GenerateReport <tests.json> <values.json>");
//            return;
//        }
//
//        String testsJsonFileName = args[0];
//        String valuesJsonFileName = args[1];
//
//        try (JsonReader valuesJsonReader = Json.createReader(new FileReader(valuesJsonFileName);
//             JsonReader testsJsonReader = Json.createReader(new FileReader(testsJsonFileName));
//             FileWriter reportJsonWriter = new FileWriter("report.json")) {
//
//            // Чтение values.json
//            JsonObject valuesObject = valuesJsonReader.readObject();
//            Map<Integer, String> valuesMap = new HashMap<>();
//            valuesObject.getJsonArray("values").forEach(value -> {
//                int id = value.getJsonNumber("id").intValue();
//                String result = value.getString("value");
//                valuesMap.put(id, result);
//            });
//
//            // Чтение и обновление tests.json
//            JsonObject testsObject = testsJsonReader.readObject();
//            updateTestsJson(testsObject, valuesMap);
//
//            // Запись результата в report.json
//            JsonWriterFactory writerFactory = Json.createWriterFactory(Collections.singletonMap(JsonGenerator.PRETTY_PRINTING, true));
//            JsonWriter reportJsonWriter = writerFactory.createWriter(reportJsonWriter);
//            reportJsonWriter.writeObject(testsObject);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    private static void updateTestsJson(JsonObject node, Map<Integer, String> valuesMap) {
//        int id = node.getInt("id", -1);
//        if (id != -1 && valuesMap.containsKey(id)) {
//            node = Json.createObjectBuilder(node).add("value", valuesMap.get(id)).build();
//        }
//
//        for (String key : node.keySet()) {
//            if (node.get(key) instanceof JsonObject) {
//                updateTestsJson(node.getJsonObject(key), valuesMap);
//            } else if (node.get(key) instanceof JsonArray) {
//                node = Json.createObjectBuilder(node).add(key, updateJsonArray(node.getJsonArray(key), valuesMap)).build();
//            }
//        }
//    }
//
//    private static JsonArray updateJsonArray(JsonArray jsonArray, Map<Integer, String> valuesMap) {
//        JsonArrayBuilder updatedArray = Json.createArrayBuilder();
//        jsonArray.forEach(item -> {
//            if (item instanceof JsonObject) {
//                updatedArray.add(updateTestsJson((JsonObject) item, valuesMap));
//            } else {
//                updatedArray.add(item);
//            }
//        });
//        return updatedArray.build();
//    }
//}
