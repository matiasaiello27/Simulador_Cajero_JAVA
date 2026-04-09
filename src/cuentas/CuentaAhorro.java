package cuentas;

public class CuentaAhorro extends Cuenta {

	private static final double TIPO_INTERES = 0.02;

	private GestorTransacciones g;

	public CuentaAhorro(String iban, double saldo, Cliente c) {
		super(iban, saldo, c);
		this.g = new GestorTransacciones(this);
	}

	public CuentaAhorro() {

	}

	public double getTipoInteres() {
		return TIPO_INTERES;
	}

	@Override
	public void retirar(double cantidad) throws SaldoInsuficienteException, LimiteExcedidoException {
		g.retirar(cantidad);

	}

	@Override
	public void ingresar(double cantidad) {

		g.ingresar(cantidad);
	}

	@Override
	public void transferir(Cuenta cuentaDestino, double cantidad) throws SaldoInsuficienteException, CuentaInexistenteException {
		g.transferir(cuentaDestino, cantidad);
	}

	public double aplicarIntereses() {
		return saldo = saldo * TIPO_INTERES;
	}

}
