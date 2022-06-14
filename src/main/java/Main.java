import java.util.List;
import java.util.UUID;

public class Main {
    static PostMap postMap = new PostMap();
    public static void main(String[] args) {
        List<Employee> employeesList = DataController.parseCards("src/test/resources/Employees.json");
        DataController.ascSortCards(employeesList,"lastName");
        DataController.printCards(employeesList);


    }
}
