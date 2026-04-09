package cuentas;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Movimiento {
	private LocalDateTime fechaYHora;
	private String concepto;
	private double cantidad;
	
	public Movimiento(String concepto, double cantidad) {
		this.fechaYHora = LocalDateTime.now();
		this.concepto = concepto;
		this.cantidad = cantidad;
	}
	
	public Movimiento() {
		
	}
	
	@Override
	public String toString() {
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		String fechaBonita = this.fechaYHora.format(formato);
		return "Fecha y Hora: "+fechaBonita+"\nMovimiento: "+concepto+"\nCantidad: "+cantidad;
	}
	
	public LocalDateTime getFechaYHora() {
		return fechaYHora;
	}
	
	
	
}
