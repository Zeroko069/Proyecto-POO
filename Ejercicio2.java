import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Empleado {
    protected String nombre;
    protected long salario;

    public Empleado(String nombre, long salario) {
        this.nombre = nombre;
        this.salario = salario;
    }

    public String getNombre() {
        return nombre;
    }

    public long getSalario() {
        return salario;
    }

    public long calcularSalario() {
        return salario;
    }
}

class EmpleadoTiempoCompleto extends Empleado {
    private long bonificacion;

    public EmpleadoTiempoCompleto(String nombre, long salario, long bonificacion) {
        super(nombre, salario);
        this.bonificacion = bonificacion;
    }

    public long getBonificacion() {
        return bonificacion;
    }

    @Override
    public long calcularSalario() {
        // Cumple la regla exacta: salario + bonificación
        return salario + bonificacion; 
    }
}

class EmpleadoPorHoras extends Empleado {
    private int horasTrabajadas;
    private long valorHora;

    public EmpleadoPorHoras(String nombre, int horasTrabajadas, long valorHora) {
        super(nombre, 0); // No requiere salario base inicial
        this.horasTrabajadas = horasTrabajadas;
        this.valorHora = valorHora;
    }

    public int getHorasTrabajadas() {
        return horasTrabajadas;
    }

    public long getValorHora() {
        return valorHora;
    }

    @Override
    public long calcularSalario() {
        // Cumple la regla exacta: horasTrabajadas * valorHora
        return horasTrabajadas * valorHora;
    }
}

public class Ejercicio2 {
    public static void main(String[] args) {
        List<Empleado> empleados = new ArrayList<>();
        Random random = new Random();
        String[] nombres = {"Juan", "María", "Pedro", "Ana", "Luis", "Sofía", "Carlos", "Lucía", "Jorge", "Valentina"};

        for (int i = 0; i < 10; i++) {
            int tipoEmpleado = random.nextInt(2);

            if (tipoEmpleado == 0) {
                long salarioBase = (random.nextInt(10) + 1) * 200000L;
                long bonificacion = (random.nextInt(6) + 1) * 100000L;
                empleados.add(new EmpleadoTiempoCompleto(nombres[i], salarioBase, bonificacion));
            } else {
                int horasTrabajadas = random.nextInt(41) + 20;
                long valorHora = (random.nextInt(6) + 1) * 10000L;
                empleados.add(new EmpleadoPorHoras(nombres[i], horasTrabajadas, valorHora));
            }
        }

        // Formato de salida similar al enunciado
        for (int i = 0; i < empleados.size(); i++) {
            Empleado e = empleados.get(i);
            String salarioFormateado = String.format("%,d", e.calcularSalario());

            if (e instanceof EmpleadoPorHoras) {
                EmpleadoPorHoras eh = (EmpleadoPorHoras) e;
                System.out.println("Empleado " + (i + 1) + ": \"" + e.getNombre() + "\", Salario Actual: \"" 
                        + salarioFormateado + "\", Cantidad horas trabajadas: " 
                        + eh.getHorasTrabajadas() + ". Valor de la hora: " + eh.getValorHora());
            } else {
                System.out.println("Empleado " + (i + 1) + ": \"" + e.getNombre() + "\", Salario Actual: \"" 
                        + salarioFormateado + "\"");
            }
        }
    }
}