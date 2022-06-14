import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class PostMap {
    private Map<UUID, Post> posts = new HashMap<>();

    public Post getPostFromUUID(UUID uuid) {
        return posts.get(uuid);
    }

    public void setPosts(Map<UUID, Post> posts) {
        this.posts = posts;
    }

    public PostMap(){
        posts.put(UUID.fromString("854ef89d-6c27-4635-926d-894d76a81707"), new Post(UUID.fromString("854ef89d-6c27-4635-926d-894d76a81707"), "middle developer"));
        posts.put(UUID.fromString("a3dec21f-1187-4b05-896b-96b580b453a5"), new Post(UUID.fromString("a3dec21f-1187-4b05-896b-96b580b453a5"), "student"));
    }
}
