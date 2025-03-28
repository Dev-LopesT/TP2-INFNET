import java.util.Scanner;

public class ClassificadorTriangulos {
    public static void main(String[] args) {
        // Criar Scanner para entrada de dados
        Scanner scanner = new Scanner(System.in);

        // Solicitar comprimentos dos lados
        System.out.println("--- Classificador de Triângulos ---");
        System.out.print("Digite o comprimento do primeiro lado: ");
        double lado1 = scanner.nextDouble();

        System.out.print("Digite o comprimento do segundo lado: ");
        double lado2 = scanner.nextDouble();

        System.out.print("Digite o comprimento do terceiro lado: ");
        double lado3 = scanner.nextDouble();

        // Verificar se é um triângulo válido
        if (ehTrianguloValido(lado1, lado2, lado3)) {
            // Classificar o tipo de triângulo
            String tipoTriangulo = classificarTriangulo(lado1, lado2, lado3);
            System.out.println("Tipo de Triângulo: " + tipoTriangulo);
        } else {
            System.out.println("Estes comprimentos NÃO formam um triângulo válido!");
        }

        // Fechar o scanner
        scanner.close();
    }

    // Método para verificar se os lados formam um triângulo válido
    public static boolean ehTrianguloValido(double a, double b, double c) {
        // Condições para um triângulo ser válido (desigualdade triangular)
        return (a + b > c) && (a + c > b) && (b + c > a) &&
                (a > 0) && (b > 0) && (c > 0);
    }

    // Método para classificar o tipo de triângulo
    public static String classificarTriangulo(double lado1, double lado2, double lado3) {
        // Verificar se todos os lados são iguais (equilátero)
        if (lado1 == lado2 && lado2 == lado3) {
            return "Equilátero";
        }

        // Verificar se dois lados são iguais (isósceles)
        if (lado1 == lado2 || lado2 == lado3 || lado1 == lado3) {
            return "Isósceles";
        }

        // Se nenhuma das condições anteriores, é escaleno
        return "Escaleno";
    }
}