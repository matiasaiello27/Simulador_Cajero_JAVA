package cuentas;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		
		Cliente matias = new Cliente("36404945","Matias","Aiello",34,"Calle cruces bajas 52");
		Cliente gisel = new Cliente("x6964959f","Gisel", "Aiello",38, "Calle silencio 30");
		
		CuentaAhorro cuentaMatias = new CuentaAhorro("ES180180",1200, matias);
		CuentaCorriente cuentaGisel = new CuentaCorriente("ES123123",500, gisel);
		
		
		Banco santander = new Banco();
		santander.añadirCuenta(cuentaMatias);
		santander.añadirCuenta(cuentaGisel);
		
		Menu m = new Menu(santander);

		
		m.imprimirMenu();
		

	}

}
