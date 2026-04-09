package cuentas;

import java.util.Scanner;

public class Menu {

	Scanner sc = new Scanner(System.in);

	private Banco b;
	private Cuenta c;

	public Menu(Banco bancoDeFuera) {
		this.b = bancoDeFuera;

	}

	public void imprimirMenu() {
		boolean cajeroEncendido = true;

		while (cajeroEncendido) {
			System.out.println("----------Bienvenido a Bancos Capitolio----------\n\n");

			do {

				System.out.println("Introduzca su IBAN para comenzar: ");
				String ibanIntroducido = sc.nextLine();
				this.c = b.buscarCuenta(ibanIntroducido);
				if (this.c == null) {
					System.out.println("El IBAN no existe!!!");
				}
			} while (this.c == null);

			boolean salirSesion = false;

			while (!salirSesion) {
				System.out.println("\nBienvenido de nuevo " + c.cli.getNombre() + " " + c.cli.getApellido()
						+ "\n****************MENU****************\n");
				System.out.println("Seleccione la operación que desea realizar\n"
						+ "[1]DEPOSITAR\n[2]RETIRAR\n[3]TRANSFERIR\n[4]MOSTAR SALDO\n[5]MOSTRAR TODOS SUS DATOS"
						+ "\n[6]MOSTRAR MOVIMIENTOS" + "\n[7]SALIR");
				int opcionElegida = sc.nextInt();
				sc.nextLine();

				switch (opcionElegida) {

				case 1:
					System.out.println("Ingrese una cantidad");
					double cantidadIngreso = sc.nextDouble();
					sc.nextLine();
					c.ingresar(cantidadIngreso);
					System.out.println("Su saldo es: " + c.getSaldo());
					System.out.println("Presione una tecla para continuar");
					String continuar = sc.nextLine();
					break;
				case 2:
					System.out.println("Ingrese una cantidad");
					double cantidadRetiro = sc.nextDouble();
					sc.nextLine();
					try {
						c.retirar(cantidadRetiro);
					} catch (SaldoInsuficienteException | LimiteExcedidoException m) {
						System.out.println(m.getMessage());
					}

					System.out.println("Su saldo es: " + c.getSaldo());
					System.out.println("Presione una tecla para continuar");
					continuar = sc.nextLine();
					break;
				case 3:
					System.out.println("Indique la cuenta de destino de su transferencia");
					String cuentaDestino = sc.nextLine();
					Cuenta cuentaObjetoDestino = b.buscarCuenta(cuentaDestino);

					if (b.buscarCuenta(cuentaDestino) != null) {

						if (b.buscarCuenta(cuentaDestino).equals(this.c)) {

							System.out.println("No puede realizarse una transferencia a su propia cuenta.");
							System.out.println("Presione una tecla para continuar");
							continuar = sc.nextLine();

						} else {
							System.out.println("Introduzca la cantidad a transferir: ");
							double cantidad = sc.nextDouble();

							try {
								c.transferir(cuentaObjetoDestino, cantidad);
							} catch (SaldoInsuficienteException | CuentaInexistenteException m) {
								System.out.println(m.getMessage());

								System.out.println("Su saldo es: " + c.getSaldo());
								System.out.println("Presione una tecla para continuar");
								continuar = sc.nextLine();
							}
						}
					}

					System.out.println("Presione una tecla para continuar");
					continuar = sc.nextLine();
					break;
				case 4:
					System.out.println("Su saldo actual es: " + c.getSaldo());
					System.out.println("Presione una tecla para continuar\n");
					continuar = sc.nextLine();
					break;
				case 5:
					System.out.println(c.toString());
					System.out.println("Presione una tecla para continuar");
					continuar = sc.nextLine();
					break;
				case 6:
					System.out.println("----------MOVIMIENTOS----------");
					if (c.getHistorial() == null || c.getHistorial().isEmpty()) {
						System.out.println("No hay movimientos para mostrar");
					}
					for (Movimiento m : c.getHistorial()) {

						System.out.println(m);
						System.out.println("************************\n");

					}
					System.out.println("Presione una tecla para continuar");
					continuar = sc.nextLine();
					break;
				case 7:
					salirSesion = true;
					System.out.println("Gracias por usar nuestros servivios!!\nHasta pronto!!!");
					break;
				default:
					System.out.println("Opción Incorrecta, pruebe de nuevo");
				}
			}
			if (salirSesion) {

				System.out.println("¿Que desea hacer ahora?\n");
				System.out.println("[1]VOLVER A ENTRAR");
				System.out.println("[2]QUITAR TARJETA");
				int opcionElegidaFinal = sc.nextInt();
				sc.nextLine();

				if (opcionElegidaFinal == 1) {
					this.c = null;
				} else {
					salirSesion = false;
					System.out.println("Gracias por su visita!!\nHasta pronto!!!");

				}

			}

		}

		sc.close();
	}

}
