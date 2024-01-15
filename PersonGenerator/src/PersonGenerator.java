import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class PersonGenerator {
    public static void main(String[] args) {
        ArrayList<String> personsData = new ArrayList<>();

        System.out.println("Enter data for each person. Type 'exit' to finish.");

        while (true) {
            String personData = getPersonData(new Scanner(System.in));

            if (personData.equalsIgnoreCase("exit")) {
                break;
            }

            personsData.add(personData);
        }

        System.out.println("Enter a file name to save the data:");
        String fileName = SafeInput.getNonZeroLenString(new Scanner(System.in), "Please enter a valid file name.");

        saveToFile(fileName, personsData);

        System.out.println("Data saved to file: " + fileName);
    }

    private static String getPersonData(Scanner scanner) {
        System.out.print("Enter person data (ID, FirstName, LastName, Title, YearOfBirth): ");
        return SafeInput.getNonZeroLenString(scanner, "Data Recorded");
    }

    private static void saveToFile(String fileName, ArrayList<String> data) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (String personData : data) {
                writer.write(personData);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error while saving to file: " + e.getMessage());
        }
    }
}
