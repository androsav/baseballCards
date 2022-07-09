package service.employeeService;

import action.SortEmpByFirstName;
import action.SortEmpByLastName;
import lombok.NonNull;
import model.Employee;
import model.Post;
import service.parseService.JsonArrayToEmployeeList;
import service.parseService.JsonFileToJsonArray;

import java.util.*;
import java.util.stream.Collectors;

public class EmployeeServiceImpl implements  EmployeeService{

    private ArrayList<Employee> employeesList = new ArrayList<Employee>();

    public EmployeeServiceImpl(){
        JsonArrayToEmployeeList.ParseToEmployeeList(Objects.requireNonNull(JsonFileToJsonArray.ParseToJsonArray("src/test/resources/Employees.json", "employees"))).forEach(emp -> addEmployee(emp));
    }

    @Override
    public void addEmployee(@NonNull Employee employee) {employeesList.add(employee);}

    @Override
    public Employee createEmployee(@NonNull EmployeeArgument createArgument) {
        return Employee.builder()
                .id(createArgument.getId())
                .firstName(createArgument.getFirstName())
                .lastName(createArgument.getLastName())
                .characteristics(createArgument.getCharacteristics())
                .description(createArgument.getDescription())
                .post(createArgument.getPost())
                .build();
    }

    @Override
    public void updateEmployee(@NonNull EmployeeArgument updateArgument) {
        for(Employee emp : employeesList){
            if(emp.getId().equals(updateArgument.getId())){
                employeesList.set(getAllEmployees().indexOf(emp), createEmployee(updateArgument));
                break;
            }
        }
    }

    @Override
    public void deleteEmployee(@NonNull UUID id) {
        for(Employee emp : employeesList){
            if((emp.getId() == id)){
                employeesList.remove(emp);
                break;
            }
        }
    }

    @Override
    public ArrayList<Employee> getEmployees(@NonNull SearchParams params) {

        ArrayList<Employee> findedList = (ArrayList<Employee>) employeesList
                .stream()
                .filter(emp -> ((emp.getFirstName().equals(params.getFirstName()))||
                        (emp.getLastName().equals(params.getLastName()))||
                        (emp.getPost().getUuid().equals(params.getPostID()))))
                .collect(Collectors.toList());

        return findedList;
    }

    @Override
    public Employee getEmployee(UUID id){

        Employee finded = new Employee();
        for(Employee emp : employeesList){
            if(emp.getId().equals(id) ){
                finded = emp;
                break;
            }
        }
        return finded;
    }

    @Override
    public ArrayList<Employee> getAllEmployees() {return employeesList;}

    @Override
    public void sortEmployees(String fieldName) {
            if (fieldName == "firstName")
                employeesList.sort(new SortEmpByFirstName());
            else if (fieldName == "lastName")
                employeesList.sort(new SortEmpByLastName());

    }
}
