import java.util.ArrayList;
import java.util.Set;

public class Employee {

    String firstName;
    String lastName;
    String description;
    ArrayList<String> characteristics;
    String postId;

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDescription() {
        return description;
    }

    public ArrayList<String> getCharacteristics() {
        return characteristics;
    }

    public String getPostId() {
        return postId;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCharacteristics(ArrayList<String> characteristics) {
        this.characteristics = characteristics;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public void printCard(){
        System.out.println("firstName: " +getFirstName());
        System.out.println("lastName: " + getLastName());
        System.out.println("description: "+getDescription());
        System.out.println("characteristics: "+getCharacteristics());
        /*getCharacteristics().forEach(str -> System.out.println(str));*/
        System.out.println("post: "+ getPostId());

    }
}
