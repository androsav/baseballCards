package service.employeeService;
import lombok.Builder;
import lombok.Data;
import java.util.UUID;

@Data
@Builder
public class SearchParams {
    String firstName;
    String lastName;
    UUID postID;
}
