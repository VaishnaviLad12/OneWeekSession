package AnudipPracticals;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class CustomerManagementSystem {
    private static class Customer {
        private int id;
        private String name;
        private String email;

        public Customer(int id, String name, String email) {
            this.id = id;
            this.name = name;
            this.email = email;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getEmail() {
            return email;
        }

        @Override
        public String toString() {
            return "Customer [ID=" + id + ", Name=" + name + ", Email=" + email + "]";
        }
    }

    private List<Customer> customers = new ArrayList<>();

    public void addCustomer(Customer customer) {
        customers.add(customer);
        System.out.println("Customer added successfully.");
    }

    public void removeCustomer(int id) {
        customers.removeIf(customer -> customer.getId() == id);
        System.out.println("Customer removed successfully.");
    }

    public Customer searchCustomer(int id) {
        for (Customer customer : customers) {
            if (customer.getId() == id) {
                return customer;
            }
        }
        return null;
    }

    public void listAllCustomers() {
        if (customers.isEmpty()) {
            System.out.println("No customers found.");
        } else {
            for (Customer customer : customers) {
                System.out.println(customer);
            }
        }
    }

    public void sortCustomersByName() {
        customers.sort(Comparator.comparing(Customer::getName));
        System.out.println("Customers sorted by name.");
    }

    public void sortCustomersById() {
        customers.sort(Comparator.comparingInt(Customer::getId));
        System.out.println("Customers sorted by ID.");
    }

    public static void main(String[] args) {
        CustomerManagementSystem manager = new CustomerManagementSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n Welome to Customer Management System!");
            System.out.println("1. Add Customer");
            System.out.println("2. Remove Customer");
            System.out.println("3. Search Customer");
            System.out.println("4. List All Customers");
            System.out.println("5. Sort Customers by Name");
            System.out.println("6. Sort Customers by ID");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Customer ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    System.out.print("Enter Customer Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Customer Email: ");
                    String email = scanner.nextLine();
                    Customer newCustomer = new Customer(id, name, email);
                    manager.addCustomer(newCustomer);
                    break;

                case 2:
                    System.out.print("Enter Customer ID to remove: ");
                    int removeId = scanner.nextInt();
                    manager.removeCustomer(removeId);
                    break;

                case 3:
                    System.out.print("Enter Customer ID to search: ");
                    int searchId = scanner.nextInt();
                    Customer customer = manager.searchCustomer(searchId);
                    if (customer != null) {
                        System.out.println("Customer found: " + customer);
                    } else {
                        System.out.println("Customer not found.");
                    }
                    break;

                case 4:
                    manager.listAllCustomers();
                    break;

                case 5:
                    manager.sortCustomersByName();
                    break;

                case 6:
                    manager.sortCustomersById();
                    break;

                case 7:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

