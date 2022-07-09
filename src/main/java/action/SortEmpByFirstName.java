package action;
import java.util.Comparator;
import model.Employee;

public class SortEmpByFirstName implements Comparator<Employee> {

    @Override
    public int compare(Employee o1, Employee o2) {
        if ( o1.getFirstName().charAt(0) < o2.getFirstName().charAt(0) ) return -1;
        else if ( o1.getFirstName().charAt(0) == o2.getFirstName().charAt(0)  ) return 0;
        else return 1;
    }
}
