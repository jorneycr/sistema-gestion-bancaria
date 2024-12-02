DELIMITER $$

CREATE PROCEDURE depositarFondos(
    IN p_cuenta INT,
    IN p_monto DECIMAL(15,2),
    OUT p_resultado VARCHAR(100)
)
BEGIN
    IF p_monto <= 0 THEN
        SET p_resultado = 'El monto debe ser mayor a 0';
    ELSE
        -- Actualizar saldo
        UPDATE cuenta_bancaria
        SET saldo = saldo + p_monto
        WHERE id_cuenta = p_cuenta;

        -- Registrar transacción
        INSERT INTO transaccion (tipo, cuenta_asociada, monto)
        VALUES ('Deposito', p_cuenta, p_monto);

        SET p_resultado = 'Depósito realizado exitosamente';
    END IF;
END$$

DELIMITER ;
