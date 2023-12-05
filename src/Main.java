import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("data\\list.txt");
        Scanner scanner = new Scanner(file);
        IdentifyNumbers identifyNumbers = new IdentifyNumbers();
        String results;
        ArrayList<Integer> numberList = new ArrayList<>();

        while (scanner.hasNextLine()) {

            String text = scanner.nextLine();
            results = identifyNumbers.extractAll(text);
            numberList.add(Integer.valueOf(results));
            System.out.println(results);

        }
        scanner.close();
        int sum = numberList.stream().mapToInt(Integer::intValue).sum();

        System.out.println(sum);
    }
}