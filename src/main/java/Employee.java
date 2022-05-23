import java.util.ArrayList;
import java.util.Set;

public class Employee {
    public static String firstName;
    static String lastName;
    static String description;
    static ArrayList<String> characteristics;
    static String postId;


    Employee(String firstName, String lastName,String description,ArrayList<String> characteristics,String postId){
        this.firstName = firstName;
        this.lastName = lastName;
        this.description = description;
        this.characteristics = characteristics;
        this.postId = postId;
    }

    public void printCard(){
        System.out.println(firstName);
        System.out.println(lastName);
        System.out.println(description);
        characteristics.forEach(str -> System.out.println(str));
        System.out.println(postId);

    }
}
