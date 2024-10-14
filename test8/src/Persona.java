public class Persona {
    String name;
    int age;

    public Persona(String name, int age) {      //Constructor
        this.name = name;
        if(age >= 0) {
            this.age = age;
        }
    }

    public Persona(Persona p ) {              //Constructor copia de personas
        this.name = p.name;
        this.age = p.age;
    }



    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        if  (age >= 0) {
            this.age = age;
        }
    }

    public int getAge() {
        return age;
    }

    public void salute() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}
