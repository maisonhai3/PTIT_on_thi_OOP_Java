import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class DocFileTinhTong {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<Integer> allInt = new ArrayList<>();

        File file = new File("DATA.in");
        Scanner sc = new Scanner(file);

        while (sc.hasNextLine()){
            String line = sc.nextLine();
//            System.out.println(line);

            Scanner lineSc = new Scanner(line);
            while (lineSc.hasNext()){
                if (lineSc.hasNextInt()){
                    int intNumber = lineSc.nextInt();
//                    System.out.println(intNumber);
                    allInt.add(intNumber);
                }
                else {
                    lineSc.next();
                }
            }
            lineSc.close();

        }
        sc.close();

        long sum = 0;
        for (Integer i : allInt){
            sum += i;
        }

        System.out.print(sum);
    }
}
