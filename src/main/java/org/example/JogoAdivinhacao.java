import java.util.Random;
import java.util.Scanner;

public class JogoAdivinhacao {
    public static void main(String[] args) {
        // Criar objeto Scanner para entrada de dados
        Scanner scanner = new Scanner(System.in);

        // Criar objeto Random para gerar número aleatório
        Random random = new Random();

        // Gerar número secreto entre 1 e 100
        int numeroSecreto = random.nextInt(100) + 1;

        // Variáveis para controle do jogo
        int palpite;
        int tentativas = 0;

        // Mensagem inicial do jogo
        System.out.println("--- Jogo de Adivinhação ---");
        System.out.println("Tente adivinhar o número entre 1 e 100!");

        // Laço de repetição para múltiplas tentativas
        do {
            // Incrementar contador de tentativas
            tentativas++;

            // Solicitar palpite do usuário
            System.out.print("Digite seu palpite: ");
            palpite = scanner.nextInt();

            // Verificar se o palpite está correto
            if (palpite == numeroSecreto) {
                System.out.println("Parabéns! Você acertou o número " + numeroSecreto + " em " + tentativas + " tentativas!");
            } else if (palpite < numeroSecreto) {
                System.out.println("O número secreto é MAIOR que seu palpite.");
            } else {
                System.out.println("O número secreto é MENOR que seu palpite.");
            }

        } while (palpite != numeroSecreto);

        // Fechar o scanner
        scanner.close();
    }
}