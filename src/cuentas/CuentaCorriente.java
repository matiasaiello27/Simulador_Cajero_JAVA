package cuentas;

public class CuentaCorriente extends Cuenta {

	private static final double COMISIONMANTENIMIENTO = 0.04;

	private GestorTransacciones g;
	
	public CuentaCorriente(String iban, double saldo, Cliente c) {
		super(iban, saldo, c);
		this.g = new GestorTransacciones(this);
	}

	@Override
	public void ingresar(double cantidad) {
		g.ingresar(cantidad);

	}

	@Override
	public void retirar(double cantidad) throws SaldoInsuficienteException, LimiteExcedidoException {
		g.retirar(cantidad);

	}

	@Override
	public void transferir(Cuenta cuentaDestino, double cantidad) throws SaldoInsuficienteException, CuentaInexistenteException {
		g.transferir(cuentaDestino, cantidad);
	}
	
	public double aplicarComision() {
		return saldo = saldo - (saldo * COMISIONMANTENIMIENTO);
	}

}
