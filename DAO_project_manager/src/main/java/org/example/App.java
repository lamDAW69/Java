package org.example;

import java.util.Scanner;

import org.example.dao.CategoryDAO;
import org.example.dao.CategoryDAOMySql;
import org.example.entities.Category;

import org.example.dao.ProductDAO;
import org.example.dao.ProductDAOMySql;
import org.example.entities.Product;

/**
 * Hello world!
 *
 */
public class App
{
    private static Scanner sc = new Scanner(System.in);
    private static CategoryDAO categoryDAO = new CategoryDAOMySql();
    private static ProductDAO productDAO = new ProductDAOMySql();

    public static void listarCategorias() {
        categoryDAO.getCategories().forEach(categoria -> System.out.println(categoria));
    }

    public static void listarProductos() {
        productDAO.getProducts().forEach(producto -> System.out.println(producto));
    }

    public static void crearCategoria() {
        System.out.print("Introduce el nombre: ");
        String nombre = sc.nextLine();

        Category nuevaCategoria = new Category(0, nombre);
        categoryDAO.insertCategory(nuevaCategoria);
    }

    public static void crearProducto() {
        System.out.print("Introduce la referencia: ");
        String referencia = sc.nextLine();

        System.out.print("Introduce el nombre: ");
        String nombre = sc.nextLine();

        System.out.print("Introduce el precio: ");
        double precio = sc.nextDouble();

        System.out.print("Introduce la categoría: ");
        int categoria = sc.nextInt();
        sc.nextLine();

        Product nuevoProducto = new Product(0, referencia, nombre, precio, categoria);
        productDAO.insertProduct(nuevoProducto);
    }

    public static void borrarCategoria() {
        listarCategorias();

        System.out.print("Introduce el id de la categoría que quieres borrar: ");
        int id = sc.nextInt();
        sc.nextLine();

        categoryDAO.deleteCategory(id);
    }

    public static void borrarProducto() {
        listarProductos();

        System.out.print("Introduce el id del producto que quieres borrar: ");
        int id = sc.nextInt();
        sc.nextLine();

        productDAO.deleteProduct(id);
    }

    public static void actualizarCategoria() {
        listarCategorias();

        System.out.print("Introduce el identificador de la categoría que quieres actualizar: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Introduce el nuevo nombre: ");
        String nombre = sc.nextLine().trim();

        Category categoria = new Category(id, nombre);
        categoryDAO.updateCategory(categoria);
    }

    public static void actualizarProducto() {
        listarProductos();

        System.out.print("Introduce el identificador del producto que quieres actualizar: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Introduce la referencia: ");
        String referencia = sc.nextLine();

        System.out.print("Introduce el nombre: ");
        String nombre = sc.nextLine();

        System.out.print("Introduce el precio: ");
        double precio = sc.nextDouble();

        System.out.print("Introduce la categoría: ");
        int categoria = sc.nextInt();
        sc.nextLine();

        Product producto = new Product(id, referencia, nombre, precio, categoria);
        productDAO.updateProduct(producto);
    }

    public static void menuProductos() {
        String opcion = "";

        System.out.println("c: Crear Producto");
        System.out.println("r: Listar Productos");
        System.out.println("u: Actualizar Producto");
        System.out.println("d: Borrar Producto");
        System.out.print("Introduzca opción: ");

        opcion = sc.nextLine();

        switch (opcion.toLowerCase()) {
            case "c":
                crearProducto();
                break;
            case "r":
                listarProductos();
                break;
            case "u":
                actualizarProducto();
                break;
            case "d":
                borrarProducto();
                break;
            default:
                System.err.println("Opción no válida");
        }
    }

    public static void menuCategorias() {
        String opcion = "";

        System.out.println("c: Crear Categoría");
        System.out.println("r: Listar Categoría");
        System.out.println("u: Actualizar Categoría");
        System.out.println("d: Borrar Categoría");
        System.out.print("Introduzca opción: ");

        opcion = sc.nextLine();

        switch (opcion.toLowerCase()) {
            case "c":
                crearCategoria();
                break;
            case "r":
                listarCategorias();
                break;
            case "u":
                actualizarCategoria();
                break;
            case "d":
                borrarCategoria();
                break;
            default:
                System.err.println("Opción no válida");
        }
    }

    public static void main(String[] args) {
        String opcion = "";

        do {
            System.out.println();
            System.out.println("CRUD BÁSICO PRODUCT MANAGER");
            System.out.println("p: Productos");
            System.out.println("c: Categorías");
            System.out.println("s: Salir");
            System.out.print("Introduzca opción: ");

            opcion = sc.nextLine();

            switch (opcion.toLowerCase()) {
                case "p":
                    menuProductos();
                    break;
                case "c":
                    menuCategorias();
                    break;
                case "s":
                    break;
                default:
                    System.err.println("Opción no válida");
            }

        } while(!opcion.toLowerCase().equals("e"));
    }
}