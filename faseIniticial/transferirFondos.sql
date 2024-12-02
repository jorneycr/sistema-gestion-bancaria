DELIMITER $$

CREATE PROCEDURE transferirFondos(
    IN p_cuenta_origen INT,
    IN p_cuenta_destino INT,
    IN p_monto DECIMAL(15,2),
    OUT p_resultado VARCHAR(100)
)
BEGIN
    DECLARE saldo_actual DECIMAL(15,2);

    -- Verificar saldo de la cuenta origen
    SELECT saldo INTO saldo_actual
    FROM cuenta_bancaria
    WHERE id_cuenta = p_cuenta_origen;

    IF saldo_actual < p_monto THEN
        SET p_resultado = 'Saldo insuficiente';
    ELSE
        -- Actualizar saldo de la cuenta origen
        UPDATE cuenta_bancaria
        SET saldo = saldo - p_monto
        WHERE id_cuenta = p_cuenta_origen;

        -- Actualizar saldo de la cuenta destino
        UPDATE cuenta_bancaria
        SET saldo = saldo + p_monto
        WHERE id_cuenta = p_cuenta_destino;

        -- Registrar transacción
        INSERT INTO transaccion (tipo, cuenta_asociada, cuenta_destino, monto)
        VALUES ('Transferencia', p_cuenta_origen, p_cuenta_destino, p_monto);

        SET p_resultado = 'Transferencia realizada exitosamente';
    END IF;
END$$

DELIMITER ;
