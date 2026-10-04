package lw03.prelab;

import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // PROBLEM 1
        Scanner sc1 = new Scanner(Main.class.getResourceAsStream("playlist.txt"));

        List<String> playlist = new ArrayList<>();
        while (sc1.hasNext()) {

            String operation = sc1.next();

            if (operation.equals("ADD")) {

                String song = sc1.next();

                playlist.add(song);

            }
            else if (operation.equals("INSERT")) {

                int index = sc1.nextInt();
                String song = sc1.next();

                playlist.add(index, song);

            }
            else if (operation.equals("REMOVE")) {

                String song = sc1.next();

                playlist.remove(song);
            }
        }


        System.out.println("===== Problem 1 =====");
        System.out.println("Total songs: " + playlist.size());

        for (int i = 0; i < playlist.size(); i++) {
            System.out.println((i + 1) + ": " + playlist.get(i));
        }

        // PROBLEM 2

        Scanner sc2 = new Scanner(Main.class.getResourceAsStream("participants.txt"));
        Set<String> participants = new LinkedHashSet<>();

        int duplicate = 0;

        while (sc2.hasNext()) {

            String name = sc2.next();

            if (participants.contains(name)) {

                duplicate++;

            }
            else {

                participants.add(name);

            }
        }


        System.out.println("===== Problem 2 =====");
        System.out.println("Unique participants: " + participants.size());

        int number = 1;

        for (String name : participants) {

            System.out.println(number + ". " + name);

            number++;
        }

        System.out.println("Duplicate registrations: " + duplicate);

        // PROBLEM 3

        Scanner sc3 = new Scanner(Main.class.getResourceAsStream("inventory.txt"));

        Map<String, Integer> inventory = new LinkedHashMap<>();

        int failedSales = 0;

        while (sc3.hasNext()) {

            String type = sc3.next();
            String product = sc3.next();
            int quantity = sc3.nextInt();


            // ADD
            if (type.equals("ADD")) {

                if (inventory.containsKey(product)) {

                    int stock = inventory.get(product);

                    stock = stock + quantity;

                    inventory.put(product, stock);

                }
                else {

                    inventory.put(product, quantity);

                }
            }


            // SELL
            else if (type.equals("SELL")) {

                if (inventory.containsKey(product)) {

                    int stock = inventory.get(product);

                    if (stock >= quantity) {

                        stock = stock - quantity;

                        inventory.put(product, stock);

                    }
                    else {

                        failedSales++;

                    }

                }
                else {

                    failedSales++;

                }
            }
        }


        System.out.println("===== Problem 3 =====");

        for (String product : inventory.keySet()) {

            System.out.println(product + ": " + inventory.get(product));

        }

        System.out.println("Failed sales: " + failedSales);
    }
}