package cuentas;

import java.util.ArrayList;

public abstract class Cuenta {
	protected String iban;
	protected double saldo;
	protected Cliente cli;
	protected ArrayList<Movimiento> historial;
	
	
	public Cuenta(String iban, double saldo, Cliente c) {
		this.iban = iban;
		this.saldo = saldo;
		this.cli = c;
		this.historial = new ArrayList<>();
		
	}
	
	public void cargarHistorial(Movimiento movimiento) {
		historial.add(movimiento);
	}
	
	public Cuenta() {
		
	}

	public String getIban() {
		return iban;
	}

	public void setIban(String iban) {
		this.iban = iban;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public Cliente getC() {
		return cli;
	}

	public void setC(Cliente c) {
		this.cli = c;
	}
	
	public ArrayList<Movimiento> getHistorial() {
		return historial;
	}
	
	public abstract void retirar(double cantidad) throws SaldoInsuficienteException, LimiteExcedidoException;
	public abstract void ingresar(double cantidad);
	public abstract void transferir(Cuenta cuentaDestino, double cantidad) throws SaldoInsuficienteException, CuentaInexistenteException;

	@Override
	public String toString() {
		return "Numero de cuenta: "+this.iban+"\nNombre y apellido de cliente: "+cli.getNombre()+" "+cli.getApellido()+"\nSaldo: "+this.saldo+"\n\n";
	}
	
	
	
	
}
