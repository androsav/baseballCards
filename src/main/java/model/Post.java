package model;
import lombok.*;
import java.util.UUID;

@Data
@Builder
@NonNull
@NoArgsConstructor
@AllArgsConstructor
public class Post {
    UUID uuid;
    String name;

}
