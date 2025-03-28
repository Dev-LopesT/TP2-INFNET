import java.util.Scanner;
import java.text.DecimalFormat;

public class ConversorMoedas {
    // Taxas de câmbio fixas (valor de 1 real para cada moeda)
    private static final double TAXA_DOLAR = 0.20; // R$ 1 = $0.20
    private static final double TAXA_EURO = 0.18;  // R$ 1 = €0.18
    private static final double TAXA_LIBRA = 0.16; // R$ 1 = £0.16

    private Scanner scanner;
    private DecimalFormat formatador;

    public ConversorMoedas() {
        scanner = new Scanner(System.in);
        // Formatador para duas casas decimais
        formatador = new DecimalFormat("#0.00");
    }

    // Método para validar entrada de valor em reais
    private double validarValorReal() {
        while (true) {
            try {
                System.out.print("Digite o valor em reais (R$): ");
                String input = scanner.nextLine().trim().replace(",", ".");

                // Verifica se a entrada está vazia
                if (input.isEmpty()) {
                    System.out.println("Erro: O valor não pode estar em branco.");
                    continue;
                }

                double valor = Double.parseDouble(input);

                // Verifica se o valor é positivo
                if (valor > 0) {
                    return valor;
                } else {
                    System.out.println("Erro: Por favor, digite um valor positivo.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Erro: Por favor, digite um número válido.");
            }
        }
    }

    // Método para selecionar moeda de destino
    private String selecionarMoeda() {
        while (true) {
            System.out.println("\nSelecione a moeda de destino:");
            System.out.println("1 - Dólar (USD)");
            System.out.println("2 - Euro (EUR)");
            System.out.println("3 - Libra (GBP)");
            System.out.print("Digite o número da opção desejada: ");

            String escolha = scanner.nextLine().trim();

            switch (escolha) {
                case "1":
                    return "Dólar";
                case "2":
                    return "Euro";
                case "3":
                    return "Libra";
                default:
                    System.out.println("Opção inválida. Por favor, tente novamente.");
            }
        }
    }

    // Método para realizar a conversão de moeda
    public void converterMoeda() {
        try {
            // Captura do valor em reais
            double valorReal = validarValorReal();

            // Seleção da moeda de destino
            String moedaDestino = selecionarMoeda();

            // Realiza a conversão
            double valorConvertido = converterParaMoedaEscolhida(valorReal, moedaDestino);

            // Exibe o resultado
            exibirResultado(valorReal, valorConvertido, moedaDestino);

        } catch (Exception e) {
            System.out.println("Ocorreu um erro inesperado: " + e.getMessage());
        }
    }

    // Método para converter para a moeda escolhida
    private double converterParaMoedaEscolhida(double valorReal, String moedaDestino) {
        switch (moedaDestino) {
            case "Dólar":
                return valorReal * TAXA_DOLAR;
            case "Euro":
                return valorReal * TAXA_EURO;
            case "Libra":
                return valorReal * TAXA_LIBRA;
            default:
                throw new IllegalArgumentException("Moeda inválida");
        }
    }

    // Método para exibir o resultado da conversão
    private void exibirResultado(double valorReal, double valorConvertido, String moedaDestino) {
        System.out.println("\n--- Resultado da Conversão ---");
        System.out.println("Valor Original: R$ " + formatador.format(valorReal));

        // Símbolos das moedas
        String simboloMoeda = obterSimbolo(moedaDestino);

        System.out.println("Moeda de Destino: " + moedaDestino);
        System.out.println("Valor Convertido: " + simboloMoeda + " " + formatador.format(valorConvertido));
    }

    // Método para obter o símbolo da moeda
    private String obterSimbolo(String moedaDestino) {
        switch (moedaDestino) {
            case "Dólar":
                return "$";
            case "Euro":
                return "€";
            case "Libra":
                return "£";
            default:
                return "";
        }
    }

    // Método main para iniciar o programa
    public static void main(String[] args) {
        ConversorMoedas conversor = new ConversorMoedas();
        conversor.converterMoeda();
    }

    // Método para fechar o Scanner
    public void fecharScanner() {
        if (scanner != null) {
            scanner.close();
        }
    }
}