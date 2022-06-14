import org.json.JSONArray;
import org.json.JSONObject;
import java.io.*;
import java.util.*;

public class DataController {

     static List<Employee> parseCards(String patch) {
         File file = new File(patch);
         List<Employee> employeesList = new ArrayList<Employee>();
         try (FileReader reader = new FileReader(file)) {
             // Считываем содержимое файла в объект JsonObject
             int fileLen = (int) file.length();
             char[] chars = new char[fileLen];
             reader.read(chars);
             String s = String.valueOf(chars);
             JSONObject jsonObject = new JSONObject (s); // Это можно понимать как удаление самого внешнего {}

             // Анализ объекта JSONObject
             JSONArray employees = jsonObject.getJSONArray("employees");

             for (Object employee : employees) {
                 // Получаем единственный объект JSONObject
                 JSONObject employeeObject = (JSONObject) employee;
                 Employee emp = new Employee();
                 emp.setFirstName(employeeObject.getString("firstName"));
                 emp.setLastName(employeeObject.getString("lastName"));
                 emp.setDescription(employeeObject.get("description").toString());

                 ArrayList<String> characteristics = new ArrayList<>();
                 employeeObject.getJSONArray("characteristics").forEach(str -> characteristics.add(str.toString()));
                 Collections.sort(characteristics);//Сортировка характеристик в алфавитном порядке

                 emp.setCharacteristics(characteristics);
                 emp.setPost(Main.postMap.getPostFromUUID(UUID.fromString(employeeObject.getString("postId"))));
                 employeesList.add(emp);
             }

         } catch (Exception e) {
             e.printStackTrace();
         }
          return employeesList;
    }

    //Сортировка в алфавитном порядке указанного поля списка карточек
    static void ascSortCards(List<Employee> empCards, String fieldName){
        if (fieldName == "firstName")
            empCards.sort(new SortEmployeesByFirstName());
        else if (fieldName == "lastName")
            empCards.sort(new SortEmployeesByLastName());
    }

    static void printCards(List<Employee> empCards){
        System.out.println("Employee cards:");
        empCards.forEach(emp -> emp.printCard());
    }
}
