import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        Scanner scanner = new Scanner(new File("washes.txt"));

        int totalRecords = scanner.nextInt();

        WashService[] rentals = new WashService[totalRecords];

        for (int i = 0; i < totalRecords; i++) {

            String type = scanner.next();
            String id = scanner.next();
            int days = scanner.nextInt();
            int units = scanner.nextInt();

            if (type.equals("MOTORCYCLE")) {
                rentals[i] = new MotorcycleWash(id, days);
            } else if (type.equals("CAR")) {
                rentals[i] = new CarWash(id, days);
            }

            rentals[i].calculateCharge(units);
        }

        scanner.close();

        for (WashService rental : rentals) {
            System.out.println(rental.summary());
        }
    }
}
