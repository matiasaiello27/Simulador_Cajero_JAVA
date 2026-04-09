# Simulador_Cajero_JAVA

Proyecto desarrollado en Java que simula la operativa de un cajero automático real y la gestión interna de un banco. Diseñado como práctica integradora para consolidar conceptos avanzados de Programación Orientada a Objetos (POO).

## 🚀 Tecnologías y Conceptos Aplicados

- **Lenguaje:** Java (JDK 17+)
- **Paradigma:** Programación Orientada a Objetos (POO)
- **Conceptos Destacados:**
  - **Herencia y Polimorfismo:** Uso de clases abstractas (Cuenta) y clases hijas (CuentaAhorro, CuentaCorriente).
  - **Manejo de Excepciones:** Creación de excepciones personalizadas (SaldoInsuficienteException, LimiteExcedidoException, etc.) para una gestión de errores robusta.
  - **Colecciones:** Uso de `ArrayList` para la gestión dinámica de clientes, cuentas y el historial de movimientos.
  - **API de Fechas:** Implementación de `LocalDateTime` y `DateTimeFormatter` para el registro preciso de las transacciones.
  - **Interacción por Consola:** Menú interactivo con gestión de flujo de sesiones continuas (Login/Logout simulado).

## ⚙️ Funcionalidades Principales

1. **Autenticación Simulada:** Acceso mediante validación de IBAN en la base de datos del banco.
2. **Operativa Básica:** Ingresos y retiradas de efectivo con validación de saldos y límites diarios.
3. **Transferencias:** Movimiento de fondos entre cuentas del mismo banco con registro cruzado en los historiales de ambos usuarios.
4. **Historial Detallado:** Registro temporal de cada transacción generada, con fecha, hora y concepto exacto.
5. **Tipos de Cuentas:** - *Cuenta de Ahorro:* Incluye lógica de aplicación de intereses.
   - *Cuenta Corriente:* Incluye lógica de cobro de comisiones de mantenimiento.

## 👨‍💻 Autor

**Matias Aiello**
Estudiante de Desarrollo de Aplicaciones Multiplataforma (DAM) en busca de oportunidades para realizar la FCT (Prácticas).
- []
