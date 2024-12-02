
# Paso 1: Crear la tabla tipo_cliente
CREATE TABLE tipo_cliente (
    id_tipo_cliente INT AUTO_INCREMENT PRIMARY KEY,
    tipo VARCHAR(10) UNIQUE NOT NULL,
    porcentaje_comision DECIMAL(5, 2) NOT NULL CHECK (porcentaje_comision >= 0)
);

# Paso 2: Insertar datos iniciales en tipo_cliente
INSERT INTO tipo_cliente (tipo, porcentaje_comision)
VALUES 
    ('A', 10.00),
    ('B', 12.00),
    ('C', 15.00);
    
# Paso 3: Modificar la tabla cliente para agregar id_tipo_cliente
ALTER TABLE cliente 
ADD COLUMN id_tipo_cliente INT NOT NULL,
ADD FOREIGN KEY (id_tipo_cliente) REFERENCES tipo_cliente(id_tipo_cliente);


# Paso 4: Modificar la tabla transaccion para agregar comision
ALTER TABLE transaccion 
ADD COLUMN comision DECIMAL(15, 2) DEFAULT 0.00;



