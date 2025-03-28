import java.util.Scanner;

public class CalculadoraNotas {
    private Scanner scanner;

    public CalculadoraNotas() {
        scanner = new Scanner(System.in);
    }

    // Método para validar entrada de notas
    private double validarNota(int bimestre) {
        while (true) {
            try {
                System.out.printf("Digite a nota do %dº bimestre: ", bimestre);
                String input = scanner.nextLine().trim();

                // Verifica se a entrada está vazia
                if (input.isEmpty()) {
                    System.out.println("Erro: A nota não pode estar em branco.");
                    continue;
                }

                double nota = Double.parseDouble(input);

                // Verifica se a nota está no intervalo válido
                if (nota >= 0 && nota <= 10) {
                    return nota;
                } else {
                    System.out.println("Erro: Nota inválida. Por favor, digite uma nota entre 0 e 10.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Erro: Por favor, digite um número válido para a nota.");
            }
        }
    }

    // Método para calcular média e status do aluno
    public void calcularMediaNotas() {
        try {
            // Vetor para armazenar as notas
            double[] notas = new double[4];

            // Captura das notas com validação
            for (int i = 0; i < notas.length; i++) {
                notas[i] = validarNota(i + 1);
            }

            // Cálculo da média
            double media = calcularMedia(notas);

            // Exibição dos resultados
            exibirResultado(notas, media);

        } catch (Exception e) {
            System.out.println("Ocorreu um erro inesperado: " + e.getMessage());
        }
    }

    // Método para calcular média
    private double calcularMedia(double[] notas) {
        double soma = 0;
        for (double nota : notas) {
            soma += nota;
        }
        return soma / notas.length;
    }

    // Método para exibir resultado
    private void exibirResultado(double[] notas, double media) {
        System.out.println("\n--- Boletim Escolar ---");

        // Exibição das notas individuais
        for (int i = 0; i < notas.length; i++) {
            System.out.printf("%dº Bimestre: %.2f\n", i + 1, notas[i]);
        }

        // Formatação da média com duas casas decimais
        System.out.printf("\nMédia Final: %.2f\n", media);

        // Verificação da situação do aluno
        System.out.print("Situação: ");
        if (media >= 7) {
            System.out.println("APROVADO ✅");
            System.out.println("Parabéns! Você foi aprovado com sucesso!");
        } else if (media >= 5 && media < 7) {
            System.out.println("RECUPERAÇÃO ⚠️");
            System.out.println("Você está em recuperação. Estude mais para melhorar sua nota!");
        } else {
            System.out.println("REPROVADO ❌");
            System.out.println("Infelizmente você foi reprovado. Não desista, estude mais!");
        }
    }

    // Método main para iniciar o programa
    public static void main(String[] args) {
        CalculadoraNotas calculadora = new CalculadoraNotas();
        calculadora.calcularMediaNotas();
    }

    // Método para fechar o Scanner
    public void fecharScanner() {
        if (scanner != null) {
            scanner.close();
        }
    }
}