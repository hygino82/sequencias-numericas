package entities;

public class PA extends Sequencia {

	public PA() {
	}

	public PA(Double a1, Double razao) {
		this.a1 = a1;
		this.razao = razao;
	}

	public PA(double am, int pm, double an, int pn) {
		double razao = (am - an) / (pm - pn);
		double a1 = am - (pm - 1) * razao;
		this.a1 = a1;
		this.razao = razao;
	}

	@Override
	public double An(int pos) {
		return a1 + (pos - 1) * razao;
	}

	@Override
	public double soma(int quant) {
		return (a1 + An(quant)) * quant / 2;
	}

	@Override
	public double soma(int posInicial, int posFinal) {
		int n = posFinal - posInicial + 1;
		double soma = (An(posInicial) + An(posFinal)) * n / 2;
		return soma;
	}
}
