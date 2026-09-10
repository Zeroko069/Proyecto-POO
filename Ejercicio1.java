import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Persona {

    private String nombre;
    private int edad;
    private String documento;

    public Persona(String nombre, int edad, String documento) {
        this.nombre = nombre;
        this.edad = edad;
        this.documento = documento;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public String getDocumento() {
        return documento;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public void mostrarInformacion() {
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad);
        System.out.println("Documento: " + documento);
    }

    public boolean esMayorDeEdad() {
        return edad > 18;
    }
}


public class Ejercicio1 {

    public static void main(String[] args) {

        List<Persona> personas = new ArrayList<>();

        Random random = new Random();

        String[] nombres = {
            "Andres", "Carlos", "Maria", "Laura", "Juan", "Sofia", "Daniel", "Camila", "Pedro", "Valentina"};

        for (int i = 0; i < 10; i++) {

            String nombre = nombres[i];

            int edad = random.nextInt(60) + 1;

            String documento = String.valueOf(
                1000000000 + random.nextInt(100000000)
            );

            Persona persona = new Persona(
                nombre,
                edad,
                documento
            );

            personas.add(persona);
        }

        System.out.println("===== LISTA DE PERSONAS =====");
        System.out.println();

        for (Persona persona : personas) {

            persona.mostrarInformacion();

            if (persona.esMayorDeEdad()) {
                System.out.println(
                    "Nombre: " + persona.getNombre()
                    + " Es mayor de edad"
                );
            } else {
                System.out.println(
                    "Nombre: " + persona.getNombre()
                    + " No es mayor de edad"
                );
            }

            System.out.println("-----------------------------");
        }
    }
}