package service.employeeService;

import lombok.Builder;
import lombok.Data;
import model.Post;
import java.util.ArrayList;
import java.util.UUID;

@Data
@Builder
public class EmployeeArgument {
    UUID id;
    String firstName;
    String lastName;
    String description;
    ArrayList<String> characteristics;
    Post post;
}
