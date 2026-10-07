package Lw03.Unguided;

import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        // baca dari file registration.txt
        Scanner registrationScanner = new Scanner(
                Main.class.getResourceAsStream("registrations.txt")
        );

        Set<String> registered = new HashSet<>();

        while (registrationScanner.hasNext()){
            String id = registrationScanner.next();
            registered.add(id);
            
        }

        // baca dari file checkins.txt
        Scanner checkinScanner = new Scanner(
                Main.class.getResourceAsStream("checkins.txt")
        );

        Set<String> checkedIn = new HashSet<>();
        List<String> results = new LinkedList<>();

        int rejected = 0;
        
        while (checkinScanner.hasNext()){
            String id = checkinScanner.next();

            if (!registered.contains(id)){
                results.add(id + ": Rejected (not registered) ");
                rejected++;

            }else if (checkedIn.contains(id)){
                results.add(id + ": Rejected (already checked in)");
                rejected++;
            } else {
                checkedIn.add(id);
                results.add(id + ": Checked in");
            }
        }
        int absent = registered.size() - checkedIn.size();

        System.out.println("===== Event Check-In Results =====");

        for (String result : results){
            System.out.println(result);
        }

        System.out.println("");
        System.out.println("===== Final Event Summary =====");
        System.out.println("Registered students:" + registered.size());
        System.out.println("Successful check-ins:" + checkedIn.size());
        System.out.println("Absent students:" + absent);
        System.out.println("Rejected attempts:" + rejected);

    }
}
    