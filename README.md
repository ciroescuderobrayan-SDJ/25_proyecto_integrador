# 💸 Proyecto: Gestión de Finanzas Personales (Java)

Este proyecto reúne **cinco ejercicios prácticos** relacionados con la gestión de finanzas personales.  
Cada ejercicio está desarrollado en Java e implementado mediante **métodos independientes**, llamados desde un **menú principal**.

El objetivo del proyecto es aplicar los conceptos fundamentales del curso de Lógica de Programación usando:

- Scanner  
- Variables y operadores  
- Condicionales (`if`, `else if`, `switch`)  
- Bucles (`for`, `while`, `do-while`)  
- Constantes  
- Arrays / ArrayList  
- Métodos  
- Manejo básico de clases (POJO)

---

## 📚 Contenidos del proyecto

El proyecto contiene los siguientes ejercicios:

### **1️⃣ Ejercicio 1 – Calcular presupuesto mensual y saldo restante**
Permite ingresar ingresos y gastos, calcula el saldo restante y evalúa la salud financiera del usuario.

### **2️⃣ Ejercicio 2 – Simulación de intereses (ahorro o crédito)**
Simula el crecimiento de una cuenta de ahorro o el aumento de una deuda aplicando una tasa de interés mensual por varios meses.

### **3️⃣ Ejercicio 3 – Registro de transacciones con ArrayList**
Permite registrar ingresos y gastos en una lista, mostrando posteriormente un reporte tabular y el saldo final.

### **4️⃣ Ejercicio 4 – Clasificación de gastos por categorías**
Registra gastos y los clasifica en categorías como alimentación, transporte, ocio y servicios.  
Al final muestra el total por cada categoría.

### **5️⃣ Ejercicio 5 – Sistema de alertas por límite de gasto**
El usuario define un límite mensual y el sistema genera alertas cuando se acerca o supera ese límite.

---

## 🧱 Estructura del programa

El programa está contenido en un solo archivo Java:

FinanzasPersonalesApp.java


Contiene:

- Un **menú principal**
- **5 métodos** (uno por cada ejercicio)
- Un **Scanner global**
- La clase interna `Transaccion` para el ejercicio 3

---

## ▶️ ¿Cómo ejecutar el proyecto?

1. Instalar **Java JDK** (versión 17 o superior).
2. Abrir el proyecto en VS Code, IntelliJ o un editor similar.
3. Compilar el programa:

```bash
javac FinanzasPersonalesApp.java
