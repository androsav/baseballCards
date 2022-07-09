package service.parseService;
import model.Employee;
import org.json.JSONArray;
import org.json.JSONObject;
import service.postService.PostServiceImpl;
import java.util.ArrayList;
import java.util.Collections;
import java.util.UUID;


public class JsonArrayToEmployeeList {

    public static ArrayList<Employee> ParseToEmployeeList(JSONArray employees){
        PostServiceImpl postService = new PostServiceImpl();
        ArrayList<Employee> employeesList = new ArrayList<Employee>();

        for (Object employee : employees) {
            // Получаем единственный объект JSONObject
            JSONObject employeeObject = (JSONObject) employee;
            Employee emp = new Employee();
            emp.setId(UUID.fromString(employeeObject.getString("id")));
            emp.setFirstName(employeeObject.getString("firstName"));
            emp.setLastName(employeeObject.getString("lastName"));
            emp.setDescription(employeeObject.get("description").toString());

            ArrayList<String> characteristics = new ArrayList<>();
            employeeObject.getJSONArray("characteristics").forEach(str -> characteristics.add(str.toString()));
            Collections.sort(characteristics);//Сортировка характеристик в алфавитном порядке

            emp.setCharacteristics(characteristics);
//            System.out.println(UUID.fromString(employeeObject.getString("postId")));
            emp.setPost(postService.getPost(UUID.fromString(employeeObject.getString("postId"))));
            employeesList.add(emp);

        }

        return employeesList;
    }

}
