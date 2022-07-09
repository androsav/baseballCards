package service.employeeService;
import lombok.NonNull;
import model.Employee;

import java.util.*;

public interface EmployeeService {

    void addEmployee(@NonNull Employee employee);

    Employee createEmployee(@NonNull EmployeeArgument employeeArgument);

    void updateEmployee(@NonNull EmployeeArgument employeeArgument);

    void deleteEmployee(@NonNull UUID id) ;

    Employee getEmployee(@NonNull UUID id);

    List<Employee> getEmployees (@NonNull SearchParams params) ;

    List<Employee> getAllEmployees();

    void sortEmployees(String fieldName);
}