DELIMITER $$

CREATE PROCEDURE transferirFondos(
    IN p_cuenta_origen INT,
    IN p_cuenta_destino INT,
    IN p_monto DECIMAL(15,2),
    OUT p_resultado VARCHAR(100)
)
BEGIN
    DECLARE saldo_actual DECIMAL(15,2);
    DECLARE id_cliente_origen INT;
    DECLARE id_tipo_cliente INT;
    DECLARE porcentaje_comision DECIMAL(5,2);
    DECLARE comision DECIMAL(15,2);

    -- Verificar saldo de la cuenta origen
    SELECT saldo, id_cliente INTO saldo_actual, id_cliente_origen
    FROM cuenta_bancaria
    WHERE id_cuenta = p_cuenta_origen;

    IF saldo_actual < p_monto THEN
        SET p_resultado = 'Saldo insuficiente';
    ELSE
        -- Obtener tipo de cliente y porcentaje de comisión
        SELECT id_tipo_cliente INTO id_tipo_cliente
        FROM cliente
        WHERE id_cliente = id_cliente_origen;

        SELECT porcentaje_comision INTO porcentaje_comision
        FROM tipo_cliente
        WHERE id_tipo_cliente = id_tipo_cliente;

        -- Calcular comisión si el monto supera 5,000,000
        IF p_monto > 5000000 THEN
            SET comision = (p_monto * porcentaje_comision) / 100;
        ELSE
            SET comision = 0.00;
        END IF;

        -- Actualizar saldo de la cuenta origen
        UPDATE cuenta_bancaria
        SET saldo = saldo - (p_monto + comision)
        WHERE id_cuenta = p_cuenta_origen;

        -- Actualizar saldo de la cuenta destino
        UPDATE cuenta_bancaria
        SET saldo = saldo + p_monto
        WHERE id_cuenta = p_cuenta_destino;

        -- Registrar transacción
        INSERT INTO transaccion (tipo, cuenta_asociada, cuenta_destino, monto, comision)
        VALUES ('Transferencia', p_cuenta_origen, p_cuenta_destino, p_monto, comision);

        SET p_resultado = 'Transferencia realizada exitosamente';
    END IF;
END$$

DELIMITER ;
