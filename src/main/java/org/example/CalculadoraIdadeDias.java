import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class CalculadoraIdadeDias {
    private Scanner scanner;

    public CalculadoraIdadeDias() {
        scanner = new Scanner(System.in);
    }

    // Método para validar e converter data de nascimento
    private LocalDate validarDataNascimento() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        while (true) {
            try {
                System.out.print("Digite sua data de nascimento (dd/mm/aaaa): ");
                String input = scanner.nextLine().trim();

                // Verifica se a entrada está vazia
                if (input.isEmpty()) {
                    System.out.println("Erro: A data não pode estar em branco.");
                    continue;
                }

                // Converte a string para LocalDate
                LocalDate dataNascimento = LocalDate.parse(input, formatter);

                // Verifica se a data não é no futuro
                if (dataNascimento.isAfter(LocalDate.now())) {
                    System.out.println("Erro: Data de nascimento não pode ser no futuro.");
                    continue;
                }

                return dataNascimento;

            } catch (DateTimeParseException e) {
                System.out.println("Erro: Data inválida. Use o formato dd/mm/aaaa.");
            }
        }
    }

    // Método para calcular dias de vida
    public void calcularIdadeEmDias() {
        try {
            // Captura da data de nascimento
            LocalDate dataNascimento = validarDataNascimento();

            // Cálculo da idade
            LocalDate dataAtual = LocalDate.now();

            // Cálculo de dias de vida
            long diasDeVida = calcularTotalDias(dataNascimento, dataAtual);

            // Exibir resultados
            exibirResultado(dataNascimento, dataAtual, diasDeVida);

        } catch (Exception e) {
            System.out.println("Ocorreu um erro inesperado: " + e.getMessage());
        }
    }

    // Método para calcular total de dias considerando anos bissextos
    private long calcularTotalDias(LocalDate inicio, LocalDate fim) {
        // Período entre as datas
        Period periodo = Period.between(inicio, fim);

        // Calcula o total de dias
        long totalDias = 0;

        // Itera ano por ano para considerar anos bissextos
        LocalDate dataAtual = inicio;
        while (dataAtual.isBefore(fim)) {
            totalDias++;
            dataAtual = dataAtual.plusDays(1);
        }

        return totalDias;
    }

    // Método para exibir resultado
    private void exibirResultado(LocalDate dataNascimento, LocalDate dataAtual, long diasDeVida) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("\n--- Calculadora de Idade em Dias ---");
        System.out.println("Data de Nascimento: " + dataNascimento.format(formatter));
        System.out.println("Data Atual: " + dataAtual.format(formatter));

        // Cálculo da idade em anos, meses e dias
        Period idade = Period.between(dataNascimento, dataAtual);

        System.out.println("\nIdade Atual:");
        System.out.println("Anos: " + idade.getYears());
        System.out.println("Meses: " + idade.getMonths());
        System.out.println("Dias: " + idade.getDays());

        System.out.println("\nTotal de Dias Vividos: " + diasDeVida + " dias");
    }

    // Método main para iniciar o programa
    public static void main(String[] args) {
        CalculadoraIdadeDias calculadora = new CalculadoraIdadeDias();
        calculadora.calcularIdadeEmDias();
    }

    // Método para fechar o Scanner
    public void fecharScanner() {
        if (scanner != null) {
            scanner.close();
        }
    }
}