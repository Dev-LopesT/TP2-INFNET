import java.util.Scanner;

public class ValidadorSenha {
    public static void main(String[] args) {
        // Criar Scanner para entrada de dados
        Scanner scanner = new Scanner(System.in);

        // Variável para armazenar a senha original
        String senhaCorreta;

        // Solicitar primeira senha
        System.out.print("Cadastre sua senha: ");
        senhaCorreta = scanner.nextLine();

        // Variável para armazenar tentativa de senha
        String tentativaSenha;

        // Laço de repetição para validar a senha
        do {
            // Solicitar nova tentativa de senha
            System.out.print("Confirme sua senha: ");
            tentativaSenha = scanner.nextLine();

            // Verificar se a senha está incorreta
            if (!tentativaSenha.equals(senhaCorreta)) {
                System.out.println("Senha incorreta. Tente novamente.");
            }

        } while (!tentativaSenha.equals(senhaCorreta));

        // Mensagem de sucesso ao validar a senha
        System.out.println("Senha cadastrada com sucesso!");

        // Fechar o scanner
        scanner.close();
    }
}