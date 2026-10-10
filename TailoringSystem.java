package tailoringshop;

import java.util.Scanner;

public class TailoringSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        JobManager manager = new JobManager();

        System.out.println("Tailoring Shop System - VU-BIT-2511-0229-DAY");

        boolean running = true;
        while (running) {
            System.out.println("\nMenu:");
            System.out.println("1. Add RepairJob");
            System.out.println("2. Add NewGarmentJob");
            System.out.println("3. List Report");
            System.out.println("4. Find Job by ID");
            System.out.println("5. Remove Job");
            System.out.println("6. Show Summary");
            System.out.println("7. Exit");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    try {
                        System.out.print("Enter Job ID: ");
                        String id = sc.nextLine();
                        System.out.print("Enter Customer Name: ");
                        String name = sc.nextLine();
                        System.out.print("Is Loyal Customer? (true/false): ");
                        boolean loyal = sc.nextBoolean();
                        System.out.print("Enter number of items: ");
                        int items = sc.nextInt();
                        sc.nextLine();

                        RepairJob rj = new RepairJob(id, name, loyal, items);
                        manager.addJob(rj);
                        System.out.println("RepairJob added: " + rj);
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 2:
                    try {
                        System.out.print("Enter Job ID: ");
                        String id = sc.nextLine();
                        System.out.print("Enter Customer Name: ");
                        String name = sc.nextLine();
                        System.out.print("Is Loyal Customer? (true/false): ");
                        boolean loyal = sc.nextBoolean();
                        System.out.print("Enter fabric cost: ");
                        double fabricCost = sc.nextDouble();
                        sc.nextLine();

                        NewGarmentJob ngj = new NewGarmentJob(id, name, loyal, fabricCost);
                        manager.addJob(ngj);
                        System.out.println("NewGarmentJob added: " + ngj);
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 3:
                    manager.printReport();
                    break;

                case 4:
                    System.out.print("Enter Job ID to find: ");
                    String searchId = sc.nextLine();
                    Job found = manager.findJobById(searchId);
                    if (found != null) {
                        System.out.println("Found: " + found);
                    } else {
                        System.out.println("Job not found.");
                    }
                    break;

                case 5:
                    System.out.print("Enter Job ID to remove: ");
                    String removeId = sc.nextLine();
                    boolean removed = manager.removeJob(removeId);
                    if (removed) {
                        System.out.println("Job removed successfully.");
                    } else {
                        System.out.println("Job not found.");
                    }
                    break;

                case 6:
                    System.out.println("Total charges = " + manager.getTotalCharges());
                    break;

                case 7:
                    running = false;
                    System.out.println("Exiting system...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        }
        sc.close();
    }
}
