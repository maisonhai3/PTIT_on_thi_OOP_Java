import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class DistinctNumber {
    public static void main(String[] args) {
        // Use TreeMap to store frequencies, which keeps the keys (numbers) in sorted order.
        Map<Integer, Integer> frequency = new TreeMap<>();

        try (Scanner sc = new Scanner(new File("DATA.in"))) {
            while (sc.hasNextInt()) {
                int number = sc.nextInt();
                frequency.put(number, frequency.getOrDefault(number, 0) + 1);
            }
        } catch (FileNotFoundException e) {
            System.err.println("Error: Input file 'DATA.in' not found.");
            e.printStackTrace();
        }

        // Print the frequencies of each number
        for (Map.Entry<Integer, Integer> entry : frequency.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
