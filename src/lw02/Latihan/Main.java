package lw02.Latihan;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        LinkedList<String[]> orders = new LinkedList<>();
        LinkedList<String[]> side_dishes = new LinkedList<>();
        LinkedList<String[]> drinks = new LinkedList<>();
        LinkedList<String[]> successfully  = new LinkedList<>();
        LinkedList<String[]> table  = new LinkedList<>();
        LinkedList<String[]> customers  = new LinkedList<>();


        Queue<String[]> queue = new LinkedList<>();
        Stack<String[]> failed = new Stack<>();

        Scanner scanner = new Scanner(
            Main.class.getResourceAsStream("orders.txt")
        );

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();

            Scanner lineScanner = new Scanner(line);

            String name = lineScanner.next();
            String side_dish = lineScanner.next();
            String drink = lineScanner.next();
            String table = lineScanner.next();


            String[] order = {name, side_dish, drink, table};
            orders.add(order);

            boolean foodAvailable = checkStock(side_dishes, side_dish);
            boolean drinkAvailable = checkStock(drinks, drink);

            if ((side_dish.equals("-") || side_dishAvailable) && (drink.equals("-") || drinkAvailable)) {
                if (!side_dish.equals("-")) reduceStock(side_dishes, side_dish);
                if (!drink.equals("-")) reduceStock(drinks, drink);
                successfully.add(order);
            } else {
                failed.push(order);
            }

            lineScanner.close();
        }

        scanner.close();

        String[] bakso = {"Bakso", "2"};
        String[] sate = {"Sate", "1"};
        String[] soto = {"Soto", "2"};

        side_dishes.add(bakso);
        side_dishes.add(sate);
        side_dishes.add(soto);

        String[] esteh = {"EsTeh", "4"};
        String[] esjeruk = {"EsJeruk", "2"};

        drinks.add(esteh);
        drinks.add(esjeruk);

        while (!orders.isEmpty()) {
            queue.add(orders.remove());
        }

        while (!queue.isEmpty()) {
            String[] order = queue.poll();

            String name = order[0];
            String side_dish = order[1];
            String drink = order[2];
            String table = order[3];

            String[] selectedSide_Dish = null;
            String[] selectedDrink = null;
            String[] selectedCustomer = null;

            for (int i = 0; i < side_dishes.size(); i++) {
                String[] dish = side_dishes.get(i);

                if (dish[0].equals(side_dish)) {
                    selectedSide_Dish = dish;
                    break;
                }
            }

            for (int i = 0; i < drinks.size(); i++) {
                String[] drinkItem = drinks.get(i);

                if (drinkItem[0].equals(drink)) {
                    selectedDrink = drinkItem;
                    break;
                }
            }

            for (int i = 0; i < customers.size(); i++) {
                String[] cust = customers.get(i);

                if (cust[0].equals(name)) {
                    selectedCustomer = cust;
                    break;
                }
            }
                    selectedSide_Dish = dish;
                    selectedDrink = drinkItem;
                    break;
                }
            }

            for (int i = 0; i < customers.size(); i++) {
                String[] cust = customers.get(i);

                if (cust[0].equals(name)) {
                    selectedCustomer = cust;
                    break;
                }
            }

            int stock = Integer.parseInt(selectedBook[1]);
            int borrowed = Integer.parseInt(selectedMember[1]);

            if ((side_dish.equals("-") || side_dishAvailable) && (drink.equals("-") || drinkAvailable)) {
                if (!side_dish.equals("-")) reduceStock(side_dishes, side_dish);
                if (!drink.equals("-")) reduceStock(drinks, drink);
                successfully.add(order);
            } else {
                failed.push(order);
            }

            System.out.println("=== Successfully Processed Orders ===");
            
            for (int i = 0; i < successful.size(); i++) {
                String[] order = successful.get(i);
                System.out.println(order[0] + " " + order[1]);
            }

        System.out.println("=== Remaining Foods Stock ===");

        for (int i = 0; i < side_dishes.size(); i++) {
            String[] dish = side_dishes.get(i);

            System.out.println(dish[0] + " : " + dish[1]);
        }

        System.out.println("=== Remaining Drinks Stock ===");

        for (int i = 0; i < drinks.size(); i++) {
            String[] drinkItem = drinks.get(i);

            System.out.println(drinkItem[0] + " : " + drinkItem[1]);
        }

        System.out.println("=== Failed Orders ===");

        while (!failed.isEmpty()) {
            String[] order = failed.pop();

            System.out.println(order[0] + " " + order[1]);
        }
    }
}


