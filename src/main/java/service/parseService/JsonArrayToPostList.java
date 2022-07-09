package service.parseService;
import model.Post;
import org.json.JSONArray;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.UUID;

public class JsonArrayToPostList {

    public static ArrayList<Post> ParseToPostList(JSONArray posts){
        ArrayList<Post> postList = new ArrayList<Post>();

        for (Object post : posts) {
            JSONObject postObject = (JSONObject) post;
            Post pos = new Post();

            pos.setUuid(UUID.fromString(postObject.getString("uuid")));
            pos.setName(postObject.getString("name"));

            postList.add(pos);
        }
        return postList;
    }
}
