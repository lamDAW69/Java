package org.example;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.example.dao.CategoryDAO;
import org.example.dao.CategoryDAOHibernate;
import org.example.entities.Category;

import org.example.dao.ProductDAO;
import org.example.dao.ProductDAOHibernate;
import org.example.entities.Product;

import org.example.entities.User;
import org.example.dao.UserDAO;
import org.example.dao.UserDAOHibernate;


/**
 * Hello world!
 *
 */
public class App {
    private static Scanner sc = new Scanner(System.in);
    private static CategoryDAO categoryDAO = new CategoryDAOHibernate();
    private static ProductDAO productDAO = new ProductDAOHibernate();
    private static UserDAO userDAO = new UserDAOHibernate();

    public static void listCategories() {
        categoryDAO.getCategories().forEach(category -> System.out.println(category));
    }

    public static void listProducts() {
        productDAO.getProducts().forEach(product -> System.out.println(product));
    }

    public static void listProductsByCategory() {
        listCategories();
        System.out.print("Choose a category: ");
        int idCat = sc.nextInt();
        sc.nextLine();
        productDAO.getProdutosCategoria(idCat).forEach(product -> System.out.println(product));
    }

    public static void createCategory() {
        System.out.print("Enter the name: ");
        String name = sc.nextLine();

        Category newCategory = new Category(0, name);
        categoryDAO.insertCategory(newCategory);
    }

    public static void createProduct() {
        System.out.print("Enter the reference: ");
        String reference = sc.nextLine();

        System.out.print("Enter the name: ");
        String name = sc.nextLine();

        System.out.print("Enter the price: ");
        double price = sc.nextDouble();

        listCategories();
        System.out.print("Enter the category: ");
        int category = sc.nextInt();
        sc.nextLine();

        Product newProduct = new Product(0, reference, name, price, null);
        productDAO.insertProduct(newProduct, category);
    }

    public static void deleteCategory() {
        listCategories();

        System.out.print("Enter the id of the category you want to delete: ");
        int id = sc.nextInt();
        sc.nextLine();

        categoryDAO.deleteCategory(id);
    }

    public static void deleteProduct() {
        listProducts();

        System.out.print("Enter the id of the product you want to delete: ");
        int id = sc.nextInt();
        sc.nextLine();

        productDAO.deleteProduct(id);
    }

    public static void updateCategory() {
        listCategories();

        System.out.print("Enter the id of the category you want to update: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter the new name: ");
        String name = sc.nextLine().trim();

        Category category = new Category(id, name);
        categoryDAO.updateCategory(category);
    }

    public static void updateProduct() {
        listProducts();

        System.out.print("Enter the id of the product you want to update: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter the reference: ");
        String reference = sc.nextLine();

        System.out.print("Enter the name: ");
        String name = sc.nextLine();

        System.out.print("Enter the price: ");
        double price = sc.nextDouble();

        System.out.print("Enter the category: ");
        int category = sc.nextInt();
        sc.nextLine();

        Product product = new Product(id, reference, name, price, null);
        productDAO.updateProduct(product, category);
    }

    public static void productMenu() {
        String option = "";

        System.out.println("c: Create Product");
        System.out.println("r: List Products");
        System.out.println("r2: List Products by Category");
        System.out.println("u: Update Product");
        System.out.println("d: Delete Product");
        System.out.print("Enter option: ");

        option = sc.nextLine();

        switch (option.toLowerCase()) {
            case "c":
                createProduct();
                break;
            case "r":
                listProducts();
                break;
            case "r2":
                listProductsByCategory();
                break;
            case "u":
                updateProduct();
                break;
            case "d":
                deleteProduct();
                break;
            default:
                System.err.println("Invalid option");
        }
    }

    public static void listUsers() {
        userDAO.getUsers().forEach(user -> System.out.println(user));
    }

    public static void createUser() {
        System.out.print("Enter the name: ");
        String name = sc.nextLine();

        User newUser = new User(0, name);
        userDAO.insertUser(newUser);
    }

    public static void deleteUser() {
        listUsers();

        System.out.print("Enter the id of the user you want to delete: ");
        int id = sc.nextInt();
        sc.nextLine();

        userDAO.deleteUser(id);
    }

    public static void updateUser() {
        listUsers();

        System.out.print("Enter the id of the user you want to update: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter the new name: ");
        String name = sc.nextLine().trim();

        User user = new User(id, name);
        userDAO.updateUser(user);
    }

    public static void manuUsers() {
        String option = "";
        System.out.println("c: Create User");
        System.out.println("r: List Users");
        System.out.println("u: Update User");
        System.out.println("d: Delete User");
        System.out.print("Enter option: ");

        option = sc.nextLine();

        switch (option.toLowerCase()) {
            case "c":
                createUser();
                break;
            case "r":
                listUsers();
                break;
            case "u":
                updateUser();
                break;
            case "d":
                deleteUser();
                break;
            default:
                System.err.println("Invalid option");
        }
    }

    public static void categoryMenu() {
        String option = "";

        System.out.println("c: Create Category");
        System.out.println("r: List Categories");
        System.out.println("u: Update Category");
        System.out.println("d: Delete Category");
        System.out.print("Enter option: ");

        option = sc.nextLine();

        switch (option.toLowerCase()) {
            case "c":
                createCategory();
                break;
            case "r":
                listCategories();
                break;
            case "u":
                updateCategory();
                break;
            case "d":
                deleteCategory();
                break;
            default:
                System.err.println("Invalid option");
        }
    }

    public static void main(String[] args) {
        Logger.getLogger("org.hibernate").setLevel(Level.OFF);

        String option = "";

        do {
            System.out.println();
            System.out.println("BASIC CRUD PRODUCT MANAGER");
            System.out.println("p: Products");
            System.out.println("c: Categories");
            System.out.println("s: Exit");
            System.out.print("Enter option: ");

            option = sc.nextLine();

            switch (option.toLowerCase()) {
                case "p":
                    productMenu();
                    break;
                case "c":
                    categoryMenu();
                    break;
                case "s":
                    break;
                case "u":
                    manuUsers();
                    break;
                default:
                    System.err.println("Invalid option");
            }

        } while(!option.toLowerCase().equals("s"));
    }
}