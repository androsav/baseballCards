package model;
import lombok.*;
import java.util.ArrayList;
import java.util.UUID;

@Data
@Builder
@NonNull
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    UUID id;
    String firstName;
    String lastName;
    String description;
    ArrayList<String> characteristics;
    Post post;
}
