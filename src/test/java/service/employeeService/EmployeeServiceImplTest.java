package service.employeeService;

import junit.framework.TestCase;
import model.Employee;
import org.junit.Test;
import service.parseService.JsonArrayToEmployeeList;
import service.parseService.JsonFileToJsonArray;
import service.postService.PostServiceImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.UUID;

public class EmployeeServiceImplTest extends TestCase {
    private final EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
    private final PostServiceImpl postService = new PostServiceImpl();
    private final  Employee Gennadiy = Employee.builder()
            .id(UUID.fromString("a896b21f-896b-4635-1187-96b580b494d7"))
            .firstName("Genady")
            .lastName("Qzmin")
            .description(null)
            .characteristics(new ArrayList<>(Arrays.asList("honest", "introvert", "like criticism", "love of Learning", "pragmatism")))
            .post(postService.getPost(UUID.fromString("a3dec21f-1187-4b05-896b-96b580b453a5")))
            .build();
    private final  Employee Ivan = Employee.builder()
            .id(UUID.fromString("a3dec21f-896b-4635-1187-894d70b494d7"))
            .firstName("Ivan")
            .lastName("Ivanov")
            .description(null)
            .characteristics(new ArrayList<>(Arrays.asList("honest", "introvert", "alike criticism", "clove of Learning")))
            .post(postService.getPost(UUID.fromString("a3dec21f-1187-4b05-896b-96b580b453a5")))
            .build();
    private final  Employee Konstantin = Employee.builder()
            .id(UUID.fromString("a3dec21f-896b-4635-1187-96b580b494d7"))
            .firstName("Konstantin")
            .lastName("Yakovlev")
            .description("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Cras sit amet dictum felis, eu fringilla eros. Sed et gravida neque. Nullam at egestas,,erat. Mauris vitae convallis nulla. Aenean condimentum lectus magna.Suspendisse viverra quam non ante pellentesque, a euismod nunc dapibus. Duissed congue erat")
            .characteristics(new ArrayList<>(Arrays.asList("honest", "pragmatism", "introvert", "like criticism", "love of Learning")))
            .post(postService.getPost(UUID.fromString("854ef89d-6c27-4635-926d-894d76a81707")))
            .build();

    private final  Employee Valentin = Employee.builder()
            .id(UUID.fromString("c21ec21f-4b05-896b-1580-c21580b453a5"))
            .firstName("Valentin")
            .lastName("Moroz")
            .description(null)
            .characteristics(new ArrayList<>(Arrays.asList("honest", "introvert", "like criticism", "love of Learning", "pragmatism")))
            .post(postService.getPost(UUID.fromString("a3dec21f-1187-4b05-896b-96b580b453a5")))
            .build();
    @Test
    public void testAddEmployee() {
        //arrange
        boolean expectedIsContainsValentin = true;
        //act
        employeeService.addEmployee(Valentin);
        boolean actualIsContainsValentin = employeeService.getAllEmployees().contains(Valentin);
        //assert
        assertEquals(expectedIsContainsValentin, actualIsContainsValentin);
    }

    @Test
    public void testAddEmployeeWithoutValentin() {
        //arrange
        boolean expectedIsContainsValentin = false;
        //act
        boolean actualIsContainsValentin = employeeService.getAllEmployees().contains(Valentin);
        //assert
        assertEquals(expectedIsContainsValentin, actualIsContainsValentin);
    }

    @Test
    public void testCreateEmployee() {
        //arrange
        EmployeeArgument createEmployeeArgument =  EmployeeArgument.builder()
                .id(UUID.fromString("c21ec21f-4b05-896b-1580-c21580b453a5"))
                .firstName("Valentin")
                .lastName("Moroz")
                .description(null)
                .characteristics(new ArrayList<>(Arrays.asList("honest", "introvert", "like criticism", "love of Learning", "pragmatism")))
                .post(postService.getPost(UUID.fromString("a3dec21f-1187-4b05-896b-96b580b453a5")))
                .build();
        //act
        Employee actualEmployee = employeeService.createEmployee(createEmployeeArgument);
        //assert
        assertEquals(Valentin, actualEmployee);
    }

    @Test
    public void testUpdateEmployee() {
        //arrange
        EmployeeArgument updateEmployeeArgument =  EmployeeArgument.builder()
                .id(UUID.fromString("a896b21f-896b-4635-1187-96b580b494d7"))
                .firstName("Genady")
                .lastName("Qzmin")
                .description("likes books")
                .characteristics(new ArrayList<>(Arrays.asList("honest", "introvert", "like criticism", "love of Learning", "pragmatism")))
                .post(postService.getPost(UUID.fromString("a3dec21f-1187-4b05-896b-96b580b453a5")))
                .build();
        boolean expectedIsGenadyLikesBooks = true;
        //act
        employeeService.updateEmployee(updateEmployeeArgument);
        boolean actualIsGenadyLikesBooks = false;
        System.out.println(employeeService.getEmployee(UUID.fromString("a896b21f-896b-4635-1187-96b580b494d7")).getDescription());
        if(employeeService.getEmployee(UUID.fromString("a896b21f-896b-4635-1187-96b580b494d7")).getDescription().equals("likes books"))
            actualIsGenadyLikesBooks = true;

        //assert
        assertEquals(expectedIsGenadyLikesBooks, actualIsGenadyLikesBooks);
    }

    @Test
    public void testDeleteEmployee() {
        //arrange
        boolean expectedIsContainsGenady = false;
        //act
        employeeService.deleteEmployee(Gennadiy.getId());
        boolean actualIsContainsGenady = employeeService.getAllEmployees().contains(Gennadiy);
        //assert
        assertEquals(expectedIsContainsGenady, actualIsContainsGenady);

    }

    @Test
    public void testGetEmployees() {
        //arrange
        SearchParams searchParams = SearchParams.builder()
                .postID(UUID.fromString("a3dec21f-1187-4b05-896b-96b580b453a5"))
                .firstName(null)
                .lastName(null)
                .build();
        boolean expected = true;
        boolean actual = false;
        //act
        ArrayList<Employee> actualList = employeeService.getEmployees(searchParams);
        for (Employee employee : actualList) {
            if (employee.getPost().getUuid().equals(UUID.fromString("a3dec21f-1187-4b05-896b-96b580b453a5")))
                actual = true;
            else
                actual = false;
        }
        //assert
        assertEquals(expected, actual);
    }

    @Test
    public void testGetAllEmployees() {
        //arrange
        ArrayList<Employee> expected = JsonArrayToEmployeeList.ParseToEmployeeList(
                Objects.requireNonNull(JsonFileToJsonArray.ParseToJsonArray("src/test/resources/Employees.json", "employees")));
        //act
        ArrayList<Employee> actual = employeeService.getAllEmployees();
        //assert
        assertEquals(expected, actual);
    }

}