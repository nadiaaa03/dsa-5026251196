package lw02.prelab;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        LinkedList<String[]> transactions = new LinkedList<>();
        LinkedList<String[]> customers = new LinkedList<>();

        Scanner scanner = new Scanner(new File("transactions.txt"));

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] transaction = line.split(" ");

            transactions.add(transaction);

            String name = transaction[0];
            boolean found = false;

            for (int i = 0; i < customers.size(); i++) {
                if (customers.get(i)[0].equals(name)) {
                    found = true;
                    break;
                }
            }

            if (!found) {
                String[] customer = {name, "0"};
                customers.add(customer);
            }
        }

        scanner.close();

        Queue<String[]> queue = new LinkedList<>();

        while (!transactions.isEmpty()) {
            queue.add(transactions.removeFirst());
        }

        Stack<String[]> failedTransactions = new Stack<>();

        while (!queue.isEmpty()) {
            String[] transaction = queue.poll();

            String name = transaction[0];
            String type = transaction[1];
            int amount = Integer.parseInt(transaction[2]);

            for (int i = 0; i < customers.size(); i++) {
                String[] customer = customers.get(i);

                if (customer[0].equals(name)) {

                    int balance = Integer.parseInt(customer[1]);

                    if (type.equals("DEPOSIT")) {
                        balance = balance + amount;
                    } else if (type.equals("WITHDRAW")) {
                        if (amount > balance) {
                            failedTransactions.push(transaction);
                        } else {
                            balance = balance - amount;
                        }
                    }

                    customer[1] = String.valueOf(balance);

                    break;
                }
            }
        }

        System.out.println("=== Final Balances ===");

        for (int i = 0; i < customers.size(); i++) {
            String[] customer = customers.get(i);
            System.out.println(customer[0] + " : " + customer[1]);
        }

        System.out.println("=== Failed Transactions ===");

        while (!failedTransactions.isEmpty()) {
            String[] transaction = failedTransactions.pop();

            System.out.println(
                transaction[0] + " "
                + transaction[1] + " "
                + transaction[2]
            );
        }
    }
}