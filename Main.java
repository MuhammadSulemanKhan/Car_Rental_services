import java.util.ArrayList;
import java.util.Scanner;

// Car Class (Encapsulation)
class Car {
    private int carId;
    private String model;
    private boolean isRented;

    public Car(int carId, String model) {
        this.carId = carId;
        this.model = model;
        this.isRented = false;
    }

    public int getCarId() {
        return carId;
    }

    public String getModel() {
        return model;
    }

    public boolean isRented() {
        return isRented;
    }

    public void rentCar() {
        isRented = true;
    }

    public void returnCar() {
        isRented = false;
    }
}

// Rental System Class
class RentalSystem {
    private ArrayList<Car> cars = new ArrayList<>();
    private Scanner scanner;

    public RentalSystem(Scanner scanner) {
        this.scanner = scanner;
    }

    public void addCar() {
        System.out.print("Enter Car ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Car Model: ");
        String model = scanner.nextLine();

        cars.add(new Car(id, model));
        System.out.println("Car added successfully.");
    }

    public void rentCar() {
        System.out.print("Enter Car ID to Rent: ");
        int id = scanner.nextInt();

        for (Car car : cars) {
            if (car.getCarId() == id) {
                if (!car.isRented()) {
                    car.rentCar();
                    System.out.println("Car rented successfully.");
                } else {
                    System.out.println("Car is already rented.");
                }
                return;
            }
        }

        System.out.println("Car not found.");
    }

    public void returnCar() {
        System.out.print("Enter Car ID to Return: ");
        int id = scanner.nextInt();

        for (Car car : cars) {
            if (car.getCarId() == id) {
                if (car.isRented()) {
                    car.returnCar();
                    System.out.println("Car returned successfully.");
                } else {
                    System.out.println("Car is already available.");
                }
                return;
            }
        }

        System.out.println("Car not found.");
    }

    public void viewCars() {
        if (cars.isEmpty()) {
            System.out.println("No cars available in the system.");
            return;
        }

        System.out.println("--- Car List ---");
        for (Car car : cars) {
            String status = car.isRented() ? "Rented" : "Available";
            System.out.println("ID: " + car.getCarId() + " | Model: " + car.getModel() + " | Status: " + status);
        }
    }
}

// Main Class
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        RentalSystem rentalSystem = new RentalSystem(input);

        while (true) {
            System.out.println("\n--- Car Rental System ---");
            System.out.println("1. Add Car");
            System.out.println("2. Rent Car");
            System.out.println("3. Return Car");
            System.out.println("4. View Cars");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = input.nextInt();

            if (choice == 1) {
                rentalSystem.addCar();
            } else if (choice == 2) {
                rentalSystem.rentCar();
            } else if (choice == 3) {
                rentalSystem.returnCar();
            } else if (choice == 4) {
                rentalSystem.viewCars();
            } else if (choice == 5) {
                System.out.println("Exiting System...");
                break;
            } else {
                System.out.println("Invalid Choice!");
            }
        }

        input.close();
    }
}
