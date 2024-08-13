package ecommerce;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

class Cart {
    private List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
    }

    public void displayCart() {
        for (int i = 0; i < products.size(); i++) {
            System.out.println((i + 1) + ". " + products.get(i).getName() + " - " + products.get(i).getPrice());
        }
    }

    public double calculateTotal() {
        double total = 0;
        for (Product product : products) {
            total += product.getPrice();
        }
        return total;
    }
}

class User {
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public boolean checkPassword(String password) {
        return this.password.equals(password);
    }
}

class UserManager {
    private Map<String, User> users = new HashMap<>();

    public void signUp(String username, String password) {
        if (users.containsKey(username)) {
            System.out.println("Username already exists. Please choose a different username.");
        } else {
            users.put(username, new User(username, password));
            System.out.println("Sign-up successful. Please log in.");
        }
    }

    public boolean signIn(String username, String password) {
        User user = users.get(username);
        if (user != null && user.checkPassword(password)) {
            System.out.println("Login successful. Welcome, " + username + "!");
            return true;
        } else {
            System.out.println("Invalid username or password. Please try again.");
            return false;
        }
    }
}

public class Main {
    private static Cart cart = new Cart();
    private static Scanner scanner = new Scanner(System.in);
    private static UserManager userManager = new UserManager();

    public static void main(String[] args) {
        while (true) {
            System.out.println("Welcome to our E-commerce Website!");
            System.out.println("1. Sign Up");
            System.out.println("2. Sign In");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    signUp();
                    break;
                case 2:
                    if (signIn()) {
                        Main1.showCategories(cart);
                    }
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    private static void signUp() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        userManager.signUp(username, password);
    }

    private static boolean signIn() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        return userManager.signIn(username, password);
    }
}

class Main1 {
    private static Scanner scanner = new Scanner(System.in);

    public static void showCategories(Cart cart) {
        System.out.println("Welcome to our E-commerce Website!");
        System.out.println("Please select a category:");
        System.out.println("1. Fashion");
        System.out.println("2. Electronics");
        System.out.println("3. Home Appliances");
        System.out.println("4. Furniture");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                fashionCategory(cart);
                break;
            case 2:
                electronicsCategory(cart);
                break;
            case 3:
                homeAppliancesCategory(cart);
                break;
            case 4:
                furnitureCategory(cart);
                break;
            default:
                System.out.println("Invalid choice");
        }
    }

    private static void fashionCategory(Cart cart) {
        System.out.println("Fashion Category");
        System.out.println("1. Men");
        System.out.println("2. Women");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                menFashion(cart);
                break;
            case 2:
                womenFashion(cart);
                break;
            default:
                System.out.println("Invalid choice");
                fashionCategory(cart);
        }
    }

    private static void menFashion(Cart cart) {
        System.out.println("Men's Fashion");
        System.out.println("1. Jeans");
        System.out.println("2. Shirts");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                jeans(cart);
                break;
            case 2:
                shirts(cart);
                break;
            default:
                System.out.println("Invalid choice");
                
        }
    }

    private static void womenFashion(Cart cart) {
        System.out.println("Women's Fashion");
        System.out.println("1. Jeans");
        System.out.println("2. Kurta");
        System.out.println("3. Western Tops");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                jeans(cart);
                break;
            case 2:
                kurta(cart);
                break;
            case 3:
                westernTops(cart);
                break;
            default:
                System.out.println("Invalid choice");
        }
    }

    private static void jeans(Cart cart) {
        System.out.println("Jeans");
        System.out.println("Select size:");
        System.out.println("1. 32");
        System.out.println("2. 30");
        System.out.println("3. 28");
        int choice = scanner.nextInt();
        Product product = new Product("Jeans", 1000);
        cart.addProduct(product);
        System.out.println("Added to cart");
        continueShopping(cart);
        buyNow(cart);
    }

    private static void shirts(Cart cart) {
        System.out.println("Shirts");
        System.out.println("Select size:");
        System.out.println("1. 32");
        System.out.println("2. 30");
        System.out.println("3. 28");
        int choice = scanner.nextInt();
        Product product = new Product("Shirts", 500);
        cart.addProduct(product);
        System.out.println("Added to cart");
        continueShopping(cart);
        buyNow(cart);
    }

    private static void kurta(Cart cart) {
        System.out.println("Kurta");
        System.out.println("Select size:");
        System.out.println("1. 32");
        System.out.println("2. 30");
        System.out.println("3. 28");
        int choice = scanner.nextInt();
        Product product = new Product("Kurta", 800);
        cart.addProduct(product);
        System.out.println("Added to cart");
        continueShopping(cart);
        buyNow(cart);
    }

    private static void westernTops(Cart cart) {
        System.out.println("Western Tops");
        System.out.println("Select size:");
        System.out.println("1. 32");
        System.out.println("2. 30");
        System.out.println("3. 28");
        int choice = scanner.nextInt();
        Product product = new Product("Tops", 900);
        cart.addProduct(product);
        System.out.println("Added to cart");
        continueShopping(cart);
        buyNow(cart);
    }

    private static void electronicsCategory(Cart cart) {
        System.out.println("Electronic Items Category");
        System.out.println("1. Mobiles");
        System.out.println("2. Laptops");
        System.out.println("3. Mouse");
        System.out.println("4. Iron");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                mobiles(cart);
                break;
            case 2:
                laptops(cart);
                break;
            case 3:
                mouse(cart);
                break;
            case 4:
                iron(cart);
                break;
            default:
                System.out.println("Invalid choice");
                electronicsCategory(cart);
                break;
        }
    }

    private static void mobiles(Cart cart) {
        Product product = new Product("Mobiles", 10000);
        cart.addProduct(product);
        System.out.println("Added to cart");
        continueShopping(cart);
    }

    private static void laptops(Cart cart) {
        Product product = new Product("Laptops", 11000);
        cart.addProduct(product);
        System.out.println("Added to cart");
        continueShopping(cart);
    }

    private static void mouse(Cart cart) {
        Product product = new Product("Mouse", 12000);
        cart.addProduct(product);
        System.out.println("Added to cart");
        continueShopping(cart);
    }

    private static void iron(Cart cart) {
        Product product = new Product("Iron", 13000);
        cart.addProduct(product);
        System.out.println("Added to cart");
        continueShopping(cart);
    }

    private static void homeAppliancesCategory(Cart cart) {
        System.out.println("Home Appliances Category");
        System.out.println("1. Fridge");
        System.out.println("2. Washing Machine");
        System.out.println("3. Microwave Oven");
        System.out.println("4. Induction cookers");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                fridge(cart);
                break;
            case 2:
                washingMachine(cart);
                break;
            case 3:
                microwaveOven(cart);
                break;
            case 4:
                inductionCookers(cart);
                break;
            default:
                System.out.println("Invalid choice");
                homeAppliancesCategory(cart);
                break;
        }
    }

    private static void fridge(Cart cart) {
        Product product = new Product("Fridge", 9000);
        cart.addProduct(product);
        System.out.println("Added to cart");
        continueShopping(cart);
    }

    private static void washingMachine(Cart cart) {
        Product product = new Product("WashingMachine", 8000);
        cart.addProduct(product);
        System.out.println("Added to cart");
        continueShopping(cart);
    }

    private static void microwaveOven(Cart cart) {
        Product product = new Product("Oven", 7000);
        cart.addProduct(product);
        System.out.println("Added to cart");
        continueShopping(cart);
    }

    private static void inductionCookers(Cart cart) {
        Product product = new Product("Induction", 6000);
        cart.addProduct(product);
        System.out.println("Added to cart");
        continueShopping(cart);
    }

    private static void furnitureCategory(Cart cart) {
        System.out.println("Furniture Category");
        System.out.println("1. Sofa");
        System.out.println("2. Table");
        System.out.println("3. Bed");
        System.out.println("4. Chair");
        System.out.println("5. TV Units");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                sofa(cart);
                break;
            case 2:
                table(cart);
                break;
            case 3:
                bed(cart);
                break;
            case 4:
                chair(cart);
                break;
            case 5:
                tvUnits(cart);
                break;
            default:
                System.out.println("Invalid choice");
                furnitureCategory(cart);
                break;
        }
    }

    private static void sofa(Cart cart) {
        Product product = new Product("Sofa", 1000);
        cart.addProduct(product);
        System.out.println("Added to cart");
        continueShopping(cart);
    }

    private static void table(Cart cart) {
        Product product = new Product("Table", 2000);
        cart.addProduct(product);
        System.out.println("Added to cart");
        continueShopping(cart);
    }

    private static void bed(Cart cart) {
        Product product = new Product("Bed", 3000);
        cart.addProduct(product);
        System.out.println("Added to cart");
        continueShopping(cart);
    }

    private static void chair(Cart cart) {
        Product product = new Product("Chair", 4000);
        cart.addProduct(product);
        System.out.println("Added to cart");
        continueShopping(cart);
    }

    private static void tvUnits(Cart cart) {
        Product product = new Product("Tvunits", 5000);
        cart.addProduct(product);
        System.out.println("Added to cart");
        continueShopping(cart);
    }

    private static void continueShopping(Cart cart) {
        System.out.println("Do you want to continue shopping? (1. Yes, 2. No)");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                showCategories(cart);
                break;
            case 2:
                buyNow(cart);
                break;
            default:
                System.out.println("Invalid choice");
                continueShopping(cart);
                break;
        }
    }

    private static void buyNow(Cart cart) {
        System.out.println("Do you want to buy now? (1. Yes, 2. No)");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                generateBill(cart);
                break;
            case 2:
                System.out.println("Thank you for shopping!");
                break;
            default:
                System.out.println("Invalid choice");
        }
    }

    private static void generateBill(Cart cart) {
        Date date = new Date();
        System.out.println("Bill generated on: " + date);
        System.out.println("Products in cart:");
        cart.displayCart();
        System.out.println("Total: " + cart.calculateTotal());
        System.out.println("Ordered Successfully....");
        System.out.println("Thank you for your purchase!");
    }
}
