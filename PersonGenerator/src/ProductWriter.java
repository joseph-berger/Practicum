import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ProductWriter {
    public static void main(String[] args) {
        ArrayList<String> productsData = new ArrayList<>();

        System.out.println("Enter data for each product. Type 'exit' to finish.");

        while (true) {
            String productData = getProductData(new Scanner(System.in));

            if (productData.equalsIgnoreCase("exit")) {
                break;
            }

            productsData.add(productData);
        }

        System.out.println("Enter a file name to save the product data:");
        String fileName = SafeInput.getNonZeroLenString(new Scanner(System.in), "Please enter a valid file name.");

        saveToFile(fileName, productsData);

        System.out.println("Product data saved to file: " + fileName);
    }

    private static String getProductData(Scanner scanner) {
        System.out.print("Enter product data (ID, Name, Description, Cost): ");
        return SafeInput.getNonZeroLenString(scanner, "Data Recorded");
    }

    private static void saveToFile(String fileName, ArrayList<String> data) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (String productData : data) {
                writer.write(productData);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error while saving to file: " + e.getMessage());
        }
    }
}
