class Calculadora {
    public double sumar(double a, double b) {
        return a + b;
    }

    public double restar(double a, double b) {
        return a - b;
    }

    public double multiplicar(double a, double b) {
        return a * b;
    }

    public double dividir(double a, double b) {
        if (b == 0) {
            throw new IllegalArgumentException("No se puede dividir por cero.");
        }
        return a / b;
    }

    public void mostrarResultado(double resultado) {
        System.out.println("El resultado es: " + resultado);
    }
}

public class Ejercicio3 {
    public static void main(String[] args) {
        Calculadora calculadora = new Calculadora();

        double a = 10;
        double b = 5;

        double suma = calculadora.sumar(a, b);
        calculadora.mostrarResultado(suma);

        double resta = calculadora.restar(a, b);
        calculadora.mostrarResultado(resta);

        double multiplicacion = calculadora.multiplicar(a, b);
        calculadora.mostrarResultado(multiplicacion);

        double division = calculadora.dividir(a, b);
        calculadora.mostrarResultado(division);
    }
}