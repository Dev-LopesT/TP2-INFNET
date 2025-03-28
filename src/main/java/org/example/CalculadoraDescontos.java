import java.util.Scanner;
import java.text.DecimalFormat;

public class CalculadoraDescontos {
    private Scanner scanner;
    private DecimalFormat formatador;

    public CalculadoraDescontos() {
        scanner = new Scanner(System.in);
        formatador = new DecimalFormat("#0.00");
    }

    // Método para validar entrada do valor da compra
    private double validarValorCompra() {
        while (true) {
            try {
                System.out.print("Digite o valor total da compra: R$ ");
                String input = scanner.nextLine().trim().replace(",", ".");

                // Verifica se a entrada está vazia
                if (input.isEmpty()) {
                    System.out.println("Erro: O valor não pode estar em branco.");
                    continue;
                }

                double valorCompra = Double.parseDouble(input);

                // Verifica se o valor é positivo
                if (valorCompra > 0) {
                    return valorCompra;
                } else {
                    System.out.println("Erro: Por favor, digite um valor positivo.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Erro: Por favor, digite um número válido.");
            }
        }
    }

    // Método para calcular desconto
    private double calcularDesconto(double valorCompra) {
        double percentualDesconto;

        if (valorCompra > 1000) {
            percentualDesconto = 0.10; // 10% de desconto
        } else if (valorCompra >= 500) {
            percentualDesconto = 0.05; // 5% de desconto
        } else {
            percentualDesconto = 0; // Sem desconto
        }

        return valorCompra * percentualDesconto;
    }

    // Método para processar a compra
    public void processarCompra() {
        try {
            // Captura do valor da compra
            double valorCompra = validarValorCompra();

            // Cálculo do desconto
            double valorDesconto = calcularDesconto(valorCompra);

            // Cálculo do valor final
            double valorFinal = valorCompra - valorDesconto;

            // Exibição dos resultados
            exibirResultado(valorCompra, valorDesconto, valorFinal);

        } catch (Exception e) {
            System.out.println("Ocorreu um erro inesperado: " + e.getMessage());
        }
    }

    // Método para exibir resultado
    private void exibirResultado(double valorCompra, double valorDesconto, double valorFinal) {
        System.out.println("\n--- Resultado da Compra ---");
        System.out.println("Valor Original: R$ " + formatador.format(valorCompra));

        // Determina a faixa de desconto
        String faixaDesconto;
        if (valorCompra > 1000) {
            faixaDesconto = "10% (Compras acima de R$ 1.000)";
        } else if (valorCompra >= 500) {
            faixaDesconto = "5% (Compras entre R$ 500 e R$ 1.000)";
        } else {
            faixaDesconto = "0% (Compras abaixo de R$ 500)";
        }

        System.out.println("Faixa de Desconto: " + faixaDesconto);
        System.out.println("Valor do Desconto: R$ " + formatador.format(valorDesconto));
        System.out.println("Valor Final: R$ " + formatador.format(valorFinal));

        // Mensagem adicional
        if (valorDesconto > 0) {
            System.out.println("\nParabéns! Você obteve um desconto.");
        }
    }

    // Método main para iniciar o programa
    public static void main(String[] args) {
        CalculadoraDescontos calculadora = new CalculadoraDescontos();
        calculadora.processarCompra();
    }

    // Método para fechar o Scanner
    public void fecharScanner() {
        if (scanner != null) {
            scanner.close();
        }
    }
}