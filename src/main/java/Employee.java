import java.util.ArrayList;
import java.util.Set;

public class Employee {

    public static String firstName;
    static String lastName;
    static String description;
    static ArrayList<String> characteristics;
    static String postId;

    public static void setFirstName(String firstName) {
        Employee.firstName = firstName;
    }

    public static void setLastName(String lastName) {
        Employee.lastName = lastName;
    }

    public static void setDescription(String description) {
        Employee.description = description;
    }

    public static void setCharacteristics(ArrayList<String> characteristics) {
        Employee.characteristics = characteristics;
    }

    public static void setPostId(String postId) {
        Employee.postId = postId;
    }

    public static String getFirstName() {
        return firstName;
    }

    public static String getLastName() {
        return lastName;
    }

    public static String getDescription() {
        return description;
    }

    public static ArrayList<String> getCharacteristics() {
        return characteristics;
    }

    public static String getPostId() {
        return postId;
    }

    public void printCard(){
        System.out.println(firstName);
        System.out.println(lastName);
        System.out.println(description);
        characteristics.forEach(str -> System.out.println(str));
        System.out.println(postId);

    }
}
