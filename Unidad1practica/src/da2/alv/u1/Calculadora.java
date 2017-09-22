package da2.alv.u1;

import java.io.Serializable;

public class Calculadora implements Serializable {
	private double valueA;
	private double resultado;
	
	
	public Calculadora(double valueA, double resultado) {
		super();
		this.valueA = valueA;
		this.resultado = resultado;
	}
	

	public Calculadora() {
		super();
		// TODO Auto-generated constructor stub
	}


	public double getValueA() {
		return valueA;
	}
	public void setValueA(double valueA) {
		this.valueA = valueA;
	}
	public double getResultado() {
		return (valueA +2)*(3*valueA-4);
	}
	public void setResultado(double resultado) {
		this.resultado = resultado;
	}
	
	
	@Override
	public String toString() {
		return "Calculadora [valueA=" + valueA + ", resultado=" + resultado + "]";
	}

	
	
}
