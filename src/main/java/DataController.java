import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonWriter;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DataController {

     static void parseCards() {
         File file = new File("src/test/resources/Employee.json");
         try (FileReader reader = new FileReader(file)) {
             // Считываем содержимое файла в объект JsonObject
             int fileLen = (int) file.length();
             char[] chars = new char[fileLen];
             reader.read(chars);
             String s = String.valueOf(chars);
             System.out.println(s+"\n");
             JSONObject jsonObject = new JSONObject (s); // Это можно понимать как удаление самого внешнего {}

             // Анализ объекта JSONObject
             JSONArray employees = jsonObject.getJSONArray("employees");
             List<Employee> employeesList = new ArrayList<Employee>();
             for (Object employee : employees) {
                 // Получаем единственный объект JSONObject
                 JSONObject employeeObject = (JSONObject) employee;
                 Employee emp = new Employee();
                 emp.setFirstName(employeeObject.getString("firstName"));
                 emp.setLastName(employeeObject.getString("lastName"));
                 emp.setDescription(employeeObject.get("description").toString());
                 ArrayList<String> characteristics = new ArrayList<>();
                 employeeObject.getJSONArray("characteristics").forEach(str -> characteristics.add(str.toString()));
                 emp.setCharacteristics(characteristics);
                 emp.setPostId(employeeObject.getString("postId"));
                 employeesList.add(emp);
             }

             System.out.println(employeesList.get(0).getFirstName());
             System.out.println(employeesList.get(2).getFirstName());
             /*employeesList.forEach(emp -> System.out.println(emp.getFirstName()));*/

         } catch (Exception e) {
             e.printStackTrace();
         }

    }

    static void printCards(List<Employee> empCards){

    }
}
