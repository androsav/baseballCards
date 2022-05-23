import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonWriter;
import org.json.JSONException;
import java.io.*;
import java.util.ArrayList;
import java.util.Collection;

public class DataController {

     static ArrayList<Employee> parseCards() {
         ArrayList<Employee> employeeCards  = new ArrayList<>();
         Gson gson = new GsonBuilder().setPrettyPrinting().create();

         try (Reader reader = new FileReader("src/test/resources/Employee.json")){
             BufferedReader br = new BufferedReader(reader);
             employeeCards = gson.fromJson(br, new TypeToken<ArrayList<Employee>>(){}.getType());
             //BufferedReader br = new BufferedReader(new FileReader("src/test/resources/data.json"));
             //JsonParser parser = new JsonParser();
             //JsonArray arrtay = parser.parse(br).getAsJsonArray();

         /*JsonWriter writer = new JsonWriter(new FileWriter("C:\\file.json"));
         writer.beginObject();
         writer.name("data");
         writer.beginArray();
         writer.beginObject();
         writer.name("id").value(t.getId());
         writer.name("name").value(t.getNom());
         writer.endObject();
         writer.endArray();
         writer.endObject();
         writer.close();*/

         } catch (JSONException e) {
             e.printStackTrace();
         } catch (FileNotFoundException e) {
             e.printStackTrace();
         } catch (IOException e) {
             e.printStackTrace();
         }
         return employeeCards;
    }

    static void printCards(ArrayList<Employee> empCards){
        empCards.forEach(Employee::printCard);
    }
}
