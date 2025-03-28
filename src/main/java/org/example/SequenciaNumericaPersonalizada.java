import java.util.Scanner;

public class SequenciaNumericaPersonalizada {
    public static void main(String[] args) {
        // Criar Scanner para entrada de dados
        Scanner scanner = new Scanner(System.in);

        // Solicitar valor inicial
        System.out.print("Digite o valor inicial da sequência: ");
        int valorInicial = scanner.nextInt();

        // Solicitar incremento
        System.out.print("Digite o incremento: ");
        int incremento = scanner.nextInt();

        // Variável para armazenar o valor atual da sequência
        int valorAtual = valorInicial;

        // Imprimir cabeçalho da sequência
        System.out.println("\nSequência Numérica:");

        // Flag para controlar a primeira iteração (para formatação de vírgulas)
        boolean primeiroNumero = true;

        // Laço de repetição para gerar a sequência
        while (valorAtual <= 100) {
            // Imprimir número com formatação
            if (primeiroNumero) {
                System.out.print(valorAtual);
                primeiroNumero = false;
            } else {
                System.out.print(", " + valorAtual);
            }

            // Atualizar valor atual com o incremento
            valorAtual += incremento;
        }

        // Fechar o scanner
        scanner.close();
    }
}