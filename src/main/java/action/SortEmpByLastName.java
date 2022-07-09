package action;
import model.Employee;
import java.util.Comparator;

public class SortEmpByLastName implements Comparator<Employee> {

    @Override
    public int compare(Employee o1, Employee o2) {
        int comparedResult = o1.getLastName().compareTo(o2.getLastName());
        return comparedResult;
    }
}
