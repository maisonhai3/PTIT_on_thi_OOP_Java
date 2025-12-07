import java.util.*;

public class SapXepDaySo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int nTest = scanner.nextInt();

        while (nTest-- > 0) {
            int lengthA = scanner.nextInt();

            int[] A = new int[lengthA];

            for (int i = 0; i < lengthA; i++) {
                A[i] = scanner.nextInt();
            }

            Arrays.sort(A);

            for (int i = 0; i < lengthA; i++) {
                System.out.print(A[i]);
                if (i < lengthA - 1) System.out.print(" ");
            }
            System.out.println();
        }

        scanner.close();
    }
}