import java.util.*;

public class MainApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Save drug data to file");
            System.out.println("2. Read drug data from file");
            System.out.println("3. Save patient data to SQL");
            System.out.println("4. Read patient data from SQL");
            System.out.println("5. Exit ");

            int choice = scanner.nextInt();

            try {
                switch (choice) {
                    case 1 -> {
                        List<Drug> drugs = Arrays.asList(
                            new Drug(1, "Advil", 12.99, "200mg"),
                            new Drug(2, "Tylenol", 9.99, "500mg")
                        );
                        DrugManager.saveDrugsToFile(drugs);
                        System.out.println("Drugs saved to file");
                    }

                    case 2 -> {
                        List<Drug> drugs = DrugManager.readDrugsFromFile();
                        drugs.forEach(System.out::println);
                    }

                    case 3 -> {
                        List<Patient> patients = Arrays.asList(
                            new Patient(101, "Nala", "Antle", "2014-03-12"),
                            new Patient(102, "Simba", "Meow", "2017-10-12")
                        );
                        PatientManager.insertPatients(patients);
                        System.out.println("Patients inserted into Database");
                    }

                    case 4 -> {
                        
                    }
                }
            }
        }
    }
}
