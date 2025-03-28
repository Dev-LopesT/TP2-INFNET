import java.util.Scanner;
import java.text.DecimalFormat;

public class CalculadoraImpostoRenda {
    public static void main(String[] args) {
        // Criação do objeto Scanner para entrada de dados
        Scanner scanner = new Scanner(System.in);

        // Criação do objeto DecimalFormat para formatar valores monetários
        DecimalFormat df = new DecimalFormat("#,##0.00");

        // Solicitar salário bruto anual
        System.out.print("Digite seu salário bruto anual: R$ ");
        double salarioBrutoAnual = scanner.nextDouble();

        // Variável para armazenar o imposto a pagar
        double impostoDevido = calcularImpostoRenda(salarioBrutoAnual);

        // Calcular salário líquido
        double salarioLiquido = salarioBrutoAnual - impostoDevido;

        // Exibir resultados
        System.out.println("\n--- Cálculo do Imposto de Renda ---");
        System.out.println("Salário Bruto Anual: R$ " + df.format(salarioBrutoAnual));
        System.out.println("Imposto a Pagar: R$ " + df.format(impostoDevido));
        System.out.println("Salário Líquido: R$ " + df.format(salarioLiquido));

        // Fechar o scanner
        scanner.close();
    }

    // Método para calcular o imposto de renda baseado em faixas progressivas
    public static double calcularImpostoRenda(double salarioBrutoAnual) {
        double impostoDevido = 0.0;

        // Definição das faixas de imposto de renda (valores de 2024)
        if (salarioBrutoAnual <= 22847.76) {
            // Isento
            impostoDevido = 0.0;
        } else if (salarioBrutoAnual <= 33919.80) {
            // Faixa 1: 7.5%
            impostoDevido = (salarioBrutoAnual - 22847.76) * 0.075;
        } else if (salarioBrutoAnual <= 45012.60) {
            // Faixa 2: 15%
            impostoDevido = (33919.80 - 22847.76) * 0.075 +
                    (salarioBrutoAnual - 33919.80) * 0.15;
        } else if (salarioBrutoAnual <= 55976.16) {
            // Faixa 3: 22.5%
            impostoDevido = (33919.80 - 22847.76) * 0.075 +
                    (45012.60 - 33919.80) * 0.15 +
                    (salarioBrutoAnual - 45012.60) * 0.225;
        } else {
            // Faixa 4: 27.5%
            impostoDevido = (33919.80 - 22847.76) * 0.075 +
                    (45012.60 - 33919.80) * 0.15 +
                    (55976.16 - 45012.60) * 0.225 +
                    (salarioBrutoAnual - 55976.16) * 0.275;
        }

        return impostoDevido;
    }
}