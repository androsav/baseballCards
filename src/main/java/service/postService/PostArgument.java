package service.postService;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Builder
@Data
public class PostArgument {
    UUID uuid;
    String name;
}
