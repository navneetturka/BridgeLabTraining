import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class OnlineShoppingSystem {

    static class Product {
        int productId;
        String productName;
        double price;

        public Product(int productId, String productName, double price) {
            this.productId = productId;
            this.productName = productName;
            this.price = price;
        }

        public void showProduct() {
            System.out.println("ID: " + productId + " | Name: " + productName + " | Price: " + price);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Product> products = new ArrayList<Product>();
        LinkedList<Product> recentlyViewed = new LinkedList<Product>();
        ArrayList<Product> cart = new ArrayList<Product>();

        while (true) {
            System.out.println("\n========== Online Shopping System ==========");
            System.out.println("1. Add Product");
            System.out.println("2. View Product");
            System.out.println("3. Add to Cart");
            System.out.println("4. Display Recently Viewed Products");
            System.out.println("5. Search Product by Name");
            System.out.println("6. Display All Products");
            System.out.println("7. Display Cart & Total");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");

            int choice;
            if (sc.hasNextInt()) {
                choice = sc.nextInt();
            } else {
                System.out.println("Invalid input. Please enter a number.");
                sc.next();
                continue;
            }

            if (choice == 0) {
                System.out.println("Thank you for using the system.");
                break;
            }

            if (choice == 1) {
                System.out.print("Enter Product ID: ");
                int id = sc.nextInt();
                sc.nextLine();

                System.out.print("Enter Product Name: ");
                String name = sc.nextLine();

                System.out.print("Enter Product Price: ");
                double price = sc.nextDouble();

                Product p = new Product(id, name, price);
                products.add(p);
                System.out.println("Product added successfully.");
            }

            else if (choice == 2) {
                System.out.print("Enter Product ID to view: ");
                int idToView = sc.nextInt();

                Product found = findProductById(products, idToView);

                if (found == null) {
                    System.out.println("Product not found.");
                } else {
                    System.out.println("Product details:");
                    found.showProduct();

                    recentlyViewed.addFirst(found);

                    if (recentlyViewed.size() > 5) {
                        recentlyViewed.removeLast();
                    }
                }
            }

            else if (choice == 3) {
                System.out.print("Enter Product ID to add to cart: ");
                int idToCart = sc.nextInt();

                Product found = findProductById(products, idToCart);

                if (found == null) {
                    System.out.println("Product not found. Cannot add to cart.");
                } else {
                    cart.add(found);
                    System.out.println("Added to cart:");
                    found.showProduct();
                }
            }

            else if (choice == 4) {
                System.out.println("\nRecently Viewed Products (Latest first):");

                if (recentlyViewed.size() == 0) {
                    System.out.println("No recently viewed products yet.");
                } else {
                    for (int i = 0; i < recentlyViewed.size(); i++) {
                        System.out.print((i + 1) + ". ");
                        Product p = recentlyViewed.get(i);
                        p.showProduct();
                    }
                }
            }

            else if (choice == 5) {
                sc.nextLine();
                System.out.print("Enter product name to search: ");
                String searchName = sc.nextLine();

                boolean foundAny = false;
                System.out.println("Search results:");

                for (int i = 0; i < products.size(); i++) {
                    Product p = products.get(i);
                    if (p.productName.equalsIgnoreCase(searchName)) {
                        p.showProduct();
                        foundAny = true;
                    }
                }

                if (!foundAny) {
                    System.out.println("No product found with that name.");
                }
            }

            else if (choice == 6) {
                System.out.println("\nAll Products:");

                if (products.size() == 0) {
                    System.out.println("No products added yet.");
                } else {
                    for (int i = 0; i < products.size(); i++) {
                        System.out.print((i + 1) + ". ");
                        products.get(i).showProduct();
                    }
                }
            }

            else if (choice == 7) {
                System.out.println("\nCart Items:");

                if (cart.size() == 0) {
                    System.out.println("Cart is empty.");
                } else {
                    for (int i = 0; i < cart.size(); i++) {
                        System.out.print((i + 1) + ". ");
                        cart.get(i).showProduct();
                    }

                    double total = calculateTotal(cart);
                    System.out.println("Cart Total = " + total);
                }
            }

            else {
                System.out.println("Invalid choice. Try again.");
            }
        }

        sc.close();
    }

    public static Product findProductById(ArrayList<Product> products, int id) {
        for (int i = 0; i < products.size(); i++) {
            Product p = products.get(i);
            if (p.productId == id) {
                return p;
            }
        }
        return null;
    }

    public static double calculateTotal(ArrayList<Product> cart) {
        double total = 0.0;
        for (int i = 0; i < cart.size(); i++) {
            Product p = cart.get(i);
            total += p.price;
        }
        return total;
    }
}