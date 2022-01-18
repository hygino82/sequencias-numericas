package entities;

public abstract class Sequencia {
	protected Double a1;
	protected Double razao;
	
	public abstract double An(int pos);
	public abstract double soma(int quant);
	public abstract double soma(int posInicial, int posFinal);
	
	public Double getA1() {
		return a1;
	}
	
	public void setA1(Double a1) {
		this.a1 = a1;
	}
	
	public Double getRazao() {
		return razao;
	}
	
	public void setRazao(Double razao) {
		this.razao = razao;
	}
	
	@Override
	public String toString() {
		return "a1 = " + a1 + ", razao= " + razao;
	}
}
