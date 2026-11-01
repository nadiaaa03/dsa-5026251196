package lw04.prelab;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(Main.class.getResourceAsStream("branches.txt"));
        int n = sc.nextInt();
        int[] branches = new int[n];
        for (int i = 0; i < n; i++) {
            branches[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        int[] targets = new int[m];
        for (int i = 0; i < m; i++) {
            targets[i] = sc.nextInt();
        }
        sc.close();

        // Insertion Sort - Descending Order
        for (int i = 1; i <= 3; i++) {
            int key = branches[i];
            int j = i - 1;
            while (j >= 0 && branches[j] < key) {
                branches[j + 1] = branches[j];
                j--;
            }

            branches[j + 1] = key;
        }
        // Display branches after 3 passes
        for (int i = 0; i < n; i++) {
            System.out.print(branches[i]);
            if (i < n - 1) {
                System.out.print(" ");
            }
        }

        System.out.println();
        // Linear Search
        for (int i = 0; i < m; i++) {
            int index = -1;
            for (int j = 0; j < n; j++) {
                if (branches[j] == targets[i]) {
                    index = j;
                    break;
                }
            }
            if (index != -1) {
                System.out.println(
                    targets[i] + ": FOUND at index " + index
                );
            } else {
                System.out.println(
                    targets[i] + ": NOT FOUND"
                );
            }
        }
    }
}
