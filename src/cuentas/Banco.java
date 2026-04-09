package cuentas;

import java.util.ArrayList;

public class Banco {
	
	private ArrayList<Cuenta> listaCuentas;
	
	public Banco() {
		this.listaCuentas = new ArrayList<>();
	}
	
	public void añadirCuenta(Cuenta c) {
		this.listaCuentas.add(c);
	}
	
	
	
	public ArrayList<Cuenta> getListaCuentas() {
		return listaCuentas;
	}

	

	public Cuenta buscarCuenta(String ibanBuscar) {
		for(Cuenta c : listaCuentas) {
			if(c.getIban().equalsIgnoreCase(ibanBuscar)) {
				return c;
			}
			
		}
		return null;
	}
}
