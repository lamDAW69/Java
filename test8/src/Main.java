import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Main {
    public static void main(String[] args) {
        /*Scanner sc = new Scanner(System.in);
        System.out.println("Enter your name: ");
        String name = sc.nextLine();
        System.out.println("Hello " + name);*/

        //Crear un objeto cuadrado con un lado de 5.6

        Cuadrado square = new Cuadrado(5.6);
        Cuadrado square2 = new Cuadrado();
        square2.setLado(10.5);
        System.out.println("El lado del cuadrado es: " + square.getLado() + " Y el cuadrado 2 es: " + square2.getLado());

        //Create an object product with a name and a price
        Product product = new Product("Laptop", 650);
        double canaryIslandTax = 1.08;
        double ceutaMelillaTax = 1.10;
        double peninsularTax = 1.21;

        System.out.println("The price of the product in the Canary Islands is: " + product.getPriceTaxed(canaryIslandTax));
        System.out.println("The price of the product in Ceuta and Melilla is: " + String.format("%.2f", product.getPriceTaxed(ceutaMelillaTax) ));
        System.out.println("The price of the product in the Peninsula is: " + product.getPriceTaxed(peninsularTax));

        //Create a persona

        Persona personita = new Persona("Luis", 25);
        System.out.println("The name of the person is: " + personita.getName() + " and the age is: " + personita.getAge());
        personita.setAge(-5);
        System.out.println("The name of the person is: " + personita.getName() + " and the age is: " + personita.getAge());
        personita.salute();

        Persona[] personas = {
            new Persona("Luis", 25),
            new Persona("Juan", 30),
            new Persona("Maria", 20),
            new Persona("Ana", 40),
            new Persona("Pedro", 35)
        };

        for(Persona x : personas) {         //For each
            x.salute();
        }

        Persona[] personas2 = Persona.copyArray(personas); //Copy the array of personas

        for( Persona x : personas2) {
            x.salute();
        }

        //Create a record
        PersonaRecord littlerPersona = new PersonaRecord("Luis", 25);
        System.out.println(littlerPersona);

        //Herencia
        TiendaLicores store = new TiendaLicores();
        store.bienvenida();

        //Collections
        List<Product> listadoProductos = new ArrayList<>();

        listadoProductos.add(new Product("Laptop", 650));
        listadoProductos.add(new Product("Mouse", 20));
        listadoProductos.add(new Product("Keyboard", 50));
        listadoProductos.add(new Product("Monitor", 200));
        listadoProductos.add(new Product("Headphones", 100));

        for(Product x : listadoProductos) {
            System.out.println(x.getName() + " " + x.getPrice());
        }
        //HashMap

        Map<String, String> translations = new HashMap<>();
                        //KEY, VALUE
        translations.put("Hello", "Hola");
        translations.put("Goodbye", "Adios");
        translations.put("Thank you", "Gracias");
        translations.put("Please", "Por favor");

        String word = translations.get("Hello");
        System.out.println(word);
        System.out.println(translations);

        //Polimorfismo
        List<Figura> figuritas = new ArrayList<>();
        figuritas.add(new Square(5.6));
        figuritas.add(new Circle(3.5));

        for(Figura x : figuritas) {
            System.out.println("Area: " + String.format("%.2f", x.calculateArea()));
        }
    }

}
