package com.pluralsight;

import java.util.Scanner;

public class VehicleInventory {
    //declared these as static to I don't have to keep passing them in methods

    static int count = 0;
    static Vehicle[] vehicles = new Vehicle[20];
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        preloadVehicles(); //preloads the vehicles into the array

        int option = 7;
        while(option != 6){
            printOptions();
            option = sc.nextInt();
            switch (option){
                case 1 -> listAllVehicles();
                case 2 -> searchByMakeModel();
                case 3 -> searchByPriceRange();
                case 4 -> searchByColor();
                case 5 -> addVehicle();
                case 6 -> System.out.println("Vehicle Inventory Program quitting...");
                default -> {
                    System.out.println("Invalid option selected. Program exiting.");
                    System.exit(0);
                }
            }
        }

    }

    private static void printOptions() {
        System.out.println("\n" + """
                    What do you want to do?
                    1 - List all vehicles
                    2 - Search by make/model
                    3 - Search by price range
                    4 - Search by color
                    5 - Add a vehicle
                    6 - Quit
                    Enter your command as a number:""");
    }

    private static void preloadVehicles() {
        vehicles[count] = new Vehicle(101121, "Ford Explorer", "Red", 45000, 13500.00);
        count++;

        vehicles[count] = new Vehicle(101122, "Toyota Camry", "Blue", 60000, 11000.00);
        count++;

        vehicles[count] = new Vehicle(101123, "Chevrolet Malibu", "Black", 50000, 9700.00);
        count++;

        vehicles[count] = new Vehicle(101124, "Honda Civic", "White", 70000, 7500.00);
        count++;

        vehicles[count] = new Vehicle(101125, "Jeep Wrangler", "Green", 55000, 14500.00);
        count++;

        vehicles[count] = new Vehicle(101126, "Jeep Wrangler", "Yellow", 30000, 16000.00);
        count++;
    }

    private static void addVehicle() {
        sc.nextLine();
        System.out.println("Enter the Vehicle ID:");
        long vehicleId = Long.parseLong(sc.nextLine());

        System.out.println("Enter the make/model:");
        String makeModel = sc.nextLine();

        System.out.println("Enter the color: ");
        String color = sc.nextLine();

        System.out.println("Enter the number of miles on odometer:");
        int odometer = sc.nextInt();

        System.out.println("Enter the price: ");
        double price = sc.nextDouble();

        vehicles[count] = new Vehicle(vehicleId, makeModel, color, odometer, price);
        System.out.println("Success! Following car was added to the list" + vehicles[count]);
        count ++;
    }

    private static void searchByColor() {
        boolean notFound = true;
        sc.nextLine();
        System.out.print("Enter Color to search: ");
        String color = sc.nextLine(); // Capture user input
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < count; i++){
            if (vehicles[i].getColor().equalsIgnoreCase(color)){
                result.append("\n").append(vehicles[i].toString());
                notFound = false;
            }
        }
        System.out.println(result);
        if (notFound) System.out.println("No matching Vehicles found!");
    }

    private static void searchByPriceRange() {
        boolean notFound = true;
        StringBuilder result = new StringBuilder();
        sc.nextLine();
        System.out.print("Enter the min amount for search: ");
        int minValue = sc.nextInt();
        System.out.print("Enter the min amount for search: ");
        int maxValue = sc.nextInt();

        for (int i = 0; i < count; i++){
            if (vehicles[i].getPrice() <= maxValue && vehicles[i].getPrice() >= minValue ){
                result.append("\n").append(vehicles[i].toString());
                notFound = false;
            }
        }
        System.out.println(result);
        if (notFound) System.out.println("No matching Vehicles found!");

    }

    private static void searchByMakeModel() {
        sc.nextLine();
        boolean notFound = true;
        System.out.print("Enter Make/Model to search: ");
        String makeModel = sc.nextLine(); // Capture user input
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < count; i++){
            if (vehicles[i].getMakeModel().equalsIgnoreCase(makeModel)){
                result.append("\n").append(vehicles[i].toString());
                notFound = false;
            }
        }
        System.out.println(result);
        if (notFound) System.out.println("No matching Vehicles found!");
    }

    private static void listAllVehicles() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < count; i++){
            result.append("\n").append(vehicles[i].toString());
        }
        System.out.println(result);
    }
}