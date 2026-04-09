package cuentas;

public class GestorTransacciones {
	Cuenta cuentaOrigen;
	Banco banco;

	public GestorTransacciones(Cuenta c) {
		this.cuentaOrigen = c;
	}

	public void ingresar(double cantidad) {
		
		if(cantidad <= 0) {
			System.out.println("Error, la cantidad a ingresar debe ser mayor a 0");
			return;
		}

		cuentaOrigen.setSaldo(cuentaOrigen.getSaldo() + cantidad);

		Movimiento m = new Movimiento("Ingreso en efectivo", cantidad);
		cuentaOrigen.cargarHistorial(m);
	}

	public void retirar(double cantidad) throws SaldoInsuficienteException, LimiteExcedidoException {

		if (cuentaOrigen.getSaldo() < cantidad) {

			throw new SaldoInsuficienteException("Saldo insuficiente!");

		} else if (cantidad > 1000) {

			throw new LimiteExcedidoException("Cantidad de retiro máxima permitida por dia 1000");
		} else {
			if(cantidad <= 0) {
				System.out.println("Error, la cantidad a ingresar debe ser mayor a 0");
				return;
			}
			cuentaOrigen.setSaldo(cuentaOrigen.getSaldo() - cantidad);
			Movimiento m = new Movimiento("Retiro de efectivo", cantidad);
			cuentaOrigen.cargarHistorial(m);
		}
	}

	public void transferir(Cuenta cuentaDestino, double cantidad)
			throws SaldoInsuficienteException {

		if(cantidad <= 0) {
			System.out.println("Error, la cantidad a ingresar debe ser mayor a 0");
			return;
		}
		if (cuentaOrigen.getSaldo() >= cantidad) {
			cuentaOrigen.setSaldo(cuentaOrigen.getSaldo() - cantidad);
			cuentaDestino.setSaldo(cuentaDestino.getSaldo() + cantidad);
			System.out.println("Transferencia realizada con exito\n");
			Movimiento transhecha = new Movimiento("Transferencia realizada", cantidad);
			Movimiento transRecibida = new Movimiento("Transferencia recibida", cantidad);
			cuentaOrigen.cargarHistorial(transhecha);
			cuentaDestino.cargarHistorial(transRecibida);

		} else if (cuentaOrigen.getSaldo() < cantidad) {

			throw new SaldoInsuficienteException("Saldo Insuficiente");

		} 
		

	}
}
