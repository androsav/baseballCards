package service.parseService;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.File;
import java.io.FileReader;

public class JsonFileToJsonArray {

    public static JSONArray ParseToJsonArray(String patch, String arrayName) {
        File file = new File(patch);
        try (FileReader reader = new FileReader(file)) {
            // Считываем содержимое файла в объект JsonObject
            int fileLen = (int) file.length();
            char[] chars = new char[fileLen];
            reader.read(chars);
            String s = String.valueOf(chars);
            JSONObject jsonObject = new JSONObject(s); // Это можно понимать как удаление самого внешнего {}

            // Анализ объекта JSONObject
            JSONArray employees = jsonObject.getJSONArray(arrayName);
            return employees;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
