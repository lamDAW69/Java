public record PersonaRecord(String name, int age) {



    public PersonaRecord(Persona p) { //Constructor copia de personas
        this(p.name, p.age);
    }
}
