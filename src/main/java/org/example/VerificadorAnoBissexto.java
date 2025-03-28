import java.util.Scanner;

public class VerificadorAnoBissexto {
    private Scanner scanner;

    public VerificadorAnoBissexto() {
        scanner = new Scanner(System.in);
    }

    // Método para validar entrada do ano
    private int validarAno() {
        while (true) {
            try {
                System.out.print("Digite um ano para verificar (formato AAAA): ");
                String input = scanner.nextLine().trim();

                // Verifica se a entrada está vazia
                if (input.isEmpty()) {
                    System.out.println("Erro: O ano não pode estar em branco.");
                    continue;
                }

                int ano = Integer.parseInt(input);

                // Verifica se o ano é positivo
                if (ano > 0) {
                    return ano;
                } else {
                    System.out.println("Erro: Por favor, digite um ano válido (positivo).");
                }
            } catch (NumberFormatException e) {
                System.out.println("Erro: Por favor, digite um número inteiro válido.");
            }
        }
    }

    // Método para verificar se o ano é bissexto
    private boolean ehAnoBissexto(int ano) {
        // Regras para ano bissexto:
        // 1. Divisível por 4
        // 2. Não é divisível por 100, ou
        // 3. É divisível por 400
        return (ano % 4 == 0 && ano % 100 != 0) || (ano % 400 == 0);
    }

    // Método para processar a verificação do ano
    public void verificarAnoBissexto() {
        try {
            // Captura do ano
            int ano = validarAno();

            // Verificação se é ano bissexto
            boolean bissexto = ehAnoBissexto(ano);

            // Exibição dos resultados
            exibirResultado(ano, bissexto);

        } catch (Exception e) {
            System.out.println("Ocorreu um erro inesperado: " + e.getMessage());
        }
    }

    // Método para exibir resultado
    private void exibirResultado(int ano, boolean bissexto) {
        System.out.println("\n--- Verificação de Ano Bissexto ---");
        System.out.println("Ano Analisado: " + ano);

        // Mensagem personalizada
        if (bissexto) {
            System.out.println("🗓️ " + ano + " é um ANO BISSEXTO!");
            System.out.println("Detalhes:");
            System.out.println("- Divisível por 4");

            // Explicação adicional para anos divisíveis por 100
            if (ano % 100 == 0) {
                System.out.println("- Também divisível por 100, mas por 400");
            }
        } else {
            System.out.println("❌ " + ano + " NÃO é um ano bissexto.");
            System.out.println("Motivo:");
            if (ano % 4 != 0) {
                System.out.println("- Não é divisível por 4");
            } else if (ano % 100 == 0 && ano % 400 != 0) {
                System.out.println("- Divisível por 100, mas não por 400");
            }
        }

        // Informações adicionais sobre anos bissextos
        System.out.println("\nInformação: Anos bissextos ocorrem a cada 4 anos, " +
                "exceto anos divisíveis por 100 que não são divisíveis por 400.");
    }

    // Método main para iniciar o programa
    public static void main(String[] args) {
        VerificadorAnoBissexto verificador = new VerificadorAnoBissexto();
        verificador.verificarAnoBissexto();
    }

    // Método para fechar o Scanner
    public void fecharScanner() {
        if (scanner != null) {
            scanner.close();
        }
    }
}