package entities;

public class PG extends Sequencia {

	public PG() {

	}

	public PG(Double a1, Double razao) {
		this.a1 = a1;
		this.razao = razao;
	}

	public PG(double am, int pm, double an, int pn) {
		double razao = Math.pow(am / an, 1.0 / (pm - pn));
		double a1 = am / Math.pow(razao, (pm - 1));
		this.a1 = a1;
		this.razao = razao;//TODO veriificar erro
		//System.out.println("Construtor utilizado");
		//System.out.printf("a1 = %.5f, r = %.5f\n", a1, razao);
	}

	@Override
	public double An(int pos) {
		return a1 * Math.pow(razao, pos - 1);
	}

	@Override
	public double soma(int quant) {
		return (a1 * (Math.pow(razao, quant) - 1)) / (razao - 1);
	}

	@Override
	public double soma(int posInicial, int posFinal) {
		int quant = posFinal - posInicial + 1;
		double ai = An(posInicial);
		return (ai * (Math.pow(razao, quant) - 1)) / (razao - 1);
	}
}
