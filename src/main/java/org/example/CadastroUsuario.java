import java.util.Scanner;

public class CadastroUsuario {
    private Scanner scanner;

    public CadastroUsuario() {
        scanner = new Scanner(System.in);
    }

    // Método para validar entrada de string
    private String validarEntradaTexto(String mensagem) {
        String entrada;
        while (true) {
            System.out.print(mensagem);
            entrada = scanner.nextLine().trim();

            if (!entrada.isEmpty()) {
                return entrada;
            }

            System.out.println("Erro: A entrada não pode estar em branco. Por favor, tente novamente.");
        }
    }

    // Método para validar entrada de idade
    private int validarIdade() {
        while (true) {
            try {
                System.out.print("Digite sua idade: ");
                String input = scanner.nextLine().trim();

                // Verifica se a entrada está vazia
                if (input.isEmpty()) {
                    System.out.println("Erro: A idade não pode estar em branco.");
                    continue;
                }

                int idade = Integer.parseInt(input);

                // Verifica se a idade é válida
                if (idade > 0 && idade < 150) {
                    return idade;
                } else {
                    System.out.println("Erro: Idade inválida. Por favor, digite uma idade entre 0 e 150.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Erro: Por favor, digite um número válido para a idade.");
            }
        }
    }

    // Método para capturar dados do usuário
    public void capturarDados() {
        try {
            // Captura de dados com validação
            String nomeCompleto = validarEntradaTexto("Digite seu nome completo: ");
            int idade = validarIdade();
            String nomeMae = validarEntradaTexto("Digite o nome da sua mãe: ");
            String nomePai = validarEntradaTexto("Digite o nome do seu pai: ");

            // Exibição das informações
            exibirInformacoes(nomeCompleto, idade, nomeMae, nomePai);

            // Análise do tamanho dos nomes
            compararTamanhoNomes(nomeCompleto, nomeMae, nomePai);

        } catch (Exception e) {
            System.out.println("Ocorreu um erro inesperado: " + e.getMessage());
        }
    }

    // Método para exibir informações
    private void exibirInformacoes(String nomeCompleto, int idade, String nomeMae, String nomePai) {
        System.out.println("\n--- Informações Cadastradas ---");
        System.out.println("Nome Completo: " + nomeCompleto);
        System.out.println("Idade: " + idade + " anos");
        System.out.println("Nome da Mãe: " + nomeMae);
        System.out.println("Nome do Pai: " + nomePai);
    }

    // Método para comparar tamanho dos nomes
    private void compararTamanhoNomes(String nomeCompleto, String nomeMae, String nomePai) {
        System.out.println("\n--- Análise de Nomes ---");
        if (nomeCompleto.length() > nomeMae.length() && nomeCompleto.length() > nomePai.length()) {
            System.out.println("Seu nome é o mais longo entre os três!");
        } else if (nomeMae.length() > nomeCompleto.length() && nomeMae.length() > nomePai.length()) {
            System.out.println("O nome da sua mãe é o mais longo!");
        } else if (nomePai.length() > nomeCompleto.length() && nomePai.length() > nomeMae.length()) {
            System.out.println("O nome do seu pai é o mais longo!");
        } else {
            System.out.println("Há nomes com o mesmo comprimento!");
        }
    }

    // Método main para iniciar o programa
    public static void main(String[] args) {
        CadastroUsuario cadastro = new CadastroUsuario();
        cadastro.capturarDados();
    }

    // Método para fechar o Scanner
    public void fecharScanner() {
        if (scanner != null) {
            scanner.close();
        }
    }
}