import java.util.Scanner;

public class ContadorPalavras {
    public static void main(String[] args) {
        // Criar Scanner para entrada de dados
        Scanner scanner = new Scanner(System.in);

        // Solicitar frase ao usuário
        System.out.print("Digite uma frase: ");
        String frase = scanner.nextLine();

        // Usar split() para separar as palavras
        // Divide a frase usando espaços em branco como separador
        String[] palavras = frase.split("\\s+");

        // Remover espaços em branco no início e no final
        frase = frase.trim();

        // Variável para armazenar o total de palavras
        int totalPalavras = 0;

        // Laço de repetição para contar palavras
        for (String palavra : palavras) {
            // Ignorar strings vazias
            if (!palavra.isEmpty()) {
                totalPalavras++;
            }
        }

        // Exibir resultado
        System.out.println("Total de palavras: " + totalPalavras);

        // Fechar o scanner
        scanner.close();
    }
}