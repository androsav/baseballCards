package service.printService;

import model.Employee;

import java.util.ArrayList;

public class printCardsToConsole implements printCards {

    private String employeeToString(Employee emp) {

        return "firstName: " + emp.getFirstName()
                + "\nlastName: " + emp.getLastName()
                + "\ndescription: " + emp.getDescription()
                + "\ncharacteristics: " + emp.getCharacteristics().toString().replaceAll("^\\[|]$", "")
                + "\npost: " + emp.getPost().getName() + "\n";
    }

    @Override
    public void print(ArrayList<Employee> empCards) {
        System.out.println("Employee cards:");
        empCards.forEach(emp -> System.out.println(employeeToString(emp)));
    }
}
