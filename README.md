# 🧩 Sistema de Gestión Bancaria - Microservicios Spring Boot

Este repositorio tiene la prueba tecnica para la bacante de desarrollador springboot

ARQUITECTURA- MICROSERVICIOS

- `cliente-persona-service`: Gestiona información de personas y clientes.
- `cuenta-movimiento-service`: Gestiona cuentas bancarias y movimientos asociados.

También se incluye un script `BaseDatos.sql` para la creación inicial de las tablas y secuencias necesarias en PostgreSQL.

---

## 📁 Estructura del Proyecto
/ (raíz del repositorio)
│
├── cliente-persona-service/ # Microservicio para gestión de clientes y personas
│
├── cuenta-movimiento-service/ # Microservicio para gestión de cuentas y movimientos
│
├── BaseDatos.sql # Script SQL para crear tablas y secuencias
│
└── README.md # Este archivo

## 🏗️ Configuración de la Base de Datos en PostgreSQL

### 1. Crear la base de datos

Abre tu terminal, consola SQL o pgAdmin y ejecuta:

```sql
CREATE DATABASE info_cliente;
```

### 2. Ejecuta el SCRIPT BaseDatos.sql
Conectate a la base de datos 
### 3. Ejecuta el microservicio cliente-persona-service
### 3. Ejecuta el microservicio cuenta-movimiento-service
### 4. Ejecuta el SCRIPT BaseDatos.sql