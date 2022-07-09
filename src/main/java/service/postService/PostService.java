package service.postService;
import lombok.NonNull;
import model.Post;

import java.util.List;
import java.util.UUID;

public interface PostService {

    void addPost(@NonNull Post post);

    Post createPost(@NonNull PostArgument postArgument);

    void updatePost(@NonNull PostArgument postArgument);

    void deletePost(@NonNull UUID id) ;

    Post getPost(@NonNull UUID uuid);

    List<Post> getAllPosts();
}
