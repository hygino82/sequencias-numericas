package application;

import java.util.Locale;

import entities.PA;

public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		System.out.println("SEQUÊNCIAS NUMÉRICAS P.A.");
		PA p1 = new PA(5.0, 2, 11.0, 4);
		System.out.println(p1);

		for (int i = 1; i <= 4; i++) {
			System.out.printf("A[%d] = %f\n", i, p1.An(i));
		}

		double soma = p1.soma(4);// soma os 4 primeiros elementos
		System.out.println("soma = " + soma);

		double somaParcial = p1.soma(2, 5);
		System.out.println("soma_parcial = " + somaParcial);
	}
}
