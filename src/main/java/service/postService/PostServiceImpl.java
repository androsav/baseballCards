package service.postService;
import lombok.NonNull;
import model.Post;
import service.parseService.JsonArrayToPostList;
import service.parseService.JsonFileToJsonArray;

import java.util.*;

public class PostServiceImpl implements  PostService{

    private static ArrayList<Post> postList = new ArrayList<Post>();

    public PostServiceImpl(){
        JsonArrayToPostList.ParseToPostList(Objects.requireNonNull(JsonFileToJsonArray.ParseToJsonArray("src/test/resources/Posts.json", "posts"))).forEach(this::addPost);
    }

    @Override
    public void addPost(@NonNull Post post) {postList.add(post);}

    @Override
    public Post createPost(@NonNull PostArgument createArgument) {
        return Post.builder()
                .uuid(createArgument.getUuid())
                .name(createArgument.getName())
                .build();
    }

    @Override
    public void updatePost(@NonNull PostArgument updateArgument) {
        for(Post post : postList){
            if((post.getUuid().equals(updateArgument.getUuid()))){
                postList.set(getAllPosts().indexOf(post), createPost(updateArgument));
                break;
            }
        }
    }

    @Override
    public void deletePost(@NonNull UUID id) {
        for(Post post : postList){
            if((post.getUuid().equals(id))){
                postList.remove(post);
                break;
            }
        }
    }

    @Override
    public Post getPost(@NonNull UUID uuid) {
        Post finded = new Post();
        for(Post post : postList){
            if(post.getUuid().equals(uuid) ){
                finded = post;
                break;
            }
        }
        return finded;
    }

    @Override
    public ArrayList<Post> getAllPosts() {
        return postList;
    }

}
