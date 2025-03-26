
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class app {
	public static void main(String[] args) {
		
		double saldo = 1000.0;
		String tentarNovamente ="";
		
		Scanner scanner = new Scanner(System.in);
		scanner.useLocale(Locale.ENGLISH);
		
		System.out.println("CAIXA ELETRONICO");
		System.out.println("=================");
		do {
			try {
				sacar(scanner);
				
			} catch (ValorInvalidoException | InputMismatchException erro ) {
				System.out.println("[Erro:]"+erro.getMessage());
				scanner.nextLine(); // Limpa o buffer do Scanner
			}
			finally {
				System.out.println("Programa finalizado.!");
			}
		System.out.print("Deseja Continuar?[S/N]:");
		tentarNovamente = scanner.next();
					
		} while (tentarNovamente.equalsIgnoreCase("s"));
		scanner.close();
	}
	public static void sacar(Scanner scanner) throws ValorInvalidoException {
		double valorSaque = 0;
		double somaNotas = 0;
		double resultadoSaque = 0;
		int quantidadeNotas = 0;
		double nota = 10.0;
		
		System.out.print("Valor que deseja sacar:");
		valorSaque = scanner.nextDouble();
		/*
		 * scanner.nextLine(); // Limpa o buffer após a leitura do double
		 */		
		resultadoSaque = valorSaque % 10;
		
		if (resultadoSaque != 0) {
			throw new ValorInvalidoException("O valor solicitado deve ser um múltiplo de 10.");
		}
		for (double i = 10; i <= valorSaque; i += 10) {
			quantidadeNotas++;
		}
		System.out.printf("Valor do saque:%.2f\n",valorSaque);
		System.out.println("Sera necessario: " + quantidadeNotas + " notas de 10,00");
		
		for (int i = 1; i <= quantidadeNotas; i ++) {
			System.out.printf("Nota:%.2f\n",nota);
		}
	}
}
