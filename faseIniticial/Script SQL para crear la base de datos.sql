CREATE DATABASE gestion_bancaria;

USE gestion_bancaria;

-- Tabla Cliente
CREATE TABLE cliente (
    id_cliente INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    numero_identificacion VARCHAR(50) UNIQUE NOT NULL,
    detalles_contacto VARCHAR(255)
);

-- Tabla Cuenta Bancaria
CREATE TABLE cuenta_bancaria (
    id_cuenta INT AUTO_INCREMENT PRIMARY KEY,
    id_cliente INT NOT NULL,
    numero_cuenta VARCHAR(50) UNIQUE NOT NULL,
    tipo_cuenta ENUM('Ahorro', 'Corriente') NOT NULL,
    saldo DECIMAL(15, 2) DEFAULT 0.00,
    FOREIGN KEY (id_cliente) REFERENCES cliente(id_cliente)
);

-- Tabla Transacción
CREATE TABLE transaccion (
    id_transaccion INT AUTO_INCREMENT PRIMARY KEY,
    tipo ENUM('Deposito', 'Retiro', 'Transferencia') NOT NULL,
    id_cuenta_origen INT NULL,
    id_cuenta_destino INT NULL,
    monto DECIMAL(15, 2) NOT NULL,
    fecha DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (id_cuenta_origen) REFERENCES cuenta_bancaria(id_cuenta),
    FOREIGN KEY (id_cuenta_destino) REFERENCES cuenta_bancaria(id_cuenta)
);
