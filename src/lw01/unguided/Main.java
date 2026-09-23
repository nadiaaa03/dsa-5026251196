import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {

        Scanner scanner = new Scanner(new File("washes.txt"));

        int totalRecords = scanner.nextInt();

        WashService[] services = new WashService[totalRecords];

        for (int i = 0; i < totalRecords; i++) {

            String type = scanner.next();
            String id = scanner.next();
            int days = scanner.nextInt();
            int units = scanner.nextInt();

            if (type.equals("MOTORCYCLE")) {
                services[i] = new MotorcycleWash(id, days);
            } else if (type.equals("CAR")) {
                services[i] = new CarWash(id, days);
            }

            services[i].calculateCharge(units);
        }

        scanner.close();

        for (WashService service : services) {
            System.out.println(service.summary());
        }
    }
}
