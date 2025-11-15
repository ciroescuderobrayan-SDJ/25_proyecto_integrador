package com.example;

import java.util.ArrayList;
import java.util.Scanner;

public class FinanzasPersonalesApp {

    // Scanner global para que todos los métodos lo usen
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;

        do {
            System.out.println("\n===== MENÚ PRINCIPAL - GESTIÓN DE FINANZAS PERSONALES =====");
            System.out.println("1. Calcular presupuesto mensual y saldo restante");
            System.out.println("2. Simular intereses de ahorro o crédito");
            System.out.println("3. Registrar transacciones y mostrar reporte");
            System.out.println("4. Clasificar gastos por categoría");
            System.out.println("5. Generar alertas por límite de gasto mensual");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    ejercicio1Presupuesto();
                    break;
                case 2:
                    ejercicio2Intereses();
                    break;
                case 3:
                    ejercicio3Transacciones();
                    break;
                case 4:
                    ejercicio4ClasificarGastos();
                    break;
                case 5:
                    ejercicio5Alertas();
                    break;
                case 0:
                    System.out.println("\nSaliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }

        } while (opcion != 0);

        sc.close();
    }

    // =========================================================
    // EJERCICIO 1: PRESUPUESTO MENSUAL
    // =========================================================
    static void ejercicio1Presupuesto() {
        System.out.println("\n=== EJERCICIO 1: PRESUPUESTO MENSUAL ===");

        System.out.print("Ingrese su ingreso mensual: ");
        double ingresoMensual = sc.nextDouble();

        System.out.print("¿Cuántos tipos de gastos desea registrar? ");
        int cantidadGastos = sc.nextInt();

        double totalGastos = 0;

        for (int i = 1; i <= cantidadGastos; i++) {
            System.out.print("Valor del gasto " + i + ": ");
            double gasto = sc.nextDouble();
            totalGastos += gasto;
        }

        double saldo = ingresoMensual - totalGastos;

        System.out.println("\n=== RESUMEN MENSUAL ===");
        System.out.println("Ingreso mensual: " + ingresoMensual);
        System.out.println("Total gastos: " + totalGastos);
        System.out.println("Saldo restante: " + saldo);

        double porcentaje = (saldo / ingresoMensual) * 100;

        if (saldo < 0) {
            System.out.println("⚠ Atención: está gastando más de lo que gana.");
        } else if (porcentaje < 10) {
            System.out.println("😬 Su saldo es muy ajustado.");
        } else {
            System.out.println("✅ ¡Finanzas saludables! Buen trabajo.");
        }
    }

    // =========================================================
    // EJERCICIO 2: SIMULADOR DE INTERESES
    // =========================================================
    static void ejercicio2Intereses() {
        System.out.println("\n=== EJERCICIO 2: SIMULACIÓN DE INTERESES ===");

        System.out.println("Seleccione tipo de simulación:");
        System.out.println("1. Ahorro");
        System.out.println("2. Crédito");
        int opcion = sc.nextInt();

        System.out.print("Monto inicial: ");
        double saldo = sc.nextDouble();

        System.out.print("Tasa de interés mensual (%): ");
        double tasa = sc.nextDouble() / 100;

        System.out.print("Número de meses a simular: ");
        int meses = sc.nextInt();

        System.out.println("\n--- RESULTADOS ---");

        for (int mes = 1; mes <= meses; mes++) {
            double interes = saldo * tasa;
            saldo += interes;
            System.out.printf("Mes %d → Interés: %.2f | Saldo: %.2f%n", mes, interes, saldo);
        }

        if (opcion == 1) {
            System.out.println("\nSaldo final en cuenta de ahorro: " + saldo);
        } else {
            System.out.println("\nTotal de deuda después de " + meses + " meses: " + saldo);
        }
    }

    // =========================================================
    // EJERCICIO 3: REGISTRO DE TRANSACCIONES
    // =========================================================

    static class Transaccion {
        String tipo; 
        String descripcion;
        double monto;

        Transaccion(String tipo, String descripcion, double monto) {
            this.tipo = tipo;
            this.descripcion = descripcion;
            this.monto = monto;
        }
    }

    static void ejercicio3Transacciones() {
        System.out.println("\n=== EJERCICIO 3: REGISTRO DE TRANSACCIONES ===");

        ArrayList<Transaccion> lista = new ArrayList<>();
        String continuar;

        do {
            System.out.println("\nNueva transacción");
            System.out.print("Tipo (1 = Ingreso, 2 = Gasto): ");
            int tipoNum = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            String tipo = (tipoNum == 1) ? "Ingreso" : "Gasto";

            System.out.print("Descripción: ");
            String descripcion = sc.nextLine();

            System.out.print("Monto: ");
            double monto = sc.nextDouble();

            lista.add(new Transaccion(tipo, descripcion, monto));

            System.out.print("¿Registrar otra transacción? (s/n): ");
            continuar = sc.next();
        } while (continuar.equalsIgnoreCase("s"));

        System.out.println("\n=== REPORTE DE TRANSACCIONES ===");
        System.out.printf("%-10s %-20s %10s%n", "TIPO", "DESCRIPCIÓN", "MONTO");

        double saldoFinal = 0;

        for (Transaccion t : lista) {
            System.out.printf("%-10s %-20s %10.2f%n", t.tipo, t.descripcion, t.monto);

            if (t.tipo.equals("Ingreso")) {
                saldoFinal += t.monto;
            } else {
                saldoFinal -= t.monto;
            }
        }

        System.out.println("\nSaldo final: " + saldoFinal);
    }

    // =========================================================
    // EJERCICIO 4: CLASIFICAR GASTOS
    // =========================================================
    static void ejercicio4ClasificarGastos() {
        System.out.println("\n=== EJERCICIO 4: CLASIFICACIÓN DE GASTOS ===");

        double alim = 0, trans = 0, ocio = 0, serv = 0;

        System.out.print("¿Cuántos gastos desea registrar? ");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            System.out.print("\nMonto del gasto " + i + ": ");
            double monto = sc.nextDouble();

            System.out.println("Categoría:");
            System.out.println("1. Alimentación");
            System.out.println("2. Transporte");
            System.out.println("3. Ocio");
            System.out.println("4. Servicios");
            System.out.print("Seleccione categoría: ");
            int cat = sc.nextInt();

            switch (cat) {
                case 1: alim += monto; break;
                case 2: trans += monto; break;
                case 3: ocio += monto; break;
                case 4: serv += monto; break;
                default: System.out.println("Categoría inválida.");
            }
        }

        double total = alim + trans + ocio + serv;

        System.out.println("\n=== RESUMEN DE GASTOS ===");
        System.out.println("Alimentación: " + alim);
        System.out.println("Transporte:   " + trans);
        System.out.println("Ocio:         " + ocio);
        System.out.println("Servicios:    " + serv);
        System.out.println("--------------------------");
        System.out.println("TOTAL GASTOS: " + total);
    }

    // =========================================================
    // EJERCICIO 5: ALERTAS DE LÍMITE DE GASTO
    // =========================================================
    static void ejercicio5Alertas() {
        System.out.println("\n=== EJERCICIO 5: ALERTAS DE GASTO ===");

        System.out.print("Ingrese su límite de gasto mensual: ");
        double limite = sc.nextDouble();

        double total = 0;
        String continuar;

        do {
            System.out.print("\nNuevo gasto: ");
            double gasto = sc.nextDouble();
            total += gasto;

            double porcentaje = (total / limite) * 100;

            System.out.printf("Total gastado: %.2f (%.2f%% del límite)%n", total, porcentaje);

            if (porcentaje > 100) {
                System.out.println("🚨 ALERTA: Ha superado su límite mensual.");
            } else if (porcentaje >= 80) {
                System.out.println("⚠ Advertencia: Está cerca de alcanzar su límite.");
            } else {
                System.out.println("✔ Aún está dentro del límite.");
            }

            System.out.print("¿Registrar otro gasto? (s/n): ");
            continuar = sc.next();

        } while (continuar.equalsIgnoreCase("s"));

        System.out.println("\nGasto total del mes: " + total);
    }
}
