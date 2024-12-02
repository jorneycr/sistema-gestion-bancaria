DELIMITER $$

CREATE PROCEDURE obtenerHistorial(
    IN p_cuenta INT,
    IN p_fecha_inicio DATETIME,
    IN p_fecha_fin DATETIME
)
BEGIN
    -- Consultar historial con rango de fechas opcional
    IF p_fecha_inicio IS NULL AND p_fecha_fin IS NULL THEN
        SELECT * FROM transaccion
        WHERE cuenta_asociada = p_cuenta;
    ELSE
        SELECT * FROM transaccion
        WHERE cuenta_asociada = p_cuenta
        AND fecha BETWEEN COALESCE(p_fecha_inicio, '1900-01-01') AND COALESCE(p_fecha_fin, NOW());
    END IF;
END$$

DELIMITER ;
