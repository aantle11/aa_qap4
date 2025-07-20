import java.io.*;
import java.util.*;

public class DrugManager {
    private static final String FILE_NAME = "drugs.txt";

    public static void saveDrugsToFile(List<Drug> drugs) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Drug drug : drugs) {
                writer.write(drug.toString());
                writer.newLine();
            }
        } 
    }

    public static List<Drug> readDrugsFromFile() throws IOException {
        List<Drug> drugs = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                drugs.add(Drug.fromString(line));
            }
        }

        return drugs;
    }
}
