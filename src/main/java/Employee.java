import java.util.ArrayList;

public class Employee {

    String firstName;
    String lastName;
    String description = " ";
    ArrayList<String> characteristics;
    Post post;

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

    public Post getPost() {
        return post;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
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

    public void setPost(Post post) {
        this.post = post;
    }

    public void printCard(){
        System.out.println("firstName: " +getFirstName());
        System.out.println("lastName: " + getLastName());
        System.out.println("description: "+getDescription());
        System.out.print("characteristics: ");
        getCharacteristics().forEach(str -> System.out.print(str+ ", ")); System.out.println();
        System.out.println("post: "+ getPost().getName());
        System.out.println();
    }
}
