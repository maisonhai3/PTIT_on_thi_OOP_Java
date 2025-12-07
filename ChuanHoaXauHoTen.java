import java.util.*;

public class ChuanHoaXauHoTen {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int nTest = sc.nextInt();
        sc.nextLine();

        ArrayList<String> results = new ArrayList<>();

        for (int i = 0; i < nTest; i++) {
            String name = sc.nextLine();

            name = name.trim().toLowerCase();

            String[] words = name.split("\\s+");

            StringBuilder formattedName = new StringBuilder();
            for (String word : words) {
                if (!word.isEmpty()) {
                    formattedName.append(Character.toUpperCase(word.charAt(0)))
                                 .append(word.substring(1))
                                 .append(" ");
                }
            }

            results.add(formattedName.toString().trim());
        }

        for (String name : results){
            System.out.println(name);
        }
    }
}
