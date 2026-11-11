
package Lw04.Unguided;

import java.lang.*;
import java.util.*;

public class Main {

    public static void bubbleSort(int[] arr, int[] copy) {

        for (int i = 0; i < arr.length - 1; i++) {

            for (int j = 0; j < arr.length - 1 - i; j++) {

                if (arr[j] < arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }

            if (i == 1) {
                for (int j = 0; j < arr.length; j++) {
                    copy[j] = arr[j];
                }
            }
        }
    }

    public static int binarySearch(int[] arr, int target, int[] steps) {

        int low = 0;
        int high = arr.length - 1;

        steps[0] = 0;

        while (low <= high) {

            int mid = (low + high) / 2;
            steps[0]++;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(Main.class.getResourceAsStream("parcels.txt"));

        int n = sc.nextInt();

        int[] arr = new int[n];
        int[] copy = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int m = sc.nextInt();

        int[] target = new int[m];

        for (int i = 0; i < m; i++) {
            target[i] = sc.nextInt();
        }

        bubbleSort(arr, copy);

        System.out.println("==== After 2 Passes ====");

        for (int i = 0; i < n; i++) {
            System.out.print(copy[i] + " ");
        }

        System.out.println();
        System.out.println();

        
        System.out.println("==== Fully Sorted ====");

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println();
        System.out.println();

    
        System.out.println("==== Search Results ====");

        for (int i = 0; i < m; i++) {

            int[] steps = new int[1];

            int ans = binarySearch(arr, target[i], steps);

            if (ans != -1) {
                System.out.println(target[i] + ": FOUND at index "
                        + ans + " (steps: " + steps[0] + ")");
            } else {
                System.out.println(target[i] + ": NOT FOUND (steps: "
                        + steps[0] + ")");
            }
        }

        sc.close();
    }
}
